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

//NativeJsProxy for vjo.dsf.utils.JsLoader.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class JsLoader extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public JsLoader(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected JsLoader(Object ...args){
        super(args);
    }

    public JsLoader() {
        super();
    }

    public static void load(String psUrl) {
        callStaticWithName("vjo.dsf.utils.JsLoader", "load", psUrl);
    }

    public static void load(String psUrl, Object poCallback) {
        callStaticWithName("vjo.dsf.utils.JsLoader", "load", psUrl, poCallback);
    }

    public static void load(String psUrl, Object poCallback, Object poScope) {
        callStaticWithName("vjo.dsf.utils.JsLoader", "load", psUrl, poCallback, poScope);
    }

    public static void load(String psUrl, Object poCallback, Object poScope, String psType) {
        callStaticWithName("vjo.dsf.utils.JsLoader", "load", psUrl, poCallback, poScope, psType);
    }

    public static void loadText(String psJsText) {
        callStaticWithName("vjo.dsf.utils.JsLoader", "loadText", psJsText);
    }

    public static Object getHead() {
        return callStaticWithName("vjo.dsf.utils.JsLoader", "getHead", Object.class);
    }

    public static Object createScript() {
        return callStaticWithName("vjo.dsf.utils.JsLoader", "createScript", Object.class);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<JsLoader> prototype = NativeJsTypeRef.get(JsLoader.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<JsLoader>> load = NativeJsFuncProxy.create(prototype, "load");

    public static final INativeJsFuncProxy<NativeJsTypeRef<JsLoader>> loadText = NativeJsFuncProxy.create(prototype, "loadText");

    public static final INativeJsFuncProxy<NativeJsTypeRef<JsLoader>> getHead = NativeJsFuncProxy.create(prototype, "getHead");

    public static final INativeJsFuncProxy<NativeJsTypeRef<JsLoader>> createScript = NativeJsFuncProxy.create(prototype, "createScript");
}