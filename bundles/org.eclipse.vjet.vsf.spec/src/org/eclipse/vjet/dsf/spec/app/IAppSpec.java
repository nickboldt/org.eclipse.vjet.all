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
import java.util.Set;

import org.eclipse.vjet.dsf.spec.module.IModuleSpec;
import org.eclipse.vjet.dsf.spec.view.IViewSpec;

/**
 * The central point to get all specs defined for an application, including
 * state and modules specs. From state spec, you can get all module spec for
 * that state. From module spec, you can get all request specs and view specs
 * for that module.
 */
public interface IAppSpec {
	/**
	 * Option provided when adding modules to a state. It provides info to
	 * static processors, but it's up to application code to enforce 
	 * it in runtime.
	 */
	public enum Option {
		IN_ONLY, OUT_ONLY, IN_OUT
	}
	
	/**
	 * Answer the name of the spec. Must not be null or empty.
	 * @return String
	 */
	String getName();
	
	/**
	 * Answer an copied list of all state configs in this app.
	 * Returns empty list if there's none.
	 * @return List<IStateSpec>
	 */
	List<IStateSpec> getAllStateSpecs();
	
	/**
	 * Answer the stateSpec in this app with given name. Returns null if
	 * name is null or stateSpec is not found.
	 * @param name String
	 * @return IStateSpec
	 */
	IStateSpec getStateSpec(String name);
	
	
	/**
	 * Answer a copied list of module specs in this app with given option.
	 * Returns empty list if there's none or option is null.
	 * @return List<IModuleSpec>
	 */
	List<IModuleSpec> getModuleSpecs(Option option);
	
	/**
	 * Answer a copied list of all view specs in this app.
	 * Returns empty list if there's none.
	 * @return List<IViewSpec>
	 */
	List<IViewSpec> getAllViewSpecs();
	
	/**
	 * Force initialization of all directly or indirectly associated specs
	 */
	void touchAll();
	
	/**
	 * Answer a copied list of all inbound module specs in this app.
	 * Returns empty list if there's none.
	 * @return List<IModuleSpec>
	 */
	List<IModuleSpec> getAllInboundModuleSpecs();
	
	/**
	 * Answer a copied list of all outbound module specs in this app.
	 * Returns empty list if there's none.
	 * @return List<IModuleSpec>
	 */
	List<IModuleSpec> getAllOutboundModuleSpecs();
	
	/**
	 * Answer a copied list of all module specs in this app.
	 * Returns empty list if there's none.
	 * @return List<IModuleSpec>
	 */
	List<IModuleSpec> getAllModuleSpecs();
	
	/**
	 * A temp solution for marking a support of non-versioned
	 * js/css resource externalization
	 */
	boolean isSupportNonversionedResourceExternalization();
	
	/**
	 * A temp solution for marking a support of runtime system
	 * js lib inclusion for the page js externalization
	 */
	boolean isIncludeJsRuntimeIntoPageJs();
	
	/*
	 *  Indicate if we want js packaging optimization in this app.
	 */
	boolean isJsPkgOptimization();
	
	/*
	 *  Indicate js optimization slot name.
	 */
	String getOptSlot();

	/*
	 *  Indicate js optimization common slot name.
	 */
	String getOptCommonSlot();
	
	/*
	 *  Indicate js optimization key view.
	 */
	String getOptKeyView();
	
	/*
	 *  Indicate js optimization common view numbers.
	 */
	int getOptCommonFactor();
	
	/*
	 *  Indicate a set of views which do not want to be included in common js optimization.
	 */
	public Set<IViewSpec> getOptViewsExclude();
	
	/*
	 *  Clear JsCache
	 */
	void clearJsCache();
	
	/**
	 * Indicate js optimization version.
	 * version 1 is default
	 * @return version
	 */
	int getOptVersion();
}
