/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.hu.clickwatch.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.hu.clickwatch.model.ClickWatchModelFactory
 * @model kind="package"
 * @generated
 */
public interface ClickWatchModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "edu.hu.clickwatch.model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "edu.hu.clickwatch.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClickWatchModelPackage eINSTANCE = edu.hu.clickwatch.model.impl.ClickWatchModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.hu.clickwatch.model.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.hu.clickwatch.model.impl.NodeImpl
	 * @see edu.hu.clickwatch.model.impl.ClickWatchModelPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 0;

	/**
	 * The feature id for the '<em><b>INet Adress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INET_ADRESS = 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__PORT = 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ELEMENTS = 2;

	/**
	 * The feature id for the '<em><b>Connected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CONNECTED = 3;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CONNECTION = 4;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link edu.hu.clickwatch.model.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.hu.clickwatch.model.impl.ElementImpl
	 * @see edu.hu.clickwatch.model.impl.ClickWatchModelPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Handlers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__HANDLERS = 1;

	/**
	 * The feature id for the '<em><b>Watch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__WATCH = 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link edu.hu.clickwatch.model.impl.HandlerImpl <em>Handler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.hu.clickwatch.model.impl.HandlerImpl
	 * @see edu.hu.clickwatch.model.impl.ClickWatchModelPackageImpl#getHandler()
	 * @generated
	 */
	int HANDLER = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Can Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER__CAN_READ = 2;

	/**
	 * The feature id for the '<em><b>Can Write</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER__CAN_WRITE = 3;

	/**
	 * The feature id for the '<em><b>Changed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER__CHANGED = 4;

	/**
	 * The feature id for the '<em><b>Watch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER__WATCH = 5;

	/**
	 * The number of structural features of the '<em>Handler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER_FEATURE_COUNT = 6;


	/**
	 * The meta object id for the '{@link edu.hu.clickwatch.model.impl.NetworkImpl <em>Network</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.hu.clickwatch.model.impl.NetworkImpl
	 * @see edu.hu.clickwatch.model.impl.ClickWatchModelPackageImpl#getNetwork()
	 * @generated
	 */
	int NETWORK = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__NAME = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__NODES = 1;

	/**
	 * The number of structural features of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link edu.hu.clickwatch.model.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see edu.hu.clickwatch.model.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link edu.hu.clickwatch.model.Node#getINetAdress <em>INet Adress</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>INet Adress</em>'.
	 * @see edu.hu.clickwatch.model.Node#getINetAdress()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_INetAdress();

	/**
	 * Returns the meta object for the attribute '{@link edu.hu.clickwatch.model.Node#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see edu.hu.clickwatch.model.Node#getPort()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Port();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.hu.clickwatch.model.Node#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see edu.hu.clickwatch.model.Node#getElements()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Elements();

	/**
	 * Returns the meta object for the attribute '{@link edu.hu.clickwatch.model.Node#isConnected <em>Connected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connected</em>'.
	 * @see edu.hu.clickwatch.model.Node#isConnected()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Connected();

	/**
	 * Returns the meta object for the attribute '{@link edu.hu.clickwatch.model.Node#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection</em>'.
	 * @see edu.hu.clickwatch.model.Node#getConnection()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Connection();

	/**
	 * Returns the meta object for class '{@link edu.hu.clickwatch.model.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see edu.hu.clickwatch.model.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.hu.clickwatch.model.Element#getHandlers <em>Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Handlers</em>'.
	 * @see edu.hu.clickwatch.model.Element#getHandlers()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Handlers();

	/**
	 * Returns the meta object for the attribute '{@link edu.hu.clickwatch.model.Element#isWatch <em>Watch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Watch</em>'.
	 * @see edu.hu.clickwatch.model.Element#isWatch()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Watch();

	/**
	 * Returns the meta object for the attribute '{@link edu.hu.clickwatch.model.Element#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.hu.clickwatch.model.Element#getName()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Name();

	/**
	 * Returns the meta object for class '{@link edu.hu.clickwatch.model.Handler <em>Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Handler</em>'.
	 * @see edu.hu.clickwatch.model.Handler
	 * @generated
	 */
	EClass getHandler();

	/**
	 * Returns the meta object for the attribute '{@link edu.hu.clickwatch.model.Handler#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.hu.clickwatch.model.Handler#getValue()
	 * @see #getHandler()
	 * @generated
	 */
	EAttribute getHandler_Value();

	/**
	 * Returns the meta object for the attribute '{@link edu.hu.clickwatch.model.Handler#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.hu.clickwatch.model.Handler#getName()
	 * @see #getHandler()
	 * @generated
	 */
	EAttribute getHandler_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.hu.clickwatch.model.Handler#isCanRead <em>Can Read</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Read</em>'.
	 * @see edu.hu.clickwatch.model.Handler#isCanRead()
	 * @see #getHandler()
	 * @generated
	 */
	EAttribute getHandler_CanRead();

	/**
	 * Returns the meta object for the attribute '{@link edu.hu.clickwatch.model.Handler#isCanWrite <em>Can Write</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Write</em>'.
	 * @see edu.hu.clickwatch.model.Handler#isCanWrite()
	 * @see #getHandler()
	 * @generated
	 */
	EAttribute getHandler_CanWrite();

	/**
	 * Returns the meta object for the attribute '{@link edu.hu.clickwatch.model.Handler#isWatch <em>Watch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Watch</em>'.
	 * @see edu.hu.clickwatch.model.Handler#isWatch()
	 * @see #getHandler()
	 * @generated
	 */
	EAttribute getHandler_Watch();

	/**
	 * Returns the meta object for the attribute '{@link edu.hu.clickwatch.model.Handler#isChanged <em>Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Changed</em>'.
	 * @see edu.hu.clickwatch.model.Handler#isChanged()
	 * @see #getHandler()
	 * @generated
	 */
	EAttribute getHandler_Changed();

	/**
	 * Returns the meta object for class '{@link edu.hu.clickwatch.model.Network <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Network</em>'.
	 * @see edu.hu.clickwatch.model.Network
	 * @generated
	 */
	EClass getNetwork();

	/**
	 * Returns the meta object for the attribute '{@link edu.hu.clickwatch.model.Network#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.hu.clickwatch.model.Network#getName()
	 * @see #getNetwork()
	 * @generated
	 */
	EAttribute getNetwork_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.hu.clickwatch.model.Network#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see edu.hu.clickwatch.model.Network#getNodes()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Nodes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ClickWatchModelFactory getClickWatchModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.hu.clickwatch.model.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.hu.clickwatch.model.impl.NodeImpl
		 * @see edu.hu.clickwatch.model.impl.ClickWatchModelPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>INet Adress</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__INET_ADRESS = eINSTANCE.getNode_INetAdress();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__PORT = eINSTANCE.getNode_Port();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__ELEMENTS = eINSTANCE.getNode_Elements();

		/**
		 * The meta object literal for the '<em><b>Connected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__CONNECTED = eINSTANCE.getNode_Connected();

		/**
		 * The meta object literal for the '<em><b>Connection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__CONNECTION = eINSTANCE.getNode_Connection();

		/**
		 * The meta object literal for the '{@link edu.hu.clickwatch.model.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.hu.clickwatch.model.impl.ElementImpl
		 * @see edu.hu.clickwatch.model.impl.ClickWatchModelPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Handlers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__HANDLERS = eINSTANCE.getElement_Handlers();

		/**
		 * The meta object literal for the '<em><b>Watch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__WATCH = eINSTANCE.getElement_Watch();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

		/**
		 * The meta object literal for the '{@link edu.hu.clickwatch.model.impl.HandlerImpl <em>Handler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.hu.clickwatch.model.impl.HandlerImpl
		 * @see edu.hu.clickwatch.model.impl.ClickWatchModelPackageImpl#getHandler()
		 * @generated
		 */
		EClass HANDLER = eINSTANCE.getHandler();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HANDLER__VALUE = eINSTANCE.getHandler_Value();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HANDLER__NAME = eINSTANCE.getHandler_Name();

		/**
		 * The meta object literal for the '<em><b>Can Read</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HANDLER__CAN_READ = eINSTANCE.getHandler_CanRead();

		/**
		 * The meta object literal for the '<em><b>Can Write</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HANDLER__CAN_WRITE = eINSTANCE.getHandler_CanWrite();

		/**
		 * The meta object literal for the '<em><b>Watch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HANDLER__WATCH = eINSTANCE.getHandler_Watch();

		/**
		 * The meta object literal for the '<em><b>Changed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HANDLER__CHANGED = eINSTANCE.getHandler_Changed();

		/**
		 * The meta object literal for the '{@link edu.hu.clickwatch.model.impl.NetworkImpl <em>Network</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.hu.clickwatch.model.impl.NetworkImpl
		 * @see edu.hu.clickwatch.model.impl.ClickWatchModelPackageImpl#getNetwork()
		 * @generated
		 */
		EClass NETWORK = eINSTANCE.getNetwork();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NETWORK__NAME = eINSTANCE.getNetwork_Name();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__NODES = eINSTANCE.getNetwork_Nodes();

	}

} //ClickWatchModelPackage
