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

//NativeJsProxy for vjo.dsf.utils.AlphaNumeric.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class AlphaNumeric extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public AlphaNumeric(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected AlphaNumeric(Object ...args){
        super(args);
    }

    public AlphaNumeric() {
        super();
    }

    public static boolean isUpper(String psStr) {
        return callStaticWithName("vjo.dsf.utils.AlphaNumeric", "isUpper", Boolean.class, psStr);
    }

    public static boolean isLower(String psStr) {
        return callStaticWithName("vjo.dsf.utils.AlphaNumeric", "isLower", Boolean.class, psStr);
    }

    public static boolean isAlpha(String psStr) {
        return callStaticWithName("vjo.dsf.utils.AlphaNumeric", "isAlpha", Boolean.class, psStr);
    }

    public static boolean isNumeric(String psStr) {
        return callStaticWithName("vjo.dsf.utils.AlphaNumeric", "isNumeric", Boolean.class, psStr);
    }

    public static boolean isAlphaNumeric(String psStr, String pExceptions) {
        return callStaticWithName("vjo.dsf.utils.AlphaNumeric", "isAlphaNumeric", Boolean.class, psStr, pExceptions);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<AlphaNumeric> prototype = NativeJsTypeRef.get(AlphaNumeric.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<AlphaNumeric>> isUpper = NativeJsFuncProxy.create(prototype, "isUpper");

    public static final INativeJsFuncProxy<NativeJsTypeRef<AlphaNumeric>> isLower = NativeJsFuncProxy.create(prototype, "isLower");

    public static final INativeJsFuncProxy<NativeJsTypeRef<AlphaNumeric>> isAlpha = NativeJsFuncProxy.create(prototype, "isAlpha");

    public static final INativeJsFuncProxy<NativeJsTypeRef<AlphaNumeric>> isNumeric = NativeJsFuncProxy.create(prototype, "isNumeric");

    public static final INativeJsFuncProxy<NativeJsTypeRef<AlphaNumeric>> isAlphaNumeric = NativeJsFuncProxy.create(prototype, "isAlphaNumeric");
}