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
public class HTMLTableColElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLTableColElement", HTMLTableColElementJsr.class, "HTMLTableColElement");

    public HTMLTableColElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLTableColElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

    public JsProp<String> char_(){
        return getProp(String.class, "char_");
    }

    public IJsPropSetter char_(String v) {
        return setProp("char_", v);
    }

    public IJsPropSetter char_(IValueBinding<String> v) {
        return setProp("char_", v);
    }

    public JsProp<String> charoff(){
        return getProp(String.class, "charoff");
    }

    public IJsPropSetter charoff(String v) {
        return setProp("charoff", v);
    }

    public IJsPropSetter charoff(IValueBinding<String> v) {
        return setProp("charoff", v);
    }

    public JsProp<Integer> span(){
        return getProp(Integer.class, "span");
    }

    public IJsPropSetter span(int v) {
        return setProp("span", v);
    }

    public IJsPropSetter span(IValueBinding<Integer> v) {
        return setProp("span", v);
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
    
    public static JsTypeRef<HTMLTableColElementJsr> prototype = new JsTypeRef<HTMLTableColElementJsr>(S);
}