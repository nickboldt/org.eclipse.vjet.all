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
package org.eclipse.vjet.dsf.resource.slot;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;


/**
 * provides pre-assignment of slot locations for some Js resources if needed.
 */
public class JsResourceSlotAssignment {
	
	private final Map<String, String> m_refToSlotMapping;
	private final Map<String, String> m_urnPrefixToSlotMapping;
	
	public JsResourceSlotAssignment() {
		m_refToSlotMapping
			= new HashMap<String, String>();
		m_urnPrefixToSlotMapping 
			= new HashMap<String, String>();
	}
	
	public JsResourceSlotAssignment(Map<String, String> refToSlotMapping, Map<String, String> urnPrefixToSlotMapping) {
		m_refToSlotMapping = new LinkedHashMap<String, String>(refToSlotMapping != null ? refToSlotMapping : Collections.EMPTY_MAP);
		m_urnPrefixToSlotMapping = new LinkedHashMap<String, String>(urnPrefixToSlotMapping != null ? urnPrefixToSlotMapping : Collections.EMPTY_MAP);
	}
	
	public Map<String, String> getUrnsMap() {
		return Collections.unmodifiableMap(m_refToSlotMapping);
	}
	
	public Map<String, String> getUrnPrefixesMap() {
		return Collections.unmodifiableMap(m_urnPrefixToSlotMapping);
	}

	//
	// API
	//
	/**
	 * Assign the passed in resource to the specified slot name.  The resource
	 * and slot name must not be null else a DsfRuntimeException is thrown.
	 * Answers null if the resource has never been assigned a slot in this
	 * instance else answers the previous associated slot name.
	 */
	public void put(final IJsResourceRef resource, final String slotName) {
		assertNotNull(resource, "JS resource ref must not be null") ;
		assertNotNull(slotName, "Slot name must not be null") ;
		m_refToSlotMapping.put(resource.getUrn(), slotName);
	}
	
	public void put(final JsResource resource, final String slotName) {
		assertNotNull(resource, "JS resource must not be null") ;
		assertNotNull(slotName, "Slot name must not be null") ;
		m_refToSlotMapping.put(resource.getUrn(), slotName);
	}
	
	/**
	 * Accept urn Prefixes, as slot locations
	 */
	public void put(final String urnPrefix, final String slotName) {
		assertNotNull(urnPrefix, "Urn Prefix must not be null") ;
		assertNotNull(slotName, "Slot name must not be null") ;
		m_urnPrefixToSlotMapping.put(urnPrefix, slotName);
	}
	
	/**
	 * Answer the slot name for the JS resource.  Answer null if the ref does
	 * not have an assignment for this instance.
	 */
	public String getSlotName(final IJsResourceRef resource) {
		return getSlotName(resource.getUrn());
	}
	
	public String getSlotName(final JsResource resource) {
		return getSlotName(resource.getUrn());
	}
	
	public String getSlotName(final String urn) {
		String slotName = m_refToSlotMapping.get(urn);
		if (slotName == null) {
			slotName = getSlotNameFromUrnPrefix(urn);
		}
		return slotName;
	}
	
	public boolean hasAssignment(final IJsResourceRef ref) {
		return m_refToSlotMapping.containsKey(ref.getUrn());
	}
	
	public boolean hasAssignment(final JsResource resource) {
		return m_refToSlotMapping.containsKey(resource.getUrn());
	}
	
	private String getSlotNameFromUrnPrefix(final String urn) {
		Set<String> keys = m_urnPrefixToSlotMapping.keySet();
		for (String key : keys){
			if (urn.startsWith(key)) {
				return m_urnPrefixToSlotMapping.get(key);
			}
		}
		return null;
	}
	//
	// Override(s) from Object
	//
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> entry : m_refToSlotMapping.entrySet()) {
			sb.append("  JsRef URN: ")
			  .append(entry.getKey())
			  .append("-->")
			  .append(entry.getValue())
			  .append("\n");
		}
		return sb.toString();
	}
	
	public Iterator<String> getUrns(){
		return m_refToSlotMapping.keySet().iterator();
	}
	
	public Iterator<String> getUrnPrefixes(){
		return m_urnPrefixToSlotMapping.keySet().iterator();
	}
	
	//
	// Private
	//
	private void assertNotNull(final Object o, final String msg) {
		if (o == null) {
			throw new DsfRuntimeException(msg) ;
		}
	}
}
