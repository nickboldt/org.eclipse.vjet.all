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
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLCollectionJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLTableSectionElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLTableSectionElement", HTMLTableSectionElementJsr.class, "HTMLTableSectionElement");

    public HTMLTableSectionElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLTableSectionElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
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

    public JsProp<String> ch(){
        return getProp(String.class, "ch");
    }

    public IJsPropSetter ch(String v) {
        return setProp("ch", v);
    }

    public IJsPropSetter ch(IValueBinding<String> v) {
        return setProp("ch", v);
    }

    public JsProp<String> chOff(){
        return getProp(String.class, "chOff");
    }

    public IJsPropSetter chOff(String v) {
        return setProp("chOff", v);
    }

    public IJsPropSetter chOff(IValueBinding<String> v) {
        return setProp("chOff", v);
    }

    public JsProp<String> vAlign(){
        return getProp(String.class, "vAlign");
    }

    public IJsPropSetter vAlign(String v) {
        return setProp("vAlign", v);
    }

    public IJsPropSetter vAlign(IValueBinding<String> v) {
        return setProp("vAlign", v);
    }

    public JsProp<HTMLCollectionJsr> rows(){
        return getProp(HTMLCollectionJsr.class, "rows");
    }

    public IJsPropSetter rows(HTMLCollectionJsr v) {
        return setProp("rows", v);
    }

    public IJsPropSetter rows(IValueBinding<? extends HTMLCollectionJsr> v) {
        return setProp("rows", v);
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

    public JsFunc<? extends HTMLElementJsr> insertRow(int index){
        return call(HTMLElementJsr.class, "insertRow").with(index);
    }

    public JsFunc<? extends HTMLElementJsr> insertRow(IValueBinding<Integer> index){
        return call(HTMLElementJsr.class, "insertRow").with(index);
    }

    public JsFunc<Void> deleteRow(int index){
        return call("deleteRow").with(index);
    }

    public JsFunc<Void> deleteRow(IValueBinding<Integer> index){
        return call("deleteRow").with(index);
    }
    
    public static JsTypeRef<HTMLTableSectionElementJsr> prototype = new JsTypeRef<HTMLTableSectionElementJsr>(S);
}