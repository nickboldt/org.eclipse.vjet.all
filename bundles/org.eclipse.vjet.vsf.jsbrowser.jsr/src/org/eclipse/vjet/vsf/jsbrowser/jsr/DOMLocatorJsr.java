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
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class DOMLocatorJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("DOMLocator", DOMLocatorJsr.class, "DOMLocator");

    public DOMLocatorJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected DOMLocatorJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Integer> lineNumber(){
        return getProp(Integer.class, "lineNumber");
    }

    public IJsPropSetter lineNumber(int v) {
        return setProp("lineNumber", v);
    }

    public IJsPropSetter lineNumber(IValueBinding<Integer> v) {
        return setProp("lineNumber", v);
    }

    public JsProp<Integer> columnNumber(){
        return getProp(Integer.class, "columnNumber");
    }

    public IJsPropSetter columnNumber(int v) {
        return setProp("columnNumber", v);
    }

    public IJsPropSetter columnNumber(IValueBinding<Integer> v) {
        return setProp("columnNumber", v);
    }

    public JsProp<Integer> byteOffset(){
        return getProp(Integer.class, "byteOffset");
    }

    public IJsPropSetter byteOffset(int v) {
        return setProp("byteOffset", v);
    }

    public IJsPropSetter byteOffset(IValueBinding<Integer> v) {
        return setProp("byteOffset", v);
    }

    public JsProp<Integer> utf16Offset(){
        return getProp(Integer.class, "utf16Offset");
    }

    public IJsPropSetter utf16Offset(int v) {
        return setProp("utf16Offset", v);
    }

    public IJsPropSetter utf16Offset(IValueBinding<Integer> v) {
        return setProp("utf16Offset", v);
    }

    public JsProp<NodeJsr> relatedNode(){
        return getProp(NodeJsr.class, "relatedNode");
    }

    public IJsPropSetter relatedNode(NodeJsr v) {
        return setProp("relatedNode", v);
    }

    public IJsPropSetter relatedNode(IValueBinding<? extends NodeJsr> v) {
        return setProp("relatedNode", v);
    }

    public JsProp<String> uri(){
        return getProp(String.class, "uri");
    }

    public IJsPropSetter uri(String v) {
        return setProp("uri", v);
    }

    public IJsPropSetter uri(IValueBinding<String> v) {
        return setProp("uri", v);
    }
    
    public static JsTypeRef<DOMLocatorJsr> prototype = new JsTypeRef<DOMLocatorJsr>(S);
}