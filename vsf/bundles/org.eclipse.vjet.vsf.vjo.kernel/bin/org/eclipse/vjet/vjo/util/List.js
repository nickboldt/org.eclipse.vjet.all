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
* Represents an list structrue used to handle response data.
*/
vjo.ctype('org.eclipse.vjet.vjo.util.List')
.protos({
	//> public void constructs(Object);
	//> public void constructs(java.util.ArrayList);
	constructs : function (psJavaClass) {
		this.javaClass = psJavaClass || 'java.util.ArrayList';
		this.list = [];
	},
	
	/**
	* Returns the element at the specified position in this list.
	*
	* @param {int} index 
	*        Index of element to return
	* @return {Object} 
	*        The element on the position
	*/
	//> public Object get(int);
	get : function (index) {
		if (this.size()>index) {
			return this.list[index]
		}
		//array out of bounds exception?
		return null;
	},
	
	/**
	* Appends the specified element to the end of this list (optional operation). 
	*
	* @param {Object} value 
	*        Element to be appended to this list
	* @return {Object} 
	*        The added element
	*/
	//> public Object add(Object);
	add : function (value) {
		return this.list[this.size()] = value;
	},
	
	/**
	* Removes the value if it in the list.
	* 
	* @param {Object} value 
	*        Element to be removed
	* @return {boolean} 
	*        True if the element in the list and be successfully removed
	*/
	//> public boolean remove(Object);
	remove : function (value) {//TODO: by index also?
		var len = this.size(), tmp = this.list, nlist = [], rv = false;
		for (var i=0; i<len; i++) {
			if (!rv && tmp[i]===value) {
				rv = true;
			} else {
				nlist[nlist.length] = tmp[i];
			}
		}
		this.list = nlist;
		return rv;
	},
	
	/**
	* Gets the length of current list.
	*
	* @return {int} 
	*         The length of current list 
	*/
	//> public int size();
	size : function () {
		return this.list.length;
	}
	//for all in?
})
.endType();