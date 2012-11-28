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
vjo.ctype('org.eclipse.vjet.vsf.FlashTransport')
.satisfies('org.eclipse.vjet.vsf.ITransport')
.needs(['org.eclipse.vjet.vsf.Error','org.eclipse.vjet.vsf.Message','org.eclipse.vjet.vsf.SvcConfig','org.eclipse.vjet.vsf.SvcErr',
'org.eclipse.vjet.vjo.util.Map'])
.protos({
	//> public void handleRequest(Message message, Object callback)
	handleRequest : function(message, callback) {
		
		var swf = document.getElementById("flash_proxy");
		// if flash object is specified on the page, use		
		if (swf == null) {
			// Log error
			return;
		}
		var cfg = message.svcConfig; //< org.eclipse.vjet.vsf.SvcConfig
		var requestUrl = cfg.url; //< String
	   try {
			var contentType;
			if (cfg.reqtMarshalling == 'SOAP') {
				contentType = "text/xml";
			} else {
				contentType = "application/json";
			}
			var svcConfigObj = {};
			svcConfigObj['async'] = cfg['async'];
			svcConfigObj['method'] = cfg['method'];
			svcConfigObj['objType'] = cfg['objType'];
			svcConfigObj['reqtMarshalling'] = cfg['reqtMarshalling'];
			svcConfigObj['respMarshalling'] = cfg['respMarshalling'];
			svcConfigObj['timeout'] = cfg['timeout'];
			svcConfigObj['url'] = cfg['url'];
			// heck
			svcConfigObj['flash'] = true;
			svcConfigObj['typeMappingClassName'] = message.typeMappingClassName;
			svcConfigObj['serviceName'] = message.svcName;
			svcConfigObj['operationName'] = message.opName;

			var header = {};
			if (message.svcConfig.svcType == 'SOA') {
		  		 // gyue: add SOA specific headers
		   		header = new Array();
		   		var i = 0;
		   		// populate the header array from message.headers
		   		for (var m in message.headers) {
					header[i] = {"name":m, "value":message.headers[m]};
					i++;
		   		}
			}

			// create a swf complaint request
			var request = {  serviceUrl: requestUrl,
				headers: header,
				data: message.rawRequest,
				contentType: contentType,
				callbackSvcId: message.svcId};
			swf.callback = function(response){
				message.response = {};
				message.response.data = {};
				message.response.data.documentElement = response.firstChild;
				callback.apply(this, new Array(message));
			}
			swf.onRemoteCall({request: request, svcConfig: svcConfigObj});
	   } catch(e) {
			var error = new org.eclipse.vjet.vsf.Error(); //< org.eclipse.vjet.vsf.Error
			error.id = org.eclipse.vjet.vsf.SvcErr.InvRq;
			error.message="Cannot open URL '"+requestUrl+"'";
			message.response.addError(error);
	 	}
	},
	// TEMP: remove after swf callback fix
	receive : function(message) {
	
		var vjoMessage = new org.eclipse.vjet.vsf.Message(message.svcConfig.serviceName, message.svcConfig.operationName); 
		vjoMessage.typeMappingClassName = message.svcConfig.typeMappingClassName;
		
		// copy vjo characteristics 
		var result = {}; 
		for (var i in vjoMessage) { 
			message[i] = vjoMessage[i]; 
		}	
	}
})
.endType();