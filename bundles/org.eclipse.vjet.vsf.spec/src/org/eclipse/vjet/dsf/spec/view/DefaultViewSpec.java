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
package org.eclipse.vjet.dsf.spec.view;


import org.eclipse.vjet.dsf.resource.slot.ExternalizedSlotGrouping;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotter;
import org.eclipse.vjet.dsf.resource.slot.ScriptType;
import org.eclipse.vjet.dsf.resource.slot.simple.JsSlotBaseName;
import org.eclipse.vjet.dsf.resource.slot.simple.SimpleJsResourceSlotter;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;

public class DefaultViewSpec extends BaseViewSpec {

	public static final String UNDEFINED = "undefined";
	
	//
	// Constructor
	//
	public DefaultViewSpec(){
		this(UNDEFINED);
	}
	
	public DefaultViewSpec(final String name){
		super(name);
		ExternalizedSlotGrouping jsSlotGroupping = getExternalizedJsSlotGrouping();
		jsSlotGroupping.put(
			getSlotName(JsSlotBaseName.BEFORE_ANY_HTML_RENDER, ScriptType.ClassDefinition), "1");
		jsSlotGroupping.put(
			getSlotName(JsSlotBaseName.BEFORE_ANY_HTML_RENDER, ScriptType.ExecutingScript), "1");
		jsSlotGroupping.put(
			getSlotName(JsSlotBaseName.BEFORE_PAGE_HTML_RENDER, ScriptType.ClassDefinition), "1");
		jsSlotGroupping.put(
			getSlotName(JsSlotBaseName.BEFORE_PAGE_HTML_RENDER, ScriptType.ExecutingScript), "1");
		jsSlotGroupping.put(
			getSlotName(JsSlotBaseName.AFTER_PAGE_HTML_RENDER, ScriptType.ClassDefinition), "1");
		jsSlotGroupping.put(
			getSlotName(JsSlotBaseName.AFTER_PAGE_HTML_RENDER, ScriptType.ExecutingScript), "1");
		jsSlotGroupping.put(
			getSlotName(JsSlotBaseName.AFTER_ANY_HTML_RENDER, ScriptType.ClassDefinition), "1");
		jsSlotGroupping.put(
			getSlotName(JsSlotBaseName.AFTER_ANY_HTML_RENDER, ScriptType.ExecutingScript), "1");
	}
	
	@Override
	public DefaultViewSpec setComponentSpec(final IComponentSpec componentSpec){
		super.setComponentSpec(componentSpec);
		return this;
	}


	public JsResourceSlotter createJsResourceSlotter() {
		JsResourceSlotter slotter = new SimpleJsResourceSlotter(true);
		slotter.addSlotAssignment(getJsSlotAssignment());
		return slotter;
	}
	
	private static String getSlotName(String baseName, ScriptType type) {
		return SimpleJsResourceSlotter.getSlotName(baseName, type);
	}
}
