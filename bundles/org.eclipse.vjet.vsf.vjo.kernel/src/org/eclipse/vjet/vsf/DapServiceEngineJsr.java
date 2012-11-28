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
package org.eclipse.vjet.vsf;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.dsf.dap.svc.IDapSvcCallback;
import org.eclipse.vjet.vsf.IServiceSpecJsr;
import org.eclipse.vjet.vsf.MessageJsr;
import org.eclipse.vjet.vsf.ServiceEngineJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class DapServiceEngineJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.DapServiceEngine", DapServiceEngineJsr.class, "DapServiceEngine");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(IServiceSpecJsr.ResourceSpec.getInstance())
        .addDependentComponent(ServiceEngineJsr.ResourceSpec.getInstance())
        .addDependentComponent(MessageJsr.ResourceSpec.getInstance());

    public DapServiceEngineJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected DapServiceEngineJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Void> subscribe(){
        return call(S, "subscribe");
    }

    public static JsFunc<Void> subscribe_2_0(IServiceSpecJsr svcSpec, IDapSvcCallback handler){
        return call(S, "subscribe_2_0").with(svcSpec, handler);
    }

    public static JsFunc<Void> subscribe_2_0(IValueBinding<? extends IServiceSpecJsr> svcSpec, IValueBinding<? extends IDapSvcCallback> handler){
        return call(S, "subscribe_2_0").with(svcSpec, handler);
    }

    public static JsFunc<Void> subscribe_3_0(IServiceSpecJsr svcSpec, String opName, IDapSvcCallback handler){
        return call(S, "subscribe_3_0").with(svcSpec, opName, handler);
    }

    public static JsFunc<Void> subscribe_3_0(IValueBinding<? extends IServiceSpecJsr> svcSpec, IValueBinding<String> opName, IValueBinding<? extends IDapSvcCallback> handler){
        return call(S, "subscribe_3_0").with(svcSpec, opName, handler);
    }

    public static JsFunc<Void> publish(){
        return call(S, "publish");
    }

    public static JsFunc<Void> publish_3_0(String svcName, Object request, IDapSvcCallback callback){
        return call(S, "publish_3_0").with(svcName, request, callback);
    }

    public static JsFunc<Void> publish_3_0(IValueBinding<String> svcName, IValueBinding<Object> request, IValueBinding<? extends IDapSvcCallback> callback){
        return call(S, "publish_3_0").with(svcName, request, callback);
    }

    public static JsFunc<Void> publish_4_0(String svcName, String opName, Object request, IDapSvcCallback callback){
        return call(S, "publish_4_0").with(svcName, opName, request, callback);
    }

    public static JsFunc<Void> publish_4_0(IValueBinding<String> svcName, IValueBinding<String> opName, IValueBinding<Object> request, IValueBinding<? extends IDapSvcCallback> callback){
        return call(S, "publish_4_0").with(svcName, opName, request, callback);
    }

    public static JsFunc<Void> publish_3_1(IServiceSpecJsr svcSpec, Object request, IDapSvcCallback callback){
        return call(S, "publish_3_1").with(svcSpec, request, callback);
    }

    public static JsFunc<Void> publish_3_1(IValueBinding<? extends IServiceSpecJsr> svcSpec, IValueBinding<Object> request, IValueBinding<? extends IDapSvcCallback> callback){
        return call(S, "publish_3_1").with(svcSpec, request, callback);
    }

    public static JsFunc<Void> publish_4_1(IServiceSpecJsr svcSpec, String opName, Object request, Object callback){
        return call(S, "publish_4_1").with(svcSpec, opName, request, callback);
    }

    public static JsFunc<Void> publish_4_1(IValueBinding<? extends IServiceSpecJsr> svcSpec, IValueBinding<String> opName, IValueBinding<Object> request, IValueBinding<Object> callback){
        return call(S, "publish_4_1").with(svcSpec, opName, request, callback);
    }
    
    public static JsTypeRef<DapServiceEngineJsr> prototype = new JsTypeRef<DapServiceEngineJsr>(S);
}