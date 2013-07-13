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
vjo.ctype("org.eclipse.vjet.vsf.utils.HistoryManager")
.needs(["org.eclipse.vjet.vsf.Enc",
	"org.eclipse.vjet.vsf.ServiceEngine",
	"org.eclipse.vjet.vsf.EventDispatcher",
	"org.eclipse.vjet.vsf.utils.UriBuilder"])
/**
* This class is used to keep the browser's back/forward button avaliable when 
* the AJAX feature is introduced into the page.
*/
.protos({
	
	/**
	* The constructor of the HistoryManager.
	* 
	* @constructor
	* @param {HistoryManagerModel} model
	*        the dataModel of the HistoryManager
	* 
	*/
	//> public void constructs(Object);
	constructs : function(model) {
	
		var self = this;
		
		this.model = model;this.modules = new Object();
		this.href = new this.vj$.UriBuilder(document.location.href, false);

		if (navigator.userAgent.indexOf("MSIE") > -1) {

			this.iframe = document.getElementById(this.model.frameId);
			if (!this.iframe.contentWindow.document.body.innerText) this.pushFrame(this.href.hash);

			this.vj$.EventDispatcher.addEventListener(this.iframe,"load",function(event) { return self.onFrameLoad(event); }, null);

		}
				
		this.vj$.EventDispatcher.addEventListener(window,"load",function(event) { return self.onLoad(event); }, null);
		this.vj$.EventDispatcher.addEventListener(window,"unload",function(event) { return self.onUnload(event); }, null);
		
	},
	
	//> private void onload(Object);
	onLoad : function(event) {

		var self = this;
		
		this.states = new Object();
		
		this.onHistoryChange(this.href.hash);
		this.ticker = window.setInterval(function() { self.onTicker(); },50);

	},
	
	//> private void onUnload(Object);
	onUnload : function(event) {
		this.iframe = null;
	},

    //> private void onTicker();
	onTicker : function() {
		var hash = this.getHash();
		if (hash != this.href.hash) this.onHistoryChange(hash);
	},
	
	//> private Object getHash();
	getHash : function() {
		return document.location.hash.match("(#)?(.*)")[2];
	},
	
	//> private void pushFrame(Object, String);
	pushFrame : function(hash,title) {

		this.href.hash = hash;
		
		title = ((title)?title:document.title);
		title = ((title)?title.replace(/"/g,'\\"'):this.href.getUri());

		var script = '<scr' + 'ipt type="text/javascript">';
		script += 'document.title = "' + title + '";';
		script += 'document.write("' + this.href.getUri() + '");';
		script += '</scr' + 'ipt>';

		var frame = this.iframe.contentWindow.document;
		frame.open();frame.write(script);frame.close();

	},
	
	//> private void onFrameLoad(Object);
	onFrameLoad : function(event) {
		var href = new this.vj$.UriBuilder(this.iframe.contentWindow.document.body.innerText, false);
		if (href.hash != this.href.hash) this.onHistoryChange(document.location.hash = href.hash);
	},
	
	//> private String serialize(Object);
	serialize : function(object) {
		try { 
			return JSON.stringify(object); //<@SUPRESSTYPECHECK 
			var x;
		}
		catch(except) { return "" }		
	},
	
	//> private Object deserialize(Object);
	deserialize : function(object) {
		try { return (object)?eval("(" + object + ")"):new Object(); }
		catch(except) { return new Object(); }
	},
	
	/**
	* Updates the state of a ajax response.
	*
	* @param {Object} key
	*        the full AJAX query url
	* @param {Object} state
	*        the state of the ajax response
	*/
	//> public void putState(Object, Object);
	putState : function(key,state) {
		this.states[key] = this.deserialize(this.serialize(state));
	},
	
	/**
	* Gets the state of the ajax response.
	*
	* @param {Object} key
	*        the full AJAX query url
	* @return {Object}
	*        the state of the ajax response
	*/
	//> public Object getState(Object);
	getState : function(key) {
		return this.states[key];
	},
	
	/**
	* Appends a ajax request to the browser's history list, which allows you
	* use 'back/forward' button as same as on the normal html page.
	*
	* @param {String} name
	*        the string id of the ajax call
	* @param {Object} state
	*        the state for current ajax call
	* @param {String} title
	*        the window title for current ajax call 
	*/
	//> public void pushHistory(String, Object, String);
	pushHistory : function(name,state,title) {

		this.modules[name] = state;
		
		var hash = org.eclipse.vjet.vsf.Enc.encodeURIComponent(this.serialize(this.modules))
		if (hash == this.href.hash) return;

		window.location.hash = hash;
		if (this.iframe) this.pushFrame(hash,title);

	},
	
	//> private void onHistoryChange(Object);
	onHistoryChange : function(hash) {
		
		this.href.hash = hash;
		
		var message = new org.eclipse.vjet.vsf.Message("HISTORY_CHANGE");
		message.state = this.deserialize(org.eclipse.vjet.vsf.Enc.decodeURIComponent(this.href.hash));

		org.eclipse.vjet.vsf.ServiceEngine.handleRequest(message);

	}
	
})
.endType();

