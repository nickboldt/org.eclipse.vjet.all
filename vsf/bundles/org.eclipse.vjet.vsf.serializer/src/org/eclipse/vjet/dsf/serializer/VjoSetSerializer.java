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
import java.util.Set;

import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.json.serializer.SerializationException;

public class VjoSetSerializer extends VjoSerializableSerializer {

	private String m_vjoSetUtil = VjoSerializer.VJO_HASHSET_UTIL_LOCAL;
	
	public String getVjoSetUtil(){
		return m_vjoSetUtil;
	}
	
	public VjoSetSerializer setVjoSetUtil(String util){
		m_vjoSetUtil = util;
		return this;
	}
	
	public boolean canSerialize(Object obj){
		final Class<?> type = obj.getClass();
		if(Set.class.isAssignableFrom(type)){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	protected void preSerialize(Object toSerialize){
		super.preSerialize(toSerialize);
		VjoSerializationCtx.ctx().setHasVjoSet(true);
	}
	
	public Object doSerialize(Object obj) throws SerializationException{
		final VjoSetSerializedResult vjoSet = new VjoSetSerializedResult();
		vjoSet.setVjoId(DsfCtx.ctx().ids().nextJsCompId());
		vjoSet.setVjoSetUtil(getVjoSetUtil());
		
		final Class<?> type = obj.getClass();
		if (Set.class.isAssignableFrom(type)) {
			Set<?> set = (Set<?>) obj;
			final Iterator<?> it = set.iterator();
			while(it.hasNext()){
				vjoSet.addVjoObject(getOwner().serialize(it.next()));
			}
		}
		
		return vjoSet;
	}

}
