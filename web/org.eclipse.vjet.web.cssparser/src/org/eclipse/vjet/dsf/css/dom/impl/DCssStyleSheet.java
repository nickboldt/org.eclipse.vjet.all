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

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.css.parser.DCssBuilder;
import org.eclipse.vjet.dsf.dom.DNode;
import org.eclipse.vjet.dsf.dom.stylesheets.IMediaList;
import org.eclipse.vjet.dsf.dom.stylesheets.IStyleSheet;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSRuleList;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.stylesheets.MediaList;

/**
 * @see org.w3c.dom.css.CSSStyleSheet
 */
public class DCssStyleSheet 
	implements CSSStyleSheet, Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private boolean m_disabled = false;
    private DNode m_ownerNode = null;
    private CSSStyleSheet m_parentStyleSheet = null;
    private String m_href = null;
    private String m_title = null;
    private MediaList m_media = null;
    private CSSRule m_ownerRule = null;
    private boolean m_readOnly = false;
    private CSSRuleList m_rules = null;

    public DCssStyleSheet() {
		m_rules = new DCssRuleList();
    }

    public String getType() {
        return "text/css";
    }

    public boolean getDisabled() {
        return m_disabled;
    }

    /**
     * We will need to respond more fully if a stylesheet is disabled, probably
     * by generating an event for the main application.
     */
    public void setDisabled(boolean disabled) {
        m_disabled = disabled;
    }

    public DNode getOwnerNode() {
        return m_ownerNode;
    }

    public CSSStyleSheet getParentStyleSheet() {
        return m_parentStyleSheet;
    }

    public String getHref() {
        return m_href;
    }

    public String getTitle() {
        return m_title;
    }

    public MediaList getMedia() {
        return m_media;
    }

    public CSSRule getOwnerRule() {
        return m_ownerRule;
    }

    public CSSRuleList getCssRules() {
        return m_rules;
    }

    public int insertRule(String rule, int index) throws DOMException {
        if (m_readOnly) {
            throw new DCssException(
                DOMException.NO_MODIFICATION_ALLOWED_ERR,
                DCssException.READ_ONLY_STYLE_SHEET);
        }

        try {
        	if(rule==null) {
        		throw new DsfRuntimeException("Error: rule is null");
        	}  
            InputSource is = new InputSource(new StringReader(rule));
            DCssBuilder parser = new DCssBuilder();
            parser.setParentStyleSheet(this);
            CSSRule r = parser.parseRule(is);

            if (getCssRules().getLength() > 0) {

                // We need to check that this type of rule can legally go into
                // the requested position.
                int msg = -1;
                if (r.getType() == CSSRule.CHARSET_RULE) {

                    // Index must be 0, and there can be only one charset rule
                    if (index != 0) {
                        msg = DCssException.CHARSET_NOT_FIRST;
                    } else if (getCssRules().item(0).getType()
                            == CSSRule.CHARSET_RULE) {
                        msg = DCssException.CHARSET_NOT_UNIQUE;
                    }
                } else if (r.getType() == CSSRule.IMPORT_RULE) {

                    // Import rules must preceed all other rules (except
                    // charset rules)
                    if (index <= getCssRules().getLength()) {
                        for (int i = 0; i < index; i++) {
                            int rt = getCssRules().item(i).getType();
                            if ((rt != CSSRule.CHARSET_RULE)
                                    || (rt != CSSRule.IMPORT_RULE)) {
                                msg = DCssException.IMPORT_NOT_FIRST;
                                break;
                            }
                        }
                    }
                }

                if (msg > -1) {
                    throw new DCssException(
                        DOMException.HIERARCHY_REQUEST_ERR,
                        msg);
                }
            }

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
        if (m_readOnly) {
            throw new DCssException(
                DOMException.NO_MODIFICATION_ALLOWED_ERR,
                DCssException.READ_ONLY_STYLE_SHEET);
        }

        try {
            ((DCssRuleList)getCssRules()).delete(index);
        } catch (IndexOutOfBoundsException e) {
            throw new DCssException(
                DOMException.INDEX_SIZE_ERR,
                DCssException.ARRAY_OUT_OF_BOUNDS,
                e.getMessage());
        }
    }

    public boolean isReadOnly() {
        return m_readOnly;
    }

    public CSSStyleSheet setReadOnly(boolean b) {
        m_readOnly = b;
        return this ;
    }

    public void setOwnerNode(DNode ownerNode) {
        m_ownerNode = ownerNode;
    }

    public void setParentStyleSheet(IStyleSheet parentStyleSheet) {
        m_parentStyleSheet = (CSSStyleSheet)parentStyleSheet;
    }

    public void setHref(String href) {
        m_href = href;
    }

    public void setTitle(String title) {
        m_title = title;
    }

    public void setMedia(String mediaText) {
        // MediaList _media = null;
    }

    public void setOwnerRule(CSSRule ownerRule) {
        m_ownerRule = ownerRule;
    }
    
    public void setRuleList(CSSRuleList rules) {
        m_rules = rules;
    }
    
    public String toString() {
        return m_rules.toString();
    }
    
	public Object clone() throws CloneNotSupportedException {
		DCssStyleSheet copy = (DCssStyleSheet)super.clone();
		copy.m_rules = (DCssRuleList) ((DCssRuleList)copy.m_rules).clone();
		return copy;
	}
}
