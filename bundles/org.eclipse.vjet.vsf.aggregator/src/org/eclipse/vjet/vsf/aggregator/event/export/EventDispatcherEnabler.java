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
package org.eclipse.vjet.vsf.aggregator.event.export;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.vjet.dsf.dom.DElement;
import org.eclipse.vjet.dsf.html.dom.BaseAttrsHtmlElement;
import org.eclipse.vjet.dsf.html.dom.DBody;
import org.eclipse.vjet.dsf.html.dom.HtmlTypeEnum;
import org.eclipse.vjet.dsf.html.events.DsfEventTarget;
import org.eclipse.vjet.dsf.html.events.EventHandlerContainer;
import org.eclipse.vjet.dsf.html.events.EventHandlerContainer.EventsToHandlerPair;
import org.eclipse.vjet.dsf.html.events.IDomEventType;
import org.eclipse.vjet.dsf.html.events.ISimpleJsEventHandler;
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;
import org.eclipse.vjet.dsf.html.js.IScopeableJsHandler;
import org.eclipse.vjet.dsf.html.js.JsFunctionEventHandlerAdaptor;
import org.eclipse.vjet.vsf.jsruntime.compregistry.JsComponentRegistry;
import org.eclipse.vjet.vsf.jsruntime.context.JsRuntimeCtx;
import org.eclipse.vjet.vsf.jsruntime.optimizer.JsFuncCodeGenOptimizer;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsObjHandler;


public final class EventDispatcherEnabler {
    private static final String NEW_LINE = System.getProperty("line.separator") ;
	
	public static final String EVENT_DISPATCHER = "vjo.dsf.EventDispatcher";
	public static final String EVENT_DISPATCHER_SHORT = "_d";
		//"var eventDispatcher = new dsf_EventDispatcher();";
		
	private HashSet<IDomEventType> m_enabledEvents = new HashSet<IDomEventType>();
	
	void enableEvent(IDomEventType eventType) {
		m_enabledEvents.add(eventType);
	}
	
	//
	// Constructor
	//
	public EventDispatcherEnabler(){};

	void addEventTrigger(final DElement element, final IDomEventType eventType) {
		// TODO: IJsContentGenerator
		final String eventName = eventType.getName();
		final String eventAttribute = "on" + eventName;
		//if (requireNativeEvent) {
			element.setAttribute(eventAttribute, getDispatchWithNativeEvent(eventName));			
		//} else {
		//	element.setAttribute(eventAttribute, getDispatch(eventName));						
		//}
	}
	
//	//TODO: GDC delete after thor.
//	public static void bindEventHandler(final DElement element,
//			final EventType eventType, final IJsFunc handler) {
//		if (JsRuntimeCtx.ctx().useInlineEventBinding()) {
//			final String eventName = eventType.getName();
//			final String eventAttribute = "on" + eventName;
//			element.setAttribute(eventAttribute,
//					getDispatchWithNativeEvent(eventName));
//		}
//		element.add(eventType, handler);
//	}
	
