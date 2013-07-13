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
vjo.ctype("org.eclipse.vjet.vsf.utils.logging.RemoteFormatter")
.needs("org.eclipse.vjet.vsf.Json")
.inherits("org.eclipse.vjet.vsf.utils.logging.Formatter")
.protos({
    //> private constructs()
	constructs: function(){
		this.base("org.eclipse.vjet.vsf.utils.logging.RemoteFormatter");
	},
	
	format: function(lr){
		return JSON.stringify(lr);//<@SUPRESSTYPECHECK
	}
})
.endType();
