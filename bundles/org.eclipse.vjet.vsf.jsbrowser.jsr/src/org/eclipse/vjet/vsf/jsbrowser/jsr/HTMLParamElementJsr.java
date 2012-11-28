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
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLParamElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLParamElement", HTMLParamElementJsr.class, "HTMLParamElement");

    public HTMLParamElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLParamElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> name(){
        return getProp(String.class, "name");
    }

    public IJsPropSetter name(String v) {
        return setProp("name", v);
    }

    public IJsPropSetter name(IValueBinding<String> v) {
        return setProp("name", v);
    }

    public JsProp<String> type(){
        return getProp(String.class, "type");
    }

    public IJsPropSetter type(String v) {
        return setProp("type", v);
    }

    public IJsPropSetter type(IValueBinding<String> v) {
        return setProp("type", v);
    }

    public JsProp<String> value(){
        return getProp(String.class, "value");
    }

    public IJsPropSetter value(String v) {
        return setProp("value", v);
    }

    public IJsPropSetter value(IValueBinding<String> v) {
        return setProp("value", v);
    }

    public JsProp<String> valueType(){
        return getProp(String.class, "valueType");
    }

    public IJsPropSetter valueType(String v) {
        return setProp("valueType", v);
    }

    public IJsPropSetter valueType(IValueBinding<String> v) {
        return setProp("valueType", v);
    }
    
    public static JsTypeRef<HTMLParamElementJsr> prototype = new JsTypeRef<HTMLParamElementJsr>(S);
}