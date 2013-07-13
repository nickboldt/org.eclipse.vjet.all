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
import org.eclipse.vjet.vsf.jsbrowser.jsr.NamedNodeMapJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.UserDataHandlerJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class NodeJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("Node", NodeJsr.class, "Node");

    public NodeJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected NodeJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> nodeName(){
        return getProp(String.class, "nodeName");
    }

    public IJsPropSetter nodeName(String v) {
        return setProp("nodeName", v);
    }

    public IJsPropSetter nodeName(IValueBinding<String> v) {
        return setProp("nodeName", v);
    }

    public JsProp<String> nodeValue(){
        return getProp(String.class, "nodeValue");
    }

    public IJsPropSetter nodeValue(String v) {
        return setProp("nodeValue", v);
    }

    public IJsPropSetter nodeValue(IValueBinding<String> v) {
        return setProp("nodeValue", v);
    }

    public JsProp<Short> nodeType(){
        return getProp(Short.class, "nodeType");
    }

    public IJsPropSetter nodeType(short v) {
        return setProp("nodeType", v);
    }

    public IJsPropSetter nodeType(IValueBinding<Short> v) {
        return setProp("nodeType", v);
    }

    public JsProp<NodeJsr> parentNode(){
        return getProp(NodeJsr.class, "parentNode");
    }

    public IJsPropSetter parentNode(NodeJsr v) {
        return setProp("parentNode", v);
    }

    public IJsPropSetter parentNode(IValueBinding<? extends NodeJsr> v) {
        return setProp("parentNode", v);
    }

    public JsProp<Object> childNodes(){
        return getProp(Object.class, "childNodes");
    }

    public IJsPropSetter childNodes(Object v) {
        return setProp("childNodes", v);
    }

    public IJsPropSetter childNodes(IValueBinding<Object> v) {
        return setProp("childNodes", v);
    }

    public JsProp<NodeJsr> firstChild(){
        return getProp(NodeJsr.class, "firstChild");
    }

    public IJsPropSetter firstChild(NodeJsr v) {
        return setProp("firstChild", v);
    }

    public IJsPropSetter firstChild(IValueBinding<? extends NodeJsr> v) {
        return setProp("firstChild", v);
    }

    public JsProp<NodeJsr> lastChild(){
        return getProp(NodeJsr.class, "lastChild");
    }

    public IJsPropSetter lastChild(NodeJsr v) {
        return setProp("lastChild", v);
    }

    public IJsPropSetter lastChild(IValueBinding<? extends NodeJsr> v) {
        return setProp("lastChild", v);
    }

    public JsProp<NodeJsr> previousSibling(){
        return getProp(NodeJsr.class, "previousSibling");
    }

    public IJsPropSetter previousSibling(NodeJsr v) {
        return setProp("previousSibling", v);
    }

    public IJsPropSetter previousSibling(IValueBinding<? extends NodeJsr> v) {
        return setProp("previousSibling", v);
    }

    public JsProp<NodeJsr> nextSibling(){
        return getProp(NodeJsr.class, "nextSibling");
    }

    public IJsPropSetter nextSibling(NodeJsr v) {
        return setProp("nextSibling", v);
    }

    public IJsPropSetter nextSibling(IValueBinding<? extends NodeJsr> v) {
        return setProp("nextSibling", v);
    }

    public JsProp<NamedNodeMapJsr> attributes(){
        return getProp(NamedNodeMapJsr.class, "attributes");
    }

    public IJsPropSetter attributes(NamedNodeMapJsr v) {
        return setProp("attributes", v);
    }

    public IJsPropSetter attributes(IValueBinding<? extends NamedNodeMapJsr> v) {
        return setProp("attributes", v);
    }

    public JsProp<DocumentJsr> ownerDocument(){
        return getProp(DocumentJsr.class, "ownerDocument");
    }

    public IJsPropSetter ownerDocument(DocumentJsr v) {
        return setProp("ownerDocument", v);
    }

    public IJsPropSetter ownerDocument(IValueBinding<? extends DocumentJsr> v) {
        return setProp("ownerDocument", v);
    }

    public JsProp<String> baseURI(){
        return getProp(String.class, "baseURI");
    }

    public IJsPropSetter baseURI(String v) {
        return setProp("baseURI", v);
    }

    public IJsPropSetter baseURI(IValueBinding<String> v) {
        return setProp("baseURI", v);
    }

    public JsProp<String> textContent(){
        return getProp(String.class, "textContent");
    }

    public IJsPropSetter textContent(String v) {
        return setProp("textContent", v);
    }

    public IJsPropSetter textContent(IValueBinding<String> v) {
        return setProp("textContent", v);
    }

    public JsProp<String> innerText(){
        return getProp(String.class, "innerText");
    }

    public IJsPropSetter innerText(String v) {
        return setProp("innerText", v);
    }

    public IJsPropSetter innerText(IValueBinding<String> v) {
        return setProp("innerText", v);
    }

    /**

 Inserts the node <code>newChild</code> before the existing child node
 <code>refChild</code>. If <code>refChild</code> is <code>null</code>,
 insert <code>newChild</code> at the end of the list of children.
 <br>If <code>newChild</code> is a <code>DocumentFragment</code> object,
 all of its children are inserted, in the same order, before
 <code>refChild</code>. If the <code>newChild</code> is already in the
 tree, it is first removed.
 <p ><b>Note:</b>  Inserting a node before itself is implementation
 dependent.
 @param newChild The node to insert.
 @param refChild The reference node, i.e., the node before which the
 new node must be inserted.
 @exception DOMExceptionHIERARCHY_REQUEST_ERR: Raised if this node is of a type that does not
 allow children of the type of the <code>newChild</code> node, or if
 the node to insert is one of this node's ancestors or this node
 itself, or if this node is of type <code>Document</code> and the
 DOM application attempts to insert a second
 <code>DocumentType</code> or <code>Element</code> node.
 <br>WRONG_DOCUMENT_ERR: Raised if <code>newChild</code> was created
 from a different document than the one that created this node.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly or
 if the parent of the node being inserted is readonly.
 <br>NOT_FOUND_ERR: Raised if <code>refChild</code> is not a child of
 this node.
 <br>NOT_SUPPORTED_ERR: if this node is of type <code>Document</code>,
 this exception might be raised if the DOM implementation doesn't
 support the insertion of a <code>DocumentType</code> or
 <code>Element</code> node.
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeJsr> insertBefore(NodeJsr newChild, NodeJsr refChild){
        return call(NodeJsr.class, "insertBefore").with(newChild, refChild);
    }

    /**

 Inserts the node <code>newChild</code> before the existing child node
 <code>refChild</code>. If <code>refChild</code> is <code>null</code>,
 insert <code>newChild</code> at the end of the list of children.
 <br>If <code>newChild</code> is a <code>DocumentFragment</code> object,
 all of its children are inserted, in the same order, before
 <code>refChild</code>. If the <code>newChild</code> is already in the
 tree, it is first removed.
 <p ><b>Note:</b>  Inserting a node before itself is implementation
 dependent.
 @param newChild The node to insert.
 @param refChild The reference node, i.e., the node before which the
 new node must be inserted.
 @exception DOMExceptionHIERARCHY_REQUEST_ERR: Raised if this node is of a type that does not
 allow children of the type of the <code>newChild</code> node, or if
 the node to insert is one of this node's ancestors or this node
 itself, or if this node is of type <code>Document</code> and the
 DOM application attempts to insert a second
 <code>DocumentType</code> or <code>Element</code> node.
 <br>WRONG_DOCUMENT_ERR: Raised if <code>newChild</code> was created
 from a different document than the one that created this node.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly or
 if the parent of the node being inserted is readonly.
 <br>NOT_FOUND_ERR: Raised if <code>refChild</code> is not a child of
 this node.
 <br>NOT_SUPPORTED_ERR: if this node is of type <code>Document</code>,
 this exception might be raised if the DOM implementation doesn't
 support the insertion of a <code>DocumentType</code> or
 <code>Element</code> node.
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeJsr> insertBefore(IValueBinding<? extends NodeJsr> newChild, IValueBinding<? extends NodeJsr> refChild){
        return call(NodeJsr.class, "insertBefore").with(newChild, refChild);
    }

    /**

 Replaces the child node <code>oldChild</code> with <code>newChild</code>
 in the list of children, and returns the <code>oldChild</code> node.
 <br>If <code>newChild</code> is a <code>DocumentFragment</code> object,
 <code>oldChild</code> is replaced by all of the
 <code>DocumentFragment</code> children, which are inserted in the
 same order. If the <code>newChild</code> is already in the tree, it
 is first removed.
 <p ><b>Note:</b>  Replacing a node with itself is implementation
 dependent.
 @param newChild The new node to put in the child list.
 @param oldChild The node being replaced in the list.
 @exception DOMExceptionHIERARCHY_REQUEST_ERR: Raised if this node is of a type that does not
 allow children of the type of the <code>newChild</code> node, or if
 the node to put in is one of this node's ancestors or this node
 itself, or if this node is of type <code>Document</code> and the
 result of the replacement operation would add a second
 <code>DocumentType</code> or <code>Element</code> on the
 <code>Document</code> node.
 <br>WRONG_DOCUMENT_ERR: Raised if <code>newChild</code> was created
 from a different document than the one that created this node.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node or the parent of
 the new node is readonly.
 <br>NOT_FOUND_ERR: Raised if <code>oldChild</code> is not a child of
 this node.
 <br>NOT_SUPPORTED_ERR: if this node is of type <code>Document</code>,
 this exception might be raised if the DOM implementation doesn't
 support the replacement of the <code>DocumentType</code> child or
 <code>Element</code> child.
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeJsr> replaceChild(NodeJsr newChild, NodeJsr oldChild){
        return call(NodeJsr.class, "replaceChild").with(newChild, oldChild);
    }

    /**

 Replaces the child node <code>oldChild</code> with <code>newChild</code>
 in the list of children, and returns the <code>oldChild</code> node.
 <br>If <code>newChild</code> is a <code>DocumentFragment</code> object,
 <code>oldChild</code> is replaced by all of the
 <code>DocumentFragment</code> children, which are inserted in the
 same order. If the <code>newChild</code> is already in the tree, it
 is first removed.
 <p ><b>Note:</b>  Replacing a node with itself is implementation
 dependent.
 @param newChild The new node to put in the child list.
 @param oldChild The node being replaced in the list.
 @exception DOMExceptionHIERARCHY_REQUEST_ERR: Raised if this node is of a type that does not
 allow children of the type of the <code>newChild</code> node, or if
 the node to put in is one of this node's ancestors or this node
 itself, or if this node is of type <code>Document</code> and the
 result of the replacement operation would add a second
 <code>DocumentType</code> or <code>Element</code> on the
 <code>Document</code> node.
 <br>WRONG_DOCUMENT_ERR: Raised if <code>newChild</code> was created
 from a different document than the one that created this node.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node or the parent of
 the new node is readonly.
 <br>NOT_FOUND_ERR: Raised if <code>oldChild</code> is not a child of
 this node.
 <br>NOT_SUPPORTED_ERR: if this node is of type <code>Document</code>,
 this exception might be raised if the DOM implementation doesn't
 support the replacement of the <code>DocumentType</code> child or
 <code>Element</code> child.
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeJsr> replaceChild(IValueBinding<? extends NodeJsr> newChild, IValueBinding<? extends NodeJsr> oldChild){
        return call(NodeJsr.class, "replaceChild").with(newChild, oldChild);
    }

    /**

 Removes the child node indicated by <code>oldChild</code> from the list
 of children, and returns it.
 @param oldChild The node being removed.
 @exception DOMExceptionNO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 <br>NOT_FOUND_ERR: Raised if <code>oldChild</code> is not a child of
 this node.
 <br>NOT_SUPPORTED_ERR: if this node is of type <code>Document</code>,
 this exception might be raised if the DOM implementation doesn't
 support the removal of the <code>DocumentType</code> child or the
 <code>Element</code> child.
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeJsr> removeChild(NodeJsr oldChild){
        return call(NodeJsr.class, "removeChild").with(oldChild);
    }

    /**

 Removes the child node indicated by <code>oldChild</code> from the list
 of children, and returns it.
 @param oldChild The node being removed.
 @exception DOMExceptionNO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 <br>NOT_FOUND_ERR: Raised if <code>oldChild</code> is not a child of
 this node.
 <br>NOT_SUPPORTED_ERR: if this node is of type <code>Document</code>,
 this exception might be raised if the DOM implementation doesn't
 support the removal of the <code>DocumentType</code> child or the
 <code>Element</code> child.
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeJsr> removeChild(IValueBinding<? extends NodeJsr> oldChild){
        return call(NodeJsr.class, "removeChild").with(oldChild);
    }

    /**

 Adds the node <code>newChild</code> to the end of the list of children
 of this node. If the <code>newChild</code> is already in the tree, it
 is first removed.  The newChild must not be null and if it has an
 owning document, it must be the same (==) document as the parent of
 this node else an exception is thrown.
 @param newChild The node to add.If it is a
 <code>DocumentFragment</code> object, the entire contents of the
 document fragment are moved into the child list of this node
 @exception DOMExceptionHIERARCHY_REQUEST_ERR: Raised if this node is of a type that does not
 allow children of the type of the <code>newChild</code> node, or if
 the node to append is one of this node's ancestors or this node
 itself, or if this node is of type <code>Document</code> and the
 DOM application attempts to append a second
 <code>DocumentType</code> or <code>Element</code> node.
 <br>WRONG_DOCUMENT_ERR: Raised if <code>newChild</code> was created
 from a different document than the one that created this node.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly or
 if the previous parent of the node being inserted is readonly.
 <br>NOT_SUPPORTED_ERR: if the <code>newChild</code> node is a child
 of the <code>Document</code> node, this exception might be raised
 if the DOM implementation doesn't support the removal of the
 <code>DocumentType</code> child or <code>Element</code> child.
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeJsr> appendChild(NodeJsr newChild){
        return call(NodeJsr.class, "appendChild").with(newChild);
    }

    /**

 Adds the node <code>newChild</code> to the end of the list of children
 of this node. If the <code>newChild</code> is already in the tree, it
 is first removed.  The newChild must not be null and if it has an
 owning document, it must be the same (==) document as the parent of
 this node else an exception is thrown.
 @param newChild The node to add.If it is a
 <code>DocumentFragment</code> object, the entire contents of the
 document fragment are moved into the child list of this node
 @exception DOMExceptionHIERARCHY_REQUEST_ERR: Raised if this node is of a type that does not
 allow children of the type of the <code>newChild</code> node, or if
 the node to append is one of this node's ancestors or this node
 itself, or if this node is of type <code>Document</code> and the
 DOM application attempts to append a second
 <code>DocumentType</code> or <code>Element</code> node.
 <br>WRONG_DOCUMENT_ERR: Raised if <code>newChild</code> was created
 from a different document than the one that created this node.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly or
 if the previous parent of the node being inserted is readonly.
 <br>NOT_SUPPORTED_ERR: if the <code>newChild</code> node is a child
 of the <code>Document</code> node, this exception might be raised
 if the DOM implementation doesn't support the removal of the
 <code>DocumentType</code> child or <code>Element</code> child.
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeJsr> appendChild(IValueBinding<? extends NodeJsr> newChild){
        return call(NodeJsr.class, "appendChild").with(newChild);
    }

    /**

 Returns whether this node has any children.
 @return Returns <code>true</code> if this node has any children,
 <code>false</code> otherwise.
 
*/

