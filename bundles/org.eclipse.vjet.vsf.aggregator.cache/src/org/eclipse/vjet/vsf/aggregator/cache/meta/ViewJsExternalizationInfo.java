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
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.vjet.dsf.resource.slot.ExternalizedSlotGrouping;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotter;

/**
 * This class holds the meta info for all externalized js resources
 * for a given view spec. There are sub-groups contributted from sub-set
 * of js slots based on slot to sub-groupping mapping - ExternalizedSlotGroupping.
 */
public class ViewJsExternalizationInfo {

	private final String m_viewId;
	private Map<String, GrouppedJsInfo> m_grouppedJsInfoMap = 
		new LinkedHashMap<String, GrouppedJsInfo>(4);
	private ExternalizedSlotGrouping m_slotGroupping;
	private Map<String, Map<String, GrouppedJsInfo>> m_localeGrouppedJsInfoMap = new LinkedHashMap<String, Map<String, GrouppedJsInfo>>(
			2);
	
	private JsResourceSlotter m_slotter;  // app js opt added for accessing slotter in opt pass
	private Set<String> m_locales = new LinkedHashSet<String>();;
	public ViewJsExternalizationInfo(String viewId) {
		this.m_viewId = viewId;
	}
	
	public void setSlotter(JsResourceSlotter slotter){
		m_slotter = slotter;
	}
	
	public JsResourceSlotter getSlotter(){
		return m_slotter;
	}
	
	public String getViewId() {
		return m_viewId;
	}
	
	public ExternalizedSlotGrouping getSlotGroupping() {
		return m_slotGroupping;
	}
	
	public void setSlotMapping(final ExternalizedSlotGrouping groupping) {
		m_slotGroupping = groupping;
	}
	
	public Collection<GrouppedJsInfo> getAllGrouppedJsInfo() {
		return m_grouppedJsInfoMap.values();
	}

	public Map<String, Map<String, GrouppedJsInfo>>  getLocaleGrouppedJsInfo() {
		return m_localeGrouppedJsInfoMap;
	}
	
	public synchronized GrouppedJsInfo getGrouppedJsInfo(
		final String groupIndex)
	{
		GrouppedJsInfo info = m_grouppedJsInfoMap.get(groupIndex);
		if (info == null) {
			info = new GrouppedJsInfo(groupIndex);
			info.setViewId(m_viewId);
			m_grouppedJsInfoMap.put(groupIndex, info);
		}
		return info;
	}

	private static Collection<GrouppedJsInfo> EMPTY_GROUPED_JS_INFO_COLLECTION 
	= (Collections.unmodifiableList(
			new ArrayList<GrouppedJsInfo>(0)));
	
	public Collection<GrouppedJsInfo> getAllGrouppedJsInfo(final String locale) {
		if(getLocales().contains(locale)){
			return m_localeGrouppedJsInfoMap.get(locale).values();
		}
		return EMPTY_GROUPED_JS_INFO_COLLECTION;
	}
	
	public synchronized GrouppedJsInfo getGrouppedJsInfo(
			final String groupIndex, final String locale)
	{
		Map<String, GrouppedJsInfo> map = m_localeGrouppedJsInfoMap.get(locale);
		if (map == null) {
			map = new LinkedHashMap<String, GrouppedJsInfo>();
			m_locales.add(locale);
			m_localeGrouppedJsInfoMap.put(locale, map);
		} 
		GrouppedJsInfo info = map.get(groupIndex);
		if(info==null){
			info = new GrouppedJsInfo(groupIndex);
			info.setViewId(m_viewId);
			map.put(groupIndex, info);
		}
		return info;
	}

	public Set<String> getLocales(){
		return m_locales;
	}
	
	public synchronized boolean removeGrouppedJsInfo(
			final String groupIndex, final String locale)
	{
		if ( m_localeGrouppedJsInfoMap.get(locale).remove(groupIndex) != null)
			return true;
		
		return false;
	}
	
	public synchronized boolean removeGrouppedJsInfo(
			final String groupIndex)
	{
		if ( m_grouppedJsInfoMap.remove(groupIndex) != null)
			return true;
		
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(300);
		sb.append(" viewId=").append(m_viewId).append("\n");	
		sb.append(m_slotGroupping.toString());
		//default
		for (GrouppedJsInfo grouppedInfo : getAllGrouppedJsInfo()) {
			sb.append(grouppedInfo.toString()).append("\n");
		}
		//locale
		for(String locale : m_locales){
			sb.append("locale=").append(locale).append("\n");
			for (GrouppedJsInfo grouppedInfo : getAllGrouppedJsInfo(locale)) {
				sb.append(grouppedInfo.toString()).append("\n");
			}
		}

		return sb.toString();
	}
	
