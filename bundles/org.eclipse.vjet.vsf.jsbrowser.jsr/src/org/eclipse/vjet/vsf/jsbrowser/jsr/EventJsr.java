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
import org.eclipse.vjet.vsf.jsbrowser.jsr.EventTargetJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class EventJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("Event", EventJsr.class, "Event");

    public EventJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected EventJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> type(){
        return getProp(String.class, "type");
    }

    public IJsPropSetter type(String v) {
        return setProp("type", v);
    }

    public IJsPropSetter type(IValueBinding<String> v) {
        return setProp("type", v);
    }

    public JsProp<EventTargetJsr> target(){
        return getProp(EventTargetJsr.class, "target");
    }

    public IJsPropSetter target(EventTargetJsr v) {
        return setProp("target", v);
    }

    public IJsPropSetter target(IValueBinding<? extends EventTargetJsr> v) {
        return setProp("target", v);
    }

    public JsProp<EventTargetJsr> srcElement(){
        return getProp(EventTargetJsr.class, "srcElement");
    }

    public IJsPropSetter srcElement(EventTargetJsr v) {
        return setProp("srcElement", v);
    }

    public IJsPropSetter srcElement(IValueBinding<? extends EventTargetJsr> v) {
        return setProp("srcElement", v);
    }

    public JsProp<Boolean> bubbles(){
        return getProp(Boolean.class, "bubbles");
    }

    public IJsPropSetter bubbles(boolean v) {
        return setProp("bubbles", v);
    }

    public IJsPropSetter bubbles(IValueBinding<Boolean> v) {
        return setProp("bubbles", v);
    }

    public JsProp<Boolean> cancelBubble(){
        return getProp(Boolean.class, "cancelBubble");
    }

    public IJsPropSetter cancelBubble(boolean v) {
        return setProp("cancelBubble", v);
    }

    public IJsPropSetter cancelBubble(IValueBinding<Boolean> v) {
        return setProp("cancelBubble", v);
    }

    public JsProp<Boolean> cancelable(){
        return getProp(Boolean.class, "cancelable");
    }

    public IJsPropSetter cancelable(boolean v) {
        return setProp("cancelable", v);
    }

    public IJsPropSetter cancelable(IValueBinding<Boolean> v) {
        return setProp("cancelable", v);
    }

    public JsProp<Long> timeStamp(){
        return getProp(Long.class, "timeStamp");
    }

    public IJsPropSetter timeStamp(long v) {
        return setProp("timeStamp", v);
    }

    public IJsPropSetter timeStamp(IValueBinding<Long> v) {
        return setProp("timeStamp", v);
    }

    public JsProp<Boolean> defaultPrevented(){
        return getProp(Boolean.class, "defaultPrevented");
    }

    public IJsPropSetter defaultPrevented(boolean v) {
        return setProp("defaultPrevented", v);
    }

    public IJsPropSetter defaultPrevented(IValueBinding<Boolean> v) {
        return setProp("defaultPrevented", v);
    }

    public JsProp<Boolean> returnValue(){
        return getProp(Boolean.class, "returnValue");
    }

    public IJsPropSetter returnValue(boolean v) {
        return setProp("returnValue", v);
    }

    public IJsPropSetter returnValue(IValueBinding<Boolean> v) {
        return setProp("returnValue", v);
    }

    public JsFunc<Void> stopPropagation(){
        return call("stopPropagation");
    }

    public JsFunc<Void> preventDefault(){
        return call("preventDefault");
    }

    public JsFunc<Void> stopImmediatePropagation(){
        return call("stopImmediatePropagation");
    }
    
    public static JsTypeRef<EventJsr> prototype = new JsTypeRef<EventJsr>(S);
}