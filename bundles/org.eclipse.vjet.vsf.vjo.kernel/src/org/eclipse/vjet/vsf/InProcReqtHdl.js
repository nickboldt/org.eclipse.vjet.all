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
vjo.ctype('org.eclipse.vjet.vsf.InProcReqtHdl')
.satisfies('org.eclipse.vjet.vsf.ITransport')
.needs('org.eclipse.vjet.vsf.ServiceResponse')
.needs('org.eclipse.vjet.vsf.Message')
.protos({
	constructs : function () {
		this.svcHdls = {};
	},
	registerSvcHdl : function(svcId, handler) {
		this.svcHdls[svcId] = handler;
	},
	getSvcHdl : function(svcId) {
		return this.svcHdls[svcId];
	},
	//> public void handleRequest(Message message, Object? callback)
	handleRequest : function(message, callback) {
//		message.trace += '-->SvcHdl_' + message.svcId;
		if (!message.response) {
			message.response = new org.eclipse.vjet.vsf.ServiceResponse();
		}
		var handler = this.svcHdls[message.svcId];
		if (handler) {
			// changed to use message rather than message.request
			message.response.data = handler.invoke(message);
		}
		if (typeof message.status == 'undefined' || message.status == null) {
			message.status = 1; //back to response chain
		}
	}
})
.endType();
