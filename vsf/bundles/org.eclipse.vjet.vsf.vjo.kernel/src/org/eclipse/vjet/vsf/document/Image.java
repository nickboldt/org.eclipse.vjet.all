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
package org.eclipse.vjet.vsf.document;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;

//NativeJsProxy for vjo.dsf.document.Image.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Image extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Image(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Image(Object ...args){
        super(args);
    }

    public Image() {
        super();
    }

    public static void load(String psId, String psURL) {
        callStaticWithName("vjo.dsf.document.Image", "load", psId, psURL);
    }

    public static void preload(String psURL) {
        callStaticWithName("vjo.dsf.document.Image", "preload", psURL);
    }

    public static void resize(String psId, int piWidth, int piHeight) {
        callStaticWithName("vjo.dsf.document.Image", "resize", psId, piWidth, piHeight);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Image> prototype = NativeJsTypeRef.get(Image.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Image>> load = NativeJsFuncProxy.create(prototype, "load");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Image>> preload = NativeJsFuncProxy.create(prototype, "preload");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Image>> resize = NativeJsFuncProxy.create(prototype, "resize");
}