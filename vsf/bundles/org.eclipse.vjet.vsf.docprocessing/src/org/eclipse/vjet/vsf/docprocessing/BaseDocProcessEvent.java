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

import java.util.EventObject;

import org.eclipse.vjet.dsf.dom.DDocument;



public abstract class BaseDocProcessEvent extends EventObject {
	
	private DDocument m_doc;
	
	public BaseDocProcessEvent(final BaseDocProcessor processor, final DDocument doc) {
		super(processor);
		m_doc = doc;
	}

	public abstract void dispatch(IDocProcessEventListener listener);

	public DDocument getDoc() {
		return m_doc;
	}
	
	public BaseDocProcessor getSource(){
		return (BaseDocProcessor)super.getSource();
	}
}
