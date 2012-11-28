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
package org.eclipse.vjet.vjo.util;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vjo.util.JsonVjoJsr;
import org.eclipse.vjet.vjo.util.XmlJsonJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;


@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class XmlVjoJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.util.XmlVjo", XmlVjoJsr.class, "XmlVjo");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
        .addDependentComponent(XmlJsonJsr.ResourceSpec.getInstance())
        .addDependentComponent(JsonVjoJsr.ResourceSpec.getInstance());

    public XmlVjoJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected XmlVjoJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Object> xml2vjo(String xml, String typeName){
        return call(S, Object.class, "xml2vjo").with(xml, typeName);
    }

    public static JsFunc<Object> xml2vjo(IValueBinding<String> xml, IValueBinding<String> typeName){
        return call(S, Object.class, "xml2vjo").with(xml, typeName);
    }
    
    public static JsTypeRef<XmlVjoJsr> prototype = new JsTypeRef<XmlVjoJsr>(S);
}