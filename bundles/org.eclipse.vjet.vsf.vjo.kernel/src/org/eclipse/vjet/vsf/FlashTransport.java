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
import org.eclipse.vjet.vsf.ITransport;
import org.eclipse.vjet.vsf.Message;

//NativeJsProxy for vjo.dsf.FlashTransport.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class FlashTransport extends NativeJsProxy implements ITransport {

    /** for framework use only */
    @AExclude
    public FlashTransport(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected FlashTransport(Object ...args){
        super(args);
    }

    public FlashTransport() {
        super();
    }

    public void handleRequest(Message message, Object callback) {
        callWithName("handleRequest", message, callback);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<FlashTransport> prototype = NativeJsTypeRef.get(FlashTransport.class);

    public final INativeJsFuncProxy<FlashTransport> handleRequest = NativeJsFuncProxy.create(this, "handleRequest");
}