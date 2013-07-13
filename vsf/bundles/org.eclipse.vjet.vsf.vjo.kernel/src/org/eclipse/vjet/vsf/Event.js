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
* Represents a VJO event reference which wraps the DOM native Event
* object. 
*/
vjo.ctype('org.eclipse.vjet.vsf.Event')
.protos({
	src : null,
	eventType : null,
	nativeEvent : null,
	
	/**
	* Creates an event instance by given element, type of event and the 
	* browser's native event object.
	* 
	* @param {Object} src 
	*        An element which emit the event
	* @param {String} eventType 
	*        An event type of this event
	* @param {com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum} event 
	*        A browser's native event object
	* @constructor
	*/
	//> public void constructs(Object, String, com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum);
	constructs : function (src, eventType, pEvent) {
		this.src = src;
		this.eventType = eventType;
		this.nativeEvent = pEvent;
	}
})
.endType();