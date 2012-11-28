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
package org.eclipse.vjet.vsf.utils;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class CurrencyJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.utils.Currency", CurrencyJsr.class, "Currency");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public CurrencyJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected CurrencyJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Float> parse(String psVal, boolean pbNonDecimal){
        return call(S, Float.class, "parse").with(psVal, pbNonDecimal);
    }

    public static JsFunc<Float> parse(IValueBinding<String> psVal, IValueBinding<Boolean> pbNonDecimal){
        return call(S, Float.class, "parse").with(psVal, checkS(pbNonDecimal));
    }

    public static JsFunc<Float> round(String psVal, int pNoofDec){
        return call(S, Float.class, "round").with(psVal, pNoofDec);
    }

    public static JsFunc<Float> round(IValueBinding<String> psVal, IValueBinding<Integer> pNoofDec){
        return call(S, Float.class, "round").with(psVal, pNoofDec);
    }

    public static JsFunc<String> format(String psVal, boolean pbNonDecimal, boolean pVATExempt){
        return call(S, String.class, "format").with(psVal, pbNonDecimal, pVATExempt);
    }

    public static JsFunc<String> format(IValueBinding<String> psVal, IValueBinding<Boolean> pbNonDecimal, IValueBinding<Boolean> pVATExempt){
        return call(S, String.class, "format").with(psVal, checkS(pbNonDecimal), checkS(pVATExempt));
    }

    public static JsFunc<Boolean> isDecimalFormat(String psVal){
        return call(S, Boolean.class, "isDecimalFormat").with(psVal);
    }

    public static JsFunc<Boolean> isDecimalFormat(IValueBinding<String> psVal){
        return call(S, Boolean.class, "isDecimalFormat").with(psVal);
    }

    public static JsFunc<String> toIntlFormat(String psVal){
        return call(S, String.class, "toIntlFormat").with(psVal);
    }

    public static JsFunc<String> toIntlFormat(IValueBinding<String> psVal){
        return call(S, String.class, "toIntlFormat").with(psVal);
    }
    
    public static JsTypeRef<CurrencyJsr> prototype = new JsTypeRef<CurrencyJsr>(S);
}