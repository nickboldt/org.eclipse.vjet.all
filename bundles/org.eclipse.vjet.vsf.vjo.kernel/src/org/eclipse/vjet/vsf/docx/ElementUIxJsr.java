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
package org.eclipse.vjet.vsf.docx;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementJsr;
import org.eclipse.vjet.vsf.docx.ElementxJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ElementUIxJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.docx.ElementUIx", ElementUIxJsr.class, "ElementUIx");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(ElementxJsr.ResourceSpec.getInstance());

    public ElementUIxJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ElementUIxJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Void> toggleHideShow(String ref, boolean pbDisplay){
        return call(S, "toggleHideShow").with(ref, pbDisplay);
    }

    public static JsFunc<Void> toggleHideShow(IValueBinding<String> ref, IValueBinding<Boolean> pbDisplay){
        return call(S, "toggleHideShow").with(ref, checkS(pbDisplay));
    }

    public static JsFunc<Void> toggleHideShow(String ref){
        return call(S, "toggleHideShow").with(ref);
    }

    public static JsFunc<Void> toggleHideShow(IValueBinding<String> ref){
        return call(S, "toggleHideShow").with(ref);
    }

    public static JsFunc<Void> toggleHideShow(HTMLElementJsr ref, boolean pbDisplay){
        return call(S, "toggleHideShow").with(ref, pbDisplay);
    }

    public static JsFunc<Void> toggleHideShow(IValueBinding<? extends HTMLElementJsr> ref, IValueBinding<Boolean> pbDisplay, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, "toggleHideShow").with(ref, checkS(pbDisplay));
    }

    public static JsFunc<Void> toggleHideShow(HTMLElementJsr ref){
        return call(S, "toggleHideShow").with(ref);
    }

    public static JsFunc<Void> toggleHideShow(IValueBinding<? extends HTMLElementJsr> ref, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, "toggleHideShow").with(ref);
    }

    public static JsFunc<Void> promoteToBody(String ref){
        return call(S, "promoteToBody").with(ref);
    }

    public static JsFunc<Void> promoteToBody(IValueBinding<String> ref){
        return call(S, "promoteToBody").with(ref);
    }

    public static JsFunc<Void> toggleVisibility(String ref, boolean pbVisible){
        return call(S, "toggleVisibility").with(ref, pbVisible);
    }

    public static JsFunc<Void> toggleVisibility(IValueBinding<String> ref, IValueBinding<Boolean> pbVisible){
        return call(S, "toggleVisibility").with(ref, checkS(pbVisible));
    }

    public static JsFunc<Void> toggleVisibility(String ref){
        return call(S, "toggleVisibility").with(ref);
    }

    public static JsFunc<Void> toggleVisibility(IValueBinding<String> ref){
        return call(S, "toggleVisibility").with(ref);
    }

    public static JsFunc<Void> toggleVisibility(HTMLElementJsr ref, boolean pbVisible){
        return call(S, "toggleVisibility").with(ref, pbVisible);
    }

    public static JsFunc<Void> toggleVisibility(IValueBinding<? extends HTMLElementJsr> ref, IValueBinding<Boolean> pbVisible, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, "toggleVisibility").with(ref, checkS(pbVisible));
    }

    public static JsFunc<Void> toggleVisibility(HTMLElementJsr ref){
        return call(S, "toggleVisibility").with(ref);
    }

    public static JsFunc<Void> toggleVisibility(IValueBinding<? extends HTMLElementJsr> ref, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, "toggleVisibility").with(ref);
    }

    public static JsFunc<Void> enable(String psId, boolean pbEnable){
        return call(S, "enable").with(psId, pbEnable);
    }

    public static JsFunc<Void> enable(IValueBinding<String> psId, IValueBinding<Boolean> pbEnable){
        return call(S, "enable").with(psId, checkS(pbEnable));
    }

    public static JsFunc<String> left(String ref, String psLeft){
        return call(S, String.class, "left").with(ref, psLeft);
    }

    public static JsFunc<String> left(IValueBinding<String> ref, IValueBinding<String> psLeft){
        return call(S, String.class, "left").with(ref, psLeft);
    }

    public static JsFunc<String> left(HTMLElementJsr ref, String psLeft){
        return call(S, String.class, "left").with(ref, psLeft);
    }

    public static JsFunc<String> left(IValueBinding<? extends HTMLElementJsr> ref, IValueBinding<String> psLeft, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, String.class, "left").with(ref, psLeft);
    }

    public static JsFunc<String> top(String ref, String psTop){
        return call(S, String.class, "top").with(ref, psTop);
    }

    public static JsFunc<String> top(IValueBinding<String> ref, IValueBinding<String> psTop){
        return call(S, String.class, "top").with(ref, psTop);
    }

    public static JsFunc<String> top(HTMLElementJsr ref, String psTop){
        return call(S, String.class, "top").with(ref, psTop);
    }

    public static JsFunc<String> top(IValueBinding<? extends HTMLElementJsr> ref, IValueBinding<String> psTop, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, String.class, "top").with(ref, psTop);
    }

    public static JsFunc<String> width(String ref, String psWidth){
        return call(S, String.class, "width").with(ref, psWidth);
    }

    public static JsFunc<String> width(IValueBinding<String> ref, IValueBinding<String> psWidth){
        return call(S, String.class, "width").with(ref, psWidth);
    }

    public static JsFunc<String> width(HTMLElementJsr ref, String psWidth){
        return call(S, String.class, "width").with(ref, psWidth);
    }

    public static JsFunc<String> width(IValueBinding<? extends HTMLElementJsr> ref, IValueBinding<String> psWidth, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, String.class, "width").with(ref, psWidth);
    }

    public static JsFunc<String> height(String ref, String psHeight){
        return call(S, String.class, "height").with(ref, psHeight);
    }

    public static JsFunc<String> height(IValueBinding<String> ref, IValueBinding<String> psHeight){
        return call(S, String.class, "height").with(ref, psHeight);
    }

    public static JsFunc<String> height(HTMLElementJsr ref, String psHeight){
        return call(S, String.class, "height").with(ref, psHeight);
    }

    public static JsFunc<String> height(IValueBinding<? extends HTMLElementJsr> ref, IValueBinding<String> psHeight, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, String.class, "height").with(ref, psHeight);
    }

    public static JsFunc<Void> toggleHideShowRow(String ref, boolean pbDisplay){
        return call(S, "toggleHideShowRow").with(ref, pbDisplay);
    }

    public static JsFunc<Void> toggleHideShowRow(IValueBinding<String> ref, IValueBinding<Boolean> pbDisplay){
        return call(S, "toggleHideShowRow").with(ref, checkS(pbDisplay));
    }

    public static JsFunc<Void> toggleHideShowRow(String ref){
        return call(S, "toggleHideShowRow").with(ref);
    }

    public static JsFunc<Void> toggleHideShowRow(IValueBinding<String> ref){
        return call(S, "toggleHideShowRow").with(ref);
    }

    public static JsFunc<Void> toggleHideShowRow(HTMLElementJsr ref, boolean pbDisplay){
        return call(S, "toggleHideShowRow").with(ref, pbDisplay);
    }

    public static JsFunc<Void> toggleHideShowRow(IValueBinding<? extends HTMLElementJsr> ref, IValueBinding<Boolean> pbDisplay, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, "toggleHideShowRow").with(ref, checkS(pbDisplay));
    }

    public static JsFunc<Void> toggleHideShowRow(HTMLElementJsr ref){
        return call(S, "toggleHideShowRow").with(ref);
    }

    public static JsFunc<Void> toggleHideShowRow(IValueBinding<? extends HTMLElementJsr> ref, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, "toggleHideShowRow").with(ref);
    }
    
    public static JsTypeRef<ElementUIxJsr> prototype = new JsTypeRef<ElementUIxJsr>(S);
}