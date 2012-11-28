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
* JsonpTransport
* Sends the remote request across a domain.
*/
vjo.ctype('org.eclipse.vjet.vsf.XDomainRequest')
.satisfies('org.eclipse.vjet.vsf.ITransport')
.needs(['org.eclipse.vjet.vsf.EventDispatcher',
        'org.eclipse.vjet.vsf.ServiceEngine'])
//>needs org.eclipse.vjet.vsf.Message
.props({
	callbacks : [],
	sCallbackName : "callback",
	sPreId : "xdr_",
	sPreExtId : "xdr_ext_",
	iCount : 0,
	bUseIframe : (navigator.userAgent.indexOf('Firefox')>0),
	bodyLoaded: false, //< boolean
	//> public void onLoad();
	onLoad : function() {
		this.bodyLoaded = true;
	},
	
	//> private Object getReqDiv();
	getReqDiv : function () {
		return document.getElementsByTagName(this.bodyLoaded?"body":"head")[0];
	},
	
	/**
	* Sends the remote request. This function will create a JavaScript statement
	* in the page and embraced with <script> tag. The id of this tage will be 
	* returned by this function.
	*
	* @param {Object} req 
	*        A request object to be sent. It can be a message object or a request url
	* @return {String} 
	*        A String id represents the script tag created to execute sending 
	*        action in the page
	*/
	//> public String send(Object poReq);
	//> public String send(Object poReq, boolean pbBustCache);
	send : function (poReq) { //returns id of script tag. if you are using this outside of client service engine, you must
		//app must cleanup
		if (!document.createElement || !poReq) {	//not supported
			return;
		}
		var url = "", eid = "", rdm = '_vrdm='+(new Date()).getTime();
		if (typeof poReq == "string") {
			url = poReq;
			eid = this.sPreExtId + this.iCount++;
		} else if (poReq.objType=="dsf_Message" && poReq.svcConfig) {
			var cb = this.createCallback(poReq);
			eid = this.sPreId + this.callbacks[this.callbacks.length-1];
			url = poReq.svcConfig.url + "&callback=" + cb;
		}
		var frm = null, doc;
		doc = document;
		var scpt = this.createElement("script");
		scpt.async = true; //make it async call
		scpt.defer = true; //make it async call(older browsers)
		scpt.id = eid;
		scpt.type = 'text/javascript';
		var bustCache = true;
		if(arguments.length>1){
			bustCache = arguments[1];
		}
		if(bustCache){
			url = url + ((url.indexOf('?')==-1) ? '?' : '&') + rdm;
		}
		scpt.src = url; 		
		//scpt.src = url + ((url.indexOf('?')==-1) ? '?' : '&') + rdm;
		//this.getReqDiv().appendChild(scpt);
		//Making script call really asynchronous
		var that = this;
		window.setTimeout(function(){that.getReqDiv().appendChild(scpt);},0);
		return eid; //callback should call parent.cb for firefox. parent.cb should be safe regardless
	},
	
	//> private String createCallback(Object poMessage);
	createCallback : function (poMessage) {
		var len = this.callbacks.length, name = this.sCallbackName + len,
		eid = this.sPreId+name;
		this.callbacks[len] = name;
		this[name] = function (poResponse) {
			org.eclipse.vjet.vsf.XDomainRequest.loaded(eid);
			poMessage.response = poResponse;
			org.eclipse.vjet.vsf.ServiceEngine.handleResponse(poMessage);
		};
		//TODO: add scoping
		
		//var ver = vjo.getVersion(), rv = ((ver)?ver+".":"")+"org.eclipse.vjet.vsf.XDomainRequest."+name;
		var ver = "", rv = ((ver)?ver+".":"")+"org.eclipse.vjet.vsf.XDomainRequest."+name; //< String
		return rv;
	},
	
	//> private void loaded(String);
	loaded : function (psName) {
		var e = document.getElementById(psName);
		if (e !== null) {
			e.parentNode.removeChild(e);
		}
	},
	
	//> private HTMLElement createElement(String);
	createElement : function (psType) {
		return (typeof(createElementV4)!="undefined")?createElementV4(psType):document.createElement(psType);
	}
})
.protos({
    //> public void handleRequest(Message message, Object callback)
    handleRequest : function(message, callback){
 		org.eclipse.vjet.vsf.XDomainRequest.send(message);
 	}
})
.inits(function (){
	org.eclipse.vjet.vsf.EventDispatcher.addEventListener(window,"load",this.onLoad,this);
})
.endType();