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
package org.eclipse.vjet.vsf.tools;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class VjPTXJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.tools.VjPTX", VjPTXJsr.class, "VjPTX");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public VjPTXJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected VjPTXJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Void> init(String psStyleName){
        return call(S, "init").with(psStyleName);
    }

    public static JsFunc<Void> init(IValueBinding<String> psStyleName){
        return call(S, "init").with(psStyleName);
    }

    public static JsFunc<Void> styleNonPseudoTextNodes(String psStyleName, String psRoot){
        return call(S, "styleNonPseudoTextNodes").with(psStyleName, psRoot);
    }

    public static JsFunc<Void> styleNonPseudoTextNodes(IValueBinding<String> psStyleName, IValueBinding<String> psRoot){
        return call(S, "styleNonPseudoTextNodes").with(psStyleName, psRoot);
    }

    public static JsFunc<Void> styleNonPseudoTextNodes(String psStyleName, HTMLElementJsr psRoot){
        return call(S, "styleNonPseudoTextNodes").with(psStyleName, psRoot);
    }

    public static JsFunc<Void> styleNonPseudoTextNodes(IValueBinding<String> psStyleName, IValueBinding<? extends HTMLElementJsr> psRoot, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, "styleNonPseudoTextNodes").with(psStyleName, psRoot);
    }
    
    public static JsTypeRef<VjPTXJsr> prototype = new JsTypeRef<VjPTXJsr>(S);
}