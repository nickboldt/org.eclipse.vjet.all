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
vjo.ctype("vjo.Registry")
.props({
	controls : [],
	//> public Object put(String, Object)
	put : function(psKey,poControl){
		this.controls[psKey] = poControl;
		if (this.isKeyValid(psKey)) {//make shorthand reference
			this['_'+psKey] = this.controls[psKey];
		}
		return this.controls[psKey];
	},

	//> public Object get(String)
	get : function(psKey){
		return this.controls[psKey];
	},
	
	//> public String dump()
	dump : function(){
		var controls = this.controls;
		var string = "controls on page:\n";
		for(var i in controls){
			string += "key = " + i;
			string += "controlName = " + controls[i].objtype;
			string +="\n";
		}
		return string;
	},
	isKeyValid : function (psKey) {
		if (typeof psKey != 'string') { 
			return false; 
		}
		return /^([a-zA-Z0-9_$]+)$/.test(psKey);
	}
})
.endType();