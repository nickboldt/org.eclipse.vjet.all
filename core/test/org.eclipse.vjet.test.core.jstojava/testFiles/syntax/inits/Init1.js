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
vjo.ctype('syntax.inits.Init1')
.props({
	s1 : undefined, //<String
	finalvar : undefined//< final String
})
.protos({
	s2 : undefined, //<String
	//>public constructs()
	constructs : function(){
	}
})
.inits(function(){
	this.s1 = "DDD";
	this.s2 = "VSFF";
	this.finalvar = "SF";
})
.endType();