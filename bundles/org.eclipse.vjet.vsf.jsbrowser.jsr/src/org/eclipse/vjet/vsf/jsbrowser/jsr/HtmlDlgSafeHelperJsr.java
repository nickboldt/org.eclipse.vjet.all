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
package org.eclipse.vjet.vsf.jsbrowser.jsr;
import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HtmlDlgSafeHelperJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HtmlDlgSafeHelper", HtmlDlgSafeHelperJsr.class, "HtmlDlgSafeHelper");

    public HtmlDlgSafeHelperJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HtmlDlgSafeHelperJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String[]> blockFormats(){
        return getProp(String[].class, "blockFormats");
    }

    public IJsPropSetter blockFormats(String[] v) {
        return setProp("blockFormats", v);
    }

    public IJsPropSetter blockFormats(IValueBinding<String[]> v) {
        return setProp("blockFormats", v);
    }

    public JsProp<String[]> fonts(){
        return getProp(String[].class, "fonts");
    }

    public IJsPropSetter fonts(String[] v) {
        return setProp("fonts", v);
    }

    public IJsPropSetter fonts(IValueBinding<String[]> v) {
        return setProp("fonts", v);
    }

    public JsFunc<Integer> ChooseColorDlg(){
        return call(Integer.class, "ChooseColorDlg");
    }

    public JsFunc<Integer> ChooseColorDlg(int initColor){
        return call(Integer.class, "ChooseColorDlg").with(initColor);
    }

    public JsFunc<Integer> ChooseColorDlg(IValueBinding<Integer> initColor){
        return call(Integer.class, "ChooseColorDlg").with(initColor);
    }

    public JsFunc<Object> getCharset(){
        return call(Object.class, "getCharset");
    }
    
    public static JsTypeRef<HtmlDlgSafeHelperJsr> prototype = new JsTypeRef<HtmlDlgSafeHelperJsr>(S);
}