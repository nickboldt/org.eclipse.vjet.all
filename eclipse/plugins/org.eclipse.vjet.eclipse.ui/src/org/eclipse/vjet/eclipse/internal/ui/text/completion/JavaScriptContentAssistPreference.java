/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.vjet.eclipse.internal.ui.text.completion;


import org.eclipse.dltk.mod.ui.text.ScriptTextTools;
import org.eclipse.dltk.mod.ui.text.completion.ContentAssistPreference;
import org.eclipse.vjet.eclipse.ui.VjetUIPlugin;

public class JavaScriptContentAssistPreference extends ContentAssistPreference {
	static JavaScriptContentAssistPreference sDefault;
	protected ScriptTextTools getTextTools() {
		return VjetUIPlugin.getDefault().getTextTools();
	}

	public static ContentAssistPreference getDefault() {
		if( sDefault == null ) {
			sDefault = new JavaScriptContentAssistPreference();
		}
		return sDefault;
	}
}
