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
* Represents the response from a service.
*/
vjo.ctype('org.eclipse.vjet.vsf.ServiceResponse') //< public
//>needs org.eclipse.vjet.vsf.Error
.protos({	
	objType:undefined, //<public String
	errors:undefined, //<public Array
	data:undefined, //<public Object
	
	//> public void constructs();
	constructs : function () {
		this.errors = []; // FIXME had to add due to new instances would retain old errors 
	},
	//> public void addError(Error error)
	addError : function (error) {
		if (this.errors) {
			this.errors[this.errors.length] = error;
		}
	}
})
.endType();