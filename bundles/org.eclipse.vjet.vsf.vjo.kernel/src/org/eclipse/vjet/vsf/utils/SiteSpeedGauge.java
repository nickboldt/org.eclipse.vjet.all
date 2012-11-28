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

//NativeJsProxy for vjo.dsf.utils.SiteSpeedGauge.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class SiteSpeedGauge extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public SiteSpeedGauge(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected SiteSpeedGauge(Object ...args){
        super(args);
    }

    public SiteSpeedGauge() {
        super();
    }

    public static void gauge() {
        callStaticWithName("vjo.dsf.utils.SiteSpeedGauge", "gauge");
    }

    public static void gaugeUnload() {
        callStaticWithName("vjo.dsf.utils.SiteSpeedGauge", "gaugeUnload");
    }

    public static void gaugeBodyLoad() {
        callStaticWithName("vjo.dsf.utils.SiteSpeedGauge", "gaugeBodyLoad");
    }

    @AJavaOnly
    public static final NativeJsTypeRef<SiteSpeedGauge> prototype = NativeJsTypeRef.get(SiteSpeedGauge.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<SiteSpeedGauge>> gauge = NativeJsFuncProxy.create(prototype, "gauge");

    public static final INativeJsFuncProxy<NativeJsTypeRef<SiteSpeedGauge>> gaugeUnload = NativeJsFuncProxy.create(prototype, "gaugeUnload");

    public static final INativeJsFuncProxy<NativeJsTypeRef<SiteSpeedGauge>> gaugeBodyLoad = NativeJsFuncProxy.create(prototype, "gaugeBodyLoad");
}