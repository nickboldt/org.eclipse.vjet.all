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

import org.eclipse.vjet.dsf.css.dom.IHslColor;
import org.w3c.css.sac.LexicalUnit;
import org.w3c.dom.css.CSSPrimitiveValue;

/**
 * @see org.w3c.dom.css.HSLColor
 */

public class DCssHslColor 
	extends DCssBaseColor
	implements IHslColor, Serializable, Cloneable
{
	private static final long serialVersionUID = 1L;
	
	protected CSSPrimitiveValue m_hue ;
    protected CSSPrimitiveValue m_saturation ;
    protected CSSPrimitiveValue m_lightness ;

    //
    // Constructor(s)
    //
    public DCssHslColor(final LexicalUnit lu) {
        LexicalUnit next = lu;
        m_hue = new DCssValue(next, true);
        
        next = next.getNextLexicalUnit();	// skip comma
        next = next.getNextLexicalUnit();
        m_saturation = new DCssValue(next, true);
        
        next = next.getNextLexicalUnit();	// skip comma
        next = next.getNextLexicalUnit();
        m_lightness = new DCssValue(next, true);
    }

    protected DCssHslColor() {
    	// empty on purpose
    }
    
    //
    // API
    //
    public CSSPrimitiveValue getHue() {
        return m_hue;
    }
    public void setHue(final CSSPrimitiveValue hue) {
        m_hue = hue;
    }

    public CSSPrimitiveValue getSaturation() {
        return m_saturation;
    }
    public void setGreen(final CSSPrimitiveValue saturation) {
        m_saturation = saturation;
    }

    public CSSPrimitiveValue getLightness() {
        return m_lightness;
    }
    public void setLightness(final CSSPrimitiveValue lightness) {
        m_lightness = lightness;
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
    	final String h = m_hue.toString();
    	final String s = m_saturation.toString();
    	final String l = m_lightness.toString();
    	
    	final StringBuilder sb = new StringBuilder(20);;
		sb.append("hsl(");
    	if (isPercentage(h)) appendPercentage(sb, h); else sb.append(h) ;
    	sb.append(',') ;
    	if (isPercentage(s)) appendPercentage(sb, s); else sb.append(s) ;
    	sb.append(',') ;
    	if (isPercentage(l)) appendPercentage(sb, l); else sb.append(l) ;
    	sb.append(')');

		return sb.toString();
    }
}
