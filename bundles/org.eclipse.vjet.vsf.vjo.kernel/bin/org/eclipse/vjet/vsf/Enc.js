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
/*
 *
 * Handling Encoding/Decoding more efficently when switching from ISO to UTF-8 
 * for encoding
 *
 */
vjo.ctype("org.eclipse.vjet.vsf.Enc")
.props({
	unescape:vjo.NEEDS_IMPL, //<public String (String)
	decodeURI:vjo.NEEDS_IMPL, //<public String (String)
	decodeURIComponent:vjo.NEEDS_IMPL, //<public String (String)
	encodeURIComponent:vjo.NEEDS_IMPL, //<public String(String)
	encodeURI:vjo.NEEDS_IMPL //<public String(String)
})
.inits(function(){
	org.eclipse.vjet.vsf.Enc.unescape = window.unescape;
	org.eclipse.vjet.vsf.Enc.decodeURI = window.decodeURI;
	org.eclipse.vjet.vsf.Enc.decodeURIComponent = window.decodeURIComponent;
	org.eclipse.vjet.vsf.Enc.encodeURIComponent = window.encodeURIComponent;
	org.eclipse.vjet.vsf.Enc.encodeURI = window.encodeURI;
})
.endType();
