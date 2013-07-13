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
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class JsLoaderJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.utils.JsLoader", JsLoaderJsr.class, "JsLoader");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public JsLoaderJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected JsLoaderJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Void> load(String psUrl){
        return call(S, "load").with(psUrl);
    }

    public static JsFunc<Void> load(IValueBinding<String> psUrl){
        return call(S, "load").with(psUrl);
    }

    public static JsFunc<Void> load(String psUrl, Object poCallback){
        return call(S, "load").with(psUrl, poCallback);
    }

    public static JsFunc<Void> load(IValueBinding<String> psUrl, IValueBinding<Object> poCallback){
        return call(S, "load").with(psUrl, poCallback);
    }

    public static JsFunc<Void> load(String psUrl, Object poCallback, Object poScope){
        return call(S, "load").with(psUrl, poCallback, poScope);
    }

    public static JsFunc<Void> load(IValueBinding<String> psUrl, IValueBinding<Object> poCallback, IValueBinding<Object> poScope){
        return call(S, "load").with(psUrl, poCallback, poScope);
    }

    public static JsFunc<Void> load(String psUrl, Object poCallback, Object poScope, String psType){
        return call(S, "load").with(psUrl, poCallback, poScope, psType);
    }

    public static JsFunc<Void> load(IValueBinding<String> psUrl, IValueBinding<Object> poCallback, IValueBinding<Object> poScope, IValueBinding<String> psType){
        return call(S, "load").with(psUrl, poCallback, poScope, psType);
    }

    public static JsFunc<Void> loadText(String psJsText){
        return call(S, "loadText").with(psJsText);
    }

    public static JsFunc<Void> loadText(IValueBinding<String> psJsText){
        return call(S, "loadText").with(psJsText);
    }

    public static JsFunc<Object> getHead(){
        return call(S, Object.class, "getHead");
    }

    public static JsFunc<Object> createScript(){
        return call(S, Object.class, "createScript");
    }
    
    public static JsTypeRef<JsLoaderJsr> prototype = new JsTypeRef<JsLoaderJsr>(S);
}