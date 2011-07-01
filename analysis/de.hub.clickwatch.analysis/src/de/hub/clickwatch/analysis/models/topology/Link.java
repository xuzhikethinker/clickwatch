/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.clickwatch.analysis.models.topology;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.clickwatch.analysis.models.topology.Link#getSource <em>Source</em>}</li>
 *   <li>{@link de.hub.clickwatch.analysis.models.topology.Link#getTarget <em>Target</em>}</li>
 *   <li>{@link de.hub.clickwatch.analysis.models.topology.Link#getPdr <em>Pdr</em>}</li>
 *   <li>{@link de.hub.clickwatch.analysis.models.topology.Link#getReverse <em>Reverse</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.clickwatch.analysis.models.topology.TopologyPackage#getLink()
 * @model
 * @generated
 */
public interface Link extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hub.clickwatch.analysis.models.topology.Node#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see de.hub.clickwatch.analysis.models.topology.TopologyPackage#getLink_Source()
	 * @see de.hub.clickwatch.analysis.models.topology.Node#getOutgoing
	 * @model opposite="outgoing"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link de.hub.clickwatch.analysis.models.topology.Link#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hub.clickwatch.analysis.models.topology.Node#getIncomming <em>Incomming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see de.hub.clickwatch.analysis.models.topology.TopologyPackage#getLink_Target()
	 * @see de.hub.clickwatch.analysis.models.topology.Node#getIncomming
	 * @model opposite="incomming"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link de.hub.clickwatch.analysis.models.topology.Link#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Pdr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pdr</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pdr</em>' attribute.
	 * @see #setPdr(int)
	 * @see de.hub.clickwatch.analysis.models.topology.TopologyPackage#getLink_Pdr()
	 * @model
	 * @generated
	 */
	int getPdr();

	/**
	 * Sets the value of the '{@link de.hub.clickwatch.analysis.models.topology.Link#getPdr <em>Pdr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pdr</em>' attribute.
	 * @see #getPdr()
	 * @generated
	 */
	void setPdr(int value);

	/**
	 * Returns the value of the '<em><b>Reverse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reverse</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reverse</em>' reference.
	 * @see #setReverse(Link)
	 * @see de.hub.clickwatch.analysis.models.topology.TopologyPackage#getLink_Reverse()
	 * @model
	 * @generated
	 */
	Link getReverse();

	/**
	 * Sets the value of the '{@link de.hub.clickwatch.analysis.models.topology.Link#getReverse <em>Reverse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reverse</em>' reference.
	 * @see #getReverse()
	 * @generated
	 */
	void setReverse(Link value);

} // Link