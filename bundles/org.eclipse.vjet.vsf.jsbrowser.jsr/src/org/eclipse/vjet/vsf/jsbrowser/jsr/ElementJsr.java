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
import org.eclipse.vjet.vsf.jsbrowser.jsr.NodeJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.NodeListJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.TypeInfoJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsProp;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;
import org.eclipse.vjet.vsf.jsruntime.jsref.IJsPropSetter;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class ElementJsr extends NodeJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("Element", ElementJsr.class, "Element");

    public ElementJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected ElementJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsProp<String> tagName(){
        return getProp(String.class, "tagName");
    }

    public IJsPropSetter tagName(String v) {
        return setProp("tagName", v);
    }

    public IJsPropSetter tagName(IValueBinding<String> v) {
        return setProp("tagName", v);
    }

    public JsProp<TypeInfoJsr> schemaTypeInfo(){
        return getProp(TypeInfoJsr.class, "schemaTypeInfo");
    }

    public IJsPropSetter schemaTypeInfo(TypeInfoJsr v) {
        return setProp("schemaTypeInfo", v);
    }

    public IJsPropSetter schemaTypeInfo(IValueBinding<? extends TypeInfoJsr> v) {
        return setProp("schemaTypeInfo", v);
    }

    public JsFunc<Object> getAttribute(String sAttrName, int iFlags){
        return call(Object.class, "getAttribute").with(sAttrName, iFlags);
    }

    public JsFunc<Object> getAttribute(IValueBinding<String> sAttrName, IValueBinding<Integer> iFlags){
        return call(Object.class, "getAttribute").with(sAttrName, iFlags);
    }

    public JsFunc<Object> getAttribute(String sAttrName){
        return call(Object.class, "getAttribute").with(sAttrName);
    }

    public JsFunc<Object> getAttribute(IValueBinding<String> sAttrName){
        return call(Object.class, "getAttribute").with(sAttrName);
    }

    public JsFunc<Void> setAttribute(String name, Object value){
        return call("setAttribute").with(name, value);
    }

    public JsFunc<Void> setAttribute(IValueBinding<String> name, IValueBinding<Object> value){
        return call("setAttribute").with(name, value);
    }

    public JsFunc<Void> setAttribute(String name, String value){
        return call("setAttribute").with(name, value);
    }

    public JsFunc<Void> setAttribute(IValueBinding<String> name, IValueBinding<String> value, 
            org.eclipse.vjet.vsf.jsref.d.D1... notUsed){
        return call("setAttribute").with(name, value);
    }

    /**

 Removes an attribute by name. If a default value for the removed
 attribute is defined in the DTD, a new attribute immediately appears
 with the default value as well as the corresponding namespace URI,
 local name, and prefix when applicable. The implementation may handle
 default values from other schemas similarly but applications should
 use <code>Document.normalizeDocument()</code> to guarantee this
 information is up-to-date.
 <br>If no attribute with this name is found, this method has no effect.
 <br>To remove an attribute by local name and namespace URI, use the
 <code>removeAttributeNS</code> method.
 @param name The name of the attribute to remove.
 @exception DOMExceptionNO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 
*/

public JsFunc<Void> removeAttribute(String name){
        return call("removeAttribute").with(name);
    }

    /**

 Removes an attribute by name. If a default value for the removed
 attribute is defined in the DTD, a new attribute immediately appears
 with the default value as well as the corresponding namespace URI,
 local name, and prefix when applicable. The implementation may handle
 default values from other schemas similarly but applications should
 use <code>Document.normalizeDocument()</code> to guarantee this
 information is up-to-date.
 <br>If no attribute with this name is found, this method has no effect.
 <br>To remove an attribute by local name and namespace URI, use the
 <code>removeAttributeNS</code> method.
 @param name The name of the attribute to remove.
 @exception DOMExceptionNO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 
*/

