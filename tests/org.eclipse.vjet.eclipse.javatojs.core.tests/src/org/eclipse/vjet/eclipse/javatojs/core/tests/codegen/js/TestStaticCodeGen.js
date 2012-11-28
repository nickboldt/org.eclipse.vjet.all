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
/* @org.eclipse.vjet.dsf.resource.utils.CodeGen("VjoGenerator") */
vjo.ctype("com.ebay.darwin.codegen.js.TestStaticCodeGen")
.props({
	/**
	 * @JsReturnType int
	 * @JsJavaAccessToJs public
	 * @JsParamType message JsMessage
	 * @JsParamType pNumber int
	 * @JsRequestHandler
	 * 
	*/
    //> public int reqMyService(JsMessage message,int pNumber)
	reqMyService : function(message,pNumber){
		alert("page listener before service: " + message.svcId + " pNumber = " + pNumber);
		return message;
	},

	/**
	 * @JsReturnType int
	 * @JsJavaAccessToJs public
	 * @JsResponseHandler
	 * @JsParamType message JsMessage
	 * 
	*/
    //> public int respondToMyService(JsMessage message)
	respondToMyService : function(message){
		alert("page listener after service: " + message.svcId);
		return message;
	}
})
.endType();
