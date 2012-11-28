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
import org.eclipse.vjet.vsf.jsnative.jsr.FunctionJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class XDomainRequestJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("XDomainRequest", XDomainRequestJsr.class, "XDomainRequest");

    public XDomainRequestJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected XDomainRequestJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Object> contentType(){
        return getProp(Object.class, "contentType");
    }

    public IJsPropSetter contentType(Object v) {
        return setProp("contentType", v);
    }

    public IJsPropSetter contentType(IValueBinding<Object> v) {
        return setProp("contentType", v);
    }

    public JsProp<String> responseText(){
        return getProp(String.class, "responseText");
    }

    public IJsPropSetter responseText(String v) {
        return setProp("responseText", v);
    }

    public IJsPropSetter responseText(IValueBinding<String> v) {
        return setProp("responseText", v);
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

    public JsProp<FunctionJsr> onerror(){
        return getProp(FunctionJsr.class, "onerror");
    }

    public IJsPropSetter onerror(FunctionJsr v) {
        return setProp("onerror", v);
    }

    public IJsPropSetter onerror(IValueBinding<? extends FunctionJsr> v) {
        return setProp("onerror", v);
    }

    public JsProp<FunctionJsr> onload(){
        return getProp(FunctionJsr.class, "onload");
    }

    public IJsPropSetter onload(FunctionJsr v) {
        return setProp("onload", v);
    }

    public IJsPropSetter onload(IValueBinding<? extends FunctionJsr> v) {
        return setProp("onload", v);
    }

    public JsProp<FunctionJsr> onprogress(){
        return getProp(FunctionJsr.class, "onprogress");
    }

    public IJsPropSetter onprogress(FunctionJsr v) {
        return setProp("onprogress", v);
    }

    public IJsPropSetter onprogress(IValueBinding<? extends FunctionJsr> v) {
        return setProp("onprogress", v);
    }

    public JsProp<FunctionJsr> ontimeout(){
        return getProp(FunctionJsr.class, "ontimeout");
    }

    public IJsPropSetter ontimeout(FunctionJsr v) {
        return setProp("ontimeout", v);
    }

    public IJsPropSetter ontimeout(IValueBinding<? extends FunctionJsr> v) {
        return setProp("ontimeout", v);
    }

    public JsFunc<Void> abort(){
        return call("abort");
    }

    /**

 Creates a connection with a domain's server.
 @param bstrMethod	One of the following required values: GET The HTTP GET method. POST The HTTP POST method.
 @param bstrUrl Required. The server URL.
 
*/

public JsFunc<Void> open(String bstrMethod, String bstrUrl){
        return call("open").with(bstrMethod, bstrUrl);
    }

    /**

 Creates a connection with a domain's server.
 @param bstrMethod	One of the following required values: GET The HTTP GET method. POST The HTTP POST method.
 @param bstrUrl Required. The server URL.
 
*/

public JsFunc<Void> open(IValueBinding<String> bstrMethod, IValueBinding<String> bstrUrl){
        return call("open").with(bstrMethod, bstrUrl);
    }

    public JsFunc<Void> send(String varBody){
        return call("send").with(varBody);
    }

    public JsFunc<Void> send(IValueBinding<String> varBody){
        return call("send").with(varBody);
    }

    public JsFunc<Void> send(){
        return call("send");
    }
    
    public static JsTypeRef<XDomainRequestJsr> prototype = new JsTypeRef<XDomainRequestJsr>(S);
}