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
* Manages, dispatches, and cleans up all DOM events created in V4. 
* <code>EventDispatcher</code> is a <code>singleton</code>. You can access 
* <code>EventDispatcher<code> directly, via <code>org.eclipse.vjet.vsf.EventDispatcher</code>.
*/
vjo.ctype('org.eclipse.vjet.vsf.EventDispatcher')
.needs(['org.eclipse.vjet.vsf.Event',
        'org.eclipse.vjet.vsf.ServiceEngine',
        'org.eclipse.vjet.vsf.Element'])
.props({
	eventHandlers : {},
	nativeEventHandlers : {},
	unboundElems : [],
	fCustomLoad : {},
	
	/**
	* Invokes the handlers registered on an event of a given DOM element in 
	* sequence. If the handler returns a <code>Message</code> object, this 
	* function will put them into <code>ServiceEngine</code>.
	*
	* @param {String} srcId 
	*        A String id that represents the DOM element
	* @param {Object} event 
	*        A <code>Event</code> object that represents the triggered event
	* @return {Object} 
	*        The return value depends on the different conditions as listed 
	*        below:
	*        <ul>
	*         <li>true - If no handler is registered on this event or, all 
	*             handlers return <code>Message</code> object and the 
	*             propagation is not stopped during the process.
	*         </li>
	*         <li>false - If the propagation is stopped during the process.
	*         </li>
	*         <li>Object - It's the last non-<code>Message</code> object 
	*             returned by a handler, and the propagation is not stopped 
	*             after that handler's execution.
	*		  </li>
	*        </ul>
	*        To stop the propagation, you can set the value of the 
	*        <code>returnData</code> defined in <code>Message</code> object as 
	*        <code>false</code>.
	*/
	//> public Object process(String, Object);
	process : function(srcId, event) {
		var eventHandlersPerSrc = this.eventHandlers[srcId];
		if (!eventHandlersPerSrc) {
			return true;
		}
	
		var handlers = eventHandlersPerSrc[event.eventType];
		if (!handlers) {
			return true;
		}
	
		var returnData, len = handlers.length;
	
		for (var i = 0; i < len; i++) {
			var message = handlers[i].handle(event);
			if (message && message.objType == "dsf_Message") {
				if (this.vj$.ServiceEngine) {//make async
					//var cb = this.createRequest(message);
					//window.setTimeout(cb,1);
					this.vj$.ServiceEngine.handleRequest(message);
				}
				if (message.returnData===false) {
					returnData = false;
				}
			} else if (returnData!=false && typeof message != 'undefined') { //do not ovveride false
				returnData = message;
			} 
		}
			
		return returnData;	
	},
	
	/**
	* Registers a handler on an event of a given DOM element into the internal 
	* registry. Calling this function will not cause the occurence of the event 
	* to trigger its handler. To safely register the handler so that it can be 
	* triggered by the occurence of the event, use {@link #add}.
	*
	* @param {String} id 
	*        A String id of the DOM element 
	* @param {String} eventType 
	*        A string that represents the type of the event
	* @param {Object} handler 
	*        The handler function to be registered
	* @param {Object} scope 
	*        A scope that the handler function belongs to
	* @return {Object} 
	*        The registered handler function or <code>EventDispatcher</code>
	*        itself if the handler is not a valid  function
	* @see   #add	
	*/
	//> public Object register(String, String, Object, Object);
	register : function(id, eventType, handler, scope) {
		if (!id || !eventType || !handler) {
			return this;
		} else {
			if (typeof handler.handle != 'function') {
				if (typeof handler == 'function') {
					var func = handler, scp = scope || this;
					var obj = {handle:function () {
						return func.apply(scp,arguments);
					}};
					handler = obj;
				} else {
					return this;
				}
			}
		}
		
		var handlers = this.eventHandlers[id];
		if (!handlers) {
			handlers = this.eventHandlers[id] = {};
		}
		if (!handlers[eventType]) {
			handlers[eventType] = [];
		}
		var len = handlers[eventType].length;
		handlers[eventType][len] = handler;
		return handler;
	},
	
	/**
	* Removes all handlers from an event of a DOM element from the internal VJO
	* registry. If {@link #add} or {@link #addEventListener} was used to 
	* register the handler, the handler may still be attached on the event even 
	* after calling this function. In that case, use {@link #detachHandler} to 
	* safely remove all handlers attached to the specified element and event.
	*
	* @param {String} id 
	*        A String id of the DOM element 
	* @param {String} eventType 
	*        A string represents the event type
	* @see   #add
	* @see   #addEventListener
	* @see   #detachHandlers	
	*/
	//> public void unregister(String, String);
	unregister : function (id,eventType) {
		if (!this.eventHandlers[id]) {
			return;
		}
		//clear handlers
		//this.eventHandlers[id][eventType] = [];
		delete this.eventHandlers[id][eventType];
	},
	
	//> private void registerNative(Object, String, Object);
	registerNative : function(elem, eventType, handler) {
		var id = (elem==window) ? "body" : elem.id;
		var handlers = this.nativeEventHandlers[id];
		if (!handlers) {
			handlers = this.nativeEventHandlers[id] = {};
		}
		if (!handlers[eventType]) {
			handlers[eventType] = [];
		}
		var len = handlers[eventType].length;
		handlers[eventType][len] = handler;
	},
	
	/**
	* Adds a handler on an event of a given DOM element. A {@link org.eclipse.vjet.vsf.Event}
	* object will be passed to the handler function as the first parameter after
	* the event is triggered. 
	*
	* @param {String} id 
	*        A String id of the DOM element 
	* @param {String} eventType 
	*        A string that represents the type of the event
	* @param {Object} handler 
	*        A handler function to be added to the event of the DOM element
	* @param {Object} scope 
	*        A scope that the handler function belongs to
	* @return {Object} 
	*        The added handler function or EventDispatcher itself if the handler 
	*        is not a function
	* @see   org.eclipse.vjet.vsf.Event
	*/
	//> public Object add(String, String, Object, Object);
	add : function(id, eventType, handler, scope) {
		if (!id || !eventType || !handler) {
			return this;
		} 
		var b = this.isBound(id,eventType),
		rv = this.register(id, eventType, handler, scope);
		if (!b) {
			b = this.bind(id, eventType);
			if (b===null) {
				this.unboundElems[this.unboundElems.length] = id;		
			}
		}
		return rv;
	},
	
	/**
	* Attaches a handler on an event of a given DOM element. The handler will 
	* not be registered to the internal VJO registry. No messages will be 
	* emitted to the <code>ServiceEngine</code> if using this function to 
	* register the handler. Use {@link #add} for complete registration.
	*
	* @param {Object} elem 
	*        A DOM element object
	* @param {String} eventType 
	*        A string that represents the type of the event
	* @param {Object} handler 
	*        A handler function to be attached to the event of the DOM element
	* @param {Object} scope 
	*        A scope that the handler function belongs to
	* @param {boolean} capture 
	*        A boolean value representing whether or not to attach the handler
	*        on event capture flow. This parameter is invalid in IE browsers
	* @return {Object} 
	*        Returns the handler function if successfully attached to an 
	*        element. Otherwise, return <code>false</code>.
	* @see   #add
	*/
	//> public Object addEventListener(HTMLElement, String, Object, Object, boolean);
	//> public Object addEventListener(HTMLElement, String, Object, Object);
	//> public Object addEventListener(Window, String, Object, Object);
	//> public Object addEventListener(String, String, Object, Object);
	addEventListener : function(elem,type,listener,scope,capture) {  
		var scp = scope || vjo.global;
		if (typeof elem == 'string') {
			elem = this.vj$.Element.get(elem);
		}
		if (!elem) {
			return false;
		}
		var func = function (event) {
			var ev = event || window.event;
			var rv = listener.call(scp,ev);
			if (rv===false) {
				org.eclipse.vjet.vsf.EventDispatcher.stopEvent(ev);
			}
			if (typeof rv != 'undefined') {
				return rv;
			}
		};
		if (window.addEventListener) {
			elem.addEventListener(type,func,capture||false); 
			this.registerNative(elem,type,func);
			return func;
		} else if (window.attachEvent) {
			elem.attachEvent("on" + type,func); 
			this.registerNative(elem,type,func);
			return func;
		}
		elem["on"+type] = func;
		return false;
	},
	
	/**
	* Binds all handlers registered on the internal VJO registry  to an event of 
	* a DOM element. The function {@link #register} is used to register the 
	* handlers to the internal VJO registry. This function is used after the 
	* handlers are registered. The function {@link #add} covers both two 
	* functions.
	*
	* @param {String} id
	*        A String id of  the DOM element
	* @param {String} eventType
	*        A string that represents the type of the event
	* @return {Object} 
	*        The EventDispatcher itself. If the DOM element to be bound doesn't 
	*        exist, it will return <code>null</code>
	* @see   #add
	* @see   #register
	*/
	//> public Object bind(String, String);
	bind : function (id, eventType) {
		var element = this.vj$.Element.get(id);
		if (id == "body" || element == document.body) {
			element = document.body;
			if (eventType == "load" || eventType == "unload") {
				var rv = this.addEventListener(window,eventType,
						function (event) {
							var oED = org.eclipse.vjet.vsf.EventDispatcher;
							if (typeof oED.fCustomLoad[eventType] == 'function') {
								oED.fCustomLoad[eventType]();
							}
							oED.run(document.body, event || window.event, eventType);
							oED.unregister("body",eventType);
							oED.fCustomLoad = {};
						});
				if (rv===false) {//older browser compatibility
					if (element.vjLoadSet) {
						return this;
					} else {
						element.vjLoadSet = true;
						//store custom onload handlers
						var customLoad = window["on"+eventType] || "";
						if (customLoad) {
							this.fCustomLoad[eventType] = customLoad;
						}
					}
				}
				return this;
			}
		} 
		
		if (element) { //only attach if element exists
			this.addEventListener(element, eventType, this.notifier, element); //pass element so that this works
			return this;
		}
		return null;
	},
	
	
	//> private Object notifier(Object, String);
	notifier : function(event, eventType){
		//return org.eclipse.vjet.vsf.EventDispatcher[eventType](this, event || window.event);
		return org.eclipse.vjet.vsf.EventDispatcher.run(this, event || window.event, eventType);
	},
	
	/**
	* Re-binds all handlers to an event of a DOM element if a new handler is 
	* regiestered.
	* 
	*/
	//> public void reBind();
	reBind : function () {
		var eH = this.eventHandlers, uE = this.unboundElems, 
		len = uE.length, tmp = [];
		
		for (var i=0; i<len; i++) {
			var id = uE[i], hdls = eH[id];
			if (hdls) {
				for (var type in hdls) {
					if (!this.hasBinding(id,type)) {
						var rv = this.bind(id,type);
						if (rv===null) {
							tmp[tmp.length] = id;
						}
					}
				}
			}
		}
		this.unboundElems = tmp;
	},
	
	/**
	* Returns true if a specified event of a DOM element has at least one 
	* handler.
	*
	* @param {String} id 
	*        A String id of the DOM element
	* @param {String} type 
	*        A string that represents the type of the event 
	* @return {boolean} 
	*        True if a specified event of a DOM element has at least one handler
	*/
	//> public boolean isBound(String, String);
	isBound : function (id,type) {
		var handlers = this.eventHandlers[id];
		return (handlers && handlers[type] && handlers[type].length>0);
	},
	
	//> private boolean hasBinding(String, String);
	hasBinding : function (id,type) {
		var nEH = this.nativeEventHandlers;
		if (nEH[id] && nEH[id][type]) {
			var aH = nEH[id][type], len = aH.length, rv = false;
			for (var i = 0; i<len; i++) {
				var str = aH[i].toString();
				if (str && str.indexOf('org.eclipse.vjet.vsf.EventDispatcher')!=-1) {
					return true;
				}
			}
		}
		return false;
	},
	
	/**
	* Removes a handler from an event of a given DOM element. It cannot remove
	* the handler from the internal VJO registry. Use {@link #detachHandlers}
	* for full detaching of the handler.
	*
	* @param {Object} elem 
	*        A DOM element object
	* @param {String} eventType 
	*        A string that represents the type of the event
	* @param {Object} handler 
	*        A handler function to be removed
	* @see   #detachHandlers
	*/
	//> public void removeEventListener(Object, String, Object)
	removeEventListener : function(elem,type,listener) { 
		if (!elem || !type) {
			return;
		} else if (typeof elem == 'string') {
			elem = this.vj$.Element.get(elem);
		}
		if (window.addEventListener && listener) {
			elem.removeEventListener(type,listener,false); 
		}
		else if (window.attachEvent && listener) {
			elem.detachEvent("on" + type,listener); 
		}
		else {
			elem["on"+type] = null;
		}
	},
	
	/**
	* Removes all handler from an event of a given DOM element. It cannot remove
	* the handlers from the internal VJO registry. Use {@link #detachHandlers}
	* for full detaching of the handlers.
	*
	* @param {Object} elem 
	*        A DOM element object
	* @param {String} eventType 
	*        A string that represents the type of the event
	* @param {Object} handler The handler function to be removed
	* @see   #detachHandlers
	*/
	//> public void detachNativeHandlers(Object, String);
	detachNativeHandlers : function (elem,type) {
		var id = (elem==window) ? "body" : elem.id;
		var handlers = this.nativeEventHandlers[id];
		if (handlers && handlers[type]) {
			var h = handlers[type], len = h.length;
			for (var i=0; i<len; i++) {
				this.removeEventListener(elem,type,handlers[type][i]);
			}
			//handlers[type] = [];
			delete handlers[type];
		} 
	},

	/**
	* Detaches a handler on an event of a given DOM element in the internal VJO 
	* registry. The handler will still be triggered by the specified event. Use 
	* {@link #detachHandlers} to safely detach all the handlers. 
	*
	* @param {Object} elem 
	*        A DOM element object
	* @param {String} eventType 
	*        A string that represents the type of the event
	* @param {Object} handler 
	*        The handler function to be removed
	* @see #detachHandlers
	*/
	//> public void detachhandler(String, String, Object);
	detachHandler : function(id, eventType, handler) {
		var handlers = this.eventHandlers[id];
		if (!handlers || !handlers[eventType]) {
			return;
		}
		var h = [], len = handlers[eventType].length;
		for (var i=0; i<len; i++) {
			if (handler != handlers[eventType][i]) {
				h[h.length] = handlers[eventType][i];
			}
		}
		this.eventHandlers[id][eventType] = h;
		
	},

	/**
	* Detaches all handlers bound on an event of a DOM element.
	*
	* @param {Object} elem 
	*        A DOM element object
	* @param {String} eventType 
	*        A string that represents the type of the event
	*/
	//> public void detachHandlers(String, String);
	detachHandlers : function(id, eventType) {
		this.unregister(id,eventType);
		var element = this.vj$.Element.get(id);
		if (id == "body") {
			element = window;
		} 
		
		if (element) {
			this.detachNativeHandlers(element,eventType);
		}
	},
	
	/**
	* Stops any action on an event. This function will stop both the propagation 
	* flow and the event itself.
	*
	* @param {Object} evt 
	*        An event object 
	*/
	//> public void stopEvent(Object);
	stopEvent : function (e) {
		this.stopPropagation(e);
		this.preventDefault(e);
	},
	
	/**
    * Stops executing all remaining handlers on the propagation flow.
    * 
	* @param {Object} evt 
	*        An event object
    */
	//> public void stopPropagation(Object);
	stopPropagation: function(e) {
        if (e.stopPropagation) {
            e.stopPropagation();
        } else {
            e.cancelBubble = true;
        }
    },
    
    /**
    * Cancels the event if it is cancelable.
    * 
	* @param {Object} evt 
	*        An event object
    */
    //> public void preventDefault(Object);
    preventDefault: function(e) {
        if (e.preventDefault) {
            e.preventDefault();
        } else {
            e.returnValue = false;
        }
    },
    
    /**
    * Gets the target element for an event.
    *
	* @param {Object} evt 
	*        An event object
    */
    //> public HTMLElement target(Object);
    target : function(event) { 
		return this.resolveTextNode((event.target)?event.target:event.srcElement);
	},

	currentTarget : function(event) { 
		return this.resolveTextNode((event.currentTarget)?event.currentTarget:event.srcElement);
	},

	/**
    * Gets the secondary target element for an event. Only 'mouseover'
    * and 'mouseout' have this target.
    *
	* @param {Object} evt 
	*        An event object
    */
	//> public HTMLElement relatedTarget(Object);
	relatedTarget : function(event) { 
		if (event.relatedTarget) 
			return this.resolveTextNode(event.relatedTarget);
		else if ((event.type === "mouseover") && event.fromElement) 
			return this.resolveTextNode(event.fromElement);
		else if ((event.type === "mouseout") && event.toElement) 
			return this.resolveTextNode(event.toElement);
		return null;		
	},

	//> private HTMLElement resolveTextNode(Object);
	resolveTextNode : function(node) {
		return (node && (node.nodeType == 3))?node.parentNode:node;
	},
	
	//> private void cleanUp();
	cleanUp : function () {
		var handlers = this.nativeEventHandlers;
		for (var id in handlers) {
			for (var ev in handlers[id]) {
				if (ev!='unload') {//keep unload handlers
					this.detachHandlers(id,ev);	
				}
			}
		}
	},
	
	/**
	 * Detaches all handlers bound on an event of a DOM element.
	 *
	 * @param {Object} elem
	 *        A DOM element object
	 * @param {String} eventType
	 *        A string that represents the type of the event
	*/
	//>public void detachAllElemHandlers(Object, String)
	detachAllElemHandlers : function(elem, eventType){
		 if (!elem) return;

		 if (elem.id){
			 this.unregister(elem.id, eventType);
			 if (elem.id == "body") {
				 elem = window;
			 }
		 }
		 this.detachNativeHandlers(elem, eventType);
	 },

	//> private String getId(Object);
	//> private String getId(Object, String);
	getId : function(src, id) {
		return (id === null || !id)?src.id:id;
	},
	
	//> private String getBodyId(Object);
	//> private String getBodyId(Object, String);
	getBodyId : function(src, id) {
	    var srcId = this.getId(src, id);
	    if (!srcId || src == document.body) {
	        srcId = "body";
	    }
	    return srcId;
	},
	
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>unload</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object unload(Object, Object);
	unload : function(src, pEvent) {
		return this.process(this.getBodyId(src), new org.eclipse.vjet.vsf.Event(src, 'unload', pEvent));
	},
		
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>change</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object change(Object, Object);
	change : function(src, pEvent) {
		return this.process(this.getId(src), new org.eclipse.vjet.vsf.Event(src, 'change', pEvent));
	},
	
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>submit</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object submit(Object, Object);
	submit : function(src, pEvent) {
		return this.process(this.getId(src), new org.eclipse.vjet.vsf.Event(src, 'submit', pEvent));
	},
	
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>reset</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object reset(Object, Object);
	reset : function(src, pEvent) { 
		return this.process(this.getId(src), new org.eclipse.vjet.vsf.Event(src, 'reset', pEvent));
	},
	
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>select</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object select(Object, Object);
	select : function(src, pEvent) { 
		return this.process(this.getId(src), new org.eclipse.vjet.vsf.Event(src, 'select', pEvent));
	},
	
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>blur</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object blur(Object, Object);
	blur : function(src, pEvent) { 
		return this.process(this.getId(src), new org.eclipse.vjet.vsf.Event(src, 'blur', pEvent));
	},
	
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>focus</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object focus(Object, Object);
	focus : function(src, pEvent) { 
		return this.process(this.getId(src), new org.eclipse.vjet.vsf.Event(src, 'focus', pEvent));
	},
	
	
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>keydown</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object keydown(Object, Object);
	keydown : function(src, pEvent) { 
		return this.process(this.getBodyId(src), new org.eclipse.vjet.vsf.Event(src, 'keydown', pEvent));
	},
	
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>keypress</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object keypress(Object, Object);
	keypress : function(src, pEvent) { 
		return this.process(this.getBodyId(src), new org.eclipse.vjet.vsf.Event(src, 'keypress', pEvent));
	},
	
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>keyup</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object keyup(Object, Object);
	keyup : function(src, pEvent) { 
		return this.process(this.getBodyId(src), new org.eclipse.vjet.vsf.Event(src, 'keyup', pEvent));
	},
	
	
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>click</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object click(Object, Object);
	click : function(src, pEvent) {
		return this.process(this.getBodyId(src), new org.eclipse.vjet.vsf.Event(src, 'click', pEvent));
	},
	
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>dblclick</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object dblclick(Object, Object);
	dblclick : function(src, pEvent) {
		return this.process(this.getBodyId(src), new org.eclipse.vjet.vsf.Event(src, 'dblclick', pEvent));
	},
	
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>mousedown</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object mousedown(Object, Object);
	mousedown : function(src, pEvent) {
		return this.process(this.getBodyId(src), new org.eclipse.vjet.vsf.Event(src, 'mousedown', pEvent));
	},
	
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>mousemove</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object mousemove(Object, Object);
	mousemove : function(src, pEvent) {
		return this.process(this.getBodyId(src), new org.eclipse.vjet.vsf.Event(src, 'mousemove', pEvent));
	},
	
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>mouseout</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object mouseout(Object, Object);
	mouseout : function(src, pEvent) {
		return this.process(this.getBodyId(src), new org.eclipse.vjet.vsf.Event(src, 'mouseout', pEvent));
	},
	
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>mouseover</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object mouseover(Object, Object);
	mouseover : function(src, pEvent) {
		return this.process(this.getBodyId(src), new org.eclipse.vjet.vsf.Event(src, 'mouseover', pEvent));
	},
	
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>mouseup</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object mouseup(Object, Object);
	mouseup : function(src, pEvent) {
		return this.process(this.getBodyId(src), new org.eclipse.vjet.vsf.Event(src, 'mouseup', pEvent));
	},	

	//> public Object contextmenu(Object, Object);
	contextmenu : function(src, pEvent) {
		return this.process(this.getBodyId(src), new org.eclipse.vjet.vsf.Event(src, 'contextmenu', pEvent));
	},	
		
	/**
	* Executes all registered handlers associated with given DOM element on 
	* <code>load</code> event. This function has been deprecated, 
	* you can use {@link #run} instead.
	*
	* @deprecated 
	* @param {Object} src 
	*        A DOM element the handlers registed on
	* @param {Object} event 
	*        Browser's native event of the triggered event
	* @return {Object} 
	*        The result of the handlers 
	* @see   #run
	*/
	//> public Object load(Object, Object);
	load : function(src, pEvent) {
		return this.run(src, pEvent, 'load');
	},
	
	/**
	* Executes all registered handlers associated with given DOM element and 
	* event. The handlers registed on <code>body</code> for the 
	* <code>load</code> event will be removed when this function is first 
	* executed. It will make sure that the handler for <code>load</code> will be 
	* executed once and only once.
	*
	* @param {Object} src 
	*        A DOM element the handlers are registed on
	* @param {Object} event 
	*        Browser's native event object of the triggered event
	* @param {String} eventType 
	*        A string representing the event type
	* @return {Object}
	*        The result of the handlers 
	*/
	//> public Object run(Object, Object, String);
	run : function (src, pEvent, eventType) {
		var et = eventType || pEvent.type;
		var id = this.getBodyId(src);
		var vEvt = new org.eclipse.vjet.vsf.Event(src, et, pEvent);
		var rv = this.process(id, vEvt);
		if (et==='load' && id==='body') {
			this.unregister('body', 'load'); 
		}
		return rv;
	}
	
})
.inits(function() {
	//must cleanup on page unload	
	org.eclipse.vjet.vsf.EventDispatcher.addEventListener(window,'load',function(){
		org.eclipse.vjet.vsf.EventDispatcher.addEventListener(window,'unload',function(){
			org.eclipse.vjet.vsf.EventDispatcher.cleanUp();
		});
	});
})
.endType();