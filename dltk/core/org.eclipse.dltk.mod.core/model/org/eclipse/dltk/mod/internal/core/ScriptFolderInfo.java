/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.internal.core;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.dltk.mod.core.ModelException;

public class ScriptFolderInfo extends OpenableElementInfo {
	private Object[] foreignResources;

	void setForeignResources(Object[] resources) {
		foreignResources = resources;
	}

	public Object[] getForeignResources(IResource resource,
			ProjectFragment projectFragment) {
		if (this.foreignResources == null) {
			try {
				this.foreignResources = ProjectFragmentInfo
						.computeFolderForeignResources(
								(ScriptProject) projectFragment
										.getScriptProject(),
								(IContainer) resource, projectFragment
										.fullInclusionPatternChars(),
								projectFragment.fullExclusionPatternChars());
			} catch (ModelException e) {
				// root doesn't exist: consider package has no
				// nonScriptResources
				this.foreignResources = NO_NON_SCRIPT_RESOURCES;
			}
		}
		return this.foreignResources;
	}

	boolean containsScriptResources() {
		return size() != 0;
	}
}
