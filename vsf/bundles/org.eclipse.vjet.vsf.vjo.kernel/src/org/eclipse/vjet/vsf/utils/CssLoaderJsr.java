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
public class CssLoaderJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.utils.CssLoader", CssLoaderJsr.class, "CssLoader");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public CssLoaderJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected CssLoaderJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Void> load(String psUrl){
        return call(S, "load").with(psUrl);
    }

    public static JsFunc<Void> load(IValueBinding<String> psUrl){
        return call(S, "load").with(psUrl);
    }

    public static JsFunc<Object> getHead(){
        return call(S, Object.class, "getHead");
    }

    public static JsFunc<Void> loadText(String psText){
        return call(S, "loadText").with(psText);
    }

    public static JsFunc<Void> loadText(IValueBinding<String> psText){
        return call(S, "loadText").with(psText);
    }
    
    public static JsTypeRef<CssLoaderJsr> prototype = new JsTypeRef<CssLoaderJsr>(S);
}