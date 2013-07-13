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

//NativeJsProxy for vjo.dsf.Enc.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Enc extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Enc(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Enc(Object ...args){
        super(args);
    }

    public Enc() {
        super();
    }

    public static void unescape(String p0) {
        callStaticWithName("vjo.dsf.Enc", "unescape", p0);
    }

    public static void decodeURI(String p0) {
        callStaticWithName("vjo.dsf.Enc", "decodeURI", p0);
    }

    public static void decodeURIComponent(String p0) {
        callStaticWithName("vjo.dsf.Enc", "decodeURIComponent", p0);
    }

    public static void encodeURIComponent(String p0) {
        callStaticWithName("vjo.dsf.Enc", "encodeURIComponent", p0);
    }

    public static void encodeURI(String p0) {
        callStaticWithName("vjo.dsf.Enc", "encodeURI", p0);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Enc> prototype = NativeJsTypeRef.get(Enc.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Enc>> unescape = NativeJsFuncProxy.create(prototype, "unescape");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Enc>> decodeURI = NativeJsFuncProxy.create(prototype, "decodeURI");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Enc>> decodeURIComponent = NativeJsFuncProxy.create(prototype, "decodeURIComponent");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Enc>> encodeURIComponent = NativeJsFuncProxy.create(prototype, "encodeURIComponent");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Enc>> encodeURI = NativeJsFuncProxy.create(prototype, "encodeURI");
}