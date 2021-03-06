/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     eBay Inc - modification
 *******************************************************************************/
package org.eclipse.vjet.eclipse.core;

import org.eclipse.dltk.mod.core.Flags;
import org.eclipse.dltk.mod.core.IModelElement;
import org.eclipse.dltk.mod.core.ISourceManipulation;
import org.eclipse.dltk.mod.core.ISourceReference;
import org.eclipse.dltk.mod.core.ModelException;

/**
 * Represents an import declaration in Java compilation unit.
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 */
public interface IImportDeclaration extends IModelElement, ISourceReference,
		ISourceManipulation {
	/**
	 * Constant representing an import declaration within a compilation unit. A
	 * Java element with this type can be safely cast to
	 * <code>IImportDeclaration</code>.
	 */
	int ELEMENT_TYPE = 13;

	/**
	 * Returns the name that has been imported. For an on-demand import, this
	 * includes the trailing <code>".*"</code>. For example, for the statement
	 * <code>"import java.util.*"</code>, this returns
	 * <code>"java.util.*"</code>. For the statement
	 * <code>"import java.util.Hashtable"</code>, this returns
	 * <code>"java.util.Hashtable"</code>.
	 * 
	 * @return the name that has been imported
	 */
	String getElementName();

	/**
	 * Returns the modifier flags for this import. The flags can be examined
	 * using class <code>Flags</code>. Only the static flag is meaningful for
	 * import declarations.
	 * 
	 * @return the modifier flags for this import
	 * @exception JavaModelException
	 *                if this element does not exist or if an exception occurs
	 *                while accessing its corresponding resource.
	 * @see Flags
	 * @since 3.0
	 */
	int getFlags() throws ModelException;

	boolean isLibrary();

	/**
	 * Returns whether the import is on-demand. An import is on-demand if it
	 * ends with <code>".*"</code>.
	 * 
	 * @return true if the import is on-demand, false otherwise
	 */
	boolean isOnDemand();
}
