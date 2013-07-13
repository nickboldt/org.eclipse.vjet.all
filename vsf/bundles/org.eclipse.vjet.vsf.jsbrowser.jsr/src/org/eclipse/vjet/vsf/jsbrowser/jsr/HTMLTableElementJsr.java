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
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLTableCaptionElementJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLTableRowElementJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLTableSectionElementJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLTableElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLTableElement", HTMLTableElementJsr.class, "HTMLTableElement");

    public HTMLTableElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLTableElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<HTMLTableCaptionElementJsr> caption(){
        return getProp(HTMLTableCaptionElementJsr.class, "caption");
    }

    public IJsPropSetter caption(HTMLTableCaptionElementJsr v) {
        return setProp("caption", v);
    }

    public IJsPropSetter caption(IValueBinding<? extends HTMLTableCaptionElementJsr> v) {
        return setProp("caption", v);
    }

    public JsProp<HTMLTableSectionElementJsr> tHead(){
        return getProp(HTMLTableSectionElementJsr.class, "tHead");
    }

    public IJsPropSetter tHead(HTMLTableSectionElementJsr v) {
        return setProp("tHead", v);
    }

    public IJsPropSetter tHead(IValueBinding<? extends HTMLTableSectionElementJsr> v) {
        return setProp("tHead", v);
    }

    public JsProp<HTMLTableSectionElementJsr> tFoot(){
        return getProp(HTMLTableSectionElementJsr.class, "tFoot");
    }

    public IJsPropSetter tFoot(HTMLTableSectionElementJsr v) {
        return setProp("tFoot", v);
    }

    public IJsPropSetter tFoot(IValueBinding<? extends HTMLTableSectionElementJsr> v) {
        return setProp("tFoot", v);
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

    public JsProp<HTMLCollectionJsr> tBodies(){
        return getProp(HTMLCollectionJsr.class, "tBodies");
    }

    public IJsPropSetter tBodies(HTMLCollectionJsr v) {
        return setProp("tBodies", v);
    }

    public IJsPropSetter tBodies(IValueBinding<? extends HTMLCollectionJsr> v) {
        return setProp("tBodies", v);
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

    public JsProp<String> bgColor(){
        return getProp(String.class, "bgColor");
    }

    public IJsPropSetter bgColor(String v) {
        return setProp("bgColor", v);
    }

    public IJsPropSetter bgColor(IValueBinding<String> v) {
        return setProp("bgColor", v);
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

    public JsProp<String> cellPadding(){
        return getProp(String.class, "cellPadding");
    }

    public IJsPropSetter cellPadding(String v) {
        return setProp("cellPadding", v);
    }

    public IJsPropSetter cellPadding(IValueBinding<String> v) {
        return setProp("cellPadding", v);
    }

    public JsProp<String> cellSpacing(){
        return getProp(String.class, "cellSpacing");
    }

    public IJsPropSetter cellSpacing(String v) {
        return setProp("cellSpacing", v);
    }

    public IJsPropSetter cellSpacing(IValueBinding<String> v) {
        return setProp("cellSpacing", v);
    }

    public JsProp<String> frame(){
        return getProp(String.class, "frame");
    }

    public IJsPropSetter frame(String v) {
        return setProp("frame", v);
    }

    public IJsPropSetter frame(IValueBinding<String> v) {
        return setProp("frame", v);
    }

    public JsProp<String> rules(){
        return getProp(String.class, "rules");
    }

    public IJsPropSetter rules(String v) {
        return setProp("rules", v);
    }

    public IJsPropSetter rules(IValueBinding<String> v) {
        return setProp("rules", v);
    }

    public JsProp<String> summary(){
        return getProp(String.class, "summary");
    }

    public IJsPropSetter summary(String v) {
        return setProp("summary", v);
    }

    public IJsPropSetter summary(IValueBinding<String> v) {
        return setProp("summary", v);
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

    public JsFunc<? extends HTMLTableSectionElementJsr> createTHead(){
        return call(HTMLTableSectionElementJsr.class, "createTHead");
    }

    public JsFunc<Void> deleteTHead(){
        return call("deleteTHead");
    }

    public JsFunc<? extends HTMLTableSectionElementJsr> createTBody(){
        return call(HTMLTableSectionElementJsr.class, "createTBody");
    }

    public JsFunc<Void> deleteTBody(){
        return call("deleteTBody");
    }

    public JsFunc<? extends HTMLTableSectionElementJsr> createTFoot(){
        return call(HTMLTableSectionElementJsr.class, "createTFoot");
    }

    public JsFunc<Void> deleteTFoot(){
        return call("deleteTFoot");
    }

    public JsFunc<? extends HTMLTableCaptionElementJsr> createCaption(){
        return call(HTMLTableCaptionElementJsr.class, "createCaption");
    }

    public JsFunc<Void> deleteCaption(){
        return call("deleteCaption");
    }

    public JsFunc<? extends HTMLTableRowElementJsr> insertRow(int index){
        return call(HTMLTableRowElementJsr.class, "insertRow").with(index);
    }

    public JsFunc<? extends HTMLTableRowElementJsr> insertRow(IValueBinding<Integer> index){
        return call(HTMLTableRowElementJsr.class, "insertRow").with(index);
    }

    public JsFunc<Void> deleteRow(int index){
        return call("deleteRow").with(index);
    }

    public JsFunc<Void> deleteRow(IValueBinding<Integer> index){
        return call("deleteRow").with(index);
    }
    
    public static JsTypeRef<HTMLTableElementJsr> prototype = new JsTypeRef<HTMLTableElementJsr>(S);
}