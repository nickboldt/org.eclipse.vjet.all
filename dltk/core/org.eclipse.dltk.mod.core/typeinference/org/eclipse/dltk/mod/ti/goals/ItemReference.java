/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *

 *******************************************************************************/
package org.eclipse.dltk.mod.ti.goals;

public abstract class ItemReference {

	public final static int ACCURATE = 0;
	public final static int POSSIBLE = 1;

	private final int accuracy;

	private final String name;
	private final String parentModelKey;
	private final PossiblePosition position;

	public ItemReference(String name, String parentModelKey,
			PossiblePosition pos) {
		super();
		this.name = name;
		this.parentModelKey = parentModelKey;
		position = pos;
		accuracy = 0;
	}

	public ItemReference(String name, String parentModelKey,
			PossiblePosition pos, int accuracy) {
		super();
		this.name = name;
		this.parentModelKey = parentModelKey;
		position = pos;
		this.accuracy = accuracy;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public String getName() {
		return name;
	}

	public String getParentModelKey() {
		return parentModelKey;
	}

	public PossiblePosition getPosition() {
		return position;
	}

}
