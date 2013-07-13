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
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLInputElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLInputElement", HTMLInputElementJsr.class, "HTMLInputElement");

    public HTMLInputElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLInputElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> defaultValue(){
        return getProp(String.class, "defaultValue");
    }

    public IJsPropSetter defaultValue(String v) {
        return setProp("defaultValue", v);
    }

    public IJsPropSetter defaultValue(IValueBinding<String> v) {
        return setProp("defaultValue", v);
    }

    public JsProp<Boolean> defaultChecked(){
        return getProp(Boolean.class, "defaultChecked");
    }

    public IJsPropSetter defaultChecked(boolean v) {
        return setProp("defaultChecked", v);
    }

    public IJsPropSetter defaultChecked(IValueBinding<Boolean> v) {
        return setProp("defaultChecked", v);
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

    public JsProp<String> accept(){
        return getProp(String.class, "accept");
    }

    public IJsPropSetter accept(String v) {
        return setProp("accept", v);
    }

    public IJsPropSetter accept(IValueBinding<String> v) {
        return setProp("accept", v);
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

    public JsProp<String> align(){
        return getProp(String.class, "align");
    }

    public IJsPropSetter align(String v) {
        return setProp("align", v);
    }

    public IJsPropSetter align(IValueBinding<String> v) {
        return setProp("align", v);
    }

    public JsProp<String> alt(){
        return getProp(String.class, "alt");
    }

    public IJsPropSetter alt(String v) {
        return setProp("alt", v);
    }

    public IJsPropSetter alt(IValueBinding<String> v) {
        return setProp("alt", v);
    }

    public JsProp<Boolean> checked(){
        return getProp(Boolean.class, "checked");
    }

    public IJsPropSetter checked(boolean v) {
        return setProp("checked", v);
    }

    public IJsPropSetter checked(IValueBinding<Boolean> v) {
        return setProp("checked", v);
    }

    public JsProp<Boolean> disabled(){
        return getProp(Boolean.class, "disabled");
    }

    public IJsPropSetter disabled(boolean v) {
        return setProp("disabled", v);
    }

    public IJsPropSetter disabled(IValueBinding<Boolean> v) {
        return setProp("disabled", v);
    }

    public JsProp<Integer> maxLength(){
        return getProp(Integer.class, "maxLength");
    }

    public IJsPropSetter maxLength(int v) {
        return setProp("maxLength", v);
    }

    public IJsPropSetter maxLength(IValueBinding<Integer> v) {
        return setProp("maxLength", v);
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

    public JsProp<Boolean> readOnly(){
        return getProp(Boolean.class, "readOnly");
    }

    public IJsPropSetter readOnly(boolean v) {
        return setProp("readOnly", v);
    }

    public IJsPropSetter readOnly(IValueBinding<Boolean> v) {
        return setProp("readOnly", v);
    }

    public JsProp<Integer> size(){
        return getProp(Integer.class, "size");
    }

    public IJsPropSetter size(int v) {
        return setProp("size", v);
    }

    public IJsPropSetter size(IValueBinding<Integer> v) {
        return setProp("size", v);
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

    public JsProp<Integer> tabIndex(){
        return getProp(Integer.class, "tabIndex");
    }

    public IJsPropSetter tabIndex(int v) {
        return setProp("tabIndex", v);
    }

    public IJsPropSetter tabIndex(IValueBinding<Integer> v) {
        return setProp("tabIndex", v);
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

    public JsProp<String> useMap(){
        return getProp(String.class, "useMap");
    }

    public IJsPropSetter useMap(String v) {
        return setProp("useMap", v);
    }

    public IJsPropSetter useMap(IValueBinding<String> v) {
        return setProp("useMap", v);
    }

    public JsProp<String> value(){
        return getProp(String.class, "value");
    }

    public IJsPropSetter value(String v) {
        return setProp("value", v);
    }

    public IJsPropSetter value(IValueBinding<String> v) {
        return setProp("value", v);
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

    public JsProp<Object> onselect(){
        return getProp(Object.class, "onselect");
    }

    public IJsPropSetter onselect(Object v) {
        return setProp("onselect", v);
    }

    public IJsPropSetter onselect(IValueBinding<Object> v) {
        return setProp("onselect", v);
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

    public JsFunc<Void> select(){
        return call("select");
    }

    public JsFunc<Void> click(){
        return call("click");
    }
    
    public static JsTypeRef<HTMLInputElementJsr> prototype = new JsTypeRef<HTMLInputElementJsr>(S);
}