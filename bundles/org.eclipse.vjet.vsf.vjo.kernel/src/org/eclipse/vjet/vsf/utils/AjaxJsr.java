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
import org.eclipse.vjet.vsf.ElementJsr;
import org.eclipse.vjet.vsf.EventDispatcherJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.utils.CssJsr;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class AjaxJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.utils.Ajax", AjaxJsr.class, "Ajax");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(EventDispatcherJsr.ResourceSpec.getInstance())
        .addDependentComponent(ElementJsr.ResourceSpec.getInstance())
        .addDependentComponent(CssJsr.ResourceSpec.getInstance());

    public AjaxJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected AjaxJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Void> apply(String psElementId, String psHtmlText, String psJsText, String psCssText){
        return call(S, "apply").with(psElementId, psHtmlText, psJsText, psCssText);
    }

    public static JsFunc<Void> apply(IValueBinding<String> psElementId, IValueBinding<String> psHtmlText, IValueBinding<String> psJsText, IValueBinding<String> psCssText){
        return call(S, "apply").with(psElementId, psHtmlText, psJsText, psCssText);
    }

    public static JsFunc<Void> cleanApply(String psElementId, String psHtmlText, String psJsText, String psCssText, Object poEventIdMap){
        return call(S, "cleanApply").with(psElementId, psHtmlText, psJsText, psCssText, poEventIdMap);
    }

    public static JsFunc<Void> cleanApply(IValueBinding<String> psElementId, IValueBinding<String> psHtmlText, IValueBinding<String> psJsText, IValueBinding<String> psCssText, IValueBinding<Object> poEventIdMap){
        return call(S, "cleanApply").with(psElementId, psHtmlText, psJsText, psCssText, poEventIdMap);
    }

    public static JsFunc<Void> clean(Object poEventIdMap){
        return call(S, "clean").with(poEventIdMap);
    }
    
    public static JsTypeRef<AjaxJsr> prototype = new JsTypeRef<AjaxJsr>(S);
}