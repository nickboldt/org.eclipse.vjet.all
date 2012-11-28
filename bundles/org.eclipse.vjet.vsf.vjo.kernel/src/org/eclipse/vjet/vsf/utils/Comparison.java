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

//NativeJsProxy for vjo.dsf.utils.Comparison.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Comparison extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Comparison(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Comparison(Object ...args){
        super(args);
    }

    public Comparison() {
        super();
    }

    public static boolean has(String pSrc, String pStr) {
        return callStaticWithName("vjo.dsf.utils.Comparison", "has", Boolean.class, pSrc, pStr);
    }

    public static boolean hasArg(String pSrc, String pArg) {
        return callStaticWithName("vjo.dsf.utils.Comparison", "hasArg", Boolean.class, pSrc, pArg);
    }

    public static boolean hasAny(String pSrc, String... p1) {
        return callStaticWithName("vjo.dsf.utils.Comparison", "hasAny", Boolean.class, pSrc, p1);
    }

    public static boolean hasAll(String pSrc, String... p1) {
        return callStaticWithName("vjo.dsf.utils.Comparison", "hasAll", Boolean.class, pSrc, p1);
    }

    public static boolean is(String pSrc, String pTarget) {
        return callStaticWithName("vjo.dsf.utils.Comparison", "is", Boolean.class, pSrc, pTarget);
    }

    public static boolean isAny(String pSrc, String... p1) {
        return callStaticWithName("vjo.dsf.utils.Comparison", "isAny", Boolean.class, pSrc, p1);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Comparison> prototype = NativeJsTypeRef.get(Comparison.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Comparison>> has = NativeJsFuncProxy.create(prototype, "has");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Comparison>> hasArg = NativeJsFuncProxy.create(prototype, "hasArg");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Comparison>> hasAny = NativeJsFuncProxy.create(prototype, "hasAny");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Comparison>> hasAll = NativeJsFuncProxy.create(prototype, "hasAll");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Comparison>> is = NativeJsFuncProxy.create(prototype, "is");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Comparison>> isAny = NativeJsFuncProxy.create(prototype, "isAny");
}