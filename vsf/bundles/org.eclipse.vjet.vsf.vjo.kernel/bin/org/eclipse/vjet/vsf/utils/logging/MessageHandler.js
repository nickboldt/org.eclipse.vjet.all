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
vjo.ctype("org.eclipse.vjet.vsf.utils.logging.MessageHandler")
.needs("org.eclipse.vjet.vsf.utils.Handlers")
.needs("org.eclipse.vjet.vsf.utils.logging.Handler")
.inherits("org.eclipse.vjet.vsf.utils.logging.Handler")
.protos({
	H:	org.eclipse.vjet.vsf.utils.Handlers,
	
    //> private constructs()
	constructs: function(){
		var t = this;
		t.base("org.eclipse.vjet.vsf.utils.logging.MessageHandler");
	},
		
	innerPublish: function(lr){
		var msg = this.H.newMsg(lr.getMsgId());
		msg.clientContext = {'logRecord': lr};
		this.H.handle(msg);
	}
})
.endType();
