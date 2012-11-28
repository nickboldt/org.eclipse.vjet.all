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
vjo.ctype("org.eclipse.vjet.vsf.utils.logging.Level")
.protos({
	/**
	*	@access public
	*	@param {String} name
	*	@param {int} value
	*/
	//>public constructs (String name, int value)
	constructs: function(name, value){
		this.name = name;
		this.value = value;
	},

	getName: function(){
		return this.name;
	},
	
	intValue: function(){
		return this.value;
	}
})
.props({
	OFF:		new org.eclipse.vjet.vsf.utils.logging.Level('OFF', 		9999),
	SEVERE:		new org.eclipse.vjet.vsf.utils.logging.Level('SEVERE', 	1000),
	WARNING:	new org.eclipse.vjet.vsf.utils.logging.Level('WARNING',	900),
	INFO:		new org.eclipse.vjet.vsf.utils.logging.Level('INFO',		800),
	CONFIG:		new org.eclipse.vjet.vsf.utils.logging.Level('CONFIG',	700),
	FINE:		new org.eclipse.vjet.vsf.utils.logging.Level('FINE',		500),
	FINER:		new org.eclipse.vjet.vsf.utils.logging.Level('FINER',	400),
	FINEST:		new org.eclipse.vjet.vsf.utils.logging.Level('FINEST',	300),
	ALL:		new org.eclipse.vjet.vsf.utils.logging.Level('ALL',		-9999),

	//have to do init for known like this, due to the diference between java & VJO
	known:		null,
	setKnown: function(){
		if(!this.known){
			this.known = [
					this.OFF,
					this.SEVERE,
					this.WARNING,
					this.INFO,
					this.CONFIG,
					this.FINE,
					this.FINER,
					this.FINEST,
					this.ALL
			];
				
		}
	},
	/**
	*	@access public
	*	@param {String} name
	*/
	//>public void parse (String name)
	parse: function(name){
		this.setKnown();
		var l = null;
		for(var i=0; i<this.known.length; i++){
			if(this.known[i].getName() === name){
				l = this.known[i];
				break;
			}
		}
		if(!l){		
			var v = parseInt(name, 10);
			if(v){
				for(var j=0; j<this.known.length; j++){
					if(this.known[j].intValue() === v){
						l = this.known[j];
						break;
					}
				}
				if(!l){
					l = new this(name, v);
					this.known[this.known.length] = l;
				}
			}
		}
		if(!l){
			throw new Error("Bad level \"" + name + "\"");		
		}
		return l;
	}
})
.endType();
