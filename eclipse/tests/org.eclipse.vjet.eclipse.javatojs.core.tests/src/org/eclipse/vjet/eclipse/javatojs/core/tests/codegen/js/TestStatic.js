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
vjo.ctype("com.ebay.darwin.codegen.js.TestStatic")
.props({

    //> public int reqMyService(int pNumber)
	reqMyService : function(message,pNumber){
		alert("page listener before service: " + message.svcId + " pNumber = " + pNumber);
		return 45;
	},
	
    //> public int reqMyService2(HTMLElement element,Array d)
	reqMyService2 : function(message,element,d){
		alert("page listener before service: " + message.svcId + " pNumber = " + pNumber);
		return 89;
	},

    //> public int respondToMyService()
	respondToMyService : function(message){
		alert("page listener after service: " + message.svcId);
		return 99;
	}
})
.endType();
