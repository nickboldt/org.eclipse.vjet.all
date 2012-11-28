/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.dom.support;

import org.apache.xerces.util.XML11Char;
import org.apache.xerces.util.XMLChar;
/**
 * XML name verifier, based on W3C spec
 */
public class XmlVerifier {
	/**
	 * Check the string against XML's definition of acceptable names for
	 * elements and attributes and so on using the XMLCharacterProperties
	 * utility class
	 */

	public static final boolean isXMLName(
		final String s, final boolean xml11Version)
	{
		if (s == null) {
			return false;
		}
		if (xml11Version) {
			return XML11Char.isXML11ValidName(s);
		}
		return XMLChar.isValidName(s);

	} // isXMLName(String):boolean
} 