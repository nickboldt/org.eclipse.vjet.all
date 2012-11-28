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

import org.eclipse.vjet.vjo.bootstrap.VjBootstrap;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.WindowJsr;
import org.eclipse.vjet.vsf.ElementJsr;
import org.eclipse.vjet.vsf.EventJsr;
import org.eclipse.vjet.vsf.ServiceEngineJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class EventDispatcherJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.EventDispatcher", EventDispatcherJsr.class, "EventDispatcher");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec()
    	.addDependentComponent(VjBootstrap.ResourceSpec.getInstance())
        .addDependentComponent(EventJsr.ResourceSpec.getInstance())
        .addDependentComponent(ServiceEngineJsr.ResourceSpec.getInstance())
        .addDependentComponent(ElementJsr.ResourceSpec.getInstance());

    public EventDispatcherJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected EventDispatcherJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public static JsFunc<Object> process(String srcId, Object event){
        return call(S, Object.class, "process").with(srcId, event);
    }

    public static JsFunc<Object> process(IValueBinding<String> srcId, IValueBinding<Object> event){
        return call(S, Object.class, "process").with(srcId, event);
    }

    public static JsFunc<Object> register(String id, String eventType, Object handler, Object scope){
        return call(S, Object.class, "register").with(id, eventType, handler, scope);
    }

    public static JsFunc<Object> register(IValueBinding<String> id, IValueBinding<String> eventType, IValueBinding<Object> handler, IValueBinding<Object> scope){
        return call(S, Object.class, "register").with(id, eventType, handler, scope);
    }

    public static JsFunc<Void> unregister(String id, String eventType){
        return call(S, "unregister").with(id, eventType);
    }

    public static JsFunc<Void> unregister(IValueBinding<String> id, IValueBinding<String> eventType){
        return call(S, "unregister").with(id, eventType);
    }

    public static JsFunc<Object> add(String id, String eventType, Object handler, Object scope){
        return call(S, Object.class, "add").with(id, eventType, handler, scope);
    }

    public static JsFunc<Object> add(IValueBinding<String> id, IValueBinding<String> eventType, IValueBinding<Object> handler, IValueBinding<Object> scope){
        return call(S, Object.class, "add").with(id, eventType, handler, scope);
    }

    public static JsFunc<Object> addEventListener(HTMLElementJsr elem, String type, Object listener, Object scope, boolean capture){
        return call(S, Object.class, "addEventListener").with(elem, type, listener, scope, capture);
    }

    public static JsFunc<Object> addEventListener(IValueBinding<? extends HTMLElementJsr> elem, IValueBinding<String> type, IValueBinding<Object> listener, IValueBinding<Object> scope, IValueBinding<Boolean> capture){
        return call(S, Object.class, "addEventListener").with(elem, type, listener, scope, checkS(capture));
    }

    public static JsFunc<Object> addEventListener(HTMLElementJsr elem, String type, Object listener, Object scope){
        return call(S, Object.class, "addEventListener").with(elem, type, listener, scope);
    }

    public static JsFunc<Object> addEventListener(IValueBinding<? extends HTMLElementJsr> elem, IValueBinding<String> type, IValueBinding<Object> listener, IValueBinding<Object> scope){
        return call(S, Object.class, "addEventListener").with(elem, type, listener, scope);
    }

    public static JsFunc<Object> addEventListener(WindowJsr elem, String type, Object listener, Object scope){
        return call(S, Object.class, "addEventListener").with(elem, type, listener, scope);
    }

    public static JsFunc<Object> addEventListener(IValueBinding<? extends WindowJsr> elem, IValueBinding<String> type, IValueBinding<Object> listener, IValueBinding<Object> scope, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(S, Object.class, "addEventListener").with(elem, type, listener, scope);
    }

    public static JsFunc<Object> addEventListener(String elem, String type, Object listener, Object scope){
        return call(S, Object.class, "addEventListener").with(elem, type, listener, scope);
    }

    public static JsFunc<Object> addEventListener(IValueBinding<String> elem, IValueBinding<String> type, IValueBinding<Object> listener, IValueBinding<Object> scope, 
            org.eclipse.vjet.vsf.jsref.d.D2... notUsed){
        return call(S, Object.class, "addEventListener").with(elem, type, listener, scope);
    }

    public static JsFunc<Object> bind(String id, String eventType){
        return call(S, Object.class, "bind").with(id, eventType);
    }

    public static JsFunc<Object> bind(IValueBinding<String> id, IValueBinding<String> eventType){
        return call(S, Object.class, "bind").with(id, eventType);
    }

    public static JsFunc<Void> reBind(){
        return call(S, "reBind");
    }

    public static JsFunc<Boolean> isBound(String id, String type){
        return call(S, Boolean.class, "isBound").with(id, type);
    }

    public static JsFunc<Boolean> isBound(IValueBinding<String> id, IValueBinding<String> type){
        return call(S, Boolean.class, "isBound").with(id, type);
    }

    public static JsFunc<Void> removeEventListener(Object elem, String type, Object listener){
        return call(S, "removeEventListener").with(elem, type, listener);
    }

    public static JsFunc<Void> removeEventListener(IValueBinding<Object> elem, IValueBinding<String> type, IValueBinding<Object> listener){
        return call(S, "removeEventListener").with(elem, type, listener);
    }

    public static JsFunc<Void> detachNativeHandlers(Object elem, String type){
        return call(S, "detachNativeHandlers").with(elem, type);
    }

    public static JsFunc<Void> detachNativeHandlers(IValueBinding<Object> elem, IValueBinding<String> type){
        return call(S, "detachNativeHandlers").with(elem, type);
    }

    public static JsFunc<Void> detachHandler(String id, String eventType, Object handler){
        return call(S, "detachHandler").with(id, eventType, handler);
    }

    public static JsFunc<Void> detachHandler(IValueBinding<String> id, IValueBinding<String> eventType, IValueBinding<Object> handler){
        return call(S, "detachHandler").with(id, eventType, handler);
    }

    public static JsFunc<Void> detachHandlers(String id, String eventType){
        return call(S, "detachHandlers").with(id, eventType);
    }

    public static JsFunc<Void> detachHandlers(IValueBinding<String> id, IValueBinding<String> eventType){
        return call(S, "detachHandlers").with(id, eventType);
    }

    public static JsFunc<Void> stopEvent(Object e){
        return call(S, "stopEvent").with(e);
    }

    public static JsFunc<Void> stopPropagation(Object e){
        return call(S, "stopPropagation").with(e);
    }

    public static JsFunc<Void> preventDefault(Object e){
        return call(S, "preventDefault").with(e);
    }

    public static JsFunc<? extends HTMLElementJsr> target(Object event){
        return call(S, HTMLElementJsr.class, "target").with(event);
    }

    public static JsFunc<? extends HTMLElementJsr> relatedTarget(Object event){
        return call(S, HTMLElementJsr.class, "relatedTarget").with(event);
    }

    public static JsFunc<Void> detachAllElemHandlers(Object elem, String eventType){
        return call(S, "detachAllElemHandlers").with(elem, eventType);
    }

    public static JsFunc<Void> detachAllElemHandlers(IValueBinding<Object> elem, IValueBinding<String> eventType){
        return call(S, "detachAllElemHandlers").with(elem, eventType);
    }

    public static JsFunc<Object> unload(Object src, Object pEvent){
        return call(S, Object.class, "unload").with(src, pEvent);
    }

    public static JsFunc<Object> change(Object src, Object pEvent){
        return call(S, Object.class, "change").with(src, pEvent);
    }

    public static JsFunc<Object> submit(Object src, Object pEvent){
        return call(S, Object.class, "submit").with(src, pEvent);
    }

    public static JsFunc<Object> reset(Object src, Object pEvent){
        return call(S, Object.class, "reset").with(src, pEvent);
    }

    public static JsFunc<Object> select(Object src, Object pEvent){
        return call(S, Object.class, "select").with(src, pEvent);
    }

    public static JsFunc<Object> blur(Object src, Object pEvent){
        return call(S, Object.class, "blur").with(src, pEvent);
    }

    public static JsFunc<Object> focus(Object src, Object pEvent){
        return call(S, Object.class, "focus").with(src, pEvent);
    }

    public static JsFunc<Object> keydown(Object src, Object pEvent){
        return call(S, Object.class, "keydown").with(src, pEvent);
    }

    public static JsFunc<Object> keypress(Object src, Object pEvent){
        return call(S, Object.class, "keypress").with(src, pEvent);
    }

    public static JsFunc<Object> keyup(Object src, Object pEvent){
        return call(S, Object.class, "keyup").with(src, pEvent);
    }

    public static JsFunc<Object> click(Object src, Object pEvent){
        return call(S, Object.class, "click").with(src, pEvent);
    }

    public static JsFunc<Object> dblclick(Object src, Object pEvent){
        return call(S, Object.class, "dblclick").with(src, pEvent);
    }

    public static JsFunc<Object> mousedown(Object src, Object pEvent){
        return call(S, Object.class, "mousedown").with(src, pEvent);
    }

    public static JsFunc<Object> mousemove(Object src, Object pEvent){
        return call(S, Object.class, "mousemove").with(src, pEvent);
    }

    public static JsFunc<Object> mouseout(Object src, Object pEvent){
        return call(S, Object.class, "mouseout").with(src, pEvent);
    }

    public static JsFunc<Object> mouseover(Object src, Object pEvent){
        return call(S, Object.class, "mouseover").with(src, pEvent);
    }

    public static JsFunc<Object> mouseup(Object src, Object pEvent){
        return call(S, Object.class, "mouseup").with(src, pEvent);
    }

    public static JsFunc<Object> contextmenu(Object src, Object pEvent){
        return call(S, Object.class, "contextmenu").with(src, pEvent);
    }

    public static JsFunc<Object> load(Object src, Object pEvent){
        return call(S, Object.class, "load").with(src, pEvent);
    }

    public static JsFunc<Object> run(Object src, Object pEvent, String eventType){
        return call(S, Object.class, "run").with(src, pEvent, eventType);
    }

    public static JsFunc<Object> run(IValueBinding<Object> src, IValueBinding<Object> pEvent, IValueBinding<String> eventType){
        return call(S, Object.class, "run").with(src, pEvent, eventType);
    }
    
    public static JsTypeRef<EventDispatcherJsr> prototype = new JsTypeRef<EventDispatcherJsr>(S);
}