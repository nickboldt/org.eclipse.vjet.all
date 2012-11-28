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
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class LocationJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("Location", LocationJsr.class, "Location");

    public LocationJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected LocationJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> hash(){
        return getProp(String.class, "hash");
    }

    public IJsPropSetter hash(String v) {
        return setProp("hash", v);
    }

    public IJsPropSetter hash(IValueBinding<String> v) {
        return setProp("hash", v);
    }

    public JsProp<String> host(){
        return getProp(String.class, "host");
    }

    public IJsPropSetter host(String v) {
        return setProp("host", v);
    }

    public IJsPropSetter host(IValueBinding<String> v) {
        return setProp("host", v);
    }

    public JsProp<String> hostname(){
        return getProp(String.class, "hostname");
    }

    public IJsPropSetter hostname(String v) {
        return setProp("hostname", v);
    }

    public IJsPropSetter hostname(IValueBinding<String> v) {
        return setProp("hostname", v);
    }

    public JsProp<String> href(){
        return getProp(String.class, "href");
    }

    public IJsPropSetter href(String v) {
        return setProp("href", v);
    }

    public IJsPropSetter href(IValueBinding<String> v) {
        return setProp("href", v);
    }

    public JsProp<String> pathname(){
        return getProp(String.class, "pathname");
    }

    public IJsPropSetter pathname(String v) {
        return setProp("pathname", v);
    }

    public IJsPropSetter pathname(IValueBinding<String> v) {
        return setProp("pathname", v);
    }

    public JsProp<String> port(){
        return getProp(String.class, "port");
    }

    public IJsPropSetter port(String v) {
        return setProp("port", v);
    }

    public IJsPropSetter port(IValueBinding<String> v) {
        return setProp("port", v);
    }

    public JsProp<String> protocol(){
        return getProp(String.class, "protocol");
    }

    public IJsPropSetter protocol(String v) {
        return setProp("protocol", v);
    }

    public IJsPropSetter protocol(IValueBinding<String> v) {
        return setProp("protocol", v);
    }

    public JsProp<String> search(){
        return getProp(String.class, "search");
    }

    public IJsPropSetter search(String v) {
        return setProp("search", v);
    }

    public IJsPropSetter search(IValueBinding<String> v) {
        return setProp("search", v);
    }

    /**

 Reload the document from the current URL. forceget is a boolean,
 which, when it is true, causes the page to always be reloaded from
 the server. If it is false or not specified, the browser may reload
 the page from its cache.
 @param forceGet
 
*/

public JsFunc<Void> reload(boolean forceGet){
        return call("reload").with(forceGet);
    }

    /**

 Reload the document from the current URL. forceget is a boolean,
 which, when it is true, causes the page to always be reloaded from
 the server. If it is false or not specified, the browser may reload
 the page from its cache.
 @param forceGet
 
*/

public JsFunc<Void> reload(IValueBinding<Boolean> forceGet){
        return call("reload").with(forceGet);
    }

    /**

 Load the document from the provided URL
 @param url
 
*/

public JsFunc<Void> assign(String url){
        return call("assign").with(url);
    }

    /**

 Load the document from the provided URL
 @param url
 
*/

public JsFunc<Void> assign(IValueBinding<String> url){
        return call("assign").with(url);
    }

    /**

 Replace the current document with the one at the provided URL.
 The difference from the assign() method is that after using replace()
 the current page will not be saved in session history, meaning the user
 won't be able to use the Back button to navigate to it.
 @param url
 
*/

public JsFunc<Void> replace(String url){
        return call("replace").with(url);
    }

    /**

 Replace the current document with the one at the provided URL.
 The difference from the assign() method is that after using replace()
 the current page will not be saved in session history, meaning the user
 won't be able to use the Back button to navigate to it.
 @param url
 
*/

public JsFunc<Void> replace(IValueBinding<String> url){
        return call("replace").with(url);
    }

    /**

 Only for Rhino support
 @param type
 @return
 
*/

public JsFunc<Object> valueOf(String type){
        return call(Object.class, "valueOf").with(type);
    }

    /**

 Only for Rhino support
 @param type
 @return
 
*/

public JsFunc<Object> valueOf(IValueBinding<String> type){
        return call(Object.class, "valueOf").with(type);
    }
    
    public static JsTypeRef<LocationJsr> prototype = new JsTypeRef<LocationJsr>(S);
}