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
import org.w3c.dom.css.RGBColor;

/**
 * @see org.w3c.dom.css.RGBColor
 */

public class DCssRgbColor 
	extends DCssBaseColor
	implements RGBColor, Serializable, Cloneable
{
	private static final long serialVersionUID = 1L;
	
	protected CSSPrimitiveValue m_red ;
    protected CSSPrimitiveValue m_green ;
    protected CSSPrimitiveValue m_blue ;

    //
    // Constructor(s)
    //
    public DCssRgbColor(final LexicalUnit lu) {
        LexicalUnit next = lu;
        m_red = new DCssValue(next, true);
        
        next = next.getNextLexicalUnit();	// skip comma
        next = next.getNextLexicalUnit();
        m_green = new DCssValue(next, true);
        
        next = next.getNextLexicalUnit();	// skip comma
        next = next.getNextLexicalUnit();
        m_blue = new DCssValue(next, true);
    }

    protected DCssRgbColor() {
    	// empty on purpose
    }
    
    //
    // API
    //
    public CSSPrimitiveValue getRed() {
        return m_red;
    }
    public void setRed(final CSSPrimitiveValue red) {
        m_red = red;
    }

    public CSSPrimitiveValue getGreen() {
        return m_green;
    }
    public void setGreen(final CSSPrimitiveValue green) {
        m_green = green;
    }

    public CSSPrimitiveValue getBlue() {
        return m_blue;
    }
    public void setBlue(final CSSPrimitiveValue blue) {
        m_blue = blue;
    }

    //
    // Override(s) from Object
    //
    @Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
    @Override
    public String toString() {
    	String rs = m_red.toString();
    	String gs = m_green.toString();
    	String bs = m_blue.toString();
    	
    	StringBuilder sb = null;
    	
    	if(isPercentage(rs) && isPercentage(gs) && isPercentage(bs)) {
    		sb = new StringBuilder(20);
    		sb.append("rgb(");
    		appendPercentage(sb, rs);
    		sb.append(',');
    		appendPercentage(sb, gs);
    		sb.append(',');
    		appendPercentage(sb, bs);
    		sb.append(')');
    	} else {    	
			sb = new StringBuilder(7);
			sb.append('#');
			appendHexValue(sb, Integer.parseInt(rs));
			appendHexValue(sb, Integer.parseInt(gs));
			appendHexValue(sb, Integer.parseInt(bs));
			
			// compress
			if(		(sb.charAt(1) == sb.charAt(2))
				&&	(sb.charAt(3) == sb.charAt(4))
				&&	(sb.charAt(5) == sb.charAt(6))
					) {	
				char[] chars = new char[] {'#', sb.charAt(1), sb.charAt(3), sb.charAt(5)};
				sb = new StringBuilder(4);
				sb.append(chars);
			}
    	}

		return sb.toString();
    }
    
	private static void appendHexValue(StringBuilder sb, int value) {
		if(value < 0) {
			value = 0;
		} else if(value > 255) {
			value = 255;
		}
		String h = Integer.toHexString(value);
		if(h.length() == 1) {
			sb.append('0');
		}
		sb.append(h);
	}
}
