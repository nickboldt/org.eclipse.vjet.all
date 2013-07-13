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
package org.eclipse.vjet.vsf.error;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.error.ErrorJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ErrorHandlerManagerJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.error.ErrorHandlerManager", ErrorHandlerManagerJsr.class, "ErrorHandlerManager");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(ErrorJsr.ResourceSpec.getInstance());

    public ErrorHandlerManagerJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ErrorHandlerManagerJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Boolean> add(String psMessage, String psUrl, String psLineNumber){
        return call(S, Boolean.class, "add").with(psMessage, psUrl, psLineNumber);
    }

    public static JsFunc<Boolean> add(IValueBinding<String> psMessage, IValueBinding<String> psUrl, IValueBinding<String> psLineNumber){
        return call(S, Boolean.class, "add").with(psMessage, psUrl, psLineNumber);
    }

    public static JsFunc<String> convertErrorTo(boolean pbIsHTML){
        return call(S, String.class, "convertErrorTo").with(pbIsHTML);
    }

    public static JsFunc<String> convertErrorTo(IValueBinding<Boolean> pbIsHTML){
        return call(S, String.class, "convertErrorTo").with(checkS(pbIsHTML));
    }

    public static JsFunc<String> toHTML(){
        return call(S, String.class, "toHTML");
    }

    public static JsFunc<String> toText(){
        return call(S, String.class, "toText");
    }

    public static JsFunc<Void> show(){
        return call(S, "show");
    }

    public static JsFunc<Void> register(Object handler){
        return call(S, "register").with(handler);
    }

    public static JsFunc<Void> clear(){
        return call(S, "clear");
    }

    public static JsFunc<Void> process(String psMessage, String psUrl, String psLineNumber){
        return call(S, "process").with(psMessage, psUrl, psLineNumber);
    }

    public static JsFunc<Void> process(IValueBinding<String> psMessage, IValueBinding<String> psUrl, IValueBinding<String> psLineNumber){
        return call(S, "process").with(psMessage, psUrl, psLineNumber);
    }

    public static JsFunc<Void> enableOnError(boolean hideJsErrors){
        return call(S, "enableOnError").with(hideJsErrors);
    }

    public static JsFunc<Void> enableOnError(IValueBinding<Boolean> hideJsErrors){
        return call(S, "enableOnError").with(checkS(hideJsErrors));
    }

    public static JsFunc<Void> enableOnError(boolean hideJsErrors, boolean addStackTrace){
        return call(S, "enableOnError").with(hideJsErrors, addStackTrace);
    }

    public static JsFunc<Void> enableOnError(IValueBinding<Boolean> hideJsErrors, IValueBinding<Boolean> addStackTrace){
        return call(S, "enableOnError").with(checkS(hideJsErrors), checkS(addStackTrace));
    }
    
    public static JsTypeRef<ErrorHandlerManagerJsr> prototype = new JsTypeRef<ErrorHandlerManagerJsr>(S);
}