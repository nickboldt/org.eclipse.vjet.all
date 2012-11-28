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
//vjo.ctype("org.eclipse.vjet.vsf.utils.SiteSpeed")
//.needs(["org.eclipse.vjet.vsf.EventDispatcher",
//	"org.eclipse.vjet.vsf.utils.URL",
//	"org.eclipse.vjet.vsf.document.Positioning",
//	"org.eclipse.vjet.vsf.error.ErrorHandlerManager",
//	"org.eclipse.vjet.vsf.cookie.VjCookieJar"])
//.props({
//	params : {},
//
//	pload : function () {
//		var oCJ = this.vj$.VjCookieJar, sbf = oCJ.readCookie("ebay","sbf"); 
//		//Mark as cached for all pages including un-sampled. 
//		//Can not do this in puload as previous page unload can happend after current response back, marking current page as cached
//		oCJ.writeCookielet("ebay","sbf",oCJ.setBitFlag(sbf, 20, 1));
//	},
//	punload : function () {
//		this.vj$.VjCookieJar.writeCookielet("ds2","ssts",(new Date()).getTime());
//	},
//	addParam : function (key,value) {
//		if (key && value) {
//			this.params[key] = value;
//		}
//	},
//	getParams : function() {
//		var rv = "";
//		for (var k in this.params) {
//			rv += "&" + k + "=" + this.params[k];
//		}
//		return rv;
//	},
//	getParam : function (key) {
//		 return this.params[key];
//	},
//	/*
//	 * This interfase can be used by app to callback to indicate lastest download after browser onload,
//	 * so that we get correct page level timers.
//	 */
//	//> public void updateLoad()
//	updateLoad : function () {
//		if (typeof(oGaugeInfo)!='undefined' && oGaugeInfo.ld === true) {
//			var g = oGaugeInfo; //<@SUPRESSTYPECHECK
//			var ct = (new Date()).getTime();
//			g.wt =  ct;
//			g.ex3 = ct;
//			g.ct21 =  ct - g.iST;
//		}
//	}
//})
//.inits(function () {
//	ed = org.eclipse.vjet.vsf.EventDispatcher;//<<
//	ed.addEventListener(window,'load', this.pload, this);
//	ed.addEventListener(window,'beforeunload', this.punload, this);
//})
//.endType();
