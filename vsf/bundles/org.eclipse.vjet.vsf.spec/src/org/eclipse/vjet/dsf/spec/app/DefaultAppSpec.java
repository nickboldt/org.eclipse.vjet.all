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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.vjet.dsf.common.exceptions.DsfExceptionHelper;
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.spec.module.IModuleSpec;
import org.eclipse.vjet.dsf.spec.view.IViewSpec;

/**
 * Default implementation of IAppSpec
 */
public class DefaultAppSpec implements IAppSpec {
	
	private String m_name;
	private final Map<String,IStateSpec> m_states = new LinkedHashMap<String,IStateSpec>(6);
	private boolean m_initialized = false;
	private boolean m_supportNonversionedResourceExternalization = false;
	private boolean m_includeJsRuntimeIntoPageJs = false;
	
	private boolean m_jsPkgOptimization = false;
	private String m_optSlot = null;
	private String m_optCommonSlot = null;
	private String m_optKeyView = null;
	private int m_optVersion = 1;
	private int m_optCommonFactor = 10;
	private Set<IViewSpec> m_optViewsExclude = null;
	
	//
	// Constructor
	//
	/**
	 * Constructor. appName is required.
	 * @param appName String
	 * @exception DsfRuntimeException if appName is null or empty.
	 */
	public DefaultAppSpec(final String name){
		if (name == null || name.trim().length() == 0){
			DsfExceptionHelper.chuck("name is null or empty");
		}
		m_name = name;
	}
	
	//
	// Satisfying IAppSpec
	//
	/**
	 * @see org.eclipse.vjet.dsf.spec.app.IAppSpec
	 */
	public String getName(){
		return m_name;
	}
	
	/**
	 * @see org.eclipse.vjet.dsf.spec.app.IAppSpec
	 */
	public List<IStateSpec> getAllStateSpecs(){
		initialize();
		return new ArrayList<IStateSpec>(m_states.values());
	}
	
	/**
	 * @see org.eclipse.vjet.dsf.spec.app.IAppSpec
	 */
	public IStateSpec getStateSpec(final String name){
		initialize();
		return m_states.get(name);
	}
	
	/**
	 * @see org.eclipse.vjet.dsf.spec.app.IAppSpec
	 */
	public List<IModuleSpec> getAllInboundModuleSpecs(){
		
		initialize();
		
		if (m_states.isEmpty()){
			return Collections.emptyList();
		}
		
		final ArrayList<IModuleSpec> list = new ArrayList<IModuleSpec>(6);
		final Iterator<IStateSpec> itr = m_states.values().iterator();
		while (itr.hasNext()){
			list.addAll(itr.next().getAllInboundModuleSpecs());
		}

		return list;
	}
	
	/**
	 * @see org.eclipse.vjet.dsf.spec.app.IAppSpec
	 */
	public List<IModuleSpec> getAllOutboundModuleSpecs(){
		
		initialize();
		
		if (m_states.isEmpty()){
			return Collections.emptyList();
		}
		
		final ArrayList<IModuleSpec> list = new ArrayList<IModuleSpec>(6);
		final Iterator<IStateSpec> itr = m_states.values().iterator();
		while (itr.hasNext()){
			list.addAll(itr.next().getAllOutboundModuleSpecs());
		}

		return list;
	}
	
	/**
	 * @see org.eclipse.vjet.dsf.spec.app.IAppSpec
	 */
	public List<IModuleSpec> getAllModuleSpecs(){
		initialize();
		
		if (m_states.isEmpty()){
			return Collections.emptyList();
		}
		
		final ArrayList<IModuleSpec> list = new ArrayList<IModuleSpec>(6);
		final Iterator<IStateSpec> itr = m_states.values().iterator();
		while (itr.hasNext()){
			list.addAll(itr.next().getAllModuleSpecs());
		}

		return list;
	}
	
	/**
	 * @see org.eclipse.vjet.dsf.spec.app.IAppSpec
	 */
	public List<IModuleSpec> getModuleSpecs(final Option option){
		initialize();
		
		if (m_states.isEmpty()){
			return Collections.emptyList();
		}
		
		final ArrayList<IModuleSpec> list = new ArrayList<IModuleSpec>(6);
		final Iterator<IStateSpec> itr = m_states.values().iterator();
		while (itr.hasNext()){
			list.addAll(itr.next().getModuleSpecs(option));
		}

		return list;
	}
	
