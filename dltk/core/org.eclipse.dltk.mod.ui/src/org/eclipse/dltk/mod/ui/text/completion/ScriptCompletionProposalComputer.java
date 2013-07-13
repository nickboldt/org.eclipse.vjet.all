/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.ui.text.completion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.mod.core.DLTKCore;
import org.eclipse.dltk.mod.core.IModelElement;
import org.eclipse.dltk.mod.core.ISourceModule;
import org.eclipse.dltk.mod.core.ModelException;
import org.eclipse.dltk.mod.ui.DLTKUIPlugin;
import org.eclipse.dltk.mod.ui.PreferenceConstants;
import org.eclipse.dltk.mod.ui.templates.ScriptTemplateProposal;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationExtension;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;

/**
 * Computes Script completion proposals and context infos.
 */
public abstract class ScriptCompletionProposalComputer implements
		IScriptCompletionProposalComputer {

	private static final class ContextInformationWrapper implements
			IContextInformation, IContextInformationExtension {

		private final IContextInformation fContextInformation;
		private int fPosition;

		public ContextInformationWrapper(IContextInformation contextInformation) {
			fContextInformation = contextInformation;
		}

		public String getContextDisplayString() {
			return fContextInformation.getContextDisplayString();
		}

		public Image getImage() {
			return fContextInformation.getImage();
		}

		public String getInformationDisplayString() {
			return fContextInformation.getInformationDisplayString();
		}

		public int getContextInformationPosition() {
			return fPosition;
		}

		public void setContextInformationPosition(int position) {
			fPosition = position;
		}

		public boolean equals(Object object) {
			if (object instanceof ContextInformationWrapper)
				return fContextInformation
						.equals(((ContextInformationWrapper) object).fContextInformation);
			else
				return fContextInformation.equals(object);
		}
	}

	private String fErrorMessage;

	private List addContextInformations(
			ScriptContentAssistInvocationContext context, int offset,
			IProgressMonitor monitor) {
		List proposals = computeScriptCompletionProposals(offset, context,
				monitor);
		List result = new ArrayList(proposals.size());

		for (Iterator it = proposals.iterator(); it.hasNext();) {
			ICompletionProposal proposal = (ICompletionProposal) it.next();
			IContextInformation contextInformation = proposal
					.getContextInformation();
			if (contextInformation != null) {
				ContextInformationWrapper wrapper = new ContextInformationWrapper(
						contextInformation);
				wrapper.setContextInformationPosition(offset);
				result.add(wrapper);
			}
		}
		return result;
	}

	private void handleCodeCompletionException(ModelException e,
			ScriptContentAssistInvocationContext context) {
		ISourceModule module = context.getSourceModule();
		Shell shell = context.getViewer().getTextWidget().getShell();
		if (e.isDoesNotExist()
				&& !module.getScriptProject().isOnBuildpath(module)) {
			IPreferenceStore store = DLTKUIPlugin.getDefault()
					.getPreferenceStore();
			boolean value = store
					.getBoolean(PreferenceConstants.NOTIFICATION_NOT_ON_BUILDPATH_MESSAGE);
			if (!value) {
				MessageDialog
						.openInformation(
								shell,
								ScriptTextMessages.CompletionProcessor_error_notOnBuildPath_title,
								ScriptTextMessages.CompletionProcessor_error_notOnBuildPath_message);
			}
			store.setValue(
					PreferenceConstants.NOTIFICATION_NOT_ON_BUILDPATH_MESSAGE,
					true);
		} else
			ErrorDialog
					.openError(
							shell,
							ScriptTextMessages.CompletionProcessor_error_accessing_title,
							ScriptTextMessages.CompletionProcessor_error_accessing_message,
							e.getStatus());
	}

	// Code template completion proposals for script language
	protected List computeTemplateCompletionProposals(int offset,
			ScriptContentAssistInvocationContext context,
			IProgressMonitor monitor) {
		TemplateCompletionProcessor templateProcessor = createTemplateProposalComputer(context);
		if (templateProcessor != null) {
			ICompletionProposal[] proposals = templateProcessor
					.computeCompletionProposals(context.getViewer(), offset);
			if (proposals != null && proposals.length != 0) {
				updateTemplateProposalRelevance(context, proposals);
			}
			return Arrays.asList(proposals);
		}

		return Collections.EMPTY_LIST;
	}

	/**
	 * Update relevance of template proposals that match with a keyword give
	 * those templates slightly more relevance than the keyword to sort them
	 * first.
	 */
	protected void updateTemplateProposalRelevance(
			ScriptContentAssistInvocationContext context,
			ICompletionProposal[] proposals) {
		IScriptCompletionProposal[] keywords = context.getKeywordProposals();
		if (keywords == null || keywords.length == 0) {
			return;
		}
		for (int i = 0; i < proposals.length; ++i) {
			ICompletionProposal cp = proposals[i];
			if (cp instanceof ScriptTemplateProposal) {
				final ScriptTemplateProposal tp = (ScriptTemplateProposal) cp;
				final String name = tp.getPattern();
				for (int j = 0; j < keywords.length; ++j) {
					if (name.startsWith(keywords[j].getDisplayString())) {
						tp.setRelevance(keywords[j].getRelevance() + 1);
					}
				}
			}
		}
	}

	// Script language specific completion proposals like types or keywords
	protected List computeScriptCompletionProposals(int offset,
			ScriptContentAssistInvocationContext context,
			IProgressMonitor monitor) {

		// Source module getting
		ISourceModule sourceModule = context.getSourceModule();
		if (sourceModule == null) {
			return Collections.EMPTY_LIST;
		}

		// Create and configure collector
		ScriptCompletionProposalCollector collector = createCollector(context);
		if (collector == null) {
			return Collections.EMPTY_LIST;
		}

		collector.setInvocationContext(context);
		Point selection = context.getViewer().getSelectedRange();
		if (selection.y > 0) {
			collector.setReplacementLength(selection.y);
		}

		// Filling collector with proposals
		try {
			if (DLTKCore.DEBUG_COMPLETION) {
				IModelElement element = sourceModule.getElementAt(offset);
				if (element != null) {
					System.out.println("========= Model element: " //$NON-NLS-1$
							+ element.getClass());
				}
			}

			sourceModule.codeComplete(offset, collector);
		} catch (ModelException e) {
			handleCodeCompletionException(e, context);
		}

		ICompletionProposal[] proposals = collector
				.getScriptCompletionProposals();

		// Checking proposals
		if (proposals.length == 0) {
			String error = collector.getErrorMessage();
			if (error.length() > 0) {
				fErrorMessage = error;
			}

			return Collections.EMPTY_LIST;
		}

		return Arrays.asList(proposals);
	}

	public ScriptCompletionProposalComputer() {
	}

	/*
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposalComputer#computeContextInformation(org.eclipse.jface.text.contentassist.TextContentAssistInvocationContext,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	/*
	 * public List computeContextInformation(ContentAssistInvocationContext
	 * context, IProgressMonitor monitor) { if (context instanceof
	 * ScriptContentAssistInvocationContext) {
	 * ScriptContentAssistInvocationContext scriptContext=
	 * (ScriptContentAssistInvocationContext) context;
	 * 
	 * int contextInformationPosition=
	 * guessContextInformationPosition(scriptContext); List result=
	 * addContextInformations(scriptContext, contextInformationPosition,
	 * monitor); return result; } return Collections.EMPTY_LIST; }
	 */

	// Completion proposals
	public List computeCompletionProposals(
			ContentAssistInvocationContext context, IProgressMonitor monitor) {

		if (context instanceof ScriptContentAssistInvocationContext) {
			ScriptContentAssistInvocationContext scriptContext = (ScriptContentAssistInvocationContext) context;

			List proposals = new ArrayList();

			// Language specific proposals (already sorted and etc.)
			proposals.addAll(computeScriptCompletionProposals(context
					.getInvocationOffset(), scriptContext, monitor));

			// Template proposals (already sorted and etc.)
			proposals.addAll(computeTemplateCompletionProposals(context
					.getInvocationOffset(), scriptContext, monitor));

			return proposals;
		}

		return Collections.EMPTY_LIST;
	}
	protected int guessContextInformationPosition(ContentAssistInvocationContext context) {
		return context.getInvocationOffset();
	}
	public List computeContextInformation(
			ContentAssistInvocationContext context, IProgressMonitor monitor) {//

		if (context instanceof ScriptContentAssistInvocationContext) {
			ScriptContentAssistInvocationContext scriptContext = (ScriptContentAssistInvocationContext) context;

			int contextInformationPosition = guessContextInformationPosition(scriptContext);
			List result = addContextInformations(scriptContext,
					contextInformationPosition, monitor);
			return result;
		}
		return Collections.EMPTY_LIST;

		// List types = computeCompletionProposals(context, monitor);
		// Iterator iter = types.iterator();

		// List list = new ArrayList();
		// while (iter.hasNext()) {
		// Object o = iter
		// .next();
		// if( !( o instanceof IScriptCompletionProposal ) ) {
		// continue;
		// }
		// IScriptCompletionProposal proposal = (IScriptCompletionProposal) o;
		// // System.out.println("Proposal: " + proposal + ", info: "
		// // + proposal.getContextInformation());
		// // System.out.println(proposal.getClass());
		// list.add(proposal.getContextInformation());
		// }
		// return list;
	}

	public String getErrorMessage() {
		return fErrorMessage;
	}

	public void sessionStarted() {
	}

	public void sessionEnded() {
		fErrorMessage = null;
	}
	
	/**
	 * Creates the template completion processor
	 * 
	 * <p>Subclasses may return <code>null</code> if they do not wish to 
	 * provide template support.</p>
	 */
	protected abstract TemplateCompletionProcessor createTemplateProposalComputer(
			ScriptContentAssistInvocationContext context);

	protected ScriptCompletionProposalCollector createCollector(
			ScriptContentAssistInvocationContext context) {
		return null;
	}
}
