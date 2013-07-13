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
package org.eclipse.vjet.vsf.resource.pattern.js.coverage;

import java.util.ArrayList;
import java.util.Iterator;

public class JsCoverageType {
	String m_typeName;
	JsCoverageFunction [] m_typeFunctions;
	ArrayList <JsCoverageFunction> m_typeFunctionsTotal = new ArrayList<JsCoverageFunction>();
	boolean hasCoverage = false;
	
	public JsCoverageType(){
	}
	
	public JsCoverageType(final String name){
		m_typeName = name;
	}
	
	public void addInstrumentedFunction(final String funcName){
		m_typeFunctionsTotal.add(new JsCoverageFunction(funcName));
	}
	
	public boolean isInstrumentedFunction(final String funcName){
		if(getInstrumentedFunction(funcName) != null){
			return true;
		}
		return false;
	}
	
	public JsCoverageFunction getInstrumentedFunction(final String funcName){
		final Iterator<JsCoverageFunction> iter = m_typeFunctionsTotal.iterator();
		while(iter.hasNext()){
			JsCoverageFunction function = iter.next();
			if(funcName.equalsIgnoreCase(function.getFunctionName())){
				return function;
			}
		}
		return null;
	}
	

	public JsCoverageFunction [] getTypeFunctions() {
		final Iterator<JsCoverageFunction> iter = m_typeFunctionsTotal.iterator();
		m_typeFunctions = new JsCoverageFunction[m_typeFunctionsTotal.size()];
		for(int i=0; iter.hasNext();i++){
			JsCoverageFunction function = iter.next();
			m_typeFunctions[i] = function;
			
		}
		if(m_typeFunctions == null){
			return new JsCoverageFunction [0];
		}
		return m_typeFunctions;
	}

	public void setTypeFunctions(final JsCoverageFunction [] typeFunctions) {
		m_typeFunctions = typeFunctions;
	}

	public String getTypeName() {
		return m_typeName;
	}

	public void setTypeName(final String typeName) {
		m_typeName = typeName;
	}
}
