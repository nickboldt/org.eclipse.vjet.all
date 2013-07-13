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
package org.eclipse.vjet.vsf.aggregator.cache;

public class ResourceAggregationControl {

	private static ResourceAggregationControl m_instance;

	public static ResourceAggregationControl getInstance() {
		if(m_instance ==null){
			m_instance = new ResourceAggregationControl();
		}
		return m_instance;
	}

	private boolean m_embedPageJs;
	private boolean m_embedSysJs;
	
	private ResourceAggregationControl(){
		
	}
	
	public void setEmbedPageJs(boolean embed){
		m_embedPageJs = embed;
	}
	
	public void setEmbedSysJs(boolean embed){
		m_embedSysJs = embed;
	}

	public boolean needToEmbedPageJs() {
		return m_embedPageJs;
	}

	public boolean needToEmbedSysJs() {
		return m_embedSysJs;
	}

}
