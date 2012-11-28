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
import org.eclipse.vjet.vsf.jsbrowser.jsr.DOMErrorJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class DOMErrorHandlerJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("DOMErrorHandler", DOMErrorHandlerJsr.class, "DOMErrorHandler");

    public DOMErrorHandlerJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected DOMErrorHandlerJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    /**

 This method is called on the error handler when an error occurs.
 If an exception is thrown from this method,
 it is considered to be equivalent of returning true.
 @param error
 @return
 
*/

public JsFunc<Boolean> handleError(DOMErrorJsr error){
        return call(Boolean.class, "handleError").with(error);
    }

    /**

 This method is called on the error handler when an error occurs.
 If an exception is thrown from this method,
 it is considered to be equivalent of returning true.
 @param error
 @return
 
*/

public JsFunc<Boolean> handleError(IValueBinding<? extends DOMErrorJsr> error){
        return call(Boolean.class, "handleError").with(error);
    }
    
    public static JsTypeRef<DOMErrorHandlerJsr> prototype = new JsTypeRef<DOMErrorHandlerJsr>(S);
}