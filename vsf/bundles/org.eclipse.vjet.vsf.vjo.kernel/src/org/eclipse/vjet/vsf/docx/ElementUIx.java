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
import org.eclipse.vjet.dsf.jsnative.HtmlElement;

//NativeJsProxy for vjo.dsf.docx.ElementUIx.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class ElementUIx extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public ElementUIx(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected ElementUIx(Object ...args){
        super(args);
    }

    public ElementUIx() {
        super();
    }

    public static void toggleHideShow(String ref, boolean pbDisplay) {
        callStaticWithName("vjo.dsf.docx.ElementUIx", "toggleHideShow", ref, pbDisplay);
    }

    public static void toggleHideShow(String ref) {
        callStaticWithName("vjo.dsf.docx.ElementUIx", "toggleHideShow", ref);
    }

    public static void toggleHideShow(HtmlElement ref, boolean pbDisplay) {
        callStaticWithName("vjo.dsf.docx.ElementUIx", "toggleHideShow", ref, pbDisplay);
    }

    public static void toggleHideShow(HtmlElement ref) {
        callStaticWithName("vjo.dsf.docx.ElementUIx", "toggleHideShow", ref);
    }

    public static void promoteToBody(String ref) {
        callStaticWithName("vjo.dsf.docx.ElementUIx", "promoteToBody", ref);
    }

    public static void toggleVisibility(String ref, boolean pbVisible) {
        callStaticWithName("vjo.dsf.docx.ElementUIx", "toggleVisibility", ref, pbVisible);
    }

    public static void toggleVisibility(String ref) {
        callStaticWithName("vjo.dsf.docx.ElementUIx", "toggleVisibility", ref);
    }

    public static void toggleVisibility(HtmlElement ref, boolean pbVisible) {
        callStaticWithName("vjo.dsf.docx.ElementUIx", "toggleVisibility", ref, pbVisible);
    }

    public static void toggleVisibility(HtmlElement ref) {
        callStaticWithName("vjo.dsf.docx.ElementUIx", "toggleVisibility", ref);
    }

    public static void enable(String psId, boolean pbEnable) {
        callStaticWithName("vjo.dsf.docx.ElementUIx", "enable", psId, pbEnable);
    }

    public static String left(String ref, String psLeft) {
        return callStaticWithName("vjo.dsf.docx.ElementUIx", "left", String.class, ref, psLeft);
    }

    public static String left(HtmlElement ref, String psLeft) {
        return callStaticWithName("vjo.dsf.docx.ElementUIx", "left", String.class, ref, psLeft);
    }

    public static String top(String ref, String psTop) {
        return callStaticWithName("vjo.dsf.docx.ElementUIx", "top", String.class, ref, psTop);
    }

    public static String top(HtmlElement ref, String psTop) {
        return callStaticWithName("vjo.dsf.docx.ElementUIx", "top", String.class, ref, psTop);
    }

    public static String width(String ref, String psWidth) {
        return callStaticWithName("vjo.dsf.docx.ElementUIx", "width", String.class, ref, psWidth);
    }

    public static String width(HtmlElement ref, String psWidth) {
        return callStaticWithName("vjo.dsf.docx.ElementUIx", "width", String.class, ref, psWidth);
    }

    public static String height(String ref, String psHeight) {
        return callStaticWithName("vjo.dsf.docx.ElementUIx", "height", String.class, ref, psHeight);
    }

    public static String height(HtmlElement ref, String psHeight) {
        return callStaticWithName("vjo.dsf.docx.ElementUIx", "height", String.class, ref, psHeight);
    }

    public static void toggleHideShowRow(String ref, boolean pbDisplay) {
        callStaticWithName("vjo.dsf.docx.ElementUIx", "toggleHideShowRow", ref, pbDisplay);
    }

    public static void toggleHideShowRow(String ref) {
        callStaticWithName("vjo.dsf.docx.ElementUIx", "toggleHideShowRow", ref);
    }

    public static void toggleHideShowRow(HtmlElement ref, boolean pbDisplay) {
        callStaticWithName("vjo.dsf.docx.ElementUIx", "toggleHideShowRow", ref, pbDisplay);
    }

    public static void toggleHideShowRow(HtmlElement ref) {
        callStaticWithName("vjo.dsf.docx.ElementUIx", "toggleHideShowRow", ref);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<ElementUIx> prototype = NativeJsTypeRef.get(ElementUIx.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<ElementUIx>> toggleHideShow = NativeJsFuncProxy.create(prototype, "toggleHideShow");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ElementUIx>> promoteToBody = NativeJsFuncProxy.create(prototype, "promoteToBody");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ElementUIx>> toggleVisibility = NativeJsFuncProxy.create(prototype, "toggleVisibility");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ElementUIx>> enable = NativeJsFuncProxy.create(prototype, "enable");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ElementUIx>> left = NativeJsFuncProxy.create(prototype, "left");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ElementUIx>> top = NativeJsFuncProxy.create(prototype, "top");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ElementUIx>> width = NativeJsFuncProxy.create(prototype, "width");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ElementUIx>> height = NativeJsFuncProxy.create(prototype, "height");

    public static final INativeJsFuncProxy<NativeJsTypeRef<ElementUIx>> toggleHideShowRow = NativeJsFuncProxy.create(prototype, "toggleHideShowRow");
}