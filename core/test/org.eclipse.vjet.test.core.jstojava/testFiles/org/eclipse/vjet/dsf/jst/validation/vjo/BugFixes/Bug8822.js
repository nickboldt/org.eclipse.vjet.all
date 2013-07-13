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
vjo.ctype("org.eclipse.vjet.dsf.jst.validation.vjo.BugFixes.Bug8822")
.protos({
	//>public void foo() 
	foo : function(){
	}
})
.props({
	
	s1:null,//<String[]
	s2	:null,//<String[]
	//>public void main(String... args) 
	main : function(args){
		this.s1 = args;//<<String[]
		this.s2 = args;
	}
})
.endType();

