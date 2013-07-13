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
package org.eclipse.vjet.dsf.resource.x;

import org.eclipse.vjet.dsf.resource.permutation.Permutation;



// MrP - From CommonRuntime
/**
 * Defines url fixer that modifies URL.
 * This is currently only used to modify placeholder url in eBay content  
 */
public interface IUrlFixer {
	String fixUrl(String url, final Permutation permutationCtx, boolean secure);
}
