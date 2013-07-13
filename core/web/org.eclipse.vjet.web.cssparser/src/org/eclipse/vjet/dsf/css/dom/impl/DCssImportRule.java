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
import org.eclipse.vjet.dsf.dom.stylesheets.IMediaList;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSImportRule;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.stylesheets.MediaList;

/**
 * @see org.w3c.dom.css.CSSImportRule
 */
public class DCssImportRule
	extends DCssRule
	implements CSSImportRule, Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private String m_href = null;
	private MediaList m_media = null;

	public DCssImportRule(
		CSSStyleSheet parentStyleSheet,
		CSSRule parentRule,
		String href,
		MediaList media) {
			
		super(parentStyleSheet, parentRule);
		m_href = href;
		m_media = media;
	}

	public short getType() {
		return IMPORT_RULE;
	}

	public String getCssText() {
		StringBuffer sb = new StringBuffer();
		sb.append("@import url(").append(getHref()).append(")");
		if (getMedia().getLength() > 0) {
			sb.append(" ").append(getMedia().toString());
		}
		sb.append(";");
		return sb.toString();
	}

	public void setCssText(String cssText) throws DOMException {
		// TODO && m_parentStyleSheet.isReadOnly()
		if (m_parentStyleSheet != null) {
			throw new DCssException(
				DOMException.NO_MODIFICATION_ALLOWED_ERR,
				DCssException.READ_ONLY_STYLE_SHEET);
		}

		try {
			InputSource is = new InputSource(new StringReader(cssText));
			DCssBuilder parser = new DCssBuilder();
			CSSRule r = parser.parseRule(is);

			// The rule must be an import rule
			if (r.getType() == CSSRule.IMPORT_RULE) {
				m_href = ((DCssImportRule) r).m_href;
				m_media = ((DCssImportRule) r).m_media;
			} else {
				throw new DCssException(
					DOMException.INVALID_MODIFICATION_ERR,
					DCssException.EXPECTING_IMPORT_RULE);
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

	public String getHref() {
		return m_href;
	}

	public MediaList getMedia() {
		return m_media;
	}

	public CSSStyleSheet getStyleSheet() {
		return null;
	}

	public String toString() {
		return getCssText();
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
