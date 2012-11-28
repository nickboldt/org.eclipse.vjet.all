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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



//import org.eclipse.vjet.dsf.aggregator.cache.ResourceAggregationControl;
import org.eclipse.vjet.dsf.dom.DDocument;
import org.eclipse.vjet.vsf.jsruntime.JsRuntimeVersion;
import org.eclipse.vjet.dsf.spec.resource.IResourceSpec;
import org.eclipse.vjet.dsf.spec.collector.ResourceSpecCollector;

import org.eclipse.vjet.dsf.spec.export.IExportJsResource;
import org.eclipse.vjet.dsf.spec.export.IExportJsSlotter;
import org.eclipse.vjet.dsf.spec.export.JsExportableCompCollector;
import org.eclipse.vjet.dsf.resource.permutation.Permutation;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotAssignment;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotter;
import org.eclipse.vjet.dsf.resource.slot.simple.SimpleJsResourceSlotter;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.dsf.spec.view.IViewSpec;
import org.eclipse.vjet.vsf.aggregator.cache.JsResourceCache;
import org.eclipse.vjet.vsf.aggregator.cache.JsSystemLibCache;
import org.eclipse.vjet.vsf.aggregator.cache.ResourceAggregationControl;
import org.eclipse.vjet.vsf.aggregator.cache.ViewSpecResourceCacheMgr;
import org.eclipse.vjet.vsf.aggregator.cache.js.JsResourceAggregator;
import org.eclipse.vjet.vsf.aggregator.js.registry.JsCompRegistryProcessor;
import org.eclipse.vjet.vsf.docprocessing.IJsProcessor;
import org.eclipse.vjet.vsf.docprocessing.IJsResourceApplier;
import org.eclipse.vjet.vsf.jsref.ctx.ResourceCtx;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;

public class BaseJsProcessor implements IJsProcessor {
	
	protected JsResourceSlotter m_slotter;
	protected IJsResourceApplier m_applier;
	protected JsSystemLibCache m_libCache;
	
	private IncompatibleJsSlotterMgr m_incompatibleSlotterMgr 
		= new IncompatibleJsSlotterMgr();

	private boolean m_processInstanceBasedJsContribution = true ;//keeping previous behavior as default; 
	
	public BaseJsProcessor() {
		this(null, null, null);
	}

	public BaseJsProcessor(final JsResourceSlotter slotter,
			final IJsResourceApplier applier, final JsSystemLibCache libCache)
	{
		this(slotter, applier, libCache, true); //keeping previous behavior as default
	}
	public BaseJsProcessor(final JsResourceSlotter slotter,
		final IJsResourceApplier applier, final JsSystemLibCache libCache, final boolean processInstanceBasedJsContribution)
	{
		m_applier = (applier != null) ? applier : createApplier();
		setSlotter((slotter != null) ? slotter : createSlotter());
		setLibCache(libCache);
		m_processInstanceBasedJsContribution = processInstanceBasedJsContribution;
	}

	//
	// API
	//
	public void process(final DDocument doc) {
		process(doc, null);
	}

	public void process(final DDocument doc, final IViewSpec viewSpec) {		
		aggragateJs(doc, viewSpec);		
		applyJsToDoc(doc);
	}

	public IJsResourceApplier getApplier() {
		return m_applier;
	}

	public void setApplier(final IJsResourceApplier applier) {
		m_applier = applier;
	}
	
	public IJsResourceApplier createApplier(){
		return new JsResourceApplier();
	}

	public JsSystemLibCache getLibCache() {
		return m_libCache;
	}

	public void setLibCache(final JsSystemLibCache cache) {
		m_libCache = cache;
		if (m_slotter != null && m_libCache != null) {
			m_slotter.setResourceReplacement(m_libCache);
		}
	}

	public JsResourceSlotter getSlotter() {
		return m_slotter;
	}

