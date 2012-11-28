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
* Tracks duplicate messages. <code>org.eclipse.vjet.vsf.service.DedupServiceHandler</code> 
* uses this as a comparator to check whether the two messages are duplicate.
*/
vjo.itype('org.eclipse.vjet.vsf.common.IDedupComparable')
.protos({
	/**
	* Checks whether the given message is allowed to be duplicate.
	*
	* @param {com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum} message
	*        a message to be checked
	* @return {boolean}
	*        <code>true</code> if this message is not allowed to be duplicate
	*/
	//> public boolean shouldTrack(com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum);
	shouldTrack : function (message) {},
	
	/**
	* Checks whether the two messages are duplicate.
	*
	* @param {com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum} currentDsfMsg
	*        the current message to be compared
	* @param {com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum} dsfMsg
	*        Another message to be compared from
	* @return {boolean}
	*        <code>true</code> if two messages are duplicate
	*/
	//> public boolean isDedup(com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum,com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum);
	isDedup : function (currentDsfMsg, dsfMsg) {}
})
.endType();