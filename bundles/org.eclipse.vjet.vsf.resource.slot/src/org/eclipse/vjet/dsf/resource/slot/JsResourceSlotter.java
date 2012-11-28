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
package org.eclipse.vjet.dsf.resource.slot;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.vjet.dsf.common.exceptions.DsfExceptionHelper;
import org.eclipse.vjet.dsf.resource.trace.ResourceUsageCtx;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsType;


/**
 * Simple manager to hold a list of js resource slot. It can also make slot assignment based on 
 * JsResourceSlotAssignment if exists.
 */
public abstract class JsResourceSlotter extends ResourceSlotter<JsResourceSlot> {

	private Set<JsResourceSlotAssignment> m_slotAssignments = null;
	private IJsResourceReplacement m_replacement = null;
	private String m_runtimeVersion = null;
	
	@Override
	protected JsResourceSlot createSlot(final String name) {
		return new JsResourceSlot(name);
	}
	
	public abstract String getDefaultSlotName();
	
	/**
	 * Get another instance of same type without real slots
	 */
	public abstract JsResourceSlotter cloneAnEmptySlotter();
	
	public void addToSlot(final IJsResourceRef resource) {
		if(isInAnySlot(resource.getUrn())!=null){
			return;
		}
		JsType type = resource.getType();
		if (type.hasExecution() || !type.hasDef()) {
			addToSlot(resource, ScriptType.ExecutingScript);
		} 
		else {
			addToSlot(resource,ScriptType.ClassDefinition);
		}	
	}
	
	/**
	 * convenience method for passing slot name at the same time
	 * for ad hoc resource 
	 * @param resource
	 * @param slotName
	 */
	public void addToSlot(final IJsResourceRef resource, final String slotName){
		if(isInAnySlot(resource.getUrn())!=null){
			return;
		}
		final JsType type = resource.getType();
		ScriptType stype = ScriptType.ClassDefinition;
		if (type.hasExecution() || !type.hasDef()) {
			stype =  ScriptType.ExecutingScript;
		}	
		getSlot(getSlotName(slotName, stype)).add(resource);
		
	}
	
	@Deprecated
	public void addToSlot(IJsResourceRef resource, final  ScriptType type){
		if(isInAnySlot(resource.getUrn())!=null){
			return;
		}
		String urnForAssignment = null;
		if (m_replacement != null && m_replacement.contains(resource)) {
			urnForAssignment = resource.getUrn();
			if (!ResourceUsageCtx.ctx().isFragmentExtractionMode()) {
				resource = m_replacement.getReplacement(resource);				
			}
			//System.out.println(urnForAssignment + " -> " + resource.getUrn());
		}
		final String name = getPreAssignedSlot(
			resource, urnForAssignment, getDefaultSlotName());
		getSlot(getSlotName(name, type)).add(resource);
	}

	public void addSlotAssignment(final JsResourceSlotAssignment slotAssignment) {
		if (slotAssignment == null){
			return;
		}
		if (m_slotAssignments == null) {
			m_slotAssignments = new LinkedHashSet<JsResourceSlotAssignment>(3);
		}
		m_slotAssignments.add(slotAssignment);
	}	
	
	public Set<JsResourceSlotAssignment> getSlotAssignmentList() {
		return m_slotAssignments;
	}
	
	public void setResourceReplacement(final IJsResourceReplacement replacement){
		m_replacement = replacement;
	}
	
	public IJsResourceReplacement getResourceReplacement() {
		return m_replacement;
	}
	
	public void setRuntimeVersion(final String version) {
		if ("".equals(version)) {
			DsfExceptionHelper.chuck("invalid runtime version");
		}
		m_runtimeVersion = version;
	}
	
	public String getRuntimeVersion() {
		return m_runtimeVersion;
	}

	public static String getSlotName(
		final String baseName, final ScriptType type) {
		return baseName + "_" + type.name();
	}

	public static String getSlotName(
		final String baseName, final JsType type) {
		if (type.hasExecution() || !type.hasDef()) {
			return getSlotName(baseName, ScriptType.ExecutingScript);
		} else {
			return getSlotName(baseName, ScriptType.ClassDefinition);
		}
	}
	
	public String getPreAssignedSlot(
		final IJsResourceRef resource,
		final String urnForAssignment,
		final String defaultSlotName)
	{	
		String slotName = null;
		if (m_slotAssignments != null) {
			for (JsResourceSlotAssignment assignment : m_slotAssignments) {
				slotName = findAssignedSlotName(assignment, resource, urnForAssignment);
				if (slotName != null) {
					return slotName;
				}
			}
		}
		return defaultSlotName;
	}
	
	private static String findAssignedSlotName(
		final JsResourceSlotAssignment assignment,
		final IJsResourceRef resource,
		final String urnForAssignment)
	{
		if (assignment == null) {
			return null;
		}
		if (urnForAssignment != null) {
			String slotName = assignment.getSlotName(urnForAssignment);
			if (slotName != null) {
				return slotName;
			}
		}
		if (resource == null) {
			return null;
		}
		return assignment.getSlotName(resource);
	}
}
