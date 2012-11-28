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

vjo.ctype('org.eclipse.vjet.vsf.Service') //< public
.needs(['org.eclipse.vjet.vsf.ServiceResponse',
	'org.eclipse.vjet.vsf.Enc',
	'org.eclipse.vjet.vsf.SvcErr',
	'org.eclipse.vjet.vsf.ServiceEngine',
	'org.eclipse.vjet.vsf.ServiceRegistry'])
//> needs org.eclipse.vjet.vsf.IBinding, org.eclipse.vjet.vsf.Message
.props({
	clientInfo:null, //<String
	E:null, //< type::SvcErr
	//> public void callback(Object xmlHttpReq, Message message);
	callback : function (xmlHttpReq, message) {
		if (xmlHttpReq.readyState != 4) {
			return;
		}
		message.response = new org.eclipse.vjet.vsf.ServiceResponse();
		try {
			if (xmlHttpReq.status >= 200 && xmlHttpReq.status < 300 ) {
				message.response.data = xmlHttpReq.responseText;
				var binding = org.eclipse.vjet.vsf.ServiceRegistry.getBinding(message.svcConfig.respMarshalling); //<<IBinding
				if (binding){
					// update message.response
					binding.deserialize(message);
					message.status = 1; //back to response chain
				}
				else {
					// no binding error
					this.E.err(message, this.E.InvRspBnd, "respMarshalling=" + message.svcConfig.respMarshalling);
				}
			} else { //protocol error
				//attach to message and send to handler
	   			var errorId = this.E.RqUnk;
	   			if (404 === xmlHttpReq.status) {
	   				errorId = this.E.SvcPrc;
	   			}
	   			this.E.err(message, errorId, "status=" + xmlHttpReq.status + ":readyState=" + xmlHttpReq.readyState);
			}
		}
		catch (e) {//app error
	   		this.E.err(message, this.E.RqUnk, "status=" + xmlHttpReq.status + ":readyState=" + xmlHttpReq.readyState);
		}
		org.eclipse.vjet.vsf.ServiceEngine.handleResponse(message);
		delete xmlHttpReq.onreadystatechange;
		xmlHttpReq = null;
	},
	//> public Object getXmlHttpReq();
	getXmlHttpReq : function () {
		//Re-order the code based on popularity of the browsers
		var o = null;
		//XMLHttpRequest first since it's available in most of modern browsers
		if (typeof XMLHttpRequest != 'undefined') {
		    o = new XMLHttpRequest();
		} else {
			if (window.ActiveXObject) {
			    try {
			    	o = new ActiveXObject("Microsoft.XMLHTTP");
			    } catch (e) {
		            o = new ActiveXObject("Msxml2.XMLHTTP");
			    }
		    }
		}
		return o;
	},
	//> private String getClientInfo();
	getClientInfo : function () {
	//returns Browser|Version|[Env] used by V4Services
	//use browser util, once vjlib moves to dsf
		if (this.clientInfo) {
			return this.clientInfo;
		}
		var nv = navigator, agt = nv.userAgent.toLowerCase(), i = 0, ver=0, b="";
		if (agt.indexOf("firefox")!=-1) {
			b = "Firefox";
			i = agt.lastIndexOf("firefox") + 8;
		}
		else if ((/webkit|khtml/).test(agt)) {
			b = "Safari";
			i = agt.lastIndexOf("safari") + 7;
		} else if(typeof(window.opera)!="undefined") {
			b = "Opera";
			i = agt.lastIndexOf("opera") + 6;
		}
		else if (nv.appName == "Netscape") {
			b = "Netscape";
			i = agt.lastIndexOf("/") + 1;
		}
		else if (agt.indexOf("msie")!=-1) {
			b = "IE";
			i = agt.indexOf("msie") + 4;
		}
		if (b) ver = parseInt((b=="Opera")?window.opera.version():agt.substring(i));
		
		this.clientInfo = b+":"+ver+":"
		return this.clientInfo;
	},
	//> public String generateReqParams(Message message);
	generateReqParams : function(message) {
		var requestParams = 'svcid=' + org.eclipse.vjet.vsf.Enc.encodeURIComponent(message.svcId);
		// tracking params
		if (message.stok) {
			requestParams += '&stok=' + message.stok; 
		}
		if (message.pId) {
			requestParams += '&pId=' + message.pId;
		}
		if (message.v) {
			requestParams += '&v=' + message.v;
		}
		
		var ma = message.svcConfig.reqtMarshalling;
		requestParams += '&reqttype=' + ma + '&resptype=' + message.svcConfig.respMarshalling;
		requestParams += '&clientType=' + this.getClientInfo();
		requestParams += '&request=';	
		if ('JSCALLBACK' == ma){
	    	requestParams += org.eclipse.vjet.vsf.Enc.encodeURIComponent(JSON.stringify(message.request));//< @SUPRESSTYPECHECK
	    }
	    return requestParams;
	}
})
.inits(function(){
	this.E = this.vj$.SvcErr;
})
.endType();