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
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.ErrorJsr;
import org.eclipse.vjet.vsf.jsnative.jsr.ArrayJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ServiceResponseJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.ServiceResponse", ServiceResponseJsr.class, "ServiceResponse");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public ServiceResponseJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ServiceResponseJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> objType(){
        return getProp(String.class, "objType");
    }

    public IJsPropSetter objType(String v) {
        return setProp("objType", v);
    }

    public IJsPropSetter objType(IValueBinding<String> v) {
        return setProp("objType", v);
    }

    public JsProp<ArrayJsr> errors(){
        return getProp(ArrayJsr.class, "errors");
    }

    public IJsPropSetter errors(ArrayJsr v) {
        return setProp("errors", v);
    }

    public IJsPropSetter errors(IValueBinding<? extends ArrayJsr> v) {
        return setProp("errors", v);
    }

    public JsProp<Object> data(){
        return getProp(Object.class, "data");
    }

    public IJsPropSetter data(Object v) {
        return setProp("data", v);
    }

    public IJsPropSetter data(IValueBinding<Object> v) {
        return setProp("data", v);
    }

    public JsFunc<Void> addError(ErrorJsr error){
        return call("addError").with(error);
    }

    public JsFunc<Void> addError(IValueBinding<? extends ErrorJsr> error){
        return call("addError").with(error);
    }
    
    public static JsTypeRef<ServiceResponseJsr> prototype = new JsTypeRef<ServiceResponseJsr>(S);
}