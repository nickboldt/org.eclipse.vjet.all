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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;

/**
 * Simple template class to manage a list of resource slot
 */
public abstract class ResourceSlotter<T extends ResourceSlot> {

	private final Map<String, T> m_slots = new LinkedHashMap<String, T>();
	private LinkedHashSet<String> m_slotsOrder = null;
	protected boolean m_allowDynamicSlots = true;

	abstract protected T createSlot(String name);
	
	/**
	 * Force a specific slot order other than the slot creation order
	 * @param slotsOrder
	 * @param allowDynamicSlots - value of true permits dynamic creation
	 *          of new slot that is not part of slotsOrder.
	 */
	public void setSlotsOrder(
		final String[] slotsOrder, final boolean allowDynamicSlots)
	{
		m_slotsOrder = new LinkedHashSet<String>(slotsOrder.length);
		for (String name : slotsOrder) {
			m_slotsOrder.add(name);
		}
		m_allowDynamicSlots = allowDynamicSlots;
	}
	
	public String[] getSlotsOrder() {
		return (String[])m_slotsOrder.toArray(new String[m_slotsOrder.size()]);
	}

	/**
	 * @return  an existing slot for a given name; it will create one if 
	 * it does not exist yet.
	 */
	public T getSlot(final String name) {
		return getSlot(name, true);
	}

	public T getSlot(final String name, final boolean create) {
		if (!m_allowDynamicSlots && !m_slotsOrder.contains(name)) {
			throw new DsfRuntimeException(name 
				+ " is not in the sealed list: "
				+ m_slotsOrder.toArray().toString());
		}
		T slot = m_slots.get(name);
		if (slot == null && create) {
			slot = createSlot(name);
			m_slots.put(name, slot);
		}
		return slot;
	}
	
	/*  
	 *  Remove a slot.
	 *  @return true if the slot exists.
	 */
	public boolean removeSlot(final String name){
		if ( m_slots.remove(name) != null )
			return true;
		return false;
	}
	
	/**
	 * @return  an ordered list of slot based on slotsOrder if it exists
	 * and the order of slot creation
	 */
	public Iterable<T> getAllSlots() {
		if (m_slotsOrder == null || m_slots.size() <= 1) {
			return m_slots.values();
		}
		
		final List<T> orderedList = new ArrayList<T>(m_slots.size());
		for (String name : m_slotsOrder) {
			T slot = m_slots.get(name);
			if (slot != null) {
				orderedList.add(slot);
			}
		}
		
		for (T slot : m_slots.values()) {
			if (!orderedList.contains(slot)) {
				orderedList.add(slot);
			}
		}
		
		return orderedList;
	}
	
	/**
	 * Answer if a resource with this given urn is already in a slot.
	 * If it is, return the slot name of the first one containing
	 * the resource.
	 */
	public String isInAnySlot(final String urn) {
		for (ResourceSlot slot : m_slots.values()) {
			if (slot.has(urn)) {
				return slot.getName();
			}
		}

		return null;
	}
}
