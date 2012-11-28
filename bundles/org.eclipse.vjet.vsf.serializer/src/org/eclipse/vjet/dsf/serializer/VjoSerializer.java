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
import java.util.LinkedList;
import java.util.List;

import org.eclipse.vjet.dsf.common.exceptions.DsfExceptionHelper;
import org.eclipse.vjet.dsf.javatojs.anno.AExclude;
import org.eclipse.vjet.dsf.json.serializer.SerializationException;
import org.eclipse.vjet.dsf.serializers.IVjoSerializer;

/**
 * Vjo Main Serializer
 * a composition of the variety of serializers per each type
 * @author huzhou
 *
 */
@AExclude
public class VjoSerializer extends VjoAbstractSerializer{

	public static enum VjoSerializerOption{
		DFEAULT,
		RESET_CTX,
		DATA_REGISTRY_FREE
	}
	
	/**
	 * vjo serializer constants
	 */
	protected static final String VJO_DATA_REGISTRY = "vjo.DataRegistry";
	protected static final String VJO_DATA_REGISTRY_FULL = "new function(){var t=this,m=[];t.put=function(k,j,r){var p,b;m[k]=j;if(r){for(p in r){b=t.get(p);if(b){b[r[p]]=j;}}}}; t.get=function(k){return m[k];};}()";
	//protected static final String VJO_DATA_REGISTRY_FULL = "{m:[],put:function(k,j,r){var t=this,p,b;t.m[k]=j;if(r){for(p in r){b=t.get(p);if(b){b[r[p]]=j;}}}},get:function(k){return this.m[k];}}";
	protected static final String VJO_DATA_REGISTRY_LOCAL = "_dr";
	
	protected static final String VJO_HASHMAP_UTIL = "org.eclipse.vjet.vjo.java.util.HashMapUtil";
	protected static final String VJO_HASHMAP_UTIL_CREATE = "create";
	protected static final String VJO_HASHMAP_UTIL_LOCAL = "$mU";
	
	protected static final String VJO_ARRAYLIST_UTIL = "org.eclipse.vjet.vjo.java.util.ArrayListUtil";
	protected static final String VJO_ARRAYLIST_UTIL_CREATE = "create";
	protected static final String VJO_ARRAYLIST_UTIL_LOCAL = "$lU";
	
	protected static final String VJO_HASHSET_UTIL = "org.eclipse.vjet.vjo.java.util.HashSetUtil";
	protected static final String VJO_HASHSET_UTIL_CREATE = "create";
	protected static final String VJO_HASHSET_UTIL_LOCAL = "$sU";
	
	/**
	 * VjoSerializer singleton instance
	 */
	private static final VjoSerializer s_instance = new VjoSerializer();
	
	public static final VjoSerializer getInstance(){
		return s_instance;
	}
	
	/**
	 * chain of dedicated serializers
	 */
	private List<IVjoSerializer> m_serializerList;
	/**
	 * variables needed for codegen
	 */
	private String m_dataRegistry = VJO_DATA_REGISTRY;
	private String m_dataRegistryLocal = VJO_DATA_REGISTRY_LOCAL;
	private String m_hashMapUtil = VJO_HASHMAP_UTIL;
	private String m_hashMapUtilLocal = VJO_HASHMAP_UTIL_LOCAL;
	private String m_hashMapUtilCreate = VJO_HASHMAP_UTIL_CREATE;
	private String m_arrayListUtil = VJO_ARRAYLIST_UTIL;
	private String m_arrayListUtilLocal = VJO_ARRAYLIST_UTIL_LOCAL;
	private String m_arrayListUtilCreate = VJO_ARRAYLIST_UTIL_CREATE;
	private String m_hashSetUtil = VJO_HASHSET_UTIL;
	private String m_hashSetUtilLocal = VJO_HASHSET_UTIL_LOCAL;
	private String m_hashSetUtilCreate = VJO_HASHSET_UTIL_CREATE;
	
	/**
	 * initialize the vjo serializer by registering the different serializers for different types
	 */
	private VjoSerializer(){
		m_serializerList = new LinkedList<IVjoSerializer>();
		
		//primitives
		registerSerializer(new VjoPrimitiveSerializer());
		//enum
		registerSerializer(new VjoEnumSerializer());
		//java bean
		registerSerializer(new VjoBeanSerializer());
		//arrays
		registerSerializer(new VjoArraySerializer());
		//@see AVjoSerializable
		registerSerializer(new VjoSerializableSerializer());
		//map
		registerSerializer(new VjoMapSerializer());
		//list
		registerSerializer(new VjoListSerializer());
		//set
		registerSerializer(new VjoSetSerializer());
	}
	
