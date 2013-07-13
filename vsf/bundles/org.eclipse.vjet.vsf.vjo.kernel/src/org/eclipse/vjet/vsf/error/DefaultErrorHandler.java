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
package org.eclipse.vjet.vsf.error;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;

//NativeJsProxy for vjo.dsf.error.DefaultErrorHandler.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class DefaultErrorHandler extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public DefaultErrorHandler(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected DefaultErrorHandler(Object ...args){
        super(args);
    }

    public DefaultErrorHandler() {
        super();
    }

    public void handle(String psMessage, String psUrl, String psLineNumber) {
        callWithName("handle", psMessage, psUrl, psLineNumber);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<DefaultErrorHandler> prototype = NativeJsTypeRef.get(DefaultErrorHandler.class);

    public final INativeJsFuncProxy<DefaultErrorHandler> handle = NativeJsFuncProxy.create(this, "handle");
}