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

//NativeJsProxy for vjo.dsf.utils.TokenReplacement.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class TokenReplacement extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public TokenReplacement(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected TokenReplacement(Object ...args){
        super(args);
    }

    public TokenReplacement() {
        super();
    }

    public static String replaceToken(String pStr, String pToken, String pRepl) {
        return callStaticWithName("vjo.dsf.utils.TokenReplacement", "replaceToken", String.class, pStr, pToken, pRepl);
    }

    public static String replaceTokensEx(String pSource, String pPattern) {
        return callStaticWithName("vjo.dsf.utils.TokenReplacement", "replaceTokensEx", String.class, pSource, pPattern);
    }

    public static String replaceTokens(String pSource) {
        return callStaticWithName("vjo.dsf.utils.TokenReplacement", "replaceTokens", String.class, pSource);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<TokenReplacement> prototype = NativeJsTypeRef.get(TokenReplacement.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<TokenReplacement>> replaceToken = NativeJsFuncProxy.create(prototype, "replaceToken");

    public static final INativeJsFuncProxy<NativeJsTypeRef<TokenReplacement>> replaceTokensEx = NativeJsFuncProxy.create(prototype, "replaceTokensEx");

    public static final INativeJsFuncProxy<NativeJsTypeRef<TokenReplacement>> replaceTokens = NativeJsFuncProxy.create(prototype, "replaceTokens");
}