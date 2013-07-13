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
package org.eclipse.vjet.vsf.aggregator.js;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.vjet.dsf.html.js.IJsFunc;
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotAssignment;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotter;
import org.eclipse.vjet.dsf.spec.collector.ResourceSpecCollector;
import org.eclipse.vjet.dsf.spec.resource.IResourceSpec;
import org.eclipse.vjet.vjo.bootstrap.VjBootstrap;
import org.eclipse.vjet.vsf.FirePageLoadJsr;
import org.eclipse.vjet.vsf.error.ErrorHandlerManagerJsr;
import org.eclipse.vjet.vsf.jsruntime.context.JsRuntimeCtx;
import org.eclipse.vjet.vsf.jsruntime.error.IErrorHandler;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceRef;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResourceProxy;
import org.eclipse.vjet.vsf.resource.pattern.js.JsType;
import org.eclipse.vjet.vsf.resource.pattern.js.OnFlyJsResourceDispenser;


public class JsProcessorUtils extends OnFlyJsResourceDispenser {
	
	public static final String ERROR_HANDLER_PREFIX = "_ERROR_";

	public static void addJsErrorHandling(final JsResourceSlotter slotter) {
		
		String[] slotsOrder = slotter.getSlotsOrder();		
		Map<String, Integer> slotsMap = new HashMap<String, Integer>();
		for (int i=0;i<slotsOrder.length;i++) {
			slotsMap.put(slotsOrder[i], i);
		}
								
		JsResourceSlotAssignment slotAssignment = new JsResourceSlotAssignment();
		
		//the two resource refs are fake refs to get access to the slot
		IJsResourceRef resDef = jsRef(JsResource.viaText("", ERROR_HANDLER_PREFIX), JsType.DefOnly);
		IJsResourceRef resExec = jsRef(JsResource.viaText("", ERROR_HANDLER_PREFIX), JsType.ExecutionOnly);
		
		String errorHandlerMgrSlot = slotter.getPreAssignedSlot(
			resDef, resDef.getUrn(), slotter.getDefaultSlotName());
		String errorHandlerMgrSlotDefExtended = JsResourceSlotter.getSlotName(
			errorHandlerMgrSlot, resDef.getType());
		String errorHandlerMgrSlotExecExtended = JsResourceSlotter.getSlotName(
			errorHandlerMgrSlot, resExec.getType());
		
		for (IErrorHandler errorHandler : JsRuntimeCtx.ctx().getErrorHandlers()) {

			ResourceSpecCollector specCollector2 = new ResourceSpecCollector();
			specCollector2.aggregate(errorHandler.getJsResource());		
			for (IResourceSpec spec: specCollector2) {
				for (IJsResourceRef resource: spec.getClassDefinitions()) {					
					String errorHandlerSlot = slotter.getPreAssignedSlot(
						resource, resource.getResource().getUrn(), slotter.getDefaultSlotName());
					String errorHandlerSlotExtended = JsResourceSlotter.getSlotName(
						errorHandlerSlot, resource.getType());
					if (slotsMap.get(errorHandlerSlotExtended).compareTo(
						slotsMap.get(errorHandlerMgrSlotDefExtended)) > 0)
					{
						slotAssignment.put(resource, errorHandlerMgrSlot);						
					}
				}
				
				for (IJsResourceRef resource: spec.getExecutingScript()) {
					String errorHandlerSlot = slotter.getPreAssignedSlot(
						resource, resource.getResource().getUrn(), slotter.getDefaultSlotName());
					String errorHandlerSlotExtended = JsResourceSlotter.getSlotName(
						errorHandlerSlot, resource.getType());
					if (slotsMap.get(errorHandlerSlotExtended).compareTo(
						slotsMap.get(errorHandlerMgrSlotExecExtended)) > 0)
					{
						slotAssignment.put(resource, errorHandlerMgrSlot);						
					}
				}			
			}
			
			//TODO find a better way to do generate js string
			IJsObjectRef jsObj = errorHandler.getJsObj();
			IJsFunc jsFunc = ErrorHandlerManagerJsr.register(jsObj);
			String reg = jsFunc.getScope() + "." + jsFunc.getName() 
				+ "(" + jsObj.getInstantiationJs() + ");";
			
			JsResource registration = JsResource.viaText(reg, null);
			JsResource registrationProxy = new JsResourceProxy(
					registration, ERROR_HANDLER_PREFIX + registration.getUrn());
			slotter.addToSlot(jsRef(registrationProxy, JsType.ExecutionOnly));
			
			//also remove from comp registry
			JsRuntimeCtx.ctx().getCompRegistry().remove(jsObj);
		}
		
		//TODO look to see if insert method is needed
		slotter.addSlotAssignment(slotAssignment);

	}

	public static void enableWindowOnError(final JsResourceSlotter slotter, boolean hideJsErrors) {
		enableWindowOnError(slotter, hideJsErrors, false); 
	}
	
	public static void enableWindowOnError(final JsResourceSlotter slotter, boolean hideJsErrors, boolean captureJsStackTrace) {
		IJsResourceRef res = jsRef(JsResource.viaText(ErrorHandlerManagerJsr.enableOnError(hideJsErrors,captureJsStackTrace).genInvocationJs(false), 
			ERROR_HANDLER_PREFIX + ErrorHandlerManagerJsr.class.getName()), JsType.ExecutionOnly);
		slotter.addToSlot(res);
	}

	public static void addVjBootstrap(final JsResourceSlotter slotter) {
		slotter.addToSlot(VjBootstrap.ResourceSpec.REF);
	}
	

	public static void addPageLoadTrigger(final JsResourceSlotter slotter) {
		slotter.addToSlot(jsRef(FirePageLoadJsr.ResourceSpec.RESOURCE, JsType.ExecutionOnly));
	}
	
	private static IJsResourceRef jsRef(final JsResource resource, final JsType type) {
		return jsRef(resource, JsProcessorUtils.class, type);
	}
}
