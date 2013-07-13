/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.css.dom.impl;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;

import org.eclipse.vjet.dsf.css.parser.DCssBuilder;
import org.w3c.css.sac.InputSource;
import org.w3c.css.sac.SelectorList;
import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleRule;
import org.w3c.dom.css.CSSStyleSheet;

/**
 * @see org.w3c.dom.css.CSSStyleRule
 */
public class DCssStyleRule
	extends DCssRule
	implements CSSStyleRule, Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private SelectorList m_selectors = null;
	private CSSStyleDeclaration m_style = null;

	public DCssStyleRule(
		CSSStyleSheet parentStyleSheet,
		CSSRule parentRule,
		SelectorList selectors) {

		super(parentStyleSheet, parentRule);
		m_selectors = selectors;
	}

	public short getType() {
		return CSSStyleRule.STYLE_RULE;
	}

	public String getCssText() {
		return getSelectorText() + " " + getStyle().toString();
	}

	public void setCssText(String cssText) throws DOMException {
		// TODO  && m_parentStyleSheet.isReadOnly()
		if (m_parentStyleSheet != null) {
			throw new DCssException(
				DOMException.NO_MODIFICATION_ALLOWED_ERR,
				DCssException.READ_ONLY_STYLE_SHEET);
		}

		try {
			InputSource is = new InputSource(new StringReader(cssText));
			DCssBuilder parser = new DCssBuilder();
			CSSRule r = parser.parseRule(is);

			// The rule must be a style rule
			if (r.getType() == CSSRule.STYLE_RULE) {
				m_selectors = ((DCssStyleRule) r).m_selectors;
				m_style = ((DCssStyleRule) r).m_style;
			} else {
				throw new DCssException(
					DOMException.INVALID_MODIFICATION_ERR,
					DCssException.EXPECTING_STYLE_RULE);
			}
		} catch (DCssException e) {
			throw new DCssException(
				DOMException.SYNTAX_ERR,
				DCssException.SYNTAX_ERROR,
				e.getMessage());
		} catch (IOException e) {
			throw new DCssException(
				DOMException.SYNTAX_ERR,
				DCssException.SYNTAX_ERROR,
				e.getMessage());
		}
		// TODO return this ;
	}

	public CSSStyleSheet getParentStyleSheet() {
		return m_parentStyleSheet;
	}

	public CSSRule getParentRule() {
		return m_parentRule;
	}

	public String getSelectorText() {
		return m_selectors.toString();
	}

	public void setSelectorText(String selectorText) throws DOMException {
		// TODO && m_parentStyleSheet.isReadOnly()
		if (m_parentStyleSheet != null ) {
			throw new DCssException(
				DOMException.NO_MODIFICATION_ALLOWED_ERR,
				DCssException.READ_ONLY_STYLE_SHEET);
		}

		try {
			InputSource is = new InputSource(new StringReader(selectorText));
			DCssBuilder parser = new DCssBuilder();
			m_selectors = parser.parseSelectors(is);
		} catch (DCssException e) {
			throw new DCssException(
				DOMException.SYNTAX_ERR,
				DCssException.SYNTAX_ERROR,
				e.getMessage());
		} catch (IOException e) {
			throw new DCssException(
				DOMException.SYNTAX_ERR,
				DCssException.SYNTAX_ERROR,
				e.getMessage());
		}
		// return this ;
	}

	public CSSStyleDeclaration getStyle() {
		return m_style;
	}

	public CSSStyleRule setStyle(CSSStyleDeclaration style) {
		m_style = style;
		return this ;
	}

	public String toString() {
		return getCssText();
	}

	public SelectorList getSelectors() {
		return m_selectors;
	}

	public Object clone() throws CloneNotSupportedException {
		DCssStyleRule clone = (DCssStyleRule) super.clone();
		clone.m_style = (CSSStyleDeclaration)
			((DCssStyleDeclaration)m_style).clone();
		// TODO add support for cloning selectors
//		clone.m_selectors = (ISelectorList)
//			((CSSSelectorList)m_selectors).clone();
		return clone;
	}
}
