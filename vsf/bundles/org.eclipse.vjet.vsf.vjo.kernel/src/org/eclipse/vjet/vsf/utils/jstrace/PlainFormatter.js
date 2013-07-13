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
vjo.ctype("org.eclipse.vjet.vsf.utils.jstrace.PlainFormatter")
.inherits("org.eclipse.vjet.vsf.utils.logging.Formatter")
.protos({
    //> private constructs()
	constructs: function(){
		this.base("org.eclipse.vjet.vsf.utils.jstrace.PlainFormatter");
	},
	
	format: function(lr){
		var ctx = lr.params[0],
			target = ctx.target || '?',
			txt = ctx.type;
		txt += ' ';
 		txt += target;
		txt += ' ';
		txt += ctx.jsrId || '?';
		txt += ' @ ';
		txt += ctx.time || '?';
		txt += ' delta= ';
		txt += ctx.delta || '0';
		return txt;
	}
})
.endType();
