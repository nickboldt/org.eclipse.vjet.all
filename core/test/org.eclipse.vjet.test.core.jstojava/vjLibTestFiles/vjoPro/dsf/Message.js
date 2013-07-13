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
* Represents a message reference.
* <p>A message could bring properties used by service handler. Some of them are 
* important and would be defined when a message is new created,
* 	<li>svcId - A service id this message is targeting to
* 	<li>request - 
* 	<li>response - org.eclipse.vjet.vsf.ServiceResponse
* 	<li>clientContext -
* 	<li>trspType - constant from org.eclipse.vjet.vsf.ITransport
* 	<li>returnData -
*   <li>v - version
*   <li>svcName - web service name
*   <li>opName - web service operation name
*   <li>stok - tracking param
*   <li>pId - tracking param
*/
vjo.ctype('vjoPro.dsf.Message') //<public dynamic
//> needs org.eclipse.vjet.vsf.ServiceResponse, org.eclipse.vjet.vsf.SvcConfig
.protos({
	objType : 'dsf_Message', //< public final String
	//> public String trspType
	trspType : '',
	//> public String svcId
	svcId : '',
	//> public Object request
	request : null,
	//> public ServiceResponse response
	response : null,
	//> public int status
	status : null,
	//> public SvcConfig svcConfig
	svcConfig : null,
	//> public String stok
	stok : '',
	//> public String pId
	pId : '',
    //> public constructs(String, String?)
	constructs : function (svcId, opName) {
    	var a = arguments, l = a.length;
		if(l==1){
            this.svcId = svcId;
        } else if(l==2){
            this.svcId = svcId + "."  + opName;
            this.svcName = svcId;
			this.opName = opName;
        }
		this.rawRequest = this.trace = "";
		this.clientContext = {};
		this.trspType = 'InProc';
		this.returnData = true;
		this.v = '0';
		this.headers = null;
	}
})
.endType();