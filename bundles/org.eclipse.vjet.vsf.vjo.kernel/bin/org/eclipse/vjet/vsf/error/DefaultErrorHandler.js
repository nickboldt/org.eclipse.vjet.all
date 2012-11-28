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
* Defines the default handler used to process the runtime error.
*/
vjo.ctype("org.eclipse.vjet.vsf.error.DefaultErrorHandler")
.needs("org.eclipse.vjet.vsf.error.ErrorHandlerManager","M")
.protos({
	//>public void constructs();
	constructs : function () {
	},
	
	/**
	* Defines the default action when a runtime error occured. 
	*
	* @param {String} message 
	*        A string message describes the error
	* @param {String} url 
	*        An page url where causes the eror
	* @param {String} lineNumber 
	*        A number value indecates the line where the error happens
	*/
	//>public void handle(String,String,String);
	handle : function (psMessage, psUrl, psLineNumber) {
		this.vj$.M.add(psMessage, psUrl, psLineNumber);
	}
})
.endType();
