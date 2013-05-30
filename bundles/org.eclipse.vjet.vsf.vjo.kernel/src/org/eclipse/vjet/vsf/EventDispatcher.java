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

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.jsnative.HtmlElement;
import org.eclipse.vjet.dsf.jsnative.Window;

//NativeJsProxy for org.eclipse.vjet.vsf.EventDispatcher.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class EventDispatcher extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public EventDispatcher(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected EventDispatcher(Object ...args){
        super(args);
    }

    public EventDispatcher() {
        super();
    }

    public static Object process(String srcId, Object event) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "process", Object.class, srcId, event);
    }

    public static Object register(String id, String eventType, Object handler, Object scope) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "register", Object.class, id, eventType, handler, scope);
    }

    public static void unregister(String id, String eventType) {
        callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "unregister", id, eventType);
    }

    public static Object add(String id, String eventType, Object handler, Object scope) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "add", Object.class, id, eventType, handler, scope);
    }

    public static Object addEventListener(HtmlElement elem, String type, Object listener, Object scope, boolean capture) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "addEventListener", Object.class, elem, type, listener, scope, capture);
    }

    public static Object addEventListener(HtmlElement elem, String type, Object listener, Object scope) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "addEventListener", Object.class, elem, type, listener, scope);
    }

    public static Object addEventListener(Window elem, String type, Object listener, Object scope) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "addEventListener", Object.class, elem, type, listener, scope);
    }

    public static Object addEventListener(String elem, String type, Object listener, Object scope) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "addEventListener", Object.class, elem, type, listener, scope);
    }

    public static Object bind(String id, String eventType) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "bind", Object.class, id, eventType);
    }

    public static void reBind() {
        callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "reBind");
    }

    public static boolean isBound(String id, String type) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "isBound", Boolean.class, id, type);
    }

    public static void removeEventListener(Object elem, String type, Object listener) {
        callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "removeEventListener", elem, type, listener);
    }

    public static void detachNativeHandlers(Object elem, String type) {
        callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "detachNativeHandlers", elem, type);
    }

    public static void detachHandler(String id, String eventType, Object handler) {
        callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "detachHandler", id, eventType, handler);
    }

    public static void detachHandlers(String id, String eventType) {
        callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "detachHandlers", id, eventType);
    }

    public static void stopEvent(Object e) {
        callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "stopEvent", e);
    }

    public static void stopPropagation(Object e) {
        callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "stopPropagation", e);
    }

    public static void preventDefault(Object e) {
        callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "preventDefault", e);
    }

    public static HtmlElement target(Object event) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "target", HtmlElement.class, event);
    }

    public static HtmlElement relatedTarget(Object event) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "relatedTarget", HtmlElement.class, event);
    }

    public static void detachAllElemHandlers(Object elem, String eventType) {
        callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "detachAllElemHandlers", elem, eventType);
    }

    public static Object unload(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "unload", Object.class, src, pEvent);
    }

    public static Object change(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "change", Object.class, src, pEvent);
    }

    public static Object submit(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "submit", Object.class, src, pEvent);
    }

    public static Object reset(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "reset", Object.class, src, pEvent);
    }

    public static Object select(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "select", Object.class, src, pEvent);
    }

    public static Object blur(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "blur", Object.class, src, pEvent);
    }

    public static Object focus(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "focus", Object.class, src, pEvent);
    }

    public static Object keydown(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "keydown", Object.class, src, pEvent);
    }

    public static Object keypress(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "keypress", Object.class, src, pEvent);
    }

    public static Object keyup(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "keyup", Object.class, src, pEvent);
    }

    public static Object click(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "click", Object.class, src, pEvent);
    }

    public static Object dblclick(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "dblclick", Object.class, src, pEvent);
    }

    public static Object mousedown(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "mousedown", Object.class, src, pEvent);
    }

    public static Object mousemove(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "mousemove", Object.class, src, pEvent);
    }

    public static Object mouseout(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "mouseout", Object.class, src, pEvent);
    }

    public static Object mouseover(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "mouseover", Object.class, src, pEvent);
    }

    public static Object mouseup(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "mouseup", Object.class, src, pEvent);
    }

    public static Object contextmenu(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "contextmenu", Object.class, src, pEvent);
    }

    public static Object load(Object src, Object pEvent) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "load", Object.class, src, pEvent);
    }

    public static Object run(Object src, Object pEvent, String eventType) {
        return callStaticWithName("org.eclipse.vjet.vsf.EventDispatcher", "run", Object.class, src, pEvent, eventType);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<EventDispatcher> prototype = NativeJsTypeRef.get(EventDispatcher.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> process = NativeJsFuncProxy.create(prototype, "process");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> register = NativeJsFuncProxy.create(prototype, "register");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> unregister = NativeJsFuncProxy.create(prototype, "unregister");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> add = NativeJsFuncProxy.create(prototype, "add");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> addEventListener = NativeJsFuncProxy.create(prototype, "addEventListener");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> bind = NativeJsFuncProxy.create(prototype, "bind");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> reBind = NativeJsFuncProxy.create(prototype, "reBind");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> isBound = NativeJsFuncProxy.create(prototype, "isBound");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> removeEventListener = NativeJsFuncProxy.create(prototype, "removeEventListener");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> detachNativeHandlers = NativeJsFuncProxy.create(prototype, "detachNativeHandlers");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> detachHandler = NativeJsFuncProxy.create(prototype, "detachHandler");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> detachHandlers = NativeJsFuncProxy.create(prototype, "detachHandlers");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> stopEvent = NativeJsFuncProxy.create(prototype, "stopEvent");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> stopPropagation = NativeJsFuncProxy.create(prototype, "stopPropagation");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> preventDefault = NativeJsFuncProxy.create(prototype, "preventDefault");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> target = NativeJsFuncProxy.create(prototype, "target");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> relatedTarget = NativeJsFuncProxy.create(prototype, "relatedTarget");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> detachAllElemHandlers = NativeJsFuncProxy.create(prototype, "detachAllElemHandlers");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> unload = NativeJsFuncProxy.create(prototype, "unload");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> change = NativeJsFuncProxy.create(prototype, "change");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> submit = NativeJsFuncProxy.create(prototype, "submit");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> reset = NativeJsFuncProxy.create(prototype, "reset");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> select = NativeJsFuncProxy.create(prototype, "select");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> blur = NativeJsFuncProxy.create(prototype, "blur");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> focus = NativeJsFuncProxy.create(prototype, "focus");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> keydown = NativeJsFuncProxy.create(prototype, "keydown");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> keypress = NativeJsFuncProxy.create(prototype, "keypress");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> keyup = NativeJsFuncProxy.create(prototype, "keyup");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> click = NativeJsFuncProxy.create(prototype, "click");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> dblclick = NativeJsFuncProxy.create(prototype, "dblclick");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> mousedown = NativeJsFuncProxy.create(prototype, "mousedown");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> mousemove = NativeJsFuncProxy.create(prototype, "mousemove");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> mouseout = NativeJsFuncProxy.create(prototype, "mouseout");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> mouseover = NativeJsFuncProxy.create(prototype, "mouseover");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> mouseup = NativeJsFuncProxy.create(prototype, "mouseup");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> contextmenu = NativeJsFuncProxy.create(prototype, "contextmenu");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> load = NativeJsFuncProxy.create(prototype, "load");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventDispatcher>> run = NativeJsFuncProxy.create(prototype, "run");
}