/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.vjet.eclipse.internal.ui.text.completion;

import org.eclipse.dltk.mod.ui.text.completion.CompletionProposalLabelProvider;
import org.eclipse.dltk.mod.ui.text.completion.ScriptCompletionProcessor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.ui.IEditorPart;
import org.eclipse.vjet.eclipse.core.VjoNature;
import org.eclipse.vjet.eclipse.ui.VjetUIPlugin;

/**
 * JavaScript completion processor
 */
public class JavaScriptCompletionProcessor extends ScriptCompletionProcessor {
	
	public JavaScriptCompletionProcessor(IEditorPart editor,
			ContentAssistant assistant, String partition) {
		super(editor, assistant, partition);
	}

	/*
	 * @see org.eclipse.dltk.mod.ui.text.completion.ScriptCompletionProcessor#getNatureId()
	 */
	protected String getNatureId() {
		return VjoNature.NATURE_ID;
	}

	/*
	 * @see org.eclipse.dltk.mod.ui.text.completion.ScriptCompletionProcessor#getProposalLabelProvider()
	 */
	protected CompletionProposalLabelProvider getProposalLabelProvider() {
		return new JavaScriptCompletionProposalLabelProvider();
	}

	/*
	 * @see org.eclipse.dltk.mod.ui.text.completion.ContentAssistProcessor#getPreferenceStore()
	 */
	protected IPreferenceStore getPreferenceStore() {
		return VjetUIPlugin.getDefault().getPreferenceStore();
	}

	
}
