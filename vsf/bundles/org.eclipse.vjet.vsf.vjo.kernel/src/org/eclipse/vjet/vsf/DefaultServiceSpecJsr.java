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
import org.eclipse.vjet.vsf.IServiceSpecJsr;
import org.eclipse.vjet.vsf.SvcConfigJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class DefaultServiceSpecJsr extends JsObj implements IServiceSpecJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.DefaultServiceSpec", DefaultServiceSpecJsr.class, "DefaultServiceSpec");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(SvcConfigJsr.ResourceSpec.getInstance())
        .addDependentComponent(IServiceSpecJsr.ResourceSpec.getInstance());

    public DefaultServiceSpecJsr(String svcId){
        super(S.getJsCmpMeta(), true, svcId);
    }

    public DefaultServiceSpecJsr(IValueBinding<String> svcId){
        super(S.getJsCmpMeta(), true, svcId);
    }

    protected DefaultServiceSpecJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static final JsProp<String> DEFAULT_URI(){
        return getProp(S, String.class, "DEFAULT_URI");
    }

    public JsFunc<? extends SvcConfigJsr> getServiceConfig(){
        return call(SvcConfigJsr.class, "getServiceConfig");
    }

    public JsFunc<String> getServiceName(){
        return call(String.class, "getServiceName");
    }

    public JsFunc<Boolean> shouldGzip(){
        return call(Boolean.class, "shouldGzip");
    }
    
    public static JsTypeRef<DefaultServiceSpecJsr> prototype = new JsTypeRef<DefaultServiceSpecJsr>(S);
}