public JsFunc<Boolean> hasChildNodes(){
        return call(Boolean.class, "hasChildNodes");
    }

    public JsFunc<? extends NodeJsr> cloneNode(){
        return call(NodeJsr.class, "cloneNode");
    }

    public JsFunc<? extends NodeJsr> cloneNode(boolean deep){
        return call(NodeJsr.class, "cloneNode").with(deep);
    }

    public JsFunc<? extends NodeJsr> cloneNode(IValueBinding<Boolean> deep){
        return call(NodeJsr.class, "cloneNode").with(deep);
    }

    /**

 Returns whether this node (if it is an element) has any attributes.
 @return Returns <code>true</code> if this node has any attributes,
 <code>false</code> otherwise.
 @since DOM Level 2
 
*/

public JsFunc<Boolean> hasAttributes(){
        return call(Boolean.class, "hasAttributes");
    }

    /**

 The namespace URI of this node, or null if it is unspecified. When this
 node is of any type other than ELEMENT_NODE and ATTRIBUTE_NODE, this is
 always null and setting it has no effect. <p>
 This is not a computed value that is the result of a namespace lookup
 based on an examination of the namespace declarations in scope. It is
 merely the namespace URI given at creation time.<p>
 For nodes created with a DOM Level 1 method, such as createElement
 from the Document interface, this is null.
 @since DOM Level 2
 
*/

