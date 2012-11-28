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
 * A production plan to aid final DOM production by providing
 * a set of pluggable pieces.
 */
public interface IProductionPlan {
	

	JsResourceSlotter getJsSlotter();
	IProductionPlan setJsSlotter(JsResourceSlotter slotter);
	IJsResourceApplier getJsApplier();
	IProductionPlan setJsApplier(IJsResourceApplier applier);
	
	JsSystemLibCache getJsSystemLibCache();
	IProductionPlan setJsSystemLibCache(JsSystemLibCache jsLibCache);
	
	IDocAnnotationData getDocAnnotation();
	IProductionPlan setDocAnnotation(IDocAnnotationData annotation);
	
	IViewSpec getViewSpec();
	IProductionPlan setViewSpec(IViewSpec viewSpec);
	
	boolean isProcessEventsAndServices();
	IProductionPlan setProcessEventsAndServices(boolean process);

	boolean isProcessDocModifiers();
	IProductionPlan setProcessDocModifiers(boolean process);
	
	IProgRenderData getProgRenderData();
	IProductionPlan setProgRenderData(IProgRenderData data);
}