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
vjo.ctype("org.eclipse.vjet.vsf.utils.Comparison")
.props({

	//>public boolean has(String pSrc, String pStr)
	has : function (pSrc, pStr) { 
		return (pSrc.indexOf(pStr) != -1); 
	},
	
	//>public boolean hasArg(String pSrc, String pArg)
	hasArg : function (pSrc, pArg) {
		var a = pArg, rv = false;
		if (typeof(a) == "string")
		{
			rv = this.has(pSrc, a)
		}
		else{
			var aL = a.length;
			for (var j=0; j<aL && !rv; j++)
			{
				rv = this.has(pSrc, a[j])
			}
		}
		return rv;
	},
	
	//>public boolean hasAny(String pSrc, String ...)
	hasAny : function (pSrc) {
		var a = arguments, l = a.length, rv = false;
		for (var i=0; i<l && !rv; i++)
		{
			rv = this.hasArg(pSrc, a[i]);
		}
		return rv;
	},

	//>public boolean hasAll(String pSrc, String ...)
	hasAll : function (pSrc) {
		var a = arguments, l = a.length;
		for (var i=0; i<l; i++)
		{
			if (!this.hasArg(pSrc,a[i]))
			{
				return false;
			}
		}
		return true;
	},

	//>public boolean is(String pSrc, String pTarget)
	is : function (pSrc, pTarget) { 
		return (pSrc == pTarget); 
	},

	//>public boolean isAny(String pSrc, String ...)
	isAny : function (pSrc) {
		var a = arguments, l = a.length, rv = false, aL;
		for (var i=0; i<l && !rv; i++)
		{
			if (typeof(a[i]) == "string")
			{
				rv = (pSrc == a[i]);
			}
			else
			{
				//It's an array (of strings)
				aL = a[i].length;
				for (var j=0; j<aL && !rv; j++)
				{
					rv = (pSrc == a[i][j]);
				}
			}
		}
		return rv;
	}
})
.endType();