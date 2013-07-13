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
//@Package org.eclipse.vjet.vsf.typeextensions.string
vjo.needs("org.eclipse.vjet.vsf.typeextensions.string.Comparison");
vjo.ctype("org.eclipse.vjet.vsf.typeextensions.string.Trim").endType();
String.prototype.trim = function() {
	var s = this;

	//Remove leading spaces and carriage returns
	while (s.substring(0,1).isAny(' ','\n','\r'))
		s = s.substring(1,s.length);

	//Remove trailing spaces and carriage returns
	while (s.substring(s.length-1,s.length).isAny(' ','\n','\r'))
		s = s.substring(0,s.length-1);

	return s;
};
