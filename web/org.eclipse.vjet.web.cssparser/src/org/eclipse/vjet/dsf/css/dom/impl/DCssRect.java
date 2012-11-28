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

import org.w3c.css.sac.LexicalUnit;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.Rect;

/**
 * @see org.w3c.dom.css.Rect
 */
public class DCssRect implements Rect, Serializable, Cloneable {
   
	private static final long serialVersionUID = 1L;
	private CSSPrimitiveValue m_left;
    private CSSPrimitiveValue m_top;
    private CSSPrimitiveValue m_right;
    private CSSPrimitiveValue m_bottom;

    /** Creates new RectImpl */
    public DCssRect(LexicalUnit lu) {
        LexicalUnit next = lu;
        m_left = new DCssValue(next, true);
        next = next.getNextLexicalUnit();
        next = next.getNextLexicalUnit();
        m_top = new DCssValue(next, true);
        next = next.getNextLexicalUnit();
        next = next.getNextLexicalUnit();
        m_right = new DCssValue(next, true);
        next = next.getNextLexicalUnit();
        next = next.getNextLexicalUnit();
        m_bottom = new DCssValue(next, true);
    }
  
    public CSSPrimitiveValue getTop() {
        return m_top;
    }

    public CSSPrimitiveValue getRight() {
        return m_right;
    }

    public CSSPrimitiveValue getBottom() {
        return m_bottom;
    }

    public CSSPrimitiveValue getLeft() {
        return m_left;
    }
    
    public String toString() {
        return new StringBuffer()
            .append("rect(")
            .append(m_left.toString())
            .append(", ")
            .append(m_top.toString())
            .append(", ")
            .append(m_right.toString())
            .append(", ")
            .append(m_bottom.toString())
            .append(")")
            .toString();
    }
    
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}