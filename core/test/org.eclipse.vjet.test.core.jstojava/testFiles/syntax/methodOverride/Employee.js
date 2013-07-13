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
vjo.ctype('syntax.methodOverride.Employee')
.inherits('syntax.methodOverride.Person')
.protos({
	m_name:undefined, //< private String

	//> public void constructs(String dept)
	constructs:function(dept) {
		this.base('Test_Name');
	},

	//> public void setName(String name)
	setName: function(name) {
		this.base.setName(name);
		this.m_name = name;
	},
	
	//> void modAddress1(String address)
	modAddress1: function(address){
		address = address + "!";
	}
})
.endType();