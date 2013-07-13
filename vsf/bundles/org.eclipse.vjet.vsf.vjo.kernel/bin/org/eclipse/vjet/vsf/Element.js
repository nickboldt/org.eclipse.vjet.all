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
* A class contains utilities used to handle DOM elements. The functions in this 
* class encapsulate frequently used JavaScript attributes and functions, and 
* make them compatible in most popular browsers.
*/
vjo.ctype("org.eclipse.vjet.vsf.Element")
.props({
	/**
	* Gets the DOM element object with a given id. 
	*
	* @param {String} id 
	*        A string id of the DOM element
	* @return {String}
	*        The DOM element with the given id
	*/
	//> public Object get(String);
	get : function(psId) {
		return document.getElementById(psId);
	},
	
	/**
	* 
	* Specifies whether or not a DOM element should be displayed. This function 
	* uses the <code>style.display</code> property. If the element is not 
	* displayed, it does not affect the page layout.
	*
	* @param {String} id 
	*        A String id of the DOM element to be shown/hidden
	* @param {boolean} display 
	*        A boolean value representing whether or not to show the element
	* @see   org.eclipse.vjet.vsf.Element.toggleVisibility
	*/
	//> public void toggleHideShow(String,boolean);
	//> public void toggleHideShow(String);
	toggleHideShow : function(psId, pbDisplay) {
		var e = this.get(psId), s, d, u = "undefined";
		if (e)
		{
			s = e.style;
			d = s.display;
			if (typeof(pbDisplay)===u)
			{
				pbDisplay = (d === "" || d === "block") ? false : true;
			}
			e.bIsShown = pbDisplay;
			s.display = (pbDisplay) ? "block" : "none";
		}	
	},
	
	/**
	* Appends a specified DOM element to the <code>BODY</code> element. 
	*
	* @param {String} id 
	*        A String id of the DOM element
	*/
	//> public void promoteToBody(String);
	promoteToBody : function(psId) {
		var e = this.get(psId), b = document.body;
		if(e && b && e.parentNode && (e.parentNode !== b)){
			e.parentNode.removeChild(e);
			b.appendChild(e);
		}
	},
	
	/**
	* Specifies whether or not a DOM element should be visible. This function 
	* uses the <code>style.visibility</code> property. Making the element 
	* invisible will affect the layout.
	*
	* @param {String} id 
	*        A String id of the DOM element
	* @param {boolean} display 
	*        A boolean value representing whether or not the element should be 
	*        visible
	* @see   org.eclipse.vjet.vsf.Element.toggleVisibility
	*/
	//> public void toggleVisibility(String,boolean);
	//> public void toggleVisibility(String);
	toggleVisibility : function(psId, pbVisible) {
		var e = this.get(psId), v, s, u = "undefined";
		if (e)
		{
			s = e.style;
			v = s.visibility;
			if (typeof(pbVisible)===u)
			{
				pbVisible = (v === "") ? false : true;
			}
			
			e.bIsVisible = pbVisible;
			s.visibility = (pbVisible) ? "" : "hidden";
		}
	},
	
	/**
	* Sets a DOM element whther or not to be enable. If the element is disabled,
	* no action would be invoked by any event on it.
	*
	* @param {String} id 
	*        A String id of the DOM element
	* @param {boolean} enable 
	*        A boolean value representing whether or not the element should be 
	*        enable
	*/
	//> public void enable(String,boolean);
	enable : function(psId, pbEnable) {
		var e = this.get(psId);
		if (e)
			e.disabled = !pbEnable;
	},
	
	/**
	* Sets how far the left edge of an element is to the right of the left edge 
	* of the parent element.
	*
	* @param {String} id 
	*        A String id of the DOM element
	* @param {String} left 
	*        A String that represents the number of the left offset
	* @return {String} 
	*        A String that represents the number of the left offset which is 
	*        same as the parameter <code>left</code>
	*/
	//> public String left(String,String);
	left : function(psId, psLeft) {
		return this.setLTWH(psId, psLeft, "Left");
	},

	/**
	* Sets how far the top edge of an element is above the top edge of the 
	* parent element.
	*
	* @param {String} id 
	*        A String id of the DOM element
	* @param {String} top 
	*        A String represents the number of the top offset
	* @return {String} 
	*        A String represents the number of the top offset which is same as 
	*        the parameter <code>top</code>
	*/
	//> public String top(String,String);
	top : function(psId, psTop)	{
		return this.setLTWH(psId, psTop, "Top");
	},
	
	/**
	* Sets the width of the element.
	*
	* @param {String} id 
	*        A String id of the DOM element
	* @param {String} width 
	*        A String that represents the number of the width
	* @return {String} 
	*        A String that represents the number of the width which is same as 
	*        the parameter <code>width</code>
	*/
	//> public String width(String,String);
	width : function(psId, psWidth)	{
		return this.setLTWH(psId, psWidth, "Width");
	},
	
	/**
	* Sets the height of the element.
	*
	* @param {String} id 
	*        A String id of the DOM element
	* @param {String} height 
	*        A String that represents the number of the height 
	* @return {String} 
	*        A String that represents the number of the height which is same as 
	*        the parameter <code>height</code>
	*/
	//> public String height(String,String);
	height : function(psId, psHeight) {
		return this.setLTWH(psId, psHeight, "Height");
	},
		
	//> protected String top(String,String,String);
	setLTWH : function(psId, psVal, psName) {
		var e = this.get(psId);
		if (e)
		{
			if ((psVal != null) && !isNaN(parseInt(psVal)))
				e.style[psName.toLowerCase()] = psVal;
			return e["offset" + psName];
		}
	},
	
	/**
	* Creates a DOM element with the given name.
	* 
	* @param {String} name 
	*        A String name of the created element
	* @return {Object} 
	*        Newly created DOM element
	*/
	//> public Object createElement(String);
	createElement : function(name) {
		return document.standardCreateElement?document.standardCreateElement(name):document.createElement(name);//<@SUPRESSTYPECHECK
	},

	/**
	* Checks whether a DOM element is in the specified container.
	* 
	* @param {Object} container 
	*        A DOM element as the container
	* @param {Object} element 
	*        The DOM element to be checked
	* @return {boolean} 
	*        True if the element's parent is the specified container.
	*/
	// public boolean createElement(Object, Object);
	containsElement : function(container,element) {
		while ((element != null) && (element != container) && (element.parentNode != null)) { element = element.parentNode; }
		return (element == container);
	},

	/**
	* Returns a DOM elements with the specified tag name and class style. If 
	* multiple elements are matched, returns the first element. If no such 
	* element is found, returns <code>null</code>. 
	* 
	* @param {Object} element 
	*        An element from where the search should start. Only the descendants 
	*        of this element are included in the search, but not the element 
	*        itself 	
	* @param {String} tagName 
	*        A tag name to be searched
	* @param {String} className 
	*        A class name the element to be applied
	* @return {Object} 
	*        The first matched element. if nothing is found, returns 
	*        <code>null</code>
	* @see   #getElementsByTagClass
	*/
	//> public Object getElementByTagClass(Object, String, String);
	getElementByTagClass : function(element,tag,name) {
		var tags = element.getElementsByTagName(tag);
		for (var ndx = 0;((ndx < tags.length) && (tags[ndx].className.match(name) == null));ndx++);
		return (ndx < tags.length)?tags[ndx]:null;
	},

	/**
	* Returns a collection of DOM elements with the specified tag name and class 
	* style. If no such element are found, returns an empty collection.
	* 
	* @param {Object} element 
	*        An element from where the search should start. Only the descendants 
	*        of this element are included in the search, but not the element 
	*        itself 	
	* @param {String} tagName 
	*        A tag name to be searched
	* @param {String} className 
	*        A class name the element to be applied
	* @return {Object} 
	*        The array containing all found object elements. If nothing is 
	*        found, returns an empty array.
	* @see   #getElementByTagClass
	*/
	//> public Object getElementsByTagClass(Object, String, String);
	getElementsByTagClass : function(element,tag,name) {
		var elements = new Array();
		var tags = element.getElementsByTagName(tag);
		for (var ndx = 0;(ndx < tags.length);ndx++) {
			if (tags[ndx].className.match(name)) elements.push(tags[ndx]);
		}
		return elements;
	},
	//> public void toggleHideShowRow(String,boolean);
	//> public void toggleHideShowRow(String);
	toggleHideShowRow : function(psId, pbDisplay) {
		var e = this.get(psId), ua = navigator.userAgent.toLowerCase(), s, d, u = "undefined",
		p = (ua.indexOf('firefox')!=-1)?"table-row":"block";
		if (e)
		{
			s = e.style;
			d = s.display;
			if (typeof(pbDisplay)===u)
			{
				pbDisplay = (d === "" || d === p) ? false : true;
			}
			e.bIsShown = pbDisplay;
			s.display = (pbDisplay) ? p : "none";
		}	
	}
})
.endType();



