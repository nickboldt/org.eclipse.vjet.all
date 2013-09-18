/*******************************************************************************
 * Copyright (c) 2013 Avantsoft Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.rules.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Registry of allowed assignable types by group
 * 
 * boolean isAssignable(String groupid, IJstType assignTo, IJstType assignFrom)
 * 
 * void registerAllowedConversion(String groupId, IJstType assignTo, IJstType assignFrom)
 * void registerAllowedConversion(String groupId, AllowedAssignableTypes conversion);
 * void registerAllowedConversion(String groupId, String assignTo, String assignTo) // fully qualified type names
 * 
 * Type issues 
 * Object[] -> MixedCollection (named type but all arrays convert
 * 
 * 
 * 
 */
public class AssignableTypeRegistry {
	
	private static AssignableTypeRegistry s_instance = new AssignableTypeRegistry();
	private Map<String, AllowedAssignableTypes> m_allowedAssignableTypes = new LinkedHashMap<String, AllowedAssignableTypes>();

	public static AssignableTypeRegistry getInstance() {
		return s_instance;
	}
	
	public void registerAllowedConversion(String groupId, String assignTo, String assignFrom){
		
		if(m_allowedAssignableTypes.get(groupId)!=null){
			m_allowedAssignableTypes.get(groupId).addAssignable(assignTo,assignFrom);
			return;
		}
		
		AllowedAssignableTypes types = new AllowedAssignableTypes();
		types.addAssignable(assignTo, assignFrom);
		m_allowedAssignableTypes.put(groupId, types);
	}
	

	public boolean isAssignable(String groupid, String assignTo, String assignFrom){
		if(m_allowedAssignableTypes.containsKey(groupid)){
			return m_allowedAssignableTypes.get(groupid).isAssignable(assignTo,assignFrom);
		}
		return false;
	}
	
//	public IMetaExtension getExtentedArgBinding(
//		String targetFunc, String key, String groupId, List<String> dependentGroupIds) {
//		
//		IMetaExtension method = getExtentedArgBinding(targetFunc, key, groupId);
//		if (method == null && dependentGroupIds != null) {
//			for (int i = 0; i < dependentGroupIds.size(); i++) {
//				method = getExtentedArgBinding(targetFunc, key, dependentGroupIds.get(i));
//				if (method != null) {
//					break;
//				}
//			}
//		}		
//		return method;
//	}
		
	public void clear(String groupId) {
		m_allowedAssignableTypes.remove(groupId);

	}
	
	public void clearAll() {
		m_allowedAssignableTypes.clear();
	}
	

}
