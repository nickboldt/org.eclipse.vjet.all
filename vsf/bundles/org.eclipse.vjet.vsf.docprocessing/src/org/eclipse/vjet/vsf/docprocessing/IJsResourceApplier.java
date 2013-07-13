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

import org.eclipse.vjet.dsf.dom.DDocument;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotter;

public interface IJsResourceApplier {
	void apply(DDocument doc, JsResourceSlotter slotter, boolean applyVersion);
}
