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
* Represents a service engine runtime error.
*/
vjo.ctype('org.eclipse.vjet.vsf.Error')
.protos({
	id:undefined, //<public String
	message:undefined, //<public String
	
	/**
	* Creates a new instance for the service engine runtime error.
	* 
	* @param {String} id 
	*        An id of this error instance
	* @param {String} message 
	*        A content of this error instance
	* @constructor 
	*/
	//>public void constructs();
	//>public void constructs(String);
	//>public void constructs(String, String);
	constructs : function (psId,psMessage) {
		this.id = psId;
		this.message = psMessage;
	}
})
.endType();