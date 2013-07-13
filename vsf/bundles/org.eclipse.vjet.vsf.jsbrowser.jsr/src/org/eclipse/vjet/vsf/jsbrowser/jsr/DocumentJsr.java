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
import org.eclipse.vjet.vsf.jsbrowser.jsr.AttrJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.CDATASectionJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.CommentJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.DOMConfigurationJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.DOMImplementationJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.DocumentFragmentJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.DocumentTypeJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.ElementJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.EntityReferenceJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.NodeJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.NodeListJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.ProcessingInstructionJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.TextJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class DocumentJsr extends NodeJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("document", null, null);

    public DocumentJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected DocumentJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<ElementJsr> documentElement(){
        return getProp(ElementJsr.class, "documentElement");
    }

    public IJsPropSetter documentElement(ElementJsr v) {
        return setProp("documentElement", v);
    }

    public IJsPropSetter documentElement(IValueBinding<? extends ElementJsr> v) {
        return setProp("documentElement", v);
    }

    public JsProp<String> inputEncoding(){
        return getProp(String.class, "inputEncoding");
    }

    public IJsPropSetter inputEncoding(String v) {
        return setProp("inputEncoding", v);
    }

    public IJsPropSetter inputEncoding(IValueBinding<String> v) {
        return setProp("inputEncoding", v);
    }

    public JsProp<String> xmlEncoding(){
        return getProp(String.class, "xmlEncoding");
    }

    public IJsPropSetter xmlEncoding(String v) {
        return setProp("xmlEncoding", v);
    }

    public IJsPropSetter xmlEncoding(IValueBinding<String> v) {
        return setProp("xmlEncoding", v);
    }

    public JsProp<Boolean> xmlStandalone(){
        return getProp(Boolean.class, "xmlStandalone");
    }

    public IJsPropSetter xmlStandalone(boolean v) {
        return setProp("xmlStandalone", v);
    }

    public IJsPropSetter xmlStandalone(IValueBinding<Boolean> v) {
        return setProp("xmlStandalone", v);
    }

    public JsProp<String> xmlVersion(){
        return getProp(String.class, "xmlVersion");
    }

    public IJsPropSetter xmlVersion(String v) {
        return setProp("xmlVersion", v);
    }

    public IJsPropSetter xmlVersion(IValueBinding<String> v) {
        return setProp("xmlVersion", v);
    }

    public JsProp<Boolean> strictErrorChecking(){
        return getProp(Boolean.class, "strictErrorChecking");
    }

    public IJsPropSetter strictErrorChecking(boolean v) {
        return setProp("strictErrorChecking", v);
    }

    public IJsPropSetter strictErrorChecking(IValueBinding<Boolean> v) {
        return setProp("strictErrorChecking", v);
    }

    public JsProp<String> documentURI(){
        return getProp(String.class, "documentURI");
    }

    public IJsPropSetter documentURI(String v) {
        return setProp("documentURI", v);
    }

    public IJsPropSetter documentURI(IValueBinding<String> v) {
        return setProp("documentURI", v);
    }

    public JsProp<DOMConfigurationJsr> domConfig(){
        return getProp(DOMConfigurationJsr.class, "domConfig");
    }

    public IJsPropSetter domConfig(DOMConfigurationJsr v) {
        return setProp("domConfig", v);
    }

    public IJsPropSetter domConfig(IValueBinding<? extends DOMConfigurationJsr> v) {
        return setProp("domConfig", v);
    }

    public JsProp<DocumentTypeJsr> doctype(){
        return getProp(DocumentTypeJsr.class, "doctype");
    }

    public IJsPropSetter doctype(DocumentTypeJsr v) {
        return setProp("doctype", v);
    }

    public IJsPropSetter doctype(IValueBinding<? extends DocumentTypeJsr> v) {
        return setProp("doctype", v);
    }

    public JsProp<DOMImplementationJsr> implementation(){
        return getProp(DOMImplementationJsr.class, "implementation");
    }

    public IJsPropSetter implementation(DOMImplementationJsr v) {
        return setProp("implementation", v);
    }

    public IJsPropSetter implementation(IValueBinding<? extends DOMImplementationJsr> v) {
        return setProp("implementation", v);
    }

    public JsProp<String> lastModified(){
        return getProp(String.class, "lastModified");
    }

    public IJsPropSetter lastModified(String v) {
        return setProp("lastModified", v);
    }

    public IJsPropSetter lastModified(IValueBinding<String> v) {
        return setProp("lastModified", v);
    }

    public JsProp<String> bgColor(){
        return getProp(String.class, "bgColor");
    }

    public IJsPropSetter bgColor(String v) {
        return setProp("bgColor", v);
    }

    public IJsPropSetter bgColor(IValueBinding<String> v) {
        return setProp("bgColor", v);
    }

    public JsProp<String> alinkColor(){
        return getProp(String.class, "alinkColor");
    }

    public IJsPropSetter alinkColor(String v) {
        return setProp("alinkColor", v);
    }

    public IJsPropSetter alinkColor(IValueBinding<String> v) {
        return setProp("alinkColor", v);
    }

    public JsProp<String> vlinkColor(){
        return getProp(String.class, "vlinkColor");
    }

    public IJsPropSetter vlinkColor(String v) {
        return setProp("vlinkColor", v);
    }

    public IJsPropSetter vlinkColor(IValueBinding<String> v) {
        return setProp("vlinkColor", v);
    }

    public JsProp<String> linkColor(){
        return getProp(String.class, "linkColor");
    }

    public IJsPropSetter linkColor(String v) {
        return setProp("linkColor", v);
    }

    public IJsPropSetter linkColor(IValueBinding<String> v) {
        return setProp("linkColor", v);
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

    public JsProp<String> cookie(){
        return getProp(String.class, "cookie");
    }

    public IJsPropSetter cookie(String v) {
        return setProp("cookie", v);
    }

    public IJsPropSetter cookie(IValueBinding<String> v) {
        return setProp("cookie", v);
    }

    public JsProp<String> fgColor(){
        return getProp(String.class, "fgColor");
    }

    public IJsPropSetter fgColor(String v) {
        return setProp("fgColor", v);
    }

    public IJsPropSetter fgColor(IValueBinding<String> v) {
        return setProp("fgColor", v);
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

    public JsProp<String> security(){
        return getProp(String.class, "security");
    }

    public IJsPropSetter security(String v) {
        return setProp("security", v);
    }

    public IJsPropSetter security(IValueBinding<String> v) {
        return setProp("security", v);
    }

    /**

 Creates an element of the type specified. Note that the instance
 returned implements the <code>Element</code> interface, so attributes
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
 @return A new <code>Element</code> object with the
 <code>nodeName</code> attribute set to <code>tagName</code>, and
 <code>localName</code>, <code>prefix</code>, and
 <code>namespaceURI</code> set to <code>null</code>.
 @exception DOMExceptionINVALID_CHARACTER_ERR: Raised if the specified name is not an XML
 name according to the XML version in use specified in the
 <code>Document.xmlVersion</code> attribute.
 
*/

public JsFunc<? extends ElementJsr> createElement(String tagName){
        return call(ElementJsr.class, "createElement").with(tagName);
    }

    /**

 Creates an element of the type specified. Note that the instance
 returned implements the <code>Element</code> interface, so attributes
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
 @return A new <code>Element</code> object with the
 <code>nodeName</code> attribute set to <code>tagName</code>, and
 <code>localName</code>, <code>prefix</code>, and
 <code>namespaceURI</code> set to <code>null</code>.
 @exception DOMExceptionINVALID_CHARACTER_ERR: Raised if the specified name is not an XML
 name according to the XML version in use specified in the
 <code>Document.xmlVersion</code> attribute.
 
*/

public JsFunc<? extends ElementJsr> createElement(IValueBinding<String> tagName){
        return call(ElementJsr.class, "createElement").with(tagName);
    }

    /**

 Creates a <code>Text</code> node given the specified string.
 @param data The data for the node.
 @return The new <code>Text</code> object.
 
*/

public JsFunc<? extends TextJsr> createTextNode(String data){
        return call(TextJsr.class, "createTextNode").with(data);
    }

    /**

 Creates a <code>Text</code> node given the specified string.
 @param data The data for the node.
 @return The new <code>Text</code> object.
 
*/

public JsFunc<? extends TextJsr> createTextNode(IValueBinding<String> data){
        return call(TextJsr.class, "createTextNode").with(data);
    }

    /**

 Returns a <code>NodeList</code> of all the <code>Elements</code> in
 document order with a given tag name and are contained in the
 document.
 @param tagname  The name of the tag to match on. The special value "*"
 matches all tags. For XML, the <code>tagname</code> parameter is
 case-sensitive, otherwise it depends on the case-sensitivity of the
 markup language in use.
 @return A new <code>NodeList</code> object containing all the matched
 <code>Elements</code>.
 
*/

public JsFunc<? extends NodeListJsr> getElementsByTagName(String tagname){
        return call(NodeListJsr.class, "getElementsByTagName").with(tagname);
    }

    /**

 Returns a <code>NodeList</code> of all the <code>Elements</code> in
 document order with a given tag name and are contained in the
 document.
 @param tagname  The name of the tag to match on. The special value "*"
 matches all tags. For XML, the <code>tagname</code> parameter is
 case-sensitive, otherwise it depends on the case-sensitivity of the
 markup language in use.
 @return A new <code>NodeList</code> object containing all the matched
 <code>Elements</code>.
 
*/

public JsFunc<? extends NodeListJsr> getElementsByTagName(IValueBinding<String> tagname){
        return call(NodeListJsr.class, "getElementsByTagName").with(tagname);
    }

    /**

 Imports a node from another document to this document, without altering
 or removing the source node from the original document; this method
 creates a new copy of the source node. The returned node has no
 parent; (<code>parentNode</code> is <code>null</code>).
 
*/

public JsFunc<? extends NodeJsr> importNode(NodeJsr importedNode, boolean deep){
        return call(NodeJsr.class, "importNode").with(importedNode, deep);
    }

    /**

 Imports a node from another document to this document, without altering
 or removing the source node from the original document; this method
 creates a new copy of the source node. The returned node has no
 parent; (<code>parentNode</code> is <code>null</code>).
 
*/

public JsFunc<? extends NodeJsr> importNode(IValueBinding<? extends NodeJsr> importedNode, IValueBinding<Boolean> deep){
        return call(NodeJsr.class, "importNode").with(importedNode, deep);
    }

    /**

 Returns the <code>Element</code> that has an ID attribute with the
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

public JsFunc<? extends ElementJsr> getElementById(String elementId){
        return call(ElementJsr.class, "getElementById").with(elementId);
    }

    /**

 Returns the <code>Element</code> that has an ID attribute with the
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

public JsFunc<? extends ElementJsr> getElementById(IValueBinding<String> elementId){
        return call(ElementJsr.class, "getElementById").with(elementId);
    }

    /**

 Creates an Attr of the given name. Note that the Attr instance can then be set on an Element
 using the setAttributeNode method. To create an attribute with a qualified name and namespace URI,
 use the createAttributeNS method.
 @param name
 @return
 
*/

public JsFunc<? extends AttrJsr> createAttribute(String name){
        return call(AttrJsr.class, "createAttribute").with(name);
    }

    /**

 Creates an Attr of the given name. Note that the Attr instance can then be set on an Element
 using the setAttributeNode method. To create an attribute with a qualified name and namespace URI,
 use the createAttributeNS method.
 @param name
 @return
 
*/

public JsFunc<? extends AttrJsr> createAttribute(IValueBinding<String> name){
        return call(AttrJsr.class, "createAttribute").with(name);
    }

    /**

 Creates an element of the given qualified name and namespace URI. Per [XML Namespaces],
 applications must use the value null as the namespaceURI parameter for methods
 if they wish to have no namespace.
 @param namespaceURI
 @param qualifiedName
 @return
 @since DOM Level 2
 
*/

public JsFunc<? extends ElementJsr> createElementNS(String namespaceURI, String qualifiedName){
        return call(ElementJsr.class, "createElementNS").with(namespaceURI, qualifiedName);
    }

    /**

 Creates an element of the given qualified name and namespace URI. Per [XML Namespaces],
 applications must use the value null as the namespaceURI parameter for methods
 if they wish to have no namespace.
 @param namespaceURI
 @param qualifiedName
 @return
 @since DOM Level 2
 
*/

public JsFunc<? extends ElementJsr> createElementNS(IValueBinding<String> namespaceURI, IValueBinding<String> qualifiedName){
        return call(ElementJsr.class, "createElementNS").with(namespaceURI, qualifiedName);
    }

    /**

 Creates an attribute of the given qualified name and namespace URI. Per [XML Namespaces],
 applications must use the value null as the namespaceURI parameter for methods
 if they wish to have no namespace.
 @param namespaceURI
 @param qualifiedName
 @return
 @since DOM Level 2
 
*/

public JsFunc<? extends AttrJsr> createAttributeNS(String namespaceURI, String qualifiedName){
        return call(AttrJsr.class, "createAttributeNS").with(namespaceURI, qualifiedName);
    }

    /**

 Creates an attribute of the given qualified name and namespace URI. Per [XML Namespaces],
 applications must use the value null as the namespaceURI parameter for methods
 if they wish to have no namespace.
 @param namespaceURI
 @param qualifiedName
 @return
 @since DOM Level 2
 
*/

public JsFunc<? extends AttrJsr> createAttributeNS(IValueBinding<String> namespaceURI, IValueBinding<String> qualifiedName){
        return call(AttrJsr.class, "createAttributeNS").with(namespaceURI, qualifiedName);
    }

    /**

 Returns a NodeList of all the Elements with a given local name and namespace URI in document order.
 @param namespaceURI
 @param localName
 @return
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeListJsr> getElementsByTagNameNS(String namespaceURI, String localName){
        return call(NodeListJsr.class, "getElementsByTagNameNS").with(namespaceURI, localName);
    }

    /**

 Returns a NodeList of all the Elements with a given local name and namespace URI in document order.
 @param namespaceURI
 @param localName
 @return
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeListJsr> getElementsByTagNameNS(IValueBinding<String> namespaceURI, IValueBinding<String> localName){
        return call(NodeListJsr.class, "getElementsByTagNameNS").with(namespaceURI, localName);
    }

    /**

 Creates an EntityReference object. In addition, if the referenced entity is known,
 the child list of the EntityReference node is made the same as that of the corresponding Entity node.
 @param name
 @return
 
*/

public JsFunc<? extends EntityReferenceJsr> createEntityReference(String name){
        return call(EntityReferenceJsr.class, "createEntityReference").with(name);
    }

    /**

 Creates an EntityReference object. In addition, if the referenced entity is known,
 the child list of the EntityReference node is made the same as that of the corresponding Entity node.
 @param name
 @return
 
*/

public JsFunc<? extends EntityReferenceJsr> createEntityReference(IValueBinding<String> name){
        return call(EntityReferenceJsr.class, "createEntityReference").with(name);
    }

    /**

 Creates a Comment node given the specified string.
 @param data
 @return
 
*/

public JsFunc<? extends CommentJsr> createComment(String data){
        return call(CommentJsr.class, "createComment").with(data);
    }

    /**

 Creates a Comment node given the specified string.
 @param data
 @return
 
*/

public JsFunc<? extends CommentJsr> createComment(IValueBinding<String> data){
        return call(CommentJsr.class, "createComment").with(data);
    }

    /**

 Creates a CDATASection node whose value is the specified string.
 @param data
 @return
 
*/

public JsFunc<? extends CDATASectionJsr> createCDATASection(String data){
        return call(CDATASectionJsr.class, "createCDATASection").with(data);
    }

    /**

 Creates a CDATASection node whose value is the specified string.
 @param data
 @return
 
*/

public JsFunc<? extends CDATASectionJsr> createCDATASection(IValueBinding<String> data){
        return call(CDATASectionJsr.class, "createCDATASection").with(data);
    }

    /**

 Creates a ProcessingInstruction node given the specified name and data strings.
 @param target
 @param data
 @return
 
*/

public JsFunc<? extends ProcessingInstructionJsr> createProcessingInstruction(String target, String data){
        return call(ProcessingInstructionJsr.class, "createProcessingInstruction").with(target, data);
    }

    /**

 Creates a ProcessingInstruction node given the specified name and data strings.
 @param target
 @param data
 @return
 
*/

public JsFunc<? extends ProcessingInstructionJsr> createProcessingInstruction(IValueBinding<String> target, IValueBinding<String> data){
        return call(ProcessingInstructionJsr.class, "createProcessingInstruction").with(target, data);
    }

    /**

 Creates an empty DocumentFragment object.
 @return
 
*/

public JsFunc<? extends DocumentFragmentJsr> createDocumentFragment(){
        return call(DocumentFragmentJsr.class, "createDocumentFragment");
    }

    /**

 Attempts to adopt a node from another document to this document.
 If supported, it changes the ownerDocument of the source node, its children,
 as well as the attached attribute nodes if there are any.
 If the source node has a parent it is first removed from the child list of its parent.
 This effectively allows moving a subtree from one document to another (unlike importNode()
 which create a copy of the source node instead of moving it).
 When it fails, applications should use Document.importNode() instead.
 Note that if the adopted node is already part of this document (i.e. the source and
 target document are the same), this method still has the effect of removing the source node
 from the child list of its parent, if any.
 The following list describes the specifics for each type of node.
 @param source
 @return
 @since DOM Level 3
 
*/

public JsFunc<? extends NodeJsr> adoptNode(NodeJsr source){
        return call(NodeJsr.class, "adoptNode").with(source);
    }

    /**

 Attempts to adopt a node from another document to this document.
 If supported, it changes the ownerDocument of the source node, its children,
 as well as the attached attribute nodes if there are any.
 If the source node has a parent it is first removed from the child list of its parent.
 This effectively allows moving a subtree from one document to another (unlike importNode()
 which create a copy of the source node instead of moving it).
 When it fails, applications should use Document.importNode() instead.
 Note that if the adopted node is already part of this document (i.e. the source and
 target document are the same), this method still has the effect of removing the source node
 from the child list of its parent, if any.
 The following list describes the specifics for each type of node.
 @param source
 @return
 @since DOM Level 3
 
*/

public JsFunc<? extends NodeJsr> adoptNode(IValueBinding<? extends NodeJsr> source){
        return call(NodeJsr.class, "adoptNode").with(source);
    }

    /**

 This method acts as if the document was going through a save and load cycle,
 putting the document in a "normal" form. As a consequence, this method updates the
 replacement tree of EntityReference nodes and normalizes Text nodes, as defined in
 the method Node.normalize(). Otherwise, the actual result depends on the features being set
 on the Document.domConfig object and governing what operations actually take place.
 Noticeably this method could also make the document namespace well-formed according to
 the algorithm described in Namespace Normalization, check the character normalization,
 remove the CDATASection nodes, etc. See DOMConfiguration for details.
 @since DOM Level 3
 
*/

public JsFunc<Void> normalizeDocument(){
        return call("normalizeDocument");
    }

    /**

 Rename an existing node of type ELEMENT_NODE or ATTRIBUTE_NODE. When possible this simply changes
 the name of the given node, otherwise this creates a new node with the specified name
 and replaces the existing node with the new node as described below. If simply changing the name of
 the given node is not possible, the following operations are performed: a new node is created,
 any registered event listener is registered on the new node, any user data attached to the old node
 is removed from that node, the old node is removed from its parent if it has one, the children
 are moved to the new node, if the renamed node is an Element its attributes are moved to the
 new node, the new node is inserted at the position the old node used to have in its parent's
 child nodes list if it has one, the user data that was attached to the old node is attached to
 the new node.
 When the node being renamed is an Element only the specified attributes are moved,
 default attributes originated from the DTD are updated according to the new element name.
 In addition, the implementation may update default attributes from other schemas.
 Applications should use Document.normalizeDocument() to guarantee these attributes are up-to-date.
 When the node being renamed is an Attr that is attached to an Element, the node is first removed
 from the Element attributes map. Then, once renamed, either by modifying the existing node or
 creating a new one as described above, it is put back. In addition,
 <ul>
 <li>a user data event NODE_RENAMED is fired,</li>
 <li>when the implementation supports the feature "MutationNameEvents",
 each mutation operation involved in this method fires the appropriate event,
 and in the end the event {http://www.w3.org/2001/xml-events, DOMElementNameChanged} or
 {http://www.w3.org/2001/xml-events, DOMAttributeNameChanged} is fired.</li>
 </ul>
 @param n
 @param namespaceURI
 @param qualifiedName
 @return
 @since DOM Level 3
 
*/

public JsFunc<? extends NodeJsr> renameNode(NodeJsr n, String namespaceURI, String qualifiedName){
        return call(NodeJsr.class, "renameNode").with(n, namespaceURI, qualifiedName);
    }

    /**

 Rename an existing node of type ELEMENT_NODE or ATTRIBUTE_NODE. When possible this simply changes
 the name of the given node, otherwise this creates a new node with the specified name
 and replaces the existing node with the new node as described below. If simply changing the name of
 the given node is not possible, the following operations are performed: a new node is created,
 any registered event listener is registered on the new node, any user data attached to the old node
 is removed from that node, the old node is removed from its parent if it has one, the children
 are moved to the new node, if the renamed node is an Element its attributes are moved to the
 new node, the new node is inserted at the position the old node used to have in its parent's
 child nodes list if it has one, the user data that was attached to the old node is attached to
 the new node.
 When the node being renamed is an Element only the specified attributes are moved,
 default attributes originated from the DTD are updated according to the new element name.
 In addition, the implementation may update default attributes from other schemas.
 Applications should use Document.normalizeDocument() to guarantee these attributes are up-to-date.
 When the node being renamed is an Attr that is attached to an Element, the node is first removed
 from the Element attributes map. Then, once renamed, either by modifying the existing node or
 creating a new one as described above, it is put back. In addition,
 <ul>
 <li>a user data event NODE_RENAMED is fired,</li>
 <li>when the implementation supports the feature "MutationNameEvents",
 each mutation operation involved in this method fires the appropriate event,
 and in the end the event {http://www.w3.org/2001/xml-events, DOMElementNameChanged} or
 {http://www.w3.org/2001/xml-events, DOMAttributeNameChanged} is fired.</li>
 </ul>
 @param n
 @param namespaceURI
 @param qualifiedName
 @return
 @since DOM Level 3
 
*/

public JsFunc<? extends NodeJsr> renameNode(IValueBinding<? extends NodeJsr> n, IValueBinding<String> namespaceURI, IValueBinding<String> qualifiedName){
        return call(NodeJsr.class, "renameNode").with(n, namespaceURI, qualifiedName);
    }
    
    public static JsTypeRef<DocumentJsr> prototype = new JsTypeRef<DocumentJsr>(S);
}