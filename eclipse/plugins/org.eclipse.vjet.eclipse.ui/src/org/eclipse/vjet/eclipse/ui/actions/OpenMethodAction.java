/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.vjet.eclipse.ui.actions;


import org.eclipse.dltk.mod.ui.IDLTKUILanguageToolkit;
import org.eclipse.vjet.eclipse.internal.ui.VjetUILanguageToolkit;

/**
 * @author jcompagner
 * 
 */
public class OpenMethodAction extends
		org.eclipse.dltk.mod.ui.actions.OpenMethodAction {

	/**
	 * @see org.eclipse.dltk.mod.ui.actions.OpenMethodAction#getUILanguageToolkit()
	 */
	protected IDLTKUILanguageToolkit getUILanguageToolkit() {
		return new VjetUILanguageToolkit();
	}

}
