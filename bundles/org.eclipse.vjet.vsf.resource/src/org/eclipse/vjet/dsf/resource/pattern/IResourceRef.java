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
package org.eclipse.vjet.dsf.resource.pattern;

/**
 * Marks all resource reference types. Only of interest if you are
 * implementing a new resource type.
 *
 */
public interface IResourceRef {
	/**
	 * Answer the Uniform Resource Name (URN) for this instance.  The framework
	 * will generally use this name in Slotting and other resource registries.
	 */
	String getUrn();
}
