/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.vsf.aggregator.js;

import java.util.List;

import org.w3c.dom.Node;

import org.eclipse.vjet.dsf.common.trace.TraceCtx;
import org.eclipse.vjet.dsf.dom.DComment;
import org.eclipse.vjet.dsf.dom.DDocument;
import org.eclipse.vjet.dsf.dom.DElement;
import org.eclipse.vjet.dsf.html.dom.DBody;
import org.eclipse.vjet.dsf.html.dom.DHtmlDocument;
import org.eclipse.vjet.dsf.html.dom.DScript;
import org.eclipse.vjet.vsf.docprocessing.IJsResourceApplier;
import org.eclipse.vjet.vsf.jsruntime.JsRuntimeVersion;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceHandle;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.dsf.resource.permutation.Permutation;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlot;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotter;

/**
 * default js resource applier to apply slotted resources on to document
 */
public class JsResourceApplier implements IJsResourceApplier {

	public static JsResourceApplier DEFAULT = new JsResourceApplier();

	protected String m_jsRtVersion = null;

	public void apply(
		final DDocument doc, 
		final JsResourceSlotter slotter, 
		final boolean applyScope)
	{
		apply((DHtmlDocument)doc, slotter, applyScope);
	}
	
	public void apply(
		final DHtmlDocument doc, 
		final JsResourceSlotter slotter, 
		boolean applyScope)
	{
		if (applyScope) {
			initVersionScope(doc, slotter);
		}

		final Permutation permutation = Permutation.getFromCtx();
		final DBody body = doc.getBody();
		final Node firstChild = body.getFirstChild();

		for (JsResourceSlot slot : slotter.getAllSlots()) {
			Node childRefToInsertBefore = null;
			if (slot.getName().startsWith("BEFORE")) {
				childRefToInsertBefore = firstChild;
			}
			addSlotToElement(slot, permutation, body, childRefToInsertBefore);
		}
	}

	public void initVersionScope(
		final DHtmlDocument doc, final JsResourceSlotter slotter)
	{
		m_jsRtVersion = slotter.getRuntimeVersion();
		if (m_jsRtVersion == null) return ;

		final DScript script = new DScript()
			.setHtmlType(DScript.TYPE_TEXT_JAVASCRIPT)
			.setHtmlText(JsRuntimeVersion.getVersionScopeInit(m_jsRtVersion));
		doc.getHead().add(script);
	}

	public void addSlotToElement(
		final JsResourceSlot slot,
		final Permutation permutation, final DElement parent,
		final Node childRefToInsertBefore)
	{
		List<IJsResourceRef> refs = slot.getResourceRefs();
		if (refs.size() <= 0) {
			return;
		}

		boolean verboseOn = TraceCtx.ctx().getTraceManager().isVerboseOn();
		if (verboseOn) {
			final DComment beginComment = new DComment(" begin " + slot.getName());
			parent.insertBefore(beginComment, childRefToInsertBefore);
		}
		
		final StringBuilder scriptText = new StringBuilder();
		for (IJsResourceRef ref : refs) {
			IJsResourceHandle handle = ref.getHandle(permutation);
			if (handle.isExternalized()) {
				if (m_jsRtVersion!=null) {
					final DScript script = new DScript()
						.setHtmlType(DScript.TYPE_TEXT_JAVASCRIPT)
						.setHtmlText(JsRuntimeVersion.getExternalFileScope(m_jsRtVersion));
					parent.insertBefore(script, childRefToInsertBefore);
				}
				final DScript script;
				script = new DScript()
					.setHtmlType(DScript.TYPE_TEXT_JAVASCRIPT)
					.setHtmlSrc(handle.getExternalUrl().toExternalForm());
				parent.insertBefore(script, childRefToInsertBefore);
			} 
			else {
				// collect script text do not create nodes for each code gen ref
				scriptText.append(ref.getHandle(permutation).getScriptText());
				scriptText.append("\n");
			}
		}

		if (m_jsRtVersion != null && scriptText.length() > 0) {
			scriptText.insert(0, JsRuntimeVersion.getVersionScopeStart(m_jsRtVersion));
			scriptText.append(JsRuntimeVersion.getVersionScopeEnd(m_jsRtVersion));
		}

		final String scriptTextString = scriptText.toString();
		//if (scriptTextString != null && scriptTextString.length() > 0) {
		//BUGDB00625213 fix
		if (scriptTextString != null && scriptTextString.trim().length() > 0) {
			final DScript script = new DScript()
				.setHtmlType(DScript.TYPE_TEXT_JAVASCRIPT)
				.setHtmlText(scriptTextString);
			parent.insertBefore(script, childRefToInsertBefore);
		}

		if (verboseOn) {
			final DComment endComment = new DComment("end " + slot.getName());
			parent.insertBefore(endComment, childRefToInsertBefore);
		}
	}
}
