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
public class HTMLAppletElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLAppletElement", HTMLAppletElementJsr.class, "HTMLAppletElement");

    public HTMLAppletElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLAppletElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

    public JsProp<String> alt(){
        return getProp(String.class, "alt");
    }

    public IJsPropSetter alt(String v) {
        return setProp("alt", v);
    }

    public IJsPropSetter alt(IValueBinding<String> v) {
        return setProp("alt", v);
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

    public JsProp<String> code(){
        return getProp(String.class, "code");
    }

    public IJsPropSetter code(String v) {
        return setProp("code", v);
    }

    public IJsPropSetter code(IValueBinding<String> v) {
        return setProp("code", v);
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

    public JsProp<String> object(){
        return getProp(String.class, "object");
    }

    public IJsPropSetter object(String v) {
        return setProp("object", v);
    }

    public IJsPropSetter object(IValueBinding<String> v) {
        return setProp("object", v);
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
    
    public static JsTypeRef<HTMLAppletElementJsr> prototype = new JsTypeRef<HTMLAppletElementJsr>(S);
}