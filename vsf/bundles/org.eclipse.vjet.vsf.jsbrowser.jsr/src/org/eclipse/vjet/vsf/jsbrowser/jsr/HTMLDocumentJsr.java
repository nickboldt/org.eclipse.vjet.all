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
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.d.D1;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLDocumentJsr extends DocumentJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
            new JsObjData("document", null, null, true);

    public HTMLDocumentJsr(){
        super(S.getJsCmpMeta(), false);
    }

    protected HTMLDocumentJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<Object> all(){
        return getProp(Object.class, "all");
    }

    public IJsPropSetter all(Object v) {
        return setProp("all", v);
    }

    public IJsPropSetter all(IValueBinding<Object> v) {
        return setProp("all", v);
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

    public JsProp<String> referrer(){
        return getProp(String.class, "referrer");
    }

    public IJsPropSetter referrer(String v) {
        return setProp("referrer", v);
    }

    public IJsPropSetter referrer(IValueBinding<String> v) {
        return setProp("referrer", v);
    }

    public JsProp<String> domain(){
        return getProp(String.class, "domain");
    }

    public IJsPropSetter domain(String v) {
        return setProp("domain", v);
    }

    public IJsPropSetter domain(IValueBinding<String> v) {
        return setProp("domain", v);
    }

    public JsProp<String> URL(){
        return getProp(String.class, "URL");
    }

    public IJsPropSetter URL(String v) {
        return setProp("URL", v);
    }

    public IJsPropSetter URL(IValueBinding<String> v) {
        return setProp("URL", v);
    }

    public JsProp<HTMLBodyElementJsr> body(){
        return getProp(HTMLBodyElementJsr.class, "body");
    }

    public IJsPropSetter body(HTMLBodyElementJsr v) {
        return setProp("body", v);
    }

    public IJsPropSetter body(IValueBinding<? extends HTMLBodyElementJsr> v) {
        return setProp("body", v);
    }

    public JsProp<Object> images(){
        return getProp(Object.class, "images");
    }

    public IJsPropSetter images(Object v) {
        return setProp("images", v);
    }

    public IJsPropSetter images(IValueBinding<Object> v) {
        return setProp("images", v);
    }

    public JsProp<HTMLDOMImplementationJsr> implementation(D1... arg){
        return getProp(HTMLDOMImplementationJsr.class, "implementation");
    }

    public IJsPropSetter implementation(HTMLDOMImplementationJsr v) {
        return setProp("implementation", v);
    }

    public IJsPropSetter implementation(IValueBinding<? extends HTMLDOMImplementationJsr> v,D1... arg) {
        return setProp("implementation", v);
    }

    public JsProp<HTMLCollectionJsr> applets(){
        return getProp(HTMLCollectionJsr.class, "applets");
    }

    public IJsPropSetter applets(HTMLCollectionJsr v) {
        return setProp("applets", v);
    }

    public IJsPropSetter applets(IValueBinding<? extends HTMLCollectionJsr> v) {
        return setProp("applets", v);
    }

    public JsProp<HTMLCollectionJsr> links(){
        return getProp(HTMLCollectionJsr.class, "links");
    }

    public IJsPropSetter links(HTMLCollectionJsr v) {
        return setProp("links", v);
    }

    public IJsPropSetter links(IValueBinding<? extends HTMLCollectionJsr> v) {
        return setProp("links", v);
    }

    public JsProp<HTMLCollectionJsr> forms(){
        return getProp(HTMLCollectionJsr.class, "forms");
    }

    public IJsPropSetter forms(HTMLCollectionJsr v) {
        return setProp("forms", v);
    }

    public IJsPropSetter forms(IValueBinding<? extends HTMLCollectionJsr> v) {
        return setProp("forms", v);
    }

    public JsProp<HTMLCollectionJsr> anchors(){
        return getProp(HTMLCollectionJsr.class, "anchors");
    }

    public IJsPropSetter anchors(HTMLCollectionJsr v) {
        return setProp("anchors", v);
    }

    public IJsPropSetter anchors(IValueBinding<? extends HTMLCollectionJsr> v) {
        return setProp("anchors", v);
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

    public JsProp<String> cookie(){
        return getProp(String.class, "cookie");
    }

    public IJsPropSetter cookie(String v) {
        return setProp("cookie", v);
    }

    public IJsPropSetter cookie(IValueBinding<String> v) {
        return setProp("cookie", v);
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

    public JsProp<SelectionJsr> selection(){
        return getProp(SelectionJsr.class, "selection");
    }

    public IJsPropSetter selection(SelectionJsr v) {
        return setProp("selection", v);
    }

    public IJsPropSetter selection(IValueBinding<? extends SelectionJsr> v) {
        return setProp("selection", v);
    }

    public JsProp<WindowJsr> parentWindow(){
        return getProp(WindowJsr.class, "parentWindow");
    }

    public IJsPropSetter parentWindow(WindowJsr v) {
        return setProp("parentWindow", v);
    }

    public IJsPropSetter parentWindow(IValueBinding<? extends WindowJsr> v) {
        return setProp("parentWindow", v);
    }

    public JsProp<WindowJsr> defaultView(){
        return getProp(WindowJsr.class, "defaultView");
    }

    public IJsPropSetter defaultView(WindowJsr v) {
        return setProp("defaultView", v);
    }

    public IJsPropSetter defaultView(IValueBinding<? extends WindowJsr> v) {
        return setProp("defaultView", v);
    }

    public JsProp<Object> styleSheets(){
        return getProp(Object.class, "styleSheets");
    }

    public IJsPropSetter styleSheets(Object v) {
        return setProp("styleSheets", v);
    }

    public IJsPropSetter styleSheets(IValueBinding<Object> v) {
        return setProp("styleSheets", v);
    }

    public JsProp<String> URLUnencoded(){
        return getProp(String.class, "URLUnencoded");
    }

    public IJsPropSetter URLUnencoded(String v) {
        return setProp("URLUnencoded", v);
    }

    public IJsPropSetter URLUnencoded(IValueBinding<String> v) {
        return setProp("URLUnencoded", v);
    }

    public JsProp<String> readyState(){
        return getProp(String.class, "readyState");
    }

    public IJsPropSetter readyState(String v) {
        return setProp("readyState", v);
    }

    public IJsPropSetter readyState(IValueBinding<String> v) {
        return setProp("readyState", v);
    }

    public JsProp<Object> onkeydown(){
        return getProp(Object.class, "onkeydown");
    }

    public IJsPropSetter onkeydown(Object v) {
        return setProp("onkeydown", v);
    }

    public IJsPropSetter onkeydown(IValueBinding<Object> v) {
        return setProp("onkeydown", v);
    }

    public JsProp<Object> onkeypress(){
        return getProp(Object.class, "onkeypress");
    }

    public IJsPropSetter onkeypress(Object v) {
        return setProp("onkeypress", v);
    }

    public IJsPropSetter onkeypress(IValueBinding<Object> v) {
        return setProp("onkeypress", v);
    }

    public JsProp<Object> onkeyup(){
        return getProp(Object.class, "onkeyup");
    }

    public IJsPropSetter onkeyup(Object v) {
        return setProp("onkeyup", v);
    }

    public IJsPropSetter onkeyup(IValueBinding<Object> v) {
        return setProp("onkeyup", v);
    }

    public JsProp<Object> onclick(){
        return getProp(Object.class, "onclick");
    }

    public IJsPropSetter onclick(Object v) {
        return setProp("onclick", v);
    }

    public IJsPropSetter onclick(IValueBinding<Object> v) {
        return setProp("onclick", v);
    }

    public JsProp<Object> ondblclick(){
        return getProp(Object.class, "ondblclick");
    }

    public IJsPropSetter ondblclick(Object v) {
        return setProp("ondblclick", v);
    }

    public IJsPropSetter ondblclick(IValueBinding<Object> v) {
        return setProp("ondblclick", v);
    }

    public JsProp<Object> onmousedown(){
        return getProp(Object.class, "onmousedown");
    }

    public IJsPropSetter onmousedown(Object v) {
        return setProp("onmousedown", v);
    }

    public IJsPropSetter onmousedown(IValueBinding<Object> v) {
        return setProp("onmousedown", v);
    }

    public JsProp<Object> onmousemove(){
        return getProp(Object.class, "onmousemove");
    }

    public IJsPropSetter onmousemove(Object v) {
        return setProp("onmousemove", v);
    }

    public IJsPropSetter onmousemove(IValueBinding<Object> v) {
        return setProp("onmousemove", v);
    }

    public JsProp<Object> onmouseout(){
        return getProp(Object.class, "onmouseout");
    }

    public IJsPropSetter onmouseout(Object v) {
        return setProp("onmouseout", v);
    }

    public IJsPropSetter onmouseout(IValueBinding<Object> v) {
        return setProp("onmouseout", v);
    }

    public JsProp<Object> onmouseover(){
        return getProp(Object.class, "onmouseover");
    }

    public IJsPropSetter onmouseover(Object v) {
        return setProp("onmouseover", v);
    }

    public IJsPropSetter onmouseover(IValueBinding<Object> v) {
        return setProp("onmouseover", v);
    }

    public JsProp<Object> onmouseup(){
        return getProp(Object.class, "onmouseup");
    }

    public IJsPropSetter onmouseup(Object v) {
        return setProp("onmouseup", v);
    }

    public IJsPropSetter onmouseup(IValueBinding<Object> v) {
        return setProp("onmouseup", v);
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

    public JsProp<String> compatMode(){
        return getProp(String.class, "compatMode");
    }

    public IJsPropSetter compatMode(String v) {
        return setProp("compatMode", v);
    }

    public IJsPropSetter compatMode(IValueBinding<String> v) {
        return setProp("compatMode", v);
    }

    public JsProp<HTMLElementJsr> documentElement(D1... arg){
        return getProp(HTMLElementJsr.class, "documentElement");
    }

    public IJsPropSetter documentElement(HTMLElementJsr v) {
        return setProp("documentElement", v);
    }

    public IJsPropSetter documentElement(IValueBinding<? extends HTMLElementJsr> v,D1... arg) {
        return setProp("documentElement", v);
    }

    public JsFunc<? extends NodeListJsr> all(String id){
        return call(NodeListJsr.class, "all").with(id);
    }

    public JsFunc<? extends NodeListJsr> all(IValueBinding<String> id){
        return call(NodeListJsr.class, "all").with(id);
    }

    public JsFunc<? extends NodeJsr> all(String id, int subIndex){
        return call(NodeJsr.class, "all").with(id, subIndex);
    }

    public JsFunc<? extends NodeJsr> all(IValueBinding<String> id, IValueBinding<Integer> subIndex){
        return call(NodeJsr.class, "all").with(id, subIndex);
    }

    public JsFunc<? extends NodeJsr> all(int index){
        return call(NodeJsr.class, "all").with(index);
    }

    public JsFunc<? extends NodeJsr> all(IValueBinding<Integer> index, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call(NodeJsr.class, "all").with(index);
    }

    /**

 Open a document stream for writing.
 If a document exists in the target, this method clears it. 
 
*/

public JsFunc<Void> open(){
        return call("open");
    }

    /**

 Closes a document stream opened by open() and forces rendering.
 
*/

public JsFunc<Void> close(){
        return call("close");
    }

    /**

 Write a string of text to a document stream opened by open().
 Note that the function will produce a document which is not necessarily
 driven by a DTD and therefore might be produce an invalid result in the
 context of the document.
 @param text
 
*/

public JsFunc<Void> write(Object text){
        return call("write").with(text);
    }

    /**

 Write a string of text followed by a newline character to a document
 stream opened by open(). Note that the function will produce a document
 which is not necessarily driven by a DTD and therefore might be produce
 an invalid result in the context of the document
 @param text
 
*/

public JsFunc<Void> writeln(Object text){
        return call("writeln").with(text);
    }

    /**

 With [HTML 4.01] documents, this method returns the (possibly empty)
 collection of elements whose name value is given by elementName.
 In [XHTML 1.0] documents, this methods only return the (possibly empty) collection
 of form controls with matching name.
 This method is case sensitive.
 @param elementName The name attribute value for an element.
 @return <code>NodeList</code> The matching elements.
 
*/

public JsFunc<? extends NodeListJsr> getElementsByName(String elementName){
        return call(NodeListJsr.class, "getElementsByName").with(elementName);
    }

    /**

 With [HTML 4.01] documents, this method returns the (possibly empty)
 collection of elements whose name value is given by elementName.
 In [XHTML 1.0] documents, this methods only return the (possibly empty) collection
 of form controls with matching name.
 This method is case sensitive.
 @param elementName The name attribute value for an element.
 @return <code>NodeList</code> The matching elements.
 
*/

public JsFunc<? extends NodeListJsr> getElementsByName(IValueBinding<String> elementName){
        return call(NodeListJsr.class, "getElementsByName").with(elementName);
    }

    public JsFunc<Boolean> execCommand(String command, boolean userInterface){
        return call(Boolean.class, "execCommand").with(command, userInterface);
    }

    public JsFunc<Boolean> execCommand(IValueBinding<String> command, IValueBinding<Boolean> userInterface){
        return call(Boolean.class, "execCommand").with(command, userInterface);
    }

    public JsFunc<Boolean> execCommand(String command, boolean userInterface, Object value){
        return call(Boolean.class, "execCommand").with(command, userInterface, value);
    }

    public JsFunc<Boolean> execCommand(IValueBinding<String> command, IValueBinding<Boolean> userInterface, IValueBinding<Object> value){
        return call(Boolean.class, "execCommand").with(command, userInterface, value);
    }

    public JsFunc<Boolean> execCommand(String command){
        return call(Boolean.class, "execCommand").with(command);
    }

    public JsFunc<Boolean> execCommand(IValueBinding<String> command){
        return call(Boolean.class, "execCommand").with(command);
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

    public JsFunc<Void> createStyleSheet(String url){
        return call("createStyleSheet").with(url);
    }

    public JsFunc<Void> createStyleSheet(IValueBinding<String> url){
        return call("createStyleSheet").with(url);
    }

    public JsFunc<Void> createStyleSheet(String url, int index){
        return call("createStyleSheet").with(url, index);
    }

    public JsFunc<Void> createStyleSheet(IValueBinding<String> url, IValueBinding<Integer> index){
        return call("createStyleSheet").with(url, index);
    }

    public JsFunc<Void> createStyleSheet(){
        return call("createStyleSheet");
    }

    public JsFunc<? extends RangeJsr> createRange(){
        return call(RangeJsr.class, "createRange");
    }

    /**

 Creates an element of the type specified. Note that the instance
 returned implements the <code>HtmlElement</code> interface, so attributes
 can be specified directly on the returned object.
 <br>In addition, if there are known attributes with default values,
 <code>Attr</code> nodes representing them are automatically created
 and attached to the element.
 <br>To create an element with a qualified name and namespace URI, use
 the <code>createElementNS</code> method.
 @param tagName The name of the element type to instantiate. For XML,
 this is case-sensitive, otherwise it depends on the
 case-sensitivity of the markup language in use. In that case, the
 name is mapped to the canonical form of that markup by the DOM
 implementation.
 @return A new <code>HtmlElement</code> object with the
 <code>nodeName</code> attribute set to <code>tagName</code>, and
 <code>localName</code>, <code>prefix</code>, and
 <code>namespaceURI</code> set to <code>null</code>.
 @exception DOMExceptionINVALID_CHARACTER_ERR: Raised if the specified name is not an XML
 name according to the XML version in use specified in the
 <code>Document.xmlVersion</code> attribute.
 
*/

public JsFunc<? extends HTMLElementJsr> createElement(String tagName){
        return call(HTMLElementJsr.class, "createElement").with(tagName);
    }

    /**

 Creates an element of the type specified. Note that the instance
 returned implements the <code>HtmlElement</code> interface, so attributes
 can be specified directly on the returned object.
 <br>In addition, if there are known attributes with default values,
 <code>Attr</code> nodes representing them are automatically created
 and attached to the element.
 <br>To create an element with a qualified name and namespace URI, use
 the <code>createElementNS</code> method.
 @param tagName The name of the element type to instantiate. For XML,
 this is case-sensitive, otherwise it depends on the
 case-sensitivity of the markup language in use. In that case, the
 name is mapped to the canonical form of that markup by the DOM
 implementation.
 @return A new <code>HtmlElement</code> object with the
 <code>nodeName</code> attribute set to <code>tagName</code>, and
 <code>localName</code>, <code>prefix</code>, and
 <code>namespaceURI</code> set to <code>null</code>.
 @exception DOMExceptionINVALID_CHARACTER_ERR: Raised if the specified name is not an XML
 name according to the XML version in use specified in the
 <code>Document.xmlVersion</code> attribute.
 
*/

public JsFunc<? extends HTMLElementJsr> createElement(IValueBinding<String> tagName){
        return call(HTMLElementJsr.class, "createElement").with(tagName);
    }

    /**

 Returns the <code>HtmlElement</code> that has an ID attribute with the
 given value. If no such element exists, this returns <code>null</code>
 . If more than one element has an ID attribute with that value, what
 is returned is undefined.
 <br> The DOM implementation is expected to use the attribute
 <code>Attr.isId</code> to determine if an attribute is of type ID.
 <p ><b>Note:</b> Attributes with the name "ID" or "id" are not of type
 ID unless so defined.
 @param elementId The unique <code>id</code> value for an element.
 @return The matching element or <code>null</code> if there is none.
 @since DOM Level 2
 
*/

public JsFunc<? extends HTMLElementJsr> getElementById(String elementId){
        return call(HTMLElementJsr.class, "getElementById").with(elementId);
    }

    /**

 Returns the <code>HtmlElement</code> that has an ID attribute with the
 given value. If no such element exists, this returns <code>null</code>
 . If more than one element has an ID attribute with that value, what
 is returned is undefined.
 <br> The DOM implementation is expected to use the attribute
 <code>Attr.isId</code> to determine if an attribute is of type ID.
 <p ><b>Note:</b> Attributes with the name "ID" or "id" are not of type
 ID unless so defined.
 @param elementId The unique <code>id</code> value for an element.
 @return The matching element or <code>null</code> if there is none.
 @since DOM Level 2
 
*/

public JsFunc<? extends HTMLElementJsr> getElementById(IValueBinding<String> elementId){
        return call(HTMLElementJsr.class, "getElementById").with(elementId);
    }
    
    public static JsTypeRef<HTMLDocumentJsr> prototype = new JsTypeRef<HTMLDocumentJsr>(S);
}