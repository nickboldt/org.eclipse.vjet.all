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

//NativeJsProxy for vjo.dsf.Service.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Service extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Service(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Service(Object ...args){
        super(args);
    }

    public Service() {
        super();
    }

    public static void callback(Object xmlHttpReq, Message message) {
        callStaticWithName("vjo.dsf.Service", "callback", xmlHttpReq, message);
    }

    public static Object getXmlHttpReq() {
        return callStaticWithName("vjo.dsf.Service", "getXmlHttpReq", Object.class);
    }

    public static String generateReqParams(Message message) {
        return callStaticWithName("vjo.dsf.Service", "generateReqParams", String.class, message);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Service> prototype = NativeJsTypeRef.get(Service.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Service>> callback = NativeJsFuncProxy.create(prototype, "callback");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Service>> getXmlHttpReq = NativeJsFuncProxy.create(prototype, "getXmlHttpReq");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Service>> generateReqParams = NativeJsFuncProxy.create(prototype, "generateReqParams");
}