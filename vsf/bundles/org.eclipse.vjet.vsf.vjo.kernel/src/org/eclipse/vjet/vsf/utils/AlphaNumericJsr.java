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
import org.eclipse.vjet.vsf.typeextensions.number.DecimalToHexJsr;
import org.eclipse.vjet.vsf.typeextensions.string.ComparisonJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class AlphaNumericJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.utils.AlphaNumeric", AlphaNumericJsr.class, "AlphaNumeric");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(ComparisonJsr.ResourceSpec.getInstance())
        .addDependentComponent(DecimalToHexJsr.ResourceSpec.getInstance());

    public AlphaNumericJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected AlphaNumericJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Boolean> isUpper(String psStr){
        return call(S, Boolean.class, "isUpper").with(psStr);
    }

    public static JsFunc<Boolean> isUpper(IValueBinding<String> psStr){
        return call(S, Boolean.class, "isUpper").with(psStr);
    }

    public static JsFunc<Boolean> isLower(String psStr){
        return call(S, Boolean.class, "isLower").with(psStr);
    }

    public static JsFunc<Boolean> isLower(IValueBinding<String> psStr){
        return call(S, Boolean.class, "isLower").with(psStr);
    }

    public static JsFunc<Boolean> isAlpha(String psStr){
        return call(S, Boolean.class, "isAlpha").with(psStr);
    }

    public static JsFunc<Boolean> isAlpha(IValueBinding<String> psStr){
        return call(S, Boolean.class, "isAlpha").with(psStr);
    }

    public static JsFunc<Boolean> isNumeric(String psStr){
        return call(S, Boolean.class, "isNumeric").with(psStr);
    }

    public static JsFunc<Boolean> isNumeric(IValueBinding<String> psStr){
        return call(S, Boolean.class, "isNumeric").with(psStr);
    }

    public static JsFunc<Boolean> isAlphaNumeric(String psStr, String pExceptions){
        return call(S, Boolean.class, "isAlphaNumeric").with(psStr, pExceptions);
    }

    public static JsFunc<Boolean> isAlphaNumeric(IValueBinding<String> psStr, IValueBinding<String> pExceptions){
        return call(S, Boolean.class, "isAlphaNumeric").with(psStr, pExceptions);
    }
    
    public static JsTypeRef<AlphaNumericJsr> prototype = new JsTypeRef<AlphaNumericJsr>(S);
}