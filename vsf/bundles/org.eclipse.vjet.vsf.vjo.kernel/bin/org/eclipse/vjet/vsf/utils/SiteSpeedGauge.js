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
//vjo.ctype("org.eclipse.vjet.vsf.utils.SiteSpeedGauge")
//.needs(["org.eclipse.vjet.vsf.EventDispatcher",
//	"org.eclipse.vjet.vsf.utils.URL",
//	"org.eclipse.vjet.vsf.document.Positioning",
//	"org.eclipse.vjet.vsf.error.ErrorHandlerManager",
//	"org.eclipse.vjet.vsf.utils.SiteSpeed",
//	"org.eclipse.vjet.vsf.cookie.VjCookieJar"])
//.props({
//	/**
//	* Handle onload event.
//	* @return void
//	* @access public
//	* @JsEventHandler
//	*/
//	//> public void gauge()
//	gauge : function () {
//		if (typeof(oGaugeInfo)!='undefined') {
//			oGaugeInfo.ld = true; //<@SUPRESSTYPECHECK
//			// Note in edge cases window onload can be called mutiple times, but the last set the lastest stamps
//			this.vj$.SiteSpeed.updateLoad();
//			var ua = navigator.userAgent;
//			if ( ua.indexOf("Firefox/3.0") > 0 || (ua.indexOf("Safari") > 0 && ua.indexOf("Chrome") < 0)){
//				this.send(0);
//			}
//		}
//	},
//	/**
//	* @return void
//	* @access public
//	* @JsEventHandler
//	*/
//	//> public void gaugeUnload()
//	gaugeUnload : function () {
//		this.send(1);
//	},
//	//> public void gaugeBodyLoad()
//	gaugeBodyLoad : function() {
//		if (typeof(oGaugeInfo)!='undefined') {
//			var g = oGaugeInfo; //<@SUPRESSTYPECHECK
//			if ( g.bf != 1 ){
//				var et = (new Date()).getTime() - g.iST;
//				this.vj$.SiteSpeed.addParam("ctb", et);
//			}
//			var fg = this.vj$.URL.getArg(document.location.href, "ForceSiteSpeedGauge");
//			if ( fg  == "true" ){
//				var img = new Image(1,1);
//				img.src = "http://p.ebaystatic.com/aw/pics/sitespeed/past/speedp.gif";
//			}
//		}
//	},
//	send : function (sul){
//		// sul=1 for sending on unload, else sending on onload such as Safari and FF3.0
//		if (typeof(oGaugeInfo)!='undefined') {
//			var g = oGaugeInfo; //<@SUPRESSTYPECHECK
//			var sg = this.vj$.SiteSpeed;
//			if ( g.ld === true ){
//				if ( g.bf != 1 ){
//					sg.addParam("ct21", g.ct21);
//					// pregressinve rendering tags
//					if ( typeof(g.aChunkInfo)!='undefined' && g.aChunkInfo.length > 1 ){
//						var ct1end = g.aChunkInfo[0][1] - g.iST;
//						if ( ct1end === 0 ){
//							sg.addParam("ct1chnk", "0");
//						}else{
//							sg.addParam("ct1chnk", ct1end);
//						}
//						var ctidl = g.aChunkInfo[1][0] - g.aChunkInfo[0][1];
//						if ( ctidl === 0 ){
//							sg.addParam("ctidl", "0");
//						}else{
//							sg.addParam("ctidl", ctidl);
//						}
//						var st2pt = g.aChunkInfo[1][2];
//						if ( st2pt === 0 ){
//							sg.addParam("st2pt", "0");
//						}else{
//							sg.addParam("st2pt", st2pt);
//						}
//					}
//					if ( typeof(g.iLoadST)!='undefined' ){
//						var ctbend = g.iLoadST - g.iST;
//						sg.addParam("ctbend", ctbend);
//					}
//					var refUrl = document.referrer;
//					var fg = this.vj$.URL.getArg(document.location.href, "ForceSiteSpeedGauge");
//					var fg1 = this.vj$.URL.getArg(document.location.href, "forcesitespeedgauge");
//					if ( fg=="true" || fg1=="true" || (refUrl !== null && refUrl.indexOf("ebay.") > 0)){
//						if (g.ut !== null && g.ut !== ""){
//							g.ex3 = g.ex3 - g.ut;
//							if ( g.ex3 > 0 && g.ex3 < 300000 ){
//								sg.addParam("ex3", g.ex3);
//							}
//						}
//					}
//				}else{
//					sg.addParam("ex1", "1");
//				}
//				if ( sul == 1 ){
//					g.wt = (new Date()).getTime()  - g.wt;
//					sg.addParam("sgwt", g.wt);
//					if ( g.x !== 0 && g.y !== 0 ){
//						var cxy = "0|" + g.x + "|" + g.y;
//						sg.addParam("cxy", cxy);
//					}
//					if ( g.sx === 0 ){
//						sg.addParam("slo", "0");
//					}else{
//						sg.addParam("slo", g.sx);
//					}
//					if ( g.sy === 0 ){
//						sg.addParam("svo", "0");
//					}else{
//						sg.addParam("svo", g.sy);
//					}
//				}else{
//					g.wt = 0;
//				}
//				if ( g.wt < 60000*20 ){ // ignore > 20 min to prevent incorrect st21
//					this.internal();
//				}
//			}else{ // earlier exit
//				sg.addParam("ex2", (new Date()).getTime() - g.iST);
//				this.internal();
//			}
//		}
//	},
//	mXY : function (e) {
//		  var g = oGaugeInfo; //<@SUPRESSTYPECHECK
//		  var p = this.vj$.Positioning;//<<
//		  var sr = p.getScrollLeftTop();
//		  var xy = p.getEventLeftTop(e); 
//		  g.x = xy[0] +  sr[0];
//		  g.y = xy[1] + sr[1];
//	},
//	sXY : function (e) {
//		 var g = oGaugeInfo; //<@SUPRESSTYPECHECK
//		  var sr = this.vj$.Positioning.getScrollLeftTop();
//		  if ( g.sx < sr[0] ){
//			  g.sx = sr[0];
//		  }
//		  if ( g.sy < sr[1] ){
//			  g.sy = sr[1];
//		  }
//	},
//	internal : function () {
//		//alert("gaugeInternal() = " + oGaugeInfo.bf);
//		if (typeof(oGaugeInfo) === 'undefined'){
//			return;
//		}
//		var g = oGaugeInfo; //<@SUPRESSTYPECHECK
//		if ( g.sent === true ){
//			return;
//		}
//		g.sent = true;
//		var p = this.vj$.Positioning;//<<
//		var sg = this.vj$.SiteSpeed;
//		sg.addParam("bw", p.getClientWidth());
//		sg.addParam("bh", p.getClientHeight());
//		/* js error */
//		var errs = this.vj$.ErrorHandlerManager.dsfErrors;
//		if ( errs.length > 0){
//			var msg="";
//			for (var i =0;i<errs.length;i++) {
//				if (i>0){
//					msg += "|";
//				}
//				msg += "js-err-line-" + errs[i].lineNumber + "-msg-" + errs[i].message;
//			}
//			sg.addParam("sgbld", errs.length);
//			sg.addParam("emsg", msg);
//		}
//		var prm = sg.getParams();
//		var img = new Image(1,1);
//		if (g.bf != 1) {  // non-cached or non-cookie page
//				img.src = g.sUrl.replace(/&amp;/g,'&') + prm;
//		}else{
//				var url, idx = g.sUrl.indexOf("&st1");
//				if ( idx > 0 ){
//					url = g.sUrl.substring(0, idx);
//				}else{
//					url = g.sUrl;
//				}
//				img.src = url.replace(/&amp;/g,'&') + prm;
//		}
//	}
//})
//.inits(function () {
//	if (typeof(oGaugeInfo)!='undefined') {
//		var oCJ = org.eclipse.vjet.vsf.cookie.VjCookieJar, ed = org.eclipse.vjet.vsf.EventDispatcher;//<<
//		var sbf = oCJ.readCookie("ebay","sbf"), b = (sbf) ? oCJ.getBitFlag(sbf,20) : 0;
//		oCJ.writeCookielet("ebay","sbf",oCJ.setBitFlag(sbf, 20, 1)); //for earlier exit cases
//	
//		var g = oGaugeInfo; //<@SUPRESSTYPECHECK
//		if (g.ebox === 1){
//			g.bf = 0;
//		}else{
//			g.bf = b; // 1 for cached page
//		}
//		g.sent = false;
////		g.ut = oCJ.readCookie("ssg","uld");  // put in init instead of unload to prevent multiple unload updating uld inside VI, making ex3 < ct21
//		g.ut = oCJ.readCookie("ds2","ssts");
//		
//		g.ld = false;
//		g.x = 0; g.y = 0;
//		g.sx = 0; g.sy = 0;
//		g.wt = 0; g.ex3 = 0;
//		g.ct21 = 0;
//		ed.addEventListener(document,'click', this.mXY, this);
//		ed.addEventListener(window,'scroll', this.sXY, this);
//		ed.addEventListener(window,'load', this.gauge, this);
//		ed.addEventListener(window,'beforeunload', this.gaugeUnload, this);
//	}
//})
//.endType();
