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
public class HTMLEmbedElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLEmbedElement", HTMLEmbedElementJsr.class, "HTMLEmbedElement");

    public HTMLEmbedElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLEmbedElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

    public JsProp<String> align(){
        return getProp(String.class, "align");
    }

    public IJsPropSetter align(String v) {
        return setProp("align", v);
    }

    public IJsPropSetter align(IValueBinding<String> v) {
        return setProp("align", v);
    }

    public JsProp<String> atomicSelection(){
        return getProp(String.class, "atomicSelection");
    }

    public IJsPropSetter atomicSelection(String v) {
        return setProp("atomicSelection", v);
    }

    public IJsPropSetter atomicSelection(IValueBinding<String> v) {
        return setProp("atomicSelection", v);
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

    public JsProp<String> hidden(){
        return getProp(String.class, "hidden");
    }

    public IJsPropSetter hidden(String v) {
        return setProp("hidden", v);
    }

    public IJsPropSetter hidden(IValueBinding<String> v) {
        return setProp("hidden", v);
    }

    public JsProp<String> hideFocus(){
        return getProp(String.class, "hideFocus");
    }

    public IJsPropSetter hideFocus(String v) {
        return setProp("hideFocus", v);
    }

    public IJsPropSetter hideFocus(IValueBinding<String> v) {
        return setProp("hideFocus", v);
    }

    public JsProp<String> language(){
        return getProp(String.class, "language");
    }

    public IJsPropSetter language(String v) {
        return setProp("language", v);
    }

    public IJsPropSetter language(IValueBinding<String> v) {
        return setProp("language", v);
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

    public JsProp<String> pluginsPage(){
        return getProp(String.class, "pluginsPage");
    }

    public IJsPropSetter pluginsPage(String v) {
        return setProp("pluginsPage", v);
    }

    public IJsPropSetter pluginsPage(IValueBinding<String> v) {
        return setProp("pluginsPage", v);
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

    public JsProp<String> type(){
        return getProp(String.class, "type");
    }

    public IJsPropSetter type(String v) {
        return setProp("type", v);
    }

    public IJsPropSetter type(IValueBinding<String> v) {
        return setProp("type", v);
    }

    public JsProp<String> units(){
        return getProp(String.class, "units");
    }

    public IJsPropSetter units(String v) {
        return setProp("units", v);
    }

    public IJsPropSetter units(IValueBinding<String> v) {
        return setProp("units", v);
    }

    public JsProp<String> unselectable(){
        return getProp(String.class, "unselectable");
    }

    public IJsPropSetter unselectable(String v) {
        return setProp("unselectable", v);
    }

    public IJsPropSetter unselectable(IValueBinding<String> v) {
        return setProp("unselectable", v);
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
    
    public static JsTypeRef<HTMLEmbedElementJsr> prototype = new JsTypeRef<HTMLEmbedElementJsr>(S);
}