public JsFunc<Void> removeAttribute(IValueBinding<String> name){
        return call("removeAttribute").with(name);
    }

    /**

 Returns a <code>NodeList</code> of all descendant <code>Elements</code>
 with a given tag name, in document order.
 @param name The name of the tag to match on. The special value "*"
 matches all tags.
 @return A list of matching <code>Element</code> nodes.
 
*/

public JsFunc<? extends NodeListJsr> getElementsByTagName(String name){
        return call(NodeListJsr.class, "getElementsByTagName").with(name);
    }

    /**

 Returns a <code>NodeList</code> of all descendant <code>Elements</code>
 with a given tag name, in document order.
 @param name The name of the tag to match on. The special value "*"
 matches all tags.
 @return A list of matching <code>Element</code> nodes.
 
*/

public JsFunc<? extends NodeListJsr> getElementsByTagName(IValueBinding<String> name){
        return call(NodeListJsr.class, "getElementsByTagName").with(name);
    }

    /**

 Retrieves an attribute node by name.
 @param name
 @return Attr 
 
*/

public JsFunc<? extends AttrJsr> getAttributeNode(String name){
        return call(AttrJsr.class, "getAttributeNode").with(name);
    }

    /**

 Retrieves an attribute node by name.
 @param name
 @return Attr 
 
*/

public JsFunc<? extends AttrJsr> getAttributeNode(IValueBinding<String> name){
        return call(AttrJsr.class, "getAttributeNode").with(name);
    }

    /**

 Adds a new attribute node.
 @param newAttr Attr
 @return Attr If the newAttr attribute replaces an existing attribute,
 the replaced Attr node is returned, otherwise null is returned.
 
*/

public JsFunc<? extends AttrJsr> setAttributeNode(AttrJsr newAttr){
        return call(AttrJsr.class, "setAttributeNode").with(newAttr);
    }

    /**

 Adds a new attribute node.
 @param newAttr Attr
 @return Attr If the newAttr attribute replaces an existing attribute,
 the replaced Attr node is returned, otherwise null is returned.
 
*/

public JsFunc<? extends AttrJsr> setAttributeNode(IValueBinding<? extends AttrJsr> newAttr){
        return call(AttrJsr.class, "setAttributeNode").with(newAttr);
    }

    /**

 Removes the specified attribute node
 @param oldAttr Attr
 @return The Attr node that was removed.
 
*/

public JsFunc<? extends AttrJsr> removeAttributeNode(AttrJsr oldAttr){
        return call(AttrJsr.class, "removeAttributeNode").with(oldAttr);
    }

    /**

 Removes the specified attribute node
 @param oldAttr Attr
 @return The Attr node that was removed.
 
*/

public JsFunc<? extends AttrJsr> removeAttributeNode(IValueBinding<? extends AttrJsr> oldAttr){
        return call(AttrJsr.class, "removeAttributeNode").with(oldAttr);
    }

    /**

 Returns <code>true</code> when an attribute with a given name is
 specified on this element or has a default value, <code>false</code>
 otherwise.
 @param name The name of the attribute to look for.
 @return <code>true</code> if an attribute with the given name is
 specified on this element or has a default value, <code>false</code>
 otherwise.
 @since DOM Level 2
 
*/

public JsFunc<Boolean> hasAttribute(String name){
        return call(Boolean.class, "hasAttribute").with(name);
    }

    /**

 Returns <code>true</code> when an attribute with a given name is
 specified on this element or has a default value, <code>false</code>
 otherwise.
 @param name The name of the attribute to look for.
 @return <code>true</code> if an attribute with the given name is
 specified on this element or has a default value, <code>false</code>
 otherwise.
 @since DOM Level 2
 
*/

