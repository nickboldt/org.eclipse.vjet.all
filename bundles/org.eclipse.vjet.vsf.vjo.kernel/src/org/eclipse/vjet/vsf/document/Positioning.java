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
import org.eclipse.vjet.dsf.jsnative.events.MouseEvent;

//NativeJsProxy for vjo.dsf.document.Positioning.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Positioning extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Positioning(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Positioning(Object ...args){
        super(args);
    }

    public Positioning() {
        super();
    }

    public static Object getScrollLeftTop() {
        return callStaticWithName("vjo.dsf.document.Positioning", "getScrollLeftTop", Object.class);
    }

    public static int getOffsetLeft(Object poElem) {
        return callStaticWithName("vjo.dsf.document.Positioning", "getOffsetLeft", Integer.class, poElem);
    }

    public static int getOffsetTop(Object poElem) {
        return callStaticWithName("vjo.dsf.document.Positioning", "getOffsetTop", Integer.class, poElem);
    }

    public static int getClientWidth() {
        return callStaticWithName("vjo.dsf.document.Positioning", "getClientWidth", Integer.class);
    }

    public static int getClientHeight() {
        return callStaticWithName("vjo.dsf.document.Positioning", "getClientHeight", Integer.class);
    }

    public static Object getEventLeftTop(MouseEvent poEvent) {
        return callStaticWithName("vjo.dsf.document.Positioning", "getEventLeftTop", Object.class, poEvent);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Positioning> prototype = NativeJsTypeRef.get(Positioning.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Positioning>> getScrollLeftTop = NativeJsFuncProxy.create(prototype, "getScrollLeftTop");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Positioning>> getOffsetLeft = NativeJsFuncProxy.create(prototype, "getOffsetLeft");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Positioning>> getOffsetTop = NativeJsFuncProxy.create(prototype, "getOffsetTop");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Positioning>> getClientWidth = NativeJsFuncProxy.create(prototype, "getClientWidth");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Positioning>> getClientHeight = NativeJsFuncProxy.create(prototype, "getClientHeight");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Positioning>> getEventLeftTop = NativeJsFuncProxy.create(prototype, "getEventLeftTop");
}