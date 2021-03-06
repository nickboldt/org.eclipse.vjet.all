/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.internal.core;

import org.eclipse.dltk.mod.core.IField;
import org.eclipse.dltk.mod.core.IMethod;
import org.eclipse.dltk.mod.core.IScriptFolder;
import org.eclipse.dltk.mod.core.IType;

/**
 * This interface is used by IRequestorNameLookup. As results are found by
 * IRequestorNameLookup, they are reported to this interface. An
 * IModelElementRequestor is able to cancel at any time (that is, stop receiving
 * results), by responding <code>true</code> to <code>#isCancelled</code>.
 */
public interface IModelElementRequestor {
	public void acceptField(IField field);

	public void acceptMemberType(IType type);

	public void acceptMethod(IMethod method);

	public void acceptScriptFolder(IScriptFolder ScriptFolder);

	public void acceptType(IType type);

	/**
	 * Returns <code>true</code> if this IModelElementRequestor does not want
	 * to receive any more results.
	 */
	boolean isCanceled();
}
