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
 * The ServiceEngine passes messages through a configured set of handlers. 
 * Some handlers are specific to a particular service, some global, and 
 * some are transport related. Those handlers will be invoked in sequence on
 * service process chain. 
 * <p>
 * A service process chain shows as below:
 * <pre>
 *                        (REQUEST)
 *                      |           |
 *           -> SERVICE | TRANSPORT | GLOBAL \
 *         /            |           |         ->
 * LISTENER             |           |           SERVICE
 * 		   <-           |           |          /
 *            \ SERVICE | TRANSPORT | GLOBAL <-                            
 *                      |           |
 *                        (RESPONSE)
 * </pre>
 * <p>
 * A service can be registered on remote and also be avaliable on client side.
 * See the Ajax BinDox on how the ServiceEngine can communicate with the server's 
 * service engine via Ajax. On client, you can use the service engine for 
 * custom event listening. One component can fire an event (broadcast a message) 
 * while another can listen (has a handler registered and interested in that 
 * type of message) for the event.
 */
vjo.ctype('org.eclipse.vjet.vsf.ServiceEngine') //< public
.needs([
	'org.eclipse.vjet.vsf.InProcReqtHdl',
	'org.eclipse.vjet.vsf.RemoteReqtHdl',
	'org.eclipse.vjet.vsf.ServiceResponse',
	'org.eclipse.vjet.vsf.SvcConfig',
	'org.eclipse.vjet.vsf.XDomainRequest',
	'org.eclipse.vjet.vsf.Error',
	'org.eclipse.vjet.vsf.ServiceRegistry',
	'org.eclipse.vjet.vsf.SvcErr'])
