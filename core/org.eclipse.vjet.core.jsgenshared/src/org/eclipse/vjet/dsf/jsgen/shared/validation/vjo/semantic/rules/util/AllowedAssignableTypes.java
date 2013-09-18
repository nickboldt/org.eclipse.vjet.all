/*******************************************************************************
 * Copyright (c) 2013 Avantsoft Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.rules.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllowedAssignableTypes {


	private Map<String,List<String>> m_assignables = new HashMap<String, List<String>>();
	
	public AllowedAssignableTypes() {
		
	}



	public void addAssignable(String assignTo, String assignFrom) {
		// TODO Auto-generated method stub
		if(m_assignables.get(assignTo)==null){
			List<String> types = new ArrayList<String>();
			types.add(assignFrom);
			m_assignables.put(assignTo, types );
		}else{
			m_assignables.get(assignTo).add(assignFrom);
		}
		
	}



	public boolean isAssignable(String assignTo, String assignFrom) {
		if(m_assignables.containsKey(assignTo)){
			for (String t : m_assignables.get(assignTo)) {
				if(t.equals(assignFrom)){
					return true;
				}
			}
		}
		return false;
		
	}

}
