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
package org.eclipse.vjet.dsf.spec.view;

import java.util.Set;

import org.eclipse.vjet.dsf.common.CallerIntrospector;
import org.eclipse.vjet.dsf.common.exceptions.DsfExceptionHelper;
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;


import org.eclipse.vjet.dsf.resource.slot.ExternalizedSlotGrouping;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotAssignment;
import org.eclipse.vjet.dsf.resource.slot.plan.ResourceProcessCtx;
import org.eclipse.vjet.dsf.spec.collector.ResourceSpecCollector;
import org.eclipse.vjet.dsf.spec.component.BaseJsComponentSpec;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.dsf.spec.resource.IResourceSpec;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceDispenser;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsRefCollection;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResourceRefMgr;
import org.eclipse.vjet.vsf.resource.pattern.js.JsType;


public abstract class BaseViewSpec implements IViewSpec, IJsResourceDispenser {

	private final String m_name;
	private IComponentSpec m_componentSpec;

	private JsResourceSlotAssignment m_jsSlotAssignment; 
	private ExternalizedSlotGrouping m_slotGroupping = new ExternalizedSlotGrouping();
	private ISharedViewSpec m_sharedViewSpec;

	private boolean m_isSecureRequestSupported = false;
	private ResourceProcessCtx m_resourceProcessCtx = new ResourceProcessCtx();
	private boolean m_isJsSystemLibCache;
	private Set<String> m_jsExclusionResourceUrns;
	private boolean m_isForceJsExclusionCheck = false;
	private Set<String> m_cssExclusionResourceUrns;
	private boolean m_isJsSystemLibVariation = false;
	private boolean m_hasL10nResources;
	//
	// Constructor
	//
	public BaseViewSpec(final String name){
		if (name == null){
			DsfExceptionHelper.chuck("name is null");
		}
		m_name = name;
	}
	
	//
	// Satisfying IViewSpec
	//
	public String getName(){
		return m_name;
	}
	
	public IComponentSpec getComponentSpec(){
		if (m_componentSpec == null){
			m_componentSpec = new BaseJsComponentSpec() {};
		}
		return m_componentSpec;
	}
	
	//
	// API
	//
	public BaseViewSpec setComponentSpec(final IComponentSpec componentSpec){
		if (componentSpec == null){
			DsfExceptionHelper.chuck("componentSpec is null");
		}
		m_componentSpec = componentSpec;
		return this;
	}
	

	public BaseViewSpec assignJsSlot(
		final IJsResourceRef resource, final String baseSlotName)
	{
		if (m_jsSlotAssignment == null) {
			m_jsSlotAssignment = new JsResourceSlotAssignment();
		}
		m_jsSlotAssignment.put(resource, baseSlotName);
		return this;
	}
	
	public BaseViewSpec assignJsSlot(
		final JsResource resource, final String baseSlotName)
	{
		if (m_jsSlotAssignment == null) {
			m_jsSlotAssignment = new JsResourceSlotAssignment();
		}
		m_jsSlotAssignment.put(resource, baseSlotName);
		return this;
	}
	
	public BaseViewSpec assignJsSlot(final String urnPrefix,
			final String baseSlotName) {
		if (m_jsSlotAssignment == null) {
			m_jsSlotAssignment = new JsResourceSlotAssignment();
		}
		m_jsSlotAssignment.put(urnPrefix, baseSlotName);
		return this;
	}
	
	public BaseViewSpec assignJsSlot(final IComponentSpec rootSpec,
			final String baseSlotName) {		
		if (m_jsSlotAssignment == null) {
			m_jsSlotAssignment = new JsResourceSlotAssignment();
		}
		ResourceSpecCollector specCollector = new ResourceSpecCollector();
		specCollector.aggregate(rootSpec);		
		for (IResourceSpec spec: specCollector) {
			for (IJsResourceRef resource: spec.getClassDefinitions()) {
				if (!m_jsSlotAssignment.hasAssignment(resource)) {
					assignJsSlot(resource, baseSlotName);
				}
			}
			for (IJsResourceRef resource: spec.getExecutingScript()) {
				if (!m_jsSlotAssignment.hasAssignment(resource)) {
					assignJsSlot(resource, baseSlotName);
				}
			}			
		}		
		return this;
	}

	public boolean isJsSystemLibCache() {
		return m_isJsSystemLibCache;
	}

	public void setIsJsSystemLibCache(boolean isJsSystemLibCache) {
		m_isJsSystemLibCache = isJsSystemLibCache;
	}

	public BaseViewSpec supportSecureRequest() {
		m_isSecureRequestSupported = true;
		return this;
	}
	
	public boolean isSecureRequestSupported() {
		return m_isSecureRequestSupported;
	}
	
