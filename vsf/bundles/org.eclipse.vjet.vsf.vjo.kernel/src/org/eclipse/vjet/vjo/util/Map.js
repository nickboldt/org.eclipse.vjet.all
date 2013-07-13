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
* Represents an map structrue used to handle response data.
*/
vjo.ctype('org.eclipse.vjet.vjo.util.Map')
.protos({
	//> public void constructs();
	//> public void constructs(Object);
	//> public void constructs(java.util.HashMap);
	constructs : function (psJavaClass) {
		this.javaClass = psJavaClass || 'java.util.HashMap';
		this.map = {};
	},
	
	/**
	* Returns the element with the specified key in this map.
	*
	* @param {Object} key 
	*        An object used as key value
	* @return {Object} 
	*        The element with the key
	*/
	//> public Object get(Object);
	get : function (key) {
		return this.map[key];
	},
	
	/**
	* Appends the specified element to the map. 
	*
	* @param {Object} key 
	*        An object used as key value
	* @param {Object} value 
	*        An object value with a key
	* @return {Object} 
	*        The added object
	*/
	//> public Object add(Object, Object);
	put : function (key,value) {
		return this.map[key] = value;
	},
	
	/**
	* Removes a specified value with specified key object.
	* 
	* @param {Object} key 
	*        A key object of the value object to be removed
	* @return {boolean} 
	*        The removed value object
	*/
	//> public boolean remove(Object);
	remove : function (key) {
		var val = this.map[key];
		delete this.map[key];
		return val;
	},
	
	/**
	* Gets the number of key-value pairs in current map.
	*
	* @return {int} 
	*         The number of key-value pairs
	*/
	//> public int size();
	size : function () {
		var count = 0;
		for (var key in this.map){
			count ++;
		}
		return count;
	}
	//TODO: keys & values, or possibly a foreach that takes a function
})
.endType();