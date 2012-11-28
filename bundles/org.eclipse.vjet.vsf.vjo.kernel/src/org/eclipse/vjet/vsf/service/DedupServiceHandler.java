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
package org.eclipse.vjet.vsf.service;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.vsf.common.IDedupComparable;
import org.eclipse.vjet.vsf.common.IJsReqHandler;
import org.eclipse.vjet.vsf.common.IJsRespHandler;
import org.eclipse.vjet.vsf.resource.html.event.handler.JsHandlerObjectEnum;

//NativeJsProxy for vjo.dsf.service.DedupServiceHandler.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class DedupServiceHandler extends NativeJsProxy implements IJsRespHandler, IJsReqHandler {

    /** for framework use only */
    @AExclude
    public DedupServiceHandler(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected DedupServiceHandler(Object ...args){
        super(args);
    }

    public DedupServiceHandler(IDedupComparable comparable) {
        super(comparable);
    }

    public void handleRequest(JsHandlerObjectEnum message) {
        callWithName("handleRequest", message);
    }

    public void handleResponse(JsHandlerObjectEnum message) {
        callWithName("handleResponse", message);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<DedupServiceHandler> prototype = NativeJsTypeRef.get(DedupServiceHandler.class);

    public final INativeJsFuncProxy<DedupServiceHandler> handleRequest = NativeJsFuncProxy.create(this, "handleRequest");

    public final INativeJsFuncProxy<DedupServiceHandler> handleResponse = NativeJsFuncProxy.create(this, "handleResponse");
}