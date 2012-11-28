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
vjo.ctype('org.eclipse.vjet.vjo.java.lang.BooleanUtil')
.props({
	TRUE : null, //< public Boolean
	FALSE : null,  //< public Boolean
	
    //> public boolean booleanValue(Boolean b)
	booleanValue : function (b){
		return b.valueOf();
	},
    //> public boolean getBoolean(String name)
	getBoolean : function (name){
		return ( (name=='true')?true:false );
	},
    //> public boolean parseBoolean(String s)
	parseBoolean : function (s) {
		return this.toBoolean(s);
	},
    //> public boolean toBoolean(String name)
	toBoolean : function (name) {
		return (name != null && name.toLowerCase() == "true");
	},
    //> public String toString(boolean val)
    //> public String toString(Boolean val)
	toString : function (val) {
		var b;
		if (typeof val == 'boolean') {
			b = val;
		} else {
			b = val.valueOf();
		}
		return b ? "true" : "false";
	},
    //> public Boolean valueOf_(boolean val)
    //> public Boolean valueOf_(String val)
	valueOf_ : function (val) {
		var b;
		if (typeof val == 'string' && (val == 'true' || val == 'false')) {
			b = eval(val);
		} else if (typeof val == 'boolean') {
			b = val;
		}
		return (b?this.TRUE:this.FALSE);
	}
})
.inits(function(){
	this.FALSE = new Boolean(false);
	this.TRUE = new Boolean(true);
})
.endType();