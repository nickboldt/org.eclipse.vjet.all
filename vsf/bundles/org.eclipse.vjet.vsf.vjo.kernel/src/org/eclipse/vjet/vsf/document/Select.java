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
import org.eclipse.vjet.dsf.jsnative.Option;

//NativeJsProxy for vjo.dsf.document.Select.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Select extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Select(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Select(Object ...args){
        super(args);
    }

    public Select() {
        super();
    }

    public static void addOption(Object poSelect, String psVal, String psText) {
        callStaticWithName("vjo.dsf.document.Select", "addOption", poSelect, psVal, psText);
    }

    public static Option createOption(String psText, String psVal) {
        return callStaticWithName("vjo.dsf.document.Select", "createOption", Option.class, psText, psVal);
    }

    public static Option createOption(String psText, String psVal, boolean pbDefSel) {
        return callStaticWithName("vjo.dsf.document.Select", "createOption", Option.class, psText, psVal, pbDefSel);
    }

    public static Option createOption(String psText, String psVal, boolean pbDefSel, boolean pbSel) {
        return callStaticWithName("vjo.dsf.document.Select", "createOption", Option.class, psText, psVal, pbDefSel, pbSel);
    }

    public static void clear(Object poSelect) {
        callStaticWithName("vjo.dsf.document.Select", "clear", poSelect);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Select> prototype = NativeJsTypeRef.get(Select.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Select>> addOption = NativeJsFuncProxy.create(prototype, "addOption");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Select>> createOption = NativeJsFuncProxy.create(prototype, "createOption");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Select>> clear = NativeJsFuncProxy.create(prototype, "clear");
}