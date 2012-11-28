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
vjo.ctype("org.eclipse.vjet.vsf.utils.CssLoader")
.props({
	//>public void load(String psUrl)
	load : function(psUrl) {
		var d = document;
		if(d.createStyleSheet){
			d.createStyleSheet(psUrl);
		}else {
			var head = this.getHead(), style = d.createElement("link");
            style.rel =  "stylesheet";
            style.type = "text/css";
            style.href = psUrl;
            head.appendChild(style);
		}
	},
	//> public Object getHead()
	getHead : function(){
		return document.getElementsByTagName('head')[0];
	},
	//>public void loadText(String psText)
	loadText : function(psText) {
		var d = document, style = d.createElement("style");
		style.type = "text/css";
		if(style.styleSheet) {
			style.styleSheet.cssText = psText;
		}else {
			style.appendChild(d.createTextNode(psText));
		}
		this.getHead().appendChild(style);
	}	
})
.endType();