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
import org.eclipse.vjet.vsf.jsbrowser.jsr.NodeJsr;
import org.eclipse.vjet.vsf.jsref.JsFunc;
import org.eclipse.vjet.vsf.jsref.JsObj;
import org.eclipse.vjet.vsf.jsref.JsObjData;
import org.eclipse.vjet.vsf.jsref.JsTypeRef;
import org.eclipse.vjet.vsf.jsref.internals.JsCmpMeta;

@org.eclipse.vjet.dsf.resource.utils.CodeGen("JsrGenerator")
public class UserDataHandlerJsr extends JsObj {
    private static final long serialVersionUID = 1L;

    private static final JsObjData S = 
        new JsObjData("UserDataHandler", UserDataHandlerJsr.class, "UserDataHandler");

    public UserDataHandlerJsr(){
        super(S.getJsCmpMeta(), true);
    }

    protected UserDataHandlerJsr(JsCmpMeta cmpMeta, boolean isInstance, Object... args) {
        super(cmpMeta, isInstance, args);
    }

    public JsFunc<Void> handle(short operation, String key, Object data, NodeJsr src, NodeJsr dst){
        return call("handle").with(operation, key, data, src, dst);
    }

    public JsFunc<Void> handle(IValueBinding<Short> operation, IValueBinding<String> key, IValueBinding<Object> data, IValueBinding<? extends NodeJsr> src, IValueBinding<? extends NodeJsr> dst){
        return call("handle").with(operation, key, data, src, dst);
    }
    
    public static JsTypeRef<UserDataHandlerJsr> prototype = new JsTypeRef<UserDataHandlerJsr>(S);
}