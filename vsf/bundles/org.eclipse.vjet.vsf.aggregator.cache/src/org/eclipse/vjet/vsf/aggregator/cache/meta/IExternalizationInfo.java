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
import java.util.List;

import org.eclipse.vjet.dsf.resource.permutation.Permutation;


public interface IExternalizationInfo {
	
	Collection<AggregationInfo> getAggregationInfo(String viewId);
	
	void updateAggregationId(String viewId, String slotIndex, Permutation permutation, boolean isSecure, String resAggId, String aggChecksum);
	
	boolean validate();
	
	public static class AggregationInfo{
		private List<String> m_urns = new ArrayList<String>();
		private String m_locale;
		
		public List<String> getUrns(){
			return m_urns;
		}
		
		public String getLocale(){
			return m_locale;
		}
		
		public void addAllUrns(List<String> urns){
			m_urns.addAll(urns);
		}
		
		public void setLocale(String locale){
			m_locale = locale;
		}
	}
}
