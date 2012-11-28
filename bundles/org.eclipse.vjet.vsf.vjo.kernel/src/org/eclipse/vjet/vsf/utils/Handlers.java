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
package org.eclipse.vjet.vsf.utils;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.vsf.Message;

//NativeJsProxy for vjo.dsf.utils.Handlers.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Handlers extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Handlers(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Handlers(Object ...args){
        super(args);
    }

    public Handlers() {
        super();
    }

    public static boolean attachEvt(Object target, String type, Object func, Object scope) {
        return callStaticWithName("vjo.dsf.utils.Handlers", "attachEvt", Boolean.class, target, type, func, scope);
    }

    public static boolean detachEvt(Object target, String type, Object hdl) {
        return callStaticWithName("vjo.dsf.utils.Handlers", "detachEvt", Boolean.class, target, type, hdl);
    }

    public static Message newMsg(String svcName) {
        return callStaticWithName("vjo.dsf.utils.Handlers", "newMsg", Message.class, svcName);
    }

    public static void handle(Message msg) {
        callStaticWithName("vjo.dsf.utils.Handlers", "handle", msg);
    }

    public static void attachSvc(String svcName, Object func, Object scope) {
        callStaticWithName("vjo.dsf.utils.Handlers", "attachSvc", svcName, func, scope);
    }

    public static void attachSvcReqt(String svcName, Object func, Object scope) {
        callStaticWithName("vjo.dsf.utils.Handlers", "attachSvcReqt", svcName, func, scope);
    }

    public static void attachSvcResp(String svcName, Object func, Object scope) {
        callStaticWithName("vjo.dsf.utils.Handlers", "attachSvcResp", svcName, func, scope);
    }

    public static void resetSvc(String svcName) {
        callStaticWithName("vjo.dsf.utils.Handlers", "resetSvc", svcName);
    }

    public static void resetSvcReqt(String svcName) {
        callStaticWithName("vjo.dsf.utils.Handlers", "resetSvcReqt", svcName);
    }

    public static void resetSvcResp(String svcName) {
        callStaticWithName("vjo.dsf.utils.Handlers", "resetSvcResp", svcName);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Handlers> prototype = NativeJsTypeRef.get(Handlers.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Handlers>> attachEvt = NativeJsFuncProxy.create(prototype, "attachEvt");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Handlers>> detachEvt = NativeJsFuncProxy.create(prototype, "detachEvt");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Handlers>> newMsg = NativeJsFuncProxy.create(prototype, "newMsg");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Handlers>> handle = NativeJsFuncProxy.create(prototype, "handle");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Handlers>> attachSvc = NativeJsFuncProxy.create(prototype, "attachSvc");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Handlers>> attachSvcReqt = NativeJsFuncProxy.create(prototype, "attachSvcReqt");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Handlers>> attachSvcResp = NativeJsFuncProxy.create(prototype, "attachSvcResp");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Handlers>> resetSvc = NativeJsFuncProxy.create(prototype, "resetSvc");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Handlers>> resetSvcReqt = NativeJsFuncProxy.create(prototype, "resetSvcReqt");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Handlers>> resetSvcResp = NativeJsFuncProxy.create(prototype, "resetSvcResp");
}