public JsFunc<String> getNamespaceURI(){
        return call(String.class, "getNamespaceURI");
    }

    /**

 Returns the local part of the qualified name of this node.
 For nodes created with a DOM Level 1 method, such as createElement
 from the Document interface, and for nodes of any type other than
 ELEMENT_NODE and ATTRIBUTE_NODE this is the same as the nodeName
 attribute.
 @since DOM Level 2
 
*/

public JsFunc<String> getLocalName(){
        return call(String.class, "getLocalName");
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

    /**

 Puts all <code>Text</code> nodes in the full depth of the sub-tree
 underneath this <code>Node</code>, including attribute nodes, into a
 "normal" form where only structure (e.g., elements, comments,
 processing instructions, CDATA sections, and entity references)
 separates <code>Text</code> nodes, i.e., there are neither adjacent
 <code>Text</code> nodes nor empty <code>Text</code> nodes. This can
 be used to ensure that the DOM view of a document is the same as if
 it were saved and re-loaded, and is useful when operations (such as
 XPointer [<a href='http://www.w3.org/TR/2003/REC-xptr-framework-20030325/'>XPointer</a>]
 lookups) that depend on a particular document tree structure are to
 be used. If the parameter "normalize-characters" of the
 <code>DOMConfiguration</code> object attached to the
 <code>Node.ownerDocument</code> is <code>true</code>, this method
 will also fully normalize the characters of the <code>Text</code>
 nodes.
 <p ><b>Note:</b> In cases where the document contains
 <code>CDATASections</code>, the normalize operation alone may not be
 sufficient, since XPointers do not differentiate between
 <code>Text</code> nodes and <code>CDATASection</code> nodes.
 @since DOM Level 2
 
*/

public JsFunc<Void> normalize(){
        return call("normalize");
    }

    /**

 Tests whether the DOM implementation implements a specific feature and
 that feature is supported by this node, as specified in .
 @param feature  The name of the feature to test.
 @param version  This is the version number of the feature to test.
 @return Returns <code>true</code> if the specified feature is
 supported on this node, <code>false</code> otherwise.
 @since DOM Level 2
 
*/

public JsFunc<Boolean> isSupported(String feature, String version){
        return call(Boolean.class, "isSupported").with(feature, version);
    }

    /**

 Tests whether the DOM implementation implements a specific feature and
 that feature is supported by this node, as specified in .
 @param feature  The name of the feature to test.
 @param version  This is the version number of the feature to test.
 @return Returns <code>true</code> if the specified feature is
 supported on this node, <code>false</code> otherwise.
 @since DOM Level 2
 
*/

public JsFunc<Boolean> isSupported(IValueBinding<String> feature, IValueBinding<String> version){
        return call(Boolean.class, "isSupported").with(feature, version);
    }

    /**

 The namespace prefix of this node, or <code>null</code> if it is
 unspecified. When it is defined to be <code>null</code>, setting it
 has no effect, including if the node is read-only.
 <br>Note that setting this attribute, when permitted, changes the
 <code>nodeName</code> attribute, which holds the qualified name, as
 well as the <code>tagName</code> and <code>name</code> attributes of
 the <code>Element</code> and <code>Attr</code> interfaces, when
 applicable.
 <br>Setting the prefix to <code>null</code> makes it unspecified,
 setting it to an empty string is implementation dependent.
 <br>Note also that changing the prefix of an attribute that is known to
 have a default value, does not make a new attribute with the default
 value and the original prefix appear, since the
 <code>namespaceURI</code> and <code>localName</code> do not change.
 <br>For nodes of any type other than <code>ELEMENT_NODE</code>
 and <code>ATTRIBUTE_NODE</code> and nodes created with a DOM Level 1
 method, such as <code>createElement</code> from the
 <code>Document</code> interface, this is always <code>null</code>.
 http://java.sun.com/j2se/1.4.2/docs/api/org/w3c/dom/Node.html#getPrefix()
 @since DOM Level 2
 
*/

public JsFunc<String> getPrefix(){
        return call(String.class, "getPrefix");
    }

    /**

 The namespace prefix of this node, or <code>null</code> if it is
 unspecified. When it is defined to be <code>null</code>, setting it
 has no effect, including if the node is read-only.
 <br>Note that setting this attribute, when permitted, changes the
 <code>nodeName</code> attribute, which holds the qualified name, as
 well as the <code>tagName</code> and <code>name</code> attributes of
 the <code>Element</code> and <code>Attr</code> interfaces, when
 applicable.
 <br>Setting the prefix to <code>null</code> makes it unspecified,
 setting it to an empty string is implementation dependent.
 <br>Note also that changing the prefix of an attribute that is known to
 have a default value, does not make a new attribute with the default
 value and the original prefix appear, since the
 <code>namespaceURI</code> and <code>localName</code> do not change.
 <br>For nodes of any type other than <code>ELEMENT_NODE</code> and
 <code>ATTRIBUTE_NODE</code> and nodes created with a DOM Level 1
 method, such as <code>createElement</code> from the
 <code>Document</code> interface, this is always <code>null</code>.
 @exception DOMExceptionINVALID_CHARACTER_ERR: Raised if the specified prefix contains an
 illegal character according to the XML version in use specified in
 the <code>Document.xmlVersion</code> attribute.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 <br>NAMESPACE_ERR: Raised if the specified <code>prefix</code> is
 malformed per the Namespaces in XML specification, if the
 <code>namespaceURI</code> of this node is <code>null</code>, if the
 specified prefix is "xml" and the <code>namespaceURI</code> of this
 node is different from "<a href='http://www.w3.org/XML/1998/namespace'>
 http://www.w3.org/XML/1998/namespace</a>", if this node is an attribute and the specified prefix is "xmlns" and
 the <code>namespaceURI</code> of this node is different from "<a href='http://www.w3.org/2000/xmlns/'>http://www.w3.org/2000/xmlns/</a>", or if this node is an attribute and the <code>qualifiedName</code> of
 this node is "xmlns" [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>]
 .
 http://java.sun.com/j2se/1.4.2/docs/api/org/w3c/dom/Node.html#setPrefix(java.lang.String)
 @since DOM Level 2
 
*/

public JsFunc<Void> setPrefix(String prefix){
        return call("setPrefix").with(prefix);
    }

    /**

 The namespace prefix of this node, or <code>null</code> if it is
 unspecified. When it is defined to be <code>null</code>, setting it
 has no effect, including if the node is read-only.
 <br>Note that setting this attribute, when permitted, changes the
 <code>nodeName</code> attribute, which holds the qualified name, as
 well as the <code>tagName</code> and <code>name</code> attributes of
 the <code>Element</code> and <code>Attr</code> interfaces, when
 applicable.
 <br>Setting the prefix to <code>null</code> makes it unspecified,
 setting it to an empty string is implementation dependent.
 <br>Note also that changing the prefix of an attribute that is known to
 have a default value, does not make a new attribute with the default
 value and the original prefix appear, since the
 <code>namespaceURI</code> and <code>localName</code> do not change.
 <br>For nodes of any type other than <code>ELEMENT_NODE</code> and
 <code>ATTRIBUTE_NODE</code> and nodes created with a DOM Level 1
 method, such as <code>createElement</code> from the
 <code>Document</code> interface, this is always <code>null</code>.
 @exception DOMExceptionINVALID_CHARACTER_ERR: Raised if the specified prefix contains an
 illegal character according to the XML version in use specified in
 the <code>Document.xmlVersion</code> attribute.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 <br>NAMESPACE_ERR: Raised if the specified <code>prefix</code> is
 malformed per the Namespaces in XML specification, if the
 <code>namespaceURI</code> of this node is <code>null</code>, if the
 specified prefix is "xml" and the <code>namespaceURI</code> of this
 node is different from "<a href='http://www.w3.org/XML/1998/namespace'>
 http://www.w3.org/XML/1998/namespace</a>", if this node is an attribute and the specified prefix is "xmlns" and
 the <code>namespaceURI</code> of this node is different from "<a href='http://www.w3.org/2000/xmlns/'>http://www.w3.org/2000/xmlns/</a>", or if this node is an attribute and the <code>qualifiedName</code> of
 this node is "xmlns" [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>]
 .
 http://java.sun.com/j2se/1.4.2/docs/api/org/w3c/dom/Node.html#setPrefix(java.lang.String)
 @since DOM Level 2
 
*/

public JsFunc<Void> setPrefix(IValueBinding<String> prefix){
        return call("setPrefix").with(prefix);
    }

    /**

 Compares the reference node, i.e. the node on which this method is
 being called, with a node, i.e. the one passed as a parameter, with
 regard to their position in the document and according to the
 document order.
 @param other The node to compare against the reference node.
 @return Returns how the node is positioned relatively to the reference
 node.
 @exception DOMExceptionNOT_SUPPORTED_ERR: when the compared nodes are from different DOM
 implementations that do not coordinate to return consistent
 implementation-specific results.
 @since DOM Level 3
 
*/

public JsFunc<Short> compareDocumentPosition(NodeJsr other){
        return call(Short.class, "compareDocumentPosition").with(other);
    }

    /**

 Compares the reference node, i.e. the node on which this method is
 being called, with a node, i.e. the one passed as a parameter, with
 regard to their position in the document and according to the
 document order.
 @param other The node to compare against the reference node.
 @return Returns how the node is positioned relatively to the reference
 node.
 @exception DOMExceptionNOT_SUPPORTED_ERR: when the compared nodes are from different DOM
 implementations that do not coordinate to return consistent
 implementation-specific results.
 @since DOM Level 3
 
*/

public JsFunc<Short> compareDocumentPosition(IValueBinding<? extends NodeJsr> other){
        return call(Short.class, "compareDocumentPosition").with(other);
    }

    /**

 Returns whether this node is the same node as the given one.
 <br>This method provides a way to determine whether two
 <code>Node</code> references returned by the implementation reference
 the same object. When two <code>Node</code> references are references
 to the same object, even if through a proxy, the references may be
 used completely interchangeably, such that all attributes have the
 same values and calling the same DOM method on either reference
 always has exactly the same effect.
 @param other The node to test against.
 @return Returns <code>true</code> if the nodes are the same,
 <code>false</code> otherwise.
 @since DOM Level 3
 
*/

public JsFunc<Boolean> isSameNode(NodeJsr other){
        return call(Boolean.class, "isSameNode").with(other);
    }

    /**

 Returns whether this node is the same node as the given one.
 <br>This method provides a way to determine whether two
 <code>Node</code> references returned by the implementation reference
 the same object. When two <code>Node</code> references are references
 to the same object, even if through a proxy, the references may be
 used completely interchangeably, such that all attributes have the
 same values and calling the same DOM method on either reference
 always has exactly the same effect.
 @param other The node to test against.
 @return Returns <code>true</code> if the nodes are the same,
 <code>false</code> otherwise.
 @since DOM Level 3
 
*/

public JsFunc<Boolean> isSameNode(IValueBinding<? extends NodeJsr> other){
        return call(Boolean.class, "isSameNode").with(other);
    }

    /**

 Look up the prefix associated to the given namespace URI, starting from
 this node. The default namespace declarations are ignored by this
 method.
 <br>See  for details on the algorithm used by this method.
 @param namespaceURI The namespace URI to look for.
 @return Returns an associated namespace prefix if found or
 <code>null</code> if none is found. If more than one prefix are
 associated to the namespace prefix, the returned namespace prefix
 is implementation dependent.
 @since DOM Level 3
 
*/

public JsFunc<String> lookupPrefix(String namespaceURI){
        return call(String.class, "lookupPrefix").with(namespaceURI);
    }

    /**

 Look up the prefix associated to the given namespace URI, starting from
 this node. The default namespace declarations are ignored by this
 method.
 <br>See  for details on the algorithm used by this method.
 @param namespaceURI The namespace URI to look for.
 @return Returns an associated namespace prefix if found or
 <code>null</code> if none is found. If more than one prefix are
 associated to the namespace prefix, the returned namespace prefix
 is implementation dependent.
 @since DOM Level 3
 
*/

public JsFunc<String> lookupPrefix(IValueBinding<String> namespaceURI){
        return call(String.class, "lookupPrefix").with(namespaceURI);
    }

    /**

 This method checks if the specified <code>namespaceURI</code> is the
 default namespace or not.
 @param namespaceURI The namespace URI to look for.
 @return Returns <code>true</code> if the specified
 <code>namespaceURI</code> is the default namespace,
 <code>false</code> otherwise.
 @since DOM Level 3
 
*/

public JsFunc<Boolean> isDefaultNamespace(String namespaceURI){
        return call(Boolean.class, "isDefaultNamespace").with(namespaceURI);
    }

    /**

 This method checks if the specified <code>namespaceURI</code> is the
 default namespace or not.
 @param namespaceURI The namespace URI to look for.
 @return Returns <code>true</code> if the specified
 <code>namespaceURI</code> is the default namespace,
 <code>false</code> otherwise.
 @since DOM Level 3
 
*/

public JsFunc<Boolean> isDefaultNamespace(IValueBinding<String> namespaceURI){
        return call(Boolean.class, "isDefaultNamespace").with(namespaceURI);
    }

    /**

 Look up the namespace URI associated to the given prefix, starting from
 this node.
 <br>See  for details on the algorithm used by this method.
 @param prefix The prefix to look for. If this parameter is
 <code>null</code>, the method will return the default namespace URI
 if any.
 @return Returns the associated namespace URI or <code>null</code> if
 none is found.
 @since DOM Level 3
 
*/

public JsFunc<String> lookupNamespaceURI(String specifiedPrefix){
        return call(String.class, "lookupNamespaceURI").with(specifiedPrefix);
    }

    /**

 Look up the namespace URI associated to the given prefix, starting from
 this node.
 <br>See  for details on the algorithm used by this method.
 @param prefix The prefix to look for. If this parameter is
 <code>null</code>, the method will return the default namespace URI
 if any.
 @return Returns the associated namespace URI or <code>null</code> if
 none is found.
 @since DOM Level 3
 
*/

public JsFunc<String> lookupNamespaceURI(IValueBinding<String> specifiedPrefix){
        return call(String.class, "lookupNamespaceURI").with(specifiedPrefix);
    }

    /**

 Tests whether two nodes are equal.
 <br>This method tests for equality of nodes, not sameness (i.e.,
 whether the two nodes are references to the same object) which can be
 tested with <code>Node.isSameNode()</code>. All nodes that are the
 same will also be equal, though the reverse may not be true.
 <br>Two nodes are equal if and only if the following conditions are
 satisfied:
 <ul>
 <li>The two nodes are of the same type.
 </li>
 <li>The following string
 attributes are equal: <code>nodeName</code>, <code>localName</code>,
 <code>namespaceURI</code>, <code>prefix</code>, <code>nodeValue</code>
 . This is: they are both <code>null</code>, or they have the same
 length and are character for character identical.
 </li>
 <li>The
 <code>attributes</code> <code>NamedNodeMaps</code> are equal. This
 is: they are both <code>null</code>, or they have the same length and
 for each node that exists in one map there is a node that exists in
 the other map and is equal, although not necessarily at the same
 index.
 </li>
 <li>The <code>childNodes</code> <code>NodeLists</code> are equal.
 This is: they are both <code>null</code>, or they have the same
 length and contain equal nodes at the same index. Note that
 normalization can affect equality; to avoid this, nodes should be
 normalized before being compared.
 </li>
 </ul>
 <br>For two <code>DocumentType</code> nodes to be equal, the following
 conditions must also be satisfied:
 <ul>
 <li>The following string attributes
 are equal: <code>publicId</code>, <code>systemId</code>,
 <code>internalSubset</code>.
 </li>
 <li>The <code>entities</code>
 <code>NamedNodeMaps</code> are equal.
 </li>
 <li>The <code>notations</code>
 <code>NamedNodeMaps</code> are equal.
 </li>
 </ul>
 <br>On the other hand, the following do not affect equality: the
 <code>ownerDocument</code>, <code>baseURI</code>, and
 <code>parentNode</code> attributes, the <code>specified</code>
 attribute for <code>Attr</code> nodes, the <code>schemaTypeInfo</code>
 attribute for <code>Attr</code> and <code>Element</code> nodes, the
 <code>Text.isElementContentWhitespace</code> attribute for
 <code>Text</code> nodes, as well as any user data or event listeners
 registered on the nodes.
 <p ><b>Note:</b>  As a general rule, anything not mentioned in the
 description above is not significant in consideration of equality
 checking. Note that future versions of this specification may take
 into account more attributes and implementations conform to this
 specification are expected to be updated accordingly.
 @param arg The node to compare equality with.
 @return Returns <code>true</code> if the nodes are equal,
 <code>false</code> otherwise.
 @since DOM Level 3
 
*/

public JsFunc<Boolean> isEqualNode(NodeJsr arg){
        return call(Boolean.class, "isEqualNode").with(arg);
    }

    /**

 Tests whether two nodes are equal.
 <br>This method tests for equality of nodes, not sameness (i.e.,
 whether the two nodes are references to the same object) which can be
 tested with <code>Node.isSameNode()</code>. All nodes that are the
 same will also be equal, though the reverse may not be true.
 <br>Two nodes are equal if and only if the following conditions are
 satisfied:
 <ul>
 <li>The two nodes are of the same type.
 </li>
 <li>The following string
 attributes are equal: <code>nodeName</code>, <code>localName</code>,
 <code>namespaceURI</code>, <code>prefix</code>, <code>nodeValue</code>
 . This is: they are both <code>null</code>, or they have the same
 length and are character for character identical.
 </li>
 <li>The
 <code>attributes</code> <code>NamedNodeMaps</code> are equal. This
 is: they are both <code>null</code>, or they have the same length and
 for each node that exists in one map there is a node that exists in
 the other map and is equal, although not necessarily at the same
 index.
 </li>
 <li>The <code>childNodes</code> <code>NodeLists</code> are equal.
 This is: they are both <code>null</code>, or they have the same
 length and contain equal nodes at the same index. Note that
 normalization can affect equality; to avoid this, nodes should be
 normalized before being compared.
 </li>
 </ul>
 <br>For two <code>DocumentType</code> nodes to be equal, the following
 conditions must also be satisfied:
 <ul>
 <li>The following string attributes
 are equal: <code>publicId</code>, <code>systemId</code>,
 <code>internalSubset</code>.
 </li>
 <li>The <code>entities</code>
 <code>NamedNodeMaps</code> are equal.
 </li>
 <li>The <code>notations</code>
 <code>NamedNodeMaps</code> are equal.
 </li>
 </ul>
 <br>On the other hand, the following do not affect equality: the
 <code>ownerDocument</code>, <code>baseURI</code>, and
 <code>parentNode</code> attributes, the <code>specified</code>
 attribute for <code>Attr</code> nodes, the <code>schemaTypeInfo</code>
 attribute for <code>Attr</code> and <code>Element</code> nodes, the
 <code>Text.isElementContentWhitespace</code> attribute for
 <code>Text</code> nodes, as well as any user data or event listeners
 registered on the nodes.
 <p ><b>Note:</b>  As a general rule, anything not mentioned in the
 description above is not significant in consideration of equality
 checking. Note that future versions of this specification may take
 into account more attributes and implementations conform to this
 specification are expected to be updated accordingly.
 @param arg The node to compare equality with.
 @return Returns <code>true</code> if the nodes are equal,
 <code>false</code> otherwise.
 @since DOM Level 3
 
*/

public JsFunc<Boolean> isEqualNode(IValueBinding<? extends NodeJsr> arg){
        return call(Boolean.class, "isEqualNode").with(arg);
    }

    /**

 This method returns a specialized object which implements the
 specialized APIs of the specified feature and version, as specified
 in . The specialized object may also be obtained by using
 binding-specific casting methods but is not necessarily expected to,
 as discussed in . This method also allow the implementation to
 provide specialized objects which do not support the <code>Node</code>
 interface.
 @param feature  The name of the feature requested. Note that any plus
 sign "+" prepended to the name of the feature will be ignored since
 it is not significant in the context of this method.
 @param version  This is the version number of the feature to test.
 @return  Returns an object which implements the specialized APIs of
 the specified feature and version, if any, or <code>null</code> if
 there is no object which implements interfaces associated with that
 feature. If the <code>DOMObject</code> returned by this method
 implements the <code>Node</code> interface, it must delegate to the
 primary core <code>Node</code> and not return results inconsistent
 with the primary core <code>Node</code> such as attributes,
 childNodes, etc.
 @since DOM Level 3
 
*/

public JsFunc<Object> getFeature(String feature, String version){
        return call(Object.class, "getFeature").with(feature, version);
    }

    /**

 This method returns a specialized object which implements the
 specialized APIs of the specified feature and version, as specified
 in . The specialized object may also be obtained by using
 binding-specific casting methods but is not necessarily expected to,
 as discussed in . This method also allow the implementation to
 provide specialized objects which do not support the <code>Node</code>
 interface.
 @param feature  The name of the feature requested. Note that any plus
 sign "+" prepended to the name of the feature will be ignored since
 it is not significant in the context of this method.
 @param version  This is the version number of the feature to test.
 @return  Returns an object which implements the specialized APIs of
 the specified feature and version, if any, or <code>null</code> if
 there is no object which implements interfaces associated with that
 feature. If the <code>DOMObject</code> returned by this method
 implements the <code>Node</code> interface, it must delegate to the
 primary core <code>Node</code> and not return results inconsistent
 with the primary core <code>Node</code> such as attributes,
 childNodes, etc.
 @since DOM Level 3
 
*/

public JsFunc<Object> getFeature(IValueBinding<String> feature, IValueBinding<String> version){
        return call(Object.class, "getFeature").with(feature, version);
    }

    /**

 Associate an object to a key on this node. The object can later be
 retrieved from this node by calling <code>getUserData</code> with the
 same key.
 @param key The key to associate the object to.
 @param data The object to associate to the given key, or
 <code>null</code> to remove any existing association to that key.
 @param handler The handler to associate to that key, or
 <code>null</code>.
 @return Returns the <code>DOMUserData</code> previously associated to
 the given key on this node, or <code>null</code> if there was none.
 @since DOM Level 3
 
*/

public JsFunc<Object> setUserData(String key, Object data, UserDataHandlerJsr handler){
        return call(Object.class, "setUserData").with(key, data, handler);
    }

    /**

 Associate an object to a key on this node. The object can later be
 retrieved from this node by calling <code>getUserData</code> with the
 same key.
 @param key The key to associate the object to.
 @param data The object to associate to the given key, or
 <code>null</code> to remove any existing association to that key.
 @param handler The handler to associate to that key, or
 <code>null</code>.
 @return Returns the <code>DOMUserData</code> previously associated to
 the given key on this node, or <code>null</code> if there was none.
 @since DOM Level 3
 
*/

public JsFunc<Object> setUserData(IValueBinding<String> key, IValueBinding<Object> data, IValueBinding<? extends UserDataHandlerJsr> handler){
        return call(Object.class, "setUserData").with(key, data, handler);
    }

    /**

 Retrieves the object associated to a key on a this node. The object
 must first have been set to this node by calling
 <code>setUserData</code> with the same key.
 @param key The key the object is associated to.
 @return Returns the <code>DOMUserData</code> associated to the given
 key on this node, or <code>null</code> if there was none.
 @since DOM Level 3
 
*/

public JsFunc<Object> getUserData(String key){
        return call(Object.class, "getUserData").with(key);
    }

    /**

 Retrieves the object associated to a key on a this node. The object
 must first have been set to this node by calling
 <code>setUserData</code> with the same key.
 @param key The key the object is associated to.
 @return Returns the <code>DOMUserData</code> associated to the given
 key on this node, or <code>null</code> if there was none.
 @since DOM Level 3
 
*/

public JsFunc<Object> getUserData(IValueBinding<String> key){
        return call(Object.class, "getUserData").with(key);
    }

    public JsFunc<String> toString_(){
        return call(String.class, "toString");
    }
    
    public static JsTypeRef<NodeJsr> prototype = new JsTypeRef<NodeJsr>(S);
}