//> needs(org.eclipse.vjet.vsf.Message)
//> needs(org.eclipse.vjet.vsf.ITransport)
.props({
	STATUS : {
		ABORT : -1,
		JUMP : 1
	},
	E:null, //< type::SvcErr
	svcReqtHdls : null, //< Array
	svcRespHdls : null, //< Array
	glbReqtHdls : null, //< Array
	glbRespHdls : null, //< Array
	trspReqtHdls : null, //< Array
	trspRespHdls : null, //< Array
	svcHdls : null, //< Array
	inProcHdl : null, //< InProcReqtHdl
	remoteHdl : null, //< RemoteReqtHdl
	//> public void init();
	init : function() {
		this.svcReqtHdls = [];
		this.svcRespHdls = [];
		this.glbReqtHdls = [];
		this.glbRespHdls = [];
		this.trspReqtHdls = [];
		this.trspRespHdls = [];
		this.inProcHdl = new this.vj$.InProcReqtHdl();
		this.remoteHdl = new this.vj$.RemoteReqtHdl();
		this.E = this.vj$.SvcErr;
		org.eclipse.vjet.vsf.ServiceRegistry.registerTransport('JSONP', new org.eclipse.vjet.vsf.XDomainRequest());
	},
	/**
	* Passes a messages through all handlers registered to handle this message. 
	* The message will be sent to remote server side if it is a remote request.
	* The handlers process the messeage in sequence till all handlers are invoked
	* or the flow is aborted.
	*
	* @param {Message} oMessage 
	*        A Message object to be passed
	* @return {boolean} 
	*        the returnData defined in the message 
	*/
	//> public boolean handleRequest(Message oMessage);
	handleRequest : function(m) {
		
		var rt, ab = this.STATUS.ABORT;
		
		if ((m.status != ab) && typeof rt == 'undefined') {
			rt = this.processServiceRequestHandlers(m);
		}	
		if ((m.status != ab) && typeof rt == 'undefined') {
			rt = this.processGlobalRequestHandlers(m);
		}
		if ((m.status != ab) && typeof rt == 'undefined') {
			this.processTransportHandlers(m);
		}	
		// remote requests will handle the response on their own
		// TODO better way to handle a response
		if ((m.status != ab) && ('Remote' != m.trspType || typeof rt != 'undefined')) {
			this.handleResponse(m, rt);
		}
		
		return m.returnData;
	},
	//> private String processServiceRequestHandlers(Message oMessage);
	processServiceRequestHandlers : function(oMessage){
		var rt, handlers = this.svcReqtHdls[oMessage.svcId];
		if (handlers) {	
			try {
				for (var i=0,len=handlers.length; i < len; i++) {
					oMessage.trace = oMessage.trace + '-->svcReqtHdl_' + i;
					handlers[i].handleRequest(oMessage);			
					if (oMessage.status == this.STATUS.JUMP) {
						rt = 'SVC';		
						this.err(oMessage,this.E.SvcRq,this.E.SvcRq);		
						break;
					}
				}
			} catch (e) {
				rt = 'SVC';
				this.err(oMessage,this.E.SvcRq,this.E.SvcRq);			
			}
		}
		return rt;
	},
	
	//> private String processGlobalRequestHandlers(Message oMessage);
	processGlobalRequestHandlers : function(oMessage){
		var rt;
		if (oMessage.status != this.STATUS.JUMP) {
		    try {
				for (var i=0, len=this.glbReqtHdls.length; i < len; i++) {
					oMessage.trace = oMessage.trace + '-->glbReqtHdl_' + i;
					this.glbReqtHdls[i].handleRequest(oMessage);			
					if (oMessage.status == this.STATUS.JUMP) {
						rt = 'GLB';
						this.err(oMessage,this.E.GlbRq,this.E.GlbRq);	
						break;
					}
				}
			} catch (e) {
				rt = 'GLB';
				this.err(oMessage,this.E.GlbRq,this.E.GlbRq);				
			}
		}
		return rt;
	},
	
	//> private void processTransportHandlers(Message oMessage);
	processTransportHandlers : function(oMessage){
		if (oMessage.status != this.STATUS.JUMP && oMessage.trspType) {
			// use transport if registered
			var transport = org.eclipse.vjet.vsf.ServiceRegistry.getTransport(oMessage.trspType); //< ITransport
			if (transport) {
				transport.handleRequest(oMessage, this.handleResponse);
			}
			else {
				// legacy
				var handlers = this.trspReqtHdls[oMessage.trspType];
				if (handlers) {	
				    try {
						for (var i = 0, len = handlers.length; i < len; i++) {
							oMessage.trace = oMessage.trace + '-->trspReqtHdl_' + i;
							handlers[i].handleRequest(oMessage);				
							if (oMessage.status == this.STATUS.JUMP) {
								this.err(oMessage,this.E.TrnRq,this.E.TrnRq);	
								break;
							}
						}
					} catch (e){
						this.err(oMessage,this.E.TrnRq,this.E.TrnRq);					
					}
				}
				
				if (oMessage.status!=this.STATUS.JUMP && oMessage.status!=org.eclipse.vjet.vsf.ServiceEngine.STATUS.ABORT) {
					if (oMessage.trspType == 'undefined'){
						this.err(oMessage,this.E.TrnRq,this.E.TrnRq);
					}
					else {
						// fallback to legacy transport
						if ('InProc' === oMessage.trspType) {
							this.inProcHdl.handleRequest(oMessage);
						} else if ('Remote' === oMessage.trspType){
							this.remoteHdl.handleRequest(oMessage);
						}		
					}
				}
			}
		}
	},
	//> public void handleResponse(Message msg);
	//> public void handleResponse(Message msg, String jumpto);
	handleResponse : function(msg, jumpto) {
		
		if (msg.trspType != 'undefined' && msg.trspType && typeof jumpto == "undefined") {
			// TEMP: remove after swf callback fix
//			msg.trspType = 'FLASH';
			this.processTransResponseHandlers(msg);
		}
		
		if (jumpto != 'SVC') {
			this.processGlobalResponseHandlers(msg);
		}
		this.processServiceResponseHandlers(msg);
	},
	
	//> private void processTransResponseHandlers(Message msg);
	processTransResponseHandlers : function(msg){
	
		var handlers = this.trspRespHdls[msg.trspType];
		try {
			if (handlers) {	
				for (var i = handlers.length - 1; i >= 0; i--) {
					msg.trace = msg.trace + '-->trspRespHdl_' + i;
					handlers[i].handleResponse(msg);				
				}
		    }
		} catch (e) {
	   		this.err(msg,this.E.TrnRsp,this.E.TrnRsp);	
		}
	},

	//> private void processGlobalResponseHandlers(Message msg);
	processGlobalResponseHandlers : function(msg){
		try {
			for (var i = this.glbRespHdls.length - 1; i >= 0 ; i--) {
				msg.trace = msg.trace + '-->glbRespHdl_' + i;
				this.glbRespHdls[i].handleResponse(msg);
			}
		} catch (e) {		
	   		 this.err(msg,this.E.GlbRsp,this.E.GlbRsp);	
		}
	},
			
	//> private void processServiceResponseHandlers(Message msg);
	processServiceResponseHandlers : function(msg){
		var applier;
		if (msg.clientContext) {
			applier = msg.clientContext.svcApplier;
		}
		try {
			if (applier) {
				if (typeof applier.onResponse == 'function') {
					applier.onResponse(msg);
				} else if (typeof applier == 'function') {
					applier(msg);
				}
			}
		} catch (e){
			this.err(msg,this.E.SvcRsp,this.E.SvcRsp);	
		}
		var handlers = this.svcRespHdls[msg.svcId];		
		if (handlers) {	
			try {		
				for (var i = handlers.length - 1; i >= 0; i--) {
					msg.trace = msg.trace + '-->svcRespHdl_' + i;	
					handlers[i].handleResponse(msg);		
				}
			} catch (e) {
				this.err(msg,this.E.SvcRsp,this.E.SvcRsp);
			}
		}			
	},	
	
	//> private Object createHandler(Object handler, String methodName);
	createHandler : function (handler,methodName) {
		if (typeof handler[methodName] != 'function') {
			if (typeof handler == 'function') {
				var func = handler, obj = {}, self = this;
				obj[methodName] = function () {
					return func.apply(self,arguments);
				};
				handler = obj;
			}
		}
		return handler;
	},
	
	/**
	* Registers a client side service. A non-remote message will invoke the 
	* service after go through all request handlers. Only one handler can be 
	* registered as a service per each service id.
	* <p>
	* To invoke the registered service. The property 'trspType' of the message
	* should be set as 'InProc'.
	*
	* @param {String} svcId 
	*        A string id represents the service
	* @param {Object} handler 
	*        A handler function to be registered as the service
	*/
	//> public void registerSvcHdl(String svcId, Object handler);
	registerSvcHdl : function(svcId, handler) {
		if (!svcId || !handler) {
			return;
		}
		handler = this.createHandler(handler,"invoke");
		this.inProcHdl.registerSvcHdl(svcId, handler);
	},
	
	/**
	* Gets the service handler registered on a service id. This handler is
	* registered by the function {@link #registerSvcHdl}
	*
	* @param {String} svcId 
	*        A String id represents the service
	* @return {Object} 
	*        A handler registered on this service
	* @see #registerSvcHdl
	*/
	//> public Object getSvcHdl(String svcId);
	getSvcHdl : function (svcId) {
		return this.inProcHdl.getSvcHdl(svcId);
	},

	/**
	* Registers a handler as service-specific request handler in service engine. 
	* The service-specific request handlers will be invoked at the begining of the
	* service process chain. Multiple handlers can be registered as service-specific
	* request handler. All these handlers should populate the message with relevent
	* data the target service will need.
	* 
	* @param {String} svcId 
	*        A String id represents the service
	* @param {Object} handler 
	*        A function to be registered as the service-specific request handler 
	*/
	//> public void registerSvcReqtHdl(String svcId, Object handler);
	registerSvcReqtHdl : function(svcId, handler) {
		if (!svcId || !handler) {
			return;
		}
		// failed to init
		if (!this.svcReqtHdls) {
			this.init();
		}
		if (typeof this.svcReqtHdls[svcId] == "undefined") {
			this.svcReqtHdls[svcId] = [];
		}
		var handlers = this.svcReqtHdls[svcId];
		handlers[handlers.length] = this.createHandler(handler,"handleRequest");
	},

	/**
	* Registers a handler as service-specific response handler in service engine.
	* The service-specific response handlers will be invoked at the end of the
	* service process chain. Multiple handlers can be registered as service-specific
	* response handler. All these handlers should be able to use the data provided
	* by the service.
	*
	* @param {String} svcId 
	*        A String id represents the service
	* @param {Object} handler 
	*        A function to be registered as the service-specific response handler
	*/
	//> public void registerSvcReqtHdl(String svcId, Object handler);
	registerSvcRespHdl : function(svcId, handler) {
		if (!svcId || !handler) {
			return;
		}
		if (typeof this.svcRespHdls[svcId] == "undefined") {
			this.svcRespHdls[svcId] = [];
		}
		var handlers = this.svcRespHdls[svcId];
		handlers[handlers.length] = this.createHandler(handler,"handleResponse");
	},

	/**
	* Registers a handler as global request handler in service engine. The global
	* request handler will have an opportunity to affect any service message that 
	* are sent to the service engine. It will be notified after all
	* service-specific request handlers are invoked.
	*
	* @param {Object} handler 
	*        A function to be registered as the global request handler
	*/
	//> public void registerGlbReqtHdl(Object handler);
	registerGlbReqtHdl : function(handler) {
		if (!handler) {
			return;
		}
		this.glbReqtHdls[this.glbReqtHdls.length] = this.createHandler(handler,"handleRequest");
	},

	/**
	* Registers a handler as global response handler in service engine. The global
	* response handler will have an opportunity to affect any service message that
	* are set to the service engine. It will be notified after all transport 
	* response handlers are invoked.
	*
	* @param {Object} handler 
	*        A function to be registered as the global response handler
	*/
	//> public void registerGlbRespHdl(Object handler);
	registerGlbRespHdl : function(handler) {
		if (!handler) {
			return;
		}
		this.glbRespHdls[this.glbRespHdls.length] = this.createHandler(handler,"handleResponse");
	},

	/**
	* Registers a handler as transport-specific request handler in service engine. 
	* The transport-specific request handler will have an opportunity to affect the
	* service message with the specified transport type. By default, there are two
	* transport-specific request handler, "InProc" is for client, and "Remote" is
	* for remote call. These handlers will be notified after all global request
	* handler are invoked.
	*
	* @param {String} transportType 
	*        A String represents the type of transport
	* @param {Object} handler 
	*        A function to be registered as the transport-specific request handler
	*/
	//> public void registerTrspReqtHdl(String transportType, Object handler);
	registerTrspReqtHdl : function(transportType, handler) {
		if (!transportType || !handler) {
			return;
		}
		if (typeof this.trspReqtHdls[transportType] == "undefined") {
			this.trspReqtHdls[transportType] = [];
		}
		// if not ITransport than use legacy
		if (!org.eclipse.vjet.vsf.ServiceRegistry.registerTransport(transportType, handler)) {
			var handlers = this.trspReqtHdls[transportType];
			handlers[handlers.length] = this.createHandler(handler,"handleRequest");
		}
	},
	
	/**
	* Registers a handler as transport-specific response handler in service engine. 
	* The transport-specific response handler will have an opportunity to affect the
	* service message with the specified transport type. These handlers will be 
	* notified at the beginning of the service response phase.
	*
	* @param {String} transportType 
	*        A String represents the type of transport
	* @param {Object} handler 
	*        A function to be registered as the transport-specific response handler
	*/
	//> public void registerTrspReqtHdl(String transportType, Object handler);
	registerTrspRespHdl : function(transportType, handler) {
		if (!transportType || !handler) {
			return;
		}
		if (typeof this.trspRespHdls[transportType] == "undefined") {
			this.trspRespHdls[transportType] = [];
		}
		var handlers = this.trspRespHdls[transportType];
		handlers[handlers.length] = this.createHandler(handler,"handleResponse");
	},
	//> private void err(Message msg, String errorId, String errorMsg);
	err : function(msg, errorId, errorMsg) {
	    if (!msg.response) {
	    	msg.response = new org.eclipse.vjet.vsf.ServiceResponse();
		}
	    if (msg.response.addError) {
	    	msg.response.addError(new org.eclipse.vjet.vsf.Error(errorId,errorMsg));
	    }
		else {
			// backwards compatibility logic here
			// add ServiceResponse.addError methods
	    	msg.response.addError =  org.eclipse.vjet.vsf.ServiceResponse.prototype['addError'];
		    // if non-object response, no place to set response error
		    if (msg.response.addError) {
		    	msg.response.addError(new org.eclipse.vjet.vsf.Error(errorId,errorMsg));
		    }
		}
	},
	
	//Helper method, used with code gen
	//> public void register(int pFuncType, String pServiceId, Object pHandler);
	register : function (pFuncType, pServiceId, pHandler) {
		var _s = org.eclipse.vjet.vsf.ServiceEngine; //DO NOT change it to 'this'
		switch (pFuncType) { 
			case 0:
				_s.registerSvcHdl(pServiceId, pHandler);
				break;
			case 1:
				_s.registerSvcReqtHdl(pServiceId, pHandler);
				break;
			case 2:
				_s.registerGlbReqtHdl(pServiceId, pHandler);
				break;
			case 3:
				_s.registerTrspReqtHdl(pServiceId, pHandler);
				break;
			case 4:
				_s.registerSvcRespHdl(pServiceId, pHandler);
				break;
			case 5:
				_s.registerGlbRespHdl(pServiceId, pHandler);
				break;
			case 6:
				_s.registerTrspRespHdl(pServiceId, pHandler);
				break;
		}
	}	
})
.inits(function(){
	this.init();
})
.endType();
