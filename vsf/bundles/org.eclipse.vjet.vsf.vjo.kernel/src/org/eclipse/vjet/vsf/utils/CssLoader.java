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

//NativeJsProxy for vjo.dsf.utils.CssLoader.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class CssLoader extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public CssLoader(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected CssLoader(Object ...args){
        super(args);
    }

    public CssLoader() {
        super();
    }

    public static void load(String psUrl) {
        callStaticWithName("vjo.dsf.utils.CssLoader", "load", psUrl);
    }

    public static Object getHead() {
        return callStaticWithName("vjo.dsf.utils.CssLoader", "getHead", Object.class);
    }

    public static void loadText(String psText) {
        callStaticWithName("vjo.dsf.utils.CssLoader", "loadText", psText);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<CssLoader> prototype = NativeJsTypeRef.get(CssLoader.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<CssLoader>> load = NativeJsFuncProxy.create(prototype, "load");

    public static final INativeJsFuncProxy<NativeJsTypeRef<CssLoader>> getHead = NativeJsFuncProxy.create(prototype, "getHead");

    public static final INativeJsFuncProxy<NativeJsTypeRef<CssLoader>> loadText = NativeJsFuncProxy.create(prototype, "loadText");
}