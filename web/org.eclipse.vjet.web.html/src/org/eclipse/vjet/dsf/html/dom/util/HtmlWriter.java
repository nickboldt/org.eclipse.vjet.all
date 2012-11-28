/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.html.dom.util;

import java.util.Set;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.dom.DDocument;
import org.eclipse.vjet.dsf.dom.DElement;
import org.eclipse.vjet.dsf.dom.support.DNamespace;
import org.eclipse.vjet.dsf.dom.util.BaseDomWriter;
import org.eclipse.vjet.dsf.dom.util.ILineLocateIndenter;
import org.eclipse.vjet.dsf.html.HtmlWriterCtx;
import org.eclipse.vjet.dsf.html.dom.BaseHtmlElement;
import org.eclipse.vjet.dsf.html.schemas.IContentModel;
import org.eclipse.vjet.dsf.html.schemas.IElementInfo;
import org.eclipse.vjet.dsf.html.schemas.ISchema;

public class HtmlWriter extends BaseDomWriter {

	private final IHtmlStreamWriter m_writer;
	private ISchema m_schema;
	private final HtmlWriterCtx m_writerCtx;

	/**
	 * Create a new XML writer.
	 * 
	 * <p>
	 * Write to the writer provided.
	 * </p>
	 * 
	 * @param writer
	 *            The output destination, or null to use standard output.
	 */
	public HtmlWriter(final IHtmlStreamWriter writer) {
		// this(Html401Transitional.getInstance(), writer);
		this(writer, new HtmlWriterCtx());
	}

	public HtmlWriter(final ISchema schema, final IHtmlStreamWriter writer) {
		this(writer, new HtmlWriterCtx(schema));
	}

	public HtmlWriter(final IHtmlStreamWriter writer, HtmlWriterCtx ctx) {
		super(writer, ctx);

		m_writer = writer;
		m_schema = ctx.getSchema();
		m_writerCtx = ctx;
		if (ctx.getIndenter() instanceof ILineLocateIndenter) {
			m_lineLocator = (ILineLocateIndenter) ctx.getIndenter();
		} else {
			m_lineLocator = null;
		}
		if (ctx.isAddLineNumber() && m_lineLocator == null) {
			throw new DsfRuntimeException("lineLocation is null.");
		}
	}

	// //////////////////////////////////////////////////////////////////
	// Public methods.
	// //////////////////////////////////////////////////////////////////
	public HtmlWriter setSchema(final ISchema schema) {
		m_schema = schema;
		return this;
	}

	public ISchema getSchema() {
		return m_schema;
	}

	public void startElement(final DElement element) {
		// MrPperf - use char[] lookup rather than tagName
		// final String localName = element.getTagName();
		addLine(element, true, false);
		// final char[] tagNameAsChars;
		String tagName; // = element.getTagName() ;
		if (m_writerCtx.isRenderNS()) {
			// tagNameAsChars = element.getTagName().toCharArray();
			tagName = element.getTagName();
		} else {
			if (element instanceof BaseHtmlElement) {
				// final HtmlTypeEnum htmlType =
				// ((BaseHtmlElement)element).htmlType();
				// tagNameAsChars =
				// HtmlTypeEnumAssociator.getNameCharArray(htmlType);
				tagName = ((BaseHtmlElement) element).htmlType().getName();
			} else {
				// // yes this is a copy but that's ok since this is an 'HTML'
				// writer
				// // so we are favoring HTML element names as char[]
				// // tagNameAsChars = element.getTagName().toCharArray();
				tagName = element.getTagName();
			}
		}

		// MrPperf - use char[] vs. tagName String
		m_writer.writeStartElement(tagName /* tagNameAsChars */); // (localName);
		// has doc and element is doc root element
		if (element.getOwnerDocument() != null
				&& element.getOwnerDocument().getDocumentElement() == element) {
			if (element.getOwnerDocument().getBaseURI() != null) {
				m_writer.writeAttribute("xmlns:base", element
						.getOwnerDocument().getBaseURI());
			}
			// MrPperf - todo: should use loop vs. iterator
			Set<DNamespace> nsDecls = ((DDocument) element.getOwnerDocument())
					.getDsfNamespaceDeclarations();
			for (DNamespace nsObj : nsDecls) {
				writeNSAttr(nsObj.getPrefix(), nsObj.getNamespaceKey());
			}
		}
		writeAttributes(element);
	}

	/**
	 * Write an end tag.
	 * 
	 * Pass the event on down the filter chain for further processing.
	 * 
	 * @param uri
	 *            The Namespace URI, or the empty string if none is available.
	 * @param localName
	 *            The element's local (unprefixed) name (required).
	 * @param qName
	 *            The element's qualified (prefixed) name, or the empty string
	 *            is none is available. This method will use the qName as a
	 *            template for generating a prefix if necessary, but it is not
	 *            guaranteed to use the same qName.
	 * @exception org.xml.sax.SAXException
	 *                If there is an error writing the end tag, or if a handler
	 *                further down the filter chain raises an exception.
	 * @see org.xml.sax.ContentHandler#endElement
	 */
	// TODO: Big assumption that a DElement "is a" html element which it is not
	// thus the enum lookup based on tagname can easily fail and NPE
	public void endElement(final DElement element) {
		final IElementInfo elementInfo = getElementInfo(element);

		if (shouldEndTag(elementInfo)) {
			addLine(element, false, true);
			try {
				m_writer.writeEndElement();
			} catch (Exception e) {
				throw new DsfRuntimeException("error writing end tag for '"
						+ element.getTagName() + "'", e);
			}
		} else {
			addLine(element, false, false);
			m_writer.ignoreCurrentEndTag();
		}
	}

	public IElementInfo getElementInfo(final DElement element) {
		if (m_schema == null) {
			return null;
		}

		// MrPperf -- do faster single static array lookup for BaseHtmlElements
		// elementInfo
		// This will save two hashmap lookups for each BaseHtmlElement type
		if (element instanceof BaseHtmlElement) {
			return m_schema.getElementInfo(((BaseHtmlElement) element)
					.htmlType());
		}

		return null;
		// final String localName = element.getTagName();
		// final HtmlTypeEnum htmlType =
		// HtmlTypeEnum.getEnum(localName);
		// final IElementInfo answer
		// = m_schema.getElementInfo(htmlType);
		// return answer ;
	}

	private boolean shouldEndTag(final IElementInfo elementInfo) {
		return elementInfo == null || elementInfo.requireEndTag()
				|| elementInfo.getContentModel() != IContentModel.EMPTY;
	}

}
