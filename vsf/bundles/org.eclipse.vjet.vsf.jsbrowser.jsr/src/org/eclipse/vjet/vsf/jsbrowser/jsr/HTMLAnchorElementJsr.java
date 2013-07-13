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
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLAnchorElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLAnchorElement", HTMLAnchorElementJsr.class, "HTMLAnchorElement");

    public HTMLAnchorElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLAnchorElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

    public JsProp<String> charset(){
        return getProp(String.class, "charset");
    }

    public IJsPropSetter charset(String v) {
        return setProp("charset", v);
    }

    public IJsPropSetter charset(IValueBinding<String> v) {
        return setProp("charset", v);
    }

    public JsProp<String> coords(){
        return getProp(String.class, "coords");
    }

    public IJsPropSetter coords(String v) {
        return setProp("coords", v);
    }

    public IJsPropSetter coords(IValueBinding<String> v) {
        return setProp("coords", v);
    }

    public JsProp<String> href(){
        return getProp(String.class, "href");
    }

    public IJsPropSetter href(String v) {
        return setProp("href", v);
    }

    public IJsPropSetter href(IValueBinding<String> v) {
        return setProp("href", v);
    }

    public JsProp<String> hreflang(){
        return getProp(String.class, "hreflang");
    }

    public IJsPropSetter hreflang(String v) {
        return setProp("hreflang", v);
    }

    public IJsPropSetter hreflang(IValueBinding<String> v) {
        return setProp("hreflang", v);
    }

    public JsProp<String> name(){
        return getProp(String.class, "name");
    }

    public IJsPropSetter name(String v) {
        return setProp("name", v);
    }

    public IJsPropSetter name(IValueBinding<String> v) {
        return setProp("name", v);
    }

    public JsProp<String> rel(){
        return getProp(String.class, "rel");
    }

    public IJsPropSetter rel(String v) {
        return setProp("rel", v);
    }

    public IJsPropSetter rel(IValueBinding<String> v) {
        return setProp("rel", v);
    }

    public JsProp<String> rev(){
        return getProp(String.class, "rev");
    }

    public IJsPropSetter rev(String v) {
        return setProp("rev", v);
    }

    public IJsPropSetter rev(IValueBinding<String> v) {
        return setProp("rev", v);
    }

    public JsProp<String> shape(){
        return getProp(String.class, "shape");
    }

    public IJsPropSetter shape(String v) {
        return setProp("shape", v);
    }

    public IJsPropSetter shape(IValueBinding<String> v) {
        return setProp("shape", v);
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

    public JsProp<String> target(){
        return getProp(String.class, "target");
    }

    public IJsPropSetter target(String v) {
        return setProp("target", v);
    }

    public IJsPropSetter target(IValueBinding<String> v) {
        return setProp("target", v);
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

    public JsFunc<Void> blur(){
        return call("blur");
    }

    public JsFunc<Void> focus(){
        return call("focus");
    }
    
    public static JsTypeRef<HTMLAnchorElementJsr> prototype = new JsTypeRef<HTMLAnchorElementJsr>(S);
}