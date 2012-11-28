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

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.vjet.dsf.json.JsonObject;
import org.eclipse.vjet.dsf.json.serializer.BeanSerializer;
import org.eclipse.vjet.dsf.json.serializer.BeanSerializer.BeanData;
import org.eclipse.vjet.dsf.json.serializer.SerializationException;
import org.eclipse.vjet.dsf.logger.Logger;
import org.eclipse.vjet.dsf.serializers.ISerializableForVjo;


public class VjoBeanSerializer extends VjoPrimitiveSerializer{
	private static Logger s_logger = Logger.getInstance(VjoBeanSerializer.class);

	public VjoBeanSerializer() {
	}

	public boolean canSerialize(Object obj){
		final Class<?> type = obj.getClass();
		if(isPrimitive(type)){
			return false;
		}
		else if(type.isEnum()){
			return false;
		}
		else if(type.isArray()){
			return false;
		}
		else if(Map.class.isAssignableFrom(type)){
			return false;
		}
		else if(List.class.isAssignableFrom(type)){
			return false;
		}
		else if(Set.class.isAssignableFrom(type)){
			return false;
		}
		else if(type.getAnnotation(AVjoSerializable.class) != null){
			return false;
		}
		else if(ISerializableForVjo.class.isAssignableFrom(type)){
			return false;
		}
		
		return true;
	}
	
	public Object doSerialize(Object obj) throws SerializationException{
		final JsonObject sb = new JsonObject();
		try {
			objectStateTransfer(obj, sb);
		}
		catch (IntrospectionException e) {
			s_logger.log(e);
		} 
		catch (IllegalArgumentException e) {
			s_logger.log(e);
		} 
		catch (IllegalAccessException e) {
			s_logger.log(e);
		} 
		catch (InvocationTargetException e) {
			s_logger.log(e);
		}
		
		return sb;
	}
	
	public void objectStateTransfer(Object obj, JsonObject sb) throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, SerializationException{
		final Class<?> type = obj.getClass();
		final BeanData bd = BeanSerializer.getBeanData(type);
		for(final Iterator<Map.Entry<String, Method>> it = bd.m_readableProps.entrySet().iterator(); it.hasNext();){
			final Map.Entry<String, Method> entry = it.next();
			//NV pair {(write method | attribute), value}
			final Method meth = entry.getValue();
			final Object value = meth.invoke(obj);
			sb.put(entry.getKey(), getOwner().serialize(value));
		}
	}

	@Override
	protected Object toCache(Object toSerialize, Object result) {
		return result;
	}

	@Override
	protected boolean canCache(Object toSerialize) {
		return true;
	}
}
