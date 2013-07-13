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
package org.eclipse.vjet.vsf.docx;
//package vjo.dsf.docx;
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
//import vjo.dsf.docx.ElementxJsr;
//import vjo.dsf.client.BrowserJsr;
//
//@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
//public class FramexJsr extends JsObj {
//    private static final long serialVersionUID = 1L;
//
//    private static final JsObjData S = 
//        new JsObjData("vjo.dsf.docx.Framex", FramexJsr.class, "Framex");
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
//        .addDependentComponent(ElementxJsr.ResourceSpec.getInstance())
//        .addDependentComponent(BrowserJsr.ResourceSpec.getInstance());
//
//    public FramexJsr(){
//        super(S.getJsCmpMeta(), true);
//    }
//
//    protected FramexJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
//        super(cmpMeta, isInstance, args);
//    }
//
//    public static JsFunc<Void> resize(String psIframeId){
//        return call(S, "resize").with(psIframeId);
//    }
//
//    public static JsFunc<Void> resize(IValueBinding<String> psIframeId){
//        return call(S, "resize").with(psIframeId);
//    }
//    
//    public static JsTypeRef<FramexJsr> prototype = new JsTypeRef<FramexJsr>(S);
//}