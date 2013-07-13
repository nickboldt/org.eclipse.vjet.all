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
import org.eclipse.vjet.vsf.ErrorJsr;
import org.eclipse.vjet.vsf.InProcReqtHdlJsr;
import org.eclipse.vjet.vsf.MessageJsr;
import org.eclipse.vjet.vsf.RemoteReqtHdlJsr;
import org.eclipse.vjet.vsf.ServiceRegistryJsr;
import org.eclipse.vjet.vsf.ServiceResponseJsr;
import org.eclipse.vjet.vsf.SvcConfigJsr;
import org.eclipse.vjet.vsf.SvcErrJsr;
import org.eclipse.vjet.vsf.XDomainRequestJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ServiceEngineJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.ServiceEngine", ServiceEngineJsr.class, "ServiceEngine");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(InProcReqtHdlJsr.ResourceSpec.getInstance())
        .addDependentComponent(RemoteReqtHdlJsr.ResourceSpec.getInstance())
        .addDependentComponent(ServiceResponseJsr.ResourceSpec.getInstance())
        .addDependentComponent(SvcConfigJsr.ResourceSpec.getInstance())
        .addDependentComponent(XDomainRequestJsr.ResourceSpec.getInstance())
        .addDependentComponent(ErrorJsr.ResourceSpec.getInstance())
        .addDependentComponent(ServiceRegistryJsr.ResourceSpec.getInstance())
        .addDependentComponent(SvcErrJsr.ResourceSpec.getInstance())
        .addDependentComponent(MessageJsr.ResourceSpec.getInstance());

    public ServiceEngineJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ServiceEngineJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Void> init(){
        return call(S, "init");
    }

    public static JsFunc<Boolean> handleRequest(MessageJsr m){
        return call(S, Boolean.class, "handleRequest").with(m);
    }

    public static JsFunc<Boolean> handleRequest(IValueBinding<? extends MessageJsr> m){
        return call(S, Boolean.class, "handleRequest").with(m);
    }

    public static JsFunc<Void> handleResponse(MessageJsr msg){
        return call(S, "handleResponse").with(msg);
    }

    public static JsFunc<Void> handleResponse(IValueBinding<? extends MessageJsr> msg){
        return call(S, "handleResponse").with(msg);
    }

    public static JsFunc<Void> handleResponse(MessageJsr msg, String jumpto){
        return call(S, "handleResponse").with(msg, jumpto);
    }

    public static JsFunc<Void> handleResponse(IValueBinding<? extends MessageJsr> msg, IValueBinding<String> jumpto){
        return call(S, "handleResponse").with(msg, jumpto);
    }

    public static JsFunc<Void> registerSvcHdl(String svcId, Object handler){
        return call(S, "registerSvcHdl").with(svcId, handler);
    }

    public static JsFunc<Void> registerSvcHdl(IValueBinding<String> svcId, IValueBinding<Object> handler){
        return call(S, "registerSvcHdl").with(svcId, handler);
    }

    public static JsFunc<Object> getSvcHdl(String svcId){
        return call(S, Object.class, "getSvcHdl").with(svcId);
    }

    public static JsFunc<Object> getSvcHdl(IValueBinding<String> svcId){
        return call(S, Object.class, "getSvcHdl").with(svcId);
    }

    public static JsFunc<Void> registerSvcReqtHdl(String svcId, Object handler){
        return call(S, "registerSvcReqtHdl").with(svcId, handler);
    }

    public static JsFunc<Void> registerSvcReqtHdl(IValueBinding<String> svcId, IValueBinding<Object> handler){
        return call(S, "registerSvcReqtHdl").with(svcId, handler);
    }

    public static JsFunc<Void> registerSvcRespHdl(String svcId, Object handler){
        return call(S, "registerSvcRespHdl").with(svcId, handler);
    }

    public static JsFunc<Void> registerSvcRespHdl(IValueBinding<String> svcId, IValueBinding<Object> handler){
        return call(S, "registerSvcRespHdl").with(svcId, handler);
    }

    public static JsFunc<Void> registerGlbReqtHdl(Object handler){
        return call(S, "registerGlbReqtHdl").with(handler);
    }

    public static JsFunc<Void> registerGlbRespHdl(Object handler){
        return call(S, "registerGlbRespHdl").with(handler);
    }

    public static JsFunc<Void> registerTrspReqtHdl(String transportType, Object handler){
        return call(S, "registerTrspReqtHdl").with(transportType, handler);
    }

    public static JsFunc<Void> registerTrspReqtHdl(IValueBinding<String> transportType, IValueBinding<Object> handler){
        return call(S, "registerTrspReqtHdl").with(transportType, handler);
    }

    public static JsFunc<Void> registerTrspRespHdl(String transportType, Object handler){
        return call(S, "registerTrspRespHdl").with(transportType, handler);
    }

    public static JsFunc<Void> registerTrspRespHdl(IValueBinding<String> transportType, IValueBinding<Object> handler){
        return call(S, "registerTrspRespHdl").with(transportType, handler);
    }

    public static JsFunc<Void> register(int pFuncType, String pServiceId, Object pHandler){
        return call(S, "register").with(pFuncType, pServiceId, pHandler);
    }

    public static JsFunc<Void> register(IValueBinding<Integer> pFuncType, IValueBinding<String> pServiceId, IValueBinding<Object> pHandler){
        return call(S, "register").with(pFuncType, pServiceId, pHandler);
    }
    
    public static JsTypeRef<ServiceEngineJsr> prototype = new JsTypeRef<ServiceEngineJsr>(S);
}