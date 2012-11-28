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

import org.eclipse.vjet.dsf.dom.DDocument;
import org.eclipse.vjet.dsf.html.dom.DHtmlDocument;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotAssignment;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotter;
import org.eclipse.vjet.dsf.resource.slot.simple.JsSlotBaseName;
import org.eclipse.vjet.dsf.resource.slot.simple.SimpleJsResourceSlotter;
import org.eclipse.vjet.dsf.spec.view.IViewSpec;
import org.eclipse.vjet.vjo.bootstrap.VjBootstrap;
import org.eclipse.vjet.vsf.EventDispatcherJsr;
import org.eclipse.vjet.vsf.FirePageLoadJsr;
import org.eclipse.vjet.vsf.ServiceEngineJsr;
import org.eclipse.vjet.vsf.aggregator.cache.JsSystemLibCache;
import org.eclipse.vjet.vsf.aggregator.event.export.EventDispatcherAssembler;
import org.eclipse.vjet.vsf.aggregator.event.export.IEventDispatcherAssembler;
import org.eclipse.vjet.vsf.assembly.VjClientAssemblerJsr;
import org.eclipse.vjet.vsf.docprocessing.IJsResourceApplier;
import org.eclipse.vjet.vsf.error.DefaultErrorHandlerJsr;
import org.eclipse.vjet.vsf.error.ErrorHandlerManagerJsr;

import vjo.RegistryJsr;

/**
 * Simple JS processor to collect slotted js for a page
 */
public class JsProcessor extends BaseJsProcessor {
	
	private IEventDispatcherAssembler m_evtDispatcherAssembler 
		= EventDispatcherAssembler.getInstance();


	private boolean m_processEventsAndServices = true;  //keeping previous behavior as default
	
	public JsProcessor() {
		super();
	}

	public JsProcessor(final JsResourceSlotter slotter,
		final IJsResourceApplier applier, final JsSystemLibCache libCache)
	{
		this(slotter, applier, libCache, true); //keeping previous behavior as default
	}

	public JsProcessor(final JsResourceSlotter slotter,
			final IJsResourceApplier applier, final JsSystemLibCache libCache, final boolean processEventsAndServices)
		{
			super(slotter, applier, libCache, processEventsAndServices);
			m_processEventsAndServices = processEventsAndServices;
		}

	//
	// API
	//
	
	public IEventDispatcherAssembler getEvtDispatcherAssembler() {
		return m_evtDispatcherAssembler;
	}

	public void setEvtDispatcherAssembler(
			final IEventDispatcherAssembler dispatcherAssembler) {
		m_evtDispatcherAssembler = dispatcherAssembler;
	}
	
	@Override
	public JsResourceSlotAssignment createAssignment() {
		return createDefaultAssignment();
	}
	
	public static JsResourceSlotAssignment createDefaultAssignment() {
		JsResourceSlotAssignment assignment = new JsResourceSlotAssignment();
		assignJsSlot(assignment, VjBootstrap.ResourceSpec.getInstance(),
				JsSlotBaseName.BEFORE_ANY_HTML_RENDER);
		assignJsSlot(assignment, DefaultErrorHandlerJsr.ResourceSpec.getInstance(),
				JsSlotBaseName.BEFORE_ANY_HTML_RENDER);
		assignJsSlot(assignment, ErrorHandlerManagerJsr.ResourceSpec.getInstance(),
				JsSlotBaseName.BEFORE_ANY_HTML_RENDER);
		assignJsSlot(assignment, JsProcessorUtils.ERROR_HANDLER_PREFIX,
				JsSlotBaseName.BEFORE_ANY_HTML_RENDER);
		assignJsSlot(assignment, EventDispatcherJsr.ResourceSpec.getInstance(),
				JsSlotBaseName.BEFORE_ANY_HTML_RENDER);
		assignJsSlot(assignment, RegistryJsr.ResourceSpec.getInstance(),
				JsSlotBaseName.BEFORE_ANY_HTML_RENDER);
		assignJsSlot(assignment, ServiceEngineJsr.ResourceSpec.getInstance(),
				JsSlotBaseName.BEFORE_ANY_HTML_RENDER);
		assignJsSlot(assignment, VjClientAssemblerJsr.ResourceSpec.getInstance(),
				JsSlotBaseName.BEFORE_ANY_HTML_RENDER);
		assignJsSlot(assignment, FirePageLoadJsr.ResourceSpec.getInstance(),
				JsSlotBaseName.AFTER_ANY_HTML_RENDER);
		return assignment;
	}
	
	public static JsResourceSlotter createDefaultSlotter() {		
		JsResourceSlotter slotter = new SimpleJsResourceSlotter(false);
		slotter.addSlotAssignment(createDefaultAssignment());
		return slotter;
	}
	
	public static IJsResourceApplier createDefaultApplier() {
		return new JsResourceApplier();
	}
	
	@Override
	protected void aggragateJs(final DDocument doc, final IViewSpec viewSpec) {
		super.aggragateJs(doc, viewSpec);
		if(m_processEventsAndServices){
			processEvents((DHtmlDocument)doc);
		
		}
	}

	private void processEvents(final DHtmlDocument doc) {
		m_evtDispatcherAssembler.processEventHandling(doc.getBody(), m_slotter);
	}

	
}
