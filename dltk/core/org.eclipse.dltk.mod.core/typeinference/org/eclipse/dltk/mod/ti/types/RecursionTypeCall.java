/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *

 *******************************************************************************/
package org.eclipse.dltk.mod.ti.types;

public class RecursionTypeCall implements IEvaluatedType {

	public static final IEvaluatedType INSTANCE = new RecursionTypeCall();

	/**
	 * The constructor is private so that we can rely on comparing with
	 * <code>INSTANCE</code>.
	 */
	private RecursionTypeCall() {
	}

	public String getTypeName() {
		return "recursion type call"; //$NON-NLS-1$
	}

	public boolean subtypeOf(IEvaluatedType type) {
		// TODO Auto-generated method stub
		return false;
	}

}
