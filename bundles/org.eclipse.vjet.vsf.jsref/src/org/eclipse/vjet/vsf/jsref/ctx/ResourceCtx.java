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
package org.eclipse.vjet.vsf.jsref.ctx;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.vjet.dsf.common.context.BaseSubCtx;
import org.eclipse.vjet.dsf.common.context.ContextHelper;
import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.dsf.spec.export.JsExportableCompCollector;

public final class ResourceCtx extends BaseSubCtx {

	private static final List<IComponentSpec> EMPTY_LIST = new ArrayList<IComponentSpec>(
			0);

	private JsResourceCtx m_jsResourceContext;
	private Set<IComponentSpec> m_componentSpecs = null;

	private JsExportableCompCollector m_jsInstanceCollector;

	/**
	 * 
	 * returns the adaptation target for content elements. An adaptation target
	 * is a vector along which content and ContentElements might vary To the V4
	 * content subsystem, this target is IContentElementTarget the value of
	 * "target" however, cana actually be eBay enumeration for sites etc.
	 */
	// private IContentElementTarget m_contentTarget;

	//
	// ThreadLocal setup
	//
	public static ResourceCtx ctx() {
		return ctx(DsfCtx.ctx());
	}

	public static ResourceCtx ctx(final DsfCtx ctx) {
		ResourceCtx context = CtxAssociator.getCtx(ctx);
		if (context == null) {
			context = new ResourceCtx();
			setCtx(context);
		}
		return context;
	}

	/**
	 * Sets the context to be associated with this thread local. The context can
	 * be null.
	 */
	public static void setCtx(final ResourceCtx context) {
		CtxAssociator.setCtx(context);
	}

	//
	// Constructor(s)
	//
	private ResourceCtx() {
	}

	/**
	 * Answer the thread local associated DsfContext instance. Initially a
	 * DsfContext instance is associated. The setContext(...) can set the
	 * associated value to null.
	 */

	public void register(final IComponentSpec componentSpec) {
		if (m_componentSpecs == null) {
			m_componentSpecs = new HashSet<IComponentSpec>();
		}
		m_componentSpecs.add(componentSpec);
	}

	/**
	 * @return Returns the jsResourceContext.
	 */
	public JsResourceCtx getJsResourceCtx() {
		if (m_jsResourceContext == null) {
			m_jsResourceContext = new JsResourceCtx();
		}
		return m_jsResourceContext;
	}

	public void reset() {
		m_jsResourceContext = null;
		m_componentSpecs = null;

	}

	public Iterator<IComponentSpec> componentSpecIterator() {
		if (m_componentSpecs == null) {
			return EMPTY_LIST.iterator();
		}
		return m_componentSpecs.iterator();
	}

	public boolean hasCollectedCompSpecs() {
		return m_componentSpecs == null;
	}

	public JsExportableCompCollector getJsInstanceCollector() {
		if (m_jsInstanceCollector == null) {
			m_jsInstanceCollector = new JsExportableCompCollector();
		}
		return m_jsInstanceCollector;
	}

	public boolean hasJsInstanceCollector() {
		return m_jsInstanceCollector != null;
	}

	private static class CtxAssociator extends ContextHelper {
		private static final String CTX_NAME = ResourceCtx.class
				.getSimpleName();

		protected static ResourceCtx getCtx(final DsfCtx ctx) {
			return (ResourceCtx) getSubCtx(ctx, CTX_NAME);
		}

		protected static void setCtx(final ResourceCtx ctx) {
			setSubCtx(DsfCtx.ctx(), CTX_NAME, ctx);
		}
	}
}
