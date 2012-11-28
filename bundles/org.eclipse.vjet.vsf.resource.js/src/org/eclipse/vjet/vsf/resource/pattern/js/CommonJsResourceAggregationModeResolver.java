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
package org.eclipse.vjet.vsf.resource.pattern.js;

import org.eclipse.vjet.dsf.resource.x.IResourceAggregationModeResolver;

public class CommonJsResourceAggregationModeResolver implements
		IResourceAggregationModeResolver {
	
	private static final CommonJsResourceAggregationModeResolver s_instance = 
		new CommonJsResourceAggregationModeResolver();
	private CommonJsResourceAggregationModeResolver() {}
	public static CommonJsResourceAggregationModeResolver getInstance() {
		return s_instance;
	}

	protected AggregationMode getForcedAggregationMode() {
		// TODO make this runtime configurable
		return null;
	}
	
	@Override
	public AggregationMode getAggregationMode() {
		AggregationMode mode = getForcedAggregationMode();
		if (mode == null) {
			mode = AggregationMode.BUILDTIME;
		}
		return mode;
	}

}
