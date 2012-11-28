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
package org.eclipse.vjet.vsf;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class SvcConfigJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("vjo.dsf.SvcConfig", SvcConfigJsr.class, "SvcConfig");

    
    public static class ResourceSpec {
        public static IComponentSpec getInstance() {
            return S.getResourceSpec(); 
        }
        public static final JsResource RESOURCE = S.getJsResource();
        public static final IJsResourceRef REF = S.getJsResourceRef();
    }

    public static final IComponentSpec SPEC = S.getResourceSpec();

    public SvcConfigJsr(String method, String url){
        super(S.getJsCmpMeta(), true, method, url);
    }

    public SvcConfigJsr(IValueBinding<String> method, IValueBinding<String> url){
        super(S.getJsCmpMeta(), true, method, url);
    }

    protected SvcConfigJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> objType(){
        return getProp(String.class, "objType");
    }

    public IJsPropSetter objType(String v) {
        return setProp("objType", v);
    }

    public IJsPropSetter objType(IValueBinding<String> v) {
        return setProp("objType", v);
    }

    public JsProp<String> url(){
        return getProp(String.class, "url");
    }

    public IJsPropSetter url(String v) {
        return setProp("url", v);
    }

    public IJsPropSetter url(IValueBinding<String> v) {
        return setProp("url", v);
    }

    public JsProp<String> method(){
        return getProp(String.class, "method");
    }

    public IJsPropSetter method(String v) {
        return setProp("method", v);
    }

    public IJsPropSetter method(IValueBinding<String> v) {
        return setProp("method", v);
    }

    public JsProp<String> reqtMarshalling(){
        return getProp(String.class, "reqtMarshalling");
    }

    public IJsPropSetter reqtMarshalling(String v) {
        return setProp("reqtMarshalling", v);
    }

    public IJsPropSetter reqtMarshalling(IValueBinding<String> v) {
        return setProp("reqtMarshalling", v);
    }

    public JsProp<String> respMarshalling(){
        return getProp(String.class, "respMarshalling");
    }

    public IJsPropSetter respMarshalling(String v) {
        return setProp("respMarshalling", v);
    }

    public IJsPropSetter respMarshalling(IValueBinding<String> v) {
        return setProp("respMarshalling", v);
    }

    public JsProp<Boolean> async(){
        return getProp(Boolean.class, "async");
    }

    public IJsPropSetter async(boolean v) {
        return setProp("async", v);
    }

    public IJsPropSetter async(IValueBinding<Boolean> v) {
        return setProp("async", v);
    }

    public JsProp<Integer> timeout(){
        return getProp(Integer.class, "timeout");
    }

    public IJsPropSetter timeout(int v) {
        return setProp("timeout", v);
    }

    public IJsPropSetter timeout(IValueBinding<Integer> v) {
        return setProp("timeout", v);
    }
    
    public static JsTypeRef<SvcConfigJsr> prototype = new JsTypeRef<SvcConfigJsr>(S);
}