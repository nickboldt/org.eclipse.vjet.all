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
package org.eclipse.vjet.vsf.aggregator.cache.js;

import java.util.Set;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.spec.resource.IResourceSpec;
import org.eclipse.vjet.dsf.spec.resource.IResourceSpecs;
import org.eclipse.vjet.dsf.spec.export.IExportJsResource;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotter;
import org.eclipse.vjet.dsf.resource.slot.ScriptType;
import org.eclipse.vjet.dsf.resource.trace.ResourceUsageCtx;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResourceRef;


public class  JsResourceAggregator {
	
	public static void aggregate(
		final IResourceSpecs<? extends IResourceSpec> specs,
		final JsResourceSlotter slotter)
	{
		aggregate(specs, slotter, null);
	}
	
	public static void aggregate(
		final IResourceSpecs<? extends IResourceSpec> specs, 
		final JsResourceSlotter slotter, 
		final Set<String> exclusion)
	{
		if (specs == null) {
			throw new DsfRuntimeException("specs is null");
		}
		for (IResourceSpec spec: specs) {
			aggregate(spec, slotter, exclusion);
		}
	}

	public static void aggregate(
		final IExportJsResource exptResource,
		final JsResourceSlotter slotter)
	{
		if (exptResource == null) {
			throw new DsfRuntimeException("exptResource is null");
		}
		aggregate(exptResource, slotter, null);
	}
	
	public static void aggregate(
		final IExportJsResource exptResource, 
		final JsResourceSlotter slotter,
		final Set<String> exclusion)
	{	
		for (IJsResourceRef resource: exptResource.getClassDefinitions()) {
			if (!shouldExclude(resource, exclusion)) {
				slotter.addToSlot(resource, ScriptType.ClassDefinition);
				
				if(ResourceUsageCtx.ctx().isNeedinlineInfo() 
					&& slotter.getResourceReplacement() != null 
					&& !slotter.getResourceReplacement().contains(resource))
				{
					if(resource instanceof JsResourceRef){
						if(!((JsResourceRef) resource).isTextadapter()){
							ResourceUsageCtx.ctx().setInlinedUrns(resource.getUrn());
						}
					}
				}
				
			}
			
			
		}
		for (IJsResourceRef resource: exptResource.getExecutingScript()) {
			if (!shouldExclude(resource, exclusion)) {
				slotter.addToSlot(resource, ScriptType.ExecutingScript);
				
				if(ResourceUsageCtx.ctx().isNeedinlineInfo() 
					&& slotter.getResourceReplacement() != null 
					&& !slotter.getResourceReplacement().contains(resource) )
				{
					if(!((JsResourceRef) resource).isTextadapter()){
						ResourceUsageCtx.ctx().setInlinedUrns(resource.getUrn());
					}
				}
				
			}
			
		}
	}


	private static boolean shouldExclude(
		final IJsResourceRef resource, final Set<String> exclusion)
	{
		if (exclusion == null) {
			return false;
		}
		return exclusion.contains(resource.getUrn());
	}
}
