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
vjo.ctype("org.eclipse.vjet.vsf.utils.Trim")
.needs("org.eclipse.vjet.vsf.utils.Comparison")
.props({
	//>public String trim(String pSource)
	trim : function(s) {
		//Remove leading spaces and carriage returns
		while (this.vj$.Comparison.isAny(s.substring(0,1),' ','\n','\r'))
			s = s.substring(1,s.length);

		//Remove trailing spaces and carriage returns
		while (this.vj$.Comparison.isAny(s.substring(s.length-1,s.length),' ','\n','\r'))
			s = s.substring(0,s.length-1);
		return s;
	}
})
.endType();
