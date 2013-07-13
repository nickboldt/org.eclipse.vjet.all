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
package org.eclipse.vjet.vsf.aggregator.js.event;



import org.eclipse.vjet.dsf.spec.component.BaseJsComponentSpec;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.vsf.EventDispatcherJsr;
import org.eclipse.vjet.vsf.EventJsr;
import org.eclipse.vjet.vsf.MessageJsr;
import org.eclipse.vjet.vsf.SvcConfigJsr;

public class EventDispatcherCompSpec extends BaseJsComponentSpec {


	private static final IComponentSpec s_instance = new EventDispatcherCompSpec()
	.addDependentComponent(EventJsr.ResourceSpec.getInstance())
		.addDependentComponent(SvcConfigJsr.ResourceSpec.getInstance())
		.addDependentComponent(MessageJsr.ResourceSpec.getInstance())
		.addDependentComponent(EventDispatcherJsr.ResourceSpec.getInstance());
	
	public static IComponentSpec getInstance() {
		return s_instance;
	}
}
