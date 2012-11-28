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

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.vjet.dsf.json.serializer.SerializationException;

public class VjoPrimitiveSerializer extends VjoAbstractSerializer{
//	private static Logger s_logger = Logger.getInstance(VjoPrimitiveSerializer.class);

	protected static final List<Class<?>> s_primitiveTypes = new ArrayList<Class<?>>(
			10);
	
	static {//added byte, short, char types
		s_primitiveTypes.add(Byte.class);
		s_primitiveTypes.add(Character.class);
		s_primitiveTypes.add(String.class);
		s_primitiveTypes.add(Boolean.class);
		s_primitiveTypes.add(Short.class);
		s_primitiveTypes.add(Integer.class);
		s_primitiveTypes.add(Long.class);
		s_primitiveTypes.add(Float.class);
		s_primitiveTypes.add(Double.class);
	}

	public VjoPrimitiveSerializer() {
	}

	public boolean canSerialize(Object obj){
		final Class<?> type = obj.getClass();
		if(isPrimitive(type)){
			return true;
		}
		
		return false;
	}
	
	public Object doSerialize(Object obj) throws SerializationException{
		final Class<?> type = obj.getClass();
		final String val = type == String.class ? (String) obj : obj.toString();
		
		if (char.class.isAssignableFrom(type) || Character.class.isAssignableFrom(type)) {
			return val.substring(0, 1);
		}
		else if (type == byte[].class) {
			try {
				return val.getBytes("utf-8");
			}
			catch (UnsupportedEncodingException e) {
				throw new SerializationException("UnsupportedEncodingException");
			}
		}
		
		return obj;
	}

	protected boolean isPrimitive(final Class<?> type) {
		return type.isPrimitive() || s_primitiveTypes.contains(type);
	}

	@Override
	protected Object toCache(Object toSerialize, Object result) {
		return result;
	}

	@Override
	protected boolean canCache(Object toSerialize) {
		return false;
	}

	@Override
	protected Object restoreBrokenReference(Object toSerialize, Object result) {
		return result;
	}
}
