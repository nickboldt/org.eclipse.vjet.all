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
package org.eclipse.vjet.dsf.resource.slot.plan;

import java.util.Set;

import org.eclipse.vjet.dsf.resource.slot.ExternalizedSlotGrouping;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotAssignment;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotter;



/**
 * Used for defining a JS and CSS aggregation plan
 */
public interface IResourceAggregationPlan {
	
	
	
	JsResourceSlotAssignment getJsSlotAssignment();
	JsResourceSlotter createJsResourceSlotter();
	
	ExternalizedSlotGrouping getExternalizedJsSlotGrouping();
	
	boolean isJsSystemLibCache();
	boolean isSecureRequestSupported();
	ResourceProcessCtx getResourceProcessCtx();

	Set<String> getJsExclusionResourceUrns();
	Set<String> getCssExclusionResourceUrns();
	
	boolean isForceJsExclusionCheck();
	
	boolean isJsSystemLibVariation();
}
