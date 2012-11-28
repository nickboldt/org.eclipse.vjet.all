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
import org.eclipse.vjet.vsf.jsnative.jsr.ArrayJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ElementxJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.docx.Elementx", ElementxJsr.class, "Elementx");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public ElementxJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ElementxJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<? extends HTMLElementJsr> get(String psId){
        return call(S, HTMLElementJsr.class, "get").with(psId);
    }

    public static JsFunc<? extends HTMLElementJsr> get(IValueBinding<String> psId){
        return call(S, HTMLElementJsr.class, "get").with(psId);
    }

    public static JsFunc<? extends HTMLElementJsr> createElement(String name){
        return call(S, HTMLElementJsr.class, "createElement").with(name);
    }

    public static JsFunc<? extends HTMLElementJsr> createElement(IValueBinding<String> name){
        return call(S, HTMLElementJsr.class, "createElement").with(name);
    }

    public static JsFunc<Boolean> containsElement(HTMLElementJsr container, HTMLElementJsr element){
        return call(S, Boolean.class, "containsElement").with(container, element);
    }

    public static JsFunc<Boolean> containsElement(IValueBinding<? extends HTMLElementJsr> container, IValueBinding<? extends HTMLElementJsr> element){
        return call(S, Boolean.class, "containsElement").with(container, element);
    }

    public static JsFunc<? extends HTMLElementJsr> getElementByTagClass(HTMLElementJsr element, String tag, String name){
        return call(S, HTMLElementJsr.class, "getElementByTagClass").with(element, tag, name);
    }

    public static JsFunc<? extends HTMLElementJsr> getElementByTagClass(IValueBinding<? extends HTMLElementJsr> element, IValueBinding<String> tag, IValueBinding<String> name){
        return call(S, HTMLElementJsr.class, "getElementByTagClass").with(element, tag, name);
    }

    public static JsFunc<? extends ArrayJsr> getElementsByTagClass(HTMLElementJsr element, String tag, String name){
        return call(S, ArrayJsr.class, "getElementsByTagClass").with(element, tag, name);
    }

    public static JsFunc<? extends ArrayJsr> getElementsByTagClass(IValueBinding<? extends HTMLElementJsr> element, IValueBinding<String> tag, IValueBinding<String> name){
        return call(S, ArrayJsr.class, "getElementsByTagClass").with(element, tag, name);
    }

    public static JsFunc<? extends HTMLElementJsr> getx(String ref){
        return call(S, HTMLElementJsr.class, "getx").with(ref);
    }

    public static JsFunc<? extends HTMLElementJsr> getx(IValueBinding<String> ref){
        return call(S, HTMLElementJsr.class, "getx").with(ref);
    }

    public static JsFunc<? extends HTMLElementJsr> getx(HTMLElementJsr ref){
        return call(S, HTMLElementJsr.class, "getx").with(ref);
    }

    public static JsFunc<? extends HTMLElementJsr> getx(IValueBinding<? extends HTMLElementJsr> ref, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, HTMLElementJsr.class, "getx").with(ref);
    }
    
    public static JsTypeRef<ElementxJsr> prototype = new JsTypeRef<ElementxJsr>(S);
}