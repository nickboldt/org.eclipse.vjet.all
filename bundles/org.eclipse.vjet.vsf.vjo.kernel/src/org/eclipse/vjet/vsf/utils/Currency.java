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

//NativeJsProxy for vjo.dsf.utils.Currency.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Currency extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Currency(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Currency(Object ...args){
        super(args);
    }

    public Currency() {
        super();
    }

    public static float parse(String psVal, boolean pbNonDecimal) {
        return callStaticWithName("vjo.dsf.utils.Currency", "parse", Float.class, psVal, pbNonDecimal);
    }

    public static float round(String psVal, int pNoofDec) {
        return callStaticWithName("vjo.dsf.utils.Currency", "round", Float.class, psVal, pNoofDec);
    }

    public static String format(String psVal, boolean pbNonDecimal, boolean pVATExempt) {
        return callStaticWithName("vjo.dsf.utils.Currency", "format", String.class, psVal, pbNonDecimal, pVATExempt);
    }

    public static boolean isDecimalFormat(String psVal) {
        return callStaticWithName("vjo.dsf.utils.Currency", "isDecimalFormat", Boolean.class, psVal);
    }

    public static String toIntlFormat(String psVal) {
        return callStaticWithName("vjo.dsf.utils.Currency", "toIntlFormat", String.class, psVal);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Currency> prototype = NativeJsTypeRef.get(Currency.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Currency>> parse = NativeJsFuncProxy.create(prototype, "parse");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Currency>> round = NativeJsFuncProxy.create(prototype, "round");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Currency>> format = NativeJsFuncProxy.create(prototype, "format");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Currency>> isDecimalFormat = NativeJsFuncProxy.create(prototype, "isDecimalFormat");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Currency>> toIntlFormat = NativeJsFuncProxy.create(prototype, "toIntlFormat");
}