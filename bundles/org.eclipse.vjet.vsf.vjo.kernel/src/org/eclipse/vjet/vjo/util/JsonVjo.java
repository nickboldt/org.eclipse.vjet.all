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
package org.eclipse.vjet.vjo.util;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;

//NativeJsProxy for vjo.util.JsonVjo.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class JsonVjo extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public JsonVjo(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected JsonVjo(Object ...args){
        super(args);
    }

    public JsonVjo() {
        super();
    }

    public static Object json2vjo(String jsonStr, String typeName) {
        return callStaticWithName("vjo.util.JsonVjo", "json2vjo", Object.class, jsonStr, typeName);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<JsonVjo> prototype = NativeJsTypeRef.get(JsonVjo.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<JsonVjo>> json2vjo = NativeJsFuncProxy.create(prototype, "json2vjo");
}