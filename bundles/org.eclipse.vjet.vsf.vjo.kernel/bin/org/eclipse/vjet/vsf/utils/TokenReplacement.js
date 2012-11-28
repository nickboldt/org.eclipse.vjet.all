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
vjo.ctype("org.eclipse.vjet.vsf.utils.TokenReplacement")
.needs("org.eclipse.vjet.vsf.utils.Comparison")
.props({
	//>public String replaceToken(String pStr,String pToken,String pRepl)
	replaceToken : function(pStr,pToken,pRepl) {
		if (pToken==pRepl) return pStr;
		var rv = pStr;
		while (this.vj$.Comparison.has(rv, pToken)){
			rv = rv.replace(pToken, pRepl);
		}
		return rv;
	
	},
	//>public String replaceTokensEx(String pSource ,String pPattern)
	replaceTokensEx : function (pSource, pPattern) {
		var rv = pSource, re, tkn, a = arguments, l = a.length;
		for ( var i = 1; i < l+1; i++ ){
			rv = this.replaceToken(rv,pPattern.replace("n", (i)),a[i]);
		}
		return rv;
	},
	
	//>public String replaceTokens(String pSource)
	replaceTokens : function (pSource) {
		var rv = pSource, re, tkn, a = arguments, l = a.length;
		for ( var i = 0; i < l; i++ ){
			rv = this.replaceToken(rv, "<#" + ( i + 1 ) + "#>",a[i])
		}
		return rv;
	}
})
.endType();