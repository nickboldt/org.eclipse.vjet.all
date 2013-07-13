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
vjo.ctype('org.eclipse.vjet.vsf.EventBindingUtil')
.needs('org.eclipse.vjet.vsf.EventDispatcher', 'ED')
.props({
	s_elem2AssocMap:[], //Id to associator map
	s_assoc2ElemMap:[], //Instances to id map

 	//> public void detachAll(Object, boolean)
 	detachAll : function(elem, cleanAssociators){
 		if(!elem) return;
 		this.detachEvents(elem, cleanAssociators);
 		//Get all child nodes of the given object
 		var children = elem.getElementsByTagName('*');
 		for(var i=0,l=children.length;i<l;i++){
			this.detachEvents(children[i], cleanAssociators);
 		}
 	},

	//> public void detachEvents(HTMLElement, boolean)
 	detachEvents : function(elem, cleanAssociators){
		if(!elem) return;
		var ED = this.vj$.ED;
		var handlers = ED.nativeEventHandlers;
		var elemId = elem.id;
		if(!elemId) return;
		for (var evt in handlers[elemId]) {
			if(evt){
				ED.detachAllElemHandlers(elem, evt);
			}
		}
		if(cleanAssociators) {
			var associators = this.s_elem2AssocMap[elemId];
			if(associators) {
				for(var associatorId in associators){
					//find other elements associated with the same instance
					var relatedeIds = this.s_assoc2ElemMap[associators[associatorId]];
					if(relatedeIds) {
						this.cleanUp(relatedeIds);
						this.unregisterElems(associators[associatorId]);
					}
				}
			}
		}
		this.unregisterAssociators(elemId);
  	},

	/**
	* Detach all event handlers attached to an element
	* @param {String} ids
	*        Id of the element
	* @param {boolean} cleanDescendents
	*        Detach events attached to the descendent nodes
	* @param {boolean} cleanInsElems
	*      	  Clean other elements associated with the same instance
	*/

 	 //> public void cleanUp(String)
	 //> public void cleanUp(String[])
	 //> public void cleanUp(String, boolean)
	 //> public void cleanUp(String[], boolean )
	 //> public void cleanUp(String, boolean, boolean)
	 //> public void cleanUp(String[], boolean, boolean)
	 //> public void cleanUp(String, boolean, boolean)
	 cleanUp : function(elemIds, cleanDescendents, cleanAssocElems){
		if(!elemIds) return;
		//If an array of element ids is passed as input
		var list = elemIds, elem;
		if(!(elemIds instanceof Array)) {
			list = [elemIds];
		}
		for (var i in list){
			elem = document.getElementById(list[i]);
			if(elem) {
				if (cleanDescendents) 
					this.detachAll(elem, cleanAssocElems);
				else
					this.detachEvents(elem, cleanAssocElems);
			}
		}
	},

	//> public void register(String, String)
	register : function(elemId, associator){
		var associators;
		if(!this.s_elem2AssocMap[elemId]){
			associators = [];
			this.s_elem2AssocMap[elemId] = associators;
		} else {
			associators = this.s_elem2AssocMap[elemId];
		}
		associators.push(associator);
		
		var elemIds;
		if(!this.s_assoc2ElemMap[associator]){
			elemIds = [];
			this.s_assoc2ElemMap[associator] = elemIds;
		} else {
			elemIds = this.s_assoc2ElemMap[associator];
		}
		elemIds.push(elemId);
	},

	//> public void unregister(String, String)
	unregister : function(elemId, associator){
		this.unregisterAssociators(elemId);
		this.unregisterElems(associator);
	},
	
	//> private void unregisterAssociators(String)
	unregisterAssociators : function (elemId) {
		if(elemId && this.s_elem2AssocMap[elemId]) {
			this.s_elem2AssocMap[elemId] = null;
			delete this.s_elem2AssocMap[elemId];
		}
	},
	
	//> private void unregisterElems(String)
	unregisterElems : function (associator) {
		if(associator && this.s_assoc2ElemMap[associator]) {
			this.s_assoc2ElemMap[associator] = null;
			delete this.s_assoc2ElemMap[associator];
		}
	},
	
	/**
	* Attach an handler
	* @param {String} id
	*        A String id of the DOM element
	* @param {String} eventType
	*        A string that represents the type of the event
	* @param {Object} handler
	*        A handler function to be added to the event of the DOM element
	* @param {Object} scope
	*        A scope that the handler function belongs to
	* @param {Object} associator
	*       The instance in which the actual event attachment takes place.This is useful in finding  all the elements
	*       associated with an instance
	**/
	//> public void add(String, String, Object, Object, Object);
	bind : function(id, eventType, handler, scope, associator) {
		var ED = org.eclipse.vjet.vsf.EventDispatcher;
		ED.add(id, eventType, handler, scope);
		//TODO - hashCode is not guaranteed to be unique.
		if(associator && associator.hashCode) {
			this.register(id, associator.hashCode());
		} else {
			//TODO - what if it didn't have hashcode?
		}
	}
})
.endType();