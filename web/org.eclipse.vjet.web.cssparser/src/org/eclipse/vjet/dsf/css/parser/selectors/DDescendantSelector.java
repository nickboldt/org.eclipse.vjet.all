/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.vjet.dsf.css.parser.selectors;

import java.io.Serializable;

import org.eclipse.vjet.dsf.css.sac.ISelector;
import org.w3c.css.sac.DescendantSelector;
import org.w3c.css.sac.Selector;
import org.w3c.css.sac.SimpleSelector;

public class DDescendantSelector
	implements DescendantSelector, Serializable {

	private Selector m_parent;
	private SimpleSelector m_simpleSelector;

	public DDescendantSelector(
		Selector parent,
		SimpleSelector simpleSelector) {
		m_parent = parent;
		m_simpleSelector = simpleSelector;
	}

	public short getSelectorType() {
		return ISelector.SAC_DESCENDANT_SELECTOR;
	}

	public Selector getAncestorSelector() {
		return m_parent;
	}

	public SimpleSelector getSimpleSelector() {
		return m_simpleSelector;
	}

	public String toString() {
		return getAncestorSelector().toString()
			+ " "
			+ getSimpleSelector().toString();
	}
	
	//added API
	public void setAncestorSelector(Selector parent) {
		m_parent = parent;
	}
	
	public Object clone() throws CloneNotSupportedException {
		// TODO
		return null;
		
//		DDescendantSelector clone = (DDescendantSelector)super.clone();
//		clone.m_parent = (Selector)m_parent.clone();
//		clone.m_simpleSelector = (SimpleSelector)m_simpleSelector.clone();
//		return clone;
	}
}
