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
package org.eclipse.vjet.dsf.spec.export;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.vjet.dsf.common.container.DsfNodeInstantiationException;
import org.eclipse.vjet.dsf.common.container.IDsfNodeInstantiationValidator;
import org.eclipse.vjet.dsf.dom.DNode;

/**
 * An instance of this class can be registered with DsfContainer to 
 * detect any newly instantiated IDsfComponent which had implemented
 * IExportJsResource.
 * 
 * It can be used to quickly retrieve those instance or simply for
 * detecting the existence of IExportJsResource.
 */
public class JsExportableCompCollector 	implements IDsfNodeInstantiationValidator {

	private List<IExportJsResource> m_resources = null;
	
	public void validate(final DNode component) 
		throws DsfNodeInstantiationException
	{
		if (component instanceof IExportJsResource) {
			getList().add((IExportJsResource)component);
		}
	}
	
	public boolean hasExportedResource() {
		if (m_resources == null) {
			return false;
		}
		return m_resources.size() > 0;
	}
	
	public List<IExportJsResource> getExportedResources() {
		return m_resources;
	}
	
	private List<IExportJsResource> getList() {
		if (m_resources == null) {
			m_resources = new ArrayList<IExportJsResource>(2);
		}
		return m_resources;
	}

}
