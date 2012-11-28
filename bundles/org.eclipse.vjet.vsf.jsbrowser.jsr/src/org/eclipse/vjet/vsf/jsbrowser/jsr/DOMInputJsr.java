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
import org.eclipse.vjet.vsf.jsbrowser.jsr.DOMInputStreamJsr;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class DOMInputJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("DOMInput", DOMInputJsr.class, "DOMInput");

    public DOMInputJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected DOMInputJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<DOMInputStreamJsr> byteStream(){
        return getProp(DOMInputStreamJsr.class, "byteStream");
    }

    public IJsPropSetter byteStream(DOMInputStreamJsr v) {
        return setProp("byteStream", v);
    }

    public IJsPropSetter byteStream(IValueBinding<? extends DOMInputStreamJsr> v) {
        return setProp("byteStream", v);
    }

    public JsProp<String> stringData(){
        return getProp(String.class, "stringData");
    }

    public IJsPropSetter stringData(String v) {
        return setProp("stringData", v);
    }

    public IJsPropSetter stringData(IValueBinding<String> v) {
        return setProp("stringData", v);
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

    public JsProp<String> encoding(){
        return getProp(String.class, "encoding");
    }

    public IJsPropSetter encoding(String v) {
        return setProp("encoding", v);
    }

    public IJsPropSetter encoding(IValueBinding<String> v) {
        return setProp("encoding", v);
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

    public JsProp<String> baseURI(){
        return getProp(String.class, "baseURI");
    }

    public IJsPropSetter baseURI(String v) {
        return setProp("baseURI", v);
    }

    public IJsPropSetter baseURI(IValueBinding<String> v) {
        return setProp("baseURI", v);
    }

    public JsProp<Boolean> certified(){
        return getProp(Boolean.class, "certified");
    }

    public IJsPropSetter certified(boolean v) {
        return setProp("certified", v);
    }

    public IJsPropSetter certified(IValueBinding<Boolean> v) {
        return setProp("certified", v);
    }
    
    public static JsTypeRef<DOMInputJsr> prototype = new JsTypeRef<DOMInputJsr>(S);
}