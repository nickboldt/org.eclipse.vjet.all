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
package org.eclipse.vjet.dsf.spec.module;

import java.util.List;

import org.eclipse.vjet.dsf.spec.view.IViewSpec;

public interface IModuleSpec {
	String getName();
	String getNameSpace();
	
	
	// Response
	List<IViewSpec> getAllViewSpecs();
	
	// Child modules
	List<IModuleSpec> getChildModules();
}
