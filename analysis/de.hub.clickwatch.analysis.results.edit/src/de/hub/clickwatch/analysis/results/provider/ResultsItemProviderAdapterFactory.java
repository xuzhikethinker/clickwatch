/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.clickwatch.analysis.results.provider;

import de.hub.clickwatch.analysis.results.util.ResultsAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ResultsItemProviderAdapterFactory extends ResultsAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hub.clickwatch.analysis.results.DataSet} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataSetItemProvider dataSetItemProvider;

	/**
	 * This creates an adapter for a {@link de.hub.clickwatch.analysis.results.DataSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataSetAdapter() {
		if (dataSetItemProvider == null) {
			dataSetItemProvider = new DataSetItemProvider(this);
		}

		return dataSetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hub.clickwatch.analysis.results.DataEntry} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataEntryItemProvider dataEntryItemProvider;

	/**
	 * This creates an adapter for a {@link de.hub.clickwatch.analysis.results.DataEntry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataEntryAdapter() {
		if (dataEntryItemProvider == null) {
			dataEntryItemProvider = new DataEntryItemProvider(this);
		}

		return dataEntryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hub.clickwatch.analysis.results.Chart} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChartItemProvider chartItemProvider;

	/**
	 * This creates an adapter for a {@link de.hub.clickwatch.analysis.results.Chart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createChartAdapter() {
		if (chartItemProvider == null) {
			chartItemProvider = new ChartItemProvider(this);
		}

		return chartItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hub.clickwatch.analysis.results.ChartType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChartTypeItemProvider chartTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.hub.clickwatch.analysis.results.ChartType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createChartTypeAdapter() {
		if (chartTypeItemProvider == null) {
			chartTypeItemProvider = new ChartTypeItemProvider(this);
		}

		return chartTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hub.clickwatch.analysis.results.Axis} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AxisItemProvider axisItemProvider;

	/**
	 * This creates an adapter for a {@link de.hub.clickwatch.analysis.results.Axis}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAxisAdapter() {
		if (axisItemProvider == null) {
			axisItemProvider = new AxisItemProvider(this);
		}

		return axisItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hub.clickwatch.analysis.results.Series} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SeriesItemProvider seriesItemProvider;

	/**
	 * This creates an adapter for a {@link de.hub.clickwatch.analysis.results.Series}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSeriesAdapter() {
		if (seriesItemProvider == null) {
			seriesItemProvider = new SeriesItemProvider(this);
		}

		return seriesItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hub.clickwatch.analysis.results.Category} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CategoryItemProvider categoryItemProvider;

	/**
	 * This creates an adapter for a {@link de.hub.clickwatch.analysis.results.Category}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCategoryAdapter() {
		if (categoryItemProvider == null) {
			categoryItemProvider = new CategoryItemProvider(this);
		}

		return categoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hub.clickwatch.analysis.results.Result} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultItemProvider resultItemProvider;

	/**
	 * This creates an adapter for a {@link de.hub.clickwatch.analysis.results.Result}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createResultAdapter() {
		if (resultItemProvider == null) {
			resultItemProvider = new ResultItemProvider(this);
		}

		return resultItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hub.clickwatch.analysis.results.XY} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XYItemProvider xyItemProvider;

	/**
	 * This creates an adapter for a {@link de.hub.clickwatch.analysis.results.XY}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createXYAdapter() {
		if (xyItemProvider == null) {
			xyItemProvider = new XYItemProvider(this);
		}

		return xyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hub.clickwatch.analysis.results.BoxAndWhiskers} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoxAndWhiskersItemProvider boxAndWhiskersItemProvider;

	/**
	 * This creates an adapter for a {@link de.hub.clickwatch.analysis.results.BoxAndWhiskers}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBoxAndWhiskersAdapter() {
		if (boxAndWhiskersItemProvider == null) {
			boxAndWhiskersItemProvider = new BoxAndWhiskersItemProvider(this);
		}

		return boxAndWhiskersItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hub.clickwatch.analysis.results.Bar} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BarItemProvider barItemProvider;

	/**
	 * This creates an adapter for a {@link de.hub.clickwatch.analysis.results.Bar}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBarAdapter() {
		if (barItemProvider == null) {
			barItemProvider = new BarItemProvider(this);
		}

		return barItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.hub.clickwatch.analysis.results.Results} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultsItemProvider resultsItemProvider;

	/**
	 * This creates an adapter for a {@link de.hub.clickwatch.analysis.results.Results}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createResultsAdapter() {
		if (resultsItemProvider == null) {
			resultsItemProvider = new ResultsItemProvider(this);
		}

		return resultsItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (dataSetItemProvider != null) dataSetItemProvider.dispose();
		if (dataEntryItemProvider != null) dataEntryItemProvider.dispose();
		if (chartItemProvider != null) chartItemProvider.dispose();
		if (chartTypeItemProvider != null) chartTypeItemProvider.dispose();
		if (axisItemProvider != null) axisItemProvider.dispose();
		if (seriesItemProvider != null) seriesItemProvider.dispose();
		if (categoryItemProvider != null) categoryItemProvider.dispose();
		if (resultItemProvider != null) resultItemProvider.dispose();
		if (xyItemProvider != null) xyItemProvider.dispose();
		if (boxAndWhiskersItemProvider != null) boxAndWhiskersItemProvider.dispose();
		if (barItemProvider != null) barItemProvider.dispose();
		if (resultsItemProvider != null) resultsItemProvider.dispose();
	}

}