	/**
	 * @see org.eclipse.vjet.dsf.spec.app.IAppSpec
	 */
	public List<IViewSpec> getAllViewSpecs(){
		
		initialize();
		
		final List<IModuleSpec> modules = getAllOutboundModuleSpecs();
		if (modules == null){
			return Collections.emptyList();
		}
		
		List<IViewSpec> views = new ArrayList<IViewSpec>(modules.size());
		Iterator<IModuleSpec> itr = modules.iterator();
		while (itr.hasNext()){
			views.addAll(itr.next().getAllViewSpecs());
		}
		
		return views;
	}
	
	/**
	 * @see org.eclipse.vjet.dsf.spec.app.IAppSpec
	 */
	public void touchAll(){
		getAllViewSpecs();
	}
	
	//
	// API
	//
	/**
	 * Create a new state spec with given name and add it to this app.
	 * @param moduleSpec IModuleSpec
	 * @param option Option
	 * @return DefaultStateSpec 
	 */
	public DefaultStateSpec createStateSpec(final String name){
		final DefaultStateSpec stateSpec = new DefaultStateSpec(name);
		m_states.put(name, stateSpec);
		return stateSpec;
	}
	
	//
	// Protected
	//
	protected static final Option IN_ONLY = Option.IN_ONLY;
	protected static final Option OUT_ONLY = Option.OUT_ONLY;
	protected static final Option IN_OUT = Option.IN_OUT;
	
	//
	// Private
	//
	private void initialize(){
		
		if (m_initialized){
			return;
		}
		
		m_initialized = true;
		
		try {
			Class.forName(this.getClass().getName() + "$StateSpecs");
		} 
		catch (ClassNotFoundException e) {
			// No-op
			// could be normal without StateSpecs
		}
		
		try {
			Class.forName(this.getClass().getName() + "$ModuleSpecs");
		} 
		catch (ClassNotFoundException e) {
			// No-op
			// could be normal without ModuleSpecs
		}
	}

	public boolean isSupportNonversionedResourceExternalization() {
		return m_supportNonversionedResourceExternalization;
	}
	
	protected void supportNonversionedResourceExternalization() {
		m_supportNonversionedResourceExternalization = true;
	}

	public boolean isIncludeJsRuntimeIntoPageJs() {
		return m_includeJsRuntimeIntoPageJs;
	}
	
	protected void includeJsRuntimeIntoPageJs() {
		m_includeJsRuntimeIntoPageJs = true;
	}
	
	public void setJsPkgOptimization(boolean flag){
		m_jsPkgOptimization = flag;
	}
	
	public boolean isJsPkgOptimization(){
		return m_jsPkgOptimization;
	}
	
	public String getOptSlot(){
		return m_optSlot;
	}
	
	public void setOptSlot(String slotName){
		m_optSlot = slotName;
	}
	
	public String getOptCommonSlot(){
		return m_optCommonSlot;
	}
	
	public void setOptCommonSlot(String slotName){
		m_optCommonSlot = slotName;
	}
	
	public String getOptKeyView(){
		return m_optKeyView;
	}
	
	public void setOptKeyView(String viewName){
		m_optKeyView = viewName;
	}
	
	public int getOptCommonFactor(){
		return m_optCommonFactor;
	}
	
	public void setOptCommonFactor(int views){
		m_optCommonFactor = views;
	}
	
	public void addOptViewsExclude(IViewSpec viewSpec){
		if ( viewSpec == null)
			return;
		if ( m_optViewsExclude == null )
			m_optViewsExclude = new HashSet<IViewSpec>();
		
		m_optViewsExclude.add(viewSpec);
	}
	
	public Set<IViewSpec> getOptViewsExclude(){
		return m_optViewsExclude;
	}
	
	public void clearJsCache() {
	}

	@Override
	public int getOptVersion() {
		return m_optVersion;
	}
	public void setOptVersion(int version) {
		m_optVersion = version;
	}
}

