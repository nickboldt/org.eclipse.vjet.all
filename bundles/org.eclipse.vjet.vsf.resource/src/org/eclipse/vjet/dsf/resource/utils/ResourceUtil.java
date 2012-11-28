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
package org.eclipse.vjet.dsf.resource.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.logger.LogLevel;
import org.eclipse.vjet.dsf.logger.Logger;
import org.eclipse.vjet.dsf.resource.ctx.ResourceProcessCtx;
import org.eclipse.vjet.dsf.resource.x.IResourceAggregationModeResolver.AggregationMode;


public class ResourceUtil {
	public enum BrowserType {
		IE("MSIE", " "),FIREFOX("Firefox"),OPERA("Opera"),CHROME("Chrome"),SAFARI("Safari");
		private String m_name = null;
		private String m_versionSeperator = "/";
		private BrowserType(String name , String seperator){
			m_name = name;
			m_versionSeperator = seperator;
		}
		private BrowserType(String name ){
			m_name = name;
		}
		public String getName(){
			return m_name;
		}
	}
        
        public static URL modify(URL url, AggregationMode mode ){
             return modify ( url, mode, new ResourceProcessCtx());
	}

	public static URL modify(URL url, AggregationMode mode , ResourceProcessCtx resourceProcessCtx) {
		
		boolean isModified = false;
		
		String externalForm = url.toExternalForm();
		
		String paramJoin = externalForm.contains("?") ? "&" : "?";

		if (DsfCtx.ctx().isResourceDebugEnabled()) {
			
			if (externalForm.contains("#")) {
				externalForm = externalForm.replace("#", paramJoin + "hint=");
				paramJoin = "&";
				isModified = true;
			}
			
			// handle spyglass debug mode to skip caching and get pretty print
			if (mode == AggregationMode.DYNAMIC) {
				externalForm = externalForm.replace(".ebaystatic.", ".ebay.");
				String debugParameters = "debug=true&loadMode=2&obfuscate=false&optimize=false";
				externalForm += paramJoin+debugParameters;
				isModified = true;
			}
		}
		
		String userAgent = DsfCtx.ctx().getUserAgent();
		if (userAgent != null && (userAgent.contains("MSIE 6.") || userAgent.contains("BlackBerry")) 
				&& externalForm.contains("#")) {
			externalForm = externalForm.substring(0, externalForm.indexOf("#"));
			isModified = true;
		}
		if ( resourceProcessCtx.isDataUriEnabled() && mode == AggregationMode.DYNAMIC && isDataUriSupported(userAgent)){
			String dataUriParam = paramJoin + "dataUri=true";
			paramJoin = "&";
			int maxRpt = resourceProcessCtx.getDataUriMaxRepeatCount();
			if (maxRpt > 0){
				dataUriParam += "&maxRpt=" + maxRpt;
			}
			
			if (externalForm.contains("#")) {
				externalForm = externalForm.replace("#", dataUriParam + "#");
			} else {
				externalForm += dataUriParam;
			}
			isModified = true;
		}
		
		// modify if cache buster checksums are registered
		// TODO support cache busting mode
		if (mode == AggregationMode.DYNAMIC ) {
			// find hash
			String checksum = extractChecksum(url);
			if (checksum != null) {
				// get version
				// TODO add extension point to allow different version schemes
				int version = 1;
				// add cacheBuster parameter
				if (version >= 0) {
					String cacheBusterParam = paramJoin + "ver="+version;
					paramJoin = "&";
					if (externalForm.contains("#")) {
						externalForm = externalForm.replace("#", cacheBusterParam + "#");
					} else {
						externalForm += cacheBusterParam;
					}
					isModified = true;
				}
			}
		}
		
		
		if (isModified) {
			try {
				return new URL(externalForm);
			} catch (MalformedURLException e) {
				Logger.getInstance(ResourceUtil.class).log(LogLevel.ERROR, "Failed to modify resource URL: " + externalForm, e);
			}
		}
		return url;
	}
	
	public static String extractChecksum(URL url) {
		String path = url.getPath();
		int pos = path.lastIndexOf("/");
		int dotPos = path.indexOf(".");
		if (pos != -1 && dotPos != -1) {
			// find two parts of checksum
			String checksumLastPart = path.substring(pos - 2, pos);
			String checksumFirstPart = path.substring(pos + 1, dotPos);
			// get checksum
			return checksumLastPart + checksumFirstPart;
		}
		return null;
	}

	public static boolean isDataUriSupported(String userAgent){
		if ( isBrowserVersioAbove(userAgent, BrowserType.IE , "8")){
			return true;
		}
		if ( isBrowserVersioAbove(userAgent, BrowserType.FIREFOX , "2")){
			return true;
		}
		if ( isBrowserVersioAbove(userAgent, BrowserType.OPERA , "7.2")){
			return true;
		}
		if ( isBrowserVersioAbove(userAgent, BrowserType.CHROME , null)){
			return true;
		}
		if ( isBrowserVersioAbove(userAgent, BrowserType.SAFARI , null)){
			return true;
		}
		return false;
	}
	public static boolean isBrowserVersioAbove(String userAgent, BrowserType browserType , String version){
		if ( userAgent == null || browserType == null ){
			return false;
		}
		if (version == null){
			version = "0";
		}
		String name = browserType.getName();
		int index = userAgent.indexOf(name);
		
		if( index >= 0 ){
			String sub = userAgent.substring(index + name.length() + 1);
			return isVersionAbove(sub, version);
		}
		
		return false;
	}
	
	public static boolean isVersionAbove(String actualVersion , String expectedVersion){
		
		String aNumberStr = getVersionNumber(actualVersion);
		String eNumberStr = getVersionNumber(expectedVersion);
		
		if ( aNumberStr.length() == 0 || eNumberStr.length() == 0 ){
			return false;
		}
		
		String [] aVersions = aNumberStr.split("\\.");
		String [] eVersions = eNumberStr.split("\\.");
		
		int aLen = aVersions.length;
		int eLen = eVersions.length;
		int minLen = aLen > eLen ? eLen : aLen;
		
		
		
		for ( int i = 0 ; i < minLen ; i ++){
			int aVersionNumber = new Integer(aVersions[i]);
			int eVersionNumber = new Integer(eVersions[i]);
			
			if ( aVersionNumber > eVersionNumber ){
				return true;
			}
			
			if ( aVersionNumber < eVersionNumber ){
				return false;
			}
		}
		if ( aLen < eLen ){
			for ( int i = aLen ; i < eLen ; i ++ ){
				if ( new Integer(eVersions[i]) > 0){
				return false;
				}
			}
		}
		
		return true;
		
	}
	
	public static String getVersionNumber(String version){
		if ( version == null ){
			return ""; 
		}
		int len = version.length();
		
		if (len == 0 ){
			return "";
		}
		
		char c = version.charAt(0);
		if ( c < '0' || c > '9'){
			return "";
		}
		
		int i;
		for(i = 1 ; i < len ; i ++ ){
			c = version.charAt(i);
			if ( ( c < '0' || c > '9') && c != '.' ){
				break;
			}
		}
		
		i = version.charAt(i - 1) == '.' ? i - 1 : i;
		return version.substring(0, i);
	}
	
	
}
