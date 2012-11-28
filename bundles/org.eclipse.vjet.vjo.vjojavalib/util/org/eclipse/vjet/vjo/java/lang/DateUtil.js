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
vjo.ctype('org.eclipse.vjet.vjo.java.lang.DateUtil')
.props({
	/**
	* This method is to create Date object like in Java 
	* where year is number of years from 1900
	* y should be number of years from 1900, Ex: year 2009 -> y = 109
	**/
	create : function (y, m, d, hh, mm, s, ms) {
		return new Date(y + 1900, m, d, hh, mm, s, ms);
	},
	
	after : function (dt, whn) {
		return (this.getMillisOf(dt) > this.getMillisOf(whn));
	},
	
	before : function (dt, whn) {
		return (this.getMillisOf(dt) < this.getMillisOf(whn));
	},
	
	getMillisOf : function (dt) {
		return dt.getTime();	
	},
	
	getTimezoneOffset : function (dt) {
		throw "Not supported";
	},
	
	compareTo : function (dt, anotherDate) {
		var thisTime = this.getMillisOf(dt);
		var anotherTime = this.getMillisOf(anotherDate);
		return ( (thisTime<anotherTime)? -1 : ( (thisTime==anotherTime)? 0 : 1 ) );
	},
	
	hashCode : function (dt) {
		var ht = dt.getTime();
    	return (ht ^ (ht >> 32));
	},
	
	equals : function (dt1, dt2) {
		if (dt1 === dt2) {
			return true;
		}
		if (dt1 !== null && dt2 !== null) {
			return (dt1.getTime() === dt2.getTime());
		}
		return false;
	}
})
.endType();