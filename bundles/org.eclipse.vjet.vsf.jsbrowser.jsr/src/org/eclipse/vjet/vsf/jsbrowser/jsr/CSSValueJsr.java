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
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class CSSValueJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("CSSValue", CSSValueJsr.class, "CSSValue");

    public CSSValueJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected CSSValueJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> cssText(){
        return getProp(String.class, "cssText");
    }

    public IJsPropSetter cssText(String v) {
        return setProp("cssText", v);
    }

    public IJsPropSetter cssText(IValueBinding<String> v) {
        return setProp("cssText", v);
    }

    public JsProp<Integer> cssValueType(){
        return getProp(Integer.class, "cssValueType");
    }

    public IJsPropSetter cssValueType(int v) {
        return setProp("cssValueType", v);
    }

    public IJsPropSetter cssValueType(IValueBinding<Integer> v) {
        return setProp("cssValueType", v);
    }
    
    public static JsTypeRef<CSSValueJsr> prototype = new JsTypeRef<CSSValueJsr>(S);
}