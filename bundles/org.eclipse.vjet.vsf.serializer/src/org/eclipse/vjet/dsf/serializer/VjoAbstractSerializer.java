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

import org.eclipse.vjet.dsf.json.JsonObject;
import org.eclipse.vjet.dsf.json.serializer.SerializationException;
import org.eclipse.vjet.dsf.serializers.IVjoSerializer;

/**
 * 
 * @author huzhou
 *
 */
public abstract class VjoAbstractSerializer implements IVjoSerializer {

	private IVjoSerializer m_owner;

	protected IVjoSerializer getOwner() {
		return m_owner;
	}

	protected void setOwner(IVjoSerializer owner) {
		m_owner = owner;
	}

	/**
	 * abstract serializer can't serialize any object
	 * it relies on its implementations to decide whether the object could be serialized on their behalf
	 * @return
	 */
	public boolean canSerialize(Object toSerialize) {
		return false;
	}

	/**
	 * normalized serialization flow:
	 * 1) check null
	 * 2) check cache
	 * 3) double confirm if can serialize
	 * 4) pre serialize
	 * 5) check cache capability
	 * 6) cache if capable
	 * 7) restore broken references
	 * 8) post serialize
	 * 
	 * @param toSerialize
	 * @return String
	 */
	public Object serialize(Object toSerialize) throws SerializationException{
		if (toSerialize == null) {
			return JsonObject.NULL;
		}
		final VjoSerializationCtx ctx = VjoSerializationCtx.ctx();
		Object result = ctx.getCached(toSerialize);
		if (result == null) {
			if (canSerialize(toSerialize)) {
				preSerialize(toSerialize);
				result = doSerialize(toSerialize);
				//cache if only capable
				if (canCache(toSerialize)) {
					final Object toCache = toCache(toSerialize, result);
					ctx.cache(toSerialize, toCache);
				}
				//restore broken references
				result = restoreBrokenReference(toSerialize, result);
				postSerialize(toSerialize);
			}
		}
		
		return result;
	}

	/**
	 * push the target to the serialization stack
	 * @param toSerialize
	 */
	protected void preSerialize(Object toSerialize) {
		VjoSerializationCtx.ctx().push(toSerialize);
	}

	/**
	 * pop the target to the serialization stack
	 * @param toSerialize
	 */
	protected void postSerialize(Object toSerialize) {
		VjoSerializationCtx.ctx().pop(toSerialize);
	}

	/**
	 * restore the broken references by assigning the finished json to the object.property pairs in the map
	 * @see VjoSerializationCtx#getBrokenReference(Object)
	 * @see VjoSerializationCtx#addBrokenReference(Object, Object, String)
	 * @param toSerialize
	 * @param result
	 * @return
	 */
	protected abstract Object restoreBrokenReference(Object toSerialize,
			Object result);

	protected abstract Object doSerialize(Object toSerialize) throws SerializationException;

	protected abstract boolean canCache(Object toSerialize);

	protected abstract Object toCache(Object toSerialize, Object result);
}
