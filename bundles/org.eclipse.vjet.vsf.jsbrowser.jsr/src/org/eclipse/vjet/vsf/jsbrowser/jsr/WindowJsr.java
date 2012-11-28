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
import org.eclipse.vjet.vsf.jsbrowser.jsr.EventJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.ExternalJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.FramesJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLCollectionJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLDocumentJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLElementStyleJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HistoryJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.LocationJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.NavigatorJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.OperaJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.ScreenJsr;
import org.eclipse.vjet.vsf.jsnative.jsr.GlobalJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class WindowJsr extends GlobalJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("window", null, null, true);

    public WindowJsr(){
        super(S.getJsCmpMeta(), false);
    }

    protected WindowJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Boolean> closed(){
        return getProp(Boolean.class, "closed");
    }

    public IJsPropSetter closed(boolean v) {
        return setProp("closed", v);
    }

    public IJsPropSetter closed(IValueBinding<Boolean> v) {
        return setProp("closed", v);
    }

    public JsProp<String> defaultStatus(){
        return getProp(String.class, "defaultStatus");
    }

    public IJsPropSetter defaultStatus(String v) {
        return setProp("defaultStatus", v);
    }

    public IJsPropSetter defaultStatus(IValueBinding<String> v) {
        return setProp("defaultStatus", v);
    }

    public JsProp<HTMLDocumentJsr> document(){
        return getProp(HTMLDocumentJsr.class, "document");
    }

    public IJsPropSetter document(HTMLDocumentJsr v) {
        return setProp("document", v);
    }

    public IJsPropSetter document(IValueBinding<? extends HTMLDocumentJsr> v) {
        return setProp("document", v);
    }

    public JsProp<HTMLCollectionJsr> frames(){
        return getProp(HTMLCollectionJsr.class, "frames");
    }

    public IJsPropSetter frames(HTMLCollectionJsr v) {
        return setProp("frames", v);
    }

    public IJsPropSetter frames(IValueBinding<? extends HTMLCollectionJsr> v) {
        return setProp("frames", v);
    }

    public JsProp<FramesJsr> childWindows(){
        return getProp(FramesJsr.class, "childWindows");
    }

    public IJsPropSetter childWindows(FramesJsr v) {
        return setProp("childWindows", v);
    }

    public IJsPropSetter childWindows(IValueBinding<? extends FramesJsr> v) {
        return setProp("childWindows", v);
    }

    public JsProp<HistoryJsr> history(){
        return getProp(HistoryJsr.class, "history");
    }

    public IJsPropSetter history(HistoryJsr v) {
        return setProp("history", v);
    }

    public IJsPropSetter history(IValueBinding<? extends HistoryJsr> v) {
        return setProp("history", v);
    }

    public JsProp<LocationJsr> location(){
        return getProp(LocationJsr.class, "location");
    }

    public IJsPropSetter location(LocationJsr v) {
        return setProp("location", v);
    }

    public IJsPropSetter location(IValueBinding<? extends LocationJsr> v) {
        return setProp("location", v);
    }

    public JsProp<String> name(){
        return getProp(String.class, "name");
    }

    public IJsPropSetter name(String v) {
        return setProp("name", v);
    }

    public IJsPropSetter name(IValueBinding<String> v) {
        return setProp("name", v);
    }

    public JsProp<NavigatorJsr> navigator(){
        return getProp(NavigatorJsr.class, "navigator");
    }

    public IJsPropSetter navigator(NavigatorJsr v) {
        return setProp("navigator", v);
    }

    public IJsPropSetter navigator(IValueBinding<? extends NavigatorJsr> v) {
        return setProp("navigator", v);
    }

    public JsProp<WindowJsr> opener(){
        return getProp(WindowJsr.class, "opener");
    }

    public IJsPropSetter opener(WindowJsr v) {
        return setProp("opener", v);
    }

    public IJsPropSetter opener(IValueBinding<? extends WindowJsr> v) {
        return setProp("opener", v);
    }

    public JsProp<WindowJsr> parent(){
        return getProp(WindowJsr.class, "parent");
    }

    public IJsPropSetter parent(WindowJsr v) {
        return setProp("parent", v);
    }

    public IJsPropSetter parent(IValueBinding<? extends WindowJsr> v) {
        return setProp("parent", v);
    }

    public JsProp<WindowJsr> self(){
        return getProp(WindowJsr.class, "self");
    }

    public IJsPropSetter self(WindowJsr v) {
        return setProp("self", v);
    }

    public IJsPropSetter self(IValueBinding<? extends WindowJsr> v) {
        return setProp("self", v);
    }

    public JsProp<String> status(){
        return getProp(String.class, "status");
    }

    public IJsPropSetter status(String v) {
        return setProp("status", v);
    }

    public IJsPropSetter status(IValueBinding<String> v) {
        return setProp("status", v);
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

    public JsProp<WindowJsr> top(){
        return getProp(WindowJsr.class, "top");
    }

    public IJsPropSetter top(WindowJsr v) {
        return setProp("top", v);
    }

    public IJsPropSetter top(IValueBinding<? extends WindowJsr> v) {
        return setProp("top", v);
    }

    public JsProp<Integer> length(){
        return getProp(Integer.class, "length");
    }

    public IJsPropSetter length(int v) {
        return setProp("length", v);
    }

    public IJsPropSetter length(IValueBinding<Integer> v) {
        return setProp("length", v);
    }

    public JsProp<ScreenJsr> screen(){
        return getProp(ScreenJsr.class, "screen");
    }

    public IJsPropSetter screen(ScreenJsr v) {
        return setProp("screen", v);
    }

    public IJsPropSetter screen(IValueBinding<? extends ScreenJsr> v) {
        return setProp("screen", v);
    }

    public JsProp<WindowJsr> window(){
        return getProp(WindowJsr.class, "window");
    }

    public IJsPropSetter window(WindowJsr v) {
        return setProp("window", v);
    }

    public IJsPropSetter window(IValueBinding<? extends WindowJsr> v) {
        return setProp("window", v);
    }

    public JsProp<Integer> innerWidth(){
        return getProp(Integer.class, "innerWidth");
    }

    public IJsPropSetter innerWidth(int v) {
        return setProp("innerWidth", v);
    }

    public IJsPropSetter innerWidth(IValueBinding<Integer> v) {
        return setProp("innerWidth", v);
    }

    public JsProp<Integer> innerHeight(){
        return getProp(Integer.class, "innerHeight");
    }

    public IJsPropSetter innerHeight(int v) {
        return setProp("innerHeight", v);
    }

    public IJsPropSetter innerHeight(IValueBinding<Integer> v) {
        return setProp("innerHeight", v);
    }

    public JsProp<Integer> outerWidth(){
        return getProp(Integer.class, "outerWidth");
    }

    public IJsPropSetter outerWidth(int v) {
        return setProp("outerWidth", v);
    }

    public IJsPropSetter outerWidth(IValueBinding<Integer> v) {
        return setProp("outerWidth", v);
    }

    public JsProp<Integer> outerHeight(){
        return getProp(Integer.class, "outerHeight");
    }

    public IJsPropSetter outerHeight(int v) {
        return setProp("outerHeight", v);
    }

    public IJsPropSetter outerHeight(IValueBinding<Integer> v) {
        return setProp("outerHeight", v);
    }

    public JsProp<Integer> pageXOffset(){
        return getProp(Integer.class, "pageXOffset");
    }

    public IJsPropSetter pageXOffset(int v) {
        return setProp("pageXOffset", v);
    }

    public IJsPropSetter pageXOffset(IValueBinding<Integer> v) {
        return setProp("pageXOffset", v);
    }

    public JsProp<Integer> pageYOffset(){
        return getProp(Integer.class, "pageYOffset");
    }

    public IJsPropSetter pageYOffset(int v) {
        return setProp("pageYOffset", v);
    }

    public IJsPropSetter pageYOffset(IValueBinding<Integer> v) {
        return setProp("pageYOffset", v);
    }

    public JsProp<Integer> screenLeft(){
        return getProp(Integer.class, "screenLeft");
    }

    public IJsPropSetter screenLeft(int v) {
        return setProp("screenLeft", v);
    }

    public IJsPropSetter screenLeft(IValueBinding<Integer> v) {
        return setProp("screenLeft", v);
    }

    public JsProp<Integer> screenTop(){
        return getProp(Integer.class, "screenTop");
    }

    public IJsPropSetter screenTop(int v) {
        return setProp("screenTop", v);
    }

    public IJsPropSetter screenTop(IValueBinding<Integer> v) {
        return setProp("screenTop", v);
    }

    public JsProp<Integer> screenX(){
        return getProp(Integer.class, "screenX");
    }

    public IJsPropSetter screenX(int v) {
        return setProp("screenX", v);
    }

    public IJsPropSetter screenX(IValueBinding<Integer> v) {
        return setProp("screenX", v);
    }

    public JsProp<Integer> screenY(){
        return getProp(Integer.class, "screenY");
    }

    public IJsPropSetter screenY(int v) {
        return setProp("screenY", v);
    }

    public IJsPropSetter screenY(IValueBinding<Integer> v) {
        return setProp("screenY", v);
    }

    public JsProp<ExternalJsr> external(){
        return getProp(ExternalJsr.class, "external");
    }

    public IJsPropSetter external(ExternalJsr v) {
        return setProp("external", v);
    }

    public IJsPropSetter external(IValueBinding<? extends ExternalJsr> v) {
        return setProp("external", v);
    }

    public JsProp<EventJsr> event(){
        return getProp(EventJsr.class, "event");
    }

    public IJsPropSetter event(EventJsr v) {
        return setProp("event", v);
    }

    public IJsPropSetter event(IValueBinding<? extends EventJsr> v) {
        return setProp("event", v);
    }

    public JsProp<Object> onblur(){
        return getProp(Object.class, "onblur");
    }

    public IJsPropSetter onblur(Object v) {
        return setProp("onblur", v);
    }

    public IJsPropSetter onblur(IValueBinding<Object> v) {
        return setProp("onblur", v);
    }

    public JsProp<Object> onfocus(){
        return getProp(Object.class, "onfocus");
    }

    public IJsPropSetter onfocus(Object v) {
        return setProp("onfocus", v);
    }

    public IJsPropSetter onfocus(IValueBinding<Object> v) {
        return setProp("onfocus", v);
    }

    public JsProp<Object> onload(){
        return getProp(Object.class, "onload");
    }

    public IJsPropSetter onload(Object v) {
        return setProp("onload", v);
    }

    public IJsPropSetter onload(IValueBinding<Object> v) {
        return setProp("onload", v);
    }

    public JsProp<Object> onunload(){
        return getProp(Object.class, "onunload");
    }

    public IJsPropSetter onunload(Object v) {
        return setProp("onunload", v);
    }

    public IJsPropSetter onunload(IValueBinding<Object> v) {
        return setProp("onunload", v);
    }

    public JsProp<Object> onresize(){
        return getProp(Object.class, "onresize");
    }

    public IJsPropSetter onresize(Object v) {
        return setProp("onresize", v);
    }

    public IJsPropSetter onresize(IValueBinding<Object> v) {
        return setProp("onresize", v);
    }

    public JsProp<OperaJsr> opera(){
        return getProp(OperaJsr.class, "opera");
    }

    public IJsPropSetter opera(OperaJsr v) {
        return setProp("opera", v);
    }

    public IJsPropSetter opera(IValueBinding<? extends OperaJsr> v) {
        return setProp("opera", v);
    }

    /**

 Displays an alert box with a message and an OK button
 @param message
 
*/

public JsFunc<Void> alert(Object message){
        return call("alert").with(message);
    }

    /**

 Removes focus from the current window
 
*/

public JsFunc<Void> blur(){
        return call("blur");
    }

    /**

 Cancels a timeout set with setInterval()
 @param idThe ID value returned by setInterval()
 
*/

public JsFunc<Void> clearInterval(int id){
        return call("clearInterval").with(id);
    }

    /**

 Cancels a timeout set with setInterval()
 @param idThe ID value returned by setInterval()
 
*/

public JsFunc<Void> clearInterval(IValueBinding<Integer> id){
        return call("clearInterval").with(id);
    }

    /**

 Cancels a timeout set with setTimeout()
 @param idThe ID value returned by setTimeout()
 
*/

public JsFunc<Void> clearTimeout(int id){
        return call("clearTimeout").with(id);
    }

    /**

 Cancels a timeout set with setTimeout()
 @param idThe ID value returned by setTimeout()
 
*/

public JsFunc<Void> clearTimeout(IValueBinding<Integer> id){
        return call("clearTimeout").with(id);
    }

    /**

 Closes the current window
 
*/

public JsFunc<Void> close(){
        return call("close");
    }

    /**

 Displays a dialog box with a message and an OK and a Cancel button
 @param messagestring message
 @return true if OK is pressed
 
*/

public JsFunc<Boolean> confirm(String message){
        return call(Boolean.class, "confirm").with(message);
    }

    /**

 Displays a dialog box with a message and an OK and a Cancel button
 @param messagestring message
 @return true if OK is pressed
 
*/

public JsFunc<Boolean> confirm(IValueBinding<String> message){
        return call(Boolean.class, "confirm").with(message);
    }

    /**

 Sets focus to the current window
 
*/

public JsFunc<Void> focus(){
        return call("focus");
    }

    /**

 Moves a window relative to its current position
 @param xint number of pixels
 @param yint number of pixels
 
*/

public JsFunc<Void> moveBy(int x, int y){
        return call("moveBy").with(x, y);
    }

    /**

 Moves a window relative to its current position
 @param xint number of pixels
 @param yint number of pixels
 
*/

public JsFunc<Void> moveBy(IValueBinding<Integer> x, IValueBinding<Integer> y){
        return call("moveBy").with(x, y);
    }

    /**

 Moves a window to the specified position
 @param xint number of pixels
 @param yint number of pixels
 
*/

public JsFunc<Void> moveTo(int x, int y){
        return call("moveTo").with(x, y);
    }

    /**

 Moves a window to the specified position
 @param xint number of pixels
 @param yint number of pixels
 
*/

public JsFunc<Void> moveTo(IValueBinding<Integer> x, IValueBinding<Integer> y){
        return call("moveTo").with(x, y);
    }

    public JsFunc<? extends WindowJsr> open(String url){
        return call(WindowJsr.class, "open").with(url);
    }

    public JsFunc<? extends WindowJsr> open(IValueBinding<String> url){
        return call(WindowJsr.class, "open").with(url);
    }

    public JsFunc<? extends WindowJsr> open(String url, String windowName){
        return call(WindowJsr.class, "open").with(url, windowName);
    }

    public JsFunc<? extends WindowJsr> open(IValueBinding<String> url, IValueBinding<String> windowName){
        return call(WindowJsr.class, "open").with(url, windowName);
    }

    public JsFunc<? extends WindowJsr> open(String url, String windowName, String features){
        return call(WindowJsr.class, "open").with(url, windowName, features);
    }

    public JsFunc<? extends WindowJsr> open(IValueBinding<String> url, IValueBinding<String> windowName, IValueBinding<String> features){
        return call(WindowJsr.class, "open").with(url, windowName, features);
    }

    public JsFunc<? extends WindowJsr> open(String url, String windowName, String features, boolean replace){
        return call(WindowJsr.class, "open").with(url, windowName, features, replace);
    }

    public JsFunc<? extends WindowJsr> open(IValueBinding<String> url, IValueBinding<String> windowName, IValueBinding<String> features, IValueBinding<Boolean> replace){
        return call(WindowJsr.class, "open").with(url, windowName, features, replace);
    }

    public JsFunc<? extends WindowJsr> open(){
        return call(WindowJsr.class, "open");
    }

    /**

 Prints the contents of the current window
 
*/

public JsFunc<Void> print(){
        return call("print");
    }

    public JsFunc<String> prompt(String message){
        return call(String.class, "prompt").with(message);
    }

    public JsFunc<String> prompt(IValueBinding<String> message){
        return call(String.class, "prompt").with(message);
    }

    public JsFunc<String> prompt(String message, String defaultReply){
        return call(String.class, "prompt").with(message, defaultReply);
    }

    public JsFunc<String> prompt(IValueBinding<String> message, IValueBinding<String> defaultReply){
        return call(String.class, "prompt").with(message, defaultReply);
    }

    public JsFunc<String> prompt(){
        return call(String.class, "prompt");
    }

    /**

 Resizes a window by the specified pixels
 @param widthHow many pixels to resize the width by. Can be a positive or a
 negative number
 @param heightHow many pixels to resize the height by. Can be a positive or
 a negative number
 
*/

public JsFunc<Void> resizeBy(int width, int height){
        return call("resizeBy").with(width, height);
    }

    /**

 Resizes a window by the specified pixels
 @param widthHow many pixels to resize the width by. Can be a positive or a
 negative number
 @param heightHow many pixels to resize the height by. Can be a positive or
 a negative number
 
*/

public JsFunc<Void> resizeBy(IValueBinding<Integer> width, IValueBinding<Integer> height){
        return call("resizeBy").with(width, height);
    }

    /**

 Resizes a window to the specified width and height
 @param widthThe width of the window (in pixels)
 @param heightThe height of the window (in pixels)
 
*/

public JsFunc<Void> resizeTo(int width, int height){
        return call("resizeTo").with(width, height);
    }

    /**

 Resizes a window to the specified width and height
 @param widthThe width of the window (in pixels)
 @param heightThe height of the window (in pixels)
 
*/

public JsFunc<Void> resizeTo(IValueBinding<Integer> width, IValueBinding<Integer> height){
        return call("resizeTo").with(width, height);
    }

    /**

 Scrolls the content by the specified number of pixels
 @param xHow many pixels to scroll by, along the x-axis
 @param yHow many pixels to scroll by, along the y-axis
 
*/

public JsFunc<Void> scrollBy(int x, int y){
        return call("scrollBy").with(x, y);
    }

    /**

 Scrolls the content by the specified number of pixels
 @param xHow many pixels to scroll by, along the x-axis
 @param yHow many pixels to scroll by, along the y-axis
 
*/

public JsFunc<Void> scrollBy(IValueBinding<Integer> x, IValueBinding<Integer> y){
        return call("scrollBy").with(x, y);
    }

    /**

 Scrolls the content to the specified coordinates
 @param xThe position to scroll to, along the x-axis
 @param yThe position to scroll to, along the y-axis
 
*/

public JsFunc<Void> scrollTo(int x, int y){
        return call("scrollTo").with(x, y);
    }

    /**

 Scrolls the content to the specified coordinates
 @param xThe position to scroll to, along the x-axis
 @param yThe position to scroll to, along the y-axis
 
*/

public JsFunc<Void> scrollTo(IValueBinding<Integer> x, IValueBinding<Integer> y){
        return call("scrollTo").with(x, y);
    }

    /**

 Evaluates an expression at specified intervals
 @param codefunction or the code to be executed
 @param msecsthe number of milliseconds
 @return The ID value returned by setInterval() is used as the parameter
 for the clearInterval() method
 
*/

public JsFunc<Integer> setInterval(Object code, int msecs){
        return call(Integer.class, "setInterval").with(code, msecs);
    }

    /**

 Evaluates an expression at specified intervals
 @param codefunction or the code to be executed
 @param msecsthe number of milliseconds
 @return The ID value returned by setInterval() is used as the parameter
 for the clearInterval() method
 
*/

public JsFunc<Integer> setInterval(IValueBinding<Object> code, IValueBinding<Integer> msecs){
        return call(Integer.class, "setInterval").with(code, msecs);
    }

    /**

 Evaluates an expression after a specified number of milliseconds
 @param codefunction or the code to be executed
 @param msecsThe number of milliseconds to wait before executing the code
 @return The ID value returned by setTimeout() is used as the parameter
 for the clearTimeout() method
 
*/

public JsFunc<Integer> setTimeout(Object code, int msecs){
        return call(Integer.class, "setTimeout").with(code, msecs);
    }

    /**

 Evaluates an expression after a specified number of milliseconds
 @param codefunction or the code to be executed
 @param msecsThe number of milliseconds to wait before executing the code
 @return The ID value returned by setTimeout() is used as the parameter
 for the clearTimeout() method
 
*/

public JsFunc<Integer> setTimeout(IValueBinding<Object> code, IValueBinding<Integer> msecs){
        return call(Integer.class, "setTimeout").with(code, msecs);
    }

    /**

 Returns computed style of the element.
 @param elem
 @param pseudoElem
 @return
 
*/

public JsFunc<? extends HTMLElementStyleJsr> getComputedStyle(HTMLElementJsr elem, String pseudoElem){
        return call(HTMLElementStyleJsr.class, "getComputedStyle").with(elem, pseudoElem);
    }

    /**

 Returns computed style of the element.
 @param elem
 @param pseudoElem
 @return
 
*/

public JsFunc<? extends HTMLElementStyleJsr> getComputedStyle(IValueBinding<? extends HTMLElementJsr> elem, IValueBinding<String> pseudoElem){
        return call(HTMLElementStyleJsr.class, "getComputedStyle").with(elem, pseudoElem);
    }

    public JsFunc<Void> addEventListener(String type, Object listener, boolean useCapture){
        return call("addEventListener").with(type, listener, useCapture);
    }

    public JsFunc<Void> addEventListener(IValueBinding<String> type, IValueBinding<Object> listener, IValueBinding<Boolean> useCapture){
        return call("addEventListener").with(type, listener, useCapture);
    }

    public JsFunc<Void> attachEvent(String type, Object listener){
        return call("attachEvent").with(type, listener);
    }

    public JsFunc<Void> attachEvent(IValueBinding<String> type, IValueBinding<Object> listener){
        return call("attachEvent").with(type, listener);
    }
    
    public static JsTypeRef<WindowJsr> prototype = new JsTypeRef<WindowJsr>(S);
}