public JsFunc<Boolean> hasAttribute(IValueBinding<String> name){
        return call(Boolean.class, "hasAttribute").with(name);
    }

    /**

 Retrieves an attribute value by local name and namespace URI.
 <br>Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>]
 , applications must use the value <code>null</code> as the
 <code>namespaceURI</code> parameter for methods if they wish to have
 no namespace.
 @param namespaceURI The namespace URI of the attribute to retrieve.
 @param localName The local name of the attribute to retrieve.
 @return The <code>Attr</code> value as a string, or the empty string
 if that attribute does not have a specified or default value.
 @exception DOMExceptionNOT_SUPPORTED_ERR: May be raised if the implementation does not
 support the feature <code>"XML"</code> and the language exposed
 through the Document does not support XML Namespaces (such as [<a href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
 @since DOM Level 2
 
*/

public JsFunc<String> getAttributeNS(String namespaceURI, String localName){
        return call(String.class, "getAttributeNS").with(namespaceURI, localName);
    }

    /**

 Retrieves an attribute value by local name and namespace URI.
 <br>Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>]
 , applications must use the value <code>null</code> as the
 <code>namespaceURI</code> parameter for methods if they wish to have
 no namespace.
 @param namespaceURI The namespace URI of the attribute to retrieve.
 @param localName The local name of the attribute to retrieve.
 @return The <code>Attr</code> value as a string, or the empty string
 if that attribute does not have a specified or default value.
 @exception DOMExceptionNOT_SUPPORTED_ERR: May be raised if the implementation does not
 support the feature <code>"XML"</code> and the language exposed
 through the Document does not support XML Namespaces (such as [<a href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
 @since DOM Level 2
 
*/

public JsFunc<String> getAttributeNS(IValueBinding<String> namespaceURI, IValueBinding<String> localName){
        return call(String.class, "getAttributeNS").with(namespaceURI, localName);
    }

    /**

 Adds a new attribute. If an attribute with the same local name and
 namespace URI is already present on the element, its prefix is
 changed to be the prefix part of the <code>qualifiedName</code>, and
 its value is changed to be the <code>value</code> parameter. This
 value is a simple string; it is not parsed as it is being set. So any
 markup (such as syntax to be recognized as an entity reference) is
 treated as literal text, and needs to be appropriately escaped by the
 implementation when it is written out. In order to assign an
 attribute value that contains entity references, the user must create
 an <code>Attr</code> node plus any <code>Text</code> and
 <code>EntityReference</code> nodes, build the appropriate subtree,
 and use <code>setAttributeNodeNS</code> or
 <code>setAttributeNode</code> to assign it as the value of an
 attribute.
 <br>Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>]
 , applications must use the value <code>null</code> as the
 <code>namespaceURI</code> parameter for methods if they wish to have
 no namespace.
 @param namespaceURI The namespace URI of the attribute to create or
 alter.
 @param qualifiedName The qualified name of the attribute to create or
 alter.
 @param value The value to set in string form.
 @exception DOMExceptionINVALID_CHARACTER_ERR: Raised if the specified qualified name is not
 an XML name according to the XML version in use specified in the
 <code>Document.xmlVersion</code> attribute.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 <br>NAMESPACE_ERR: Raised if the <code>qualifiedName</code> is
 malformed per the Namespaces in XML specification, if the
 <code>qualifiedName</code> has a prefix and the
 <code>namespaceURI</code> is <code>null</code>, if the
 <code>qualifiedName</code> has a prefix that is "xml" and the
 <code>namespaceURI</code> is different from "<a href='http://www.w3.org/XML/1998/namespace'>
 http://www.w3.org/XML/1998/namespace</a>", if the <code>qualifiedName</code> or its prefix is "xmlns" and the
 <code>namespaceURI</code> is different from "<a href='http://www.w3.org/2000/xmlns/'>http://www.w3.org/2000/xmlns/</a>", or if the <code>namespaceURI</code> is "<a href='http://www.w3.org/2000/xmlns/'>http://www.w3.org/2000/xmlns/</a>" and neither the <code>qualifiedName</code> nor its prefix is "xmlns".
 <br>NOT_SUPPORTED_ERR: May be raised if the implementation does not
 support the feature <code>"XML"</code> and the language exposed
 through the Document does not support XML Namespaces (such as [<a href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
 @since DOM Level 2
 
*/

