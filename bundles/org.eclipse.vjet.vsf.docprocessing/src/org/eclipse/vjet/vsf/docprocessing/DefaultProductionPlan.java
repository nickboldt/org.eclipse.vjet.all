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
package org.eclipse.vjet.vsf.docprocessing;


import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotter;
import org.eclipse.vjet.dsf.spec.app.IDocAnnotationData;
import org.eclipse.vjet.dsf.spec.view.IViewSpec;
import org.eclipse.vjet.vsf.aggregator.cache.JsSystemLibCache;

/**
 * A default implementation of an IProductionPlan
 */
public class DefaultProductionPlan implements IProductionPlan {


	private JsResourceSlotter m_jsSlotter;
	private IJsResourceApplier m_jsApplier;
	private JsSystemLibCache m_jsSystemLibCache;
	private IDocAnnotationData m_docAnnotation;
	private IViewSpec m_viewSpec;
	private boolean m_processEventsAndServices = true; //Keep default as true
	private boolean m_processDocModifiers = true;//Keep default as true
	private IProgRenderData m_progRenderData;
	
	public JsResourceSlotter getJsSlotter() {
		return m_jsSlotter;
	}
	
	public IProductionPlan setJsSlotter(final JsResourceSlotter slotter) {
		m_jsSlotter = slotter;
		return this;
	}
	
	public IJsResourceApplier getJsApplier() {
		return m_jsApplier;
	}
	
	public IProductionPlan setJsApplier(final IJsResourceApplier applier) {
		m_jsApplier = applier;
		return this;
	}

	public JsSystemLibCache getJsSystemLibCache() {
		return m_jsSystemLibCache;
	}

	public IProductionPlan setJsSystemLibCache(final JsSystemLibCache jsLibCache) {
		m_jsSystemLibCache = jsLibCache;
		return this;
	}
	
	public IDocAnnotationData getDocAnnotation() {
		return m_docAnnotation;
	}

	public IProductionPlan setDocAnnotation(final IDocAnnotationData annotation) {
		m_docAnnotation = annotation;
		return this;
	}

	public IViewSpec getViewSpec() {
		return m_viewSpec;
	}

	public IProductionPlan setViewSpec(final IViewSpec viewSpec) {
		m_viewSpec = viewSpec;
		if (m_viewSpec != null) {
			if (getJsSlotter() == null) {
				setJsSlotter(m_viewSpec.createJsResourceSlotter());
			}
		}
		return this;
	}

	public boolean isProcessDocModifiers() {
		return m_processDocModifiers;
	}

	public boolean isProcessEventsAndServices() {
		return m_processEventsAndServices;
	}

	public IProductionPlan setProcessEventsAndServices(boolean mProcessEventsAndServices) {
		m_processEventsAndServices = mProcessEventsAndServices;
		return this;
	}

	public IProductionPlan setProcessDocModifiers(boolean mProcessDocModifiers) {
		m_processDocModifiers = mProcessDocModifiers;
		return this;
	}

	@Override
	public IProgRenderData getProgRenderData() {
		return m_progRenderData;
	}

	@Override
	public IProductionPlan setProgRenderData(IProgRenderData data) {
		m_progRenderData = data;
		return this;
	}

}
