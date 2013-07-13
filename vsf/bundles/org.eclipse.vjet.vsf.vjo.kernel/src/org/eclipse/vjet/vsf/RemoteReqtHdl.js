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
vjo.ctype('org.eclipse.vjet.vsf.RemoteReqtHdl') //< public
.satisfies('org.eclipse.vjet.vsf.ITransport')
.needs(['org.eclipse.vjet.vsf.SvcErr',
'org.eclipse.vjet.vsf.ServiceRegistry',
'org.eclipse.vjet.vsf.ServiceResponse',
'org.eclipse.vjet.vsf.ServiceEngine'
        ])
//> needs org.eclipse.vjet.vsf.IBinding, org.eclipse.vjet.vsf.ITransport, org.eclipse.vjet.vsf.Message
.protos({
	//> public void handleRequest(Message message, Object callback)
	handleRequest : function(message, callback) {
//		message.trace += '-->RemoteHdl_' + message.svcId;
		message.response = new org.eclipse.vjet.vsf.ServiceResponse(); //< ServiceResponse
		// svcConfig is required
		if (!message.svcConfig) {
	   		org.eclipse.vjet.vsf.SvcErr.err(message, org.eclipse.vjet.vsf.SvcErr.InvRq, "message.svcConfig is undefined")
			return;
		}
		// get binding
		var binding = org.eclipse.vjet.vsf.ServiceRegistry.getBinding(message.svcConfig.reqtMarshalling); //< IBinding
		if (binding){
			binding.serialize(message);
		}
		else {
			// no binding error
			org.eclipse.vjet.vsf.SvcErr.err(message, org.eclipse.vjet.vsf.SvcErr.InvRqBnd, "reqtMarshalling=" + message.svcConfig.reqtMarshalling);
		}
		this.invoke(message);	
	},
	//> private void invoke(Message message);
	invoke : function(message) {
		// use transport if registered then return
		// JSCALLBACK uses JSONP transport
		var tT = ((message.svcConfig.respMarshalling == 'JSCALLBACK')?'JSONP':'XHR');
		var t = org.eclipse.vjet.vsf.ServiceRegistry.getTransport(tT); //< ITransport
		if (t) {
			t.handleRequest(message, this.callback);
		}
	},
	//> public void callback(Message message);
	callback: function (message) {
		try {
			var binding = org.eclipse.vjet.vsf.ServiceRegistry.getBinding(message.svcConfig.respMarshalling); //< IBinding
			if (binding){
				binding.deserialize(message);
			}
			else {
				org.eclipse.vjet.vsf.SvcErr.err(message, org.eclipse.vjet.vsf.SvcErr.InvRspBnd, "marshalling=" + message.svcConfig.respMarshalling + ":responseText=" + message.response);
			}
		} catch (e) {
			org.eclipse.vjet.vsf.SvcErr.err(message, org.eclipse.vjet.vsf.SvcErr.InvRsp, "marshalling=" + message.svcConfig.respMarshalling + ":responseText=" + message.response);
		}
		// TODO review if commented out then DapSample works
		org.eclipse.vjet.vsf.ServiceEngine.handleResponse(message);
	}
})
.endType();