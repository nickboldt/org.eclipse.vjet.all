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
import java.util.List;
import java.util.Map;

/**
 * Keeps the mapping between logical resource slots to their corresponding
 * externalized group index.
 */
public class ExternalizedSlotGrouping {

	private Map<String, String> m_slotGroupMapping =
		new LinkedHashMap<String, String>();
	
	//
	// API
	//
	public void put(final String slotName, final String groupIndex) {
		m_slotGroupMapping.put(slotName, groupIndex);
	}
	
	public String getGroupIndex(final String slotName) {
		return m_slotGroupMapping.get(slotName);
	}
	
	public Map<String, String> getAllMappings() {
		return m_slotGroupMapping;
	}
	
	public List<String> getSlotNames(final String groupId) {
		final List<String> slots = new ArrayList<String>();
		for (Map.Entry<String, String> entry : m_slotGroupMapping.entrySet()) {
			if (groupId.equals(entry.getValue())) {
				slots.add(entry.getKey());
			}
		}
		return slots;
	}
	
	//
	// Override(s) from Object
	//
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder(100);
		for (Map.Entry<String, String> entry : m_slotGroupMapping.entrySet()) {
			sb.append("  ")
			  .append(entry.getKey())
			  .append("-->")
			  .append(entry.getValue())
			  .append("\n");
		}
		return sb.toString();
	}
}
