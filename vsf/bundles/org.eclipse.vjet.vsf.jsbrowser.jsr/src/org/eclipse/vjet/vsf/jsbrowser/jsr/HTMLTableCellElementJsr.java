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
public class HTMLTableCellElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLTableCellElement", HTMLTableCellElementJsr.class, "HTMLTableCellElement");

    public HTMLTableCellElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLTableCellElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Integer> cellIndex(){
        return getProp(Integer.class, "cellIndex");
    }

    public IJsPropSetter cellIndex(int v) {
        return setProp("cellIndex", v);
    }

    public IJsPropSetter cellIndex(IValueBinding<Integer> v) {
        return setProp("cellIndex", v);
    }

    public JsProp<String> abbr(){
        return getProp(String.class, "abbr");
    }

    public IJsPropSetter abbr(String v) {
        return setProp("abbr", v);
    }

    public IJsPropSetter abbr(IValueBinding<String> v) {
        return setProp("abbr", v);
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

    public JsProp<String> axis(){
        return getProp(String.class, "axis");
    }

    public IJsPropSetter axis(String v) {
        return setProp("axis", v);
    }

    public IJsPropSetter axis(IValueBinding<String> v) {
        return setProp("axis", v);
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

    public JsProp<Integer> colSpan(){
        return getProp(Integer.class, "colSpan");
    }

    public IJsPropSetter colSpan(int v) {
        return setProp("colSpan", v);
    }

    public IJsPropSetter colSpan(IValueBinding<Integer> v) {
        return setProp("colSpan", v);
    }

    public JsProp<String> headers(){
        return getProp(String.class, "headers");
    }

    public IJsPropSetter headers(String v) {
        return setProp("headers", v);
    }

    public IJsPropSetter headers(IValueBinding<String> v) {
        return setProp("headers", v);
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

    public JsProp<Boolean> noWrap(){
        return getProp(Boolean.class, "noWrap");
    }

    public IJsPropSetter noWrap(boolean v) {
        return setProp("noWrap", v);
    }

    public IJsPropSetter noWrap(IValueBinding<Boolean> v) {
        return setProp("noWrap", v);
    }

    public JsProp<Integer> rowSpan(){
        return getProp(Integer.class, "rowSpan");
    }

    public IJsPropSetter rowSpan(int v) {
        return setProp("rowSpan", v);
    }

    public IJsPropSetter rowSpan(IValueBinding<Integer> v) {
        return setProp("rowSpan", v);
    }

    public JsProp<String> scope(){
        return getProp(String.class, "scope");
    }

    public IJsPropSetter scope(String v) {
        return setProp("scope", v);
    }

    public IJsPropSetter scope(IValueBinding<String> v) {
        return setProp("scope", v);
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
    
    public static JsTypeRef<HTMLTableCellElementJsr> prototype = new JsTypeRef<HTMLTableCellElementJsr>(S);
}