	//	
	// Only valid in DBody and DFrameset elements
	//		
	void addOnLoadEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onload", getDispatch("load")) ;		
	}
	
	void addOnUnloadEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onunload", getDispatch("unload"));		
	}

	//	
	// Only valid in DFormControl elements
	//
	void addOnChangeEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onchange", getDispatch("change"));		
	}

	void addOnSubmitEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onsubmit", getDispatch("submit"));		
	}		
		
	void addOnResetEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onreset", getDispatch("reset"));		
	}

	void addOnSelectEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onselect", getDispatch("select"));		
	}
		
	void addOnBlurEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onblur", getDispatch("blur"));		
	}
		
	void addOnFocusEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onfocus", getDispatch("focus"));		
	}

	//
	//	Keyboard events.  NOT valid in base, bdo, br, frame, frameset, head
	//	html, iframe, meta, param, script, style and title elements	
	//
	void addOnKeyDownEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onkeydown", getDispatch("keydown"));		
	}

	void addOnKeyPressEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onkeypress", getDispatch("keypress"));		
	}		

	void addOnKeyUpEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onkeyup", getDispatch("keyup"));		
	}

	//
	//	Mouse events.  NOT valid in base, bdo, br, frame, frameset, head
	//	html, iframe, meta, param, script, style and title elements	
	//
	void addOnClickEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onclick", getDispatch("click"));		
	}
	
	void addOnDblClickEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("ondblclick", getDispatch("dblclick"));		
	}

	void addOnMouseDownEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onmousedown", getDispatch("mousedown"));		
	}

	void addOnMouseMoveEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onmousemove", getDispatch("mousemove"));		
	}

	void addOnMouseOutEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onmouseout", getDispatch("mouseout"));		
	}

	void addOnMouseOverEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onmouseover", getDispatch("mouseover"));		
	}

	void addOnMouseUpEventTrigger(final BaseAttrsHtmlElement element) {
		element.setAttribute("onmouseup", getDispatch("mouseup"));		
	}
	
	/**
	 * Will extract event handler definition and registration
	 * code block.
	 * 
	 * @param container
	 * @param optimize - tells code gen to use short handed notations
	 * @return
	 */
	public static String extractEventHandlerData(
			final EventHandlerContainer container,
			final boolean optimize
			) {
		final StringBuilder jsDef = new StringBuilder();
		//Map<String,List<ISimpleJsEventHandler>> dedupMap = new HashMap<String, List<ISimpleJsEventHandler>>();
		if (optimize) {
			JsRuntimeCtx.ctx().getCompRegistry().setRegistryVar(JsComponentRegistry.JSVAR_OREGISTRY_SHORT);
		}
		JsFuncCodeGenOptimizer optimizer;
		if (optimize) {
			optimizer = new JsFuncCodeGenOptimizer();
		} else {
			optimizer = null;
		}
		/*
		if (optimize) {
			for (Entry<DsfEventTarget, List<EventsToHandlerPair>> entry : container.getElements().entrySet()) {
				for (EventsToHandlerPair pair : entry.getValue()) {
					//Add it to optimizer here
					if (pair.getHandler() instanceof JsFunctionEventHandlerAdaptor) {
						JsFunctionEventHandlerAdaptor handler = (JsFunctionEventHandlerAdaptor) pair.getHandler();
						optimizer.add(handler.getJsFunc());
						
					}
				}
			}
		}
		*/
		//String optimizedFuncDefs = optimizer.createDefs();
		
		//Map<ISimpleJsEventHandler, String> keyMap = new HashMap<ISimpleJsEventHandler, String>();
		extractHandlerDefData(container.getElements(), jsDef, /*keyMap,*/ optimizer);
		extractHandlerDefData(container.getElementsAttached(), jsDef, /*keyMap,*/ optimizer);
	
		final StringBuilder jsReg = new StringBuilder();
		//begin
		jsReg.append("(function(){").append(NEW_LINE).append("var ").append(
				EventDispatcherEnabler.EVENT_DISPATCHER_SHORT).append("=")
				.append(EventDispatcherEnabler.EVENT_DISPATCHER).append(";")
				.append(NEW_LINE).append("var ").append(
						JsComponentRegistry.JSVAR_OREGISTRY_SHORT).append(
						"=").append(JsComponentRegistry.JSVAR_OREGISTRY)
				.append(";").append(NEW_LINE);
		
		//jsReg.append(optimizedFuncDefs);
		if (optimize) {
			jsReg.append(optimizer.createDefs());
		}
		jsReg.append(jsDef);
/*		final RopeBufferWriter handlerArr = new RopeBufferWriter();
		//Generate JS handler map for dups
		handlerArr.append("[");
		int i = 0;
		for (Entry<String,List<ISimpleJsEventHandler>> dedup : dedupMap.entrySet()) {
			List<ISimpleJsEventHandler> vals = dedup.getValue();
			if (vals.size()>1) {
				handlerArr.append(dedup.getKey()).append(",");
				int j = i++;
				for (ISimpleJsEventHandler key : vals) {
					if (key!=null) {
						keyMap.put(key, "_h["+j+"]");
					}
				}
			} else if (vals.size()==1){
				keyMap.put(vals.get(0), dedup.getKey());
			}
		}
		String map = handlerArr.toString();
		boolean hasDups = (map.length()>1);
		if (hasDups) {
			jsReg.append(NEW_LINE).append("var _h=").append(map.substring(0, map.length()-1)).append("];").append(NEW_LINE);
		}
*/		

		extractHandlerRegData(container.getElements(), jsReg, /*keyMap,*/ optimizer);
		extractHandlerRegData(container.getElementsAttached(), jsReg, /*keyMap,*/ optimizer);
		
		//end
		jsReg.append("})();");
		
		if (optimize) {
			JsRuntimeCtx.ctx().getCompRegistry().resetRegistryVar();
		}
		return jsReg.toString();
	}
	
	private static void extractHandlerDefData(
		final Map<DsfEventTarget, List<EventsToHandlerPair>> elemMap, 
		final StringBuilder jsContent,
		/*final Map<String,List<ISimpleJsEventHandler>> dedupMap,*/
		/*Map<ISimpleJsEventHandler, String> keyMap,*/
		JsFuncCodeGenOptimizer optimizer)
	{
		Set<String> set = new HashSet<String>();
		for (Entry<DsfEventTarget, List<EventsToHandlerPair>> entry : elemMap.entrySet()) {
			for (EventsToHandlerPair pair : entry.getValue()) {
				ISimpleJsEventHandler handler = pair.getHandler();
				if (optimizer != null) {
					if (handler instanceof JsFunctionEventHandlerAdaptor) {
						JsFunctionEventHandlerAdaptor new_handler 
							= (JsFunctionEventHandlerAdaptor) pair.getHandler();
						optimizer.add(new_handler.getJsFunc());
						
					}
				}
				String def = handler.asJsDefinition();
				if (def!=null&&!"".equals(def) && !set.contains(def)) {
					jsContent.append(def).append(" ");
					set.add(def);
				}
				
				//store duplicate handlers so we can create map in js
				/*
				String h = "";
				if (handler instanceof JsFunctionEventHandlerAdaptor) {
					h = generateEventHandler(handler,optimizer);
				} else {
					h = generateHandler(null,handler);
				}
				keyMap.put(handler, h);
				*/
				/*
				List<ISimpleJsEventHandler>list = dedupMap.get(h);
				if (list==null){
					list = new ArrayList<ISimpleJsEventHandler>(10);
					dedupMap.put(h, list);
				}
				list.add(handler);
				*/
			}
		}
	}
	
	private static String generateEventHandler(ISimpleJsEventHandler handler, JsFuncCodeGenOptimizer optimizer) {
		
		if (handler instanceof JsFunctionEventHandlerAdaptor) {
			JsFunctionEventHandlerAdaptor oHandler = (JsFunctionEventHandlerAdaptor) handler;
			return (optimizer.createCall(oHandler.getJsFunc()));
		}
		return "";
	}

	private static void extractHandlerRegData(final Map<DsfEventTarget, List<EventsToHandlerPair>> elemMap, 
			final StringBuilder jsContent,
			/*final Map<ISimpleJsEventHandler,String> dedupMap,*/
			JsFuncCodeGenOptimizer optimizer
		) {
		
		int i = 0;
		for (Entry<DsfEventTarget, List<EventsToHandlerPair>> entry : elemMap.entrySet()) {
			DsfEventTarget target = entry.getKey();
			if (HtmlTypeEnum.BODY.equals(target.getType()) || target.getElem() instanceof DBody) {
				target.setId(EventDispatcherAssembler.BODY_ID);
			} 
			boolean byId = (target.getId()!=null);
			String srcId = (byId) ? target.getId() : target.getElem().getAttribute("id") ; //getHtmlId();
			for (EventsToHandlerPair pair : entry.getValue()) {
				ISimpleJsEventHandler handler = pair.getHandler();
				IDomEventType type = pair.getEventType();
				//String instanceStr = (dedupMap==null) ? null : dedupMap.get(handler);
				String instanceStr = (optimizer==null) ? null : generateEventHandler(handler, optimizer);
				instanceStr = ( instanceStr==null || "".equals(instanceStr) ) ? generateHandler(jsContent, handler) : instanceStr;
				String method = (byId || !JsRuntimeCtx
						.ctx().useInlineEventBinding()) ? "add" : "register";
				jsContent.append(EVENT_DISPATCHER_SHORT).append(".")
					.append(method).append("('").append(srcId).append("','")
					.append(type.getName()).append("',")
					.append(instanceStr);
				
				if (handler instanceof IScopeableJsHandler) {
					String scope = ((IScopeableJsHandler)handler).getScope();
					jsContent.append(",").append(scope);
				}
				jsContent.append(");");
				if (++i % 10 == 0) {
					jsContent.append(NEW_LINE);
				}
			}
		}
	}

	private static String generateHandler(final StringBuilder jsContent, ISimpleJsEventHandler handler) {
		IJsObjectRef oRef = null;
		//always use js to bind body events
		
		if (handler instanceof IJsObjHandler) {
			oRef = ((IJsObjHandler)handler).getJsObj();
		}
		
		String instanceStr = "";
		if (oRef!=null) {
			if (jsContent!=null && oRef.isHandler() && !oRef.isGenned()) {
				jsContent.append(oRef.generate(true)).append(NEW_LINE);//add instance
			}
			instanceStr = JsComponentRegistry.getJsInstance(oRef.getInstanceId(), true);
		} else {//we'll always register scope
			instanceStr = (handler instanceof IScopeableJsHandler) ? 
					((IScopeableJsHandler) handler).asJsHandler("this")
					: handler.asJsHandler();
		}
		return instanceStr;
	}
	
	/**
	 * deprecated method
	 * use extractEventHandlerData method in this file
	 */
	@Deprecated 
	public static void  addHandlerRegistration(
			final String srcId,
			final IDomEventType type,
			final ISimpleJsEventHandler handler,
			final StringBuilder jsContent, 
			final boolean byId, 
			final boolean optimize)
		{
			if (jsContent==null) {
				return;
			}
			//always use js to bind body events
			String method = (byId || !JsRuntimeCtx
					.ctx().useInlineEventBinding()) ? "add" : "register";
			IJsObjectRef oRef = null;
			//always use js to bind body events
			
			if (handler instanceof IJsObjHandler) {
				oRef = ((IJsObjHandler)handler).getJsObj();
			}
			
			String instanceStr = "";
			if (oRef!=null) {
				if (oRef.isHandler() && !oRef.isGenned()) {
					jsContent.append(oRef.generate(true)).append(NEW_LINE);//add instance
				}
				instanceStr = JsComponentRegistry.getJsInstance(oRef.getInstanceId(), true);
			} else {
				instanceStr = handler.asJsHandler();
			}
		
			
			jsContent.append((optimize)?EVENT_DISPATCHER_SHORT:EVENT_DISPATCHER).append(".")
				.append(method).append("('").append(srcId).append("','")
				.append(type.getName()).append("',")
				.append(instanceStr).append(");")
				.append(NEW_LINE);
		}
	

	//
	// Private
	//
	private static String getDispatch(final String event) {
//		return "return "+EVENT_DISPATCHER+"." + event + "(this)";
		//SP
		return "return "+EVENT_DISPATCHER+".run(this,null,'" + event + "')";
		//return "return vjo.h.$e(this,null,'" + event + "')";
	}

	private static String getDispatchWithNativeEvent(final String event) {
//		return "return "+EVENT_DISPATCHER+"." + event + "(this,event)";
		//SP
		return "return "+EVENT_DISPATCHER+".run(this,event,'" + event + "')";
		//return "return vjo.h.$e(this,event,'" + event + "')";
	}

}
