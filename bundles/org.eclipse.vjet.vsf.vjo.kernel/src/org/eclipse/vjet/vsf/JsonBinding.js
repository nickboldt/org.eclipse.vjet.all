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
 * org.eclipse.vjet.vsf.Json is added outside of type since it's
 * not a vjo object, and will not notify it's loaded.
 * inits block will only init once all dependencies are
 * loaded. specify a global needs for any non vjo dependencies.
 */
vjo.needs("org.eclipse.vjet.vsf.Json");
vjo.ctype('org.eclipse.vjet.vsf.JsonBinding') //< public
.satisfies('org.eclipse.vjet.vsf.IBinding')
.needs('org.eclipse.vjet.vsf.Error')
.needs('org.eclipse.vjet.vsf.SvcErr')
.needs('org.eclipse.vjet.vsf.Message')
.needs('org.eclipse.vjet.vjo.util.List')
.needs('org.eclipse.vjet.vjo.util.Map')
.needs('org.eclipse.vjet.vsf.ServiceResponse')
.needs('org.eclipse.vjet.vsf.Service')
.needs('org.eclipse.vjet.vsf.Enc')
.protos({
 	//>public String serialize(Message message) 
 	serialize : function(message){
 		var request = '';
    	request += org.eclipse.vjet.vsf.Service.generateReqParams(message);
    	request += org.eclipse.vjet.vsf.Enc.encodeURIComponent(JSON.stringify(message.request));//< @SUPRESSTYPECHECK
		message.rawRequest = request;
	    return request;
 	},
 	//>public void deserialize(Message message) 
 	deserialize : function(message){
		// TODO integrate new TypeMappingClz or create new binding
		// lookup the response type name from TypeMappings (from message)
//		var TypeMappingClz = eval(message.svcConfig.typeMappingClassName);
//		var TypeMappingObj = new TypeMappingClz();
//		var responseTypeName = TypeMappingObj.getResponseTypeName(message.svcConfig.operationName);
		var respStr = message.response.data;
		try {
				message.response = eval("("+respStr+")");
				// backwards compatibility logic here
				// add ServiceResponse.addError methods
				this.addMethods(message.response,org.eclipse.vjet.vsf.ServiceResponse.prototype.addError);
				// javaclass hint is used then use default binding
				if (message.response.data) {
					this.processObj(message.response.data);
				}
		} catch (e) {
			//JSON Parse error
			//attach to message and send to handler
			var error = new org.eclipse.vjet.vsf.Error();
			error.id = org.eclipse.vjet.vsf.SvcErr.Prs;
			error.message = "marshalling=" + message.svcConfig.respMarshalling + ":responseText=" + respStr;
			message.response.addError(error);
		}

 	},
	//> private void processObj(Object obj);
	processObj : function (obj) {
		var hint = obj.javaClass;
		if (hint && hint.length>0) {
			if (/java.util.([^\s])*List/.test(hint)) {
				this.addMethods(obj,vjo.util.List.prototype);
			} else if (/java.util.([^\s])*Map/.test(hint)) {
				this.addMethods(obj,vjo.util.Map.prototype);
			}
		}
	},
	//> private void addMethods(Object obj, Object methods);
	addMethods : function (obj,methods) {
		for (var key in methods) {
			obj[key] = methods[key];
		}
	}
})
.endType();