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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class VjoListSerializedResult extends VjoSerializedResult{

	private List<Object> m_vjoList;
	private String m_vjoListUtil = VjoSerializer.VJO_ARRAYLIST_UTIL + "." + VjoSerializer.VJO_ARRAYLIST_UTIL_CREATE;
	
	public List<Object> getVjoList(){
		if(m_vjoList == null){
			return Collections.emptyList();
		}
		
		return Collections.unmodifiableList(m_vjoList);
	}
	
	public VjoListSerializedResult addVjoObject(Object vjoObject){
		if(m_vjoList == null){
			m_vjoList = new ArrayList<Object>();
		}
		m_vjoList.add(vjoObject);
		return this;
	}
	
	public String getVjoListUtil(){
		return m_vjoListUtil;
	}
	
	public VjoListSerializedResult setVjoListUtil(String listUtil){
		m_vjoListUtil = listUtil;
		return this;
	}
	
	@Override
	protected StringBuilder toBeginJson(StringBuilder sb) {
		sb.append(getVjoListUtil());
		sb.append('(');
		return sb;
	}
	
	@Override
	protected StringBuilder toJsonData(StringBuilder sb) {
		sb.append('[');
        for(final Iterator<Object> it = getVjoList().iterator(); it.hasNext();){
        	appendValue(it.next(), sb);
        	if(it.hasNext()){
        		sb.append(',');
        	}
        }
        sb.append(']');
		return sb;
	}
}
