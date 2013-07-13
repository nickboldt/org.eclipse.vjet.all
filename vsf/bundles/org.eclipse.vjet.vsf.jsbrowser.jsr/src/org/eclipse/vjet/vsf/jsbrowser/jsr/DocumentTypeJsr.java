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
import org.eclipse.vjet.vsf.jsbrowser.jsr.NamedNodeMapJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.NodeJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class DocumentTypeJsr extends NodeJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("DocumentType", DocumentTypeJsr.class, "DocumentType");

    public DocumentTypeJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected DocumentTypeJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

    public JsProp<NamedNodeMapJsr> entities(){
        return getProp(NamedNodeMapJsr.class, "entities");
    }

    public IJsPropSetter entities(NamedNodeMapJsr v) {
        return setProp("entities", v);
    }

    public IJsPropSetter entities(IValueBinding<? extends NamedNodeMapJsr> v) {
        return setProp("entities", v);
    }

    public JsProp<NamedNodeMapJsr> notations(){
        return getProp(NamedNodeMapJsr.class, "notations");
    }

    public IJsPropSetter notations(NamedNodeMapJsr v) {
        return setProp("notations", v);
    }

    public IJsPropSetter notations(IValueBinding<? extends NamedNodeMapJsr> v) {
        return setProp("notations", v);
    }

    public JsProp<String> publicId(){
        return getProp(String.class, "publicId");
    }

    public IJsPropSetter publicId(String v) {
        return setProp("publicId", v);
    }

    public IJsPropSetter publicId(IValueBinding<String> v) {
        return setProp("publicId", v);
    }

    public JsProp<String> systemId(){
        return getProp(String.class, "systemId");
    }

    public IJsPropSetter systemId(String v) {
        return setProp("systemId", v);
    }

    public IJsPropSetter systemId(IValueBinding<String> v) {
        return setProp("systemId", v);
    }

    public JsProp<String> internalSubset(){
        return getProp(String.class, "internalSubset");
    }

    public IJsPropSetter internalSubset(String v) {
        return setProp("internalSubset", v);
    }

    public IJsPropSetter internalSubset(IValueBinding<String> v) {
        return setProp("internalSubset", v);
    }
    
    public static JsTypeRef<DocumentTypeJsr> prototype = new JsTypeRef<DocumentTypeJsr>(S);
}