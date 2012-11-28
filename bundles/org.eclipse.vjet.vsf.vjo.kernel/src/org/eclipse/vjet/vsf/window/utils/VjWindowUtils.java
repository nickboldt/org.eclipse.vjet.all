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
package org.eclipse.vjet.vsf.window.utils;

import org.eclipse.vjet.dsf.javatojs.anno.AJsProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsProxy;
import org.mozilla.mod.javascript.Scriptable;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.dap.proxy.INativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsFuncProxy;
import org.eclipse.vjet.dsf.dap.proxy.NativeJsTypeRef;
import org.eclipse.vjet.dsf.javatojs.anno.AJavaOnly;
import org.eclipse.vjet.dsf.jsnative.events.MouseEvent;
import org.eclipse.vjet.dsf.jsnative.HtmlElement;

//NativeJsProxy for vjo.dsf.window.utils.VjWindowUtils.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class VjWindowUtils extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public VjWindowUtils(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected VjWindowUtils(Object ...args){
        super(args);
    }

    public VjWindowUtils() {
        super();
    }

    public static int getBrowserWindowHeight() {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "getBrowserWindowHeight", Integer.class);
    }

    public static int getBrowserWindowWidth() {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "getBrowserWindowWidth", Integer.class);
    }

    public static Object getScrollXY() {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "getScrollXY", Object.class);
    }

    public static String toPixels(int number) {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "toPixels", String.class, number);
    }

    public static int scrollTop() {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "scrollTop", Integer.class);
    }

    public static int scrollLeft() {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "scrollLeft", Integer.class);
    }

    public static int scrollWidth() {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "scrollWidth", Integer.class);
    }

    public static int scrollHeight() {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "scrollHeight", Integer.class);
    }

    public static int clientTop() {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "clientTop", Integer.class);
    }

    public static int clientLeft() {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "clientLeft", Integer.class);
    }

    public static int clientWidth() {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "clientWidth", Integer.class);
    }

    public static int clientHeight() {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "clientHeight", Integer.class);
    }

    public static int browserTop() {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "browserTop", Integer.class);
    }

    public static int browserLeft() {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "browserLeft", Integer.class);
    }

    public static int eventTop(MouseEvent event) {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "eventTop", Integer.class, event);
    }

    public static int eventLeft(MouseEvent event) {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "eventLeft", Integer.class, event);
    }

    public static int offsetTop(HtmlElement element) {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "offsetTop", Integer.class, element);
    }

    public static int offsetLeft(HtmlElement element) {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "offsetLeft", Integer.class, element);
    }

    public static Object openWindow(String url, String name, Object features) {
        return callStaticWithName("vjo.dsf.window.utils.VjWindowUtils", "openWindow", Object.class, url, name, features);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<VjWindowUtils> prototype = NativeJsTypeRef.get(VjWindowUtils.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> getBrowserWindowHeight = NativeJsFuncProxy.create(prototype, "getBrowserWindowHeight");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> getBrowserWindowWidth = NativeJsFuncProxy.create(prototype, "getBrowserWindowWidth");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> getScrollXY = NativeJsFuncProxy.create(prototype, "getScrollXY");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> toPixels = NativeJsFuncProxy.create(prototype, "toPixels");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> scrollTop = NativeJsFuncProxy.create(prototype, "scrollTop");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> scrollLeft = NativeJsFuncProxy.create(prototype, "scrollLeft");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> scrollWidth = NativeJsFuncProxy.create(prototype, "scrollWidth");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> scrollHeight = NativeJsFuncProxy.create(prototype, "scrollHeight");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> clientTop = NativeJsFuncProxy.create(prototype, "clientTop");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> clientLeft = NativeJsFuncProxy.create(prototype, "clientLeft");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> clientWidth = NativeJsFuncProxy.create(prototype, "clientWidth");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> clientHeight = NativeJsFuncProxy.create(prototype, "clientHeight");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> browserTop = NativeJsFuncProxy.create(prototype, "browserTop");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> browserLeft = NativeJsFuncProxy.create(prototype, "browserLeft");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> eventTop = NativeJsFuncProxy.create(prototype, "eventTop");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> eventLeft = NativeJsFuncProxy.create(prototype, "eventLeft");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> offsetTop = NativeJsFuncProxy.create(prototype, "offsetTop");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> offsetLeft = NativeJsFuncProxy.create(prototype, "offsetLeft");

    public static final INativeJsFuncProxy<NativeJsTypeRef<VjWindowUtils>> openWindow = NativeJsFuncProxy.create(prototype, "openWindow");
}