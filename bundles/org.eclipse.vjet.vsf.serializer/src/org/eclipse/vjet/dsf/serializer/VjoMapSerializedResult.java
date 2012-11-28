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
package org.eclipse.vjet.dsf.serializer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class VjoMapSerializedResult extends VjoSerializedResult{

	private Map<Object, Object> m_vjoMap;
	private String m_vjoMapUtil = VjoSerializer.VJO_HASHMAP_UTIL + "." + VjoSerializer.VJO_HASHMAP_UTIL_CREATE;
	
	public Map<Object, Object> getVjoMap(){
		if(m_vjoMap == null){
			return Collections.emptyMap();
		}
		
		return Collections.unmodifiableMap(m_vjoMap);
	}
	
	public VjoMapSerializedResult putVjoObject(Object key, Object value){
		if(m_vjoMap == null){
			m_vjoMap = new HashMap<Object, Object>();
		}
		m_vjoMap.put(key, value);
		return this;
	}
	
	public String getVjoMapUtil(){
		return m_vjoMapUtil;
	}
	
	public VjoMapSerializedResult setVjoMapUtil(String mapUtil){
		m_vjoMapUtil = mapUtil;
		return this;
	}
	
	@Override
	protected StringBuilder toBeginJson(StringBuilder sb) {
		sb.append(getVjoMapUtil());
		sb.append('(');
		return sb;
	}
	
	@Override
	protected StringBuilder toJsonData(StringBuilder sb) {
		sb.append('[');
		for (final Iterator<Map.Entry<Object, Object>> it = getVjoMap()
				.entrySet().iterator(); it.hasNext();) {
			final Map.Entry<Object, Object> entry = it.next();
			sb.append("{'K':");
			appendValue(entry.getKey(), sb);
			sb.append(",'V':");
			appendValue(entry.getValue(), sb);
			sb.append('}');
			if (it.hasNext()) {
				sb.append(',');
			}
		}
		sb.append(']');
		return sb;
	}
}
