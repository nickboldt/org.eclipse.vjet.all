/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.css.dom.impl;

import java.io.Serializable;

import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleSheet;

public abstract class DCssRule implements CSSRule, Serializable, Cloneable {

	protected CSSStyleSheet m_parentStyleSheet = null;
	protected CSSRule m_parentRule = null;
	
	protected DCssRule
		(CSSStyleSheet parentStyleSheet, CSSRule parentRule) {
		m_parentStyleSheet = parentStyleSheet;
		m_parentRule = parentRule;
	}
	
	public CSSRule getParentRule() {
		return m_parentRule;
	}

	public CSSStyleSheet getParentStyleSheet() {
		return m_parentStyleSheet;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
