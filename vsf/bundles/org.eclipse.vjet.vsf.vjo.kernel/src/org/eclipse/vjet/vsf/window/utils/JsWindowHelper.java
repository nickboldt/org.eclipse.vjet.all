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

import java.net.URL;

import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.html.dom.BaseAttrsHtmlElement;
import org.eclipse.vjet.dsf.html.dom.DA;
import org.eclipse.vjet.dsf.html.events.EventType;
import org.eclipse.vjet.dsf.html.js.IJsFunc;
import org.eclipse.vjet.vsf.jsref.JsFunc;

public class JsWindowHelper {


	private static final String RETURN_FALSE = "return false";

	private static final String _NEW = "_new";

	static final JsWindowFeatures DEFAULT_FEATURES = new JsWindowFeatures(600,
			800);

	/**
	 * Wrapper function to get the JsDefaultFunction wrapping the annotated code
	 * gen js2Java file Can be used by applications to open a window. This
	 * provides more type safety and java tools for using a window.
	 * 
	 * Can be used to attach to multiple objects
	 * 
	 * @param url
	 * @param windowName
	 * @param features
	 * @param replace - replace content in open window with same name
	 * @return
	 */

	public static IJsFunc openWindow(URL url, String windowName,
			JsWindowFeatures features, boolean replace) {
		return VjWindowJsr.open(url.toString(), windowName,
				features.createJsWindowFeatures(), replace, features.getCenter(), features.getWidth(), features.getHeight());
	}

	/**
	 * 
	 * @param url
	 * @param windowName
	 * @param features
	 * @return
	 */
	public static IJsFunc openWindow(URL url, String windowName,
			JsWindowFeatures features) {
		return openWindow(url, windowName, features, false);
	}

	public static IJsFunc openWindow(URL url) {
		return openWindow(url, DsfCtx.ctx().ids().nextJsWindowId(), DEFAULT_FEATURES,
				false);

	}

	/**
	 * Convenience method for opening a window that works for js and non js
	 * Returns the window object NOT false
	 * 
	 * @param url
	 * @param windowName
	 * @param features
	 * @param replace
	 * @param linkText
	 * @return
	 */

	public static DA openWindowWithUrlReturnWindow(URL url, String windowName,
			JsWindowFeatures features, boolean replace, String linkText) {
		DA a = new DA();
		a.setHtmlHref(url.toString());
		a.setHtmlTarget(_NEW);
		// set onclick and return the window object
		// otherwise href will be called.
		a.add(EventType.CLICK,openWindow(url, windowName, features, replace));
		
		a.setHtmlExtTextValue(linkText);
		return a;
	}

	/**
	 * Convenience method for opening a window that works for js and non js
	 * 
	 * @param url
	 * @param windowName
	 * @param features
	 * @param replace
	 * @param linkText
	 * @return
	 */

	public static DA openWindowWithUrl(URL url, String windowName,
			JsWindowFeatures features, boolean replace, String linkText) {
		DA a = new DA();
		a.setHtmlHref(url.toString());
		a.setHtmlTarget(_NEW);
		// set onclick and return false for js off case
		// otherwise href will be called.
		a.add(EventType.CLICK,openWindow(url, windowName, features, replace));
		a.add(EventType.CLICK, RETURN_FALSE);
		
		a.setHtmlExtTextValue(linkText);
		return a;
	}

	/**
	 * Convenience method for opening a window that works for js and non js
	 * 
	 * @param url
	 * @param features
	 * @param linkText
	 * @return
	 */
	public static DA openWindowWithUrl(URL url, JsWindowFeatures features,
			String linkText) {
		return openWindowInternal(url, null, features, false, linkText);

	}

	private static DA openWindowInternal(URL url, String windowName,
			JsWindowFeatures features, boolean replace, String linkText) {
		String winName;

		if (windowName != null) {
			winName = windowName;
		} else {
			winName = DsfCtx.ctx().ids().nextJsWindowId();
		}

		DA a = new DA();
		a.setHtmlHref(url.toString());
		a.setHtmlTarget(_NEW);
		// set onclick and return false for js off case
		// otherwise href will be called. 
		a.add(EventType.CLICK, openWindow(url, winName,
				features, replace)) ;
		a.add(EventType.CLICK, RETURN_FALSE);
		if (linkText != null) {
			a.setHtmlExtTextValue(linkText);
		}

		return a;
	}
	
	private static String getHandlerId(){
		return DsfCtx.ctx().ids().nextJsHandlerId();
	}

	/**
	 * Convenience method for opening a window that works for js and non js does
	 * not add any text to link allowing for more children of the DA.
	 * 
	 * @param url
	 * @param features
	 * @return
	 */
	public static DA openWindowWithUrl(URL url, JsWindowFeatures features) {

		return openWindowInternal(url, null, features, false, null);
	}

	/**
	 * Convenience method for opening a window that works for js and non js
	 * 
	 * @param url
	 * @param linkText
	 * @return
	 */
	public static DA openWindowWithUrl(URL url, String linkText) {

		DA a = new DA();
		a.setHtmlHref(url.toString());
		// set onclick and return false for js off case
		// otherwise href will be called.
		a.add(EventType.CLICK, openWindow(url)) ;
		a.add(EventType.CLICK, RETURN_FALSE);
		a.setHtmlExtTextValue(linkText);
		return a;

	}

	/**
	 * adds onclick to any html element to open a window not recommended for app
	 * managed code
	 * 
	 * @param elem
	 * @param url
	 * @param features
	 */

	public static void openWindowWithUrl(BaseAttrsHtmlElement elem, URL url,
			JsWindowFeatures features) {
		elem.add(EventType.CLICK, openWindow(url, DsfCtx.ctx().ids().nextJsWindowId(),features));
		elem.add(EventType.CLICK, RETURN_FALSE);

	}

	/**
	 * simple implementation add on click with default window features may not
	 * work for every prototype.
	 * 
	 * @param elem
	 * @param url
	 */
	public static void openWindowWithUrl(BaseAttrsHtmlElement elem, URL url) {
		elem.add(EventType.CLICK,openWindow(url, DsfCtx.ctx().ids().nextJsWindowId(),
				DEFAULT_FEATURES));
		elem.add(EventType.CLICK, RETURN_FALSE);

	}

	// ////////////////////////////////////////////////////////////
	/**
	 * Opens a confirmation window
	 * 
	 * @param message
	 * @return
	 */
	public static JsFunc<Boolean> confirmDialog(String message) {
		return VjWindowJsr.confirm(message);
	}

}
