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
package org.eclipse.vjet.vsf.window.utils;

/**
 * this is an optional string that contains details of which of the standard
 * window features are to be used with the new window. This takes the form of a
 * comma-delimited list. Most of these features require yes or no (1 or 0 is
 * also o.k.) and any of these can be turned on by simply listing the feature
 * (they default to yes). Also, if you don't supply any of the feature
 * arguments, all features with a choice of yes or no are enabled; if you do
 * specify any feature parameters, titlebar and hotkeys still default to yes but
 * all others are no.
 * 
 * @author jearly
 * 
 */

public class JsWindowFeatures {

	private static final String RESIZABLE = "resizable";

	private static final String HEIGHT = "height";
	private static final String WIDTH = "width";
	private static final String LOCATION = "location";
	
	private static final String MENUBAR = "menubar";
	private static final String SCROLLBARS = "scrollbars";
	private static final String STATUS = "status";
	
	private static final String EQUALYES = "=yes";
	private static final String EQUALNO = "=no";
	
	// http://www.devguru.com/Technologies/ecmaScript/quickref/win_open.html
	// default is all of these features are on by default
	private boolean m_resizable = false;
	private boolean m_status = false;
	private boolean m_scrollbars = false;
	private boolean m_menubar = false;
	private boolean m_location = false;
	private boolean m_center = false;
	private int m_height = 0;
	private int m_width = 0;
	
	
	/**
	 * Constructor for opening new window with all window features
	 * set as default.
	 */
	public JsWindowFeatures(int width,int height){
		setHeight(height);
		setWidth(width);
		setLocation(true);
		setStatus(true);
		setMenubar(true);
		setScrollbars(true);
	}
	
	public String createJsWindowFeatures(){
		final StringBuilder jsContent = new StringBuilder();
		
		if(getWidth()!=0){
			jsContent.append(WIDTH + "=" + getWidth());
			addComma(jsContent);
		}
		
		if(getHeight()!=0){
			jsContent.append(HEIGHT + "=" + getHeight());
			addComma(jsContent);
			
		}
		
		if(isLocation()){
			jsContent.append(LOCATION + EQUALYES);
			addComma(jsContent);
		}else{
			jsContent.append(LOCATION + EQUALNO);
			addComma(jsContent);
		}
		
		if(isMenubar()){
			jsContent.append(MENUBAR + EQUALYES);
			addComma(jsContent);
		}else{
			jsContent.append(MENUBAR + EQUALNO);
			addComma(jsContent);
		}
			
		if(isScrollbars()){
			jsContent.append(SCROLLBARS + EQUALYES);
			addComma(jsContent);
		}else{
			jsContent.append(SCROLLBARS + EQUALNO);
			addComma(jsContent);	
		}
			
		if(isResizable()){
			jsContent.append(RESIZABLE + EQUALYES);
			addComma(jsContent);
		}else{
			jsContent.append(RESIZABLE + EQUALNO);
			addComma(jsContent);	
		}
			
		if(!isStatus()){
			jsContent.append(STATUS + EQUALYES);
		}else{
			jsContent.append(STATUS + EQUALNO);
		}
			

//		if(getHeight()!=0){
//			b.append(JsWindowFeaturesEnum..toString()+ "=" + getHeight());
//		}
//		if(getWidth()!=0){
//			b.append(JsWindowFeaturesEnum.WIDTH.toString()+ "=" + getWidth());
//		}
//		
		return jsContent.toString();
	}
	
	private static void addComma(StringBuilder w){
		w.append(",");
	}
	
	public final int getHeight() {
		return m_height;
	}
	public final void setHeight(int height) {
		m_height = height;
	}
	public final boolean isLocation() {
		return m_location;
	}
	public final void setLocation(boolean location) {
		m_location = location;
	}
	public final boolean isMenubar() {
		return m_menubar;
	}
	public final void setMenubar(boolean menubar) {
		m_menubar = menubar;
	}
	public final boolean isResizable() {
		return m_resizable;
	}
	public final void setResizable(boolean resizable) {
		m_resizable = resizable;
	}
	public final boolean isScrollbars() {
		return m_scrollbars;
	}
	public final void setScrollbars(boolean scrollbars) {
		m_scrollbars = scrollbars;
	}
	public final boolean isStatus() {
		return m_status;
	}
	public final void setStatus(boolean status) {
		m_status = status;
	}
	public final int getWidth() {
		return m_width;
	}
	public final void setWidth(int width) {
		m_width = width;
	}
	public final boolean getCenter() {
		return m_center;
	}
	public final void setCenter(boolean center) {
		m_center = center;
	}
	
}
