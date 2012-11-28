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
public class HTMLDelElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLDelElement", HTMLDelElementJsr.class, "HTMLDelElement");

    public HTMLDelElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLDelElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> cite(){
        return getProp(String.class, "cite");
    }

    public IJsPropSetter cite(String v) {
        return setProp("cite", v);
    }

    public IJsPropSetter cite(IValueBinding<String> v) {
        return setProp("cite", v);
    }

    public JsProp<String> dateTime(){
        return getProp(String.class, "dateTime");
    }

    public IJsPropSetter dateTime(String v) {
        return setProp("dateTime", v);
    }

    public IJsPropSetter dateTime(IValueBinding<String> v) {
        return setProp("dateTime", v);
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
    
    public static JsTypeRef<HTMLDelElementJsr> prototype = new JsTypeRef<HTMLDelElementJsr>(S);
}