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
* Detects if triggered message is duplicate and keeps it single if required.
* This handler could be registered in ServiceEngine if you want keep the message
* as singleton.
* 
* @see org.eclipse.vjet.vsf.common.IJsRespHandler
* @see org.eclipse.vjet.vsf.common.IJsReqHandler
*/
vjo.ctype("org.eclipse.vjet.vsf.service.DedupServiceHandler")
.needs(["org.eclipse.vjet.vsf.Message",
	"org.eclipse.vjet.vsf.ServiceEngine",
	"org.eclipse.vjet.vsf.common.IJsRespHandler",
	"org.eclipse.vjet.vsf.common.IJsReqHandler",
	"org.eclipse.vjet.vsf.common.IDedupComparable"])
.satisfies("org.eclipse.vjet.vsf.common.IJsRespHandler")
.satisfies("org.eclipse.vjet.vsf.common.IJsReqHandler")
.protos({
	STATUS : {
		ABORT : org.eclipse.vjet.vsf.ServiceEngine.STATUS.ABORT,
		JUMP : org.eclipse.vjet.vsf.ServiceEngine.STATUS.JUMP
	},
	
	/**
	* Creates instance of the handler. You must specify a comparator which
	* implements <code>org.eclipse.vjet.vsf.common.IDedupComparable</code>. The handler uses
	* this comparator to decide if message should be tracked as singleton and if
	* it is duplicate. 
	* 
	* @param {org.eclipse.vjet.vsf.common.IDedupComparable} comparable
	*        The comparator used by the handler
	* @see   org.eclipse.vjet.vsf.common.IDedupComparable
	*/
	//> public void constructs(org.eclipse.vjet.vsf.common.IDedupComparable);
	constructs : function (comparable) {
	    this.messages = [];
	    this.oComparable = comparable;
	},
			
	//> public void handleRequest(com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum);	
	handleRequest : function(message) {
		if(!this.oComparable.shouldTrack(message)) {
		    return;
		} 
		var msgs = this.messages;
		for (var i = 0; i < msgs.length; i++) {
		    var msg = msgs[i];
		    if (this.oComparable.isDedup(msg,message)) {
		        //alert("Message is duplicate");		   
		        message.status = this.STATUS.ABORT;
		        return;
		    }
		}
		this.messages[this.messages.length] = message;
	},
		
	//> public void handleResponse(com.ebay.dsf.resource.html.event.handler.JsHandlerObjectEnum);	
	handleResponse : function( message) {
        var temp = [], len = this.messages.length;
        for (var i=0; i<len; i++) {
            if (message != this.messages[i]) {
                temp[temp.length] = this.messages[i];
             }
         }
         this.messages = temp;
	}		
})
.endType();