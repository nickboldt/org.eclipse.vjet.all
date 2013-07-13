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

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.vjet.dsf.common.context.BaseSubCtx;
import org.eclipse.vjet.dsf.common.context.ContextHelper;
import org.eclipse.vjet.dsf.common.context.DsfCtx;

/**
 * A context (associated with DsfCtx) to set and retrieve an IProductionPlan
 */
public class ProductionCtx extends BaseSubCtx {
	
	private IProductionPlan m_plan ;
	// We want to maintain set semantics while preserving the order
	private Queue<IDocModifier> m_docModifiers;

	public static ProductionCtx ctx() {
		ProductionCtx context = CtxAssociator.getCtx();
		if (context == null) {
			context = new ProductionCtx();
			setCtx(context);
		}
		return context;
	}
	

	
	public static void setCtx(final ProductionCtx context) {
		CtxAssociator.setCtx(context) ;
	}
	
	private ProductionCtx() {
		// empty on purpose
	}

	public Queue<IDocModifier> getDocModifiersQueue(){
		if(m_docModifiers==null){
			m_docModifiers = new ConcurrentLinkedQueue<IDocModifier>();
		}
		return m_docModifiers;
	}
	
	public Iterable<IDocModifier> getDocModifiers() {
		return getDocModifiersQueue();
	}

	public void addDocModifier(final IDocModifier modifier) {
		final Queue<IDocModifier> queue = getDocModifiersQueue();
		//add the modifier to the queue if it's not existing.
		if(!queue.contains(modifier)){
			queue.add(modifier);
		}
	}

	public boolean hasDocModifiers() {
		if(m_docModifiers==null){
			return false;
		}
		
		return !m_docModifiers.isEmpty() ;
	}
	
	public void reset(){
		m_plan = null;
		m_docModifiers = null;
	}
	
	public IProductionPlan getPlan() {
		if (m_plan == null) {
			m_plan = new DefaultProductionPlan();
		}
		return m_plan;
	}

	public void setPlan(IProductionPlan plan) {
		m_plan = plan;
	}

	private static class CtxAssociator extends ContextHelper {
		private static final String CTX_NAME = ProductionCtx.class.getSimpleName();
		protected static ProductionCtx getCtx() {
			return (ProductionCtx)getSubCtx(DsfCtx.ctx(), CTX_NAME);
		}
		
		protected static void setCtx(final ProductionCtx ctx) {
			setSubCtx(DsfCtx.ctx(), CTX_NAME, ctx);
		}
	}
}
