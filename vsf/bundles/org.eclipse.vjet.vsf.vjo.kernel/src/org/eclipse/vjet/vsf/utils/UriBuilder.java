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

//NativeJsProxy for vjo.dsf.utils.UriBuilder.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class UriBuilder extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public UriBuilder(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected UriBuilder(Object ...args){
        super(args);
    }

    public UriBuilder(String uri, boolean decode) {
        super(uri, decode);
    }

    public static String meta(String name, String value) {
        return callStaticWithName("vjo.dsf.utils.UriBuilder", "meta", String.class, name, value);
    }

    public void parse(String uri, boolean decode) {
        callWithName("parse", uri, decode);
    }

    public void appendParam(String name, String value, Object params) {
        callWithName("appendParam", name, value, params);
    }

    public void appendParams(Object params) {
        callWithName("appendParams", params);
    }

    public void decodeParams(String query) {
        callWithName("decodeParams", query);
    }

    public String encodeParams(Object params) {
        return callWithName("encodeParams", String.class, params);
    }

    public void decodeSeo() {
        callWithName("decodeSeo");
    }

    public Object decodeForm(Object form) {
        return callWithName("decodeForm", Object.class, form);
    }

    public void appendSelect(Object select, Object params) {
        callWithName("appendSelect", select, params);
    }

    public String getUri() {
        return callWithName("getUri", String.class);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<UriBuilder> prototype = NativeJsTypeRef.get(UriBuilder.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<UriBuilder>> meta = NativeJsFuncProxy.create(prototype, "meta");

    public final INativeJsFuncProxy<UriBuilder> parse = NativeJsFuncProxy.create(this, "parse");

    public final INativeJsFuncProxy<UriBuilder> appendParam = NativeJsFuncProxy.create(this, "appendParam");

    public final INativeJsFuncProxy<UriBuilder> appendParams = NativeJsFuncProxy.create(this, "appendParams");

    public final INativeJsFuncProxy<UriBuilder> decodeParams = NativeJsFuncProxy.create(this, "decodeParams");

    public final INativeJsFuncProxy<UriBuilder> encodeParams = NativeJsFuncProxy.create(this, "encodeParams");

    public final INativeJsFuncProxy<UriBuilder> decodeSeo = NativeJsFuncProxy.create(this, "decodeSeo");

    public final INativeJsFuncProxy<UriBuilder> decodeForm = NativeJsFuncProxy.create(this, "decodeForm");

    public final INativeJsFuncProxy<UriBuilder> appendSelect = NativeJsFuncProxy.create(this, "appendSelect");

    public final INativeJsFuncProxy<UriBuilder> getUri = NativeJsFuncProxy.create(this, "getUri");
}