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

public class VjoSerializedCache extends JsonObject{

	private String m_cacheId;
	
	public String getCacheId(){
		return m_cacheId;
	}
	
	public VjoSerializedCache setCacheId(String id){
		m_cacheId = id;
		return this;
	}
	
	@Override
	public String toString(){
		return append(new StringBuilder()).toString();
	}
	
	@Override
	public StringBuilder append(StringBuilder sb) {
		return toWrapperString(sb);
	}
	
	public String toWrapperString() {
		return toWrapperString(new StringBuilder()).toString();
	}
	
	public String toWrapperString(String registryScope) {
		return toWrapperString(registryScope, new StringBuilder()).toString();
	}
	
	public StringBuilder toWrapperString(StringBuilder sb) {
		return toWrapperString(VjoSerializationCtx.ctx().getRegistryScope(), sb);
	}
	
	//TODO use the _dr.id abbr form to replace _dr.get(id) when the id is valid
	public StringBuilder toWrapperString(final String registryScope, StringBuilder sb) {
		sb.append(registryScope);
		sb.append(".get(");
		appendQuoted(getCacheId(), sb);
		sb.append(')');
		return sb;
	}
}
