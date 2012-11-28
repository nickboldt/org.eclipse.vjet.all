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
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLDocumentJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLIFrameElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLIFrameElement", HTMLIFrameElementJsr.class, "HTMLIFrameElement");

    public HTMLIFrameElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLIFrameElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

    public JsProp<Object> frameBorder(){
        return getProp(Object.class, "frameBorder");
    }

    public IJsPropSetter frameBorder(Object v) {
        return setProp("frameBorder", v);
    }

    public IJsPropSetter frameBorder(IValueBinding<Object> v) {
        return setProp("frameBorder", v);
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

    public JsProp<String> longDesc(){
        return getProp(String.class, "longDesc");
    }

    public IJsPropSetter longDesc(String v) {
        return setProp("longDesc", v);
    }

    public IJsPropSetter longDesc(IValueBinding<String> v) {
        return setProp("longDesc", v);
    }

    public JsProp<String> marginHeight(){
        return getProp(String.class, "marginHeight");
    }

    public IJsPropSetter marginHeight(String v) {
        return setProp("marginHeight", v);
    }

    public IJsPropSetter marginHeight(IValueBinding<String> v) {
        return setProp("marginHeight", v);
    }

    public JsProp<String> marginWidth(){
        return getProp(String.class, "marginWidth");
    }

    public IJsPropSetter marginWidth(String v) {
        return setProp("marginWidth", v);
    }

    public IJsPropSetter marginWidth(IValueBinding<String> v) {
        return setProp("marginWidth", v);
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

    public JsProp<String> scrolling(){
        return getProp(String.class, "scrolling");
    }

    public IJsPropSetter scrolling(String v) {
        return setProp("scrolling", v);
    }

    public IJsPropSetter scrolling(IValueBinding<String> v) {
        return setProp("scrolling", v);
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

    public JsProp<String> width(){
        return getProp(String.class, "width");
    }

    public IJsPropSetter width(String v) {
        return setProp("width", v);
    }

    public IJsPropSetter width(IValueBinding<String> v) {
        return setProp("width", v);
    }

    public JsProp<HTMLDocumentJsr> contentDocument(){
        return getProp(HTMLDocumentJsr.class, "contentDocument");
    }

    public IJsPropSetter contentDocument(HTMLDocumentJsr v) {
        return setProp("contentDocument", v);
    }

    public IJsPropSetter contentDocument(IValueBinding<? extends HTMLDocumentJsr> v) {
        return setProp("contentDocument", v);
    }

    public JsProp<HTMLDocumentJsr> document(){
        return getProp(HTMLDocumentJsr.class, "document");
    }

    public IJsPropSetter document(HTMLDocumentJsr v) {
        return setProp("document", v);
    }

    public IJsPropSetter document(IValueBinding<? extends HTMLDocumentJsr> v) {
        return setProp("document", v);
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
    
    public static JsTypeRef<HTMLIFrameElementJsr> prototype = new JsTypeRef<HTMLIFrameElementJsr>(S);
}