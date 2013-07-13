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
import org.eclipse.vjet.vsf.Message;

//NativeJsProxy for vjo.dsf.SvcErr.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class SvcErr extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public SvcErr(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected SvcErr(Object ...args){
        super(args);
    }

    public SvcErr() {
        super();
    }

    public static final String InvRsp = getStaticProperty("vjo.dsf.SvcErr", "InvRsp", String.class);

    public static final String InvRqBnd = getStaticProperty("vjo.dsf.SvcErr", "InvRqBnd", String.class);

    public static final String InvRspBnd = getStaticProperty("vjo.dsf.SvcErr", "InvRspBnd", String.class);

    public static final String InvRq = getStaticProperty("vjo.dsf.SvcErr", "InvRq", String.class);

    public static final String TO = getStaticProperty("vjo.dsf.SvcErr", "TO", String.class);

    public static final String RqUnk = getStaticProperty("vjo.dsf.SvcErr", "RqUnk", String.class);

    public static final String SvcRq = getStaticProperty("vjo.dsf.SvcErr", "SvcRq", String.class);

    public static final String SvcRsp = getStaticProperty("vjo.dsf.SvcErr", "SvcRsp", String.class);

    public static final String GlbRq = getStaticProperty("vjo.dsf.SvcErr", "GlbRq", String.class);

    public static final String GlbRsp = getStaticProperty("vjo.dsf.SvcErr", "GlbRsp", String.class);

    public static final String TrnRq = getStaticProperty("vjo.dsf.SvcErr", "TrnRq", String.class);

    public static final String TrnRsp = getStaticProperty("vjo.dsf.SvcErr", "TrnRsp", String.class);

    public static final String Prs = getStaticProperty("vjo.dsf.SvcErr", "Prs", String.class);

    public static final String SvcPrc = getStaticProperty("vjo.dsf.SvcErr", "SvcPrc", String.class);

    public static void err(Message message, String errorId, String errorMsg) {
        callStaticWithName("vjo.dsf.SvcErr", "err", message, errorId, errorMsg);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<SvcErr> prototype = NativeJsTypeRef.get(SvcErr.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<SvcErr>> err = NativeJsFuncProxy.create(prototype, "err");
}