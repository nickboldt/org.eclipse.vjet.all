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
import org.eclipse.vjet.vsf.Message;

//NativeJsProxy for vjo.dsf.ServiceEngine.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class ServiceEngine extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public ServiceEngine(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected ServiceEngine(Object ...args){
        super(args);
    }

    public ServiceEngine() {
        super();
    }

    public static void init() {
        callStaticWithName("vjo.dsf.ServiceEngine", "init");
    }

    public static boolean handleRequest(Message m) {
        return callStaticWithName("vjo.dsf.ServiceEngine", "handleRequest", Boolean.class, m);
    }

    public static void handleResponse(Message msg) {
        callStaticWithName("vjo.dsf.ServiceEngine", "handleResponse", msg);
    }

    public static void handleResponse(Message msg, String jumpto) {
        callStaticWithName("vjo.dsf.ServiceEngine", "handleResponse", msg, jumpto);
    }

    public static void registerSvcHdl(String svcId, Object handler) {
        callStaticWithName("vjo.dsf.ServiceEngine", "registerSvcHdl", svcId, handler);
    }

    public static Object getSvcHdl(String svcId) {
        return callStaticWithName("vjo.dsf.ServiceEngine", "getSvcHdl", Object.class, svcId);
    }

    public static void registerSvcReqtHdl(String svcId, Object handler) {
        callStaticWithName("vjo.dsf.ServiceEngine", "registerSvcReqtHdl", svcId, handler);
    }

    public static void registerSvcRespHdl(String svcId, Object handler) {
        callStaticWithName("vjo.dsf.ServiceEngine", "registerSvcRespHdl", svcId, handler);
    }

    public static void registerGlbReqtHdl(Object handler) {
        callStaticWithName("vjo.dsf.ServiceEngine", "registerGlbReqtHdl", handler);
    }

    public static void registerGlbRespHdl(Object handler) {
        callStaticWithName("vjo.dsf.ServiceEngine", "registerGlbRespHdl", handler);
    }

    public static void registerTrspReqtHdl(String transportType, Object handler) {
        callStaticWithName("vjo.dsf.ServiceEngine", "registerTrspReqtHdl", transportType, handler);
    }

    public static void registerTrspRespHdl(String transportType, Object handler) {
        callStaticWithName("vjo.dsf.ServiceEngine", "registerTrspRespHdl", transportType, handler);
    }

    public static void register(int pFuncType, String pServiceId, Object pHandler) {
        callStaticWithName("vjo.dsf.ServiceEngine", "register", pFuncType, pServiceId, pHandler);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<ServiceEngine> prototype = NativeJsTypeRef.get(ServiceEngine.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<ServiceEngine>> init = NativeJsFuncProxy.create(prototype, "init");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ServiceEngine>> handleRequest = NativeJsFuncProxy.create(prototype, "handleRequest");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ServiceEngine>> handleResponse = NativeJsFuncProxy.create(prototype, "handleResponse");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ServiceEngine>> registerSvcHdl = NativeJsFuncProxy.create(prototype, "registerSvcHdl");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ServiceEngine>> getSvcHdl = NativeJsFuncProxy.create(prototype, "getSvcHdl");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ServiceEngine>> registerSvcReqtHdl = NativeJsFuncProxy.create(prototype, "registerSvcReqtHdl");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ServiceEngine>> registerSvcRespHdl = NativeJsFuncProxy.create(prototype, "registerSvcRespHdl");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ServiceEngine>> registerGlbReqtHdl = NativeJsFuncProxy.create(prototype, "registerGlbReqtHdl");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ServiceEngine>> registerGlbRespHdl = NativeJsFuncProxy.create(prototype, "registerGlbRespHdl");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ServiceEngine>> registerTrspReqtHdl = NativeJsFuncProxy.create(prototype, "registerTrspReqtHdl");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ServiceEngine>> registerTrspRespHdl = NativeJsFuncProxy.create(prototype, "registerTrspRespHdl");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ServiceEngine>> register = NativeJsFuncProxy.create(prototype, "register");
}