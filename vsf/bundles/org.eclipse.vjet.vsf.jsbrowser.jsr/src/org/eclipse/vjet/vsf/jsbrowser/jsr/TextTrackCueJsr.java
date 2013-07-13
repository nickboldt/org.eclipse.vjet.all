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
import org.eclipse.vjet.vsf.jsbrowser.jsr.DocumentFragmentJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.TextTrackJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class TextTrackCueJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("TextTrackCue", TextTrackCueJsr.class, "TextTrackCue");

    public TextTrackCueJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected TextTrackCueJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<TextTrackJsr> track(){
        return getProp(TextTrackJsr.class, "track");
    }

    public IJsPropSetter track(TextTrackJsr v) {
        return setProp("track", v);
    }

    public IJsPropSetter track(IValueBinding<? extends TextTrackJsr> v) {
        return setProp("track", v);
    }

    public JsProp<String> id(){
        return getProp(String.class, "id");
    }

    public IJsPropSetter id(String v) {
        return setProp("id", v);
    }

    public IJsPropSetter id(IValueBinding<String> v) {
        return setProp("id", v);
    }

    public JsProp<Double> startTime(){
        return getProp(Double.class, "startTime");
    }

    public IJsPropSetter startTime(double v) {
        return setProp("startTime", v);
    }

    public IJsPropSetter startTime(IValueBinding<Double> v) {
        return setProp("startTime", v);
    }

    public JsProp<Double> endTime(){
        return getProp(Double.class, "endTime");
    }

    public IJsPropSetter endTime(double v) {
        return setProp("endTime", v);
    }

    public IJsPropSetter endTime(IValueBinding<Double> v) {
        return setProp("endTime", v);
    }

    public JsProp<Boolean> pauseOnExit(){
        return getProp(Boolean.class, "pauseOnExit");
    }

    public IJsPropSetter pauseOnExit(boolean v) {
        return setProp("pauseOnExit", v);
    }

    public IJsPropSetter pauseOnExit(IValueBinding<Boolean> v) {
        return setProp("pauseOnExit", v);
    }

    public JsProp<Object> onenter(){
        return getProp(Object.class, "onenter");
    }

    public IJsPropSetter onenter(Object v) {
        return setProp("onenter", v);
    }

    public IJsPropSetter onenter(IValueBinding<Object> v) {
        return setProp("onenter", v);
    }

    public JsProp<Object> onexit(){
        return getProp(Object.class, "onexit");
    }

    public IJsPropSetter onexit(Object v) {
        return setProp("onexit", v);
    }

    public IJsPropSetter onexit(IValueBinding<Object> v) {
        return setProp("onexit", v);
    }

    public JsFunc<String> getCueAsSource(){
        return call(String.class, "getCueAsSource");
    }

    public JsFunc<? extends DocumentFragmentJsr> getCueAsHTML(){
        return call(DocumentFragmentJsr.class, "getCueAsHTML");
    }
    
    public static JsTypeRef<TextTrackCueJsr> prototype = new JsTypeRef<TextTrackCueJsr>(S);
}