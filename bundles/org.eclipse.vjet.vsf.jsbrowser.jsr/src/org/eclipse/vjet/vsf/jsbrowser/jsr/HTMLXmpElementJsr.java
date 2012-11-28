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
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLXmpElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLXmpElement", HTMLXmpElementJsr.class, "HTMLXmpElement");

    public HTMLXmpElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLXmpElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> accessKey(){
        return getProp(String.class, "accessKey");
    }

    public IJsPropSetter accessKey(String v) {
        return setProp("accessKey", v);
    }

    public IJsPropSetter accessKey(IValueBinding<String> v) {
        return setProp("accessKey", v);
    }

    public JsProp<String> atomicSelection(){
        return getProp(String.class, "atomicSelection");
    }

    public IJsPropSetter atomicSelection(String v) {
        return setProp("atomicSelection", v);
    }

    public IJsPropSetter atomicSelection(IValueBinding<String> v) {
        return setProp("atomicSelection", v);
    }

    public JsProp<String> contentEditable(){
        return getProp(String.class, "contentEditable");
    }

    public IJsPropSetter contentEditable(String v) {
        return setProp("contentEditable", v);
    }

    public IJsPropSetter contentEditable(IValueBinding<String> v) {
        return setProp("contentEditable", v);
    }

    public JsProp<String> hideFocus(){
        return getProp(String.class, "hideFocus");
    }

    public IJsPropSetter hideFocus(String v) {
        return setProp("hideFocus", v);
    }

    public IJsPropSetter hideFocus(IValueBinding<String> v) {
        return setProp("hideFocus", v);
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

    public JsProp<Integer> tabIndex(){
        return getProp(Integer.class, "tabIndex");
    }

    public IJsPropSetter tabIndex(int v) {
        return setProp("tabIndex", v);
    }

    public IJsPropSetter tabIndex(IValueBinding<Integer> v) {
        return setProp("tabIndex", v);
    }

    public JsProp<String> unselectable(){
        return getProp(String.class, "unselectable");
    }

    public IJsPropSetter unselectable(String v) {
        return setProp("unselectable", v);
    }

    public IJsPropSetter unselectable(IValueBinding<String> v) {
        return setProp("unselectable", v);
    }
    
    public static JsTypeRef<HTMLXmpElementJsr> prototype = new JsTypeRef<HTMLXmpElementJsr>(S);
}