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
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class TrackListJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("TrackList", TrackListJsr.class, "TrackList");

    public TrackListJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected TrackListJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Long> length(){
        return getProp(Long.class, "length");
    }

    public IJsPropSetter length(long v) {
        return setProp("length", v);
    }

    public IJsPropSetter length(IValueBinding<Long> v) {
        return setProp("length", v);
    }

    public JsProp<Object> onchange(){
        return getProp(Object.class, "onchange");
    }

    public IJsPropSetter onchange(Object v) {
        return setProp("onchange", v);
    }

    public IJsPropSetter onchange(IValueBinding<Object> v) {
        return setProp("onchange", v);
    }

    public JsFunc<String> getID(long index){
        return call(String.class, "getID").with(index);
    }

    public JsFunc<String> getID(IValueBinding<Long> index){
        return call(String.class, "getID").with(index);
    }

    public JsFunc<String> getKind(long index){
        return call(String.class, "getKind").with(index);
    }

    public JsFunc<String> getKind(IValueBinding<Long> index){
        return call(String.class, "getKind").with(index);
    }

    public JsFunc<String> getLabel(long index){
        return call(String.class, "getLabel").with(index);
    }

    public JsFunc<String> getLabel(IValueBinding<Long> index){
        return call(String.class, "getLabel").with(index);
    }

    public JsFunc<String> getLanguage(long index){
        return call(String.class, "getLanguage").with(index);
    }

    public JsFunc<String> getLanguage(IValueBinding<Long> index){
        return call(String.class, "getLanguage").with(index);
    }
    
    public static JsTypeRef<TrackListJsr> prototype = new JsTypeRef<TrackListJsr>(S);
}