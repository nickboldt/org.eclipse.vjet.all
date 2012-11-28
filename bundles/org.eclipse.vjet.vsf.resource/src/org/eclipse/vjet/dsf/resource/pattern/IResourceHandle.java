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
 * 
 * Tag interface for all resource handle types. 
 * Since ResourceRef object can't represent a specific state of the resources 
 * based on the permutation or timing of access, ResourceHandle becomes 
 * the abstraction for Resource Client to access specific resource data 
 * for a given permutation at runtime.
 *
 */
public interface IResourceHandle {
}
