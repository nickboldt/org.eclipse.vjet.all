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
import org.eclipse.vjet.vsf.ErrorJsr;
import org.eclipse.vjet.vsf.MessageJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class SvcErrJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.SvcErr", SvcErrJsr.class, "SvcErr");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(ErrorJsr.ResourceSpec.getInstance())
        .addDependentComponent(MessageJsr.ResourceSpec.getInstance());

    public SvcErrJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected SvcErrJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static final JsProp<String> InvRsp(){
        return getProp(S, String.class, "InvRsp");
    }

    public static final JsProp<String> InvRqBnd(){
        return getProp(S, String.class, "InvRqBnd");
    }

    public static final JsProp<String> InvRspBnd(){
        return getProp(S, String.class, "InvRspBnd");
    }

    public static final JsProp<String> InvRq(){
        return getProp(S, String.class, "InvRq");
    }

    public static final JsProp<String> TO(){
        return getProp(S, String.class, "TO");
    }

    public static final JsProp<String> RqUnk(){
        return getProp(S, String.class, "RqUnk");
    }

    public static final JsProp<String> SvcRq(){
        return getProp(S, String.class, "SvcRq");
    }

    public static final JsProp<String> SvcRsp(){
        return getProp(S, String.class, "SvcRsp");
    }

    public static final JsProp<String> GlbRq(){
        return getProp(S, String.class, "GlbRq");
    }

    public static final JsProp<String> GlbRsp(){
        return getProp(S, String.class, "GlbRsp");
    }

    public static final JsProp<String> TrnRq(){
        return getProp(S, String.class, "TrnRq");
    }

    public static final JsProp<String> TrnRsp(){
        return getProp(S, String.class, "TrnRsp");
    }

    public static final JsProp<String> Prs(){
        return getProp(S, String.class, "Prs");
    }

    public static final JsProp<String> SvcPrc(){
        return getProp(S, String.class, "SvcPrc");
    }

    public static JsFunc<Void> err(MessageJsr message, String errorId, String errorMsg){
        return call(S, "err").with(message, errorId, errorMsg);
    }

    public static JsFunc<Void> err(IValueBinding<? extends MessageJsr> message, IValueBinding<String> errorId, IValueBinding<String> errorMsg){
        return call(S, "err").with(message, errorId, errorMsg);
    }
    
    public static JsTypeRef<SvcErrJsr> prototype = new JsTypeRef<SvcErrJsr>(S);
}