	public void setSlotter(final JsResourceSlotter slotter) {
		m_slotter = slotter;
		if (m_slotter.getSlotAssignmentList()==null){
			m_slotter.addSlotAssignment(createAssignment());
		}
		if (JsRuntimeVersion.enabled() && slotter.getRuntimeVersion()==null) {
			m_slotter.setRuntimeVersion(JsRuntimeVersion.getCurrentVersion());
		}
		if (m_slotter != null && m_libCache != null) {
			m_slotter.setResourceReplacement(m_libCache);
		}
	}

	protected void applyJsToDoc(final DDocument doc) {
		m_applier.apply(doc, m_slotter, !m_incompatibleSlotterMgr.isEmpty());
		m_incompatibleSlotterMgr.apply(doc);
	}
	
	protected void aggragateJs(final DDocument doc, final IViewSpec viewSpec) {
		
		final ResourceCtx context = ResourceCtx.ctx();
		final Permutation permutation = Permutation.getFromCtx();
		final JsExportableCompCollector instanceCollector 
			= context.getJsInstanceCollector();
		final ResourceSpecCollector specCollector = new ResourceSpecCollector();
		
		Set<String> exclusionList = new HashSet<String>();
		if (viewSpec != null) {
			Set<String> exclusion = aggregateViewSpec(viewSpec, permutation, specCollector, m_slotter);
			if(exclusion!=null){
				exclusionList.addAll(exclusion);
			}
			//adding JsExclusionResourceUrns to exclusion list.
			if(!viewSpec.isJsSystemLibCache() || viewSpec.isForceJsExclusionCheck()){
				Set<String> urns = viewSpec.getJsExclusionResourceUrns();
				if(urns!=null){
					exclusionList.addAll(urns);
				}
			}
		}
		aggregateContext(context, specCollector, exclusionList);
		
		// collect instance based JS contribution
		aggregateRunTimeInstances(instanceCollector, exclusionList);
		if(m_processInstanceBasedJsContribution){
			aggregateComponentInitialization();
		}
	}

	private void aggregateComponentInitialization() {
		JsCompRegistryProcessor.process(m_slotter);
		// TODO: remove this move to location when js runtime is finished
		// registry.reset();
	}

	private void aggregateRunTimeInstances(
			final JsExportableCompCollector instanceCollector,
			final Set<String> exclusion) {

		if (instanceCollector != null
				&& instanceCollector.hasExportedResource()) {
			for (IExportJsResource resource : instanceCollector
					.getExportedResources()) {
				JsResourceSlotter slotter = m_slotter;
				if (resource instanceof IExportJsSlotter) {
					IExportJsSlotter exportJsSlotter = (IExportJsSlotter) resource;
					if(JsRuntimeVersion.enabled()){
						String currentRtVersion = m_slotter.getRuntimeVersion();
						String anotherRtVersion = exportJsSlotter
								.getJsRuntimeVersion();
						if ((currentRtVersion != null 
								&& !currentRtVersion.equals(anotherRtVersion))
								|| (anotherRtVersion != null 
									&& !anotherRtVersion.equals(currentRtVersion)))
						{
							slotter = m_incompatibleSlotterMgr.get(anotherRtVersion);
						}
					}
					slotter.addSlotAssignment(exportJsSlotter.getJsSlotAssignment());
				}
				JsResourceAggregator.aggregate(resource, slotter, exclusion);
			}
		}
	}

	private void aggregateContext(final ResourceCtx context,
		final ResourceSpecCollector specCollector,
		final Set<String> exclusion)
	{
		final Iterator<IComponentSpec> specs = context.componentSpecIterator();
		while (specs.hasNext()) {
			specCollector.aggregate(specs.next());
		}
		JsResourceAggregator.aggregate(specCollector, m_slotter, exclusion);
	}

