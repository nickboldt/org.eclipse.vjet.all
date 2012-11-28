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
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ErrorJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.Error", ErrorJsr.class, "Error");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public ErrorJsr(){
        super(S.getJsCmpMeta(), true);
    }

    public ErrorJsr(String psId){
        super(S.getJsCmpMeta(), true, psId);
    }

    public ErrorJsr(IValueBinding<String> psId){
        super(S.getJsCmpMeta(), true, psId);
    }

    public ErrorJsr(String psId, String psMessage){
        super(S.getJsCmpMeta(), true, psId, psMessage);
    }

    public ErrorJsr(IValueBinding<String> psId, IValueBinding<String> psMessage){
        super(S.getJsCmpMeta(), true, psId, psMessage);
    }

    protected ErrorJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> id(){
        return getProp(String.class, "id");
    }

    public IJsPropSetter id(String v) {
        return setProp("id", v);
    }

    public IJsPropSetter id(IValueBinding<String> v) {
        return setProp("id", v);
    }

    public JsProp<String> message(){
        return getProp(String.class, "message");
    }

    public IJsPropSetter message(String v) {
        return setProp("message", v);
    }

    public IJsPropSetter message(IValueBinding<String> v) {
        return setProp("message", v);
    }
    
    public static JsTypeRef<ErrorJsr> prototype = new JsTypeRef<ErrorJsr>(S);
}