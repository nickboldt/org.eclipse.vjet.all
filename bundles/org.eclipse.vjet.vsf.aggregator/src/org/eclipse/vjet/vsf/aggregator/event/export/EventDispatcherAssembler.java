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

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.dom.DElement;
import org.eclipse.vjet.dsf.html.ctx.HtmlCtx;
import org.eclipse.vjet.dsf.html.dom.BaseHtmlElement;
import org.eclipse.vjet.dsf.html.dom.DBody;
import org.eclipse.vjet.dsf.html.dom.HtmlTypeEnum;
import org.eclipse.vjet.dsf.html.events.DsfEventTarget;
import org.eclipse.vjet.dsf.html.events.EventHandlerAttacher;
import org.eclipse.vjet.dsf.html.events.EventHandlerContainer;
import org.eclipse.vjet.dsf.html.events.EventHandlerContainer.EventsToHandlerPair;
import org.eclipse.vjet.dsf.html.events.IDomEventType;
import org.eclipse.vjet.dsf.html.events.InlineEventHandlerConverter;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotter;
import org.eclipse.vjet.dsf.spec.collector.ResourceSpecCollector;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.dsf.spec.resource.IResourceSpec;
import org.eclipse.vjet.vsf.EventDispatcherJsr;
import org.eclipse.vjet.vsf.jsruntime.context.JsRuntimeCtx;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.JsType;
import org.eclipse.vjet.vsf.resource.pattern.js.OnFlyJsResourceDispenser;

import vjo.RegistryJsr;

