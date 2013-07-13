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
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLFormElementJsr;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class OptionJsr extends HTMLElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("Option", OptionJsr.class, "Option");

    public OptionJsr(String text){
        super(S.getJsCmpMeta(), true, text);
    }

    public OptionJsr(IValueBinding<String> text){
        super(S.getJsCmpMeta(), true, text);
    }

    public OptionJsr(String text, Object value){
        super(S.getJsCmpMeta(), true, text, value);
    }

    public OptionJsr(IValueBinding<String> text, IValueBinding<Object> value){
        super(S.getJsCmpMeta(), true, text, value);
    }

    public OptionJsr(String text, Object value, boolean defaultSelected){
        super(S.getJsCmpMeta(), true, text, value, defaultSelected);
    }

    public OptionJsr(IValueBinding<String> text, IValueBinding<Object> value, IValueBinding<Boolean> defaultSelected){
        super(S.getJsCmpMeta(), true, text, value, defaultSelected);
    }

    public OptionJsr(String text, Object value, boolean defaultSelected, boolean selected){
        super(S.getJsCmpMeta(), true, text, value, defaultSelected, selected);
    }

    public OptionJsr(IValueBinding<String> text, IValueBinding<Object> value, IValueBinding<Boolean> defaultSelected, IValueBinding<Boolean> selected){
        super(S.getJsCmpMeta(), true, text, value, defaultSelected, selected);
    }

    public OptionJsr(String text, Object value, int defaultSelected, int selected){
        super(S.getJsCmpMeta(), true, text, value, defaultSelected, selected);
    }

    public OptionJsr(IValueBinding<String> text, IValueBinding<Object> value, IValueBinding<Integer> defaultSelected, IValueBinding<Integer> selected, org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        super(S.getJsCmpMeta(), true, text, value, defaultSelected, selected);
    }

    public OptionJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected OptionJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<HTMLFormElementJsr> form(){
        return getProp(HTMLFormElementJsr.class, "form");
    }

    public IJsPropSetter form(HTMLFormElementJsr v) {
        return setProp("form", v);
    }

    public IJsPropSetter form(IValueBinding<? extends HTMLFormElementJsr> v) {
        return setProp("form", v);
    }

    public JsProp<Boolean> defaultSelected(){
        return getProp(Boolean.class, "defaultSelected");
    }

    public IJsPropSetter defaultSelected(boolean v) {
        return setProp("defaultSelected", v);
    }

    public IJsPropSetter defaultSelected(IValueBinding<Boolean> v) {
        return setProp("defaultSelected", v);
    }

    public JsProp<String> text(){
        return getProp(String.class, "text");
    }

    public IJsPropSetter text(String v) {
        return setProp("text", v);
    }

    public IJsPropSetter text(IValueBinding<String> v) {
        return setProp("text", v);
    }

    public JsProp<Integer> index(){
        return getProp(Integer.class, "index");
    }

    public IJsPropSetter index(int v) {
        return setProp("index", v);
    }

    public IJsPropSetter index(IValueBinding<Integer> v) {
        return setProp("index", v);
    }

    public JsProp<Boolean> disabled(){
        return getProp(Boolean.class, "disabled");
    }

    public IJsPropSetter disabled(boolean v) {
        return setProp("disabled", v);
    }

    public IJsPropSetter disabled(IValueBinding<Boolean> v) {
        return setProp("disabled", v);
    }

    public JsProp<String> label(){
        return getProp(String.class, "label");
    }

    public IJsPropSetter label(String v) {
        return setProp("label", v);
    }

    public IJsPropSetter label(IValueBinding<String> v) {
        return setProp("label", v);
    }

    public JsProp<Boolean> selected(){
        return getProp(Boolean.class, "selected");
    }

    public IJsPropSetter selected(boolean v) {
        return setProp("selected", v);
    }

    public IJsPropSetter selected(IValueBinding<Boolean> v) {
        return setProp("selected", v);
    }

    public JsProp<String> value(){
        return getProp(String.class, "value");
    }

    public IJsPropSetter value(String v) {
        return setProp("value", v);
    }

    public IJsPropSetter value(IValueBinding<String> v) {
        return setProp("value", v);
    }
    
    public static JsTypeRef<OptionJsr> prototype = new JsTypeRef<OptionJsr>(S);
}