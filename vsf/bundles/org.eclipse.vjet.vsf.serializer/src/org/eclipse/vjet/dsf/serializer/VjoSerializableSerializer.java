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
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.json.JsonObject;
import org.eclipse.vjet.dsf.json.serializer.SerializationException;
import org.eclipse.vjet.dsf.logger.LogLevel;
import org.eclipse.vjet.dsf.logger.Logger;
import org.eclipse.vjet.dsf.serializers.ISerializableForVjo;


public class VjoSerializableSerializer extends VjoAbstractSerializer {
	
	private static Logger s_logger = Logger.getInstance(VjoSerializableSerializer.class);

	public boolean canSerialize(Object obj){
		final Class<?> type = obj.getClass();
		if(ISerializableForVjo.class.isAssignableFrom(type) 
				|| type.getAnnotation(AVjoSerializable.class) != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	private Method lookUpMethod(Class<?> clz, String methName){
		if(clz == null || Object.class.equals(clz)){
			return null;
		}
		
		try{
			Method toReturn = clz.getMethod(methName);
			if(toReturn != null){
				toReturn.setAccessible(true);
				return toReturn;
			}
		}
		catch(SecurityException e){
			s_logger.log(LogLevel.WARN, e);
		}
		catch(NoSuchMethodException e){
			s_logger.log(LogLevel.WARN, e);
		}
		
		return lookUpMethod(clz.getSuperclass(), methName); 
	}
	
	private boolean isInvalid(String id){
		return id == null || id.length() <= 0;
	}
	
	private String normalizeTypeName(Class<?> type){
		if(type.isMemberClass() || type.isLocalClass()){
			return type.getName().replace('$', '.');
		}
		else{
			return type.getName();
		}
	}
	
	public Object doSerialize(Object obj) throws SerializationException{
		final Class<?> type = obj.getClass();
		final VjoSerializedResult vjo = new VjoSerializedResult();
		final AVjoSerializable anno = (AVjoSerializable)type.getAnnotation(AVjoSerializable.class);
		String vjoId = null;
		String vjoType = null;
		
		//check if vjoId & vjoType has been customized in the annotation
		if(anno != null){
			final String vjoIdGetter = anno.vjoIdGetter();
			if(vjoIdGetter.length() > 0){
				try {
					final Method meth = lookUpMethod(type, vjoIdGetter);
					if(meth != null){
						vjoId = String.valueOf(meth.invoke(obj));
					}
				}
				catch (SecurityException e) {
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
			}
			vjoType = anno.vjoType();
		}
		
		if(isInvalid(vjoId)){
			vjoId = DsfCtx.ctx().ids().nextHtmlId();
		}
		if(isInvalid(vjoType)){
			vjoType = normalizeTypeName(type);
		}
		
		vjo
			.setVjoId(vjoId)
			.setVjoType(vjoType);
		
		try {
			objectStateTransfer(obj, obj.getClass(), vjo);
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
		
		return vjo;
	}

	public void objectStateTransfer(Object obj, Class<?> clz, VjoSerializedResult vjo) throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, SerializationException{
		objectStateTransfer(obj, clz, vjo, new HashSet<String>());
	}
	
	private void objectStateTransfer(Object obj, Class<?> clz, VjoSerializedResult vjo, Set<String> fieldsSet) throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, SerializationException{
		//recursion stops when there's no super class or super class is object now
		if(clz == null){
			return;
		}
		else if(clz.getAnnotation(AVjoUnSerializable.class) != null || Object.class.equals(clz)){
			if(clz.getAnnotation(AVjoSerializable.class) != null){
				throw new SerializationException("class can't be both AVjoSerializable and AVjoUnSerializable");
			}
			return;
		}
		
		final Field[] fields = clz.getDeclaredFields();
		if (fields != null && fields.length > 0) {
			for (Field f : fields) {
				if (Modifier.isStatic(f.getModifiers())) {
					continue;
				}
				//making shielding fields none-overridable by super class fields
				if(fieldsSet.contains(f.getName())){
					continue;
				}
				else{
					fieldsSet.add(f.getName());
				}
				
				propertyStateTransfer(obj, vjo, f);
			}
		}
		//recursively scan parent classes
		final Class<?> superClz = clz.getSuperclass();
		objectStateTransfer(obj, superClz, vjo, fieldsSet);
	}

	private void propertyStateTransfer(Object obj, VjoSerializedResult vjo, Field property)
			throws IllegalAccessException, SerializationException{
		property.setAccessible(true);
		final String propertyName = property.getName();
		final Object result = property.get(obj);
			
		if(VjoSerializationCtx.ctx().inStack(result)){//circular reference is found, add the broken reference to the ctx, and mark null
			VjoSerializationCtx.ctx().addBrokenReference(result, obj, propertyName);
			vjo.put(propertyName, JsonObject.NULL);
		}
		else{
			vjo.put(propertyName, getOwner().serialize(result));
		}
	}

	@Override
	protected Object toCache(Object toSerialize, Object result) {
		if(VjoSerializedResult.class.isAssignableFrom(result.getClass())){
			//using vjo cache as the cached instance, the cacheId is identical with the vjoId
			final VjoSerializedCache cache = new VjoSerializedCache()
				.setCacheId(((VjoSerializedResult)result).getVjoId());
			
			return cache;
		}
		return result;
	}

	@Override
	protected boolean canCache(Object toSerialize) {
		return true;
	}

	@Override
	protected Object restoreBrokenReference(Object toSerialize, Object result) {
		if(VjoSerializationCtx.ctx().hasBrokenReference(toSerialize)){
			//both the referenced and the referencing must be vjo object, otherwise, there's nothing to restore
			if(VjoSerializedResult.class.isAssignableFrom(result.getClass())){
				for(final Iterator<Map.Entry<Object, String>> it = VjoSerializationCtx.ctx().getBrokenReference(toSerialize).entrySet().iterator(); it.hasNext();){
					//restoring each broken references marked
					final Map.Entry<Object, String> entry = it.next();
					final Object broken = entry.getKey();
					//the broken reference's residence should have completed its init scope, and cached, using the cache id as the key
					final VjoSerializedCache brokenCache = (VjoSerializedCache)VjoSerializationCtx.ctx().getCached(broken);
					final String propertyName = entry.getValue();
					if(brokenCache != null){
						((VjoSerializedResult)result).addBrokenReference(brokenCache, propertyName);
					}
					else{
						s_logger.log(LogLevel.ERROR, "broken reference couldn't be restored as the broken residence hasn't bee cached! [broken: " + broken.toString() + "]");
					}
				}
			}
		}
		return result;
	}
}
