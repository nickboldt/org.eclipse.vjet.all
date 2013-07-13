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
package org.eclipse.vjet.vsf.service;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.MessageJsr;
import org.eclipse.vjet.vsf.ServiceEngineJsr;
import org.eclipse.vjet.vsf.common.IDedupComparableJsr;
import org.eclipse.vjet.vsf.common.IJsReqHandlerJsr;
import org.eclipse.vjet.vsf.common.IJsRespHandlerJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class DedupServiceHandlerJsr extends JsObj implements IJsRespHandlerJsr, IJsReqHandlerJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.service.DedupServiceHandler", DedupServiceHandlerJsr.class, "DedupServiceHandler");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(MessageJsr.ResourceSpec.getInstance())
        .addDependentComponent(ServiceEngineJsr.ResourceSpec.getInstance())
        .addDependentComponent(IJsRespHandlerJsr.ResourceSpec.getInstance())
        .addDependentComponent(IJsReqHandlerJsr.ResourceSpec.getInstance())
        .addDependentComponent(IDedupComparableJsr.ResourceSpec.getInstance());

    public DedupServiceHandlerJsr(IDedupComparableJsr comparable){
        super(S.getJsCmpMeta(), true, comparable);
    }

    public DedupServiceHandlerJsr(IValueBinding<? extends IDedupComparableJsr> comparable){
        super(S.getJsCmpMeta(), true, comparable);
    }

    protected DedupServiceHandlerJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsFunc<Void> handleRequest(org.eclipse.vjet.vsf.resource.html.event.handler.JsHandlerObjectEnum message){
        return call("handleRequest").with(message);
    }

    public JsFunc<Void> handleResponse(org.eclipse.vjet.vsf.resource.html.event.handler.JsHandlerObjectEnum message){
        return call("handleResponse").with(message);
    }
    
    public static JsTypeRef<DedupServiceHandlerJsr> prototype = new JsTypeRef<DedupServiceHandlerJsr>(S);
}