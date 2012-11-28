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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class VjoSetSerializedResult extends VjoSerializedResult{

	private Set<Object> m_vjoSet;
	private String m_vjoSetUtil = VjoSerializer.VJO_HASHSET_UTIL + "." + VjoSerializer.VJO_HASHMAP_UTIL_CREATE;
	
	public Set<Object> getVjoSet(){
		if(m_vjoSet == null){
			return Collections.emptySet();
		}
		
		return Collections.unmodifiableSet(m_vjoSet);
	}
	
	public VjoSetSerializedResult addVjoObject(Object vjoObject){
		if(m_vjoSet == null){
			m_vjoSet = new HashSet<Object>();
		}
		m_vjoSet.add(vjoObject);
		return this;
	}
	
	public String getVjoSetUtil(){
		return m_vjoSetUtil;
	}
	
	public VjoSetSerializedResult setVjoSetUtil(String setUtil){
		m_vjoSetUtil = setUtil;
		return this;
	}
	
	@Override
	protected StringBuilder toBeginJson(StringBuilder sb) {
		sb.append(getVjoSetUtil());
		sb.append('(');
		return sb;
	}
	
	@Override
	protected StringBuilder toJsonData(StringBuilder sb) {
		sb.append('[');
		for(final Iterator<Object> it = getVjoSet().iterator(); it.hasNext();){
        	appendValue(it.next(), sb);
        	if(it.hasNext()){
        		sb.append(',');
        	}
        }
        sb.append(']');
		return sb;
	}
}