	private void registerSerializer(VjoAbstractSerializer ser){
		ser.setOwner(this);
		m_serializerList.add(ser);
	}
	
	public String getVjoDataRegistry(){
		return m_dataRegistry;
	}
	
	public VjoSerializer setVjoDataRegistry(String dR){
		if(dR == null){
			DsfExceptionHelper.chuck("can't use a null data registry value");
		}
		m_dataRegistry = dR;
		return this;
	}
	
	public String getVjoDataRegistryLocal(){
		return m_dataRegistryLocal;
	}
	
	public VjoSerializer setVjoDataRegistryLocal(String dRLocal){
		if(dRLocal == null){
			DsfExceptionHelper.chuck("can't use a null local data registry value");
		}
		m_dataRegistryLocal = dRLocal;
		return this;
	}
	
	/*
	 * getters & setters for hashmap/arraylist/hashset util
	 */
	
	public String getVjoHashMapUtil(){
		return m_hashMapUtil;
	}
	
	public VjoSerializer setVjoHashMapUtil(String mU){
		if(mU == null){
			DsfExceptionHelper.chuck("can't use a null hashmap util value");
		}
		m_hashMapUtil = mU;
		return this;
	}
	
	public String getVjoHashMapUtilLocal(){
		return m_hashMapUtilLocal;
	}
	
	public VjoSerializer setVjoHashMapUtilLocal(String mULocal){
		if(mULocal == null){
			DsfExceptionHelper.chuck("can't use a null local hashmap util value");
		}
		m_hashMapUtilLocal = mULocal;
		return this;
	}
	
	public String getVjoHashMapUtilCreate(){
		return m_hashMapUtilCreate;
	}
	
	public VjoSerializer setVjoHashMapUtilCreate(String mUCreate){
		if(mUCreate == null){
			DsfExceptionHelper.chuck("can't use a null hashmap util create value");
		}
		m_hashMapUtilCreate = mUCreate;
		return this;
	}
	
	public String getVjoArrayListUtil(){
		return m_arrayListUtil;
	}
	
	public VjoSerializer setVjoArrayListUtil(String lU){
		if(lU == null){
			DsfExceptionHelper.chuck("can't use a null arraylist util value");
		}
		m_arrayListUtil = lU;
		return this;
	}
	
	public String getVjoArrayListUtilLocal(){
		return m_arrayListUtilLocal;
	}
	
	public VjoSerializer setVjoArrayListUtilLocal(String lULocal){
		if(lULocal == null){
			DsfExceptionHelper.chuck("can't use a null local arraylist util value");
		}
		m_arrayListUtilLocal = lULocal;
		return this;
	}
	
	public String getVjoArrayListUtilCreate(){
		return m_arrayListUtilCreate;
	}
	
	public VjoSerializer setVjoArrayListUtilCreate(String lUCreate){
		if(lUCreate == null){
			DsfExceptionHelper.chuck("can't use a null arraylist util create value");
		}
		m_arrayListUtilCreate = lUCreate;
		return this;
	}
	
	public String getVjoHashSetUtil(){
		return m_hashSetUtil;
	}
	
	public VjoSerializer setVjoHashSetUtil(String sU){
		if(sU == null){
			DsfExceptionHelper.chuck("can't use a null hashset util value");
		}
		m_hashSetUtil = sU;
		return this;
	}
	
	public String getVjoHashSetUtilLocal(){
		return m_hashSetUtilLocal;
	}
	
	public VjoSerializer setVjoHashSetUtilLocal(String sULocal){
		if(sULocal == null){
			DsfExceptionHelper.chuck("can't use a null local hashset util value");
		}
		m_hashSetUtilLocal = sULocal;
		return this;
	}
	
	public String getVjoHashSetUtilCreate(){
		return m_hashSetUtilCreate;
	}
	
	public VjoSerializer setVjoHashSetUtilCreate(String sUCreate){
		if(sUCreate == null){
			DsfExceptionHelper.chuck("can't use a null hashset util create value");
		}
		m_hashSetUtilCreate = sUCreate;
		return this;
	}
	
	/**
	 * @see IVjoSerializer
	 * satisfying the IVjoSerializer interface
	 */
	public boolean canSerialize(Object toSer){
		return true;
	}
	
