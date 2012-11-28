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
package org.eclipse.vjet.vsf.docprocessing;

/**
 * This is a system level extension mechanism. Make sure not to include app logic here,
 * and deal with exception in each listener. System will only log the exception if catched any, 
 * without blocking the doc processing flow.
 * @author yuge
 *
 */
public interface IDocProcessEventListener {
	boolean isActive();
	void beforeDocProcess(PreDocProcessEvent event);
	void afterDocProcess(PostDocProcessEvent event);
}
