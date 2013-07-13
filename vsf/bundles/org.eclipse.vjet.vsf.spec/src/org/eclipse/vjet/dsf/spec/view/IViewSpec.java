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


import org.eclipse.vjet.dsf.resource.slot.plan.IResourceAggregationPlan;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;

public interface IViewSpec extends IResourceAggregationPlan {
	String getName();
	IComponentSpec getComponentSpec();
	ISharedViewSpec getSharedViewSpec();
	/**
	 * Specifies if some view spec has resources that contain language specific content
	 * @return
	 */
	boolean hasL10nResources();
}
