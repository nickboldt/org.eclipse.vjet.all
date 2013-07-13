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
// @JsDoNotOptimize
// @JsMinimize
// @JsDoNotLintValidate
// @Package org.eclipse.vjet.vsf
vjo.ctype("org.eclipse.vjet.vsf.FirePageLoad").endType();
if(typeof(oGaugeInfo)!="undefined"){
	//Keeping VJO onload start time in oGaugeInfo object.
	oGaugeInfo.iLoadST = (new Date()).getTime();
}
org.eclipse.vjet.vsf.EventDispatcher.load(document.body);