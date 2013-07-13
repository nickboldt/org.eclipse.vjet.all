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
import org.eclipse.vjet.dsf.dap.svc.IDapSvcCallback;
import org.eclipse.vjet.vsf.IServiceSpec;

//NativeJsProxy for vjo.dsf.DapServiceEngine.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class DapServiceEngine extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public DapServiceEngine(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected DapServiceEngine(Object ...args){
        super(args);
    }

    public DapServiceEngine() {
        super();
    }

    public static void subscribe() {
        callStaticWithName("vjo.dsf.DapServiceEngine", "subscribe");
    }

    public static void subscribe_2_0(IServiceSpec svcSpec, IDapSvcCallback handler) {
        callStaticWithName("vjo.dsf.DapServiceEngine", "subscribe_2_0", svcSpec, handler);
    }

    public static void subscribe_3_0(IServiceSpec svcSpec, String opName, IDapSvcCallback handler) {
        callStaticWithName("vjo.dsf.DapServiceEngine", "subscribe_3_0", svcSpec, opName, handler);
    }

    public static void publish() {
        callStaticWithName("vjo.dsf.DapServiceEngine", "publish");
    }

    public static void publish_3_0(String svcName, Object request, IDapSvcCallback callback) {
        callStaticWithName("vjo.dsf.DapServiceEngine", "publish_3_0", svcName, request, callback);
    }

    public static void publish_4_0(String svcName, String opName, Object request, IDapSvcCallback callback) {
        callStaticWithName("vjo.dsf.DapServiceEngine", "publish_4_0", svcName, opName, request, callback);
    }

    public static void publish_3_1(IServiceSpec svcSpec, Object request, IDapSvcCallback callback) {
        callStaticWithName("vjo.dsf.DapServiceEngine", "publish_3_1", svcSpec, request, callback);
    }

    public static void publish_4_1(IServiceSpec svcSpec, String opName, Object request, Object callback) {
        callStaticWithName("vjo.dsf.DapServiceEngine", "publish_4_1", svcSpec, opName, request, callback);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<DapServiceEngine> prototype = NativeJsTypeRef.get(DapServiceEngine.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<DapServiceEngine>> subscribe = NativeJsFuncProxy.create(prototype, "subscribe");

    public static final INativeJsFuncProxy<NativeJsTypeRef<DapServiceEngine>> subscribe_2_0 = NativeJsFuncProxy.create(prototype, "subscribe_2_0");

    public static final INativeJsFuncProxy<NativeJsTypeRef<DapServiceEngine>> subscribe_3_0 = NativeJsFuncProxy.create(prototype, "subscribe_3_0");

    public static final INativeJsFuncProxy<NativeJsTypeRef<DapServiceEngine>> publish = NativeJsFuncProxy.create(prototype, "publish");

    public static final INativeJsFuncProxy<NativeJsTypeRef<DapServiceEngine>> publish_3_0 = NativeJsFuncProxy.create(prototype, "publish_3_0");

    public static final INativeJsFuncProxy<NativeJsTypeRef<DapServiceEngine>> publish_4_0 = NativeJsFuncProxy.create(prototype, "publish_4_0");

    public static final INativeJsFuncProxy<NativeJsTypeRef<DapServiceEngine>> publish_3_1 = NativeJsFuncProxy.create(prototype, "publish_3_1");

    public static final INativeJsFuncProxy<NativeJsTypeRef<DapServiceEngine>> publish_4_1 = NativeJsFuncProxy.create(prototype, "publish_4_1");
}