/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.css.dom;

import org.w3c.dom.css.CSSPrimitiveValue;

/**
 * 
 */
public interface IHslColor {
    /**
     *  This attribute is used for the hue value of the HSL color. 
     */
    CSSPrimitiveValue getHue();

    /**
     *  This attribute is used for the saturation value of the HSL color. 
     */
    CSSPrimitiveValue getSaturation();

    /**
     *  This attribute is used for the lightness value of the HSL color. 
     */
    CSSPrimitiveValue getLightness();
}
