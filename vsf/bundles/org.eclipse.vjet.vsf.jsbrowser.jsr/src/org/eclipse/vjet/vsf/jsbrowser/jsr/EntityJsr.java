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
import org.eclipse.vjet.vsf.jsbrowser.jsr.NodeJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class EntityJsr extends NodeJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("Entity", EntityJsr.class, "Entity");

    public EntityJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected EntityJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
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

    public JsProp<String> notationName(){
        return getProp(String.class, "notationName");
    }

    public IJsPropSetter notationName(String v) {
        return setProp("notationName", v);
    }

    public IJsPropSetter notationName(IValueBinding<String> v) {
        return setProp("notationName", v);
    }

    public JsProp<String> inputEncoding(){
        return getProp(String.class, "inputEncoding");
    }

    public IJsPropSetter inputEncoding(String v) {
        return setProp("inputEncoding", v);
    }

    public IJsPropSetter inputEncoding(IValueBinding<String> v) {
        return setProp("inputEncoding", v);
    }

    public JsProp<String> xmlEncoding(){
        return getProp(String.class, "xmlEncoding");
    }

    public IJsPropSetter xmlEncoding(String v) {
        return setProp("xmlEncoding", v);
    }

    public IJsPropSetter xmlEncoding(IValueBinding<String> v) {
        return setProp("xmlEncoding", v);
    }

    public JsProp<String> xmlVersion(){
        return getProp(String.class, "xmlVersion");
    }

    public IJsPropSetter xmlVersion(String v) {
        return setProp("xmlVersion", v);
    }

    public IJsPropSetter xmlVersion(IValueBinding<String> v) {
        return setProp("xmlVersion", v);
    }
    
    public static JsTypeRef<EntityJsr> prototype = new JsTypeRef<EntityJsr>(S);
}