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
/**
* An instance of the class which implements this interface can be safely 
* registered as a service response handler.
*/
vjo.itype('org.eclipse.vjet.vsf.common.IJsRespHandler')
.protos({
	/**
	* Callback function used by service engine to process a service message at 
	* the response phase
	*
	* @param {com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum} type \
	*        a message object to be processed by the handler.  
	*/
	//> public void handleResponse(com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum);
	handleResponse : function (type) {}
})
.endType();