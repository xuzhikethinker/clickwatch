package de.hub.clickwatch.datamodel.util.builder;

/**
 * <!-- begin-user-doc --> 
 *   A builder for the model object ' <em><b>de.hub.clickwatch.datamodel.Handler</b></em>'.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class HandlerBuilder implements de.hub.clickwatch.datamodel.util.builder.IDatamodelBuilder<de.hub.clickwatch.datamodel.Handler> {
  // features and builders
  private Boolean m_canRead;
  private Boolean m_canWrite;
  private Boolean m_changed;
  private java.lang.String m_name;
  private java.util.Collection<de.hub.clickwatch.datamodel.Value> m_values = new java.util.LinkedList<de.hub.clickwatch.datamodel.Value>();
  private java.util.Collection<de.hub.clickwatch.datamodel.util.builder.IDatamodelBuilder<? extends de.hub.clickwatch.datamodel.Value>> m_featureValuesBuilder = new java.util.LinkedList<de.hub.clickwatch.datamodel.util.builder.IDatamodelBuilder<? extends de.hub.clickwatch.datamodel.Value>>();
  // helper attributes
  private boolean m_featureCanReadSet = false;
  private boolean m_featureCanWriteSet = false;
  private boolean m_featureChangedSet = false;
  private boolean m_featureNameSet = false;
  private boolean m_featureValuesSet = false;

  /**
   * Builder is not instantiated with a constructor.
   * @see #newHandlerBuilder()
   */
  private HandlerBuilder() {
  }

  /**
   * This method creates a new instance of the HandlerBuilder.
   * @return new instance of the HandlerBuilder
   */
  public static HandlerBuilder newHandlerBuilder() {
    return new HandlerBuilder();
  }

  /**
   * This method can be used to override attributes of the builder. It constructs a new builder and copies the current values to it.
   */
  public HandlerBuilder but() {
    HandlerBuilder _builder = newHandlerBuilder();
    _builder.m_featureCanReadSet = m_featureCanReadSet;
    _builder.m_canRead = m_canRead;
    _builder.m_featureCanWriteSet = m_featureCanWriteSet;
    _builder.m_canWrite = m_canWrite;
    _builder.m_featureChangedSet = m_featureChangedSet;
    _builder.m_changed = m_changed;
    _builder.m_featureNameSet = m_featureNameSet;
    _builder.m_name = m_name;
    _builder.m_featureValuesSet = m_featureValuesSet;
    _builder.m_values = m_values;
    _builder.m_featureValuesBuilder = m_featureValuesBuilder;
    return _builder;
  }

  /**
   * This method constructs the final de.hub.clickwatch.datamodel.Handler type.
   * @return new instance of the de.hub.clickwatch.datamodel.Handler type
   */
  public de.hub.clickwatch.datamodel.Handler build() {
    final de.hub.clickwatch.datamodel.Handler _newInstance = de.hub.clickwatch.datamodel.ClickWatchDataModelFactory.eINSTANCE.createHandler();
    if (m_featureCanReadSet) {
      _newInstance.setCanRead(m_canRead);
    }
    if (m_featureCanWriteSet) {
      _newInstance.setCanWrite(m_canWrite);
    }
    if (m_featureChangedSet) {
      _newInstance.setChanged(m_changed);
    }
    if (m_featureNameSet) {
      _newInstance.setName(m_name);
    }
    if (m_featureValuesSet) {
      _newInstance.getValues().addAll(m_values);
    } else {
      if (!m_featureValuesBuilder.isEmpty()) {
        for (de.hub.clickwatch.datamodel.util.builder.IDatamodelBuilder<? extends de.hub.clickwatch.datamodel.Value> builder : m_featureValuesBuilder) {
          _newInstance.getValues().add(builder.build());
        }
      }
    }
    return _newInstance;
  }

  public HandlerBuilder withCanRead(Boolean p_canRead) {
    m_canRead = p_canRead;
    m_featureCanReadSet = true;
    return this;
  }

  public HandlerBuilder withCanWrite(Boolean p_canWrite) {
    m_canWrite = p_canWrite;
    m_featureCanWriteSet = true;
    return this;
  }

  public HandlerBuilder withChanged(Boolean p_changed) {
    m_changed = p_changed;
    m_featureChangedSet = true;
    return this;
  }

  public HandlerBuilder withName(java.lang.String p_name) {
    m_name = p_name;
    m_featureNameSet = true;
    return this;
  }

  public HandlerBuilder withValues(de.hub.clickwatch.datamodel.Value p_values) {
    m_values.add(p_values);
    m_featureValuesSet = true;
    return this;
  }

  public HandlerBuilder withValues(java.util.Collection<? extends de.hub.clickwatch.datamodel.Value> p_values) {
    m_values.addAll(p_values);
    m_featureValuesSet = true;
    return this;
  }

  public HandlerBuilder withValues(de.hub.clickwatch.datamodel.util.builder.IDatamodelBuilder<? extends de.hub.clickwatch.datamodel.Value> p_valueBuilder) {
    m_featureValuesBuilder.add(p_valueBuilder);
    return this;
  }
}