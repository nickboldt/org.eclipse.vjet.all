/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.css.parser;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.Stack;

import org.apache.batik.css.parser.Parser;
import org.eclipse.vjet.dsf.css.dom.impl.DCssCharsetRule;
import org.eclipse.vjet.dsf.css.dom.impl.DCssFontFaceRule;
import org.eclipse.vjet.dsf.css.dom.impl.DCssImportRule;
import org.eclipse.vjet.dsf.css.dom.impl.DCssMediaList;
import org.eclipse.vjet.dsf.css.dom.impl.DCssMediaRule;
import org.eclipse.vjet.dsf.css.dom.impl.DCssPageRule;
import org.eclipse.vjet.dsf.css.dom.impl.DCssProperty;
import org.eclipse.vjet.dsf.css.dom.impl.DCssRule;
import org.eclipse.vjet.dsf.css.dom.impl.DCssRuleList;
import org.eclipse.vjet.dsf.css.dom.impl.DCssStyleDeclaration;
import org.eclipse.vjet.dsf.css.dom.impl.DCssStyleRule;
import org.eclipse.vjet.dsf.css.dom.impl.DCssStyleSheet;
import org.eclipse.vjet.dsf.css.dom.impl.DCssUnknownRule;
import org.eclipse.vjet.dsf.css.dom.impl.DCssValue;
import org.eclipse.vjet.dsf.css.sac.helpers.DParserFactory;
import org.w3c.css.sac.CSSException;
import org.w3c.css.sac.DocumentHandler;
import org.w3c.css.sac.InputSource;
import org.w3c.css.sac.LexicalUnit;
import org.w3c.css.sac.SACMediaList;
import org.w3c.css.sac.SelectorList;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleSheet;

public class DCssBuilder {

	private static final String PARSER = Parser.class.getName();

	private org.w3c.css.sac.Parser m_parser = null;
	private CSSStyleSheet m_parentStyleSheet = null;
//	private DCssRule m_parentRule = null;

	/** Creates new CSSOMParser */
	public DCssBuilder() {
		try {
			setProperty("org.w3c.css.sac.parser", PARSER);
			DParserFactory factory = new DParserFactory();
			m_parser = factory.makeParser();
		} catch (Exception e) {
		}
	}
	
	public CSSStyleSheet parseStyleSheet(String cssText)
		throws IOException {
		InputSource is = new InputSource(new StringReader(cssText));
		return parseStyleSheet(is);
	}

	public CSSStyleSheet parseStyleSheet(InputSource source)
		throws IOException {
		CSSOMHandler handler = new CSSOMHandler();
		m_parser.setDocumentHandler(handler);
		m_parser.parseStyleSheet(source);
		return (DCssStyleSheet) handler.getRoot();
	}

	public CSSStyleDeclaration parseStyleDeclaration(InputSource source)
		throws IOException {
		DCssStyleDeclaration sd = new DCssStyleDeclaration(null);
		parseStyleDeclaration(sd, source);
		return sd;
	}

	public void parseStyleDeclaration(
		CSSStyleDeclaration sd,
		InputSource source)
		throws IOException {
		Stack<Object> nodeStack = new Stack<Object>();
		nodeStack.push(sd);
		CSSOMHandler handler = new CSSOMHandler(nodeStack);
		m_parser.setDocumentHandler(handler);
		m_parser.parseStyleDeclaration(source);
	}

	public DCssValue parsePropertyValue(InputSource source) throws IOException {
		CSSOMHandler handler = new CSSOMHandler();
		m_parser.setDocumentHandler(handler);
		return new DCssValue(m_parser.parsePropertyValue(source));
	}

	public CSSRule parseRule(InputSource source) throws IOException {
		CSSOMHandler handler = new CSSOMHandler();
		m_parser.setDocumentHandler(handler);
		m_parser.parseRule(source);
		return (DCssRule) handler.getRoot();
	}

	public SelectorList parseSelectors(InputSource source) throws IOException {
		// TODO add new handler 
//		HandlerBase handler = new HandlerBase();
//		m_parser.setDocumentHandler(handler);
		return m_parser.parseSelectors(source);
	}

	public void setParentStyleSheet(CSSStyleSheet parentStyleSheet) {
		m_parentStyleSheet = parentStyleSheet;
	}
	
	public CSSStyleSheet getParentStyleSheet() {
		return m_parentStyleSheet;
	}

	public void setParentRule(CSSRule parentRule) {
//		m_parentRule = parentRule;
	}

	class CSSOMHandler implements DocumentHandler {

		private Stack<Object> m_nodeStack;
		private Object m_root = null;

		public CSSOMHandler(Stack<Object> nodeStack) {
			m_nodeStack = nodeStack;
		}

		public CSSOMHandler() {
			m_nodeStack = new Stack<Object>();
		}

		public Object getRoot() {
			return m_root;
		}

		public void startDocument(InputSource source) throws CSSException {
			if (m_nodeStack.empty()) {
				DCssStyleSheet ss = new DCssStyleSheet();
				m_parentStyleSheet = ss;

				DCssRuleList rules = (DCssRuleList)ss.getCssRules();
				m_nodeStack.push(ss);
				m_nodeStack.push(rules);
			} else {
				// Error
			}
		}

		public void endDocument(InputSource source) throws CSSException {

			// Pop the rule list and style sheet nodes
			m_nodeStack.pop();
			m_root = m_nodeStack.pop();
		}

