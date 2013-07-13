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

import java.util.Iterator;
import java.util.Map;

import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.json.serializer.SerializationException;

public class VjoMapSerializer extends VjoSerializableSerializer {

	private String m_vjoMapUtil = VjoSerializer.VJO_HASHMAP_UTIL_LOCAL;
	
	public String getVjoMapUtil(){
		return m_vjoMapUtil;
	}
	
	public VjoMapSerializer setVjoMapUtil(String util){
		m_vjoMapUtil = util;
		return this;
	}
	
	public boolean canSerialize(Object obj){
		final Class<?> type = obj.getClass();
		if(Map.class.isAssignableFrom(type)){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	protected void preSerialize(Object toSerialize){
		super.preSerialize(toSerialize);
		VjoSerializationCtx.ctx().setHasVjoMap(true);
	}
	
	public Object doSerialize(Object obj) throws SerializationException{
		final VjoMapSerializedResult vjoMap = new VjoMapSerializedResult();
		vjoMap.setVjoId(DsfCtx.ctx().ids().nextJsCompId());
		vjoMap.setVjoMapUtil(getVjoMapUtil());
		
		final Class<?> type = obj.getClass();
		if(Map.class.isAssignableFrom(type)){
			Map<?, ?> map = (Map<?, ?>) obj;
			for(final Iterator<?> it = map.entrySet().iterator();it.hasNext();){
				final Map.Entry<?, ?> elem = (Map.Entry<?, ?>)it.next();
				vjoMap.putVjoObject(
						getOwner().serialize(elem.getKey()),
						getOwner().serialize(elem.getValue()));	
			}
		}
		return vjoMap;
	}

}
