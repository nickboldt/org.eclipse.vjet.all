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
package org.eclipse.vjet.vsf.docx;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.jsnative.HtmlImage;

//NativeJsProxy for vjo.dsf.docx.Imagex.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Imagex extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Imagex(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Imagex(Object ...args){
        super(args);
    }

    public Imagex() {
        super();
    }

    public static void load(String psId, String psURL) {
        callStaticWithName("vjo.dsf.docx.Imagex", "load", psId, psURL);
    }

    public static void preload(String psURL) {
        callStaticWithName("vjo.dsf.docx.Imagex", "preload", psURL);
    }

    public static void resize(String ref, int piWidth, int piHeight) {
        callStaticWithName("vjo.dsf.docx.Imagex", "resize", ref, piWidth, piHeight);
    }

    public static void resize(HtmlImage ref, int piWidth, int piHeight) {
        callStaticWithName("vjo.dsf.docx.Imagex", "resize", ref, piWidth, piHeight);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Imagex> prototype = NativeJsTypeRef.get(Imagex.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Imagex>> load = NativeJsFuncProxy.create(prototype, "load");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Imagex>> preload = NativeJsFuncProxy.create(prototype, "preload");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Imagex>> resize = NativeJsFuncProxy.create(prototype, "resize");
}