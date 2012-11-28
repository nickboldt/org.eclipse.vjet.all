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
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLMarqueeElementJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLMarqueeElement", HTMLMarqueeElementJsr.class, "HTMLMarqueeElement");

    public HTMLMarqueeElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLMarqueeElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> behavior(){
        return getProp(String.class, "behavior");
    }

    public IJsPropSetter behavior(String v) {
        return setProp("behavior", v);
    }

    public IJsPropSetter behavior(IValueBinding<String> v) {
        return setProp("behavior", v);
    }

    public JsProp<String> bgcolor(){
        return getProp(String.class, "bgcolor");
    }

    public IJsPropSetter bgcolor(String v) {
        return setProp("bgcolor", v);
    }

    public IJsPropSetter bgcolor(IValueBinding<String> v) {
        return setProp("bgcolor", v);
    }

    public JsProp<String> direction(){
        return getProp(String.class, "direction");
    }

    public IJsPropSetter direction(String v) {
        return setProp("direction", v);
    }

    public IJsPropSetter direction(IValueBinding<String> v) {
        return setProp("direction", v);
    }

    public JsProp<String> height(){
        return getProp(String.class, "height");
    }

    public IJsPropSetter height(String v) {
        return setProp("height", v);
    }

    public IJsPropSetter height(IValueBinding<String> v) {
        return setProp("height", v);
    }

    public JsProp<String> hspace(){
        return getProp(String.class, "hspace");
    }

    public IJsPropSetter hspace(String v) {
        return setProp("hspace", v);
    }

    public IJsPropSetter hspace(IValueBinding<String> v) {
        return setProp("hspace", v);
    }

    public JsProp<String> loop(){
        return getProp(String.class, "loop");
    }

    public IJsPropSetter loop(String v) {
        return setProp("loop", v);
    }

    public IJsPropSetter loop(IValueBinding<String> v) {
        return setProp("loop", v);
    }

    public JsProp<String> scrollamount(){
        return getProp(String.class, "scrollamount");
    }

    public IJsPropSetter scrollamount(String v) {
        return setProp("scrollamount", v);
    }

    public IJsPropSetter scrollamount(IValueBinding<String> v) {
        return setProp("scrollamount", v);
    }

    public JsProp<String> scrolldelay(){
        return getProp(String.class, "scrolldelay");
    }

    public IJsPropSetter scrolldelay(String v) {
        return setProp("scrolldelay", v);
    }

    public IJsPropSetter scrolldelay(IValueBinding<String> v) {
        return setProp("scrolldelay", v);
    }

    public JsProp<String> truespeed(){
        return getProp(String.class, "truespeed");
    }

    public IJsPropSetter truespeed(String v) {
        return setProp("truespeed", v);
    }

    public IJsPropSetter truespeed(IValueBinding<String> v) {
        return setProp("truespeed", v);
    }

    public JsProp<String> vspace(){
        return getProp(String.class, "vspace");
    }

    public IJsPropSetter vspace(String v) {
        return setProp("vspace", v);
    }

    public IJsPropSetter vspace(IValueBinding<String> v) {
        return setProp("vspace", v);
    }

    public JsProp<String> width(){
        return getProp(String.class, "width");
    }

    public IJsPropSetter width(String v) {
        return setProp("width", v);
    }

    public IJsPropSetter width(IValueBinding<String> v) {
        return setProp("width", v);
    }

    /**

 Starts scrolling of the marquee
 
*/

public JsFunc<Void> start(){
        return call("start");
    }

    /**

 Stops scrolling of the marquee
 
*/

public JsFunc<Void> stop(){
        return call("stop");
    }
    
    public static JsTypeRef<HTMLMarqueeElementJsr> prototype = new JsTypeRef<HTMLMarqueeElementJsr>(S);
}