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
//package vjo.dsf.utils;
//
//import org.eclipse.vjet.vsf.jsref.JsFunc;
//import org.eclipse.vjet.dsf.common.binding.IValueBinding;
//import org.eclipse.vjet.vsf.jsref.JsObj;
//import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
//import org.eclipse.vjet.vsf.jsref.JsTypeRef;
//import org.eclipse.vjet.vsf.jsref.JsObjData;
//import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
//import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
//import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
//import vjo.dsf.cookie.VjCookieJarJsr;
//
//@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
//public class BitJsr extends JsObj {
//    private static final long serialVersionUID = 1L;
//
//    private static final JsObjData S = 
//        new JsObjData("vjo.dsf.utils.Bit", BitJsr.class, "Bit");
//
//    
//    public static class ResourceSpec {
//        public static IComponentSpec getInstance() {
//            return S.getResourceSpec(); 
//        }
//        public static final JsResource RESOURCE = S.getJsResource();
//        public static final IJsResourceRef REF = S.getJsResourceRef();
//    }
//
//    public static final IComponentSpec SPEC = S.getResourceSpec()
//        .addDependentComponent(VjCookieJarJsr.ResourceSpec.getInstance());
//
//    public BitJsr(){
//        super(S.getJsCmpMeta(), true);
//    }
//
//    protected BitJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
//        super(cmpMeta, isInstance, args);
//    }
//
//    public static JsFunc<Integer> getMulti(String piDec, int piPos, int piBits){
//        return call(S, Integer.class, "getMulti").with(piDec, piPos, piBits);
//    }
//
//    public static JsFunc<Integer> getMulti(IValueBinding<String> piDec, IValueBinding<Integer> piPos, IValueBinding<Integer> piBits){
//        return call(S, Integer.class, "getMulti").with(piDec, piPos, piBits);
//    }
//
//    public static JsFunc<String> setMulti(String piDec, int piPos, int piBits, Number piVal){
//        return call(S, String.class, "setMulti").with(piDec, piPos, piBits, piVal);
//    }
//
//    public static JsFunc<String> setMulti(IValueBinding<String> piDec, IValueBinding<Integer> piPos, IValueBinding<Integer> piBits, IValueBinding<? extends Number> piVal){
//        return call(S, String.class, "setMulti").with(piDec, piPos, piBits, piVal);
//    }
//    
//    public static JsTypeRef<BitJsr> prototype = new JsTypeRef<BitJsr>(S);
//}