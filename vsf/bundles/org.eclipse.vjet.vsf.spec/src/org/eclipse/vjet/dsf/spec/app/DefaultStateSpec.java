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
package org.eclipse.vjet.dsf.spec.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.vjet.dsf.common.exceptions.DsfExceptionHelper;
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.spec.app.IAppSpec.Option;
import org.eclipse.vjet.dsf.spec.module.IModuleSpec;
import org.eclipse.vjet.dsf.spec.view.IViewSpec;

/**
 * Default implementation of IStateSpec
 */
public class DefaultStateSpec implements IStateSpec {
	
	private final String m_name;
	private final Map<Option,List<IModuleSpec>> m_modules = 
		new HashMap<Option,List<IModuleSpec>>(3);
	
	//
	// Constructor
	//
	/**
	 * Constructor. name is required.
	 * @param stateId StateId
	 * @exception DsfRuntimeException if stateId is null.
	 */
	public DefaultStateSpec(final String name){
		if (name == null){
			DsfExceptionHelper.chuck("stateId is null");
		}
		m_name = name;
		m_modules.put(Option.IN_ONLY, new ArrayList<IModuleSpec>(1));
		m_modules.put(Option.OUT_ONLY, new ArrayList<IModuleSpec>(1));
		m_modules.put(Option.IN_OUT, new ArrayList<IModuleSpec>(1));
	}
	
	//
	// Satisfying IStateSpec
	//
	/**
	 * @see org.eclipse.vjet.dsf.spec.app.IStateSpec
	 */
	public String getName(){
		return m_name;
	}
	
	/**
	 * @see org.eclipse.vjet.dsf.spec.app.IStateSpec
	 */
	public List<IModuleSpec> getAllInboundModuleSpecs(){
		
		final List<IModuleSpec> ilist = m_modules.get(Option.IN_ONLY);
		final List<IModuleSpec> iolist = m_modules.get(Option.IN_OUT);
		final List<IModuleSpec> allList 
			= new ArrayList<IModuleSpec>(ilist.size() + iolist.size());
		allList.addAll(ilist);
		allList.addAll(iolist);
		
		return allList;
	}
	
	/**
	 * @see org.eclipse.vjet.dsf.spec.app.IStateSpec
	 */
	public List<IModuleSpec> getAllOutboundModuleSpecs(){
		
		final List<IModuleSpec> olist = m_modules.get(Option.OUT_ONLY);
		final List<IModuleSpec> iolist = m_modules.get(Option.IN_OUT);
		final List<IModuleSpec> allList 
			= new ArrayList<IModuleSpec>(olist.size() + iolist.size());
		allList.addAll(olist);
		allList.addAll(iolist);
		
		return allList;
	}
	
	/**
	 * @see org.eclipse.vjet.dsf.spec.app.IStateSpec
	 */
	public List<IModuleSpec> getModuleSpecs(final Option option){
		if (option == null || m_modules.get(option).size() == 0){
			return Collections.emptyList();
		}

		return new ArrayList<IModuleSpec>(m_modules.get(option));
	}
	
	/**
	 * @see org.eclipse.vjet.dsf.spec.app.IStateSpec
	 */
	public List<IModuleSpec> getAllModuleSpecs(){	
		final List<IModuleSpec> ilist = m_modules.get(Option.IN_ONLY);
		final List<IModuleSpec> olist = m_modules.get(Option.OUT_ONLY);
		final List<IModuleSpec> iolist = m_modules.get(Option.IN_OUT);
		final List<IModuleSpec> allList 
			= new ArrayList<IModuleSpec>(ilist.size() + olist.size() + iolist.size());
		allList.addAll(ilist);
		allList.addAll(olist);
		allList.addAll(iolist);
		
		return allList;
	}
	
	/**
	 * @see org.eclipse.vjet.dsf.spec.app.IStateSpec
	 */
	public List<IViewSpec> getAllViewSpecs(){
		final List<IModuleSpec> modules = getModuleSpecs(Option.OUT_ONLY);
		if (modules == null || modules.isEmpty()){
			return Collections.emptyList();
		}
		
		final List<IViewSpec> views = new ArrayList<IViewSpec>(modules.size());
		final Iterator<IModuleSpec> itr = modules.iterator();
		while (itr.hasNext()){
			views.addAll(itr.next().getAllViewSpecs());
		}
		
		return views;
	}
	
	//
	// API
	//
	/**
	 * Add a module spec to this state with given option.
	 * @param moduleSpec IModuleSpec
	 * @param option Option
	 * @return DefaultStateSpec 
	 */
	public DefaultStateSpec add(
		final IModuleSpec moduleSpec, final Option option)
	{
		if (moduleSpec == null){
			DsfExceptionHelper.chuck("moduleSpec is null");
		}
		
		if (option == null){
			DsfExceptionHelper.chuck("option is null");
		}
		
		m_modules.get(option).add(moduleSpec);
		return this;
	}
}
