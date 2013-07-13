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
 * Name value pair binding
 * serialize implemented only
 */
vjo.ctype('org.eclipse.vjet.vsf.NvBinding') //< public
.satisfies('org.eclipse.vjet.vsf.IBinding')
.needs('org.eclipse.vjet.vsf.Service')
.needs('org.eclipse.vjet.vsf.Enc')
//> needs org.eclipse.vjet.vsf.Message
.protos({
 	//>public String serialize(Message message) 
 	serialize : function(message){
 		message.rawRequest = org.eclipse.vjet.vsf.Service.generateReqParams(message) + org.eclipse.vjet.vsf.Enc.encodeURIComponent(message.request);
		return message.rawRequest;
	},
 	//>public void deserialize(Message message) 
 	deserialize : function( message){
 	}
})
.endType();