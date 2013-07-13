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
* Utility class for HTML <code>Select</code> element.
*/
vjo.ctype("org.eclipse.vjet.vsf.document.Select")
.needs("org.eclipse.vjet.vsf.Element")
.props({
	E : org.eclipse.vjet.vsf.Element,
	
	/**
	* Adds a new option to a select list.
	* 
	* @param {Object} select 
	*        the referernce of the select element
	* @param {String} val
	*        the value of the newly added option. It will be the value of
	*        <code>value</code> attribute of the option, such as, 
	*        <code>&lt;option value="val"&gt;</code>
	* @param {String} text
	*        the display text of the newly added option. It looks like
	*        <code>&lt;option&gt;text&lt;/option&gt;</code>
	*        
	*/
	//> public void addOption(Object,String,String);
	addOption : function(poSelect, psVal, psText) {
		var t = this, e = t.get(poSelect), o, os;
		if(e)
		{
			o = t.createOption(psText,psVal);
			os = e.options;
			os[os.length] = o;
		}
	},


	
	/**
	* Creates a HTML option element for the select control.
	* <p>
	* Two parameters could be specified here when creating option element. See 
	* parameters description in details.
	*
	* @param {String} text
	*        the display text of the newly added option. It looks like
	*        <code>&lt;option&gt;text&lt;/option&gt;</code>
	* @param {String} val
	*        the value of the newly added option. It will be the value of
	*        <code>value</code> attribute of the option, such as, 
	*        <code>&lt;option value="val"&gt;</code>
	* @param {boolean} defSel
	*        <code>true</code> if current option is default selected option.
    *        Only one option in a select element could be set as 
    *        <code>ture</code> at a time
	* @param {boolean} sel
	*        <code>true</code> if current option is selected. Multiple options
	*        in a select element could be set as <code>true</code>. It's usually 
	*        used in multiple select mode.
	* @return {Object}
	*        the newly created option element. It looks like
	*        <code>&lt;option value="val"&gt;text&lt;/option&gt;</code>
	*/
	//> public Option createOption(String,String,boolean?,boolean?);
	createOption : function(psText, psVal, pbDefSel, pbSel) {
		var defSel = pbDefSel?pbDefSel:false;
		var sel = pbDefSel?pbSel:false;
		return new Option(psText,psVal,defSel,sel);
	},
	
	/**
	* Cleans all options in a given select element
	*
	* @param {Object} select
	*        a reference of the select element that all options will be removed 
	*        from
	*/
	//> public void clear(Object);
	clear : function(poSelect) {
		var e = this.get(poSelect), os, i, l;
		if(e){
			os = e.options;
			l = os.length;
			for(i=l-1;i>=0;i--){
				os[i] = null;
			}
		}
	},
	
	//> private Object get(String);
	get : function(poSelect){
		var e = poSelect;
		if(typeof(poSelect)=="string"){
			e = this.E.get(poSelect);
		}
		return e;
	}
	
})
.endType();

