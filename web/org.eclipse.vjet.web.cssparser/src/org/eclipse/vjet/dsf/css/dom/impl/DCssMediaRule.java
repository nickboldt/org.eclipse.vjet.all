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
import org.w3c.dom.css.CSSMediaRule;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSRuleList;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.stylesheets.MediaList;

/**
 * @see org.w3c.dom.css.CSSMediaRule
 */
public class DCssMediaRule extends DCssRule
	implements CSSMediaRule, Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private MediaList m_media = null;
    private CSSRuleList m_rules = null;

    public DCssMediaRule(
            CSSStyleSheet parentStyleSheet,
            CSSRule parentRule,
            MediaList media) {
        super(parentStyleSheet, parentRule);
        m_media = media;
    }

    public short getType() {
        return MEDIA_RULE;
    }

    public String getCssText() {
        StringBuffer sb = new StringBuffer("@media ");
        sb.append(getMedia().toString()).append(" {");
        for (int i = 0; i < getCssRules().getLength(); i++) {
            CSSRule rule = getCssRules().item(i);
            sb.append(rule.getCssText()).append(" ");
        }
        sb.append("}");
        return sb.toString();
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

            // The rule must be a media rule
            if (r.getType() == CSSRule.MEDIA_RULE) {
                m_media = ((DCssMediaRule)r).m_media;
                m_rules = ((DCssMediaRule)r).m_rules;
            } else {
                throw new DCssException(
                    DOMException.INVALID_MODIFICATION_ERR,
                    DCssException.EXPECTING_MEDIA_RULE);
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
       // TODO  return this ;
    }

    public CSSStyleSheet getParentStyleSheet() {
        return m_parentStyleSheet;
    }

    public CSSRule getParentRule() {
        return m_parentRule;
    }

    public MediaList getMedia() {
        return m_media;
    }

    public CSSRuleList getCssRules() {
        return m_rules;
    }

    public int insertRule(String rule, int index) throws DOMException {
    	// TODO && m_parentStyleSheet.isReadOnly()
        if (m_parentStyleSheet != null ) {
            throw new DCssException(
                DOMException.NO_MODIFICATION_ALLOWED_ERR,
                DCssException.READ_ONLY_STYLE_SHEET);
        }

        try {
            InputSource is = new InputSource(new StringReader(rule));
            DCssBuilder parser = new DCssBuilder();
            parser.setParentStyleSheet(m_parentStyleSheet);
            parser.setParentRule(m_parentRule);
            CSSRule r = parser.parseRule(is);

            // Insert the rule into the list of rules
            ((DCssRuleList)getCssRules()).insert(r, index);

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DCssException(
                DOMException.INDEX_SIZE_ERR,
                DCssException.ARRAY_OUT_OF_BOUNDS,
                e.getMessage());
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
        return index;
    }

    public void deleteRule(int index) throws DOMException {
    	// TODO && m_parentStyleSheet.isReadOnly()
        if (m_parentStyleSheet != null ) {
            throw new DCssException(
                DOMException.NO_MODIFICATION_ALLOWED_ERR,
                DCssException.READ_ONLY_STYLE_SHEET);
        }
        try {
            ((DCssRuleList)getCssRules()).delete(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DCssException(
                DOMException.INDEX_SIZE_ERR,
                DCssException.ARRAY_OUT_OF_BOUNDS,
                e.getMessage());
        }
    }

    public void setRuleList(CSSRuleList rules) {
        m_rules = rules;
    }
    
    public String toString() {
        return getCssText();
    }
    
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
