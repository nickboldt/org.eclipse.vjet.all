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
* The default comparator to detect whether the two messages are duplicate.
*
* @see org.eclipse.vjet.vsf.common.IDedupComparable
*/
vjo.ctype("org.eclipse.vjet.vsf.service.DefaultDedupComparable")
.needs("org.eclipse.vjet.vsf.common.IDedupComparable")
.satisfies("org.eclipse.vjet.vsf.common.IDedupComparable")
.protos({

	//> public void constructs();
	constructs : function () {
	},
	//> public boolean shouldTrack(com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum); 
	shouldTrack : function (pMessage) {
		return true;
	},
	
	//> public boolean isDedup(com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum,com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum); 
	isDedup : function (pCurrentMessage, pMessage) {
	    var currentServiceId = pCurrentMessage.svcId;
	    var serviceId = pMessage.svcId;
	    if (currentServiceId === serviceId)
			return true;
		else 
			return false;
	}
})
.endType();