public JsFunc<Void> setAttributeNS(String namespaceURI, String qualifiedName, String value){
        return call("setAttributeNS").with(namespaceURI, qualifiedName, value);
    }

    /**

 Adds a new attribute. If an attribute with the same local name and
 namespace URI is already present on the element, its prefix is
 changed to be the prefix part of the <code>qualifiedName</code>, and
 its value is changed to be the <code>value</code> parameter. This
 value is a simple string; it is not parsed as it is being set. So any
 markup (such as syntax to be recognized as an entity reference) is
 treated as literal text, and needs to be appropriately escaped by the
 implementation when it is written out. In order to assign an
 attribute value that contains entity references, the user must create
 an <code>Attr</code> node plus any <code>Text</code> and
 <code>EntityReference</code> nodes, build the appropriate subtree,
 and use <code>setAttributeNodeNS</code> or
 <code>setAttributeNode</code> to assign it as the value of an
 attribute.
 <br>Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>]
 , applications must use the value <code>null</code> as the
 <code>namespaceURI</code> parameter for methods if they wish to have
 no namespace.
 @param namespaceURI The namespace URI of the attribute to create or
 alter.
 @param qualifiedName The qualified name of the attribute to create or
 alter.
 @param value The value to set in string form.
 @exception DOMExceptionINVALID_CHARACTER_ERR: Raised if the specified qualified name is not
 an XML name according to the XML version in use specified in the
 <code>Document.xmlVersion</code> attribute.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 <br>NAMESPACE_ERR: Raised if the <code>qualifiedName</code> is
 malformed per the Namespaces in XML specification, if the
 <code>qualifiedName</code> has a prefix and the
 <code>namespaceURI</code> is <code>null</code>, if the
 <code>qualifiedName</code> has a prefix that is "xml" and the
 <code>namespaceURI</code> is different from "<a href='http://www.w3.org/XML/1998/namespace'>
 http://www.w3.org/XML/1998/namespace</a>", if the <code>qualifiedName</code> or its prefix is "xmlns" and the
 <code>namespaceURI</code> is different from "<a href='http://www.w3.org/2000/xmlns/'>http://www.w3.org/2000/xmlns/</a>", or if the <code>namespaceURI</code> is "<a href='http://www.w3.org/2000/xmlns/'>http://www.w3.org/2000/xmlns/</a>" and neither the <code>qualifiedName</code> nor its prefix is "xmlns".
 <br>NOT_SUPPORTED_ERR: May be raised if the implementation does not
 support the feature <code>"XML"</code> and the language exposed
 through the Document does not support XML Namespaces (such as [<a href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
 @since DOM Level 2
 
*/

public JsFunc<Void> setAttributeNS(IValueBinding<String> namespaceURI, IValueBinding<String> qualifiedName, IValueBinding<String> value){
        return call("setAttributeNS").with(namespaceURI, qualifiedName, value);
    }

    /**

 Removes an attribute by local name and namespace URI. If a default
 value for the removed attribute is defined in the DTD, a new
 attribute immediately appears with the default value as well as the
 corresponding namespace URI, local name, and prefix when applicable.
 The implementation may handle default values from other schemas
 similarly but applications should use
 <code>Document.normalizeDocument()</code> to guarantee this
 information is up-to-date.
 <br>If no attribute with this local name and namespace URI is found,
 this method has no effect.
 <br>Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>]
 , applications must use the value <code>null</code> as the
 <code>namespaceURI</code> parameter for methods if they wish to have
 no namespace.
 @param namespaceURI The namespace URI of the attribute to remove.
 @param localName The local name of the attribute to remove.
 @exception DOMExceptionNO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 <br>NOT_SUPPORTED_ERR: May be raised if the implementation does not
 support the feature <code>"XML"</code> and the language exposed
 through the Document does not support XML Namespaces (such as [<a href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
 @since DOM Level 2
 
*/

