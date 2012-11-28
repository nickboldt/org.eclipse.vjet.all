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
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLStyleElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLStyleElement", HTMLStyleElementJsr.class, "HTMLStyleElement");

    public HTMLStyleElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLStyleElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

    public JsProp<String> media(){
        return getProp(String.class, "media");
    }

    public IJsPropSetter media(String v) {
        return setProp("media", v);
    }

    public IJsPropSetter media(IValueBinding<String> v) {
        return setProp("media", v);
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

    public JsProp<CSSStyleSheetJsr> sheet(){
        return getProp(CSSStyleSheetJsr.class, "sheet");
    }

    public IJsPropSetter sheet(CSSStyleSheetJsr v) {
        return setProp("sheet", v);
    }

    public IJsPropSetter sheet(IValueBinding<? extends CSSStyleSheetJsr> v) {
        return setProp("sheet", v);
    }
    
    public static JsTypeRef<HTMLStyleElementJsr> prototype = new JsTypeRef<HTMLStyleElementJsr>(S);
}