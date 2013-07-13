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
//package org.eclipse.vjet.dsf.spec.app;
//
//import org.eclipse.vjet.kernel.initialization.BaseInitializable;
//import org.eclipse.vjet.kernel.initialization.InitializationContext;
//
//public class DefaultAppSpecInitializable extends BaseInitializable {
//	private IAppSpec m_appSpec ;
//	
//	public DefaultAppSpecInitializable(final IAppSpec appSpec) {
//		m_appSpec = appSpec ;
//	}
//	
//	protected void initialize(final InitializationContext context) {
//		m_appSpec.touchAll();
//	}
//
//	protected void shutdown(final InitializationContext context) {
//		// Empty on purpose - override if needed
//	}
//	
//	protected IAppSpec getAppSpec() {
//		return m_appSpec ;
//	}
//}