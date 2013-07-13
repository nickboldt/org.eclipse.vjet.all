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

//NativeJsProxy for vjo.dsf.utils.URL.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class URL extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public URL(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected URL(Object ...args){
        super(args);
    }

    public URL() {
        super();
    }

    public static String addArg(String psUrl, String psArgName, String psArgValue) {
        return callStaticWithName("vjo.dsf.utils.URL", "addArg", String.class, psUrl, psArgName, psArgValue);
    }

    public static String getArg(String psUrl, String psArgName) {
        return callStaticWithName("vjo.dsf.utils.URL", "getArg", String.class, psUrl, psArgName);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<URL> prototype = NativeJsTypeRef.get(URL.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<URL>> addArg = NativeJsFuncProxy.create(prototype, "addArg");

    public static final INativeJsFuncProxy<NativeJsTypeRef<URL>> getArg = NativeJsFuncProxy.create(prototype, "getArg");
}