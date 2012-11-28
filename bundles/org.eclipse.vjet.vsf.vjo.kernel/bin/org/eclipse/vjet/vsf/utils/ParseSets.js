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
vjo.ctype("org.eclipse.vjet.vsf.utils.ParseSets")
.props({
	//>public String[] parseSets(String source, String s, String v, String n)
	parseSets : function(source, s,v,n) {
		s = s?s:"^";
		v = v?v:",";
		n = n?n:"=";
		var a = [];
		var ma = source.split(s);
		if(ma)
		{
			for(var i in ma)
			{
				var t = ma[i].split(n);
				if(t[0]!="" && t[1]!="") 
					a[t[0]] = t[1].split(v);
			}
		}
		return a;
	}
})
.endType();