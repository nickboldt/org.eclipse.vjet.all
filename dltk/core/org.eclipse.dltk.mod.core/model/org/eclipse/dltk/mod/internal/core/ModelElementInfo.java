/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.internal.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.mod.core.IModelElement;

/**
 * Holds cached structure and properties for a model element. Subclassed to
 * carry properties for specific kinds of elements.
 */
/* package */class ModelElementInfo {

	/**
	 * Collection of handles of immediate children of this object. This is an
	 * empty array if this element has no children.
	 */
	private List children;

	/**
	 * Shared empty collection used for efficiency.
	 */
	static Object[] NO_NON_SCRIPT_RESOURCES = new Object[] {};

	protected ModelElementInfo() {
	}

	public void addChild(IModelElement child) {
		if (this.children == null) {
			this.children = new ArrayList(5);
		}
		if (!this.children.contains(child)) {
			this.children.add(child);
		}
	}

	public int size() {
		if (this.children == null)
			return 0;
		return this.children.size();
	}

	protected IModelElement get(int i) {
		if (this.children == null)
			return null;
		return (IModelElement) children.get(i);
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error();
		}
	}

	public IModelElement[] getChildren() {
		if (children == null)
			return ModelElement.NO_ELEMENTS;
		return (IModelElement[]) this.children
				.toArray(new IModelElement[this.children.size()]);
	}

	public void removeChild(IModelElement child) {
		if (this.children != null) {
			this.children.remove(child);
		}
	}

	public void setChildren(IModelElement[] children) {
		if (children == null) {
			this.children = null;
		} else {
			this.children = new ArrayList(children.length);
			for (int i = 0; i < children.length; i++) {
				this.children.add(children[i]);
			}
		}
	}

}
