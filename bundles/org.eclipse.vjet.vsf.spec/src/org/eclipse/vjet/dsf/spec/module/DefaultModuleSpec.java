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
package org.eclipse.vjet.dsf.spec.module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.vjet.dsf.common.exceptions.DsfExceptionHelper;
import org.eclipse.vjet.dsf.spec.view.DefaultViewSpec;
import org.eclipse.vjet.dsf.spec.view.IViewSpec;

public class DefaultModuleSpec implements IModuleSpec {

	// Name
	private final String m_name;
	
	// NameSpace
	private String m_nameSpace;
	
	
	// Views
	private List<IViewSpec> m_viewSpecs = 
		new ArrayList<IViewSpec>(1);
	
	// Children
	private List<IModuleSpec> m_childModules;
	
	private volatile boolean m_initialized = false;
	
	//
	// Constructor
	//
	public DefaultModuleSpec(final String name){
		if (name == null){
			DsfExceptionHelper.chuck("name is null");
		}
		m_name = name;
	}
	
	public DefaultModuleSpec(final String name, final String nameSpace){
		this(name);
		m_nameSpace = nameSpace;
	}

	//
	// Satisfy IModuleSpec
	//
	public String getName(){
		return m_name;
	}
	
	public String getNameSpace(){
		return m_nameSpace;
	}
	

	

	
	public List<IViewSpec> getAllViewSpecs(){
		initialize();
		if (m_viewSpecs == null){
			return Collections.emptyList();
		}
		return Collections.unmodifiableList(m_viewSpecs);
	}
	
	public List<IModuleSpec> getChildModules(){
		initialize();
		if (m_childModules == null){
			return Collections.emptyList();
		}
		return Collections.unmodifiableList(m_childModules);
	}
	

	
	protected IModuleSpec addViewSpec(final IViewSpec respSpec) {
		m_viewSpecs.add(respSpec);
		return this;
	}
	
	protected IModuleSpec addChildModule(final IModuleSpec moduleSpec) {
		if (m_childModules == null){
			m_childModules = new ArrayList<IModuleSpec>(1);
		}
		m_childModules.add(moduleSpec);
		return this;
	}
	
	public DefaultViewSpec createViewSpec(final String name) {
		DefaultViewSpec viewSpec = new DefaultViewSpec(name);
		addViewSpec(viewSpec);
		return viewSpec;
	}

	protected void initialize(){
		if (m_initialized){
			return;
		}
		synchronized(this) {
			if (m_initialized){
				return;
			}			
	
		
			try {
				Class.forName(this.getClass().getName() + "$ViewSpecs");
			} 
			catch (ClassNotFoundException e) {
				// No-op
			}
			m_initialized = true;
	     }
	}
}
