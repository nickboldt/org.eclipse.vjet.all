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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.logger.LogLevel;
import org.eclipse.vjet.dsf.logger.Logger;
import org.eclipse.vjet.dsf.resource.slot.ExternalizedSlotGrouping;
import org.eclipse.vjet.vsf.aggregator.cache.meta.ViewJsExternalizationInfo.GrouppedJsInfo;
import org.eclipse.vjet.vsf.aggregator.cache.meta.ViewJsExternalizationInfo.GrouppedJsInfo.MARKER;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * This utility class is used for externalizing AppJsExternalizationInfo
 * into XML and/or parsing back the object from the XML.
 */
public class JsExternalizationInfoBuilder extends BaseExternalizationInfoBuilder {

	private static final String SLOT_TAG = "Slot";
	private static final String MAPPING_TAG = "Mapping";
	private static final String INDEX_ATTR = "group";
	private static final String SLOT_ATTR = "slot";
	private static Logger s_logger;
	public static String buildXml(final AppJsExternalizationInfo appJsInfo) {
		
		final StringBuilder sb = new StringBuilder();
		addDocument(sb);
		openStartTag(APP_TAG, sb);
		addAttribute(ID_ATTR, appJsInfo.getAppId(), sb);
		addAttribute(BUILD_ID_ATTR, appJsInfo.getBuildId(), sb);
		closeStartTag(sb, true);
		
		for (ViewJsExternalizationInfo viewJsInfo 
			: appJsInfo.getAllViewJsInfos()) {
			openStartTag(VIEW_TAG, sb);
			addAttribute(ID_ATTR, viewJsInfo.getViewId(), sb);
			closeStartTag(sb, true);
			
			for (Map.Entry<String, String> entry : viewJsInfo.getSlotGroupping().getAllMappings().entrySet()) {
				openStartTag(MAPPING_TAG, sb);
				addAttribute(SLOT_ATTR, entry.getKey(), sb);
				addAttribute(INDEX_ATTR, entry.getValue(), sb);
				closeFullTag(sb, true);
			}
			
			writeUrns(viewJsInfo.getAllGrouppedJsInfo(), sb);

			//Locale specific
			for(String locale : viewJsInfo.getLocales()){
				openStartTag(LOCALE_TAG, sb);
				addAttribute(NAME_ATTR, locale, sb);
				closeStartTag(sb, true);
				writeUrns(viewJsInfo.getAllGrouppedJsInfo(locale),sb);
				endTag(LOCALE_TAG, sb);
			}	
			
			endTag(VIEW_TAG, sb);
		}
				
		endTag(APP_TAG, sb);
		return sb.toString();
	}
	
	private static void writeUrns(Collection<GrouppedJsInfo> group, StringBuilder sb){
		for (GrouppedJsInfo slotJsInfo : group) {
			openStartTag(SLOT_TAG, sb);
			addAttribute(INDEX_ATTR, slotJsInfo.getIndex(), sb);
			addAttribute(PATH_ATTR, slotJsInfo.getRelativePath(), sb);
			addAttribute(OPTIMIZED_PATH_ATTR, slotJsInfo.getOptimizedPath(), sb);
			addAttribute(MD5_ATTR,slotJsInfo.getMd5(),sb);
			addAttribute(SIZE_ATTR,slotJsInfo.getResourceSize(),sb);
			closeStartTag(sb, true);
			
			for (String urn : slotJsInfo.getAllJsResourceUrns()) {
				openStartTag(REF_TAG, sb);
				addAttribute(URN_ATTR, urn, sb);
				String size = slotJsInfo.getJsResourceSize(urn);
				addAttribute(SIZE_ATTR, size, sb);
				MARKER marker = slotJsInfo.getJsResourceUrnMarker(urn); 
				if(MARKER.EXCLUDE.equals(marker)){
					addAttribute(MARKER_ATTR, MARKER.EXCLUDE.toString(),sb);
				}
				closeFullTag(sb, true);
			}
			endTag(SLOT_TAG, sb);
		}
	}

	public static AppJsExternalizationInfo parse(final InputStream is) {
		JsInfoSaxHandler handler = new JsInfoSaxHandler();
		
		try {
			final SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			parser.parse(is, handler);
		} 
		catch (Exception e) {
			throw new DsfRuntimeException(e);
		}
		
		return handler.getAppJsInfo();
	}
	
	public static AppJsExternalizationInfo parse(final byte[] data) {
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		return parse(bais);
	}
	
	private static class JsInfoSaxHandler extends DefaultHandler {
		
		private AppJsExternalizationInfo m_appJsInfo;
		private ViewJsExternalizationInfo m_viewJsInfo;
		private GrouppedJsInfo m_slottedJsInfo;
		private String m_locale;
		
