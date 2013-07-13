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
vjo.ctype('org.eclipse.vjet.vjo.util.JsonVjo')
.props({
	//> public Object json2vjo(String jsonStr, String typeName)
	json2vjo : function (jsonStr, typeName) {
		// need to trim the type from JS string, otherwise it will confuse the JS deserialization code
		var i = jsonStr.indexOf(':');
		jsonStr = jsonStr.substring(i+1, jsonStr.length-1);
		
		// call toVjo() to convert json string to VJO object
		return this.toVjo(typeName, eval("(" + jsonStr + ")"));
	},
	//> private void json2vjo(String type, Object json)
	toVjo : function toVjo (type, json) {
		if (typeof(type) == 'undefined' || type == null || type === '') {
			throw "Invalid type name";
		}
		if (typeof(json) == 'string' && type == "float") {
		   return parseFloat(json);
		}
		if (typeof(json) == 'string' && type == "number") {
		   return parseInt(json);
		}
		if (!json) return null;
	
		var TypeObj, err = "Invalid type '" + type + "'.";
		try {
			TypeObj = eval(type);
		} catch (e) {
			throw err;
		}
		if (!TypeObj) return err;
	
		if (TypeObj.clazz._type == "etype") {
			var o = "enum";
		} else {
			var o = new TypeObj();
			for (var i in json) {
				var outElementName = i;
				if (TypeObj.clazz.elementNameMap != null) {
				   if (TypeObj.clazz.elementNameMap[i] != null) {
					outElementName = TypeObj.clazz.elementNameMap[i];
				   }
				}
	
				// find the type of the field by traversing the meta map of itself and its parents
				var fieldType = vjo.findType(TypeObj, outElementName);
				if (fieldType != null) {
					var idx = fieldType.indexOf(':');
					if (idx != -1) {
						// ":" is found. this is an array
						var arrayClassName = fieldType.substring(0, idx);
						var ArrayType = eval(arrayClassName);
						var arrayObj = new ArrayType();
						var elementType = fieldType.substring(idx+1, fieldType.length);
						var array = json[i];
	
						if (elementType == "String" || elementType == "int" || elementType == "long") {
						   // iterate thru the list and add one by one
						   for (var j in array) {
							arrayObj.add(array[j]);
						   }
						} else {
						   // even the meta says it's an array, it could just be a single element,
						   // in which case it will be flattened.
						   if (vjo.isArray(array)) {
						      // need to recurse into each element for deserialization
						      for (var j in array) {
							var nestedObj = toVjo(elementType, array[j]);
							arrayObj.add(nestedObj);
						      }
						   } else {
						      var nestedObj  = toVjo(elementType, array);
						      arrayObj.add(nestedObj);
						   }
						}
						// at the end, set arrryObj
						o[outElementName] = arrayObj;
					} else {
						var nestedObj = toVjo(fieldType, json[i]);
						o[outElementName] = nestedObj;
					}
				} else {
					o[outElementName] = json[i];
				}
			}
		}
	
		return o;
	}
})
.endType();