public JsFunc<Void> removeAttributeNS(String namespaceURI, String localName){
        return call("removeAttributeNS").with(namespaceURI, localName);
    }

    /**

 Removes an attribute by local name and namespace URI. If a default
 value for the removed attribute is defined in the DTD, a new
 attribute immediately appears with the default value as well as the
 corresponding namespace URI, local name, and prefix when applicable.
 The implementation may handle default values from other schemas
 similarly but applications should use
 <code>Document.normalizeDocument()</code> to guarantee this
 information is up-to-date.
 <br>If no attribute with this local name and namespace URI is found,
 this method has no effect.
 <br>Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>]
 , applications must use the value <code>null</code> as the
 <code>namespaceURI</code> parameter for methods if they wish to have
 no namespace.
 @param namespaceURI The namespace URI of the attribute to remove.
 @param localName The local name of the attribute to remove.
 @exception DOMExceptionNO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 <br>NOT_SUPPORTED_ERR: May be raised if the implementation does not
 support the feature <code>"XML"</code> and the language exposed
 through the Document does not support XML Namespaces (such as [<a href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
 @since DOM Level 2
 
*/

public JsFunc<Void> removeAttributeNS(IValueBinding<String> namespaceURI, IValueBinding<String> localName){
        return call("removeAttributeNS").with(namespaceURI, localName);
    }

    /**

 Retrieves an <code>Attr</code> node by local name and namespace URI.
 <br>Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>]
 , applications must use the value <code>null</code> as the
 <code>namespaceURI</code> parameter for methods if they wish to have
 no namespace.
 @param namespaceURI The namespace URI of the attribute to retrieve.
 @param localName The local name of the attribute to retrieve.
 @return The <code>Attr</code> node with the specified attribute local
 name and namespace URI or <code>null</code> if there is no such
 attribute.
 @exception DOMExceptionNOT_SUPPORTED_ERR: May be raised if the implementation does not
 support the feature <code>"XML"</code> and the language exposed
 through the Document does not support XML Namespaces (such as [<a href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
 @since DOM Level 2
 
*/

public JsFunc<? extends AttrJsr> getAttributeNodeNS(String namespaceURI, String localName){
        return call(AttrJsr.class, "getAttributeNodeNS").with(namespaceURI, localName);
    }

    /**

 Retrieves an <code>Attr</code> node by local name and namespace URI.
 <br>Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>]
 , applications must use the value <code>null</code> as the
 <code>namespaceURI</code> parameter for methods if they wish to have
 no namespace.
 @param namespaceURI The namespace URI of the attribute to retrieve.
 @param localName The local name of the attribute to retrieve.
 @return The <code>Attr</code> node with the specified attribute local
 name and namespace URI or <code>null</code> if there is no such
 attribute.
 @exception DOMExceptionNOT_SUPPORTED_ERR: May be raised if the implementation does not
 support the feature <code>"XML"</code> and the language exposed
 through the Document does not support XML Namespaces (such as [<a href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
 @since DOM Level 2
 
*/

public JsFunc<? extends AttrJsr> getAttributeNodeNS(IValueBinding<String> namespaceURI, IValueBinding<String> localName){
        return call(AttrJsr.class, "getAttributeNodeNS").with(namespaceURI, localName);
    }

    /**

 Adds a new attribute. If an attribute with that local name and that
 namespace URI is already present in the element, it is replaced by
 the new one. Replacing an attribute node by itself has no effect.
 <br>Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>]
 , applications must use the value <code>null</code> as the
 <code>namespaceURI</code> parameter for methods if they wish to have
 no namespace.
 @param newAttr The <code>Attr</code> node to add to the attribute list.
 @return If the <code>newAttr</code> attribute replaces an existing
 attribute with the same local name and namespace URI, the replaced
 <code>Attr</code> node is returned, otherwise <code>null</code> is
 returned.
 @exception DOMExceptionWRONG_DOCUMENT_ERR: Raised if <code>newAttr</code> was created from a
 different document than the one that created the element.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 <br>INUSE_ATTRIBUTE_ERR: Raised if <code>newAttr</code> is already an
 attribute of another <code>Element</code> object. The DOM user must
 explicitly clone <code>Attr</code> nodes to re-use them in other
 elements.
 <br>NOT_SUPPORTED_ERR: May be raised if the implementation does not
 support the feature <code>"XML"</code> and the language exposed
 through the Document does not support XML Namespaces (such as [<a href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
 @since DOM Level 2
 
*/

