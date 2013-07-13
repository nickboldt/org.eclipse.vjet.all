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

//NativeJsProxy for vjo.dsf.utils.Form.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Form extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Form(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Form(Object ...args){
        super(args);
    }

    public Form() {
        super();
    }

    public static String getDataAsNVPairStr(String psFormId) {
        return callStaticWithName("vjo.dsf.utils.Form", "getDataAsNVPairStr", String.class, psFormId);
    }

    public static String getDataAsJSONStr(String psFormId) {
        return callStaticWithName("vjo.dsf.utils.Form", "getDataAsJSONStr", String.class, psFormId);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Form> prototype = NativeJsTypeRef.get(Form.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Form>> getDataAsNVPairStr = NativeJsFuncProxy.create(prototype, "getDataAsNVPairStr");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Form>> getDataAsJSONStr = NativeJsFuncProxy.create(prototype, "getDataAsJSONStr");
}