public class EventDispatcherAssembler 
	extends OnFlyJsResourceDispenser
	implements IEventDispatcherAssembler
{
	private static final String NEW_LINE = System.getProperty("line.separator");
	public static final String BODY_ID = "body";
	public boolean m_optimizeJs = true;
	
	//private static final String PAGE_READY = "vjo.dsf.EventDispatcher.load(document.body);";
	private static EventDispatcherAssembler s_instance 
		= new EventDispatcherAssembler();

	protected EventDispatcherAssembler() {
		// empty on purpose
	}

	public static EventDispatcherAssembler getInstance() {
		return s_instance;
	}

	public void processEventHandling(
		final DBody body, final JsResourceSlotter slotter)
	{
		String id = body.getHtmlId();
		if(id=="" || id==null){
			body.setHtmlId(BODY_ID);
		}
		
//		For Active mode, we have to dispatch all inline events through event dispatcher.
		if(HtmlCtx.ctx().isDisableInlineHandler()){
			InlineEventHandlerConverter.convert();
		}
		
		final EventHandlerContainer eventHdlContainer 
			= HtmlCtx.ctx().getEventHandlerContainer();

		if (eventHdlContainer.size() == 0) {
			return;
		}

		final EventDispatcherEnabler enabler = new EventDispatcherEnabler();
		addToJsSlot(slotter, EventDispatcherJsr.ResourceSpec.getInstance());
		addToJsSlot(slotter, RegistryJsr.ResourceSpec.getInstance());

		//getJsCodeGen(body, eventHdlContainer, enabler, slotter);
		String data = EventDispatcherEnabler.extractEventHandlerData(eventHdlContainer, m_optimizeJs);
//		TODO - SP - Remove
//		System.out.println("\n/* size=" + data.length() + " bytes */");
		if (data!=null && !"".equals(data)) {
			slotter.addToSlot(jsRef(
					JsResource.viaText(data, null),
					JsType.ExecutionOnly));	
		}
		
		if (JsRuntimeCtx.ctx().useInlineEventBinding()) {
			attachEventHandlingTrigger(body, eventHdlContainer, enabler);
		}
	}

	private static void addToJsSlot(JsResourceSlotter slotter, final IComponentSpec rootSpec) {
		
		ResourceSpecCollector specCollector = new ResourceSpecCollector();
		specCollector.aggregate(rootSpec);		
		for (IResourceSpec spec: specCollector) {
			for (IJsResourceRef resource: spec.getClassDefinitions()) {
				slotter.addToSlot(resource);
			}
			
			for (IJsResourceRef resource: spec.getExecutingScript()) {
				slotter.addToSlot(resource);
			}			
		}		
	}

//	@Deprecated
//	protected void getJsCodeGen(final DBody body,
//		final EventHandlerContainer container,
//		final EventDispatcherEnabler enabler,
//		final JsResourceSlotter slotter)
//	{
//		final RopeBufferWriter jsContent = new RopeBufferWriter();
//		JsRuntimeCtx.ctx().getCompRegistry().setRegistryVar(
//				JsComponentRegistry.JSVAR_OREGISTRY_SHORT);
//		for (DsfEventTarget element : container.getElements().keySet()) {
//			if (element.getType() == HtmlTypeEnum.BODY) {
//				element.setElem(body);
//				element.setType(null);
//			}
//			if (element.getElem() instanceof BaseHtmlElement) {
//				collectEventHandling(/*body,*/ element.getElem(),
//					container.getElements().get(element),
//					enabler, slotter, jsContent);
//			} 
//			else if (element.getId() != null) {
//				exportEventHandling(
//					container.getElements().get(element),
//					enabler, slotter, jsContent, element.getId(), true);		
//			}
//		}
//
//		for (DsfEventTarget element : container.getElementsAttached().keySet()) {
//			if (element.getType() == HtmlTypeEnum.BODY) {
//				element.setElem(body);
//				element.setType(null);
//			}
//			
//			if (element.getElem() instanceof BaseHtmlElement) {
//				collectEventHandling(/*body,*/ element.getElem(),
//						container.getElementsAttached().get(element),
//						enabler,
//						slotter, jsContent);
//			} 
//			else if (element.getId() != null) {
//				exportEventHandling(container.getElements().get(element),
//						enabler, slotter, jsContent, element.getId(), true);
//			}
//		}
//		JsRuntimeCtx.ctx().getCompRegistry().resetRegistryVar();
//		if (jsContent.length() > 0) {
//			RopeBufferWriter writer = new RopeBufferWriter();
//			writer.write("(function(){").write(NEW_LINE).write("var ").write(
//					EventDispatcherEnabler.EVENT_DISPATCHER_SHORT).write(" = ")
//					.write(EventDispatcherEnabler.EVENT_DISPATCHER).write(";")
//					.write(NEW_LINE).write("var ").write(
//							JsComponentRegistry.JSVAR_OREGISTRY_SHORT).write(
//							" = ").write(JsComponentRegistry.JSVAR_OREGISTRY)
//					.write(";").write(NEW_LINE);
//			
//			// JsRuntimeCtx.ctx().getCompRegistry().getRegistryVar()
//			writer.write(jsContent.toString());
//			writer.write("})();");
//
//			slotter.addToSlot(jsRef(
//					JsResource.viaText(writer.toString(), null),
//					JsType.ExecutionOnly));
//		}
//		
//	}

	
	protected void attachEventHandlingTrigger(
		final DBody body,
		final EventHandlerContainer container,
		final EventDispatcherEnabler enabler)
	{
		for (DsfEventTarget element : container.getElements().keySet()) {
			DElement elem = element.getElem();
			//NOTE: body elements events will be added in js runtime, because we do
			//not want to create multiple body tags in portal case
			if (elem instanceof BaseHtmlElement && !(elem instanceof DBody)) {
				attachEventHandlingTrigger(
					body, element, container, enabler);
			}
		}
	}

//	@Deprecated
//	private void collectEventHandling(/*final DBody body,*/
//		final DElement element,
//		final Iterable<EventsToHandlerPair> pairs,
//		final EventDispatcherEnabler enabler,
//		final JsResourceSlotter slotter, 
//		final StringWriter jsContentBuf)
//	{
//		if (!element.hasEventHandlers()) {
//			return;
//		}
//
//		final String srcId;
//
//		// components may not have access to body during construction
//		// they may have a dummy body object that is not part of the doc
//		// we will reassign the DBody element to the real body of the
//		// document when this happens
//		if (element instanceof DBody) {
//			srcId = BODY_ID;
//		} 
//		else {
//			srcId = element.getAttribute("id") ; //getHtmlId();
//		}
//
//		exportEventHandling(pairs, enabler, slotter, jsContentBuf, srcId, false);
//	}

//	@Deprecated
//	private void exportEventHandling(
//		final Iterable<EventsToHandlerPair> pairs,
//		final EventDispatcherEnabler enabler,
//		final JsResourceSlotter slotter, 
//		final StringWriter jsContentBuf,
//		final String srcId,
//		final boolean byId)
//	{
//		for (EventsToHandlerPair pair : pairs) {
//			final IDomEventType type = pair.getEventType();
//
//			if (type == null) {
//				continue;
//			}
//			
//			final ISimpleJsEventHandler handler = pair.getHandler();
//			final StringBuilder sb = new StringBuilder(100);
//			
//			//predefined handler, no need to add it
////				IJsObjectRef oRef = null;
////				if (handler instanceof BaseJsHandler) {
////					oRef = ((BaseJsHandler)handler).getJsObject();
////				}
//
//		//	if (oRef == null) {
//			String def = handler.asJsDefinition();
//			if (def!=null&&!"".equals(def)) {
//				JsRuntimeCtx.ctx().getCompRegistry().resetRegistryVar();
//				sb.append(def);
//				JsRuntimeCtx.ctx().getCompRegistry().setRegistryVar(
//					JsComponentRegistry.JSVAR_OREGISTRY_SHORT);
//			}
//			//}
//			
//			slotter.addToSlot(
//				jsRef(JsResource.viaText(sb.toString(), null), JsType.DefOnly));
//
//			EventDispatcherEnabler.addHandlerRegistration(
//				srcId, type, pair.getHandler(), jsContentBuf, byId, true);
//		}
//	}

	protected void attachEventHandlingTrigger(
		final DBody body,
		final DsfEventTarget element,
		final EventHandlerContainer container,
		final EventDispatcherEnabler enabler)
	{
		if (!EventHandlerAttacher.hasEventHandlers(element.getElem())) {
			return;
		}

		// final String srcId;
		final DElement elementToWorkOn;

		// components may not have access to body during construction
		// they may have a dummy body object that is not part of the doc
		// we will reassign the DBody element to the real body of the
		// document when this happens
		if (element.getType() == HtmlTypeEnum.BODY 
			|| element.getElem() instanceof DBody)
		{
			elementToWorkOn = body;
		} 
		else {
			elementToWorkOn = element.getElem();
		}

//		final HtmlTypeEnum htmlType = elementToWorkOn.htmlType();
		for (EventsToHandlerPair pair : container.getElements().get(element)) {
			final IDomEventType type = pair.getEventType();
			if (type == null) {
				continue;
			}
			
			setUpEventTriggers(elementToWorkOn, enabler, type) ; //, htmlType);
		}
	}

	private void setUpEventTriggers(
		final DElement element,
		final EventDispatcherEnabler enabler,
		final IDomEventType eventType)
//		final HtmlTypeEnum htmlType)
	{
//		assertProperEvent(element, htmlType, eventType) ;
		
		enabler.addEventTrigger(element, eventType) ;
		enabler.enableEvent(eventType);
	}

//	private void assertProperEvent(
//		final DElement element,
//		final HtmlTypeEnum htmlType, 
//		final IDomEventType eventType)
//	{	
//		if (!DsfVerifierConfig.getInstance().isVerifyRelationship()) {
//			return ;
//		}
//		
//		// Only valid in DBody and DFrameset elements
//		if (eventType == EventType.LOAD) {
//			if ((htmlType == HtmlTypeEnum.BODY
//				|| htmlType == HtmlTypeEnum.FRAMESET
//				|| htmlType == HtmlTypeEnum.IMG) == false)
//			{
//				chuck("onload() is only valid for BODY, IMG, or FRAMESET elements");
//			}
//		} 
//		else if (eventType == EventType.UNLOAD) {
//			if (! (htmlType == HtmlTypeEnum.BODY)) {
//				chuck("onunload() is only valid for BODY and FRAMESET elements");
//			}
//		}
//		// Only valid in DFormControl elements
//		else if (eventType == EventType.CHANGE) {
//			if (! (element instanceof IDFormControl)) {
//				chuck("onchange() is only valid for DFormControl elements");
//			}
//		} 
//		else if (eventType == EventType.SUBMIT) {
//			if (! (element instanceof DForm)) {
//				chuck("onsubmit() is only valid for DForm element");
//			}
//		} 
//		else if (eventType == EventType.RESET) {
//			if (! (element instanceof DForm)) {
//				chuck("onreset() is only valid for DForm element");
//			}
//		} 
//		else if (eventType == EventType.SELECT) {
//			if (! (element instanceof IDFormControl)) {
//				chuck("onselect() is only valid for DFormControl elements");
//			}
//		} 
//		else if (eventType == EventType.BLUR) {
//			if (! (element instanceof IDFormControl)) {
//				chuck("onblur( )is only valid for DFormControl elements");
//			}
//		} 
//		else if (eventType == EventType.FOCUS) {
//			if (! (element instanceof IDFormControl)) {
//				chuck("onfocus() is only valid for DFormControl elements");
//			}
//		}
////		// Keyboard events. NOT valid in base, bdo, br, frame, frameset, head
////		// html, iframe, meta, param, script, style and title elements
////		else if (eventType == EventType.ON_KEY_DOWN) {
////			enabler.addOnKeyDownEventTrigger(element);
////			enabler.enableEvent(eventType);
////		} 
////		else if (eventType == EventType.ON_KEY_PRESS) {
////			enabler.addOnKeyPressEventTrigger(element);
////			enabler.enableEvent(eventType);
////		} 
////		else if (eventType == EventType.ON_KEY_UP) {
////			enabler.addOnKeyUpEventTrigger(element);
////			enabler.enableEvent(eventType);
////		}
////		// Mouse events. NOT valid in base, bdo, br, frame, frameset, head
////		// html, iframe, meta, param, script, style and title elements
////		else if (eventType == EventType.ON_CLICK) {
////			enabler.addOnClickEventTrigger(element);
////			enabler.enableEvent(eventType);
////		} 
////		else if (eventType == EventType.ON_DBL_CLICK) {
////			enabler.addOnDblClickEventTrigger(element);
////			enabler.enableEvent(eventType);
////		} 
////		else if (eventType == EventType.ON_MOUSE_DOWN) {
////			enabler.addOnMouseDownEventTrigger(element);
////			enabler.enableEvent(eventType);
////		} 
////		else if (eventType == EventType.ON_MOUSE_MOVE) {
////			enabler.addOnMouseMoveEventTrigger(element);
////			enabler.enableEvent(eventType);
////		} 
////		else if (eventType == EventType.ON_MOUSE_OUT) {
////			enabler.addOnMouseOutEventTrigger(element);
////			enabler.enableEvent(eventType);
////		} 
////		else if (eventType == EventType.ON_MOUSE_OVER) {
////			enabler.addOnMouseOverEventTrigger(element);
////			enabler.enableEvent(eventType);
////		} 
////		else if (eventType == EventType.ON_MOUSE_UP) {
////			enabler.addOnMouseUpEventTrigger(element);
////			enabler.enableEvent(eventType);
////		}
//	}
	
//	private static void addPageInstanceJs(
//		final EventDispatcherEnabler enabler,
//		final StringWriter jsContentBuf)
//	{
//		jsContentBuf.write(enabler.getEventDispatcherInstanceJS());
//		jsContentBuf.write(NEW_LINE);
//	}

	private static void chuck(final String message) {
		throw new DsfRuntimeException(message);
	}
	
	private static IJsResourceRef jsRef(final JsResource resource, final JsType type) {
		return jsRef(resource, EventDispatcherAssembler.class, type);
	}

	public boolean isOptimizeJs() {
		return m_optimizeJs;
	}

	public void setOptimizeJs(boolean js) {
		m_optimizeJs = js;
	}
}
