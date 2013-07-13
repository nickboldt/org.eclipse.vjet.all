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
import org.eclipse.vjet.vsf.jsbrowser.jsr.DocumentTypeJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class DOMImplementationJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("DOMImplementation", DOMImplementationJsr.class, "DOMImplementation");

    public DOMImplementationJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected DOMImplementationJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    /**

 Test if the DOM implementation implements a specific feature and version,
 as specified in DOM Features.
 @param feature
 @param version
 @return
 
*/

public JsFunc<Boolean> hasFeature(String feature, String version){
        return call(Boolean.class, "hasFeature").with(feature, version);
    }

    /**

 Test if the DOM implementation implements a specific feature and version,
 as specified in DOM Features.
 @param feature
 @param version
 @return
 
*/

public JsFunc<Boolean> hasFeature(IValueBinding<String> feature, IValueBinding<String> version){
        return call(Boolean.class, "hasFeature").with(feature, version);
    }

    /**

 Creates an empty DocumentType node.
 Entity declarations and notations are not made available.
 Entity reference expansions and default attribute additions do not occur.
 @param qualifiedName
 @param publicId
 @param systemId
 @return
 @since DOM Level 2
 
*/

public JsFunc<? extends DocumentTypeJsr> createDocumentType(String qualifiedName, String publicId, String systemId){
        return call(DocumentTypeJsr.class, "createDocumentType").with(qualifiedName, publicId, systemId);
    }

    /**

 Creates an empty DocumentType node.
 Entity declarations and notations are not made available.
 Entity reference expansions and default attribute additions do not occur.
 @param qualifiedName
 @param publicId
 @param systemId
 @return
 @since DOM Level 2
 
*/

public JsFunc<? extends DocumentTypeJsr> createDocumentType(IValueBinding<String> qualifiedName, IValueBinding<String> publicId, IValueBinding<String> systemId){
        return call(DocumentTypeJsr.class, "createDocumentType").with(qualifiedName, publicId, systemId);
    }

    /**

 Creates a DOM Document object of the specified type with its document element.
 Note that based on the DocumentType given to create the document, the implementation may
 instantiate specialized Document objects that support additional features than the "Core",
 such as "HTML" [DOM Level 2 HTML]. On the other hand, setting the DocumentType after
 the document was created makes this very unlikely to happen.
 Alternatively, specialized Document creation methods, such as
 createHTMLDocument [DOM Level 2 HTML], can be used to obtain specific types of Document objects.
 @param namespaceURI
 @param qualifiedName
 @param doctype
 @return
 @since DOM Level 2
 
*/

public JsFunc<? extends DocumentJsr> createDocument(String namespaceURI, String qualifiedName, DocumentTypeJsr doctype){
        return call(DocumentJsr.class, "createDocument").with(namespaceURI, qualifiedName, doctype);
    }

    /**

 Creates a DOM Document object of the specified type with its document element.
 Note that based on the DocumentType given to create the document, the implementation may
 instantiate specialized Document objects that support additional features than the "Core",
 such as "HTML" [DOM Level 2 HTML]. On the other hand, setting the DocumentType after
 the document was created makes this very unlikely to happen.
 Alternatively, specialized Document creation methods, such as
 createHTMLDocument [DOM Level 2 HTML], can be used to obtain specific types of Document objects.
 @param namespaceURI
 @param qualifiedName
 @param doctype
 @return
 @since DOM Level 2
 
*/

public JsFunc<? extends DocumentJsr> createDocument(IValueBinding<String> namespaceURI, IValueBinding<String> qualifiedName, IValueBinding<? extends DocumentTypeJsr> doctype){
        return call(DocumentJsr.class, "createDocument").with(namespaceURI, qualifiedName, doctype);
    }

    /**

 This method returns a specialized object which implements the specialized APIs
 of the specified feature and version, as specified in DOM Features.
 The specialized object may also be obtained by using binding-specific casting methods
 but is not necessarily expected to, as discussed in Mixed DOM Implementations.
 This method also allow the implementation to provide specialized objects which do not
 support the DOMImplementation interface.
 @param feature
 @param version
 @return
 @since DOM Level 3
 
*/

public JsFunc<Object> getFeature(String feature, String version){
        return call(Object.class, "getFeature").with(feature, version);
    }

    /**

 This method returns a specialized object which implements the specialized APIs
 of the specified feature and version, as specified in DOM Features.
 The specialized object may also be obtained by using binding-specific casting methods
 but is not necessarily expected to, as discussed in Mixed DOM Implementations.
 This method also allow the implementation to provide specialized objects which do not
 support the DOMImplementation interface.
 @param feature
 @param version
 @return
 @since DOM Level 3
 
*/

public JsFunc<Object> getFeature(IValueBinding<String> feature, IValueBinding<String> version){
        return call(Object.class, "getFeature").with(feature, version);
    }
    
    public static JsTypeRef<DOMImplementationJsr> prototype = new JsTypeRef<DOMImplementationJsr>(S);
}