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
import org.eclipse.vjet.vsf.IBindingJsr;
import org.eclipse.vjet.vsf.ITransportJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ServiceRegistryJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.ServiceRegistry", ServiceRegistryJsr.class, "ServiceRegistry");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(ITransportJsr.ResourceSpec.getInstance());

    public ServiceRegistryJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ServiceRegistryJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<? extends IBindingJsr> getBinding(String payloadType){
        return call(S, IBindingJsr.class, "getBinding").with(payloadType);
    }

    public static JsFunc<? extends IBindingJsr> getBinding(IValueBinding<String> payloadType){
        return call(S, IBindingJsr.class, "getBinding").with(payloadType);
    }

    public static JsFunc<? extends ITransportJsr> getTransport(String trspType){
        return call(S, ITransportJsr.class, "getTransport").with(trspType);
    }

    public static JsFunc<? extends ITransportJsr> getTransport(IValueBinding<String> trspType){
        return call(S, ITransportJsr.class, "getTransport").with(trspType);
    }

    public static JsFunc<Boolean> registerBinding(String payloadType, IBindingJsr binding){
        return call(S, Boolean.class, "registerBinding").with(payloadType, binding);
    }

    public static JsFunc<Boolean> registerBinding(IValueBinding<String> payloadType, IValueBinding<? extends IBindingJsr> binding){
        return call(S, Boolean.class, "registerBinding").with(payloadType, binding);
    }

    public static JsFunc<Boolean> registerTransport(String trspType, ITransportJsr transport){
        return call(S, Boolean.class, "registerTransport").with(trspType, transport);
    }

    public static JsFunc<Boolean> registerTransport(IValueBinding<String> trspType, IValueBinding<? extends ITransportJsr> transport){
        return call(S, Boolean.class, "registerTransport").with(trspType, transport);
    }
    
    public static JsTypeRef<ServiceRegistryJsr> prototype = new JsTypeRef<ServiceRegistryJsr>(S);
}