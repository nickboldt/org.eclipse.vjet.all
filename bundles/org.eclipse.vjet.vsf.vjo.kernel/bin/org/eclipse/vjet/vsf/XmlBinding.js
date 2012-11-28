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
vjo.ctype('org.eclipse.vjet.vsf.XmlBinding') //< public
.satisfies('org.eclipse.vjet.vsf.IBinding')
.needs('org.eclipse.vjet.vsf.Message')
.needs('org.eclipse.vjet.vjo.util.XmlVjo')
.needs('org.eclipse.vjet.vjo.util.XmlJson')
.protos({
	//>public String serialize(Message message)
	serialize : function(message) {
	
		if (message.svcConfig.reqtMarshalling != 'XML'){
			return;
		}
		
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

		var upper = message.upperCaseElementName;
		
		// serialize body
		request = xmlHeader + vjo.util.XmlJson.json2xml(namespace, requestObj,upper);
//    	requestParams += org.eclipse.vjet.vsf.Enc.encodeURIComponent(this.xmlize(request, "Request", ''));
	    message.rawRequest =  request;
	    return request;
	},
	//> public void serialize(Message)
	deserialize : function(message) {
	
		if (message.svcConfig.respMarshalling != 'XML') {
			return;
		}
		
		var respStr = message.response;
		
		// lookup the response type name from TypeMappings (from message)
		var TypeMappingClz = eval(message.svcConfig.typeMappingClassName);
		var TypeMappingObj = new TypeMappingClz();
		var responseTypeName = TypeMappingObj.getResponseTypeName(message.svcConfig.operationName);
		
		message.response = vjo.util.XmlVjo.xml2vjo(respStr, responseTypeName);
	}
	//> private String xmlize(Object anyObject, String objectName, String indentSpace);
//	xmlize : function (anyObject, objectName, indentSpace) {
//		indentSpace = indentSpace ? indentSpace : '';
//	    var s = indentSpace  + '<' + objectName + '>';
//	    if (!(anyObject instanceof Object) || anyObject instanceof Number || anyObject instanceof String 
//	        || anyObject instanceof Boolean || anyObject instanceof Date) {
//	        s += this.escape("" + anyObject);
//	    } else{
//	        s += "\n";
//	        var isArrayItem = anyObject instanceof Array;
//	        for (var name in anyObject) {
//	        	if (isArrayItem && name == '______array') {
//	        		continue;
//	        	}       	
//	            s += this.xmlize(anyObject[name], (isArrayItem?"array-item key=\""+name+"\"":name), indentSpace + "   ");
//	        }
//	        s += indentSpace;
//	    };
//	    return s += (objectName.indexOf(' ')!=-1?"</array-item>\n":"</" + objectName + ">\n");
//	},
	//> private String escape(String sXml);
//	escape : function(sXml) {
//	    return sXml.replace(/&/g, "&amp;")
//	        .replace(/</g, "&lt;")
//	        .replace(/>/g, "&gt;")
//	        .replace(/"/g, "&quot;")
//	        .replace(/'/g, "&apos;");
//	}
})
.endType();