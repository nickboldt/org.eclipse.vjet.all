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

//NativeJsProxy for vjo.dsf.Element.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Element extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Element(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Element(Object ...args){
        super(args);
    }

    public Element() {
        super();
    }

    public static Object get(String psId) {
        return callStaticWithName("vjo.dsf.Element", "get", Object.class, psId);
    }

    public static void toggleHideShow(String psId, boolean pbDisplay) {
        callStaticWithName("vjo.dsf.Element", "toggleHideShow", psId, pbDisplay);
    }

    public static void toggleHideShow(String psId) {
        callStaticWithName("vjo.dsf.Element", "toggleHideShow", psId);
    }

    public static void promoteToBody(String psId) {
        callStaticWithName("vjo.dsf.Element", "promoteToBody", psId);
    }

    public static void toggleVisibility(String psId, boolean pbVisible) {
        callStaticWithName("vjo.dsf.Element", "toggleVisibility", psId, pbVisible);
    }

    public static void toggleVisibility(String psId) {
        callStaticWithName("vjo.dsf.Element", "toggleVisibility", psId);
    }

    public static void enable(String psId, boolean pbEnable) {
        callStaticWithName("vjo.dsf.Element", "enable", psId, pbEnable);
    }

    public static String left(String psId, String psLeft) {
        return callStaticWithName("vjo.dsf.Element", "left", String.class, psId, psLeft);
    }

    public static String top(String psId, String psTop) {
        return callStaticWithName("vjo.dsf.Element", "top", String.class, psId, psTop);
    }

    public static String width(String psId, String psWidth) {
        return callStaticWithName("vjo.dsf.Element", "width", String.class, psId, psWidth);
    }

    public static String height(String psId, String psHeight) {
        return callStaticWithName("vjo.dsf.Element", "height", String.class, psId, psHeight);
    }

    public static Object createElement(String name) {
        return callStaticWithName("vjo.dsf.Element", "createElement", Object.class, name);
    }

    public static Object getElementByTagClass(Object element, String tag, String name) {
        return callStaticWithName("vjo.dsf.Element", "getElementByTagClass", Object.class, element, tag, name);
    }

    public static Object getElementsByTagClass(Object element, String tag, String name) {
        return callStaticWithName("vjo.dsf.Element", "getElementsByTagClass", Object.class, element, tag, name);
    }

    public static void toggleHideShowRow(String psId, boolean pbDisplay) {
        callStaticWithName("vjo.dsf.Element", "toggleHideShowRow", psId, pbDisplay);
    }

    public static void toggleHideShowRow(String psId) {
        callStaticWithName("vjo.dsf.Element", "toggleHideShowRow", psId);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Element> prototype = NativeJsTypeRef.get(Element.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Element>> get = NativeJsFuncProxy.create(prototype, "get");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Element>> toggleHideShow = NativeJsFuncProxy.create(prototype, "toggleHideShow");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Element>> promoteToBody = NativeJsFuncProxy.create(prototype, "promoteToBody");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Element>> toggleVisibility = NativeJsFuncProxy.create(prototype, "toggleVisibility");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Element>> enable = NativeJsFuncProxy.create(prototype, "enable");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Element>> left = NativeJsFuncProxy.create(prototype, "left");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Element>> top = NativeJsFuncProxy.create(prototype, "top");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Element>> width = NativeJsFuncProxy.create(prototype, "width");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Element>> height = NativeJsFuncProxy.create(prototype, "height");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Element>> createElement = NativeJsFuncProxy.create(prototype, "createElement");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Element>> getElementByTagClass = NativeJsFuncProxy.create(prototype, "getElementByTagClass");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Element>> getElementsByTagClass = NativeJsFuncProxy.create(prototype, "getElementsByTagClass");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Element>> toggleHideShowRow = NativeJsFuncProxy.create(prototype, "toggleHideShowRow");
}