	public static class GrouppedJsInfo extends GrouppedBaseInfo {
		private String m_md5;
		private List<String> m_jsResourceUrns = new ArrayList<String>();
		private Map<String, String> m_jsResourceSizes = new HashMap<String, String>();
		private Map<String, MARKER> m_jsResourceUrnMarkers = new HashMap<String, MARKER>();
		private String m_resourceSize = "0";
		public enum MARKER {INCLUDE, EXCLUDE};
		private boolean m_isEmpty = true; //This flag will provide whether js file was generated or not. It'll be set when js file was generated.

		GrouppedJsInfo(String index) {
			super(index);
		}
		
		
		public List<String> getAllJsResourceUrns() {
			return m_jsResourceUrns;
		}
		
		public List<String> getResolvedUrns(){
			GrouppedJsInfo parent = (GrouppedJsInfo)getParentGroup();
			List<String> result = new ArrayList<String>();
			if(parent != null){
				List<String> parentUrns = parent.getResolvedUrns();
				result.addAll(parentUrns);
			}

			for(String urn: m_jsResourceUrns){
				MARKER marker = m_jsResourceUrnMarkers.get(urn);
				if(marker == MARKER.EXCLUDE){
					result.remove(urn);
				}else{
					result.add(urn);
				}
			}
			
			return result;
		}
		
		
		public void addJsResourceUrn(final String jsResourceUrn) {
			m_jsResourceUrns.add(jsResourceUrn);
			m_jsResourceUrnMarkers.put(jsResourceUrn, MARKER.INCLUDE);
		}

		public void addJsResourceUrn(final String jsResourceUrn,MARKER marker) {
			m_jsResourceUrns.add(jsResourceUrn);
			m_jsResourceUrnMarkers.put(jsResourceUrn, marker);
		}

		public MARKER getJsResourceUrnMarker(final String jsResourceUrn) {
			return m_jsResourceUrnMarkers.get(jsResourceUrn);
		}
		
		public void addJsResourceSize(final String jsResourceUrn, final String jsResourceSize) {
			//calculate total resources size in a view.
//			try {
//				if(m_jsResourceSizes.get(jsResourceUrn)==null){
//					int resSize = Integer.parseInt(getResourceSize());
//					resSize += Integer.parseInt(jsResourceSize);
//					setResourceSize(resSize+"");
//				}
//			} catch (Exception e) {
//				//ignore exception
//			}
			m_jsResourceSizes.put(jsResourceUrn, jsResourceSize);
		}

		public Map<String, String> getAllJsResourceSizes() {
			return m_jsResourceSizes;
		}

		public String getJsResourceSize(final String jsResourceUrn) {
			if(m_jsResourceSizes.get(jsResourceUrn)!=null){
				return m_jsResourceSizes.get(jsResourceUrn);
			}
			return "0";
		}

		public void removeJsResourceUrn(final String jsResourceUrn) {
			m_jsResourceUrns.remove(jsResourceUrn);
			m_jsResourceUrnMarkers.remove(jsResourceUrn);
		}
		
		public boolean contains(final String urn) {
			return m_jsResourceUrns.contains(urn);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(100);
			sb.append("  slotIndex=").append(getIndex()).append("\n");
			sb.append("   path=").append(getRelativePath()).append("\n");
			sb.append("   opath=").append(getOptimizedPath()).append("\n");
			boolean notFirst = false;
			for (String urn : m_jsResourceUrns) {
				if (notFirst) {
					sb.append(" | "); 
				}
				else {
					sb.append("   ");
					notFirst = true;
				}
				sb.append(urn);
				sb.append("   ");
				sb.append(m_jsResourceUrnMarkers.get(urn));
			}
			sb.append("\n");
			return sb.toString();
		}

		public String getMd5() {
			return m_md5;
		}

		public void setMd5(String md5) {
			this.m_md5 = md5;
		}

		public String getResourceSize() {
			if(!"0".equals(m_resourceSize)){
				return m_resourceSize;
			}else{
				int resSize = 0;
				for(String size : m_jsResourceSizes.values()){
					try {
						resSize += Integer.parseInt(size);
					} catch (Exception e) {
						//ignore exception 
					}
				}
				return resSize+"";
			}
		}

		public void setResourceSize(String size) {
			m_resourceSize = size;
		}

		public boolean isEmpty() {
			return m_isEmpty;
		}

		public void setEmpty(boolean empty) {
			m_isEmpty = empty;
		}
	}
}
