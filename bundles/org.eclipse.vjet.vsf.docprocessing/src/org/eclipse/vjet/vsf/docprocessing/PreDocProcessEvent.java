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

import org.eclipse.vjet.dsf.dom.DDocument;

public class PreDocProcessEvent extends BaseDocProcessEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PreDocProcessEvent(final BaseDocProcessor processor, final DDocument doc) {
		super(processor, doc);
	}

	@Override
	public void dispatch(final IDocProcessEventListener listener) {
		listener.beforeDocProcess(this);
	}
}
