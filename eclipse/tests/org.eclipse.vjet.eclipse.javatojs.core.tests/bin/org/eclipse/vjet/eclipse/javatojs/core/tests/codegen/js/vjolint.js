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
vjo.ctype("vjo.sample.Test")
.props({
	a:"test",
	b:"test2",
	c:"test3",
    //> private void xyz()
	xyz:function(){
		alert("test");
	}
	
})
.protos({
	protoa:"test",
	protob:"test2",
	protoc:"test3",
    //> private void protoxyz()
	protoxyz:function(){
		alert("test");
	}
	
})
.endType();
