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
public class ImageJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("Image", ImageJsr.class, "Image");

    public ImageJsr(int width){
        super(S.getJsCmpMeta(), true, width);
    }

    public ImageJsr(IValueBinding<Integer> width){
        super(S.getJsCmpMeta(), true, width);
    }

    public ImageJsr(int width, int height){
        super(S.getJsCmpMeta(), true, width, height);
    }

    public ImageJsr(IValueBinding<Integer> width, IValueBinding<Integer> height){
        super(S.getJsCmpMeta(), true, width, height);
    }

    public ImageJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ImageJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
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

    public JsProp<Boolean> complete(){
        return getProp(Boolean.class, "complete");
    }

    public IJsPropSetter complete(boolean v) {
        return setProp("complete", v);
    }

    public IJsPropSetter complete(IValueBinding<Boolean> v) {
        return setProp("complete", v);
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

    public JsProp<String> border(){
        return getProp(String.class, "border");
    }

    public IJsPropSetter border(String v) {
        return setProp("border", v);
    }

    public IJsPropSetter border(IValueBinding<String> v) {
        return setProp("border", v);
    }

    public JsProp<Integer> height(){
        return getProp(Integer.class, "height");
    }

    public IJsPropSetter height(int v) {
        return setProp("height", v);
    }

    public IJsPropSetter height(IValueBinding<Integer> v) {
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

    public JsProp<Boolean> isMap(){
        return getProp(Boolean.class, "isMap");
    }

    public IJsPropSetter isMap(boolean v) {
        return setProp("isMap", v);
    }

    public IJsPropSetter isMap(IValueBinding<Boolean> v) {
        return setProp("isMap", v);
    }

    public JsProp<String> longDesc(){
        return getProp(String.class, "longDesc");
    }

    public IJsPropSetter longDesc(String v) {
        return setProp("longDesc", v);
    }

    public IJsPropSetter longDesc(IValueBinding<String> v) {
        return setProp("longDesc", v);
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

    public JsProp<Integer> width(){
        return getProp(Integer.class, "width");
    }

    public IJsPropSetter width(int v) {
        return setProp("width", v);
    }

    public IJsPropSetter width(IValueBinding<Integer> v) {
        return setProp("width", v);
    }

    public JsProp<String> lowsrc(){
        return getProp(String.class, "lowsrc");
    }

    public IJsPropSetter lowsrc(String v) {
        return setProp("lowsrc", v);
    }

    public IJsPropSetter lowsrc(IValueBinding<String> v) {
        return setProp("lowsrc", v);
    }

    public JsProp<Integer> clientWidth(){
        return getProp(Integer.class, "clientWidth");
    }

    public IJsPropSetter clientWidth(int v) {
        return setProp("clientWidth", v);
    }

    public IJsPropSetter clientWidth(IValueBinding<Integer> v) {
        return setProp("clientWidth", v);
    }

    public JsProp<Integer> clientHeight(){
        return getProp(Integer.class, "clientHeight");
    }

    public IJsPropSetter clientHeight(int v) {
        return setProp("clientHeight", v);
    }

    public IJsPropSetter clientHeight(IValueBinding<Integer> v) {
        return setProp("clientHeight", v);
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

    public JsProp<Object> onabort(){
        return getProp(Object.class, "onabort");
    }

    public IJsPropSetter onabort(Object v) {
        return setProp("onabort", v);
    }

    public IJsPropSetter onabort(IValueBinding<Object> v) {
        return setProp("onabort", v);
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
    
    public static JsTypeRef<ImageJsr> prototype = new JsTypeRef<ImageJsr>(S);
}