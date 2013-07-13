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
package vjo;

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
public class RegistryJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.Registry", RegistryJsr.class, "Registry");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public RegistryJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected RegistryJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Object> put(String psKey, Object poControl){
        return call(S, Object.class, "put").with(psKey, poControl);
    }

    public static JsFunc<Object> put(IValueBinding<String> psKey, IValueBinding<Object> poControl){
        return call(S, Object.class, "put").with(psKey, poControl);
    }

    public static JsFunc<Object> get(String psKey){
        return call(S, Object.class, "get").with(psKey);
    }

    public static JsFunc<Object> get(IValueBinding<String> psKey){
        return call(S, Object.class, "get").with(psKey);
    }

    public static JsFunc<String> dump(){
        return call(S, String.class, "dump");
    }
    
    public static JsTypeRef<RegistryJsr> prototype = new JsTypeRef<RegistryJsr>(S);
}