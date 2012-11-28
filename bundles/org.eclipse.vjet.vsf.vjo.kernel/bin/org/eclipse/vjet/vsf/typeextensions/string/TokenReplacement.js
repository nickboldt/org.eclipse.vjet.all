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
vjo.needs("org.eclipse.vjet.vsf.typeextensions.string.Comparison");
vjo.ctype("org.eclipse.vjet.vsf.typeextensions.string.TokenReplacement").endType();
//@Package org.eclipse.vjet.vsf.typeextensions.string
/**
* Replaces the tokens with specified string.
* 
* @param {String} str
*        raw string contains the token
* @param {String} token
*        specified token string in the raw string
* @param {String} repl
*        a string that is used to replace the token
* @return {String}
*        result string after the replacement
*/
String.prototype.replaceToken = function(pStr,pToken,pRepl) {
	if (pToken==pRepl) return pStr;
	var rv = pStr;
	while (rv.has(pToken)){
		rv = rv.replace(pToken, pRepl);
	}
	return rv;

};

/**
* Replaces the tokens with specified string.
* 
* @param {RegExp} pattern
*        raw string contains the token
* @return {String}
*        result string after the replacement
*/
String.prototype.replaceTokensEx = function (pPattern) {
	var rv = this, re, tkn, a = arguments, l = a.length;
	for ( var i = 1; i < l+1; i++ ){
		rv = this.replaceToken(rv,pPattern.replace("n", (i)),a[i]);
	}
	return rv;
};

String.prototype.replaceTokens = function () {
	var rv = this, re, tkn, a = arguments, l = a.length;
	for ( var i = 0; i < l; i++ ){
		rv = this.replaceToken(rv,"<#" + ( i + 1 ) + "#>",a[i]);
	}
	return rv;
};