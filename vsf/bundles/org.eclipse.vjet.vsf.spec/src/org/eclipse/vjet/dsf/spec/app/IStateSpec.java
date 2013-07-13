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
package org.eclipse.vjet.dsf.spec.app;

import java.util.List;

import org.eclipse.vjet.dsf.spec.app.IAppSpec.Option;
import org.eclipse.vjet.dsf.spec.module.IModuleSpec;
import org.eclipse.vjet.dsf.spec.view.IViewSpec;

public interface IStateSpec {
	/**
	 * Answer the name of the spec
	 * @return String
	 */
	String getName();
	
	/**
	 * Answer a copied list of all module specs in this state with the specific option.
	 * Returns empty list if there's none or option is null.
	 * IN_ONLY, OUT_ONLY, IN_OUT
	 * Note that asking for Option.IN_OUT will not return a Module that has
	 * Option.IN_ONLY - same goes for Option.IN_OUT and Option.OUT_ONLY.
	 * @return List<IModuleSpec>
	 */
	List<IModuleSpec> getModuleSpecs(Option option);
	
	/**
	 * Answer a copied list of all view specs in the state.
	 * Returns empty list if there's none.
	 * @return List<IViewSpec>
	 */
	List<IViewSpec> getAllViewSpecs();
	
	/**
	 * Answer a copied list of all inbound module specs in the state.
	 * Returns empty list if there's none.
	 * @return List<IModuleSpec>
	 */
	List<IModuleSpec> getAllInboundModuleSpecs();
	
	/**
	 * Answer a copied list of all outbound module specs in the state.
	 * Returns empty list if there's none.
	 * @return List<IModuleSpec>
	 */
	List<IModuleSpec> getAllOutboundModuleSpecs();
	
	/**
	 * Answer a copied list of all module specs in the state.
	 * Returns empty list if there's none.
	 * This means any ModuleSpec and thus could include a mix of Option.IN_ONLY,
	 * Option.OUT_ONLY and Option.IN_OUT.
	 * @return List<IModuleSpec>
	 */
	List<IModuleSpec> getAllModuleSpecs();

}
