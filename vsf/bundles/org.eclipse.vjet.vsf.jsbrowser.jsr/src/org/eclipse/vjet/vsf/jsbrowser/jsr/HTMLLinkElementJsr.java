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
import org.eclipse.vjet.vsf.jsbrowser.jsr.CSSStyleSheetJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementStyleJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLLinkElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLLinkElement", HTMLLinkElementJsr.class, "HTMLLinkElement");

    public HTMLLinkElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLLinkElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
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

    public JsProp<String> charset(){
        return getProp(String.class, "charset");
    }

    public IJsPropSetter charset(String v) {
        return setProp("charset", v);
    }

    public IJsPropSetter charset(IValueBinding<String> v) {
        return setProp("charset", v);
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

    public JsProp<String> media(){
        return getProp(String.class, "media");
    }

    public IJsPropSetter media(String v) {
        return setProp("media", v);
    }

    public IJsPropSetter media(IValueBinding<String> v) {
        return setProp("media", v);
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

    public JsProp<CSSStyleSheetJsr> styleSheet(){
        return getProp(CSSStyleSheetJsr.class, "styleSheet");
    }

    public IJsPropSetter styleSheet(CSSStyleSheetJsr v) {
        return setProp("styleSheet", v);
    }

    public IJsPropSetter styleSheet(IValueBinding<? extends CSSStyleSheetJsr> v) {
        return setProp("styleSheet", v);
    }

    public JsProp<HTMLElementStyleJsr> sheet(){
        return getProp(HTMLElementStyleJsr.class, "sheet");
    }

    public IJsPropSetter sheet(HTMLElementStyleJsr v) {
        return setProp("sheet", v);
    }

    public IJsPropSetter sheet(IValueBinding<? extends HTMLElementStyleJsr> v) {
        return setProp("sheet", v);
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
    
    public static JsTypeRef<HTMLLinkElementJsr> prototype = new JsTypeRef<HTMLLinkElementJsr>(S);
}