		AppJsExternalizationInfo getAppJsInfo() {
			return m_appJsInfo;
		}

		@Override
		public void startElement(
			final String uri, 
			final String localName,
			final String qName, 
			final Attributes attributes) throws SAXException
		{
			super.startElement(uri, localName, qName, attributes);

			if (REF_TAG.equals(qName)) {
				if (m_slottedJsInfo == null) {
					throw new DsfRuntimeException("Missing parent " + SLOT_TAG + " element");
				}
				String urn = getAttribute(URN_ATTR, attributes, REF_TAG);
				//check marker attribute
				if(attributes.getIndex(MARKER_ATTR)!=-1){
					String marker = getAttribute(MARKER_ATTR, attributes, REF_TAG);
					if(MARKER.EXCLUDE.toString().equals(marker)){
						m_slottedJsInfo.addJsResourceUrn(urn,MARKER.EXCLUDE);
					}
				}else{
					m_slottedJsInfo.addJsResourceUrn(urn);
				}
				//check for SIZE_ATTR existance
				if(attributes.getIndex(SIZE_ATTR)!=-1){
					String size = getAttribute(SIZE_ATTR, attributes, REF_TAG);
					m_slottedJsInfo.addJsResourceSize(urn,size);
				}
			}
			
			if (SLOT_TAG.equals(qName)) {
				if (m_viewJsInfo == null) {
					throw new DsfRuntimeException("Missing parent " + VIEW_TAG + " element");
				}
				String index = getAttribute(INDEX_ATTR, attributes, SLOT_TAG);
				if(m_locale==null){
					m_slottedJsInfo = m_viewJsInfo.getGrouppedJsInfo(index);
				}else{
					m_slottedJsInfo = m_viewJsInfo.getGrouppedJsInfo(index,m_locale);
				}
				String path = getAttribute(PATH_ATTR, attributes, SLOT_TAG);
				m_slottedJsInfo.setRelativePath(path);
				try {
					String oPath = getAttribute(OPTIMIZED_PATH_ATTR, attributes, SLOT_TAG);
					m_slottedJsInfo.setOptimizedPath(oPath);
					String md5 = getAttribute(MD5_ATTR, attributes, SLOT_TAG);
					m_slottedJsInfo.setMd5(md5);
					//check for SIZE_ATTR existance
					if(attributes.getIndex(SIZE_ATTR)!=-1){
						String size = getAttribute(SIZE_ATTR, attributes, SLOT_TAG);
						m_slottedJsInfo.setResourceSize(size);
					}
					
				} catch (Exception e) {
					//Should be backwards compatible
					//opath and md5 attributes were added
					getLogger().log(LogLevel.WARN,"md5 or opath not defined");
				}
				
			}
			else if (MAPPING_TAG.equals(qName)) {
				if (m_viewJsInfo == null) {
					throw new DsfRuntimeException("Missing parent " + APP_TAG + " element");
				}
				String slotName = getAttribute(SLOT_ATTR, attributes, MAPPING_TAG);
				String index = getAttribute(INDEX_ATTR, attributes, MAPPING_TAG);
				m_viewJsInfo.getSlotGroupping().put(slotName, index);
			}
			else if (VIEW_TAG.equals(qName)) {
				if (m_appJsInfo == null) {
					throw new DsfRuntimeException("Missing parent " + APP_TAG + " element");
				}
				String id = getAttribute(ID_ATTR, attributes, VIEW_TAG);			
				m_viewJsInfo = new ViewJsExternalizationInfo(id);
				m_viewJsInfo.setSlotMapping(new ExternalizedSlotGrouping());
				m_appJsInfo.addViewJsInfo(m_viewJsInfo);
			}
			else if (APP_TAG.equals(qName)) {
				String id = getAttribute(ID_ATTR, attributes, APP_TAG);
				String buildId = getAttribute(BUILD_ID_ATTR, attributes, APP_TAG);
				m_appJsInfo = new AppJsExternalizationInfo(id, buildId);
			}
			else if (LOCALE_TAG.equals(qName)) {
				m_locale = getAttribute(NAME_ATTR, attributes, MAPPING_TAG);
			}
		}

		@Override
		public void endElement(
			final String uri, 
			final String localName, 
			final String qName) throws SAXException
		{
			super.endElement(uri, localName, qName);
			
			if (VIEW_TAG.equals(qName)) {
				m_viewJsInfo = null;
			}
			else if (SLOT_TAG.equals(qName)) {
				m_slottedJsInfo = null;
			}
		}		
	}
	
	private static Logger getLogger(){
		if (s_logger != null){
			return s_logger;
		}
		
		s_logger = Logger.getInstance(JsExternalizationInfoBuilder.class);
		return s_logger;
	}
}
