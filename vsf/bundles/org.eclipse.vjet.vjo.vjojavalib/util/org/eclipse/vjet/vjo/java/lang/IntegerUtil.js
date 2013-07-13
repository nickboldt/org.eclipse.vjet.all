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
vjo.ctype("org.eclipse.vjet.vjo.java.lang.IntegerUtil")
.needs("org.eclipse.vjet.vjo.java.lang.NumberFormatException")
.props({
	parseInt : function() {
		try{
			if (arguments.length == 2) {
				return parseInt(arguments[0], arguments[1]);
			} else if (arguments.length == 1) {
				return parseInt(arguments[0]);
			}
		} catch(e) {
			//TODO throw a specific error based on the error coming back from JS
			throw new vjo.java.lang.NumberFormatException("Error using parseInt");
		}
	}
})
.endType();