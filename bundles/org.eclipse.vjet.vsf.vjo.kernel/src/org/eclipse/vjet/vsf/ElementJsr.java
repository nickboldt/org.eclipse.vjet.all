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
package org.eclipse.vjet.vsf;

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
public class ElementJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.Element", ElementJsr.class, "Element");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public ElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Object> get(String psId){
        return call(S, Object.class, "get").with(psId);
    }

    public static JsFunc<Object> get(IValueBinding<String> psId){
        return call(S, Object.class, "get").with(psId);
    }

    public static JsFunc<Void> toggleHideShow(String psId, boolean pbDisplay){
        return call(S, "toggleHideShow").with(psId, pbDisplay);
    }

    public static JsFunc<Void> toggleHideShow(IValueBinding<String> psId, IValueBinding<Boolean> pbDisplay){
        return call(S, "toggleHideShow").with(psId, checkS(pbDisplay));
    }

    public static JsFunc<Void> toggleHideShow(String psId){
        return call(S, "toggleHideShow").with(psId);
    }

    public static JsFunc<Void> toggleHideShow(IValueBinding<String> psId){
        return call(S, "toggleHideShow").with(psId);
    }

    public static JsFunc<Void> promoteToBody(String psId){
        return call(S, "promoteToBody").with(psId);
    }

    public static JsFunc<Void> promoteToBody(IValueBinding<String> psId){
        return call(S, "promoteToBody").with(psId);
    }

    public static JsFunc<Void> toggleVisibility(String psId, boolean pbVisible){
        return call(S, "toggleVisibility").with(psId, pbVisible);
    }

    public static JsFunc<Void> toggleVisibility(IValueBinding<String> psId, IValueBinding<Boolean> pbVisible){
        return call(S, "toggleVisibility").with(psId, checkS(pbVisible));
    }

    public static JsFunc<Void> toggleVisibility(String psId){
        return call(S, "toggleVisibility").with(psId);
    }

    public static JsFunc<Void> toggleVisibility(IValueBinding<String> psId){
        return call(S, "toggleVisibility").with(psId);
    }

    public static JsFunc<Void> enable(String psId, boolean pbEnable){
        return call(S, "enable").with(psId, pbEnable);
    }

    public static JsFunc<Void> enable(IValueBinding<String> psId, IValueBinding<Boolean> pbEnable){
        return call(S, "enable").with(psId, checkS(pbEnable));
    }

    public static JsFunc<String> left(String psId, String psLeft){
        return call(S, String.class, "left").with(psId, psLeft);
    }

    public static JsFunc<String> left(IValueBinding<String> psId, IValueBinding<String> psLeft){
        return call(S, String.class, "left").with(psId, psLeft);
    }

    public static JsFunc<String> top(String psId, String psTop){
        return call(S, String.class, "top").with(psId, psTop);
    }

    public static JsFunc<String> top(IValueBinding<String> psId, IValueBinding<String> psTop){
        return call(S, String.class, "top").with(psId, psTop);
    }

    public static JsFunc<String> width(String psId, String psWidth){
        return call(S, String.class, "width").with(psId, psWidth);
    }

    public static JsFunc<String> width(IValueBinding<String> psId, IValueBinding<String> psWidth){
        return call(S, String.class, "width").with(psId, psWidth);
    }

    public static JsFunc<String> height(String psId, String psHeight){
        return call(S, String.class, "height").with(psId, psHeight);
    }

    public static JsFunc<String> height(IValueBinding<String> psId, IValueBinding<String> psHeight){
        return call(S, String.class, "height").with(psId, psHeight);
    }

    public static JsFunc<Object> createElement(String name){
        return call(S, Object.class, "createElement").with(name);
    }

    public static JsFunc<Object> createElement(IValueBinding<String> name){
        return call(S, Object.class, "createElement").with(name);
    }

    public static JsFunc<Object> getElementByTagClass(Object element, String tag, String name){
        return call(S, Object.class, "getElementByTagClass").with(element, tag, name);
    }

    public static JsFunc<Object> getElementByTagClass(IValueBinding<Object> element, IValueBinding<String> tag, IValueBinding<String> name){
        return call(S, Object.class, "getElementByTagClass").with(element, tag, name);
    }

    public static JsFunc<Object> getElementsByTagClass(Object element, String tag, String name){
        return call(S, Object.class, "getElementsByTagClass").with(element, tag, name);
    }

    public static JsFunc<Object> getElementsByTagClass(IValueBinding<Object> element, IValueBinding<String> tag, IValueBinding<String> name){
        return call(S, Object.class, "getElementsByTagClass").with(element, tag, name);
    }

    public static JsFunc<Void> toggleHideShowRow(String psId, boolean pbDisplay){
        return call(S, "toggleHideShowRow").with(psId, pbDisplay);
    }

    public static JsFunc<Void> toggleHideShowRow(IValueBinding<String> psId, IValueBinding<Boolean> pbDisplay){
        return call(S, "toggleHideShowRow").with(psId, checkS(pbDisplay));
    }

    public static JsFunc<Void> toggleHideShowRow(String psId){
        return call(S, "toggleHideShowRow").with(psId);
    }

    public static JsFunc<Void> toggleHideShowRow(IValueBinding<String> psId){
        return call(S, "toggleHideShowRow").with(psId);
    }
    
    public static JsTypeRef<ElementJsr> prototype = new JsTypeRef<ElementJsr>(S);
}