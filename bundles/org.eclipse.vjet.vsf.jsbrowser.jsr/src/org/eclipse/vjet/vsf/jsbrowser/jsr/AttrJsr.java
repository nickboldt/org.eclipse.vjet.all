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
import org.eclipse.vjet.vsf.jsbrowser.jsr.ElementJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.NodeJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.TypeInfoJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class AttrJsr extends NodeJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("Attr", AttrJsr.class, "Attr");

    public AttrJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected AttrJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

    public JsProp<Boolean> specified(){
        return getProp(Boolean.class, "specified");
    }

    public IJsPropSetter specified(boolean v) {
        return setProp("specified", v);
    }

    public IJsPropSetter specified(IValueBinding<Boolean> v) {
        return setProp("specified", v);
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

    public JsProp<ElementJsr> ownerElement(){
        return getProp(ElementJsr.class, "ownerElement");
    }

    public IJsPropSetter ownerElement(ElementJsr v) {
        return setProp("ownerElement", v);
    }

    public IJsPropSetter ownerElement(IValueBinding<? extends ElementJsr> v) {
        return setProp("ownerElement", v);
    }

    public JsProp<TypeInfoJsr> schemaTypeInfo(){
        return getProp(TypeInfoJsr.class, "schemaTypeInfo");
    }

    public IJsPropSetter schemaTypeInfo(TypeInfoJsr v) {
        return setProp("schemaTypeInfo", v);
    }

    public IJsPropSetter schemaTypeInfo(IValueBinding<? extends TypeInfoJsr> v) {
        return setProp("schemaTypeInfo", v);
    }

    public JsProp<Boolean> isId(){
        return getProp(Boolean.class, "isId");
    }

    public IJsPropSetter isId(boolean v) {
        return setProp("isId", v);
    }

    public IJsPropSetter isId(IValueBinding<Boolean> v) {
        return setProp("isId", v);
    }
    
    public static JsTypeRef<AttrJsr> prototype = new JsTypeRef<AttrJsr>(S);
}