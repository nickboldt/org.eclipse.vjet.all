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
package org.eclipse.vjet.vsf.document;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.ElementJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ImageJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.document.Image", ImageJsr.class, "Image");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(ElementJsr.ResourceSpec.getInstance());

    public ImageJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ImageJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Void> load(String psId, String psURL){
        return call(S, "load").with(psId, psURL);
    }

    public static JsFunc<Void> load(IValueBinding<String> psId, IValueBinding<String> psURL){
        return call(S, "load").with(psId, psURL);
    }

    public static JsFunc<Void> preload(String psURL){
        return call(S, "preload").with(psURL);
    }

    public static JsFunc<Void> preload(IValueBinding<String> psURL){
        return call(S, "preload").with(psURL);
    }

    public static JsFunc<Void> resize(String psId, int piWidth, int piHeight){
        return call(S, "resize").with(psId, piWidth, piHeight);
    }

    public static JsFunc<Void> resize(IValueBinding<String> psId, IValueBinding<Integer> piWidth, IValueBinding<Integer> piHeight){
        return call(S, "resize").with(psId, piWidth, piHeight);
    }
    
    public static JsTypeRef<ImageJsr> prototype = new JsTypeRef<ImageJsr>(S);
}