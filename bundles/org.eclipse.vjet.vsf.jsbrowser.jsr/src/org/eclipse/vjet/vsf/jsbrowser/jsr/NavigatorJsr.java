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
import org.eclipse.vjet.vsf.jsbrowser.jsr.MimeTypeJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class NavigatorJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("Navigator", NavigatorJsr.class, "Navigator");

    public NavigatorJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected NavigatorJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> appCodeName(){
        return getProp(String.class, "appCodeName");
    }

    public IJsPropSetter appCodeName(String v) {
        return setProp("appCodeName", v);
    }

    public IJsPropSetter appCodeName(IValueBinding<String> v) {
        return setProp("appCodeName", v);
    }

    public JsProp<String> appName(){
        return getProp(String.class, "appName");
    }

    public IJsPropSetter appName(String v) {
        return setProp("appName", v);
    }

    public IJsPropSetter appName(IValueBinding<String> v) {
        return setProp("appName", v);
    }

    public JsProp<String> appMinorVersion(){
        return getProp(String.class, "appMinorVersion");
    }

    public IJsPropSetter appMinorVersion(String v) {
        return setProp("appMinorVersion", v);
    }

    public IJsPropSetter appMinorVersion(IValueBinding<String> v) {
        return setProp("appMinorVersion", v);
    }

    public JsProp<String> appVersion(){
        return getProp(String.class, "appVersion");
    }

    public IJsPropSetter appVersion(String v) {
        return setProp("appVersion", v);
    }

    public IJsPropSetter appVersion(IValueBinding<String> v) {
        return setProp("appVersion", v);
    }

    public JsProp<Boolean> cookieEnabled(){
        return getProp(Boolean.class, "cookieEnabled");
    }

    public IJsPropSetter cookieEnabled(boolean v) {
        return setProp("cookieEnabled", v);
    }

    public IJsPropSetter cookieEnabled(IValueBinding<Boolean> v) {
        return setProp("cookieEnabled", v);
    }

    public JsProp<String> browserLanguage(){
        return getProp(String.class, "browserLanguage");
    }

    public IJsPropSetter browserLanguage(String v) {
        return setProp("browserLanguage", v);
    }

    public IJsPropSetter browserLanguage(IValueBinding<String> v) {
        return setProp("browserLanguage", v);
    }

    public JsProp<MimeTypeJsr[]> mimeTypes(){
        return getProp(MimeTypeJsr[].class, "mimeTypes");
    }

    public IJsPropSetter mimeTypes(MimeTypeJsr[] v) {
        return setProp("mimeTypes", v);
    }

    public IJsPropSetter mimeTypes(IValueBinding<MimeTypeJsr[]> v) {
        return setProp("mimeTypes", v);
    }

    public JsProp<String> platform(){
        return getProp(String.class, "platform");
    }

    public IJsPropSetter platform(String v) {
        return setProp("platform", v);
    }

    public IJsPropSetter platform(IValueBinding<String> v) {
        return setProp("platform", v);
    }

    public JsProp<Object> plugins(){
        return getProp(Object.class, "plugins");
    }

    public IJsPropSetter plugins(Object v) {
        return setProp("plugins", v);
    }

    public IJsPropSetter plugins(IValueBinding<Object> v) {
        return setProp("plugins", v);
    }

    public JsProp<String> systemLanguage(){
        return getProp(String.class, "systemLanguage");
    }

    public IJsPropSetter systemLanguage(String v) {
        return setProp("systemLanguage", v);
    }

    public IJsPropSetter systemLanguage(IValueBinding<String> v) {
        return setProp("systemLanguage", v);
    }

    public JsProp<String> userAgent(){
        return getProp(String.class, "userAgent");
    }

    public IJsPropSetter userAgent(String v) {
        return setProp("userAgent", v);
    }

    public IJsPropSetter userAgent(IValueBinding<String> v) {
        return setProp("userAgent", v);
    }

    public JsProp<String> userLanguage(){
        return getProp(String.class, "userLanguage");
    }

    public IJsPropSetter userLanguage(String v) {
        return setProp("userLanguage", v);
    }

    public IJsPropSetter userLanguage(IValueBinding<String> v) {
        return setProp("userLanguage", v);
    }

    public JsProp<String> language(){
        return getProp(String.class, "language");
    }

    public IJsPropSetter language(String v) {
        return setProp("language", v);
    }

    public IJsPropSetter language(IValueBinding<String> v) {
        return setProp("language", v);
    }

    public JsProp<String> cpuClass(){
        return getProp(String.class, "cpuClass");
    }

    public IJsPropSetter cpuClass(String v) {
        return setProp("cpuClass", v);
    }

    public IJsPropSetter cpuClass(IValueBinding<String> v) {
        return setProp("cpuClass", v);
    }

    public JsProp<Boolean> onLine(){
        return getProp(Boolean.class, "onLine");
    }

    public IJsPropSetter onLine(boolean v) {
        return setProp("onLine", v);
    }

    public IJsPropSetter onLine(IValueBinding<Boolean> v) {
        return setProp("onLine", v);
    }

    /**

 Specifies whether or not the browser has Java enabled
 @return
 
*/

public JsFunc<Boolean> javaEnabled(){
        return call(Boolean.class, "javaEnabled");
    }

    /**

 Specifies whether or not the browser has data tainting enabled
 @return
 
*/

public JsFunc<Boolean> taintEnabled(){
        return call(Boolean.class, "taintEnabled");
    }
    
    public static JsTypeRef<NavigatorJsr> prototype = new JsTypeRef<NavigatorJsr>(S);
}