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
import org.eclipse.vjet.vsf.EncJsr;
import org.eclipse.vjet.vsf.MessageJsr;
import org.eclipse.vjet.vsf.ServiceEngineJsr;
import org.eclipse.vjet.vsf.ServiceRegistryJsr;
import org.eclipse.vjet.vsf.ServiceResponseJsr;
import org.eclipse.vjet.vsf.SvcErrJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ServiceJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.Service", ServiceJsr.class, "Service");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(ServiceResponseJsr.ResourceSpec.getInstance())
        .addDependentComponent(EncJsr.ResourceSpec.getInstance())
        .addDependentComponent(SvcErrJsr.ResourceSpec.getInstance())
        .addDependentComponent(ServiceEngineJsr.ResourceSpec.getInstance())
        .addDependentComponent(ServiceRegistryJsr.ResourceSpec.getInstance())
        .addDependentComponent(MessageJsr.ResourceSpec.getInstance());

    public ServiceJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ServiceJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Void> callback(Object xmlHttpReq, MessageJsr message){
        return call(S, "callback").with(xmlHttpReq, message);
    }

    public static JsFunc<Void> callback(IValueBinding<Object> xmlHttpReq, IValueBinding<? extends MessageJsr> message){
        return call(S, "callback").with(xmlHttpReq, message);
    }

    public static JsFunc<Object> getXmlHttpReq(){
        return call(S, Object.class, "getXmlHttpReq");
    }

    public static JsFunc<String> generateReqParams(MessageJsr message){
        return call(S, String.class, "generateReqParams").with(message);
    }

    public static JsFunc<String> generateReqParams(IValueBinding<? extends MessageJsr> message){
        return call(S, String.class, "generateReqParams").with(message);
    }
    
    public static JsTypeRef<ServiceJsr> prototype = new JsTypeRef<ServiceJsr>(S);
}