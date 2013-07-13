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
import org.eclipse.vjet.vsf.EventDispatcherJsr;
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
public class HandlersJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.utils.Handlers", HandlersJsr.class, "Handlers");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(EventDispatcherJsr.ResourceSpec.getInstance())
        .addDependentComponent(MessageJsr.ResourceSpec.getInstance())
        .addDependentComponent(ServiceEngineJsr.ResourceSpec.getInstance());

    public HandlersJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HandlersJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Boolean> attachEvt(Object target, String type, Object func, Object scope){
        return call(S, Boolean.class, "attachEvt").with(target, type, func, scope);
    }

    public static JsFunc<Boolean> attachEvt(IValueBinding<Object> target, IValueBinding<String> type, IValueBinding<Object> func, IValueBinding<Object> scope){
        return call(S, Boolean.class, "attachEvt").with(target, type, func, scope);
    }

    public static JsFunc<Boolean> detachEvt(Object target, String type, Object hdl){
        return call(S, Boolean.class, "detachEvt").with(target, type, hdl);
    }

    public static JsFunc<Boolean> detachEvt(IValueBinding<Object> target, IValueBinding<String> type, IValueBinding<Object> hdl){
        return call(S, Boolean.class, "detachEvt").with(target, type, hdl);
    }

    public static JsFunc<? extends MessageJsr> newMsg(String svcName){
        return call(S, MessageJsr.class, "newMsg").with(svcName);
    }

    public static JsFunc<? extends MessageJsr> newMsg(IValueBinding<String> svcName){
        return call(S, MessageJsr.class, "newMsg").with(svcName);
    }

    public static JsFunc<Void> handle(MessageJsr msg){
        return call(S, "handle").with(msg);
    }

    public static JsFunc<Void> handle(IValueBinding<? extends MessageJsr> msg){
        return call(S, "handle").with(msg);
    }

    public static JsFunc<Void> attachSvc(String svcName, Object func, Object scope){
        return call(S, "attachSvc").with(svcName, func, scope);
    }

    public static JsFunc<Void> attachSvc(IValueBinding<String> svcName, IValueBinding<Object> func, IValueBinding<Object> scope){
        return call(S, "attachSvc").with(svcName, func, scope);
    }

    public static JsFunc<Void> attachSvcReqt(String svcName, Object func, Object scope){
        return call(S, "attachSvcReqt").with(svcName, func, scope);
    }

    public static JsFunc<Void> attachSvcReqt(IValueBinding<String> svcName, IValueBinding<Object> func, IValueBinding<Object> scope){
        return call(S, "attachSvcReqt").with(svcName, func, scope);
    }

    public static JsFunc<Void> attachSvcResp(String svcName, Object func, Object scope){
        return call(S, "attachSvcResp").with(svcName, func, scope);
    }

    public static JsFunc<Void> attachSvcResp(IValueBinding<String> svcName, IValueBinding<Object> func, IValueBinding<Object> scope){
        return call(S, "attachSvcResp").with(svcName, func, scope);
    }

    public static JsFunc<Void> resetSvc(String svcName){
        return call(S, "resetSvc").with(svcName);
    }

    public static JsFunc<Void> resetSvc(IValueBinding<String> svcName){
        return call(S, "resetSvc").with(svcName);
    }

    public static JsFunc<Void> resetSvcReqt(String svcName){
        return call(S, "resetSvcReqt").with(svcName);
    }

    public static JsFunc<Void> resetSvcReqt(IValueBinding<String> svcName){
        return call(S, "resetSvcReqt").with(svcName);
    }

    public static JsFunc<Void> resetSvcResp(String svcName){
        return call(S, "resetSvcResp").with(svcName);
    }

    public static JsFunc<Void> resetSvcResp(IValueBinding<String> svcName){
        return call(S, "resetSvcResp").with(svcName);
    }
    
    public static JsTypeRef<HandlersJsr> prototype = new JsTypeRef<HandlersJsr>(S);
}