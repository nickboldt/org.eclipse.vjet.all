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
public class HTMLScriptElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLScriptElement", HTMLScriptElementJsr.class, "HTMLScriptElement");

    public HTMLScriptElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLScriptElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> text(){
        return getProp(String.class, "text");
    }

    public IJsPropSetter text(String v) {
        return setProp("text", v);
    }

    public IJsPropSetter text(IValueBinding<String> v) {
        return setProp("text", v);
    }

    public JsProp<String> charset(){
        return getProp(String.class, "charset");
    }

    public IJsPropSetter charset(String v) {
        return setProp("charset", v);
    }

    public IJsPropSetter charset(IValueBinding<String> v) {
        return setProp("charset", v);
    }

    public JsProp<Boolean> defer(){
        return getProp(Boolean.class, "defer");
    }

    public IJsPropSetter defer(boolean v) {
        return setProp("defer", v);
    }

    public IJsPropSetter defer(IValueBinding<Boolean> v) {
        return setProp("defer", v);
    }

    public JsProp<String> src(){
        return getProp(String.class, "src");
    }

    public IJsPropSetter src(String v) {
        return setProp("src", v);
    }

    public IJsPropSetter src(IValueBinding<String> v) {
        return setProp("src", v);
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

    public JsProp<Object> onload(){
        return getProp(Object.class, "onload");
    }

    public IJsPropSetter onload(Object v) {
        return setProp("onload", v);
    }

    public IJsPropSetter onload(IValueBinding<Object> v) {
        return setProp("onload", v);
    }

    public JsProp<Object> onunload(){
        return getProp(Object.class, "onunload");
    }

    public IJsPropSetter onunload(Object v) {
        return setProp("onunload", v);
    }

    public IJsPropSetter onunload(IValueBinding<Object> v) {
        return setProp("onunload", v);
    }

    public JsProp<Object> onmousemove(){
        return getProp(Object.class, "onmousemove");
    }

    public IJsPropSetter onmousemove(Object v) {
        return setProp("onmousemove", v);
    }

    public IJsPropSetter onmousemove(IValueBinding<Object> v) {
        return setProp("onmousemove", v);
    }

    public JsProp<Object> onmouseout(){
        return getProp(Object.class, "onmouseout");
    }

    public IJsPropSetter onmouseout(Object v) {
        return setProp("onmouseout", v);
    }

    public IJsPropSetter onmouseout(IValueBinding<Object> v) {
        return setProp("onmouseout", v);
    }

    public JsProp<Object> onmouseover(){
        return getProp(Object.class, "onmouseover");
    }

    public IJsPropSetter onmouseover(Object v) {
        return setProp("onmouseover", v);
    }

    public IJsPropSetter onmouseover(IValueBinding<Object> v) {
        return setProp("onmouseover", v);
    }
    
    public static JsTypeRef<HTMLScriptElementJsr> prototype = new JsTypeRef<HTMLScriptElementJsr>(S);
}