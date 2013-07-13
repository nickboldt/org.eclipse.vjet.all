/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.internal.core;

import org.eclipse.dltk.mod.core.IModelElement;
import org.eclipse.dltk.mod.core.IModelStatusConstants;
import org.eclipse.dltk.mod.core.ModelException;
import org.eclipse.dltk.mod.internal.core.util.Messages;

/**
 * This operation renames resources (Package fragments and compilation units).
 * 
 * <p>
 * Notes:
 * <ul>
 * <li>When a compilation unit is renamed, its main type and the constructors
 * of the main type are renamed.
 * </ul>
 */
public class RenameResourceElementsOperation extends MoveResourceElementsOperation {
	/**
	 * When executed, this operation will rename the specified elements with the
	 * given names in the corresponding destinations.
	 */
	public RenameResourceElementsOperation(IModelElement[] elements, IModelElement[] destinations, String[] newNames, boolean force) {
		// a rename is a move to the same parent with a new name specified
		// these elements are from different parents
		super(elements, destinations, force);
		setRenamings(newNames);
	}

	/**
	 * @see MultiOperation
	 */
	protected String getMainTaskName() {
		return Messages.operation_renameResourceProgress;
	}

	/**
	 * @see CopyResourceElementsOperation#isRename()
	 */
	protected boolean isRename() {
		return true;
	}

	/**
	 * @see MultiOperation
	 */
	protected void verify(IModelElement element) throws ModelException {
		super.verify(element);
		int elementType = element.getElementType();
		if (!(elementType == IModelElement.SOURCE_MODULE || elementType == IModelElement.SCRIPT_FOLDER)) {
			error(IModelStatusConstants.INVALID_ELEMENT_TYPES, element);
		}
		if (elementType == IModelElement.SOURCE_MODULE) {
			SourceModule cu = (SourceModule) element;
			if (cu.isWorkingCopy() && !cu.isPrimary()) {
				error(IModelStatusConstants.INVALID_ELEMENT_TYPES, element);
			}
		}
		verifyRenaming(element);
	}
}
