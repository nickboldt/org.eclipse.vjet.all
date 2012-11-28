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
package org.eclipse.vjet.vsf.assembly;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsnative.jsr.FunctionJsr;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;


@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class VjClientAssemblerRequestJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.assembly.VjClientAssemblerRequest", VjClientAssemblerRequestJsr.class, "VjClientAssemblerRequest");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public VjClientAssemblerRequestJsr(String psUrl, FunctionJsr pfCallback, Object poScope, String psCallbackParam, boolean pbSendResponseOnLoad){
        super(S.getJsCmpMeta(), true, psUrl, pfCallback, poScope, psCallbackParam, pbSendResponseOnLoad);
    }

    public VjClientAssemblerRequestJsr(IValueBinding<String> psUrl, IValueBinding<? extends FunctionJsr> pfCallback, IValueBinding<Object> poScope, IValueBinding<String> psCallbackParam, IValueBinding<Boolean> pbSendResponseOnLoad){
        super(S.getJsCmpMeta(), true, psUrl, pfCallback, poScope, psCallbackParam, pbSendResponseOnLoad);
    }

    public VjClientAssemblerRequestJsr(String psUrl, FunctionJsr pfCallback, Object poScope, String psCallbackParam){
        super(S.getJsCmpMeta(), true, psUrl, pfCallback, poScope, psCallbackParam);
    }

    public VjClientAssemblerRequestJsr(IValueBinding<String> psUrl, IValueBinding<? extends FunctionJsr> pfCallback, IValueBinding<Object> poScope, IValueBinding<String> psCallbackParam){
        super(S.getJsCmpMeta(), true, psUrl, pfCallback, poScope, psCallbackParam);
    }

    protected VjClientAssemblerRequestJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }
    
    public static JsTypeRef<VjClientAssemblerRequestJsr> prototype = new JsTypeRef<VjClientAssemblerRequestJsr>(S);
}