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
package org.eclipse.vjet.dsf.resource.x;

/**
 * This interface defines a resolver to control resource aggregation modes. The default resource aggregation based
 * on build time AppSpec/ViewSpec externalization. The new flow is to aggregate resources based on fragments deployed 
 * to resource repository 
 */
public interface IResourceAggregationModeResolver {

	// this will be handled with two PCs
	public enum AggregationMode {
		BUILDTIME,  	// resource aggregation goes old way with include/assets pools (PC.active==OFF && PC.transition==OFF)
		VALIDATION, // resource aggregation still goes old way but some validation is allowed (PC.active==OFF && PC.transition==ON)
		TRANSITION,	// resource aggregation new way with validation is allowed and fallback to old way in case of error  (PC.active==ON && PC.transition=ON)
		RUNTIME,		// new aggregation logic is active (PC.active==ON && PC.transition=OFF)
		DYNAMIC		// resource server base aggregation includes aggregation rules
	}

	/**
	 * Returns mode that resource aggregation is in. 
	 * @return
	 */
	AggregationMode getAggregationMode();
	
	public static class DefaultResourceAggregationModeResolver implements IResourceAggregationModeResolver {

		private static final DefaultResourceAggregationModeResolver s_instance = 
			new DefaultResourceAggregationModeResolver();
		
		private DefaultResourceAggregationModeResolver() {}
		
		public static DefaultResourceAggregationModeResolver getInstance() {
			return s_instance;
		}
		
		@Override
		public AggregationMode getAggregationMode() {
			return AggregationMode.BUILDTIME;
		}
		
	}
}
