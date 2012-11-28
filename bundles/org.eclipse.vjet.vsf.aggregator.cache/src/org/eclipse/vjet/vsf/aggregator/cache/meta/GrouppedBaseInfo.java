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
package org.eclipse.vjet.vsf.aggregator.cache.meta;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.vjet.dsf.resource.permutation.Permutation;


/**
 * The fallback logic for agg id is permutationLocale map->permutation map->default agg id
 * @author dsemenov
 *
 */
public class GrouppedBaseInfo {
	private String m_nonSecureAggResId;
	private String m_secureAggResId;
	private Map<String, String> m_aggChecksum = new HashMap<String, String>(); // aggResId=>checksum
	
	private Map<String, String> m_permutationSecureAggrId = new LinkedHashMap<String, String>();
	private Map<String, String> m_permutationNonSecureAggrId = new LinkedHashMap<String, String>();
	
	private final String m_index;
	private String m_relativePath;
	private String m_optimizedPath;
	private String m_viewId;
	private GrouppedBaseInfo m_parentGroup;
	private boolean m_languageSpecific;
	
	GrouppedBaseInfo(String index) {
		m_index = index;
	}
	
	public void addAggChecksum(String aggResId, String checksum) {
		m_aggChecksum.put(aggResId, checksum);
	}
	
	public String getAggChecksum(String aggResId) {
		return m_aggChecksum.get(aggResId);
	}
	
	public Map<String, String> getAggChecksums() {
		return m_aggChecksum;
	}
	
	public String getNonSecureAggResId() {
		return m_nonSecureAggResId;
	}

	public String getSecureAggResId() {
		return getSecureAggResId(true);
	}

	public String getSecureAggResId(boolean fallback) {
		if (m_secureAggResId == null && fallback) {
			return getNonSecureAggResId();
		}
		return m_secureAggResId;
	}


	public void setSecureAggResId(String aggResId) {
		m_secureAggResId = aggResId;
	}

	public void setNonSecureAggResId(String aggResId) {
		m_nonSecureAggResId = aggResId;
	}
	
	public Map<String, String> getAllSecureAggResId(){
		return m_permutationSecureAggrId;
	}
	
	public boolean isLanguageSpecific() {
		return m_languageSpecific;
	}
	
	public String getSecureAggResId(Permutation permutation){

		String aggResId = m_permutationSecureAggrId.get(permutation.toExternal());
		if (aggResId != null) {
			return aggResId;
		}
		else {
			aggResId = m_permutationNonSecureAggrId.get(permutation.toExternal());
			if (aggResId != null) {
				return aggResId;
			}
		}
		
		if (permutation.isExtended()) {
			aggResId = getSecureAggResId(permutation.getParent());
		}
		
		if (aggResId == null) {
			aggResId = getSecureAggResId();
		}
		
		return aggResId;
	}
	
	public Map<String, String> getAllNonSecureAggResId(){
		return m_permutationNonSecureAggrId;
	}
	
	public String getNonSecureAggResId(Permutation permutation){
		String aggResId = m_permutationNonSecureAggrId.get(permutation.toExternal());
		if (aggResId != null) {
			return aggResId;
		}
		
		if (permutation.isExtended()) {
			aggResId = getNonSecureAggResId(permutation.getParent());
		}
		
		if (aggResId == null) {
			aggResId = getNonSecureAggResId();
		}
		
		return aggResId;
	}
	
	public boolean addSecureAggResid(String key, String aggId){
		if (Permutation.isLanguageSpecific(key)) {
			m_languageSpecific = true;
		}
		
		if (containsSecureAggResId(key, aggId)) {
			return false;
		}
		
		if (getSecureAggResId() == null) {
			setSecureAggResId(aggId);
			return true;
		}
		
		String oldValue = m_permutationSecureAggrId.get(key);
		if (oldValue == null || !aggId.equals(oldValue)) {
			m_permutationSecureAggrId.put(key, aggId);
			return true;
		}
		
		return false;
	}
	
	public boolean addSecureAggResid(Permutation permutation, String aggId){
		return addSecureAggResid(permutation.toExternal(), aggId);
		
	}

	public void registerPermutation(Permutation permutation) {
		if (permutation.isLanguageSpecific()) {
			m_languageSpecific = true;
		}
	}
	
	/**
	 * 
	 * @param key
	 * @param aggId
	 * @return false when aggId is already available via fallback chain
	 */
	public boolean addNonSecureAggResid(String key, String aggId){
		if (Permutation.isLanguageSpecific(key)) {
			m_languageSpecific = true;
		}
		if (getNonSecureAggResId() == null) {
			setNonSecureAggResId(aggId);
			return true;
		}
		else if (aggId.equals(getNonSecureAggResId())) {
			return false;
		}
		
		String oldValue = m_permutationNonSecureAggrId.get(key);
		if (oldValue == null || !aggId.equals(oldValue)) {
			m_permutationNonSecureAggrId.put(key, aggId);
			return true;
		}
		
		return false;
	}

	/**
	 * 
	 * @param key
	 * @param aggId
	 * @return true when aggId is already available via fallback chain
	 */
	public boolean containsNonSecureAggResId(String key, String aggId){
		return aggId.equals(getNonSecureAggResId())
			|| aggId.equals(m_permutationNonSecureAggrId.get(key))
		;
	}

	/**
	 * 
	 * @param key
	 * @param aggId
	 * @return true when aggId is already available via fallback chain
	 */
	public boolean containsSecureAggResId(String key, String aggId){
		return aggId.equals(m_permutationSecureAggrId.get(key))
			|| aggId.equals(getSecureAggResId())
			|| containsNonSecureAggResId(key, aggId)
		;
	}

	public void addNonSecureAggResid(Permutation permutation, String aggId){
		addNonSecureAggResid(permutation.toExternal(), aggId);
	}

	public String getIndex() {
		return m_index;
	}
	
	public String getRelativePath() {
		return m_relativePath;
	}
	
	public void setRelativePath(final String relativePath) {
		m_relativePath = relativePath;
	}
	
	public String getOptimizedPath() {
		return m_optimizedPath;
	}

	public void setOptimizedPath(String optimizedPath) {
		m_optimizedPath = optimizedPath;
	}
	
	public GrouppedBaseInfo getParentGroup(){
		return m_parentGroup;
	}
	
	public void setParentGroup(GrouppedBaseInfo parentGroup){
		m_parentGroup = parentGroup;
	}
	
	public String getViewId(){
		return m_viewId;
	}
	
	public void setViewId(String viewId){
		m_viewId = viewId;
	}

}
