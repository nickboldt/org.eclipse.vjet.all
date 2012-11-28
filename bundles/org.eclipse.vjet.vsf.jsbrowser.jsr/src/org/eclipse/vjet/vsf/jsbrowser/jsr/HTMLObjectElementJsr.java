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
import org.eclipse.vjet.vsf.jsbrowser.jsr.DocumentJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLFormElementJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLObjectElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLObjectElement", HTMLObjectElementJsr.class, "HTMLObjectElement");

    public HTMLObjectElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLObjectElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

    public JsProp<String> code(){
        return getProp(String.class, "code");
    }

    public IJsPropSetter code(String v) {
        return setProp("code", v);
    }

    public IJsPropSetter code(IValueBinding<String> v) {
        return setProp("code", v);
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

    public JsProp<String> archive(){
        return getProp(String.class, "archive");
    }

    public IJsPropSetter archive(String v) {
        return setProp("archive", v);
    }

    public IJsPropSetter archive(IValueBinding<String> v) {
        return setProp("archive", v);
    }

    public JsProp<String> border(){
        return getProp(String.class, "border");
    }

    public IJsPropSetter border(String v) {
        return setProp("border", v);
    }

    public IJsPropSetter border(IValueBinding<String> v) {
        return setProp("border", v);
    }

    public JsProp<String> codeBase(){
        return getProp(String.class, "codeBase");
    }

    public IJsPropSetter codeBase(String v) {
        return setProp("codeBase", v);
    }

    public IJsPropSetter codeBase(IValueBinding<String> v) {
        return setProp("codeBase", v);
    }

    public JsProp<String> codeType(){
        return getProp(String.class, "codeType");
    }

    public IJsPropSetter codeType(String v) {
        return setProp("codeType", v);
    }

    public IJsPropSetter codeType(IValueBinding<String> v) {
        return setProp("codeType", v);
    }

    public JsProp<String> data(){
        return getProp(String.class, "data");
    }

    public IJsPropSetter data(String v) {
        return setProp("data", v);
    }

    public IJsPropSetter data(IValueBinding<String> v) {
        return setProp("data", v);
    }

    public JsProp<Boolean> declare(){
        return getProp(Boolean.class, "declare");
    }

    public IJsPropSetter declare(boolean v) {
        return setProp("declare", v);
    }

    public IJsPropSetter declare(IValueBinding<Boolean> v) {
        return setProp("declare", v);
    }

    public JsProp<String> height(){
        return getProp(String.class, "height");
    }

    public IJsPropSetter height(String v) {
        return setProp("height", v);
    }

    public IJsPropSetter height(IValueBinding<String> v) {
        return setProp("height", v);
    }

    public JsProp<Integer> hspace(){
        return getProp(Integer.class, "hspace");
    }

    public IJsPropSetter hspace(int v) {
        return setProp("hspace", v);
    }

    public IJsPropSetter hspace(IValueBinding<Integer> v) {
        return setProp("hspace", v);
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

    public JsProp<String> standby(){
        return getProp(String.class, "standby");
    }

    public IJsPropSetter standby(String v) {
        return setProp("standby", v);
    }

    public IJsPropSetter standby(IValueBinding<String> v) {
        return setProp("standby", v);
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

    public JsProp<Integer> vspace(){
        return getProp(Integer.class, "vspace");
    }

    public IJsPropSetter vspace(int v) {
        return setProp("vspace", v);
    }

    public IJsPropSetter vspace(IValueBinding<Integer> v) {
        return setProp("vspace", v);
    }

    public JsProp<String> width(){
        return getProp(String.class, "width");
    }

    public IJsPropSetter width(String v) {
        return setProp("width", v);
    }

    public IJsPropSetter width(IValueBinding<String> v) {
        return setProp("width", v);
    }

    public JsProp<DocumentJsr> contentDocument(){
        return getProp(DocumentJsr.class, "contentDocument");
    }

    public IJsPropSetter contentDocument(DocumentJsr v) {
        return setProp("contentDocument", v);
    }

    public IJsPropSetter contentDocument(IValueBinding<? extends DocumentJsr> v) {
        return setProp("contentDocument", v);
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
    
    public static JsTypeRef<HTMLObjectElementJsr> prototype = new JsTypeRef<HTMLObjectElementJsr>(S);
}