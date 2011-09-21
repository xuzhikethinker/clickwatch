package de.hub.clickwatch.apps.god.test;

import static org.junit.Assert.*;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.hub.clickwatch.apps.god.Server;
import de.hub.clickwatch.apps.god.node.FlowInfoProcessor;
import de.hub.clickwatch.apps.god.information.FlowInformation;

public class FlowTests {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Server.startServer(false, false, null);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException intExc) {
			//nothing
		}
	}

	@Before
	public void setUp() throws Exception {
		Server.getInstance().startSzenario();
	}

	@After
	public void tearDown() throws Exception {
		Server.getInstance().stopSzenario();
	}
	
	private void addNodesToSzenario(String[][] usableMacIps) {
		for (int k = 0; k < usableMacIps.length; k++) {
			String[][] aps = Server.getSzenario().get_ACCESS_POINTS();
			
			boolean alreadyIn = false;
			for (int m = 0; m < aps.length; m++) {
				if (aps[m][0].equals(usableMacIps[k][1])) {
					alreadyIn = true;
					break;
				}
			}
			
			if (!alreadyIn) {
				System.out.println("\tINFO: adding node " + usableMacIps[k][1] + ":7777 " + usableMacIps[k][2] + " to szenario");
				try {
					Server.getInstance().addNode(usableMacIps[k][1], "7777", usableMacIps[k][2]);
				} catch (UnknownHostException uExc) {
					System.err.println("UnknownHostException: " + uExc.getMessage());
					System.exit(-1);
				}
			}
		}
	}
	
	@Test
	//@Ignore
	public void initialFlowFunctionalityTest() {
		String[][] usableMacIps = new String[][] {
			{"06-0B-6B-09-ED-73", "192.168.3.110", "sk110"},
			{"06-0B-6B-09-F2-94", "192.168.3.111", "sk111"},
			{"06-0C-42-0C-74-0D", "192.168.3.112", "sk112"}
		};
		
		Map<String, String> apResetList = new HashMap<String, String>();
		for (String[] ap : usableMacIps) {
			apResetList.put(ap[0], ap[1]);
		}
		
		addNodesToSzenario(usableMacIps);
		FlowWrapper.resetFlows(apResetList, true, true);
		
		try {
			System.out.print("testing flow functionality ... ");
			Server.getInstance().handleSetter(usableMacIps[0][1], 7777, "sf", "add_flow", usableMacIps[0][0] + " " + usableMacIps[1][0] + " 300 100 0 100 true");
			Thread.sleep(1*1000);
			Server.getInstance().handleSetter(usableMacIps[0][1], 7777, "sf", "add_flow", usableMacIps[0][0] + " " + usableMacIps[1][0] + " 300 100 0 100 false");
			
			Server.getInstance().handleSetter(usableMacIps[0][1], 7777, "sf", "add_flow", usableMacIps[0][0] + " " + usableMacIps[2][0] + " 300 100 0 100 true");
			Thread.sleep(1*1000);
			Server.getInstance().handleSetter(usableMacIps[0][1], 7777, "sf", "add_flow", usableMacIps[0][0] + " " + usableMacIps[2][0] + " 300 100 0 100 false");
			System.out.println("done");
			
			Server.getInstance().updateInfosFromNodes();
		} catch (InterruptedException int_exc) {
			//nothing to do
		}
		
		FlowInformation f0 = (FlowInformation)Server.getInstance().getStorageManager().getClientInformations(usableMacIps[0][0]).get(FlowInfoProcessor.class.getName());
		FlowInformation f1 = (FlowInformation)Server.getInstance().getStorageManager().getClientInformations(usableMacIps[1][0]).get(FlowInfoProcessor.class.getName());
		FlowInformation f2 = (FlowInformation)Server.getInstance().getStorageManager().getClientInformations(usableMacIps[2][0]).get(FlowInfoProcessor.class.getName());
		
		assertEquals(2, f0.getTxflows().size());
		assertEquals(1, f1.getRxflows().size());
		assertEquals(1, f2.getRxflows().size());
	}
	
	@Test
	public void multiHopFunctionalityTest() {
		String[][] usableMacIps = new String[][] {
			{"06-0F-B5-3F-22-E9", "192.168.3.34", "wgt34"},
			{"06-0F-B5-3F-21-3C", "192.168.3.24", "wgt24"},
			{"06-0F-B5-97-33-6C", "192.168.3.31", "wgt31"},
			{"06-0F-B5-97-34-BC", "192.168.3.73", "wgt73"},
			{"06-0F-B5-3F-58-49", "192.168.3.45", "wgt45"}
		};
		Map<String, String> apResetList = new HashMap<String, String>();
		for (String[] ap : usableMacIps) {
			apResetList.put(ap[0], ap[1]);
		}
		
		addNodesToSzenario(usableMacIps);
		FlowWrapper.resetFlows(apResetList, true, true);
		
		try {
			System.out.print("testing multihop flow ... ");
			Server.getInstance().handleSetter(usableMacIps[0][1], 7777, "sf", "add_flow", usableMacIps[0][0] + " " + usableMacIps[4][0] + " 300 100 2 100 true");
			Thread.sleep(1*1000);
			Server.getInstance().handleSetter(usableMacIps[0][1], 7777, "sf", "add_flow", usableMacIps[0][0] + " " + usableMacIps[4][0] + " 300 100 2 100 false");
			
			System.out.println("done");
			
			Server.getInstance().updateInfosFromNodes();
		} catch (InterruptedException int_exc) {
			//nothing to do
		}
		
		FlowInformation f0 = (FlowInformation)Server.getInstance().getStorageManager().getClientInformations(usableMacIps[0][0]).get(FlowInfoProcessor.class.getName());
		FlowInformation f4 = (FlowInformation)Server.getInstance().getStorageManager().getClientInformations(usableMacIps[4][0]).get(FlowInfoProcessor.class.getName());
		
		assertEquals(1, f0.getTxflows().size());
		assertEquals(1, f4.getRxflows().size());
		assertTrue(f4.getRxflows().get(0).getAvgHops() > 1);
	}
}