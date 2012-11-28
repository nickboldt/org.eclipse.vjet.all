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

//NativeJsProxy for vjo.dsf.utils.Array.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Array extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Array(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Array(Object ...args){
        super(args);
    }

    public Array() {
        super();
    }

    public static Object[] copy(Object[] poSrcArr) {
        return callStaticWithName("vjo.dsf.utils.Array", "copy", Object[].class, poSrcArr);
    }

    public static Object[] remove(Object[] poSrcArr, int piIndex, String psValue) {
        return callStaticWithName("vjo.dsf.utils.Array", "remove", Object[].class, poSrcArr, piIndex, psValue);
    }

    public static Object[] insert(Object[] poSrcArr, int piIndex, String psValue) {
        return callStaticWithName("vjo.dsf.utils.Array", "insert", Object[].class, poSrcArr, piIndex, psValue);
    }

    public static Object[] shift(Object[] poSrcArr, int piIndex) {
        return callStaticWithName("vjo.dsf.utils.Array", "shift", Object[].class, poSrcArr, piIndex);
    }

    public static boolean contains(Object[] poSrcArr, Object poObject) {
        return callStaticWithName("vjo.dsf.utils.Array", "contains", Boolean.class, poSrcArr, poObject);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Array> prototype = NativeJsTypeRef.get(Array.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Array>> copy = NativeJsFuncProxy.create(prototype, "copy");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Array>> remove = NativeJsFuncProxy.create(prototype, "remove");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Array>> insert = NativeJsFuncProxy.create(prototype, "insert");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Array>> shift = NativeJsFuncProxy.create(prototype, "shift");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Array>> contains = NativeJsFuncProxy.create(prototype, "contains");
}