		public void comment(String text) throws CSSException {
		}

		public void ignorableAtRule(String atRule) throws CSSException {

			// Create the unknown rule and add it to the rule list
			DCssUnknownRule ir =
				new DCssUnknownRule(m_parentStyleSheet, null, atRule);
			if (!m_nodeStack.empty()) {
				((DCssRuleList) m_nodeStack.peek()).add(ir);
			} else {
				m_root = ir;
			}
		}

		public void namespaceDeclaration(String prefix, String uri)
			throws CSSException {
		}

		public void importStyle(
			String uri,
			SACMediaList media,
			String defaultNamespaceURI)
			throws CSSException {

			// Create the import rule and add it to the rule list
			DCssImportRule ir =
				new DCssImportRule(
					m_parentStyleSheet,
					null,
					uri,
					new DCssMediaList(media));
			if (!m_nodeStack.empty()) {
				((DCssRuleList) m_nodeStack.peek()).add(ir);
			} else {
				m_root = ir;
			}
		}

		public void startMedia(SACMediaList media) throws CSSException {

			// Create the media rule and add it to the rule list
			DCssMediaRule mr =
				new DCssMediaRule(
					m_parentStyleSheet,
					null,
					new DCssMediaList(media));
			if (!m_nodeStack.empty()) {
				((DCssRuleList) m_nodeStack.peek()).add(mr);
			}

			// Create the rule list
			DCssRuleList rules = new DCssRuleList();
			mr.setRuleList(rules);
			m_nodeStack.push(mr);
			m_nodeStack.push(rules);
		}

		public void endMedia(SACMediaList media) throws CSSException {

			// Pop the rule list and media rule nodes
			m_nodeStack.pop();
			m_root = m_nodeStack.pop();
		}

		public void startCharset(String name) throws CSSException {
			// Create the page rule and add it to the rule list
			DCssCharsetRule rule = new DCssCharsetRule(m_parentStyleSheet,null,name);
			if (!m_nodeStack.empty()) {
				((DCssRuleList) m_nodeStack.peek()).add(rule);
			}
	
			// Create the style declaration
			DCssStyleDeclaration decl = new DCssStyleDeclaration(rule);
//			rule.setStyle(decl);
			m_nodeStack.push(rule);
			m_nodeStack.push(decl);
		}
	
		public void endCharset(String name) throws CSSException {
			// Pop both the style declaration and the page rule nodes
			m_nodeStack.pop();
			m_root = m_nodeStack.pop();
		}
	
		public void startPage(String name, String pseudo_page)
			throws CSSException {

			// Create the page rule and add it to the rule list
			DCssPageRule pr =
				new DCssPageRule(
					m_parentStyleSheet,
					null,
					name,
					pseudo_page);
			if (!m_nodeStack.empty()) {
				((DCssRuleList) m_nodeStack.peek()).add(pr);
			}

			// Create the style declaration
			DCssStyleDeclaration decl = new DCssStyleDeclaration(pr);
			pr.setStyle(decl);
			m_nodeStack.push(pr);
			m_nodeStack.push(decl);
		}

		public void endPage(String name, String pseudo_page)
			throws CSSException {

			// Pop both the style declaration and the page rule nodes
			m_nodeStack.pop();
			m_root = m_nodeStack.pop();
		}

		public void startFontFace() throws CSSException {

			// Create the font face rule and add it to the rule list
			DCssFontFaceRule ffr =
				new DCssFontFaceRule(m_parentStyleSheet, null);
			if (!m_nodeStack.empty()) {
				((DCssRuleList) m_nodeStack.peek()).add(ffr);
			}

			// Create the style declaration
			DCssStyleDeclaration decl = new DCssStyleDeclaration(ffr);
			ffr.setStyle(decl);
			m_nodeStack.push(ffr);
			m_nodeStack.push(decl);
		}

		public void endFontFace() throws CSSException {

			// Pop both the style declaration and the font face rule nodes
			m_nodeStack.pop();
			m_root = m_nodeStack.pop();
		}

		public void startSelector(SelectorList selectors) throws CSSException {

			// Create the style rule and add it to the rule list
			DCssStyleRule sr =
				new DCssStyleRule(m_parentStyleSheet, null, selectors);
			if (!m_nodeStack.empty()) {
				((DCssRuleList) m_nodeStack.peek()).add(sr);
			}

			// Create the style declaration
			DCssStyleDeclaration decl = new DCssStyleDeclaration(sr);
			sr.setStyle(decl);
			m_nodeStack.push(sr);
			m_nodeStack.push(decl);
		}

		public void endSelector(SelectorList selectors) throws CSSException {

			// Pop both the style declaration and the style rule nodes
			m_nodeStack.pop();
			m_root = m_nodeStack.pop();
		}

		public void property(String name, LexicalUnit value, boolean important)
			throws CSSException {
			CSSStyleDeclaration decl =
				(CSSStyleDeclaration) m_nodeStack.peek();
			if(decl instanceof DCssStyleDeclaration){
				((DCssStyleDeclaration)decl).addProperty(
						new DCssProperty(name, new DCssValue(value), important));
			}
			
		}
	}

	public static void setProperty(String key, String val) {
		Properties props = System.getProperties();
		props.put(key, val);
		System.setProperties(props);
	}
}
