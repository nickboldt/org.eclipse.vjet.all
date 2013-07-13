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
* registered as event handler.
*/
vjo.itype('org.eclipse.vjet.vsf.common.IJsHandler')
.protos({
	/**
	* Callback function used to process a triggered event.
	*
	* @param {com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum} type 
	*        an event object to be processed by the handler.  
	*/
	//> public void handle(com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum);
	handle : function (type) {}
})
.endType();