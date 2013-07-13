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

vjo.ctype("org.eclipse.vjet.vsf.error.SampleErrorHandler")
.protos({

	//> public void constructs();
	constructs : function () {
	},
	
	//> public void handle(String,String,String);
	handle : function (psMessage, psUrl, psLineNumber) {
		//do something
		alert("sample error handler");
	}
})
.endType();
