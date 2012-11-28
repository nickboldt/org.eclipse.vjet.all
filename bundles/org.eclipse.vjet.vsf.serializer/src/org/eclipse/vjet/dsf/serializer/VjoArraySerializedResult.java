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
import java.util.List;

public class VjoArraySerializedResult extends VjoSerializedResult{

	private List<Object> m_vjoArray;
	
	public Object[] getVjoArray(){
		if(m_vjoArray == null){
			return new Object[0];
		}
		
		return m_vjoArray.toArray();
	}
	
	public VjoArraySerializedResult addVjoObject(Object vjoObject){
		if(m_vjoArray == null){
			m_vjoArray = new ArrayList<Object>();
		}
		m_vjoArray.add(vjoObject);
		return this;
	}
	
	@Override
	public StringBuilder toWrapperString(final String registryScope, StringBuilder sb){
		sb.append('[');
		
        for(Object obj : getVjoArray()){
        	appendValue(obj, sb);
        	sb.append(',');
        }
        //replace the last comma with bracket, if not comma, just close it
        if(sb.charAt(sb.length() - 1) == ','){
        	sb.setCharAt(sb.length() - 1, ']');
        }
        else{
        	sb.append(']');
        }
		return sb;
	}
}
