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
import org.eclipse.vjet.vsf.jsbrowser.jsr.ElementJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementStyleJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLElementJsr extends ElementJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLElement", HTMLElementJsr.class, "HTMLElement");

    public HTMLElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> id(){
        return getProp(String.class, "id");
    }

    public IJsPropSetter id(String v) {
        return setProp("id", v);
    }

    public IJsPropSetter id(IValueBinding<String> v) {
        return setProp("id", v);
    }

    public JsProp<String> title(){
        return getProp(String.class, "title");
    }

    public IJsPropSetter title(String v) {
        return setProp("title", v);
    }

    public IJsPropSetter title(IValueBinding<String> v) {
        return setProp("title", v);
    }

    public JsProp<String> lang(){
        return getProp(String.class, "lang");
    }

    public IJsPropSetter lang(String v) {
        return setProp("lang", v);
    }

    public IJsPropSetter lang(IValueBinding<String> v) {
        return setProp("lang", v);
    }

    public JsProp<String> dir(){
        return getProp(String.class, "dir");
    }

    public IJsPropSetter dir(String v) {
        return setProp("dir", v);
    }

    public IJsPropSetter dir(IValueBinding<String> v) {
        return setProp("dir", v);
    }

    public JsProp<String> className(){
        return getProp(String.class, "className");
    }

    public IJsPropSetter className(String v) {
        return setProp("className", v);
    }

    public IJsPropSetter className(IValueBinding<String> v) {
        return setProp("className", v);
    }

    public JsProp<String> innerHTML(){
        return getProp(String.class, "innerHTML");
    }

    public IJsPropSetter innerHTML(String v) {
        return setProp("innerHTML", v);
    }

    public IJsPropSetter innerHTML(IValueBinding<String> v) {
        return setProp("innerHTML", v);
    }

    public JsProp<HTMLElementStyleJsr> style(){
        return getProp(HTMLElementStyleJsr.class, "style");
    }

    public IJsPropSetter style(HTMLElementStyleJsr v) {
        return setProp("style", v);
    }

    public IJsPropSetter style(IValueBinding<? extends HTMLElementStyleJsr> v) {
        return setProp("style", v);
    }

    public JsProp<HTMLElementStyleJsr> currentStyle(){
        return getProp(HTMLElementStyleJsr.class, "currentStyle");
    }

    public IJsPropSetter currentStyle(HTMLElementStyleJsr v) {
        return setProp("currentStyle", v);
    }

    public IJsPropSetter currentStyle(IValueBinding<? extends HTMLElementStyleJsr> v) {
        return setProp("currentStyle", v);
    }

    public JsProp<HTMLElementStyleJsr> runtimeStyle(){
        return getProp(HTMLElementStyleJsr.class, "runtimeStyle");
    }

    public IJsPropSetter runtimeStyle(HTMLElementStyleJsr v) {
        return setProp("runtimeStyle", v);
    }

    public IJsPropSetter runtimeStyle(IValueBinding<? extends HTMLElementStyleJsr> v) {
        return setProp("runtimeStyle", v);
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

    public JsProp<Object> onscroll(){
        return getProp(Object.class, "onscroll");
    }

    public IJsPropSetter onscroll(Object v) {
        return setProp("onscroll", v);
    }

    public IJsPropSetter onscroll(IValueBinding<Object> v) {
        return setProp("onscroll", v);
    }

    /**

 Set's focus to the HTML element. Not all elements implement this method
 so there may be no behavior in browser.
 
*/

public JsFunc<Void> focus(){
        return call("focus");
    }

    /**

 Removes focus from the HTML element. Not all elements implement this
 method so there may be no behavior in browser.
 
*/

public JsFunc<Void> blur(){
        return call("blur");
    }

    /**

 Returns the component located at the specified coordinates via certain
 events.
 @param iCoordXRequired. Specifies the client window coordinate of x.
 @param iCoordYRequired. Specifies the client window coordinate of y.
 @return     String. Returns one of the following possible values.
 empty string
 Component is inside the client area of the object.
 outside
 Component is outside the bounds of the object.
 scrollbarDown
 Down scroll arrow is at the specified location.
 scrollbarHThumb
 Horizontal scroll thumb or box is at the specified location.
 scrollbarLeft
 Left scroll arrow is at the specified location.
 scrollbarPageDown
 Page-down scroll bar shaft is at the specified location.
 scrollbarPageLeft
 Page-left scroll bar shaft is at the specified location.
 scrollbarPageRight
 Page-right scroll bar shaft is at the specified location.
 scrollbarPageUp
 Page-up scroll bar shaft is at the specified location.
 scrollbarRight
 Right scroll arrow is at the specified location.
 scrollbarUp
 Up scroll arrow is at the specified location.
 scrollbarVThumb
 Vertical scroll thumb or box is at the specified location.
 handleBottom
 Bottom sizing handle is at the specified location.
 handleBottomLeft
 Lower-left sizing handle is at the specified location.
 handleBottomRight
 Lower-right sizing handle is at the specified location.
 handleLeft
 Left sizing handle is at the specified location.
 handleRight
 Right sizing handle is at the specified location.
 handleTop
 Top sizing handle is at the specified location.
 handleTopLeft
 Upper-left sizing handle is at the specified location.
 handleTopRight
 Upper-right sizing handle is at the specified location.
 
*/

public JsFunc<String> componentFromPoint(int iCoordX, int iCoordY){
        return call(String.class, "componentFromPoint").with(iCoordX, iCoordY);
    }

    /**

 Returns the component located at the specified coordinates via certain
 events.
 @param iCoordXRequired. Specifies the client window coordinate of x.
 @param iCoordYRequired. Specifies the client window coordinate of y.
 @return     String. Returns one of the following possible values.
 empty string
 Component is inside the client area of the object.
 outside
 Component is outside the bounds of the object.
 scrollbarDown
 Down scroll arrow is at the specified location.
 scrollbarHThumb
 Horizontal scroll thumb or box is at the specified location.
 scrollbarLeft
 Left scroll arrow is at the specified location.
 scrollbarPageDown
 Page-down scroll bar shaft is at the specified location.
 scrollbarPageLeft
 Page-left scroll bar shaft is at the specified location.
 scrollbarPageRight
 Page-right scroll bar shaft is at the specified location.
 scrollbarPageUp
 Page-up scroll bar shaft is at the specified location.
 scrollbarRight
 Right scroll arrow is at the specified location.
 scrollbarUp
 Up scroll arrow is at the specified location.
 scrollbarVThumb
 Vertical scroll thumb or box is at the specified location.
 handleBottom
 Bottom sizing handle is at the specified location.
 handleBottomLeft
 Lower-left sizing handle is at the specified location.
 handleBottomRight
 Lower-right sizing handle is at the specified location.
 handleLeft
 Left sizing handle is at the specified location.
 handleRight
 Right sizing handle is at the specified location.
 handleTop
 Top sizing handle is at the specified location.
 handleTopLeft
 Upper-left sizing handle is at the specified location.
 handleTopRight
 Upper-right sizing handle is at the specified location.
 
*/

public JsFunc<String> componentFromPoint(IValueBinding<Integer> iCoordX, IValueBinding<Integer> iCoordY){
        return call(String.class, "componentFromPoint").with(iCoordX, iCoordY);
    }

    public JsFunc<Void> doScroll(){
        return call("doScroll");
    }

    public JsFunc<Void> doScroll(String sScrollAction){
        return call("doScroll").with(sScrollAction);
    }

    public JsFunc<Void> doScroll(IValueBinding<String> sScrollAction){
        return call("doScroll").with(sScrollAction);
    }

    /**

 Returns the adjacent text string.
 Syntax
 text = object.getAdjacentText(sWhere)
 @param sWhere 	Required. A String that specifies where the text is located by using one of the following values.
 beforeBegin
 Text is returned immediately before the element.
 afterBegin
 Text is returned after the start of the element but before all other content in the element.
 beforeEnd
 Text is returned immediately before the end of the element but after all other content in the element.
 afterEnd
 Text is returned immediately after the end of the element.
 
*/

public JsFunc<String> getAdjacentText(String sWhere){
        return call(String.class, "getAdjacentText").with(sWhere);
    }

    /**

 Returns the adjacent text string.
 Syntax
 text = object.getAdjacentText(sWhere)
 @param sWhere 	Required. A String that specifies where the text is located by using one of the following values.
 beforeBegin
 Text is returned immediately before the element.
 afterBegin
 Text is returned after the start of the element but before all other content in the element.
 beforeEnd
 Text is returned immediately before the end of the element but after all other content in the element.
 afterEnd
 Text is returned immediately after the end of the element.
 
*/

public JsFunc<String> getAdjacentText(IValueBinding<String> sWhere){
        return call(String.class, "getAdjacentText").with(sWhere);
    }
    
    public static JsTypeRef<HTMLElementJsr> prototype = new JsTypeRef<HTMLElementJsr>(S);
}