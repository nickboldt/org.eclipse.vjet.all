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
package org.eclipse.vjet.vsf.docprocessing;

import org.eclipse.vjet.dsf.dom.DDocument;
import org.eclipse.vjet.dsf.html.dom.DHead;
import org.eclipse.vjet.dsf.html.dom.DHtmlDocument;
import org.eclipse.vjet.dsf.html.dom.DScript;

public class BaseSiteSpeedDocModifier implements IDocModifier {

	public static final String NAME = "oGaugeInfo";
	protected static final String TOKEN = "#URL#";
	protected static final String JS_STRING_CORE = "var " + NAME + " = {sUrl:'"
		+ TOKEN + "',iST:(new Date()).getTime()};";
	protected static final String JS_STRING = "var " + NAME + " = {sUrl:'"
		+ TOKEN + "',iST:(new Date()).getTime(),ebox:1};";
	protected String m_url;
	protected boolean m_isCore = true;

	public BaseSiteSpeedDocModifier(String url, boolean isCore) {
		m_url = url;
		m_isCore = isCore;
	}
	
	protected DScript getScript() {
		DScript script = new DScript();
		if ( m_isCore == true )
			script.setHtmlText(JS_STRING_CORE.replace(TOKEN, m_url));
		else
			script.setHtmlText(JS_STRING.replace(TOKEN, m_url));
		return script;
	}
	
	public void modify(DDocument ddoc) {
		if (ddoc instanceof DHtmlDocument) {
		DHtmlDocument doc = (DHtmlDocument)ddoc ;
		DHead head = doc.getHead(); 
		head.insertBefore(getScript(), head.getFirstChild());
	}
	}

	public String getUrl() {
		return m_url;
	}

	public boolean isCore() {
		return m_isCore;
	}
	
}