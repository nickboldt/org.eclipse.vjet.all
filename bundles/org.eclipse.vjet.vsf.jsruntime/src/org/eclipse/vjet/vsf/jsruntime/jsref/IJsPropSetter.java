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
package org.eclipse.vjet.vsf.jsruntime.jsref;

import org.eclipse.vjet.dsf.common.binding.IValueBinding;
import org.eclipse.vjet.dsf.html.js.IJsContentGenerator;
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;

public interface IJsPropSetter extends IJsContentGenerator {

	/**
	 * Answer the object that represents this Prop
	 * @return IJsObjectRef
	 */
	public IJsObjectRef getObj();
	
	/**
	 * Answer the name of the Property
	 * @return String
	 */
	public String getName();
	
	/**
	 * Answer the binding for the value of the Property
	 * @return String
	 */
	public IValueBinding<?> getValue();
	
	/**
	 * Marks this property to be executed at the client immediately
	 * @return void
	 */
	public void onClient();
	
}
