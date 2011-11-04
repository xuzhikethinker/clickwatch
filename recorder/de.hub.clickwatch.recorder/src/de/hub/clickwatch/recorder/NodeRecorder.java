package de.hub.clickwatch.recorder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.math.stat.descriptive.SummaryStatistics;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.hub.clickwatch.connection.INodeConnection;
import de.hub.clickwatch.connection.INodeConnectionProvider;
import de.hub.clickwatch.connection.adapter.IMetaDataAdapter;
import de.hub.clickwatch.connection.adapter.IPullHandlerAdapter;
import de.hub.clickwatch.connection.adapter.internal.SocketStatisticsAdapter;
import de.hub.clickwatch.connection.adapter.values.IValueAdapter;
import de.hub.clickwatch.model.Handler;
import de.hub.clickwatch.model.Network;
import de.hub.clickwatch.model.Node;
import de.hub.clickwatch.recorder.database.cwdatabase.RecordStatistics;
import de.hub.clickwatch.util.ILogger;
import de.hub.clickwatch.util.NanoClock;
import de.hub.clickwatch.util.Throwables;

public class NodeRecorder implements Runnable {
	
	private static final Pattern pattern = Pattern.compile(".*real=\"(\\d+\\.\\d+)\".*");
	
	private NetworkRecorder parent;
	private Node configuration;

	public void setup(NetworkRecorder parent, Node configuration) {
		this.parent = parent;
		this.configuration = configuration;
	}

	private Node metaData;
	private Map<String, Handler> keyMap = new HashMap<String, Handler>();
	private Object nodeDBAdapter = null;
	
	private INodeConnection connection = null;
	private IPullHandlerAdapter handlerAdapter = null;
	private SocketStatisticsAdapter socketStatisticsAdapter = null;
	private long updateInterval = -1;
	private boolean isRecording = true;
	private int samples = 0;
	
	@Inject private NanoClock clock;
	@Inject private ILogger logger;
	@Inject private INodeConnectionProvider ncp;
	
	@Inject @Named(ClickWatchRecorderModule.L_DEFAULT_UPDATE_INTERVAL_PROPERTY) private long defaultUpdateInterval;
	@Inject @Named(ClickWatchRecorderModule.B_RECORD_CHANGES_ONLY_PROPERTY) private boolean recordChangesOnly;
	@Inject private IValueAdapter valueAdapter;
	
	private List<Double> handlerPulledSValues = new ArrayList<Double>();
	private List<Double> timeSValues = new ArrayList<Double>();
	private List<Double> bytesRequestSValues = new ArrayList<Double>();
	private List<Double> timeRequestSValues = new ArrayList<Double>();
	private List<Double> cpuLoadSValues = new ArrayList<Double>();

	private void initializeRecorder() {
		logger.log(ILogger.DEBUG, "started recording of " + configuration.getINetAddress(), null);
		
		if (connection == null) {
			connection = ncp.createSimpleConnection(configuration);
		}
		connection.connect();
		
		metaData = connection.getAdapter(IMetaDataAdapter.class).pullAllMetaData();
		Network network = (Network)configuration.eContainer();
		if (network != null) {
			metaData.filter(network.getElementFilter(), network.getHandlerFilter());
		}
		updateInterval = network.getUpdateIntervall();
		if (updateInterval < 0) {
			updateInterval = defaultUpdateInterval;
		}
		
		logger.log(ILogger.DEBUG, "Recordeing " + connection + " with local update interval of " + updateInterval, null);
		
		metaData.setINetAddress(configuration.getINetAddress());
		nodeDBAdapter = parent.getDataBaseAdapter().addNode(metaData);
		logger.log(ILogger.DEBUG, "pulled meta-data for " + configuration.getINetAddress(), null);
		
		handlerAdapter = connection.getAdapter(IPullHandlerAdapter.class);
		EList<Handler> allHandlers = metaData.getAllHandlers();
		List<Handler> filteredHandlers = filterHandler(allHandlers);
		
		// if configuration has elements and handlers, only use those that are present
		EList<Handler> configuredHandlers = configuration.getAllHandlers();
		if (!configuredHandlers.isEmpty()) {
			Map<String, Handler> filteredHandlersNameMap = new HashMap<String, Handler>();
			for (Handler handler: filteredHandlers) {
				filteredHandlersNameMap.put(handler.getQualifiedName(), handler);
			}
			filteredHandlers.clear();
			for (Handler handler: configuredHandlers) {
				Handler filteredHandler = filteredHandlersNameMap.get(handler.getQualifiedName());
				if (filteredHandler != null) {
					filteredHandlers.add(filteredHandler);
				}
			}
		}
		
		handlerAdapter.configure(filteredHandlers);
		
		socketStatisticsAdapter = connection.getAdapter(SocketStatisticsAdapter.class);
		if (socketStatisticsAdapter != null) {
			socketStatisticsAdapter.activateSocketStatistics();
		}
	}
	
	protected List<Handler> filterHandler(EList<Handler> allHandlers) {
		return allHandlers;
	}
	