	public BaseViewSpec enableDataUri() {
		m_resourceProcessCtx.setDataUriEnabled(true);
		return this;
	}
	
	public boolean isDataUriEnabled() {
		return m_resourceProcessCtx.isDataUriEnabled();
	}
	
	public BaseViewSpec setDataUriMaxRepeatCount( int maxRpt) {
		m_resourceProcessCtx.setDataUriMaxRepeatCount(maxRpt);
		return this;
	}
	
	public int getDataUriMaxRepeatCount() {
		return m_resourceProcessCtx.getDataUriMaxRepeatCount();
	}
	
	public ResourceProcessCtx getResourceProcessCtx(){
		return m_resourceProcessCtx;
	}

	public JsResourceSlotAssignment getJsSlotAssignment() {
		return m_jsSlotAssignment;
	}
	
	public void setJsSlotAssignment(JsResourceSlotAssignment assignment) {
		m_jsSlotAssignment = assignment;
	}
	
	public ExternalizedSlotGrouping getExternalizedJsSlotGrouping() {
		return m_slotGroupping;
	}
	
	protected void setExternalizedJsSlotGrouping(ExternalizedSlotGrouping slotGroupping) {
		m_slotGroupping = slotGroupping;
	}
	
	public JsRefCollection getJsRefs() {
		return JsRefMgrAdapter.getRefs(getClass());
	}
	
	@SuppressWarnings("unchecked")
	protected static IJsResourceRef jsRef(final JsResource resource, final JsType type) {
		final Class<? extends IJsResourceDispenser> ownerClz = 
			(Class<? extends IJsResourceDispenser>)CallerIntrospector.getCallingClass();
		final IJsResourceRef ref = JsRefMgrAdapter.createJsRef(resource, ownerClz, type);
		JsRefMgrAdapter.addRef(ownerClz, ref);
		return ref;
	}
	
	@SuppressWarnings("unchecked")
	protected static IJsResourceRef onFlyJsRef(final JsResource resource, final JsType type) {
		final Class<? extends IJsResourceDispenser> ownerClz = 
			(Class<? extends IJsResourceDispenser>)CallerIntrospector.getCallingClass();
		final IJsResourceRef ref = JsRefMgrAdapter.createJsRef(resource, ownerClz, type);
		return ref;
	}
	
	private static class JsRefMgrAdapter extends JsResourceRefMgr {
		protected static synchronized void addRef(
			final Class<? extends IJsResourceDispenser> dispenser, 
			final IJsResourceRef ref)
		{	
			JsResourceRefMgr.addRef(dispenser, ref);
		}
		
		protected static JsRefCollection getRefs
			(Class<? extends IJsResourceDispenser> dispenser) {
			
			return JsResourceRefMgr.getRefs(dispenser);
		}
		
		protected static IJsResourceRef createJsRef(
			final JsResource resource, 
			final Class<? extends IJsResourceDispenser> dispenser,
			final JsType type) 
		{
			return JsResourceRefMgr.createJsRef(resource, dispenser, type);
		}
	}
	
	public BaseViewSpec setSharedViewSpec(ISharedViewSpec spec) {
		if (this instanceof ISharedViewSpec) {
			throw new DsfRuntimeException("An ISharedViewSpec cannot set a shared spec. We only support one level of spec sharing.");
		}
		m_sharedViewSpec = spec;
		return this;
	}
	
	public ISharedViewSpec getSharedViewSpec() {
		return m_sharedViewSpec;
	}

	@Override
	public Set<String> getJsExclusionResourceUrns() {
		return m_jsExclusionResourceUrns;
	}

	public BaseViewSpec setJsExclusionResourceUrns(Set<String> exclusionResourceUrns) {
		m_jsExclusionResourceUrns = exclusionResourceUrns;
		return this;
	}

	@Override
	public Set<String> getCssExclusionResourceUrns() {
		return m_cssExclusionResourceUrns;
	}

	public BaseViewSpec setCssExclusionResourceUrns(Set<String> exclusionResourceUrns) {
		m_cssExclusionResourceUrns = exclusionResourceUrns;
		return this;
	}

	public boolean isForceJsExclusionCheck() {
		return m_isForceJsExclusionCheck;
	}

	public BaseViewSpec setForceJsExclusionCheck(boolean forceJsExclusionCheck) {
		m_isForceJsExclusionCheck = forceJsExclusionCheck;
		return this;
	}

	public boolean isJsSystemLibVariation() {
		return m_isJsSystemLibVariation;
	}

	public void setJsSystemLibVariation(boolean jsSystemLibVariation) {
		m_isJsSystemLibVariation = jsSystemLibVariation;
	}
	
	public boolean hasL10nResources() {
		return m_hasL10nResources;
	}
	
	public void enableL10nResources() {
		m_hasL10nResources = true;
	}

}
