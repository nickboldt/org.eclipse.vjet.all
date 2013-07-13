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
package org.eclipse.vjet.vsf.window.utils;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsbrowser.jsr.MouseEventJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class VjWindowUtilsJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.window.utils.VjWindowUtils", VjWindowUtilsJsr.class, "VjWindowUtils");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public VjWindowUtilsJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected VjWindowUtilsJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Integer> getBrowserWindowHeight(){
        return call(S, Integer.class, "getBrowserWindowHeight");
    }

    public static JsFunc<Integer> getBrowserWindowWidth(){
        return call(S, Integer.class, "getBrowserWindowWidth");
    }

    public static JsFunc<Object> getScrollXY(){
        return call(S, Object.class, "getScrollXY");
    }

    public static JsFunc<String> toPixels(int number){
        return call(S, String.class, "toPixels").with(number);
    }

    public static JsFunc<String> toPixels(IValueBinding<Integer> number){
        return call(S, String.class, "toPixels").with(number);
    }

    public static JsFunc<Integer> scrollTop(){
        return call(S, Integer.class, "scrollTop");
    }

    public static JsFunc<Integer> scrollLeft(){
        return call(S, Integer.class, "scrollLeft");
    }

    public static JsFunc<Integer> scrollWidth(){
        return call(S, Integer.class, "scrollWidth");
    }

    public static JsFunc<Integer> scrollHeight(){
        return call(S, Integer.class, "scrollHeight");
    }

    public static JsFunc<Integer> clientTop(){
        return call(S, Integer.class, "clientTop");
    }

    public static JsFunc<Integer> clientLeft(){
        return call(S, Integer.class, "clientLeft");
    }

    public static JsFunc<Integer> clientWidth(){
        return call(S, Integer.class, "clientWidth");
    }

    public static JsFunc<Integer> clientHeight(){
        return call(S, Integer.class, "clientHeight");
    }

    public static JsFunc<Integer> browserTop(){
        return call(S, Integer.class, "browserTop");
    }

    public static JsFunc<Integer> browserLeft(){
        return call(S, Integer.class, "browserLeft");
    }

    public static JsFunc<Integer> eventTop(MouseEventJsr event){
        return call(S, Integer.class, "eventTop").with(event);
    }

    public static JsFunc<Integer> eventTop(IValueBinding<? extends MouseEventJsr> event){
        return call(S, Integer.class, "eventTop").with(event);
    }

    public static JsFunc<Integer> eventTop(org.eclipse.vjet.vsf.resource.html.event.handler.JsHandlerObjectEnum event){
        return call(S, Integer.class, "eventTop").with(event);
    }

    public static JsFunc<Integer> eventTop(){
        return call(S, Integer.class, "eventTop").with(org.eclipse.vjet.vsf.resource.html.event.handler.JsHandlerObjectEnum.nativeEvent);
    }

    public static JsFunc<Integer> eventLeft(MouseEventJsr event){
        return call(S, Integer.class, "eventLeft").with(event);
    }

    public static JsFunc<Integer> eventLeft(IValueBinding<? extends MouseEventJsr> event){
        return call(S, Integer.class, "eventLeft").with(event);
    }

    public static JsFunc<Integer> eventLeft(org.eclipse.vjet.vsf.resource.html.event.handler.JsHandlerObjectEnum event){
        return call(S, Integer.class, "eventLeft").with(event);
    }

    public static JsFunc<Integer> eventLeft(){
        return call(S, Integer.class, "eventLeft").with(org.eclipse.vjet.vsf.resource.html.event.handler.JsHandlerObjectEnum.nativeEvent);
    }

    public static JsFunc<Integer> offsetTop(HTMLElementJsr element){
        return call(S, Integer.class, "offsetTop").with(element);
    }

    public static JsFunc<Integer> offsetTop(IValueBinding<? extends HTMLElementJsr> element){
        return call(S, Integer.class, "offsetTop").with(element);
    }

    public static JsFunc<Integer> offsetLeft(HTMLElementJsr element){
        return call(S, Integer.class, "offsetLeft").with(element);
    }

    public static JsFunc<Integer> offsetLeft(IValueBinding<? extends HTMLElementJsr> element){
        return call(S, Integer.class, "offsetLeft").with(element);
    }

    public static JsFunc<Object> openWindow(String url, String name, Object features){
        return call(S, Object.class, "openWindow").with(url, name, features);
    }

    public static JsFunc<Object> openWindow(IValueBinding<String> url, IValueBinding<String> name, IValueBinding<Object> features){
        return call(S, Object.class, "openWindow").with(url, name, features);
    }
    
    public static JsTypeRef<VjWindowUtilsJsr> prototype = new JsTypeRef<VjWindowUtilsJsr>(S);
}