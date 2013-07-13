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
import org.eclipse.vjet.vsf.jsbrowser.jsr.DocumentJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ActiveXObjectJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("ActiveXObject", ActiveXObjectJsr.class, "ActiveXObject");

    public ActiveXObjectJsr(String param){
        super(S.getJsCmpMeta(), true, param);
    }

    public ActiveXObjectJsr(IValueBinding<String> param){
        super(S.getJsCmpMeta(), true, param);
    }

    protected ActiveXObjectJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Short> readyState(){
        return getProp(Short.class, "readyState");
    }

    public IJsPropSetter readyState(short v) {
        return setProp("readyState", v);
    }

    public IJsPropSetter readyState(IValueBinding<Short> v) {
        return setProp("readyState", v);
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

    public JsProp<DocumentJsr> responseXML(){
        return getProp(DocumentJsr.class, "responseXML");
    }

    public IJsPropSetter responseXML(DocumentJsr v) {
        return setProp("responseXML", v);
    }

    public IJsPropSetter responseXML(IValueBinding<? extends DocumentJsr> v) {
        return setProp("responseXML", v);
    }

    public JsProp<Short> status(){
        return getProp(Short.class, "status");
    }

    public IJsPropSetter status(short v) {
        return setProp("status", v);
    }

    public IJsPropSetter status(IValueBinding<Short> v) {
        return setProp("status", v);
    }

    public JsProp<String> statusText(){
        return getProp(String.class, "statusText");
    }

    public IJsPropSetter statusText(String v) {
        return setProp("statusText", v);
    }

    public IJsPropSetter statusText(IValueBinding<String> v) {
        return setProp("statusText", v);
    }

    /**

 Aborts the request if it has already been sent.
 
*/

public JsFunc<Void> abort(){
        return call("abort");
    }

    /**

 Returns all the response headers as a string.
 @return String
 
*/

public JsFunc<String> getAllResponseHeaders(){
        return call(String.class, "getAllResponseHeaders");
    }

    /**

 Returns the text of a specified header.
 @param header String header
 @return String 
 
*/

public JsFunc<String> getResponseHeader(String header){
        return call(String.class, "getResponseHeader").with(header);
    }

    /**

 Returns the text of a specified header.
 @param header String header
 @return String 
 
*/

public JsFunc<String> getResponseHeader(IValueBinding<String> header){
        return call(String.class, "getResponseHeader").with(header);
    }

    /**

 Initializes a request. This method is to be used from JavaScript code;
 to initialize a request from native code, use openRequest() instead.
 @param method The HTTP method to use; either "POST" or "GET".
 Ignored for non-HTTP URLs.
 @param url The URL to which to send the request.
 @param async An optional boolean parameter, defaulting to true,
 indicating whether or not to perform the operation asynchronously.
 If this value is false, the send() method does not return until the
 response is received.  If true, notification of a completed
 transaction is provided using event listeners.
 This must be true if the multipart attribute is true,
 or an exception will be thrown.
 @param user The optional user name to use for
 authentication purposes; by default, this is an empty string.
 @param password The optional password to use for authentication purposes;
 by default, this is an empty string.
 
*/

public JsFunc<Void> open(String method, String url, boolean async, String user, String password){
        return call("open").with(method, url, async, user, password);
    }

    /**

 Initializes a request. This method is to be used from JavaScript code;
 to initialize a request from native code, use openRequest() instead.
 @param method The HTTP method to use; either "POST" or "GET".
 Ignored for non-HTTP URLs.
 @param url The URL to which to send the request.
 @param async An optional boolean parameter, defaulting to true,
 indicating whether or not to perform the operation asynchronously.
 If this value is false, the send() method does not return until the
 response is received.  If true, notification of a completed
 transaction is provided using event listeners.
 This must be true if the multipart attribute is true,
 or an exception will be thrown.
 @param user The optional user name to use for
 authentication purposes; by default, this is an empty string.
 @param password The optional password to use for authentication purposes;
 by default, this is an empty string.
 
*/

public JsFunc<Void> open(IValueBinding<String> method, IValueBinding<String> url, IValueBinding<Boolean> async, IValueBinding<String> user, IValueBinding<String> password){
        return call("open").with(method, url, async, user, password);
    }

    /**

 Sets the value of an HTTP request header.
 @param header The name of the header whose value is to be set.
 @param value The value to set as the body of the header.
 
*/

public JsFunc<Void> setRequestHeader(String header, String value){
        return call("setRequestHeader").with(header, value);
    }

    /**

 Sets the value of an HTTP request header.
 @param header The name of the header whose value is to be set.
 @param value The value to set as the body of the header.
 
*/

public JsFunc<Void> setRequestHeader(IValueBinding<String> header, IValueBinding<String> value){
        return call("setRequestHeader").with(header, value);
    }

    public JsFunc<Void> send(String data){
        return call("send").with(data);
    }

    public JsFunc<Void> send(IValueBinding<String> data){
        return call("send").with(data);
    }

    public JsFunc<Void> send(DocumentJsr data){
        return call("send").with(data);
    }

    public JsFunc<Void> send(IValueBinding<? extends DocumentJsr> data, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call("send").with(data);
    }

    public JsFunc<Void> send(){
        return call("send");
    }
    
    public static JsTypeRef<ActiveXObjectJsr> prototype = new JsTypeRef<ActiveXObjectJsr>(S);
}