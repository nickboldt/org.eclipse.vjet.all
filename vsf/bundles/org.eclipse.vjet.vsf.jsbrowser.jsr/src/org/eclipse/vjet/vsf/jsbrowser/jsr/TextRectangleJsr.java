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
public class TextRectangleJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("TextRectangle", TextRectangleJsr.class, "TextRectangle");

    public TextRectangleJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected TextRectangleJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Float> top(){
        return getProp(Float.class, "top");
    }

    public IJsPropSetter top(float v) {
        return setProp("top", v);
    }

    public IJsPropSetter top(IValueBinding<Float> v) {
        return setProp("top", v);
    }

    public JsProp<Float> right(){
        return getProp(Float.class, "right");
    }

    public IJsPropSetter right(float v) {
        return setProp("right", v);
    }

    public IJsPropSetter right(IValueBinding<Float> v) {
        return setProp("right", v);
    }

    public JsProp<Float> bottom(){
        return getProp(Float.class, "bottom");
    }

    public IJsPropSetter bottom(float v) {
        return setProp("bottom", v);
    }

    public IJsPropSetter bottom(IValueBinding<Float> v) {
        return setProp("bottom", v);
    }

    public JsProp<Float> left(){
        return getProp(Float.class, "left");
    }

    public IJsPropSetter left(float v) {
        return setProp("left", v);
    }

    public IJsPropSetter left(IValueBinding<Float> v) {
        return setProp("left", v);
    }
    
    public static JsTypeRef<TextRectangleJsr> prototype = new JsTypeRef<TextRectangleJsr>(S);
}