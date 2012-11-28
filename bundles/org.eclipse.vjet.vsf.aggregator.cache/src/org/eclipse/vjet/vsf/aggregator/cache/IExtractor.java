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
/**
 * 
 */
package org.eclipse.vjet.vsf.aggregator.cache;

import java.util.Map;

import org.eclipse.vjet.dsf.resource.permutation.Permutation;
import org.eclipse.vjet.dsf.resource.persist.ResourcePersistanceException;
import org.eclipse.vjet.dsf.resource.slot.ResourceSlotter;
import org.eclipse.vjet.dsf.spec.app.IAppSpec;
import org.eclipse.vjet.dsf.spec.view.IViewSpec;
import org.eclipse.vjet.vsf.aggregator.cache.meta.IExternalizationInfo;

public interface IExtractor<SLOTTER extends ResourceSlotter<?>, EXT_INFO extends IExternalizationInfo> {
	
	/**
	 * Performs extraction
	 * @param info
	 * @param appSpec
	 * @param viewSpec
	 * @param slotsToExtract
	 * @throws ResourcePersistanceException
	 */
	void extract(EXT_INFO info,
			final IAppSpec appSpec, 
			final IViewSpec viewSpec,
			final Map<Permutation, SLOTTER> slotsToExtract) throws ResourcePersistanceException;
}