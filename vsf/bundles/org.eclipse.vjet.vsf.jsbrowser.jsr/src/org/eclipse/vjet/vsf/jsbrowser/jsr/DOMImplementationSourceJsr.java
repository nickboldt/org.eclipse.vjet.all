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
import org.eclipse.vjet.vsf.jsbrowser.jsr.DOMImplementationListJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class DOMImplementationSourceJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("DOMImplementationSource", DOMImplementationSourceJsr.class, "DOMImplementationSource");

    public DOMImplementationSourceJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected DOMImplementationSourceJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    /**

 A method to request the first DOM implementation that supports the specified features.
 @param features
 @return
 
*/

public JsFunc<? extends DOMImplementationJsr> getDOMImplementation(String features){
        return call(DOMImplementationJsr.class, "getDOMImplementation").with(features);
    }

    /**

 A method to request the first DOM implementation that supports the specified features.
 @param features
 @return
 
*/

public JsFunc<? extends DOMImplementationJsr> getDOMImplementation(IValueBinding<String> features){
        return call(DOMImplementationJsr.class, "getDOMImplementation").with(features);
    }

    /**

 A method to request a list of DOM implementations that support the specified features
 and versions, as specified in DOM Features.
 @param features
 @return
 
*/

public JsFunc<? extends DOMImplementationListJsr> getDOMImplementationList(String features){
        return call(DOMImplementationListJsr.class, "getDOMImplementationList").with(features);
    }

    /**

 A method to request a list of DOM implementations that support the specified features
 and versions, as specified in DOM Features.
 @param features
 @return
 
*/

public JsFunc<? extends DOMImplementationListJsr> getDOMImplementationList(IValueBinding<String> features){
        return call(DOMImplementationListJsr.class, "getDOMImplementationList").with(features);
    }
    
    public static JsTypeRef<DOMImplementationSourceJsr> prototype = new JsTypeRef<DOMImplementationSourceJsr>(S);
}