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

//NativeJsProxy for vjo.dsf.error.ErrorHandlerManager.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class ErrorHandlerManager extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public ErrorHandlerManager(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected ErrorHandlerManager(Object ...args){
        super(args);
    }

    public ErrorHandlerManager() {
        super();
    }

    public static boolean add(String psMessage, String psUrl, String psLineNumber) {
        return callStaticWithName("vjo.dsf.error.ErrorHandlerManager", "add", Boolean.class, psMessage, psUrl, psLineNumber);
    }

    public static String convertErrorTo(boolean pbIsHTML) {
        return callStaticWithName("vjo.dsf.error.ErrorHandlerManager", "convertErrorTo", String.class, pbIsHTML);
    }

    public static String toHTML() {
        return callStaticWithName("vjo.dsf.error.ErrorHandlerManager", "toHTML", String.class);
    }

    public static String toText() {
        return callStaticWithName("vjo.dsf.error.ErrorHandlerManager", "toText", String.class);
    }

    public static void show() {
        callStaticWithName("vjo.dsf.error.ErrorHandlerManager", "show");
    }

    public static void register(Object handler) {
        callStaticWithName("vjo.dsf.error.ErrorHandlerManager", "register", handler);
    }

    public static void clear() {
        callStaticWithName("vjo.dsf.error.ErrorHandlerManager", "clear");
    }

    public static void process(String psMessage, String psUrl, String psLineNumber) {
        callStaticWithName("vjo.dsf.error.ErrorHandlerManager", "process", psMessage, psUrl, psLineNumber);
    }

    public static void enableOnError(boolean hideJsErrors) {
        callStaticWithName("vjo.dsf.error.ErrorHandlerManager", "enableOnError", hideJsErrors);
    }

    public static void enableOnError(boolean hideJsErrors, boolean addStackTrace) {
        callStaticWithName("vjo.dsf.error.ErrorHandlerManager", "enableOnError", hideJsErrors, addStackTrace);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<ErrorHandlerManager> prototype = NativeJsTypeRef.get(ErrorHandlerManager.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<ErrorHandlerManager>> add = NativeJsFuncProxy.create(prototype, "add");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ErrorHandlerManager>> convertErrorTo = NativeJsFuncProxy.create(prototype, "convertErrorTo");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ErrorHandlerManager>> toHTML = NativeJsFuncProxy.create(prototype, "toHTML");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ErrorHandlerManager>> toText = NativeJsFuncProxy.create(prototype, "toText");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ErrorHandlerManager>> show = NativeJsFuncProxy.create(prototype, "show");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ErrorHandlerManager>> register = NativeJsFuncProxy.create(prototype, "register");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ErrorHandlerManager>> clear = NativeJsFuncProxy.create(prototype, "clear");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ErrorHandlerManager>> process = NativeJsFuncProxy.create(prototype, "process");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ErrorHandlerManager>> enableOnError = NativeJsFuncProxy.create(prototype, "enableOnError");
}