public JsFunc<? extends AttrJsr> setAttributeNodeNS(AttrJsr newAttr){
        return call(AttrJsr.class, "setAttributeNodeNS").with(newAttr);
    }

    /**

 Adds a new attribute. If an attribute with that local name and that
 namespace URI is already present in the element, it is replaced by
 the new one. Replacing an attribute node by itself has no effect.
 <br>Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>]
 , applications must use the value <code>null</code> as the
 <code>namespaceURI</code> parameter for methods if they wish to have
 no namespace.
 @param newAttr The <code>Attr</code> node to add to the attribute list.
 @return If the <code>newAttr</code> attribute replaces an existing
 attribute with the same local name and namespace URI, the replaced
 <code>Attr</code> node is returned, otherwise <code>null</code> is
 returned.
 @exception DOMExceptionWRONG_DOCUMENT_ERR: Raised if <code>newAttr</code> was created from a
 different document than the one that created the element.
 <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 <br>INUSE_ATTRIBUTE_ERR: Raised if <code>newAttr</code> is already an
 attribute of another <code>Element</code> object. The DOM user must
 explicitly clone <code>Attr</code> nodes to re-use them in other
 elements.
 <br>NOT_SUPPORTED_ERR: May be raised if the implementation does not
 support the feature <code>"XML"</code> and the language exposed
 through the Document does not support XML Namespaces (such as [<a href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
 @since DOM Level 2
 
*/

public JsFunc<? extends AttrJsr> setAttributeNodeNS(IValueBinding<? extends AttrJsr> newAttr){
        return call(AttrJsr.class, "setAttributeNodeNS").with(newAttr);
    }

    /**

 Returns a <code>NodeList</code> of all the descendant
 <code>Elements</code> with a given local name and namespace URI in
 document order.
 @param namespaceURI The namespace URI of the elements to match on. The
 special value "*" matches all namespaces.
 @param localName The local name of the elements to match on. The
 special value "*" matches all local names.
 @return A new <code>NodeList</code> object containing all the matched
 <code>Elements</code>.
 @exception DOMExceptionNOT_SUPPORTED_ERR: May be raised if the implementation does not
 support the feature <code>"XML"</code> and the language exposed
 through the Document does not support XML Namespaces (such as [<a href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeListJsr> getElementsByTagNameNS(String namespaceURI, String localName){
        return call(NodeListJsr.class, "getElementsByTagNameNS").with(namespaceURI, localName);
    }

    /**

 Returns a <code>NodeList</code> of all the descendant
 <code>Elements</code> with a given local name and namespace URI in
 document order.
 @param namespaceURI The namespace URI of the elements to match on. The
 special value "*" matches all namespaces.
 @param localName The local name of the elements to match on. The
 special value "*" matches all local names.
 @return A new <code>NodeList</code> object containing all the matched
 <code>Elements</code>.
 @exception DOMExceptionNOT_SUPPORTED_ERR: May be raised if the implementation does not
 support the feature <code>"XML"</code> and the language exposed
 through the Document does not support XML Namespaces (such as [<a href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
 @since DOM Level 2
 
*/

