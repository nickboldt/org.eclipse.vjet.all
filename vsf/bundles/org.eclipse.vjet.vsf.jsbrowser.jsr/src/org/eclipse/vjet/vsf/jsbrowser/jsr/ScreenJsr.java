/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.vsf.jsbrowser.jsr;
import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ScreenJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("Screen", ScreenJsr.class, "Screen");

    public ScreenJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ScreenJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Integer> availHeight(){
        return getProp(Integer.class, "availHeight");
    }

    public IJsPropSetter availHeight(int v) {
        return setProp("availHeight", v);
    }

    public IJsPropSetter availHeight(IValueBinding<Integer> v) {
        return setProp("availHeight", v);
    }

    public JsProp<Integer> availWidth(){
        return getProp(Integer.class, "availWidth");
    }

    public IJsPropSetter availWidth(int v) {
        return setProp("availWidth", v);
    }

    public IJsPropSetter availWidth(IValueBinding<Integer> v) {
        return setProp("availWidth", v);
    }

    public JsProp<Integer> colorDepth(){
        return getProp(Integer.class, "colorDepth");
    }

    public IJsPropSetter colorDepth(int v) {
        return setProp("colorDepth", v);
    }

    public IJsPropSetter colorDepth(IValueBinding<Integer> v) {
        return setProp("colorDepth", v);
    }

    public JsProp<Integer> height(){
        return getProp(Integer.class, "height");
    }

    public IJsPropSetter height(int v) {
        return setProp("height", v);
    }

    public IJsPropSetter height(IValueBinding<Integer> v) {
        return setProp("height", v);
    }

    public JsProp<Integer> pixelDepth(){
        return getProp(Integer.class, "pixelDepth");
    }

    public IJsPropSetter pixelDepth(int v) {
        return setProp("pixelDepth", v);
    }

    public IJsPropSetter pixelDepth(IValueBinding<Integer> v) {
        return setProp("pixelDepth", v);
    }

    public JsProp<Integer> width(){
        return getProp(Integer.class, "width");
    }

    public IJsPropSetter width(int v) {
        return setProp("width", v);
    }

    public IJsPropSetter width(IValueBinding<Integer> v) {
        return setProp("width", v);
    }

    public JsProp<Integer> bufferDepth(){
        return getProp(Integer.class, "bufferDepth");
    }

    public IJsPropSetter bufferDepth(int v) {
        return setProp("bufferDepth", v);
    }

    public IJsPropSetter bufferDepth(IValueBinding<Integer> v) {
        return setProp("bufferDepth", v);
    }

    public JsProp<Integer> deviceXDPI(){
        return getProp(Integer.class, "deviceXDPI");
    }

    public IJsPropSetter deviceXDPI(int v) {
        return setProp("deviceXDPI", v);
    }

    public IJsPropSetter deviceXDPI(IValueBinding<Integer> v) {
        return setProp("deviceXDPI", v);
    }

    public JsProp<Integer> deviceYDPI(){
        return getProp(Integer.class, "deviceYDPI");
    }

    public IJsPropSetter deviceYDPI(int v) {
        return setProp("deviceYDPI", v);
    }

    public IJsPropSetter deviceYDPI(IValueBinding<Integer> v) {
        return setProp("deviceYDPI", v);
    }

    public JsProp<Boolean> fontSmoothingEnabled(){
        return getProp(Boolean.class, "fontSmoothingEnabled");
    }

    public IJsPropSetter fontSmoothingEnabled(boolean v) {
        return setProp("fontSmoothingEnabled", v);
    }

    public IJsPropSetter fontSmoothingEnabled(IValueBinding<Boolean> v) {
        return setProp("fontSmoothingEnabled", v);
    }

    public JsProp<Integer> logicalXDPI(){
        return getProp(Integer.class, "logicalXDPI");
    }

    public IJsPropSetter logicalXDPI(int v) {
        return setProp("logicalXDPI", v);
    }

    public IJsPropSetter logicalXDPI(IValueBinding<Integer> v) {
        return setProp("logicalXDPI", v);
    }

    public JsProp<Integer> logicalYDPI(){
        return getProp(Integer.class, "logicalYDPI");
    }

    public IJsPropSetter logicalYDPI(int v) {
        return setProp("logicalYDPI", v);
    }

    public IJsPropSetter logicalYDPI(IValueBinding<Integer> v) {
        return setProp("logicalYDPI", v);
    }

    public JsProp<Integer> updateInterval(){
        return getProp(Integer.class, "updateInterval");
    }

    public IJsPropSetter updateInterval(int v) {
        return setProp("updateInterval", v);
    }

    public IJsPropSetter updateInterval(IValueBinding<Integer> v) {
        return setProp("updateInterval", v);
    }
    
    public static JsTypeRef<ScreenJsr> prototype = new JsTypeRef<ScreenJsr>(S);
}