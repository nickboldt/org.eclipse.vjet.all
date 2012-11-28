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
package org.eclipse.vjet.vsf.resource.pattern.js;

import org.eclipse.vjet.dsf.html.js.IJsContentGenerator;

public interface IJsParamGenerator extends IJsContentGenerator {

	void addParam(String key, Object value);
	
	void addParam(String key, byte value);
	
	void addParam(String key, short value);
	
	void addParam(String key, int value);

	void addParam(String key, long value);
	
	void addParam(String key, float value);

	void addParam(String key, double value);
	
	void addParam(String key, boolean value);
	
	void addParam(String key, char value);
	

	
}
