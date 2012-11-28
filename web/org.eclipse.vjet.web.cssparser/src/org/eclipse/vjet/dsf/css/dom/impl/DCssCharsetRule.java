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
import org.w3c.dom.css.CSSCharsetRule;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleSheet;

/**
 * @see org.w3c.dom.css.CSSStyleSheet
 */

public class DCssCharsetRule 
	implements CSSCharsetRule, Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private CSSStyleSheet m_parentStyleSheet = null;
    private CSSRule m_parentRule = null;
    private String m_encoding = null;

    public DCssCharsetRule(
            CSSStyleSheet parentStyleSheet,
            CSSRule parentRule,
            String encoding) {
        m_parentStyleSheet = parentStyleSheet;
        m_parentRule = parentRule;
        m_encoding = encoding;
    }

    public short getType() {
        return CHARSET_RULE;
    }

    public String getCssText() {
        return "@charset \"" + getEncoding() + "\";";
    }

    public void setCssText(String cssText) throws DOMException {
    	// TODO look into m_parentStyleSheet.isReadOnly() extension
        if (m_parentStyleSheet != null) {
            throw new DCssException(
                DOMException.NO_MODIFICATION_ALLOWED_ERR,
                DCssException.READ_ONLY_STYLE_SHEET);
        }

        try {
            InputSource is = new InputSource(new StringReader(cssText));
            DCssBuilder parser = new DCssBuilder();
            CSSRule r = parser.parseRule(is);

            // The rule must be a charset rule
            if (r.getType() == CSSRule.CHARSET_RULE) {
                m_encoding = ((DCssCharsetRule)r).m_encoding;
            } else {
                throw new DCssException(
                    DOMException.INVALID_MODIFICATION_ERR,
                    DCssException.EXPECTING_CHARSET_RULE);
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
        
//        return this ;
    }

    public CSSStyleSheet getParentStyleSheet() {
        return m_parentStyleSheet;
    }

    public CSSRule getParentRule() {
        return m_parentRule;
    }

    public String getEncoding() {
        return m_encoding;
    }

    public void setEncoding(String encoding) throws DOMException {
        m_encoding = encoding;
       // TODO  return this ;
    }
    
	//
	// Override(s) from Object
	//
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
