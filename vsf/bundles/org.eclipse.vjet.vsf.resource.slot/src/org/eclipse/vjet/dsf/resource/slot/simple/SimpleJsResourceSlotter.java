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
package org.eclipse.vjet.dsf.resource.slot.simple;

import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotter;
import org.eclipse.vjet.dsf.resource.slot.ScriptType;


public class SimpleJsResourceSlotter extends JsResourceSlotter {

	public SimpleJsResourceSlotter(boolean allowDynamicSlots) {
		setSlotsOrder(new String[] {
			getSlotName(JsSlotBaseName.BEFORE_ANY_HTML_RENDER, ScriptType.ClassDefinition),
			getSlotName(JsSlotBaseName.BEFORE_ANY_HTML_RENDER, ScriptType.ExecutingScript),
			getSlotName(JsSlotBaseName.SYS_OPTIONAL_A_BEFORE_ANY_HTML_RENDER, ScriptType.ClassDefinition),
			getSlotName(JsSlotBaseName.SYS_OPTIONAL_A_BEFORE_ANY_HTML_RENDER, ScriptType.ExecutingScript),
			getSlotName(JsSlotBaseName.BEFORE_PAGE_HTML_RENDER, ScriptType.ClassDefinition),
			getSlotName(JsSlotBaseName.BEFORE_PAGE_HTML_RENDER, ScriptType.ExecutingScript),
			getSlotName(JsSlotBaseName.COMMON_AFTER_PAGE_HTML_RENDER, ScriptType.ClassDefinition),
			getSlotName(JsSlotBaseName.COMMON_AFTER_PAGE_HTML_RENDER, ScriptType.ExecutingScript),
			getSlotName(JsSlotBaseName.AFTER_PAGE_HTML_RENDER, ScriptType.ClassDefinition),
			getSlotName(JsSlotBaseName.AFTER_PAGE_HTML_RENDER, ScriptType.ExecutingScript),
			getSlotName(JsSlotBaseName.AFTER_ANY_HTML_RENDER, ScriptType.ClassDefinition),
			getSlotName(JsSlotBaseName.AFTER_ANY_HTML_RENDER, ScriptType.ExecutingScript),
		}, allowDynamicSlots);
	}
	
//	private SimpleJsResourceSlotter() {}

	@Override
	public String getDefaultSlotName() {
		return JsSlotBaseName.AFTER_PAGE_HTML_RENDER;
	}

	@Override
	public SimpleJsResourceSlotter cloneAnEmptySlotter() {
		return new SimpleJsResourceSlotter(m_allowDynamicSlots);
	}	
}
