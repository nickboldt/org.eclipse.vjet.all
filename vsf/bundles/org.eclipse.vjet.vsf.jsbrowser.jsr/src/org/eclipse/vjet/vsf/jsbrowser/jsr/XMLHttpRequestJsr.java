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
import org.eclipse.vjet.vsf.jsnative.jsr.FunctionJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class XMLHttpRequestJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("XMLHttpRequest", XMLHttpRequestJsr.class, "XMLHttpRequest");

    public XMLHttpRequestJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected XMLHttpRequestJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
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

    public JsProp<Object> onreadystatechange(){
        return getProp(Object.class, "onreadystatechange");
    }

    public IJsPropSetter onreadystatechange(Object v) {
        return setProp("onreadystatechange", v);
    }

    public IJsPropSetter onreadystatechange(IValueBinding<Object> v) {
        return setProp("onreadystatechange", v);
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

    public JsProp<FunctionJsr> upload(){
        return getProp(FunctionJsr.class, "upload");
    }

    public IJsPropSetter upload(FunctionJsr v) {
        return setProp("upload", v);
    }

    public IJsPropSetter upload(IValueBinding<? extends FunctionJsr> v) {
        return setProp("upload", v);
    }

    public JsProp<Boolean> withCredentials(){
        return getProp(Boolean.class, "withCredentials");
    }

    public IJsPropSetter withCredentials(boolean v) {
        return setProp("withCredentials", v);
    }

    public IJsPropSetter withCredentials(IValueBinding<Boolean> v) {
        return setProp("withCredentials", v);
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

    /**

 Sends the request. If the request is asynchronous (which is the default),
 this method returns as soon as the request is sent.
 If the request is synchronous, this method doesn't return until the
 response has arrived.
 If data is not null, Serialize data into a namespace
 well-formed XML document and encoded using the encoding given by
 data.inputEncoding, when not null, or UTF-8 otherwise.
 Or, if this fails because the Document cannot be serialized act as if
 data  is null.
 @param data if not null use it for the entity body
 as defined by section 7.2 of RFC 2616.
 
*/

public JsFunc<Void> send(Object data){
        return call("send").with(data);
    }

    /**

 A variant of the send() method that sends binary data.
 @param body The request body as a DOM string.  
 
*/

public JsFunc<Void> sendAsBinary(String body){
        return call("sendAsBinary").with(body);
    }

    /**

 A variant of the send() method that sends binary data.
 @param body The request body as a DOM string.  
 
*/

public JsFunc<Void> sendAsBinary(IValueBinding<String> body){
        return call("sendAsBinary").with(body);
    }
    
    public static JsTypeRef<XMLHttpRequestJsr> prototype = new JsTypeRef<XMLHttpRequestJsr>(S);
}