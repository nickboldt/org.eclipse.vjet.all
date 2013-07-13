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
vjo.ctype("org.eclipse.vjet.vsf.utils.logging.Handler")
.needs("org.eclipse.vjet.vsf.utils.logging.Level")
.needs("org.eclipse.vjet.vsf.utils.logging.SimpleFormatter")
.protos({
	
	constructs: function(name){
		this.configure(name);
		this.name = name;//help to debug
	},
	
	configure: function(hName) {
		var t = this,
			manager = org.eclipse.vjet.vsf.utils.logging.LogManager.getLogManager();		

		t.setLevel(manager.getLevelProperty(hName + ".level", org.eclipse.vjet.vsf.utils.logging.Level.INFO));
		t.setFormatter(manager.getFormatterProperty(hName + ".formatter", new org.eclipse.vjet.vsf.utils.logging.SimpleFormatter()));
	},
	
	setLevel: function(level){
		this.level = level;
	},
	
    //> private Object getLevel()
	getLevel: function(){
		return this.level;
	},
	
	setFormatter: function(formatter){
		this.formatter = formatter;
	},
	
    //> Object getFormatter()
	getFormatter: function(){
		return this.formatter;
	},

//publish
	OFFVALUE:	this.vj$.Level.OFF.intValue(),
	
	isLoggable: function(record) {
		var levelValue = this.getLevel().intValue();
		if (record.getLevel().intValue() < levelValue || levelValue == this.OFFVALUE) {
			return false;
		}
		//extend filter part here
		return true;
	},
	
	publish: function(lr){
		if(this.isLoggable(lr)){
			this.innerPublish(lr);
		}
	},
	
	innerPublish: function(lr){
		//to be extended in children
	}
})
.endType();