	public static void aggragateJsForViewSpec(final IViewSpec viewSpec, final JsResourceSlotter slotter) {		
		final Permutation permutation = Permutation.getFromCtx();
		final ResourceSpecCollector specCollector = new ResourceSpecCollector();
		aggregateViewSpec(viewSpec, permutation, specCollector, slotter);
	}

	// if the ViewSpec had been pre-aggregated and/or
	// externalized, return a set of urns for all cached JsResources
	private static Set<String> aggregateViewSpec(
		final IViewSpec viewSpec,
		final Permutation permutation,
		final ResourceSpecCollector specCollector,
		final JsResourceSlotter slotter)
	{
		Set<String> exclusion = null;
		JsResourceCache cache = null;
		if (!ResourceAggregationControl.getInstance().needToEmbedPageJs()) {
			cache = ViewSpecResourceCacheMgr.getInstance().getJsCache(viewSpec);
		}
		if (cache != null && cache.isCached(permutation)) {
			for (String slotName : cache.getJsSlotNames(permutation)) {
				IJsResourceRef ref = cache.getJsRef(permutation, slotName);
				slotter.getSlot(slotName).add(ref);
			}
			return cache.getCachedJsSet(permutation);
		}
		specCollector.aggregate(viewSpec.getComponentSpec());
		JsResourceAggregator.aggregate(specCollector, slotter, exclusion);
		return null;
	}

	public JsResourceSlotter createSlotter() {		
		JsResourceSlotter slotter = new SimpleJsResourceSlotter(false);
		slotter.addSlotAssignment(createAssignment());
		return slotter;
	}
	
	public JsResourceSlotAssignment createAssignment() {
		return new JsResourceSlotAssignment();
	}
	
	protected static void assignJsSlot(
		final JsResourceSlotAssignment assignment, 
		final IComponentSpec rootSpec,
		final String slotName)
	{	
		ResourceSpecCollector specCollector = new ResourceSpecCollector();
		specCollector.aggregate(rootSpec);		
		for (IResourceSpec spec: specCollector) {
			for (IJsResourceRef resource: spec.getClassDefinitions()) {
				if (!assignment.hasAssignment(resource)) {
					assignment.put(resource, slotName);
				}
			}		
			for (IJsResourceRef resource: spec.getExecutingScript()) {
				if (!assignment.hasAssignment(resource)) {
					assignment.put(resource, slotName);
				}
			}			
		}		
	}

	protected static void assignJsSlot(
		final JsResourceSlotAssignment assignment, 
		final String urnPrefix,
		final String slotName)
	{
		assignment.put(urnPrefix, slotName);
	}

	private class IncompatibleJsSlotterMgr {
		private JsResourceSlotter m_nonScopedSlotter = null;

		private Map<String, JsResourceSlotter> m_scopedSlotters = null;

		JsResourceSlotter get(String version) {
			if (version == null) {
				if (m_nonScopedSlotter == null) {
					m_nonScopedSlotter = m_slotter.cloneAnEmptySlotter();
				}
				return m_nonScopedSlotter;
			}
			if (m_scopedSlotters == null) {
				m_scopedSlotters = new HashMap<String, JsResourceSlotter>(2);
			}
			JsResourceSlotter slotter = m_scopedSlotters.get(version);
			if (slotter == null) {
				slotter = m_slotter.cloneAnEmptySlotter();
				slotter.setRuntimeVersion(version);
				m_scopedSlotters.put(version, slotter);
			}
			return slotter;
		}

		void apply(final DDocument doc) {
			if (m_nonScopedSlotter != null) {
				m_applier.apply(doc, m_nonScopedSlotter, !isEmpty());
			}
			if (m_scopedSlotters != null) {
				for (JsResourceSlotter slotter : m_scopedSlotters.values()) {
					m_applier.apply(doc, slotter, !isEmpty());
				}
			}
		}
		
		boolean isEmpty() {
			if (m_scopedSlotters==null) {
				return true;
			}
			return m_scopedSlotters.isEmpty();
		}
	}

}
