/*
 * Copyright (c) 2005, the JUNG Project and the Regents of the University 
 * of California
 * All rights reserved.
 *
 * This software is open-source under the BSD license; see either
 * "license.txt" or
 * http://jung.sourceforge.net/license.txt for a description.
 * Created on Mar 8, 2005
 *
 */
package edu.uci.ics.jung.visualization.control;

import java.awt.ItemSelectable;
import java.awt.event.InputEvent;


/** 
 * 
 * DefaultModalGraphMouse is a PluggableGraphMouse class that
 * pre-installs a large collection of plugins for picking and
 * transforming the graph. Additionally, it carries the notion
 * of a Mode: Picking or Translating. Switching between modes
 * allows for a more natural choice of mouse modifiers to
 * be used for the various plugins. The default modifiers are
 * intended to mimick those of mainstream software applications
 * in order to be intuitive to users.
 * 
 * To change between modes, two different controls are offered,
 * a combo box and a menu system. These controls are lazily created
 * in their respective 'getter' methods so they don't impact
 * code that does not intend to use them.
 * The menu control can be placed in an unused corner of the
 * GraphZoomScrollPane, which is a common location for mouse
 * mode selection menus in mainstream applications.
 * 
 * @author Tom Nelson
 */
public class DefaultModalGraphMouse extends AbstractModalGraphMouse 
    implements ModalGraphMouse, ItemSelectable {
    
    /**
     * create an instance with default values
     *
     */
    public DefaultModalGraphMouse() {
        this(1.1f, 1/1.1f);
    }
    
    /**
     * create an instance with passed values
     * @param in override value for scale in
     * @param out override value for scale out
     */
    public DefaultModalGraphMouse(float in, float out) {
        this.in = in;
        this.out = out;
        loadPlugins();
    }
    
    /**
     * create the plugins, and load the plugins for TRANSFORMING mode
     *
     */
    protected void loadPlugins() {
        pickingPlugin = new PickingGraphMousePlugin();
        animatedPickingPlugin = new AnimatedPickingGraphMousePlugin();
        translatingPlugin = new TranslatingGraphMousePlugin(InputEvent.BUTTON1_MASK);
        scalingPlugin = new ScalingGraphMousePlugin(new CrossoverScalingControl(), 0, in, out);
        rotatingPlugin = new RotatingGraphMousePlugin();
        shearingPlugin = new ShearingGraphMousePlugin();

        add(scalingPlugin);
        setMode(Mode.TRANSFORMING);
    }
}
