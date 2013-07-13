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
public class ComparisonJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.utils.Comparison", ComparisonJsr.class, "Comparison");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public ComparisonJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ComparisonJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Boolean> has(String pSrc, String pStr){
        return call(S, Boolean.class, "has").with(pSrc, pStr);
    }

    public static JsFunc<Boolean> has(IValueBinding<String> pSrc, IValueBinding<String> pStr){
        return call(S, Boolean.class, "has").with(pSrc, pStr);
    }

    public static JsFunc<Boolean> hasArg(String pSrc, String pArg){
        return call(S, Boolean.class, "hasArg").with(pSrc, pArg);
    }

    public static JsFunc<Boolean> hasArg(IValueBinding<String> pSrc, IValueBinding<String> pArg){
        return call(S, Boolean.class, "hasArg").with(pSrc, pArg);
    }

    public static JsFunc<Boolean> hasAny(String pSrc, String... p1){
        return call(S, Boolean.class, "hasAny").with(pSrc, p1);
    }

    public static JsFunc<Boolean> hasAny(IValueBinding<String> pSrc, IValueBinding<String>... p1){
        return call(S, Boolean.class, "hasAny").with(pSrc, p1);
    }

    public static JsFunc<Boolean> hasAll(String pSrc, String... p1){
        return call(S, Boolean.class, "hasAll").with(pSrc, p1);
    }

    public static JsFunc<Boolean> hasAll(IValueBinding<String> pSrc, IValueBinding<String>... p1){
        return call(S, Boolean.class, "hasAll").with(pSrc, p1);
    }

    public static JsFunc<Boolean> is(String pSrc, String pTarget){
        return call(S, Boolean.class, "is").with(pSrc, pTarget);
    }

    public static JsFunc<Boolean> is(IValueBinding<String> pSrc, IValueBinding<String> pTarget){
        return call(S, Boolean.class, "is").with(pSrc, pTarget);
    }

    public static JsFunc<Boolean> isAny(String pSrc, String... p1){
        return call(S, Boolean.class, "isAny").with(pSrc, p1);
    }

    public static JsFunc<Boolean> isAny(IValueBinding<String> pSrc, IValueBinding<String>... p1){
        return call(S, Boolean.class, "isAny").with(pSrc, p1);
    }
    
    public static JsTypeRef<ComparisonJsr> prototype = new JsTypeRef<ComparisonJsr>(S);
}