public JsFunc<? extends NodeListJsr> getElementsByTagNameNS(IValueBinding<String> namespaceURI, IValueBinding<String> localName){
        return call(NodeListJsr.class, "getElementsByTagNameNS").with(namespaceURI, localName);
    }

    /**

 Returns <code>true</code> when an attribute with a given local name and
 namespace URI is specified on this element or has a default value,
 <code>false</code> otherwise.
 <br>Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>]
 , applications must use the value <code>null</code> as the
 <code>namespaceURI</code> parameter for methods if they wish to have
 no namespace.
 @param namespaceURI The namespace URI of the attribute to look for.
 @param localName The local name of the attribute to look for.
 @return <code>true</code> if an attribute with the given local name
 and namespace URI is specified or has a default value on this
 element, <code>false</code> otherwise.
 @exception DOMExceptionNOT_SUPPORTED_ERR: May be raised if the implementation does not
 support the feature <code>"XML"</code> and the language exposed
 through the Document does not support XML Namespaces (such as [<a href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
 @since DOM Level 2
 
*/

public JsFunc<Boolean> hasAttributeNS(String namespaceURI, String localName){
        return call(Boolean.class, "hasAttributeNS").with(namespaceURI, localName);
    }

    /**

 Returns <code>true</code> when an attribute with a given local name and
 namespace URI is specified on this element or has a default value,
 <code>false</code> otherwise.
 <br>Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>]
 , applications must use the value <code>null</code> as the
 <code>namespaceURI</code> parameter for methods if they wish to have
 no namespace.
 @param namespaceURI The namespace URI of the attribute to look for.
 @param localName The local name of the attribute to look for.
 @return <code>true</code> if an attribute with the given local name
 and namespace URI is specified or has a default value on this
 element, <code>false</code> otherwise.
 @exception DOMExceptionNOT_SUPPORTED_ERR: May be raised if the implementation does not
 support the feature <code>"XML"</code> and the language exposed
 through the Document does not support XML Namespaces (such as [<a href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
 @since DOM Level 2
 
*/

public JsFunc<Boolean> hasAttributeNS(IValueBinding<String> namespaceURI, IValueBinding<String> localName){
        return call(Boolean.class, "hasAttributeNS").with(namespaceURI, localName);
    }

    /**

 If the parameter <code>isId</code> is <code>true</code>, this method
 declares the specified attribute to be a user-determined ID attribute
 . This affects the value of <code>Attr.isId</code> and the behavior
 of <code>Document.getElementById</code>, but does not change any
 schema that may be in use, in particular this does not affect the
 <code>Attr.schemaTypeInfo</code> of the specified <code>Attr</code>
 node. Use the value <code>false</code> for the parameter
 <code>isId</code> to undeclare an attribute for being a
 user-determined ID attribute.
 <br> To specify an attribute by local name and namespace URI, use the
 <code>setIdAttributeNS</code> method.
 @param name The name of the attribute.
 @param isId Whether the attribute is a of type ID.
 @exception DOMExceptionNO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 <br>NOT_FOUND_ERR: Raised if the specified node is not an attribute
 of this element.
 @since DOM Level 3
 
*/

public JsFunc<Void> setIdAttribute(String name, boolean isId){
        return call("setIdAttribute").with(name, isId);
    }

    /**

 If the parameter <code>isId</code> is <code>true</code>, this method
 declares the specified attribute to be a user-determined ID attribute
 . This affects the value of <code>Attr.isId</code> and the behavior
 of <code>Document.getElementById</code>, but does not change any
 schema that may be in use, in particular this does not affect the
 <code>Attr.schemaTypeInfo</code> of the specified <code>Attr</code>
 node. Use the value <code>false</code> for the parameter
 <code>isId</code> to undeclare an attribute for being a
 user-determined ID attribute.
 <br> To specify an attribute by local name and namespace URI, use the
 <code>setIdAttributeNS</code> method.
 @param name The name of the attribute.
 @param isId Whether the attribute is a of type ID.
 @exception DOMExceptionNO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 <br>NOT_FOUND_ERR: Raised if the specified node is not an attribute
 of this element.
 @since DOM Level 3
 
*/

