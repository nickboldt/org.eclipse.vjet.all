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

//NativeJsProxy for vjo.dsf.EventBindingUtil.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class EventBindingUtil extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public EventBindingUtil(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected EventBindingUtil(Object ...args){
        super(args);
    }

    public EventBindingUtil() {
        super();
    }

    public static void detachAll(Object elem, boolean cleanAssociators) {
        callStaticWithName("vjo.dsf.EventBindingUtil", "detachAll", elem, cleanAssociators);
    }

    public static void detachEvents(HtmlElement elem, boolean cleanAssociators) {
        callStaticWithName("vjo.dsf.EventBindingUtil", "detachEvents", elem, cleanAssociators);
    }

    public static void cleanUp(String elemIds) {
        callStaticWithName("vjo.dsf.EventBindingUtil", "cleanUp", elemIds);
    }

    public static void cleanUp(String[] elemIds) {
        callStaticWithName("vjo.dsf.EventBindingUtil", "cleanUp", elemIds);
    }

    public static void cleanUp(String elemIds, boolean cleanDescendents) {
        callStaticWithName("vjo.dsf.EventBindingUtil", "cleanUp", elemIds, cleanDescendents);
    }

    public static void cleanUp(String[] elemIds, boolean cleanDescendents) {
        callStaticWithName("vjo.dsf.EventBindingUtil", "cleanUp", elemIds, cleanDescendents);
    }

    public static void cleanUp(String elemIds, boolean cleanDescendents, boolean cleanAssocElems) {
        callStaticWithName("vjo.dsf.EventBindingUtil", "cleanUp", elemIds, cleanDescendents, cleanAssocElems);
    }

    public static void cleanUp(String[] elemIds, boolean cleanDescendents, boolean cleanAssocElems) {
        callStaticWithName("vjo.dsf.EventBindingUtil", "cleanUp", elemIds, cleanDescendents, cleanAssocElems);
    }

    public static void register(String elemId, String associator) {
        callStaticWithName("vjo.dsf.EventBindingUtil", "register", elemId, associator);
    }

    public static void unregister(String elemId, String associator) {
        callStaticWithName("vjo.dsf.EventBindingUtil", "unregister", elemId, associator);
    }

    public static void bind(String id, String eventType, Object handler, Object scope, Object associator) {
        callStaticWithName("vjo.dsf.EventBindingUtil", "bind", id, eventType, handler, scope, associator);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<EventBindingUtil> prototype = NativeJsTypeRef.get(EventBindingUtil.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventBindingUtil>> detachAll = NativeJsFuncProxy.create(prototype, "detachAll");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventBindingUtil>> detachEvents = NativeJsFuncProxy.create(prototype, "detachEvents");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventBindingUtil>> cleanUp = NativeJsFuncProxy.create(prototype, "cleanUp");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventBindingUtil>> register = NativeJsFuncProxy.create(prototype, "register");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventBindingUtil>> unregister = NativeJsFuncProxy.create(prototype, "unregister");

    public static final INativeJsFuncProxy<NativeJsTypeRef<EventBindingUtil>> bind = NativeJsFuncProxy.create(prototype, "bind");
}