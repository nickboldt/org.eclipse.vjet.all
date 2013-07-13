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
import org.eclipse.vjet.dsf.logger.LogLevel;
import org.eclipse.vjet.dsf.logger.Logger;

public class VjoArraySerializer extends VjoAbstractSerializer{
	private static Logger s_logger = Logger.getInstance(VjoArraySerializer.class);

	//
	// Constructors
	//
	public VjoArraySerializer() {
	}

	public boolean canSerialize(Object obj){
		final Class<?> type = obj.getClass();
		if(type.isArray()){
			return true;
		}
		
		return false;
	}
	
	public Object doSerialize(Object obj) throws SerializationException{
		final VjoArraySerializedResult vjoArray = new VjoArraySerializedResult();
		final Class<?> componentType = obj.getClass().getComponentType();
		
		if(!componentType.isPrimitive()){
			for(Object elem: (Object[])obj){
				vjoArray.addVjoObject(getOwner().serialize(elem));
			}
		}
		else{//fixing primitive array classcastexception issue
			if(byte.class.equals(componentType)){
				for(Object elem: (byte[])obj){
					vjoArray.addVjoObject(getOwner().serialize(elem));
				}
			}
			else if(char.class.equals(componentType)){
				for(Object elem: (char[])obj){
					vjoArray.addVjoObject(getOwner().serialize(elem));
				}
			}
			else if(boolean.class.equals(componentType)){
				for(Object elem: (boolean[])obj){
					vjoArray.addVjoObject(getOwner().serialize(elem));
				}
			}
			else if(short.class.equals(componentType)){
				for(Object elem: (short[])obj){
					vjoArray.addVjoObject(getOwner().serialize(elem));
				}
			}
			else if(int.class.equals(componentType)){
				for(Object elem: (int[])obj){
					vjoArray.addVjoObject(getOwner().serialize(elem));
				}
			}
			else if(long.class.equals(componentType)){
				for(Object elem: (long[])obj){
					vjoArray.addVjoObject(getOwner().serialize(elem));
				}
			}
			else if(float.class.equals(componentType)){
				for(Object elem: (float[])obj){
					vjoArray.addVjoObject(getOwner().serialize(elem));
				}
			}
			else if(double.class.equals(componentType)){
				for(Object elem: (double[])obj){
					vjoArray.addVjoObject(getOwner().serialize(elem));
				}
			}
			else{
				s_logger.log(LogLevel.ERROR, "unknown primitive array component type?");
			}
		}
		return vjoArray;
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
