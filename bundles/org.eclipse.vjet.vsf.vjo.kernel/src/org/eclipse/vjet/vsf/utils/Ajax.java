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

//NativeJsProxy for vjo.dsf.utils.Ajax.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Ajax extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Ajax(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Ajax(Object ...args){
        super(args);
    }

    public Ajax() {
        super();
    }

    public static void apply(String psElementId, String psHtmlText, String psJsText, String psCssText) {
        callStaticWithName("vjo.dsf.utils.Ajax", "apply", psElementId, psHtmlText, psJsText, psCssText);
    }

    public static void cleanApply(String psElementId, String psHtmlText, String psJsText, String psCssText, Object poEventIdMap) {
        callStaticWithName("vjo.dsf.utils.Ajax", "cleanApply", psElementId, psHtmlText, psJsText, psCssText, poEventIdMap);
    }

    public static void clean(Object poEventIdMap) {
        callStaticWithName("vjo.dsf.utils.Ajax", "clean", poEventIdMap);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Ajax> prototype = NativeJsTypeRef.get(Ajax.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Ajax>> apply = NativeJsFuncProxy.create(prototype, "apply");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Ajax>> cleanApply = NativeJsFuncProxy.create(prototype, "cleanApply");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Ajax>> clean = NativeJsFuncProxy.create(prototype, "clean");
}