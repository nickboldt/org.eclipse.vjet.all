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
import org.eclipse.vjet.vsf.jsbrowser.jsr.DOMImplementationJsr;
import org.eclipse.vjet.vsf.jsbrowser.jsr.HTMLDocumentJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class HTMLDOMImplementationJsr extends DOMImplementationJsr {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("HTMLDOMImplementation", HTMLDOMImplementationJsr.class, "HTMLDOMImplementation");

    public HTMLDOMImplementationJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected HTMLDOMImplementationJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    /**

 Creates an <code>HTMLDocument</code> object with the minimal tree made of the following elements:
 HTML, HEAD, TITLE, and BODY.
 @param title The title of the document to be set as the content of the TITLE element,
 through a child Text node.
 @return HTMLDocument A new <code>HTMLDocument</code> object.
 
*/

public JsFunc<? extends HTMLDocumentJsr> createHTMLDocument(String title){
        return call(HTMLDocumentJsr.class, "createHTMLDocument").with(title);
    }

    /**

 Creates an <code>HTMLDocument</code> object with the minimal tree made of the following elements:
 HTML, HEAD, TITLE, and BODY.
 @param title The title of the document to be set as the content of the TITLE element,
 through a child Text node.
 @return HTMLDocument A new <code>HTMLDocument</code> object.
 
*/

public JsFunc<? extends HTMLDocumentJsr> createHTMLDocument(IValueBinding<String> title){
        return call(HTMLDocumentJsr.class, "createHTMLDocument").with(title);
    }
    
    public static JsTypeRef<HTMLDOMImplementationJsr> prototype = new JsTypeRef<HTMLDOMImplementationJsr>(S);
}