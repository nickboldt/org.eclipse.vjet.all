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
package org.eclipse.vjet.dsf.spec.resource;

import java.util.Locale;
import java.util.Set;

import org.eclipse.vjet.dsf.spec.export.IExportJsResource;

public interface IResourceSpec extends IExportJsResource {
	 IResourceSpecs<? extends IResourceSpec> getDependentSpecs();
     
//     IJsResourceRef onFlyJsRef(JsResource resource, JsType type);
// 
     IResourceSpecs<? extends IResourceSpec> getExclusionDependentSpec(Locale locale);
     
     IResourceSpecs<? extends IResourceSpec> getInclusionDependentSpec(Locale locale);
     
     Set<String> getLocales();
}
