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
vjo.ctype('org.eclipse.vjet.vsf.SoapBinding') //< public
.satisfies('org.eclipse.vjet.vsf.IBinding')
.needs('org.eclipse.vjet.vjo.util.XmlJson')
.needs('org.eclipse.vjet.vjo.util.JsonVjo')
//< needs(org.eclipse.vjet.vsf.Message)
.protos({
	//>public String serialize(Message message)
	serialize : function(message) {
		var request = '';
		var requestObj = message.request;
		var reqtmarsh = message.svcConfig.reqtMarshalling;

	    // infer the typemapping class name
	    var index = message.request.vj$._class.lastIndexOf('.');
	    var packageName = message.request.vj$._class.substring(0, index);
	    var typeMappingClassName = packageName + "." + message.svcName + "TypeMappings";
		message.typeMappingClassName = typeMappingClassName;

		var TypeMappingClz = eval(typeMappingClassName);
		var namespace = TypeMappingClz.SERVICE_NAMESPACE;
		var className = requestObj.vj$._class;
		var rootElement = className.substring(className.lastIndexOf(".")+1);
		
		var xmlHeader = "<?xml version='1.0' encoding='UTF-8'?>";
			
		//SOAP. Add SOAP env/header/body container		
		var soapEnvBegin = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">";
		var soapHeader = "<soapenv:Header/>";
		var soapBodyBegin = "<soapenv:Body>";	   
		
		request = xmlHeader + soapEnvBegin + soapHeader + soapBodyBegin;
			
		var upper = message.upperCaseElementName;
		// serialize body
		request = request + vjo.util.XmlJson.json2xml(namespace, requestObj,upper);
			
		// close SOAP container
		var soapBodyEnd = "</soapenv:Body>";
		var soapEnvEnd = "</soapenv:Envelope>";
		request = request + soapBodyEnd + soapEnvEnd;

	    message.rawRequest =  request;
	    return request;
	},
	//> public void serialize(Message)
	deserialize : function(message) {
		// lookup the response type name from TypeMappings (from message)
		var TypeMappingClz = eval(message.svcConfig.typeMappingClassName);
		var TypeMappingObj = new TypeMappingClz();
		var typeName = TypeMappingObj.getResponseTypeName(message.svcConfig.operationName);

		var soapEnv = message.response.data;
		var xmlDoc;
		
		// for SOAP, unwraps the SOAP env/header/body container
		if (typeof(soapEnv) == "string") {
			// soap Env as string
			var startTag = "<soapenv:Body>";
			var startIndex = soapEnv.indexOf(startTag) + startTag.length;
			var endTag = "</soapenv:Body>"
			var endIndex = soapEnv.indexOf(endTag);
			var xmlStr = soapEnv.substring(startIndex, endIndex);
			// convert xmlStr to a DOM object
			xmlDoc = (new DOMParser()).parseFromString(xmlStr, "text/xml"); //< @SUPPRESSTYPECHECK
 	
		} else {
			// soap Env as DOM
			xmlDoc = soapEnv.documentElement.childNodes[1].childNodes[0];   
		}
		
   		var jsonStr = vjo.util.XmlJson.xml2json(xmlDoc, "");
		   
		// convert JSON string to VJO object
		message.response.data = vjo.util.JsonVjo.json2vjo(jsonStr, typeName);
	}
})
.endType();