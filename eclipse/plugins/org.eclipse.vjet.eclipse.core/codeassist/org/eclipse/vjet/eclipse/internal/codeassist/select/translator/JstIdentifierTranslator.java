/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
/**
 * 
 */
package org.eclipse.vjet.eclipse.internal.codeassist.select.translator;

import java.util.List;

import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.IJstProperty;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.declaration.SynthOlType;
import org.eclipse.vjet.dsf.jst.term.JstIdentifier;
import org.eclipse.vjet.dsf.jst.term.NV;
import org.eclipse.vjet.dsf.jst.term.ObjLiteral;
import org.eclipse.vjet.eclipse.codeassist.CodeassistUtils;
import org.eclipse.vjet.eclipse.internal.codeassist.select.JstNodeDLTKElementResolver;

/**
 * the ton unit jst node is JstIdentifier, this is the key translator based on
 * JstBinding.
 * 
 * 
 * 
 */
public class JstIdentifierTranslator extends DefaultNodeTranslator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.vjet.eclipse.internal.codeassist.select.translator.DefaultNodeTranslator#resolveBinding(org.eclipse.vjet.dsf.jst.IJstNode)
	 */
	@Override
	public IJstNode lookupBinding(IJstNode jstNode) {
		JstIdentifier identifier = (JstIdentifier) jstNode;
		
		// TODO should this part of binding? each client currently has to do this lookup.
		// see similiar logic in VjoCcObjLiteralAdvisor
		if(identifier.getParentNode() instanceof NV){
			NV realParent = (NV) identifier.getParentNode();
			String fieldName = realParent.getName();
			ObjLiteral enclosingObjLiteral = (ObjLiteral) ((NV) realParent)
					.getParentNode();
			final IJstType olExprType = enclosingObjLiteral.getResultType();
			if (olExprType != null && olExprType instanceof SynthOlType) {
				final SynthOlType enclosingObjLiteralType = (SynthOlType) olExprType;
				List<IJstType> olResolvedTypes = enclosingObjLiteralType
						.getResolvedOTypes();
				if(olResolvedTypes==null){
					return null;
				}
				for (IJstType iJstType : olResolvedTypes) {
					IJstProperty prop = iJstType.getProperty(fieldName);
					if(prop!=null){
						return prop;
					}
				}
				
			}
			
		}
		
		if (identifier.getJstBinding() == null) {
			return null;
		}
		if (isKeyWord(identifier)) {
			return null;
		}
		IJstNode binding = identifier.getJstBinding();
		

		//check the identifer in local variable declarion site.
		if((binding == null || binding instanceof IJstType) && CodeassistUtils.isLocalVarDeclaration(identifier)){
			binding = identifier.getParentNode().getParentNode();// JstVars
		}
		
		if(binding == null || binding == identifier){
			return null;
		}
		
		return JstNodeDLTKElementResolver.lookupBinding(binding);
	}

	private boolean isKeyWord(JstIdentifier identifier) {
		if ("this".equals(identifier.getName()))
			return true;
		if ("vj$".equals(identifier.getName()))
			return true;
		return false;
	}

}
