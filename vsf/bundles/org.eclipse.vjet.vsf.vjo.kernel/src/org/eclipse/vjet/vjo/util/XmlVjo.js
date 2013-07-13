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
vjo.ctype('org.eclipse.vjet.vjo.util.XmlVjo')
.needs('org.eclipse.vjet.vjo.util.XmlJson')
.needs('org.eclipse.vjet.vjo.util.JsonVjo')
.props({
	//> public Object xml2vjo(String xml, String typeName)
	xml2vjo : function xml2vjo(xml, typeName) {
		// convert XML to JSON string
		var jsonStr = vjo.util.XmlJson.xml2json(xml);   
		// convert JSON string to VJO object
		return vjo.util.JsonVjo.json2vjo(jsonStr, typeName);
	}
})
.endType();