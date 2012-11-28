/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.vjet.eclipse.internal.ui.editor;

import org.eclipse.core.filebuffers.IDocumentSetupParticipant;
import org.eclipse.jface.text.IDocument;
import org.eclipse.vjet.eclipse.internal.ui.text.IJavaScriptPartitions;
import org.eclipse.vjet.eclipse.internal.ui.text.JavascriptTextTools;
import org.eclipse.vjet.eclipse.ui.VjetUIPlugin;


/**
 * The document setup participant for Javascript.
 */
public class JavaScriptDocumentSetupParticipant implements
		IDocumentSetupParticipant {

	public JavaScriptDocumentSetupParticipant() {
	}

	/*
	 * @see org.eclipse.core.filebuffers.IDocumentSetupParticipant#setup(org.eclipse.jface.text.IDocument)
	 */
	public void setup(IDocument document) {
		JavascriptTextTools tools = VjetUIPlugin.getDefault().getTextTools();
		tools.setupDocumentPartitioner(document,
				IJavaScriptPartitions.JS_PARTITIONING);
	}
}
