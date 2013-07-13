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
package org.eclipse.vjet.vsf.jsruntime;

/**
 * 
 * @author jearly
 * BoolWrapper is to distinguish between the developer
 * who has indicated they want the javaScript Boolean
 * object passed rather than the boolean literal passed
 *
 */

public class BoolWrapper {

	private Boolean m_bool;

	public BoolWrapper(Boolean b) {
		m_bool = b;
	}

	public boolean getBoolValue() {
		return m_bool.booleanValue();
	}
	
}
