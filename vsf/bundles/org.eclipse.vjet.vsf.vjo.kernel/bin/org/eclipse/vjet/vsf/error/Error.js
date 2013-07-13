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
* Represents a dsf runtime error.
*/
vjo.ctype("org.eclipse.vjet.vsf.error.Error")
.protos({
	//> public void constructs(String,String,String);
	constructs : function (psMessage, psUrl, psLineNumber) {
		this.message = psMessage;
		this.url = psUrl;
		this.lineNumber = psLineNumber;
		this.userAgent = navigator.userAgent;
	}
})
.endType();