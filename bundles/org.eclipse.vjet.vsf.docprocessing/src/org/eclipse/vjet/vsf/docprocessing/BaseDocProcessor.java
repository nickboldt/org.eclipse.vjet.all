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

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Queue;

import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.dom.DDocument;
import org.eclipse.vjet.dsf.dom.util.DeferConstructionCollector;
import org.eclipse.vjet.dsf.html.dom.util.IDeferConstruction;
import org.eclipse.vjet.dsf.logger.LogLevel;
import org.eclipse.vjet.dsf.logger.Logger;


/**
 * Simple document processor according to a production plan.
 * It annotates the doc based on the DocAnnotationData,
 * aggregates and injects the JS and CSS resources into the doc.
 */
public abstract class BaseDocProcessor implements IDocProcessor {
	
	private static Logger s_logger;
	
	protected IProductionPlan m_plan;

	//
	// Constructor(s)
	//
	public BaseDocProcessor(final IProductionPlan plan) {
		m_plan = plan;
	}

	//
	// Framework
	//
	protected abstract void processDocAnnotation(final DDocument doc) ;
	
	// 
	// API
	//
	public IProductionPlan getPlan() {
		return m_plan;
	}

	public void setPlan(final IProductionPlan plan) {
		m_plan = plan;
	}
	
	public void process(final DDocument doc) {
		beforeProcess(doc);
		
		finishComponents();
		
		processDocModifiers(doc);
		
		processDocAnnotation(doc); 
		
		//to catch any components created during processDocModifiers and processDocAnnotation.
		//coz components are removed from the collector,
		//calling finishComponents again will not cause finish() being called twice for any components.
		finishComponents();

		// in proggressive render case the js and css could
		// share the head tag so we want css to be added before js
		// in no progressive mode this change will not affect anything
		// since the default css applier will use head 
		// and js applier will use body tag.

		processJs(doc) ;

		afterProcess(doc);
	}
	
	protected void processJs(DDocument doc) {
		createJsProcessor().process(doc, m_plan.getViewSpec());
	}
	
	
	/*
	 * Call component collector to call finish() from IDeferConstruction.
	 * This ensures that components who have deferred construction are setup
	 * correctly before processing.
	 */
	protected void finishComponents() {
		DeferConstructionCollector collector 
			= DsfCtx.ctx().getDeferConstructionCollector();
		IDeferConstruction component = null;
		while ((component = collector.removeFirst()) != null) {
			component.finish();
		}
	}

	protected void processDocModifiers(final DDocument doc) {
		if(m_plan.isProcessDocModifiers()){
			ProductionCtx pctx = ProductionCtx.ctx();
			
			if(pctx.hasDocModifiers()){
				IDocModifier modifier = null;
				try{
					Queue<IDocModifier> queue = pctx.getDocModifiersQueue();
					while(!queue.isEmpty())	{
						modifier= queue.poll();
						if(modifier!=null){
							modifier.modify(doc);
						}
					}
				}
				catch (ConcurrentModificationException cme){
					throw new DsfRuntimeException(
						"Modifier: "  
						+ (modifier != null ? modifier.getClass().getName() : "Unknown") 
						+ " is adding something to ctx", cme);
				}
			}
		}
	}

	protected abstract IJsProcessor createJsProcessor();
	
	
	//
	// Private
	//
	private void beforeProcess(final DDocument doc){
		dispatchEvent(doc, DocProcessCtx.ctx().getListenerList(), true);		
		dispatchEvent(doc, DocProcessCtx.getGlobalListenerList(), true);
	}	

	private void afterProcess(final DDocument doc){		
		dispatchEvent(doc, DocProcessCtx.ctx().getListenerList(), false);
		dispatchEvent(doc, DocProcessCtx.getGlobalListenerList(), false);
	}
	
	//Currently no requirements to split before & after logic, so we build it as one.
	//If need, feel free to split.
	private void dispatchEvent(
		final DDocument doc, 
		final List<IDocProcessEventListener> listeners, 
		boolean isBefore)
	{
		if(listeners == null) return ;
		for (IDocProcessEventListener listener : listeners) {
			try{
				if(listener.isActive()){			
					BaseDocProcessEvent event = isBefore 
						? new PreDocProcessEvent(this, doc) 
						: new PostDocProcessEvent(this, doc);
					event.dispatch(listener);
				}
			}
			catch(Exception e){
				//As a system level extension, we just log this exception here, 
				//each listener should take care of their own exception
				logEx(e);		
			}
		}
	}
	private void logEx(Exception e){
		if (getLogger().isLogEnabled(LogLevel.DEBUG)){
			getLogger().log(LogLevel.DEBUG, e);
		}
	}

	private Logger getLogger() {
		if (s_logger == null) {
			s_logger = Logger.getInstance(this.getClass());
		}

		return s_logger;
	}
}
