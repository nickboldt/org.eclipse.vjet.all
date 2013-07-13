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
package org.eclipse.vjet.vsf.window.utils;

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
public class VjWindowJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.window.utils.VjWindow", VjWindowJsr.class, "VjWindow");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public VjWindowJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected VjWindowJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Object> open(String pUrl, String pWindowName, String pFeatures, boolean pReplace, boolean pCenter, int pWidth, int pHeight){
        return call(S, Object.class, "open").with(pUrl, pWindowName, pFeatures, pReplace, pCenter, pWidth, pHeight);
    }

    public static JsFunc<Object> open(IValueBinding<String> pUrl, IValueBinding<String> pWindowName, IValueBinding<String> pFeatures, IValueBinding<Boolean> pReplace, IValueBinding<Boolean> pCenter, IValueBinding<Integer> pWidth, IValueBinding<Integer> pHeight){
        return call(S, Object.class, "open").with(pUrl, pWindowName, pFeatures, checkS(pReplace), checkS(pCenter), pWidth, pHeight);
    }

    public static JsFunc<Object> open(String pUrl, String pWindowName, boolean pFeatures, boolean pReplace, int pCenter, int pWidth){
        return call(S, Object.class, "open").with(pUrl, pWindowName, pFeatures, pReplace, pCenter, pWidth);
    }

    public static JsFunc<Object> open(IValueBinding<String> pUrl, IValueBinding<String> pWindowName, IValueBinding<Boolean> pFeatures, IValueBinding<Boolean> pReplace, IValueBinding<Integer> pCenter, IValueBinding<Integer> pWidth){
        return call(S, Object.class, "open").with(pUrl, pWindowName, checkS(pFeatures), checkS(pReplace), pCenter, pWidth);
    }

    public static JsFunc<Void> location(String pUrl){
        return call(S, "location").with(pUrl);
    }

    public static JsFunc<Void> location(IValueBinding<String> pUrl){
        return call(S, "location").with(pUrl);
    }

    public static JsFunc<Void> alert(Object pMessage){
        return call(S, "alert").with(pMessage);
    }

    public static JsFunc<Boolean> confirm(Object pMessage){
        return call(S, Boolean.class, "confirm").with(pMessage);
    }
    
    public static JsTypeRef<VjWindowJsr> prototype = new JsTypeRef<VjWindowJsr>(S);
}