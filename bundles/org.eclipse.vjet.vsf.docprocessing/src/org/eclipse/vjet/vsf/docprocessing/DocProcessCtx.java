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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.vjet.dsf.common.context.BaseSubCtx;
import org.eclipse.vjet.dsf.common.context.ContextHelper;
import org.eclipse.vjet.dsf.common.context.DsfCtx;

/**
 * A threadlocal context (associated with DsfCtx) to manage IDocProcessEventListener.<br>
 * This is a system level extension mechanism, make sure not to include app logic here,
 * and deal with exception in each listener. System will only log the exception if catched any, 
 * without blocking the doc processing flow.
 * @author yuge
 * @since e605
 */
public class DocProcessCtx extends BaseSubCtx {
	
	private List<IDocProcessEventListener> m_listeners;
	
	private static List<IDocProcessEventListener> s_globalListeners;

	public static List<IDocProcessEventListener> getGlobalListenerList() {
		if(s_globalListeners == null){
			s_globalListeners = new ArrayList<IDocProcessEventListener>();
		}
		return s_globalListeners;
	}
	
	public static Iterable<IDocProcessEventListener> getGlobalListeners(){
		return getGlobalListenerList();
	}

	public static boolean addGlobalListener(IDocProcessEventListener listener) {
		return getGlobalListenerList().add(listener);
	}

	public static boolean removeGlobalListener(IDocProcessEventListener listener) {
		return getGlobalListenerList().remove(listener);
	}
	
	public List<IDocProcessEventListener> getListenerList() {
		if(m_listeners == null){
			m_listeners = new ArrayList<IDocProcessEventListener>();
		}
		return m_listeners;
	}
	
	public Iterable<IDocProcessEventListener> getListeners(){
		return getListenerList();
	}

	public boolean addListener(IDocProcessEventListener listener) {
		return getListenerList().add(listener);
	}

	public boolean removeListener(IDocProcessEventListener listener) {
		return getListenerList().remove(listener);
	}
	
	public static DocProcessCtx ctx() {
		DocProcessCtx context = CtxAssociator.getCtx();
		if (context == null) {
			context = new DocProcessCtx();
			setCtx(context);
		}
		return context;
	}	

	
	public static void setCtx(final DocProcessCtx context) {
		CtxAssociator.setCtx(context) ;
	}
	
	private DocProcessCtx() {
		// empty on purpose
	}

	public void reset(){
		m_listeners = null;
	}	

	private static class CtxAssociator extends ContextHelper {
		private static final String CTX_NAME = DocProcessCtx.class.getSimpleName();
		protected static DocProcessCtx getCtx() {
			return (DocProcessCtx)getSubCtx(DsfCtx.ctx(), CTX_NAME);
		}
		
		protected static void setCtx(final DocProcessCtx ctx) {
			setSubCtx(DsfCtx.ctx(), CTX_NAME, ctx);
		}
	}
}
