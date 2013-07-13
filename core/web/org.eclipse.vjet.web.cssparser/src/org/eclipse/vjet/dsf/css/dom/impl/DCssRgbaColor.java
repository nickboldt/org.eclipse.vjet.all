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
 * @see org.w3c.dom.css.RGBAColor
 */

public class DCssRgbaColor 
	extends DCssRgbColor 
	implements RGBColor, Serializable, Cloneable
{
	private static final long serialVersionUID = 1L;
	
    private CSSPrimitiveValue m_opacity  ;

    //
    // Constructor(s)
    //
    public DCssRgbaColor(final LexicalUnit lu) {
    	super(lu) ;
        LexicalUnit next = lu;
        
        next = next.getNextLexicalUnit();	// skip comma
        next = next.getNextLexicalUnit();	// skip green

        
        next = next.getNextLexicalUnit();	// skip comma
        next = next.getNextLexicalUnit();	// skip blue
        m_blue = new DCssValue(next, true);
        
        next = next.getNextLexicalUnit();	// skip comma
        next = next.getNextLexicalUnit();	// we have opacity
        
        m_opacity = new DCssValue(next, true);
    }

    protected DCssRgbaColor() {
    	// empty on purpose
    }
    
    //
    // API
    //
    public CSSPrimitiveValue getOpacity() {
    	return m_opacity ;
    }
    public void setOpacity(final CSSPrimitiveValue opacity) {
    	m_opacity = opacity ;
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
    	final String r = m_red.toString();
    	final String g = m_green.toString();
    	final String b = m_blue.toString();
    	final String o = m_opacity.toString() ;
    	
    	StringBuilder sb = new StringBuilder(20);
    	
    	if(isPercentage(r) && isPercentage(g) && isPercentage(b)) {
    		sb.append("rgba(");
    		appendPercentage(sb, r);
    		sb.append(',');
    		appendPercentage(sb, g);
    		sb.append(',');
    		appendPercentage(sb, b);
    		sb.append(',') ;
    		sb.append(o) ;
    		sb.append(')');
    	} 
    	else {   
    		// MrP - there is no hex notation for RGBA value...
    		sb.append("rgba(");
    		sb.append(r);
    		sb.append(',');
    		sb.append(g);
    		sb.append(',');
    		sb.append(b);
    		sb.append(',') ;
    		sb.append(o) ;
    		sb.append(')');   		
    	}

		return sb.toString();
    }
}
