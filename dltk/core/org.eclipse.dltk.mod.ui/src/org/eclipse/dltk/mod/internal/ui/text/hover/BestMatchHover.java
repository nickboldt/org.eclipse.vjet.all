/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.internal.ui.text.hover;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.dltk.mod.internal.ui.editor.ScriptEditor;
import org.eclipse.dltk.mod.ui.DLTKUIPlugin;
import org.eclipse.dltk.mod.ui.PreferenceConstants;
import org.eclipse.dltk.mod.ui.text.hover.IScriptEditorTextHover;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextHoverExtension;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.information.IInformationProviderExtension2;
import org.eclipse.ui.IEditorPart;

/**
 * Caution: this implementation is a layer breaker and contains some "shortcuts"
 */
public class BestMatchHover extends AbstractScriptEditorTextHover implements
		ITextHoverExtension, IInformationProviderExtension2 {

	private List fTextHoverSpecifications = null;
	private List fInstantiatedTextHovers;
	private ITextHover fBestHover;

	public BestMatchHover() {
	}

	public BestMatchHover(IEditorPart editor, IPreferenceStore store) {
		setEditor(editor);
		setPreferenceStore(store);
	}

	/**
	 * Installs all text hovers.
	 */
	private void installTextHovers() {

		// initialize lists - indicates that the initialization happened
		fTextHoverSpecifications = new ArrayList(2);
		fInstantiatedTextHovers = new ArrayList(2);

		// populate list
		EditorTextHoverDescriptor[] hoverDescs = DLTKUIPlugin.getDefault()
				.getEditorTextHoverDescriptors(getPreferenceStore(),
						getNatureId());
		for (int i = 0; i < hoverDescs.length; i++) {
			// ensure that we don't add ourselves to the list
			if (!PreferenceConstants.ID_BESTMATCH_HOVER.equals(hoverDescs[i]
					.getId()))
				fTextHoverSpecifications.add(hoverDescs[i]);
		}
	}

	private String getNatureId() {
		final IEditorPart editor = getEditor();
		if (editor == null || !(editor instanceof ScriptEditor)) {
			return null;
		}
		return ((ScriptEditor) editor).getLanguageToolkit().getNatureId();
	}

	private void checkTextHovers() {
		if (fTextHoverSpecifications == null) {
			installTextHovers();
		}
		if (fTextHoverSpecifications.isEmpty())
			return;

		for (Iterator iterator = new ArrayList(fTextHoverSpecifications)
				.iterator(); iterator.hasNext();) {
			EditorTextHoverDescriptor spec = (EditorTextHoverDescriptor) iterator
					.next();

			IScriptEditorTextHover hover = spec.createTextHover();
			if (hover != null) {
				hover.setEditor(getEditor());
				hover.setPreferenceStore(getPreferenceStore());
				addTextHover(hover);
				fTextHoverSpecifications.remove(spec);
			}
		}
	}

	protected void addTextHover(ITextHover hover) {
		if (!fInstantiatedTextHovers.contains(hover))
			fInstantiatedTextHovers.add(hover);
	}

	/*
	 * @see ITextHover#getHoverInfo(ITextViewer, IRegion)
	 */
	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {

		checkTextHovers();
		fBestHover = null;

		if (fInstantiatedTextHovers == null)
			return null;

		for (Iterator iterator = fInstantiatedTextHovers.iterator(); iterator
				.hasNext();) {
			ITextHover hover = (ITextHover) iterator.next();

			String s = hover.getHoverInfo(textViewer, hoverRegion);
			if (s != null && s.trim().length() > 0) {
				fBestHover = hover;
				return s;
			}
		}

		return null;
	}

	/*
	 * @see org.eclipse.jface.text.ITextHoverExtension#getHoverControlCreator()
	 */
	public IInformationControlCreator getHoverControlCreator() {
		if (fBestHover instanceof ITextHoverExtension)
			return ((ITextHoverExtension) fBestHover).getHoverControlCreator();

		return null;
	}

	/*
	 * @seeorg.eclipse.jface.text.information.IInformationProviderExtension2#
	 * getInformationPresenterControlCreator()
	 */
	public IInformationControlCreator getInformationPresenterControlCreator() {
		if (fBestHover instanceof IInformationProviderExtension2)
			return ((IInformationProviderExtension2) fBestHover)
					.getInformationPresenterControlCreator();

		return null;
	}

}
