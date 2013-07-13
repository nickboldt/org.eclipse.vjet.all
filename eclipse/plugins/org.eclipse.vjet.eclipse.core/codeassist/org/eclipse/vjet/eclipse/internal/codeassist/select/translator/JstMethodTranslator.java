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

import org.eclipse.dltk.mod.core.IModelElement;
import org.eclipse.dltk.mod.core.IType;
import org.eclipse.dltk.mod.core.ModelException;
import org.eclipse.dltk.mod.internal.core.ModelElement;
import org.eclipse.vjet.dsf.jst.IJstMethod;
import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.declaration.JstMethod;
import org.eclipse.vjet.dsf.jst.expr.FuncExpr;
import org.eclipse.vjet.eclipse.codeassist.CodeassistUtils;
import org.eclipse.vjet.eclipse.core.IVjoSourceModule;
import org.eclipse.vjet.eclipse.core.VjetPlugin;
import org.eclipse.vjet.eclipse.internal.codeassist.select.JstNodeDLTKElementResolver;

/**
 * 
 * 
 */
public class JstMethodTranslator extends DefaultNodeTranslator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.vjet.eclipse.internal.codeassist.select.translator.DefaultNodeTranslator#convert(org.eclipse.vjet.dsf.jst.IJstNode)
	 */
	@Override
	public IModelElement[] convert(IVjoSourceModule module, IJstNode node) {
		IJstMethod jstMethod = (IJstMethod) node;
		
		// there is currently assumption that parent node is type when it could be another jstmethod
		// need to get IType -> IMethod -> IMethod in the nested case.
		
		
		IJstType ownerType = jstMethod.getOwnerType();
		IModelElement[] convert = JstNodeDLTKElementResolver.convert(module, ownerType);
		if(convert == null || convert.length==0){
			return null;
		}
		IType dltkType = (IType) convert[0];
		if (dltkType == null) {
			return null;
		}

		try {
			
			if(jstMethod.getParentNode() instanceof FuncExpr || jstMethod.getParentNode() instanceof JstMethod){
				// TODO get correct IMethod based on parent chain
				// what is the parent method? 
				// create dltk element under this structure IType -> IMethod -> IMethod -> N
				
				
				IModelElement element = CodeassistUtils.findDeclaringMethodChain(dltkType, jstMethod);
				String name = jstMethod.getName().getName();
				if(element.getElementName().equals(name)){
					return new IModelElement[]{element};
				}else{
					element = CodeassistUtils.findDeclaringObjectLiteralChain((ModelElement)element, node);
					// look for this method under object literal / fields
					
					if(element!=null){
						return new IModelElement[]{element};
					}
					
				}
				
				
				
				
				
			}else if(jstMethod.getParentNode() instanceof IJstType){
				
		
				IModelElement[] converted = CodeassistUtils.getMethod(dltkType, jstMethod);
				// TODO the next statement doesn't appear to be 
				if(converted == null){
					//check local method
					converted = CodeassistUtils.getLocalVar((org.eclipse.dltk.mod.compiler.env.ISourceModule) dltkType
							.getSourceModule(), jstMethod.getName().getName(), "Function", jstMethod.getSource());
				}
				
				return converted != null ?  converted
				: new IModelElement[0];
			
			}
		} catch (ModelException e) {
			VjetPlugin.error(e.getLocalizedMessage(), e);
		}
		return null;
	}
}
