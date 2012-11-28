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

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.css.CSSUnknownRule;

/**
 * @see org.w3c.dom.css.CSSUnknownRule
 */
public class DCssUnknownRule
	extends DCssRule
	implements CSSUnknownRule, Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private String m_text = null;

	public DCssUnknownRule(
		CSSStyleSheet parentStyleSheet,
		CSSRule parentRule,
		String text) {

		super(parentStyleSheet, parentRule);
		m_text = text;
	}

	public short getType() {
		return UNKNOWN_RULE;
	}

	public String getCssText() {
		return m_text;
	}

	public void setCssText(String cssText) throws DOMException {
		// TODO: Implementation?
		// TODO return this ;
	}

	public CSSStyleSheet getParentStyleSheet() {
		return m_parentStyleSheet;
	}

	public CSSRule getParentRule() {
		return m_parentRule;
	}

	public String toString() {
		return getCssText();
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
