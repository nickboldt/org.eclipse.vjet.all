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
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class UriBuilderJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.utils.UriBuilder", UriBuilderJsr.class, "UriBuilder");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(EncJsr.ResourceSpec.getInstance());

    public UriBuilderJsr(String uri, boolean decode){
        super(S.getJsCmpMeta(), true, uri, decode);
    }

    public UriBuilderJsr(IValueBinding<String> uri, IValueBinding<Boolean> decode){
        super(S.getJsCmpMeta(), true, uri, decode);
    }

    protected UriBuilderJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<String> meta(String name, String value){
        return call(S, String.class, "meta").with(name, value);
    }

    public static JsFunc<String> meta(IValueBinding<String> name, IValueBinding<String> value){
        return call(S, String.class, "meta").with(name, value);
    }

    public JsFunc<Void> parse(String uri, boolean decode){
        return call("parse").with(uri, decode);
    }

    public JsFunc<Void> parse(IValueBinding<String> uri, IValueBinding<Boolean> decode){
        return call("parse").with(uri, check(decode));
    }

    public JsFunc<Void> appendParam(String name, String value, Object params){
        return call("appendParam").with(name, value, params);
    }

    public JsFunc<Void> appendParam(IValueBinding<String> name, IValueBinding<String> value, IValueBinding<Object> params){
        return call("appendParam").with(name, value, params);
    }

    public JsFunc<Void> appendParams(Object params){
        return call("appendParams").with(params);
    }

    public JsFunc<Void> decodeParams(String query){
        return call("decodeParams").with(query);
    }

    public JsFunc<Void> decodeParams(IValueBinding<String> query){
        return call("decodeParams").with(query);
    }

    public JsFunc<String> encodeParams(Object params){
        return call(String.class, "encodeParams").with(params);
    }

    public JsFunc<Void> decodeSeo(){
        return call("decodeSeo");
    }

    public JsFunc<Object> decodeForm(Object form){
        return call(Object.class, "decodeForm").with(form);
    }

    public JsFunc<Void> appendSelect(Object select, Object params){
        return call("appendSelect").with(select, params);
    }

    public JsFunc<String> getUri(){
        return call(String.class, "getUri");
    }
    
    public static JsTypeRef<UriBuilderJsr> prototype = new JsTypeRef<UriBuilderJsr>(S);
}