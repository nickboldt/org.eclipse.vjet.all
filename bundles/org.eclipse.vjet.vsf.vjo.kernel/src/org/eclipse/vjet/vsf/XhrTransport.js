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
vjo.ctype('org.eclipse.vjet.vsf.XhrTransport') //< public
.satisfies('org.eclipse.vjet.vsf.ITransport')
.needs(['org.eclipse.vjet.vsf.Service',
        'org.eclipse.vjet.vsf.ServiceEngine',
        'org.eclipse.vjet.vsf.SvcErr',
        'org.eclipse.vjet.vsf.assembly.VjClientAssembler'
        ])
//< needs(org.eclipse.vjet.vsf.Message)
.protos({
	processed : [], //< boolean[]
	timerCount : 0, //< int
	reqTimers : [], //< int[]
 	//>public void handleRequest(Message message, Object callback) 
 	handleRequest : function(message, callback){
// 		message.trace += '-->XhrTransport' + message.svcId;
 		this.remoteTrspHdl(message);
		var svc = org.eclipse.vjet.vsf.Service, 
		xmlHttpReq = svc.getXmlHttpReq(), 
		requestUrl = this.appendPort80ForSafari(document.location.href, message.svcConfig.url),
		cfg = message.svcConfig;
		message.status = -1; //do not handle Response. Ajax call will handle response
		
		try {
			var async = (cfg.async === false) ? false : true;
			xmlHttpReq.open(cfg.method, requestUrl, async);
			var idx = this.timerCount++;
			if (async) {
				this.setupReadyState(xmlHttpReq,message,idx);
			}
		    
		    if (cfg.method == 'POST') {
		    	xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		    	xmlHttpReq.setRequestHeader('Content-Length', message.rawRequest.length);
		
				if (message.headers !== 'undefined' && message.headers) {
				   // populate HttpReq header from message.headers
				   for (var m in message.headers) {
				      xmlHttpReq.setRequestHeader(m, message.headers[m]);
				   }
					
				}
		    	xmlHttpReq.send(message.rawRequest); 	   	
		    }
		    else {
		    	xmlHttpReq.send(null);
		    }
			if (!async && !this.checkAndSetProcessed(idx)) {
				org.eclipse.vjet.vsf.Service.callback(xmlHttpReq, message);
			} else if (cfg.timeout) { //default is 0. do not set timeout, if not defined
		    	var _this = this;
		    	this.reqTimers[idx] = window.setTimeout(function () { _this.timeout(xmlHttpReq,message,idx); },cfg.timeout)
		    }
		}
		catch (e) {
			org.eclipse.vjet.vsf.SvcErr.err(message, org.eclipse.vjet.vsf.SvcErr.InvRq, "Cannot open URL '" + requestUrl + "'");
		}
 	},
	//> private void setupReadyState(Object xmlHttp, Message message, String idx);
	setupReadyState : function (xmlHttp,message,idx) {
		var _this = this;
		xmlHttp.onreadystatechange = function() {
	    	if (xmlHttp.readyState != 4 || _this.checkAndSetProcessed(idx)) {
				return;
			}
			var timer = _this.reqTimers[idx];
			if (timer) {//clear timeout
				window.clearTimeout(timer);
				delete _this.reqTimers[idx];
			}
	    	org.eclipse.vjet.vsf.Service.callback(xmlHttp, message);
	    }
	},
	//> public void timeout(Object xmlHttp, Message message, String idx);
	timeout : function (xmlHttp,message,idx) {
		if (this.checkAndSetProcessed(idx)) {
			return;
		}
		delete xmlHttp.onreadystatechange;
		xmlHttp.abort();
		delete this.reqTimers[idx];
		org.eclipse.vjet.vsf.SvcErr.err(message, org.eclipse.vjet.vsf.SvcErr.TO, "Timed out:" + message.svcConfig.timeout); 
   		org.eclipse.vjet.vsf.ServiceEngine.handleResponse(message);
	},
	//> private boolean checkAndSetProcessed(String idx);
	checkAndSetProcessed : function(idx) {
		if (this.processed[idx]) {
			return true;
		}
		this.processed[idx] = true;
		return false;
	},
	//> private void remoteTrspHdl(Message message);
	remoteTrspHdl : function (message) {//default v4 remote transport handler
		//NOTE: if there are any "this" references in this method, there may be problems.
		//will need to register with some scope
		var cfg = message.svcConfig;
		if (!cfg || cfg.objType!="dsf_SvcConfig") { //create other svc cfg for existing urls
			return;
		} else if (cfg.respMarshalling == 'JSCALLBACK') {//client assembler
			if (typeof org.eclipse.vjet.vsf.assembly != 'undefined' 
				&& typeof org.eclipse.vjet.vsf.assembly.VjClientAssembler != 'undefined' 
				&& !org.eclipse.vjet.vsf.assembly.VjClientAssembler.bBodyLoaded) {
				org.eclipse.vjet.vsf.assembly.VjClientAssembler.load(message);
				message.status = -1;
				return;
			}
		}
		
		if (message.request && message.request.javaClass) {
			delete	message.request.b; //remove this.b from vjo type before serialization
		}
		var svc = org.eclipse.vjet.vsf.Service, requestUrl = cfg.url;
	    if (message.svcConfig.method == 'GET') {
	    	var sep = (requestUrl.indexOf('?') == -1) ? '?':'&';
	    	requestUrl = requestUrl + sep + message.rawRequest;
	    }  else if (!message.rawRequest) {
	    	// FIXME review and remove 
	    	var payload = svc.generateReqParams(message);
	    	message.rawRequest = payload;
	    }
	    //if (message.svcConfig.respMarshalling == 'JSCALLBACK') {
	   		//requestUrl += "&callback="+org.eclipse.vjet.vsf.XDomainRequest.createCallback(message);
	    //}
	    message.svcConfig.url = requestUrl;
	},
	//> private String appendPort80ForSafari(String hrefUrl, String requestUrl);
	appendPort80ForSafari : function(hrefUrl, requestUrl){
		try{
			if(navigator.userAgent.toLowerCase().indexOf('safari') >= 0){//check if browser is safari
				var regex = '(([^:]*)://([^:/?]*)(:([0-9]+))?)?([^?#]*)([?]([^#]*))?(#(.*))?',
				ajaxUrl = requestUrl,
				safariIssuePort = '80';
			    var hrefUrlMatch = hrefUrl.match(regex);
			    if(hrefUrlMatch && hrefUrlMatch.length >= 5 && hrefUrlMatch[5] && hrefUrlMatch[5] == safariIssuePort){//port number is 80
			      var ajaxUrlMatch = ajaxUrl.match(regex);
				  if(ajaxUrlMatch && ajaxUrlMatch[2] && ajaxUrlMatch[2].length > 0){//request url is absolute
				     if(ajaxUrlMatch[5] && ajaxUrlMatch[5].length > 0){//request url has explicit port number
				        //explicit port number exists
				     }
				     else{//inject :80 to the request url
				        var requestUrlWithPort = '';
				        if(ajaxUrlMatch[2]){
				           requestUrlWithPort += ajaxUrlMatch[2] + '://';
				        }
				        if(ajaxUrlMatch[3]){
				           requestUrlWithPort += ajaxUrlMatch[3] + ':' + safariIssuePort;
				        }
				        if(ajaxUrlMatch[6]){
				           requestUrlWithPort += ajaxUrlMatch[6];
				        }
				        if(ajaxUrlMatch[8]){
				          requestUrlWithPort += '?' + ajaxUrlMatch[8];
				        }
				        if(ajaxUrlMatch[10]){
				          requestUrlWithPort += '#' + ajaxUrlMatch[10];
				        }
				        requestUrl = requestUrlWithPort;
				     }
				    }
				 }
			}
		}
		catch(e){
		}
		return requestUrl;
	}
})
.endType();