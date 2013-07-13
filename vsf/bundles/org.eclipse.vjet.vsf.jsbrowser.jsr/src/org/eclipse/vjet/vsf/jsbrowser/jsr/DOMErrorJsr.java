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
import org.eclipse.vjet.vsf.jsbrowser.jsr.DOMLocatorJsr;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class DOMErrorJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("DOMError", DOMErrorJsr.class, "DOMError");

    public DOMErrorJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected DOMErrorJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Short> severity(){
        return getProp(Short.class, "severity");
    }

    public IJsPropSetter severity(short v) {
        return setProp("severity", v);
    }

    public IJsPropSetter severity(IValueBinding<Short> v) {
        return setProp("severity", v);
    }

    public JsProp<String> message(){
        return getProp(String.class, "message");
    }

    public IJsPropSetter message(String v) {
        return setProp("message", v);
    }

    public IJsPropSetter message(IValueBinding<String> v) {
        return setProp("message", v);
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

    public JsProp<Object> relatedException(){
        return getProp(Object.class, "relatedException");
    }

    public IJsPropSetter relatedException(Object v) {
        return setProp("relatedException", v);
    }

    public IJsPropSetter relatedException(IValueBinding<Object> v) {
        return setProp("relatedException", v);
    }

    public JsProp<Object> relatedData(){
        return getProp(Object.class, "relatedData");
    }

    public IJsPropSetter relatedData(Object v) {
        return setProp("relatedData", v);
    }

    public IJsPropSetter relatedData(IValueBinding<Object> v) {
        return setProp("relatedData", v);
    }

    public JsProp<DOMLocatorJsr> location(){
        return getProp(DOMLocatorJsr.class, "location");
    }

    public IJsPropSetter location(DOMLocatorJsr v) {
        return setProp("location", v);
    }

    public IJsPropSetter location(IValueBinding<? extends DOMLocatorJsr> v) {
        return setProp("location", v);
    }
    
    public static JsTypeRef<DOMErrorJsr> prototype = new JsTypeRef<DOMErrorJsr>(S);
}