public JsFunc<Void> setIdAttribute(IValueBinding<String> name, IValueBinding<Boolean> isId){
        return call("setIdAttribute").with(name, isId);
    }

    /**

 If the parameter <code>isId</code> is <code>true</code>, this method
 declares the specified attribute to be a user-determined ID attribute
 . This affects the value of <code>Attr.isId</code> and the behavior
 of <code>Document.getElementById</code>, but does not change any
 schema that may be in use, in particular this does not affect the
 <code>Attr.schemaTypeInfo</code> of the specified <code>Attr</code>
 node. Use the value <code>false</code> for the parameter
 <code>isId</code> to undeclare an attribute for being a
 user-determined ID attribute.
 @param namespaceURI The namespace URI of the attribute.
 @param localName The local name of the attribute.
 @param isId Whether the attribute is a of type ID.
 @exception DOMExceptionNO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 <br>NOT_FOUND_ERR: Raised if the specified node is not an attribute
 of this element.
 @since DOM Level 3
 
*/

public JsFunc<Void> setIdAttributeNS(String namespaceURI, String localName, boolean isId){
        return call("setIdAttributeNS").with(namespaceURI, localName, isId);
    }

    /**

 If the parameter <code>isId</code> is <code>true</code>, this method
 declares the specified attribute to be a user-determined ID attribute
 . This affects the value of <code>Attr.isId</code> and the behavior
 of <code>Document.getElementById</code>, but does not change any
 schema that may be in use, in particular this does not affect the
 <code>Attr.schemaTypeInfo</code> of the specified <code>Attr</code>
 node. Use the value <code>false</code> for the parameter
 <code>isId</code> to undeclare an attribute for being a
 user-determined ID attribute.
 @param namespaceURI The namespace URI of the attribute.
 @param localName The local name of the attribute.
 @param isId Whether the attribute is a of type ID.
 @exception DOMExceptionNO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 <br>NOT_FOUND_ERR: Raised if the specified node is not an attribute
 of this element.
 @since DOM Level 3
 
*/

public JsFunc<Void> setIdAttributeNS(IValueBinding<String> namespaceURI, IValueBinding<String> localName, IValueBinding<Boolean> isId){
        return call("setIdAttributeNS").with(namespaceURI, localName, isId);
    }

    /**

 If the parameter <code>isId</code> is <code>true</code>, this method
 declares the specified attribute to be a user-determined ID attribute
 . This affects the value of <code>Attr.isId</code> and the behavior
 of <code>Document.getElementById</code>, but does not change any
 schema that may be in use, in particular this does not affect the
 <code>Attr.schemaTypeInfo</code> of the specified <code>Attr</code>
 node. Use the value <code>false</code> for the parameter
 <code>isId</code> to undeclare an attribute for being a
 user-determined ID attribute.
 @param idAttr The attribute node.
 @param isId Whether the attribute is a of type ID.
 @exception DOMExceptionNO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 <br>NOT_FOUND_ERR: Raised if the specified node is not an attribute
 of this element.
 @since DOM Level 3
 
*/

public JsFunc<Void> setIdAttributeNode(AttrJsr idAttr, boolean isId){
        return call("setIdAttributeNode").with(idAttr, isId);
    }

    /**

 If the parameter <code>isId</code> is <code>true</code>, this method
 declares the specified attribute to be a user-determined ID attribute
 . This affects the value of <code>Attr.isId</code> and the behavior
 of <code>Document.getElementById</code>, but does not change any
 schema that may be in use, in particular this does not affect the
 <code>Attr.schemaTypeInfo</code> of the specified <code>Attr</code>
 node. Use the value <code>false</code> for the parameter
 <code>isId</code> to undeclare an attribute for being a
 user-determined ID attribute.
 @param idAttr The attribute node.
 @param isId Whether the attribute is a of type ID.
 @exception DOMExceptionNO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
 <br>NOT_FOUND_ERR: Raised if the specified node is not an attribute
 of this element.
 @since DOM Level 3
 
*/

public JsFunc<Void> setIdAttributeNode(IValueBinding<? extends AttrJsr> idAttr, IValueBinding<Boolean> isId){
        return call("setIdAttributeNode").with(idAttr, isId);
    }
    
    public static JsTypeRef<ElementJsr> prototype = new JsTypeRef<ElementJsr>(S);
}