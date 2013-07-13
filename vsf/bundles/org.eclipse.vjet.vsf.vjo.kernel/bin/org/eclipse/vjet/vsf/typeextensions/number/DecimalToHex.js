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
//@Package org.eclipse.vjet.vsf.typeextensions.number

vjo.ctype("org.eclipse.vjet.vsf.typeextensions.number.DecimalToHex").endType();
/**
* Converts a number from decimal to hex value.
*/
Number.prototype.dec2Hex = function () {
	return parseInt(this,10).toString(16);
};
