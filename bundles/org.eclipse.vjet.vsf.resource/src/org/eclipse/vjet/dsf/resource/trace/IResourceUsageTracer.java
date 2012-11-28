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
package org.eclipse.vjet.dsf.resource.trace;

import org.eclipse.vjet.dsf.resource.pattern.IResourceRef;

/**
 * A simple interface for resource ref to report its usage
 */
public interface IResourceUsageTracer {
	
	/**
	 * Records usage of a resource.
	 * 
	 * @param resource	the resource being used
	 */
	void accessed(IResourceRef resource);
	
	IResourceUsageTracer NULL_TRACER = new IResourceUsageTracer() {
		public void accessed(IResourceRef resource) {
		}
	};
}
