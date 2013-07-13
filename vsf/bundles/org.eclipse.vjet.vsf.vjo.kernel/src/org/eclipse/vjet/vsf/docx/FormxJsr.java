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
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLFormElementJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class FormxJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.docx.Formx", FormxJsr.class, "Formx");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public FormxJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected FormxJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<? extends HTMLElementJsr> getElem(String ref, String psElemName){
        return call(S, HTMLElementJsr.class, "getElem").with(ref, psElemName);
    }

    public static JsFunc<? extends HTMLElementJsr> getElem(IValueBinding<String> ref, IValueBinding<String> psElemName){
        return call(S, HTMLElementJsr.class, "getElem").with(ref, psElemName);
    }

    public static JsFunc<? extends HTMLElementJsr> getElem(HTMLFormElementJsr ref, String psElemName){
        return call(S, HTMLElementJsr.class, "getElem").with(ref, psElemName);
    }

    public static JsFunc<? extends HTMLElementJsr> getElem(IValueBinding<? extends HTMLFormElementJsr> ref, IValueBinding<String> psElemName, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, HTMLElementJsr.class, "getElem").with(ref, psElemName);
    }

    public static JsFunc<Void> submit(String psName){
        return call(S, "submit").with(psName);
    }

    public static JsFunc<Void> submit(IValueBinding<String> psName){
        return call(S, "submit").with(psName);
    }

    public static JsFunc<Void> setAction(String psName, String psAction){
        return call(S, "setAction").with(psName, psAction);
    }

    public static JsFunc<Void> setAction(IValueBinding<String> psName, IValueBinding<String> psAction){
        return call(S, "setAction").with(psName, psAction);
    }

    public static JsFunc<String> getAction(String psName){
        return call(S, String.class, "getAction").with(psName);
    }

    public static JsFunc<String> getAction(IValueBinding<String> psName){
        return call(S, String.class, "getAction").with(psName);
    }

    public static JsFunc<Void> setTarget(String psName, String psTarget){
        return call(S, "setTarget").with(psName, psTarget);
    }

    public static JsFunc<Void> setTarget(IValueBinding<String> psName, IValueBinding<String> psTarget){
        return call(S, "setTarget").with(psName, psTarget);
    }

    public static JsFunc<String> getTarget(String psName){
        return call(S, String.class, "getTarget").with(psName);
    }

    public static JsFunc<String> getTarget(IValueBinding<String> psName){
        return call(S, String.class, "getTarget").with(psName);
    }

    public static JsFunc<Void> setAttr(String psName, String psAttrName, String psAttrValue){
        return call(S, "setAttr").with(psName, psAttrName, psAttrValue);
    }

    public static JsFunc<Void> setAttr(IValueBinding<String> psName, IValueBinding<String> psAttrName, IValueBinding<String> psAttrValue){
        return call(S, "setAttr").with(psName, psAttrName, psAttrValue);
    }

    public static JsFunc<String> getAttr(String psName, String psAttrName){
        return call(S, String.class, "getAttr").with(psName, psAttrName);
    }

    public static JsFunc<String> getAttr(IValueBinding<String> psName, IValueBinding<String> psAttrName){
        return call(S, String.class, "getAttr").with(psName, psAttrName);
    }
    
    public static JsTypeRef<FormxJsr> prototype = new JsTypeRef<FormxJsr>(S);
}