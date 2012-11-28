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
public class TextTrackJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("TextTrack", TextTrackJsr.class, "TextTrack");

    public TextTrackJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected TextTrackJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> kind(){
        return getProp(String.class, "kind");
    }

    public IJsPropSetter kind(String v) {
        return setProp("kind", v);
    }

    public IJsPropSetter kind(IValueBinding<String> v) {
        return setProp("kind", v);
    }

    public JsProp<String> label(){
        return getProp(String.class, "label");
    }

    public IJsPropSetter label(String v) {
        return setProp("label", v);
    }

    public IJsPropSetter label(IValueBinding<String> v) {
        return setProp("label", v);
    }

    public JsProp<String> language(){
        return getProp(String.class, "language");
    }

    public IJsPropSetter language(String v) {
        return setProp("language", v);
    }

    public IJsPropSetter language(IValueBinding<String> v) {
        return setProp("language", v);
    }

    public JsProp<Short> short_(){
        return getProp(Short.class, "short_");
    }

    public IJsPropSetter short_(short v) {
        return setProp("short_", v);
    }

    public IJsPropSetter short_(IValueBinding<Short> v) {
        return setProp("short_", v);
    }

    public JsProp<Object> onload(){
        return getProp(Object.class, "onload");
    }

    public IJsPropSetter onload(Object v) {
        return setProp("onload", v);
    }

    public IJsPropSetter onload(IValueBinding<Object> v) {
        return setProp("onload", v);
    }

    public JsProp<Object> onerror(){
        return getProp(Object.class, "onerror");
    }

    public IJsPropSetter onerror(Object v) {
        return setProp("onerror", v);
    }

    public IJsPropSetter onerror(IValueBinding<Object> v) {
        return setProp("onerror", v);
    }
    
    public static JsTypeRef<TextTrackJsr> prototype = new JsTypeRef<TextTrackJsr>(S);
}