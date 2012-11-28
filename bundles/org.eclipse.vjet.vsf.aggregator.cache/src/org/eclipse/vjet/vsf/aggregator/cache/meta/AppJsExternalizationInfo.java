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

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.eclipse.vjet.dsf.resource.permutation.Permutation;
import org.eclipse.vjet.dsf.resource.permutation.PermutationSpec;
import org.eclipse.vjet.vsf.aggregator.cache.meta.ViewJsExternalizationInfo.GrouppedJsInfo;

/**
 * This class holds the meta info for all externalized js resources for a given
 * app spec.
 * 
 * It can be externalized to XML and parsed back from the XML
 * using JsExternalizationInfoBuilder.
 */
public class AppJsExternalizationInfo implements IExternalizationInfo{

	private String m_appId;
	private String m_buildId;
	private Map<String, ViewJsExternalizationInfo> m_viewJsInfos = 
		new LinkedHashMap<String, ViewJsExternalizationInfo>();
	private long m_changeSetId;

	public AppJsExternalizationInfo(final String appId, final String buildId) {
		m_appId = appId;
		m_buildId = buildId;
	}
	
	public String getAppId() {
		return m_appId;
	}
	
	public String getBuildId() {
		return m_buildId;
	}
	
	public Collection<ViewJsExternalizationInfo> getAllViewJsInfos() {
		return m_viewJsInfos.values();
	}
	
	public Collection<String> getAllViewIds() {
		return m_viewJsInfos.keySet();
	}
	
	public ViewJsExternalizationInfo getViewJsInfo(final String viewId) {
		return m_viewJsInfos.get(viewId);
	}
	
	public void addViewJsInfo(final ViewJsExternalizationInfo viewJsInfo) {
		m_viewJsInfos.put(viewJsInfo.getViewId(), viewJsInfo);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(200);
		sb.append("appId=").append(m_appId).append("\n");
		sb.append("buildId=").append(m_buildId).append("\n");

		for (ViewJsExternalizationInfo info : getAllViewJsInfos()) {
			sb.append(info.toString()).append("\n");
		}
		return sb.toString();
	}

	@Override
	public void updateAggregationId(String viewId, String slotIndex, Permutation permutation,
			boolean isSecure, String resAggId, String aggChecksum) 
	{
		String locale = permutation.getLocale().toString();
		Collection<ViewJsExternalizationInfo> allJsInfo = getAllViewJsInfos();
		for(ViewJsExternalizationInfo jsInfo: allJsInfo){
			if (!jsInfo.getViewId().equals(viewId)) { 
				continue;
			}
			
			Map<String, GrouppedJsInfo> localeGrouppedJsInfo = jsInfo.getLocaleGrouppedJsInfo().get(locale);
			if (localeGrouppedJsInfo != null 
					&& localeGrouppedJsInfo.get(slotIndex) != null) {
				
				GrouppedJsInfo info = localeGrouppedJsInfo.get(slotIndex);
				info.addAggChecksum(resAggId, aggChecksum);

				info.addAggChecksum(resAggId, aggChecksum);
				if(isSecure){
					info.setSecureAggResId(resAggId);
				}else{
					info.setNonSecureAggResId(resAggId);
				}
			}
			else {

				Collection<GrouppedJsInfo> defaultGroupJsInfo = jsInfo.getAllGrouppedJsInfo();
				for(GrouppedJsInfo info: defaultGroupJsInfo){
					info.addAggChecksum(resAggId, aggChecksum);
					info.registerPermutation(permutation);
					if(info.getIndex().equals(slotIndex)){
						if(isSecure){
							if (info.getSecureAggResId() == null) {
								info.setSecureAggResId(resAggId);
								continue;
							}
							if (resAggId.equals(info.getSecureAggResId())) {
								continue;
							}
							info.addSecureAggResid(permutation, resAggId);
						}else{
							if (info.getNonSecureAggResId() == null) {
								info.setNonSecureAggResId(resAggId);
								continue;
							}
							if (resAggId.equals(info.getNonSecureAggResId())) {
								continue;
							}
							info.addNonSecureAggResid(permutation, resAggId);
						}
					}
				}
			}
			
		}
	}
	
	@Override
	public boolean validate() {
		return true;
	}
	
	@Override
	public Collection<AggregationInfo> getAggregationInfo(String viewId) {

		List<AggregationInfo> result = new ArrayList<AggregationInfo>();
		
		String defaultLocale = getDefaultLocale();
		
		ViewJsExternalizationInfo jsInfo = getViewJsInfo(viewId);
		if (jsInfo == null) {
			return result;
		}

		Collection<GrouppedJsInfo> defaultGroupJsInfo = jsInfo.getAllGrouppedJsInfo();
		for(GrouppedJsInfo info: defaultGroupJsInfo){
			AggregationInfo aggInfo = createAggregationInfo(info, defaultLocale);
			result.add(aggInfo);
		}

		Set<String> locales = jsInfo.getLocales();
		for(String locale: locales){
			Collection<GrouppedJsInfo> localeGroupJsInfo = jsInfo.getAllGrouppedJsInfo(locale);
			if(localeGroupJsInfo == null){
				continue;
			}
			
			for(GrouppedJsInfo info: localeGroupJsInfo){
				AggregationInfo localeAggInfo = createAggregationInfo(info, locale);
				result.add(localeAggInfo);
			}
		}
		
		return result;
	}
	
	private String getDefaultLocale(){
		String defaultLocale = Locale.US.toString();
		PermutationSpec spec = Permutation.getPermutationSpec();
		if(spec != null && spec.getDefaultPermutation() != null){
			defaultLocale = spec.getDefaultPermutation().getLocale().toString();
		}
		return defaultLocale;
	}
	
	private AggregationInfo createAggregationInfo(GrouppedJsInfo group, String locale){
		List<String> urns = group.getResolvedUrns();
		AggregationInfo result = new AggregationInfo();
		result.addAllUrns(urns);
		result.setLocale(locale);
		return result;
	}

	public void setChangeSetId(long changeSetId) {
		m_changeSetId = changeSetId;
	}

	public long getChangeSetId() {
		return m_changeSetId;
	}

}
