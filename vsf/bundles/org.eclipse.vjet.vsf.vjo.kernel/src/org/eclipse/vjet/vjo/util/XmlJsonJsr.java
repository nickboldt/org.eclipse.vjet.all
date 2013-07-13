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
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class XmlJsonJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.util.XmlJson", XmlJsonJsr.class, "XmlJson");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public XmlJsonJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected XmlJsonJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Object> xml2json(String xml, String tab){
        return call(S, Object.class, "xml2json").with(xml, tab);
    }

    public static JsFunc<Object> xml2json(IValueBinding<String> xml, IValueBinding<String> tab){
        return call(S, Object.class, "xml2json").with(xml, tab);
    }

    public static JsFunc<String> json2xml(String ns, Object o, boolean upper){
        return call(S, String.class, "json2xml").with(ns, o, upper);
    }

    public static JsFunc<String> json2xml(IValueBinding<String> ns, IValueBinding<Object> o, IValueBinding<Boolean> upper){
        return call(S, String.class, "json2xml").with(ns, o, checkS(upper));
    }

    public static JsFunc<String> json2xml(String ns, Object o, boolean upper, String tab){
        return call(S, String.class, "json2xml").with(ns, o, upper, tab);
    }

    public static JsFunc<String> json2xml(IValueBinding<String> ns, IValueBinding<Object> o, IValueBinding<Boolean> upper, IValueBinding<String> tab){
        return call(S, String.class, "json2xml").with(ns, o, checkS(upper), tab);
    }
    
    public static JsTypeRef<XmlJsonJsr> prototype = new JsTypeRef<XmlJsonJsr>(S);
}