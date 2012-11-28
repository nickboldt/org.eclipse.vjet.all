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
package org.eclipse.vjet.vsf.aggregator.cache;

import org.eclipse.vjet.dsf.resource.permutation.Permutation;
import org.eclipse.vjet.dsf.spec.app.IAppSpec;
import org.eclipse.vjet.dsf.spec.view.IViewSpec;

public interface IExternalizationPath {
	String getRelativePath(Permutation permutation, IAppSpec appSpec, IViewSpec viewSpec);
	String getRelativePath(Permutation permutation, IAppSpec appSpec, IViewSpec viewSpec, String index);
	String getRelativePath(IAppSpec appSpec, IViewSpec viewSpec);
	String getRelativePath(IAppSpec appSpec, IViewSpec viewSpec, String index);
	String getRelativePath(Permutation permutation, String subPath);
	String getRelativePath(IAppSpec appSpec, String index);  // app js opt
	String getRelativePath(Permutation permutation, IAppSpec appSpec, String index); // app js opt
}
