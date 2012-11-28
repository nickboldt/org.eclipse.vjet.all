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

import org.eclipse.vjet.dsf.json.serializer.SerializationException;


public class VjoEnumSerializer extends VjoPrimitiveSerializer{
	public VjoEnumSerializer() {
	}

	public boolean canSerialize(Object obj){
		final Class<?> type = obj.getClass();
		if(type.isEnum()){
			return true;
		}
		
		return false;
	}
	
	public Object doSerialize(Object obj) throws SerializationException{
		final StringBuilder sb = new StringBuilder();
		sb.append(obj.getClass().getName().replace('$', '.'));
		sb.append(".");
		sb.append(((Enum<?>)obj).name());
		return sb.toString();
	}
	
	@Override
	protected Object toCache(Object toSerialize, Object result) {
		return result;
	}

	@Override
	protected boolean canCache(Object toSerialize) {
		return false;
	}
}
