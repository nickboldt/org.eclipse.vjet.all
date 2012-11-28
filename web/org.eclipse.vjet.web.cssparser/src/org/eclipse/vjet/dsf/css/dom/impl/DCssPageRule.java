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
import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSPageRule;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleSheet;

/**
 * @see org.w3c.dom.css.CSSPageRule
 */
public class DCssPageRule
	extends DCssRule
	implements CSSPageRule, Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private String m_ident = null;
	private String m_pseudoPage = null;
	private CSSStyleDeclaration m_style = null;

	public DCssPageRule(
		CSSStyleSheet parentStyleSheet,
		CSSRule parentRule,
		String ident,
		String pseudoPage) {
			
		super(parentStyleSheet, parentRule);
		m_ident = ident;
		m_pseudoPage = pseudoPage;
	}

	public short getType() {
		return PAGE_RULE;
	}

	public String getCssText() {
		String sel = getSelectorText();
		return "@page "
			+ sel
			+ ((sel.length() > 0) ? " " : "")
			+ getStyle().getCssText();
	}

	public void setCssText(String cssText) throws DOMException {
		// TODO m_parentStyleSheet.isReadOnly()
		if (m_parentStyleSheet != null ) {
			throw new DCssException(
				DOMException.NO_MODIFICATION_ALLOWED_ERR,
				DCssException.READ_ONLY_STYLE_SHEET);
		}

		try {
			InputSource is = new InputSource(new StringReader(cssText));
			DCssBuilder parser = new DCssBuilder();
			CSSRule r = parser.parseRule(is);

			// The rule must be a page rule
			if (r.getType() == CSSRule.PAGE_RULE) {
				m_ident = ((DCssPageRule) r).m_ident;
				m_pseudoPage = ((DCssPageRule) r).m_pseudoPage;
				m_style = ((DCssPageRule) r).m_style;
			} else {
				throw new DCssException(
					DOMException.INVALID_MODIFICATION_ERR,
					DCssException.EXPECTING_PAGE_RULE);
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
		return ((m_ident != null) ? m_ident : "")
			+ ((m_pseudoPage != null) ? ":" + m_pseudoPage : "");
	}

	public void setSelectorText(String selectorText) throws DOMException {
		// TODO: Implementation?
		// TODO return this ;
	}

	public CSSStyleDeclaration getStyle() {
		return m_style;
	}

	protected void setIdent(String ident) {
		m_ident = ident;
	}

	protected void setPseudoPage(String pseudoPage) {
		m_pseudoPage = pseudoPage;
	}

	public void setStyle(CSSStyleDeclaration style) {
		m_style = style;
	}

	/** 
	 * DO NOT CHANGE THIS.  Unfortunately the def code relies on toString()
	 * for values.  Will need to fix this.
	 */
	@Override
	public String toString() {
		return getCssText() ;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
