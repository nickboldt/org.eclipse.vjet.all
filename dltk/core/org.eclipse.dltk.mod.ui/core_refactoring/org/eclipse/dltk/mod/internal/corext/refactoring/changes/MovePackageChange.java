/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.internal.corext.refactoring.changes;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.mod.core.IProjectFragment;
import org.eclipse.dltk.mod.core.IScriptFolder;
import org.eclipse.dltk.mod.core.ModelException;
import org.eclipse.dltk.mod.internal.corext.refactoring.RefactoringCoreMessages;
import org.eclipse.dltk.mod.internal.corext.util.Messages;
import org.eclipse.ltk.core.refactoring.Change;


public class MovePackageChange extends ScriptFolderReorgChange {
	
	public MovePackageChange(IScriptFolder pack, IProjectFragment dest){
		super(pack, dest, null);
	}
	
	protected Change doPerformReorg(IProgressMonitor pm) throws ModelException{
		getPackage().move(getDestination(), null, getNewName(), true, pm);
		return null;
	}
	
	public String getName() {
		return Messages.format(RefactoringCoreMessages.MovePackageChange_move, 
			new String[]{getPackage().getElementName(), getDestination().getElementName()});
	}
}
