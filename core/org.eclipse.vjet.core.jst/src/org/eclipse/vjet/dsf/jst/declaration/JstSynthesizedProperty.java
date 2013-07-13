/*******************************************************************************
 * Copyright (c) 2005-2011 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jst.declaration;

import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.ISynthesized;
import org.eclipse.vjet.dsf.jst.term.JstIdentifier;
import org.eclipse.vjet.dsf.jst.term.JstLiteral;
import org.eclipse.vjet.dsf.jst.token.IExpr;



public class JstSynthesizedProperty extends JstProperty implements ISynthesized{
	private static final long serialVersionUID = 1L;

	public JstSynthesizedProperty(final IJstType type, final String name, JstIdentifier jstIdentifier, JstModifiers modifier) {
		super(type, name, jstIdentifier, (modifier==null)?new JstModifiers():modifier);
	}

	/**
	 * Constructor
	 * @param type JstType type of the property
	 * @param name String
	 */
	public JstSynthesizedProperty(final IJstType type, final String name) {
		super(type, name, (JstIdentifier)null, new JstModifiers());
	}

	/**
	 * Constructor
	 * @param type JstType type of the property
	 * @param name String
	 * @param value ISimpleTerm
	 */
	public JstSynthesizedProperty(final IJstType type, final String name, final JstIdentifier value) {
		super(type, name, value, new JstModifiers());
	}

	/**
	 * Constructor
	 * @param type JstType type of the property
	 * @param name String
	 * @param value JstLiteral
	 */
	public JstSynthesizedProperty(final IJstType type, final String name, final JstLiteral value) {
		super(type, name, value, new JstModifiers());
	}

	/**
	 * Constructor
	 * @param type JstType type of the property
	 * @param name String
	 * @param value JstIdentifier
	 * @param modifiers JstModifiers
	 */
	public JstSynthesizedProperty(final IJstType type, final String name, final JstModifiers modifiers) {
		super(type, new JstName(name), (JstIdentifier)null, modifiers);
	}


	/**
	 * Constructor
	 * @param type JstType type of the property
	 * @param name JstName
	 * @param value JstIdentifier
	 * @param modifiers JstModifiers
	 */
	public JstSynthesizedProperty(final IJstType type, final JstName name, final JstIdentifier value, final JstModifiers modifiers) {
		super(type,name,modifiers,value,null);
	}

	/**
	 * Constructor
	 * @param type JstType type of the property
	 * @param name String
	 * @param value JstLiteral
	 * @param modifiers JstModifiers
	 */
	public JstSynthesizedProperty(final IJstType type, final String name, final JstLiteral value, final JstModifiers modifiers) {
		super(type, new JstName(name), value, modifiers);
	}

	/**
	 * Constructor
	 * @param type JstType type of the property
	 * @param name JstName
	 * @param value JstLiteral
	 * @param modifiers JstModifiers
	 */
	public JstSynthesizedProperty(final IJstType type, final JstName name, final JstLiteral value, final JstModifiers modifiers) {
		super(type,name,modifiers,value,null);
	}

	/**
	 * Constructor
	 * @param type JstType type of the property
	 * @param name String
	 * @param initializer IExpr
	 * @param modifiers JstModifiers
	 */
	public JstSynthesizedProperty(final IJstType type, final String name, final IExpr initializer, final JstModifiers modifiers) {
		super(type, new JstName(name), initializer, modifiers);
	}

	/**
	 * Constructor
	 * @param type JstType type of the property
	 * @param name JstName
	 * @param initializer IExpr
	 * @param modifiers JstModifiers
	 */
	public JstSynthesizedProperty(final IJstType type, final JstName name, final IExpr initializer, final JstModifiers modifiers) {
		super(type,name,modifiers,null,initializer);
	}

}