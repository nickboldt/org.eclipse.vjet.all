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
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLFormElementJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLLabelElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLLabelElement", HTMLLabelElementJsr.class, "HTMLLabelElement");

    public HTMLLabelElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLLabelElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<HTMLFormElementJsr> form(){
        return getProp(HTMLFormElementJsr.class, "form");
    }

    public IJsPropSetter form(HTMLFormElementJsr v) {
        return setProp("form", v);
    }

    public IJsPropSetter form(IValueBinding<? extends HTMLFormElementJsr> v) {
        return setProp("form", v);
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

    public JsProp<String> htmlFor(){
        return getProp(String.class, "htmlFor");
    }

    public IJsPropSetter htmlFor(String v) {
        return setProp("htmlFor", v);
    }

    public IJsPropSetter htmlFor(IValueBinding<String> v) {
        return setProp("htmlFor", v);
    }

    public JsProp<Object> onblur(){
        return getProp(Object.class, "onblur");
    }

    public IJsPropSetter onblur(Object v) {
        return setProp("onblur", v);
    }

    public IJsPropSetter onblur(IValueBinding<Object> v) {
        return setProp("onblur", v);
    }

    public JsProp<Object> onfocus(){
        return getProp(Object.class, "onfocus");
    }

    public IJsPropSetter onfocus(Object v) {
        return setProp("onfocus", v);
    }

    public IJsPropSetter onfocus(IValueBinding<Object> v) {
        return setProp("onfocus", v);
    }

    public JsProp<Object> onkeydown(){
        return getProp(Object.class, "onkeydown");
    }

    public IJsPropSetter onkeydown(Object v) {
        return setProp("onkeydown", v);
    }

    public IJsPropSetter onkeydown(IValueBinding<Object> v) {
        return setProp("onkeydown", v);
    }

    public JsProp<Object> onkeypress(){
        return getProp(Object.class, "onkeypress");
    }

    public IJsPropSetter onkeypress(Object v) {
        return setProp("onkeypress", v);
    }

    public IJsPropSetter onkeypress(IValueBinding<Object> v) {
        return setProp("onkeypress", v);
    }

    public JsProp<Object> onkeyup(){
        return getProp(Object.class, "onkeyup");
    }

    public IJsPropSetter onkeyup(Object v) {
        return setProp("onkeyup", v);
    }

    public IJsPropSetter onkeyup(IValueBinding<Object> v) {
        return setProp("onkeyup", v);
    }

    public JsProp<Object> onresize(){
        return getProp(Object.class, "onresize");
    }

    public IJsPropSetter onresize(Object v) {
        return setProp("onresize", v);
    }

    public IJsPropSetter onresize(IValueBinding<Object> v) {
        return setProp("onresize", v);
    }

    public JsProp<Object> onclick(){
        return getProp(Object.class, "onclick");
    }

    public IJsPropSetter onclick(Object v) {
        return setProp("onclick", v);
    }

    public IJsPropSetter onclick(IValueBinding<Object> v) {
        return setProp("onclick", v);
    }

    public JsProp<Object> ondblclick(){
        return getProp(Object.class, "ondblclick");
    }

    public IJsPropSetter ondblclick(Object v) {
        return setProp("ondblclick", v);
    }

    public IJsPropSetter ondblclick(IValueBinding<Object> v) {
        return setProp("ondblclick", v);
    }

    public JsProp<Object> onmousedown(){
        return getProp(Object.class, "onmousedown");
    }

    public IJsPropSetter onmousedown(Object v) {
        return setProp("onmousedown", v);
    }

    public IJsPropSetter onmousedown(IValueBinding<Object> v) {
        return setProp("onmousedown", v);
    }

    public JsProp<Object> onmouseup(){
        return getProp(Object.class, "onmouseup");
    }

    public IJsPropSetter onmouseup(Object v) {
        return setProp("onmouseup", v);
    }

    public IJsPropSetter onmouseup(IValueBinding<Object> v) {
        return setProp("onmouseup", v);
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
    
    public static JsTypeRef<HTMLLabelElementJsr> prototype = new JsTypeRef<HTMLLabelElementJsr>(S);
}