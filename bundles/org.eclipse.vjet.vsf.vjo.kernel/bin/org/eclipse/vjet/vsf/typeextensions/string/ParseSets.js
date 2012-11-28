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
//@Package org.eclipse.vjet.vsf.typeextensions.string
/**
* Parses a given string to sets. The items in the string is seperated from some
* seperator.
* <p>
* Example:
* <code>setname1=value1,value2,value3^setname2=value1,value2,value3</code>
*
* @param {String} s
*        set seperator. The default seperator is "^"
* @param {String} v
*        value seperator. The default seperator is ","
* @param {String} n
*        set and values seperator. The default seperator is "="
*/
vjo.ctype("org.eclipse.vjet.vsf.typeextensions.string.ParseSets").endType();
String.prototype.parseSets = function(s,v,n) {
	s = s?s:"^";
	v = v?v:",";
	n = n?n:"=";
	var a = [];
	var ma = this.split(s);
	if(ma)
	{
		for(i in ma)
		{
			var t = ma[i].split(n);
			if(t[0]!="" && t[1]!="") 
				a[t[0]] = t[1].split(v);
		}
	}
	return a;
};