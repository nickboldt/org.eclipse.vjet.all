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
vjo.ctype("org.eclipse.vjet.vsf.utils.JsLoader")
.props({
	queue : [],
	pending : null,
	DEFAULT_TYPE : "text/javascript",
	//> public void load(String psUrl)
	//> public void load(String psUrl, Object poCallback)
	//> public void load(String psUrl, Object poCallback, Object poScope)
	//> public void load(String psUrl, Object poCallback, Object poScope, String psType)
	load : function(psUrl,poCallback, poScope, psType) {
		this.fetch(psUrl,poCallback, poScope,psType?psType:this.DEFAULT_TYPE);
	},
	//> public void loadText(String psJsText)
	loadText : function(psJsText) {
		if(psJsText){
			var t = this;//<Type::JsLoader
			var head = t.getHead(), stag = t.createScript();
			stag.type = t.DEFAULT_TYPE;
			stag.text =  psJsText;
			head.appendChild(stag);
		}
	},
	//> public Object getHead()
	getHead : function(){
		return document.getElementsByTagName('head')[0];
	},
	//> public Object createScript()
	createScript : function(){
		return document.createElement('script');
	},	
	//> private void fetch(String psUrl, Object poCallback, Object poScope, String psType)
	fetch : function(psUrl,poCallback, poScope, psType) {
		var request = {url : psUrl, callback : poCallback, scope : poScope}, head, stag;
		var t = this; //<Type::JsLoader
		if(t.pending){
			t.queue.push(request);
			return;
		}		
		this.pending = request;
		head = t.getHead();
		stag = t.createScript();
		stag.onload = stag.onreadystatechange 
			= function(){
				if(!this.readyState || this.readyState == "loaded" || this.readyState == "complete"){
					t.oncomplete();
					// Handle memory leak in IE
					stag.onload = stag.onreadystatechange = null;
					head.removeChild(stag);
				}
			};
		stag.type = psType;
		stag.async = true; //make it async call
		stag.defer = true; //make it async call(older browsers)
		stag.src = psUrl;
		head.appendChild(stag);
	},
	//> private void oncomplete()
	oncomplete : function(){
		var t = this, o = t.pending;
		if(o.callback){
			o.callback.call(o.scope||window);
		}
		t.pending = null;
		if(t.queue.length > 0)
		{
			var request = this.queue.shift();
			t.load(request.url, request.callback, request.scope);
		}
	}
})
.endType();