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
package org.eclipse.vjet.vsf.document;
//package vjo.dsf.document;
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
//import vjo.dsf.client.BrowserJsr;
//
//@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
//public class ShimJsr extends JsObj {
//    private static final long serialVersionUID = 1L;
//
//    private static final JsObjData S = 
//        new JsObjData("vjo.dsf.document.Shim", ShimJsr.class, "Shim");
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
//        .addDependentComponent(BrowserJsr.ResourceSpec.getInstance());
//
//    public ShimJsr(){
//        super(S.getJsCmpMeta(), true);
//    }
//
//    protected ShimJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
//        super(cmpMeta, isInstance, args);
//    }
//
//    public static JsFunc<Object> add(Object poNode, int piHPadding, int piVPadding){
//        return call(S, Object.class, "add").with(poNode, piHPadding, piVPadding);
//    }
//
//    public static JsFunc<Object> add(IValueBinding<Object> poNode, IValueBinding<Integer> piHPadding, IValueBinding<Integer> piVPadding){
//        return call(S, Object.class, "add").with(poNode, piHPadding, piVPadding);
//    }
//
//    public static JsFunc<Void> remove(Object poDiv, Object poIframe){
//        return call(S, "remove").with(poDiv, poIframe);
//    }
//    
//    public static JsTypeRef<ShimJsr> prototype = new JsTypeRef<ShimJsr>(S);
//}