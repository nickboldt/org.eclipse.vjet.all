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
package org.eclipse.vjet.vsf.jsruntime.optimizer;

import org.eclipse.vjet.dsf.common.exceptions.DsfException;


public interface IJsOptimizer<T> {
	void compare(T obj) throws DsfException;
	String createDef(String functionName);
	String createCall(T obj);
}
