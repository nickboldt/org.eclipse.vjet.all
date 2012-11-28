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

//NativeJsProxy for vjo.dsf.utils.Html.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Html extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Html(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Html(Object ...args){
        super(args);
    }

    public Html() {
        super();
    }

    public static String encode(String psStr) {
        return callStaticWithName("vjo.dsf.utils.Html", "encode", String.class, psStr);
    }

    public static String strip(String psStr) {
        return callStaticWithName("vjo.dsf.utils.Html", "strip", String.class, psStr);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Html> prototype = NativeJsTypeRef.get(Html.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Html>> encode = NativeJsFuncProxy.create(prototype, "encode");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Html>> strip = NativeJsFuncProxy.create(prototype, "strip");
}