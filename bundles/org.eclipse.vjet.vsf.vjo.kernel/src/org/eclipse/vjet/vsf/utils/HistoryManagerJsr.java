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
import org.eclipse.vjet.vsf.EncJsr;
import org.eclipse.vjet.vsf.EventDispatcherJsr;
import org.eclipse.vjet.vsf.ServiceEngineJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.utils.UriBuilderJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HistoryManagerJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.utils.HistoryManager", HistoryManagerJsr.class, "HistoryManager");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(EncJsr.ResourceSpec.getInstance())
        .addDependentComponent(ServiceEngineJsr.ResourceSpec.getInstance())
        .addDependentComponent(EventDispatcherJsr.ResourceSpec.getInstance())
        .addDependentComponent(UriBuilderJsr.ResourceSpec.getInstance());

    public HistoryManagerJsr(Object model){
        super(S.getJsCmpMeta(), true, model);
    }

    protected HistoryManagerJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsFunc<Void> putState(Object key, Object state){
        return call("putState").with(key, state);
    }

    public JsFunc<Object> getState(Object key){
        return call(Object.class, "getState").with(key);
    }

    public JsFunc<Void> pushHistory(String name, Object state, String title){
        return call("pushHistory").with(name, state, title);
    }

    public JsFunc<Void> pushHistory(IValueBinding<String> name, IValueBinding<Object> state, IValueBinding<String> title){
        return call("pushHistory").with(name, state, title);
    }
    
    public static JsTypeRef<HistoryManagerJsr> prototype = new JsTypeRef<HistoryManagerJsr>(S);
}