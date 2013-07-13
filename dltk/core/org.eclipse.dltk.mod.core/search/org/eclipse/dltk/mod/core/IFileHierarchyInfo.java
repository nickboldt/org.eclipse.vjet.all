/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.dltk.mod.core;

/**
 * This class contains cached information about file hierarchy
 */
public interface IFileHierarchyInfo {

	/**
	 * Checks whether the given file exists in the file hierarchy.
	 */
	public boolean exists(ISourceModule file);
}
