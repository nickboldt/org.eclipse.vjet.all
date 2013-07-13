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
import java.util.List;

import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.json.serializer.SerializationException;

public class VjoListSerializer extends VjoSerializableSerializer {

	private String m_vjoListUtil = VjoSerializer.VJO_ARRAYLIST_UTIL_LOCAL;
	
	public String getVjoListUtil(){
		return m_vjoListUtil;
	}
	
	public VjoListSerializer setVjoListUtil(String util){
		m_vjoListUtil = util;
		return this;
	}
	
	public boolean canSerialize(Object obj){
		final Class<?> type = obj.getClass();
		if(List.class.isAssignableFrom(type)){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	protected void preSerialize(Object toSerialize){
		super.preSerialize(toSerialize);
		VjoSerializationCtx.ctx().setHasVjoList(true);
	}
	
	public Object doSerialize(Object obj) throws SerializationException{
		final VjoListSerializedResult vjoList = new VjoListSerializedResult();
		vjoList.setVjoId(DsfCtx.ctx().ids().nextJsCompId());
		vjoList.setVjoListUtil(getVjoListUtil());
		
		final Class<?> type = obj.getClass();
		if(List.class.isAssignableFrom(type)){
			final List<?> list = (List<?>) obj;
			for(final Iterator<?> it = list.iterator(); it.hasNext();){
				vjoList.addVjoObject(getOwner().serialize(it.next()));
			}
		}
		
		return vjoList;
	}

}