	private void recover() {
		try {
			EcoreUtil.delete(metaData);
			connection.disconnect();
		} catch (Exception e) {
			logger.log(ILogger.ERROR, "could not disconnect during recovery", e);
		} finally {
			initializeRecorder();
		}
	}
	
	private int pullAndRecordHandler() {
		long start = clock.currentTimeNanos();
		int recordedHandler = 0;
		Collection<Handler> handlersPulled = handlerAdapter.pullHandler();
		for(Handler handler: handlersPulled) {			
			String qualifiedName = handler.getQualifiedName();
			Handler key = keyMap.get(qualifiedName);
			boolean hasChanged = key == null || !(valueAdapter.valuesEquals(key, handler)); 
			keyMap.put(qualifiedName, handler);
			
			if (qualifiedName.equals("sys_info/systeminfo")) {
				String value = valueAdapter.getPlainValue(handler);
				Matcher matcher = pattern.matcher(value.replace("\n", " "));
				if (matcher.matches()) {
					Double cpuLoad = new Double(matcher.group(1));
					cpuLoadSValues.add(cpuLoad);
				}
			}
			
			if (parent.getDataBaseAdapter().record(nodeDBAdapter, handler, !recordChangesOnly || hasChanged, samples)) {
				parent.reportHandlerRecorded(configuration, handler);
				recordedHandler++;
			}
		}
		
		handlerPulledSValues.add((double)handlersPulled.size());		
		timeSValues.add((double)clock.currentTimeNanos() - start);
		if (socketStatisticsAdapter != null) {
			bytesRequestSValues.add(socketStatisticsAdapter.getSocketStatistics().getBytesRequest());
			timeRequestSValues.add(socketStatisticsAdapter.getSocketStatistics().getTimeRequest());
			socketStatisticsAdapter.resetSocketStatistics();
		}
		
		return recordedHandler;
	}
	
	@Override
	public void run() {
		initializeRecorder();
		parent.reportInitialized();

		int recordedHandlerN = 0;
		long start = clock.currentTimeNanos();
		
		boolean isRecovering = false;
		int recoveringTries = 0;
		loop: while(isRecording) {
			if (isRecovering && recoveringTries < 5) {
				try {
					recover();
				} catch(Exception e) {
					logger.log(ILogger.ERROR, "could not recover for the " + ++recoveringTries + "th time for node " 
							+ configuration.getINetAddress(), e);
				}
				if (recoveringTries == 5) {
					logger.log(ILogger.ERROR, "could not recover, tried 5 times, give up on node " 
							+ configuration.getINetAddress(), null);
					break loop;
				}
			}
			int recordedHandlerS = 0;
			try {
				recordedHandlerS = pullAndRecordHandler();
			} catch (Exception e) {
				logger.log(ILogger.ERROR, "exception during pulling handlers in node " 
						+ configuration.getINetAddress() 
						+ ", I try to revover.", e);
				try {
					recover();
				} catch (Exception ee) {
					logger.log(ILogger.ERROR, "could not recover immediatly for node " 
							+ configuration.getINetAddress()
							+ ", I will retry for 5 times with update interval in between", ee);	
					isRecovering = true;
				}
			}
			
			if (samples % 100 == 0) {
				logger.log(ILogger.DEBUG, "Recording " + samples + "th sample for " 
						+ configuration.getINetAddress(), null);
				saveStatistics();
			}

			recordedHandlerN += recordedHandlerS;
			samples++;
			
			waitForUpdateInterval();
		}

		parent.getDataBaseAdapter().close(nodeDBAdapter);
		
		RecordStatistics stats = parent.getStatistics();
		stats.getHandlersN().addValue(recordedHandlerN);
		stats.getSamplesN().addValue(samples);
		stats.getTimeN().addValue(clock.currentTimeNanos() - start);
		
		saveStatistics();
		
		parent.getDataBaseAdapter().close(nodeDBAdapter);
		handlerAdapter.deconfigure();
		parent.reportStopped();
	}
	
	private void saveStatistics() {
		RecordStatistics stats = parent.getStatistics();
		addAll(stats.getHandlersPulledS(), handlerPulledSValues);
		addAll(stats.getTimeS(), timeSValues);
		addAll(stats.getBytesRequestS(), bytesRequestSValues);
		addAll(stats.getTimeRequestS(), timeRequestSValues);
		addAll(stats.getCpuLoadS(), cpuLoadSValues);
	}
	
	private void addAll(SummaryStatistics stat, Collection<Double> values) {
		for(Double d: values) {
			stat.addValue(d);
		}
		values.clear();
	}
	
	public synchronized void waitForUpdateInterval() {
		if (updateInterval > 0) {
			try {
				wait(updateInterval); // wait for being stopped
			} catch(InterruptedException e) {
				Throwables.propagate(e);
			}
		}
	}
	
	public synchronized void stop() {
		isRecording = false;
		notify(); // notify the potentially waiting node recorder
	}
}
