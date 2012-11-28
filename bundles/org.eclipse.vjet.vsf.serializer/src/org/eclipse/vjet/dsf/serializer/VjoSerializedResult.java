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

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.vjet.dsf.json.JsonArray;
import org.eclipse.vjet.dsf.json.JsonObject;

public class VjoSerializedResult extends JsonObject{
	
	private String m_vjoId;
	private String m_vjoType;
	private Map<VjoSerializedCache, String> m_brokenReferences;
	
	public String getVjoId(){
		return m_vjoId;
	}
	
	public VjoSerializedResult setVjoId(String id){
		m_vjoId = id;
		return this;
	}
	
	public String getVjoType(){
		return m_vjoType;
	}
	
	public VjoSerializedResult setVjoType(String type){
		m_vjoType = type;
		return this;
	}
	
	public Map<VjoSerializedCache, String> getBrokenReferences(){
		if(m_brokenReferences == null){
			m_brokenReferences = new HashMap<VjoSerializedCache, String>();
		}
		return Collections.unmodifiableMap(m_brokenReferences);
	}
	
	public VjoSerializedResult addBrokenReference(VjoSerializedCache ref, String prop){
		if(m_brokenReferences == null){
			m_brokenReferences = new HashMap<VjoSerializedCache, String>();
		}
		m_brokenReferences.put(ref, prop);
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
	
	protected StringBuilder toBeginJson(StringBuilder sb){
		sb.append("vjo.obj(");
		appendQuoted(getVjoType(), sb);
        sb.append(',');
		return sb;
	}
	
	protected StringBuilder toJsonData(StringBuilder sb){
		return super.append(sb);
	}
	
	protected StringBuilder toEndJson(StringBuilder sb){
		sb.append(')');
		return sb;
	}
	
	protected StringBuilder toBackReferences(StringBuilder sb){
		final Iterator<Map.Entry<VjoSerializedCache, String>> it = getBrokenReferences().entrySet().iterator();

		if(it.hasNext()){
	        sb.append(", {");
			do{
				final Map.Entry<VjoSerializedCache, String> entry = it.next();
				appendQuoted(entry.getKey().getCacheId(), sb);
				sb.append(':');
				appendQuoted(entry.getValue(), sb);
				if(it.hasNext()){
	        		sb.append(',');
	        	}
			}
			while(it.hasNext());
			sb.append('}');
		}
		
		return sb;
	}
	
	public StringBuilder toWrapperString(final String registryScope, StringBuilder sb){
		VjoSerializationCtx.ctx().setRegistryScope(registryScope);
		
		sb.append(registryScope);
		sb.append(".put(");
		appendQuoted(getVjoId(), sb);
		sb.append(',');
		toBeginJson(sb);
        toJsonData(sb);
        toEndJson(sb);
        toBackReferences(sb);
		sb.append(')');
		return sb;
	}
	
	 public static String valueToString(final Object value) {
		if (value == null || value.equals(null)) {
			return "null";
		}
		if(char.class.isAssignableFrom(value.getClass()) || Character.class.isAssignableFrom(value.getClass())){
			return quote(value.toString());
		}
		if (value instanceof Number) {
			return numberToString((Number) value);
		}
		if (value instanceof Boolean || value instanceof JsonArray
				|| JsonObject.class.isAssignableFrom(value.getClass())) {
			return value.toString();
		}
		if (!(value instanceof String)) {
			return value.toString();
		}
		return quote(value.toString());
	}
}
