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
* Checks if current string contains the given sub-string.
* 
* @param {String} str
*        a sub-string to be tested
* @return {boolean}
*        <code>true</code> if the sub-string is in the current string
*/
vjo.ctype("org.eclipse.vjet.vsf.typeextensions.string.Comparison").endType();
String.prototype.has = function (pStr) { 
	return (this.indexOf(pStr) != -1); 
};

/**
* Checks if current string contains the given arguments.
* @param {String} arg
*        a given arguments object. This can be a single string or a string array.
* @return {boolean}
*        <code>true</code> if the arguments is in the current string
*/
String.prototype.hasArg = function (pArg) {
	var a = pArg, rv = false;
	if (typeof(a) == "string")
	{
		rv = this.has(a);
	}
	else{
		var aL = a.length;
		for (var j=0; j<aL && !rv; j++)
		{
			rv = this.has(a[j]);
		}
	}
	return rv;
};

/**
* Checks if current string contains any of the given arguments.
* 
* @return {boolean}
*         <code>true</code> if any of the given arguments is in the current string
*/
String.prototype.hasAny = function () {
	var a = arguments, l = a.length, rv = false;
	for (var i=0; i<l && !rv; i++)
	{
		rv = this.hasArg(a[i]);
	}
	return rv;
};

/**
* Checks if current string contains all of the given arguments.
* 
* @return {boolean}
*         <code>true</code> if all of the given arguments is in the current string
*/
String.prototype.hasAll = function () {
	var a = arguments, l = a.length;
	for (var i=0; i<l; i++)
	{
		if (!this.hasArg(a[i]))
		{
			return false;
		}
	}
	return true;
};

/**
* Checks if the specified string is equal to current string
*
* @param {String} s
*        A string to be tested
* @return {boolean}
*        <code>true</code> if the specified string is equal to current string
*/
String.prototype.is = function (s) { 
	return (this == s); 
};

String.prototype.isAny = function () {
	var a = arguments, l = a.length, rv = false, aL;
	for (var i=0; i<l && !rv; i++)
	{
		if (typeof(a[i]) == "string")
		{
			rv = (this == a[i]);
		}
		else
		{
			//It's an array (of strings)
			aL = a[i].length;
			for (var j=0; j<aL && !rv; j++)
			{
				rv = (this == a[i][j]);
			}
		}
	}
	return rv;
};