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
/**
* Manages runtime errors and handlers registered on the errors.
*/
vjo.ctype("org.eclipse.vjet.vsf.error.ErrorHandlerManager")
.needs("org.eclipse.vjet.vsf.error.Error")
.props({
	dsfErrors : [],
	handlers : [],
	
	/**
	* Adds an error object to the dsf error list.
	*
	* @param {String} message 
	*        A string message describes the error
	* @param {String} url 
	*        An page url where causes the eror
	* @param {String} lineNumber 
	*        A number value indecates the line where the error happens
	* @param {boolean} 
	*        Always returns true
	*/
	//> public boolean add(String, String, String);
	add : function (psMessage, psUrl, psLineNumber) {
		this.dsfErrors[this.dsfErrors.length] = new org.eclipse.vjet.vsf.error.Error(psMessage, psUrl, psLineNumber);
		return true;		
	},
	
	/**
	* Converts an error to HTML format or plain text format.
	* 
	* @param {boolean} isHTML 
	*        A boolean value that reprents whether convert the error to HTML 
	*        format or plain text fromat
	* @return {String} 
	*        error information with specified format
	*/
	//> public String convertErrorTo(boolean);
	convertErrorTo : function (pbIsHTML) {
		var sBr = pbIsHTML ? "<br>" : "\n";
		var sHtmlOpen = pbIsHTML ? "<html><title>" : "";
		var sHtmlClose = pbIsHTML ? "</title><body>" : sBr;
		var sHtmlClose2 = pbIsHTML ? "</body></html>" : "";
		var sH2Open = pbIsHTML ? "<h2>" : "";
		var sH2Close = pbIsHTML ? "</h2>" + sBr : sBr;
		var sBOpen = pbIsHTML ? "<b>" : "";
		var sBClose = pbIsHTML ? "</b>" : "";
	
	
		var html = sHtmlOpen + "V4 JS Errors" + sHtmlClose;
		html += sH2Open + "Total number of errors = " + this.dsfErrors.length + sH2Close;
	
		for (var i =0;i<this.dsfErrors.length;i++) {
			html += sBOpen + "Message: " + sBClose + this.dsfErrors[i].message;
			html += sBr;
			html += sBOpen + "URL :" + sBClose + this.dsfErrors[i].url;
			html += sBr;
			html += sBOpen + "Line Number :" + sBClose + this.dsfErrors[i].lineNumber;
			html += sBr;
			html += sBOpen + "User Agent :" + sBClose + this.dsfErrors[i].userAgent;
			html += sBr;
			html += sBr;
		}
	
		html += sHtmlClose2;
		return html;	
	},
	
	/**
	* Converts an error to HTML format.
	* 
	* @return {String} error 
	*         information in HTML format
	*/
	//> public String toHTML();
	toHTML : function () {
		return this.convertErrorTo(true);
	},
	
	/**
	* Converts an error to plain text format.
	* 
	* @return {String} error 
	*         information in plain text format
	*/
	//> public String toText();
	toText : function () {
		return this.convertErrorTo(false);
	},
	
	/**
	* Pops up a window to show the error information.
	*
	*/
	//> public void show();
	show : function () {
		var errorwin = window.open("","V4JSErrors", "height=500,width=500,menubar=no,status=no,scrollbars=yes");
		if (window.focus) {		
			errorwin.focus();
		}
		errorwin.document.write(this.toHTML());
		errorwin.document.close();
	},
	
	/**
	* Registeres a handler to process the runtime error
	*
	* @param {Object} handler 
	*        A handler used to process the error
	*/
	//> public void register(Object);
	register : function (handler) {
		if (!handler) {
			return this;
		}
		if (typeof handler != 'object') {
			return this;
		}
		this.handlers[this.handlers.length] = handler;
		return handler;
	},
	
	/**
	* Clears all handlers registered to process the errors
	*
	*/
	//> public void clear();
	clear : function () {
		this.handlers.length = 0;
	},
	
	/**
	* Processes an error using all registered handlers
	*
	* @param {String} message 
	*        A string message describes the error
	* @param {String} url 
	*        An page url where causes the eror
	* @param {String} lineNumber 
	*        A number value indecates the line where the error happens
	*/
	//> public void process(String, String, String)
	process : function (psMessage, psUrl, psLineNumber) {
		for (var i=0;i<this.handlers.length;i++) {
			this.handlers[i].handle(psMessage, psUrl, psLineNumber);
		}
	},
	
	//> public void enableOnError(boolean hideJsErrors);
	//> public void enableOnError(boolean hideJsErrors, boolean addStackTrace);
	enableOnError : function (hideJsErrors, addStackTrace) {
		if(typeof(hideJsErrors)=="undefined"){
			//hideJsErrors is undefined, hide the errors as before
			hideJsErrors = true;
		}
		window.onerror = function(message, url, lineNumber) {
					var enableStackTrace = (addStackTrace?true:false);
					message = enableStackTrace?org.eclipse.vjet.vsf.error.ErrorHandlerManager.stackTrace():message;
		            org.eclipse.vjet.vsf.error.ErrorHandlerManager.process(message, url, lineNumber);
					return hideJsErrors;
				};	
	},
    stackTrace : function(){
		var msg;
		var err = this.errorObj();//simulate error to get error object reference
		if(err.stack){ 
			msg = this.stackTraceByError(err);
		}else{
			msg = this.stackTraceByCallee(arguments.callee);
		}
		return msg;
    },
	errorObj : function(){
	    try {
	    	//> @SUPPRESSTYPECHECK
	    	// undefined global variable $undefined$ must be created or error is thrown
             var err = $undefined$ << 1; 
        } catch (e) {
            return e;
        }
	}, 
    stackTraceByError : function(e) {
		var astack = e.stack.split("\n");
		//Remove first two entries
		//First entry is errorObj call
		//Second entry is stackTrace call
		astack[0]=astack[1]="";
		return astack.join().substring(2); //remove first two commas
    },

    stackTraceByCallee : function(curr) {
    //debugger;
        var ANON = '?', fnRE = /function\s*([\w\-$]+)?\s*\(/i,
            stack = [], j = 0, fn, args;
        var maxStackSize = 10;
        //start from curr.caller to skip stackTrace
        curr = curr.caller;
        while (curr && stack.length < maxStackSize) {
            fn = fnRE.test(curr.toString()) ? RegExp.$1 || ANON : ANON;
            if(fn==ANON && curr._name){
				fn = curr._name;
            }
			args = Array.prototype.slice.call(curr['arguments']);
			stack[j++] = fn + '(' + this.argumentsAsString(args) + ')';
            curr = curr.caller;
        }
        return stack;
    },
    argumentsAsString : function (args) {
        for (var i = 0; i < args.length; ++i) {
            var arg = args[i];
            if (arg === undefined) {
                args[i] = 'undefined';
            } else if (arg === null) {
                args[i] = 'null';
            } else if (arg.constructor) {
                if (arg.constructor === Array) {
                    if (arg.length < 3) {
                        args[i] = '[' + this.argumentsAsString(arg) + ']';
                    } else {
                        args[i] = '[' + this.argumentsAsString(Array.prototype.slice.call(arg, 0, 1)) + '...' + this.argumentsAsString(Array.prototype.slice.call(arg, -1)) + ']';
                    }
                } else if (arg.constructor === Object) {
                    args[i] = '#object';
                } else if (arg.constructor === Function) {
                    args[i] = '#function';
                } else if (arg.constructor === String) {
                    args[i] = '"' + arg + '"';
                }
            }
        }
        return args.join(',');
    }

})
.endType();

