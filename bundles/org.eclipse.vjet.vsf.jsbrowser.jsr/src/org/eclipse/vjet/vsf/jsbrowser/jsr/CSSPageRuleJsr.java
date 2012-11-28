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
import org.eclipse.vjet.vsf.jsbrowser.jsr.CSSRuleJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.CSSStyleDeclarationJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class CSSPageRuleJsr extends CSSRuleJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("CSSPageRule", CSSPageRuleJsr.class, "CSSPageRule");

    public CSSPageRuleJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected CSSPageRuleJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> selectorText(){
        return getProp(String.class, "selectorText");
    }

    public IJsPropSetter selectorText(String v) {
        return setProp("selectorText", v);
    }

    public IJsPropSetter selectorText(IValueBinding<String> v) {
        return setProp("selectorText", v);
    }

    public JsProp<CSSStyleDeclarationJsr> style(){
        return getProp(CSSStyleDeclarationJsr.class, "style");
    }

    public IJsPropSetter style(CSSStyleDeclarationJsr v) {
        return setProp("style", v);
    }

    public IJsPropSetter style(IValueBinding<? extends CSSStyleDeclarationJsr> v) {
        return setProp("style", v);
    }
    
    public static JsTypeRef<CSSPageRuleJsr> prototype = new JsTypeRef<CSSPageRuleJsr>(S);
}