	/**
	 * 
	 * helper methods generating the data registry init block
	 */
	
	private void appendDataRegistryAssignment(StringBuilder sb){
		appendAssignmentUtil(sb, getVjoDataRegistryLocal(), getVjoDataRegistry());
	}
	
	private void appendMapUtilAssignment(StringBuilder sb){
		appendAssignmentUtil(sb, getVjoHashMapUtilLocal(), toUtilCreateFunction(getVjoHashMapUtil(), getVjoHashMapUtilCreate()));
	}
	
	private void appendListUtilAssignment(StringBuilder sb){
		appendAssignmentUtil(sb, getVjoArrayListUtilLocal(), toUtilCreateFunction(getVjoArrayListUtil(), getVjoArrayListUtilCreate()));
	}
	
	private void appendSetUtilAssignment(StringBuilder sb){
		appendAssignmentUtil(sb, getVjoHashSetUtilLocal(), toUtilCreateFunction(getVjoHashSetUtil(), getVjoHashSetUtilCreate()));
	}
	
	private void appendAssignmentUtil(StringBuilder sb, String target, String source){
		sb.append("var ");
		sb.append(target);
		sb.append("=");
		sb.append(source);
		sb.append(";");
	}
	
	private String toUtilCreateFunction(String util, String create){
		final StringBuilder sb = new StringBuilder("function(_data){return ");
		sb.append(util);
		sb.append(".");
		sb.append(create);
		sb.append("(_data);}");
		return sb.toString();
	}
	
	public String toVjo(Object toSer, VjoSerializerOption option){
		return toVjo(toSer, option, "utf-8");
	}
	
	public String toVjo(Object toSer, VjoSerializerOption option, String encoding){
		//reset ctx will clear up the data registry caches both in java & in javascript semantics
		final VjoSerializationCtx ctx = VjoSerializationCtx.ctx();
		if(!VjoSerializerOption.DFEAULT.equals(option)){
			ctx.reset();
		}
		else{
			ctx.setHasVjoList(false);
			ctx.setHasVjoMap(false);
			ctx.setHasVjoSet(false);
		}
		
		if(VjoSerializerOption.DATA_REGISTRY_FREE.equals(option)){
			setVjoDataRegistry(VJO_DATA_REGISTRY_FULL);
		}
		
		ctx.setRegistryScope(getVjoDataRegistryLocal());

		//begin the serialization
		
		Object vjo = null;
		try{
			vjo = serialize(toSer);
		}
		catch(SerializationException ex){
			vjo = null;
		}
		
		//convert result to javascript string
		final StringBuilder sb = new StringBuilder();
		sb.append("(function(){");
		appendDataRegistryAssignment(sb);
		if(ctx.getHasVjoMap()){
			appendMapUtilAssignment(sb);
		}
		if(ctx.getHasVjoList()){
			appendListUtilAssignment(sb);
		}
		if(ctx.getHasVjoSet()){
			appendSetUtilAssignment(sb);
		}
		
		if(!VjoSerializerOption.DFEAULT.equals(option)){
			sb.append("var _2r=");
		}
		else{//immediate return
			sb.append("return ");
		}
		
		sb.append(vjo);
		sb.append(";");
		
		if(!VjoSerializerOption.DFEAULT.equals(option)){//clean data registry before exiting function scope
			if(VjoSerializerOption.RESET_CTX.equals(option)){
				sb.append(getVjoDataRegistryLocal());
				sb.append(".clear();");
			}
			sb.append("return _2r;");
		}
		
		sb.append("})()");
		
		byte[] encodedBytes;
		
		try {
			encodedBytes = sb.toString().getBytes(encoding);
			return new String(encodedBytes, encoding);
		}
		catch (UnsupportedEncodingException e) {
			return sb.toString();
		}
	}
	
	public String toVjo(Object toSer){
		return toVjo(toSer, VjoSerializerOption.DFEAULT);
	}
	
	public String toVjo(Object toSer, String encoding){
		return toVjo(toSer, VjoSerializerOption.DFEAULT, encoding);
	}
	
	@Override
	public Object doSerialize(Object toSer) throws SerializationException{		
		Object json = null;
		//loop to find the dedicated serializer and let it do serialization
		for(IVjoSerializer dedicatedSerializer : m_serializerList){
			if(dedicatedSerializer.canSerialize(toSer)){
				json = dedicatedSerializer.serialize(toSer);
				break;
			}
		}
		return json;
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
