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
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class CSSRuleJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("CSSRule", CSSRuleJsr.class, "CSSRule");

    public CSSRuleJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected CSSRuleJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Integer> type(){
        return getProp(Integer.class, "type");
    }

    public IJsPropSetter type(int v) {
        return setProp("type", v);
    }

    public IJsPropSetter type(IValueBinding<Integer> v) {
        return setProp("type", v);
    }

    public JsProp<String> cssText(){
        return getProp(String.class, "cssText");
    }

    public IJsPropSetter cssText(String v) {
        return setProp("cssText", v);
    }

    public IJsPropSetter cssText(IValueBinding<String> v) {
        return setProp("cssText", v);
    }

    public JsProp<CSSStyleSheetJsr> parentStyleSheet(){
        return getProp(CSSStyleSheetJsr.class, "parentStyleSheet");
    }

    public IJsPropSetter parentStyleSheet(CSSStyleSheetJsr v) {
        return setProp("parentStyleSheet", v);
    }

    public IJsPropSetter parentStyleSheet(IValueBinding<? extends CSSStyleSheetJsr> v) {
        return setProp("parentStyleSheet", v);
    }

    public JsProp<CSSRuleJsr> parentRule(){
        return getProp(CSSRuleJsr.class, "parentRule");
    }

    public IJsPropSetter parentRule(CSSRuleJsr v) {
        return setProp("parentRule", v);
    }

    public IJsPropSetter parentRule(IValueBinding<? extends CSSRuleJsr> v) {
        return setProp("parentRule", v);
    }
    
    public static JsTypeRef<CSSRuleJsr> prototype = new JsTypeRef<CSSRuleJsr>(S);
}