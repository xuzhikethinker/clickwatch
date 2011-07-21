/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.clickwatch.cwdatabase.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

import org.apache.commons.math.stat.descriptive.SummaryStatistics;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.xml.type.internal.DataValue.Base64;

import de.hub.clickwatch.cwdatabase.CWDataBaseFactory;
import de.hub.clickwatch.cwdatabase.CWDataBasePackage;
import de.hub.clickwatch.cwdatabase.DataBase;
import de.hub.clickwatch.cwdatabase.ExperimentDescr;
import de.hub.clickwatch.cwdatabase.ExperimentNodeRecordTimeTable;
import de.hub.clickwatch.cwdatabase.ExperimentRecord;
import de.hub.clickwatch.cwdatabase.ExperimentStatistics;
import de.hub.clickwatch.cwdatabase.NodeRecord;
import de.hub.clickwatch.cwdatabase.NodeRecordDescr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CWDataBaseFactoryImpl extends EFactoryImpl implements CWDataBaseFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CWDataBaseFactory init() {
		try {
			CWDataBaseFactory theCWDataBaseFactory = (CWDataBaseFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hub.clickwatch/cwdatabase"); 
			if (theCWDataBaseFactory != null) {
				return theCWDataBaseFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CWDataBaseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CWDataBaseFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CWDataBasePackage.EXPERIMENT_DESCR: return createExperimentDescr();
			case CWDataBasePackage.NODE_RECORD: return createNodeRecord();
			case CWDataBasePackage.DATA_BASE: return createDataBase();
			case CWDataBasePackage.EXPERIMENT_RECORD: return createExperimentRecord();
			case CWDataBasePackage.EXPERIMENT_NODE_RECORD_TIME_TABLE: return createExperimentNodeRecordTimeTable();
			case CWDataBasePackage.ESTRING_TO_EXPERIMENT_NODE_RECORD_TIME_TABLE_MAP: return (EObject)createEStringToExperimentNodeRecordTimeTableMap();
			case CWDataBasePackage.ELONG_OBJECT_TO_NODE_RECORD_DESCR_MAP: return (EObject)createELongObjectToNodeRecordDescrMap();
			case CWDataBasePackage.EXPERIMENT_STATISTICS: return createExperimentStatistics();
			case CWDataBasePackage.NODE_RECORD_DESCR: return createNodeRecordDescr();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CWDataBasePackage.ESUMMARY_STATISTICS:
				return createESummaryStatisticsFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CWDataBasePackage.ESUMMARY_STATISTICS:
				return convertESummaryStatisticsToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentDescr createExperimentDescr() {
		ExperimentDescrImpl experimentDescr = new ExperimentDescrImpl();
		return experimentDescr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeRecord createNodeRecord() {
		NodeRecordImpl nodeRecord = new NodeRecordImpl();
		return nodeRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataBase createDataBase() {
		DataBaseImpl dataBase = new DataBaseImpl();
		return dataBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentRecord createExperimentRecord() {
		ExperimentRecordImpl experimentRecord = new ExperimentRecordImpl();
		return experimentRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentNodeRecordTimeTable createExperimentNodeRecordTimeTable() {
		ExperimentNodeRecordTimeTableImpl experimentNodeRecordTimeTable = new ExperimentNodeRecordTimeTableImpl();
		return experimentNodeRecordTimeTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, ExperimentNodeRecordTimeTable> createEStringToExperimentNodeRecordTimeTableMap() {
		EStringToExperimentNodeRecordTimeTableMapImpl eStringToExperimentNodeRecordTimeTableMap = new EStringToExperimentNodeRecordTimeTableMapImpl();
		return eStringToExperimentNodeRecordTimeTableMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Long, NodeRecordDescr> createELongObjectToNodeRecordDescrMap() {
		ELongObjectToNodeRecordDescrMapImpl eLongObjectToNodeRecordDescrMap = new ELongObjectToNodeRecordDescrMapImpl();
		return eLongObjectToNodeRecordDescrMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentStatistics createExperimentStatistics() {
		ExperimentStatisticsImpl experimentStatistics = new ExperimentStatisticsImpl();
		return experimentStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeRecordDescr createNodeRecordDescr() {
		NodeRecordDescrImpl nodeRecordDescr = new NodeRecordDescrImpl();
		return nodeRecordDescr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SummaryStatistics createESummaryStatisticsFromString(EDataType eDataType, String initialValue) {
		try {
		    byte[] bytes = Base64.decode(initialValue);
		    ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes));
		    SummaryStatistics value = (SummaryStatistics)in.readObject();
		    in.close();
		    return value;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertESummaryStatisticsToString(EDataType eDataType, Object instanceValue) {
		try {
			Serializable value = (Serializable)instanceValue;
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
		    ObjectOutputStream out = new ObjectOutputStream(bos) ;
		    out.writeObject(value);
		    out.close();
	
		    return Base64.encode(bos.toByteArray());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CWDataBasePackage getCWDataBasePackage() {
		return (CWDataBasePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CWDataBasePackage getPackage() {
		return CWDataBasePackage.eINSTANCE;
	}

} //CWDataBaseFactoryImpl