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

//NativeJsProxy for vjo.dsf.utils.ParseSets.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class ParseSets extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public ParseSets(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected ParseSets(Object ...args){
        super(args);
    }

    public ParseSets() {
        super();
    }

    public static String[] parseSets(String source, String s, String v, String n) {
        return callStaticWithName("vjo.dsf.utils.ParseSets", "parseSets", String[].class, source, s, v, n);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<ParseSets> prototype = NativeJsTypeRef.get(ParseSets.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<ParseSets>> parseSets = NativeJsFuncProxy.create(prototype, "parseSets");
}