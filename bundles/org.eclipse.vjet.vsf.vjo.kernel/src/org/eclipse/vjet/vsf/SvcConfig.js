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
* Represents the configuration object of a service.
*/
vjo.ctype('org.eclipse.vjet.vsf.SvcConfig') //< public
.protos({
	objType:null, //<public String
	url:null, //<public String
	method:null, //<public String
	reqtMarshalling:null, //<public String
	respMarshalling:null, //<public String
	async:true, //<public boolean
	timeout:0, //<public int
	operationName:null,
	typeMappingClassName:null,
	
	/**
	* Creates a instance of the service configuration object.
	*
	* @param {String} method
	*        A String represents the request method. Such as "GET" and "POST"
	* @param {String} url
	*        A String reprents the request target url
	* @constructs
	*/
	//>public constructs(String, String);
	constructs : function (method, url) {
		this.objType = "dsf_SvcConfig";
		this.svcType=null;
		this.url = url;
		this.method = method;
		this.reqtMarshalling = 'raw';
		this.respMarshalling = 'raw';
		this.async = true;
		this.timeout = 0;
	}
})
.endType();