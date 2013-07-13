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
import org.eclipse.vjet.dsf.jsnative.HtmlSelect;
import org.eclipse.vjet.dsf.jsnative.HtmlOption;

//NativeJsProxy for vjo.dsf.docx.Selectx.js
@org.eclipse.vjet.dsf.resource.utils.CodeGen("NativeJsProxyGenerator")
@AJsProxy
public class Selectx extends NativeJsProxy {

    /** for framework use only */
    @AExclude
    public Selectx(Scriptable nativeObj){
        super(nativeObj);
    }

    /** internal use only */
    protected Selectx(Object ...args){
        super(args);
    }

    public Selectx() {
        super();
    }

    public static void addOption(String poSelect, String psVal, String psText) {
        callStaticWithName("vjo.dsf.docx.Selectx", "addOption", poSelect, psVal, psText);
    }

    public static void addOption(HtmlSelect poSelect, String psVal, String psText) {
        callStaticWithName("vjo.dsf.docx.Selectx", "addOption", poSelect, psVal, psText);
    }

    public static HtmlOption createOption(String psText, String psVal) {
        return callStaticWithName("vjo.dsf.docx.Selectx", "createOption", HtmlOption.class, psText, psVal);
    }

    public static HtmlOption createOption(String psText, String psVal, boolean pbDefSel) {
        return callStaticWithName("vjo.dsf.docx.Selectx", "createOption", HtmlOption.class, psText, psVal, pbDefSel);
    }

    public static HtmlOption createOption(String psText, String psVal, boolean pbDefSel, boolean pbSel) {
        return callStaticWithName("vjo.dsf.docx.Selectx", "createOption", HtmlOption.class, psText, psVal, pbDefSel, pbSel);
    }

    public static void clear(String poSelect) {
        callStaticWithName("vjo.dsf.docx.Selectx", "clear", poSelect);
    }

    public static void clear(HtmlSelect poSelect) {
        callStaticWithName("vjo.dsf.docx.Selectx", "clear", poSelect);
    }

    @AJavaOnly
    public static final NativeJsTypeRef<Selectx> prototype = NativeJsTypeRef.get(Selectx.class);

    public static final INativeJsFuncProxy<NativeJsTypeRef<Selectx>> addOption = NativeJsFuncProxy.create(prototype, "addOption");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Selectx>> createOption = NativeJsFuncProxy.create(prototype, "createOption");

    public static final INativeJsFuncProxy<NativeJsTypeRef<Selectx>> clear = NativeJsFuncProxy.create(prototype, "clear");
}