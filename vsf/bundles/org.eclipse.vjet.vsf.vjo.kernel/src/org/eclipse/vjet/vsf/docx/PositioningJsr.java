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
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class PositioningJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.docx.Positioning", PositioningJsr.class, "Positioning");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public PositioningJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected PositioningJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Integer[]> getScrollLeftTop(){
        return call(S, Integer[].class, "getScrollLeftTop");
    }

    public static JsFunc<Integer> getOffsetLeft(HTMLElementJsr poElem){
        return call(S, Integer.class, "getOffsetLeft").with(poElem);
    }

    public static JsFunc<Integer> getOffsetLeft(IValueBinding<? extends HTMLElementJsr> poElem){
        return call(S, Integer.class, "getOffsetLeft").with(poElem);
    }

    public static JsFunc<Integer> getOffsetTop(HTMLElementJsr poElem){
        return call(S, Integer.class, "getOffsetTop").with(poElem);
    }

    public static JsFunc<Integer> getOffsetTop(IValueBinding<? extends HTMLElementJsr> poElem){
        return call(S, Integer.class, "getOffsetTop").with(poElem);
    }

    public static JsFunc<Integer> getClientWidth(){
        return call(S, Integer.class, "getClientWidth");
    }

    public static JsFunc<Integer> getClientHeight(){
        return call(S, Integer.class, "getClientHeight");
    }

    public static JsFunc<Integer[]> getEventLeftTop(org.eclipse.vjet.vsf.resource.html.event.handler.JsHandlerObjectEnum poEvent){
        return call(S, Integer[].class, "getEventLeftTop").with(poEvent);
    }
    
    public static JsTypeRef<PositioningJsr> prototype = new JsTypeRef<PositioningJsr>(S);
}