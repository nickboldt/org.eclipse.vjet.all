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
public class HTMLFontElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLFontElement", HTMLFontElementJsr.class, "HTMLFontElement");

    public HTMLFontElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLFontElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> color(){
        return getProp(String.class, "color");
    }

    public IJsPropSetter color(String v) {
        return setProp("color", v);
    }

    public IJsPropSetter color(IValueBinding<String> v) {
        return setProp("color", v);
    }

    public JsProp<String> face(){
        return getProp(String.class, "face");
    }

    public IJsPropSetter face(String v) {
        return setProp("face", v);
    }

    public IJsPropSetter face(IValueBinding<String> v) {
        return setProp("face", v);
    }

    public JsProp<String> size(){
        return getProp(String.class, "size");
    }

    public IJsPropSetter size(String v) {
        return setProp("size", v);
    }

    public IJsPropSetter size(IValueBinding<String> v) {
        return setProp("size", v);
    }
    
    public static JsTypeRef<HTMLFontElementJsr> prototype = new JsTypeRef<HTMLFontElementJsr>(S);
}