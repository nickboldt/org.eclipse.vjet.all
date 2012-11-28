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
public class HTMLMetaElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLMetaElement", HTMLMetaElementJsr.class, "HTMLMetaElement");

    public HTMLMetaElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLMetaElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> content(){
        return getProp(String.class, "content");
    }

    public IJsPropSetter content(String v) {
        return setProp("content", v);
    }

    public IJsPropSetter content(IValueBinding<String> v) {
        return setProp("content", v);
    }

    public JsProp<String> httpEquiv(){
        return getProp(String.class, "httpEquiv");
    }

    public IJsPropSetter httpEquiv(String v) {
        return setProp("httpEquiv", v);
    }

    public IJsPropSetter httpEquiv(IValueBinding<String> v) {
        return setProp("httpEquiv", v);
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

    public JsProp<String> scheme(){
        return getProp(String.class, "scheme");
    }

    public IJsPropSetter scheme(String v) {
        return setProp("scheme", v);
    }

    public IJsPropSetter scheme(IValueBinding<String> v) {
        return setProp("scheme", v);
    }
    
    public static JsTypeRef<HTMLMetaElementJsr> prototype = new JsTypeRef<HTMLMetaElementJsr>(S);
}