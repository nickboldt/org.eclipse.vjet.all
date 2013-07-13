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

import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.IJstProperty;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.declaration.JstBlock;
import org.eclipse.vjet.dsf.jst.declaration.JstMethod;
import org.eclipse.vjet.dsf.jst.declaration.JstObjectLiteralType;
import org.eclipse.vjet.dsf.jst.declaration.SynthOlType;
import org.eclipse.vjet.dsf.jst.expr.AssignExpr;
import org.eclipse.vjet.dsf.jst.term.NV;
import org.eclipse.vjet.dsf.jst.term.ObjLiteral;
import org.eclipse.vjet.eclipse.codeassist.CodeassistUtils;
import org.eclipse.vjet.eclipse.core.IVjoSourceModule;
import org.eclipse.vjet.eclipse.core.VjetPlugin;
import org.eclipse.vjet.eclipse.internal.codeassist.select.JstNodeDLTKElementResolver;
import org.eclipse.dltk.mod.core.IField;
import org.eclipse.dltk.mod.core.IMember;
import org.eclipse.dltk.mod.core.IModelElement;
import org.eclipse.dltk.mod.core.IType;
import org.eclipse.dltk.mod.core.ModelException;
import org.eclipse.dltk.mod.internal.core.JSSourceField;
import org.eclipse.dltk.mod.internal.core.ModelElement;

/**
 * 
 * 
 */
public class JstPropertyTranslator extends DefaultNodeTranslator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.vjet.eclipse.internal.codeassist.select.translator.DefaultNodeTranslator#convert(org.eclipse.vjet.dsf.jst.IJstNode)
	 */
	@Override
	public IModelElement[] convert(IVjoSourceModule module, IJstNode node) {
		IJstProperty jstProperty = (IJstProperty) node;
		// TODO why does OwnerType return empty type for mixed in properties? 
		IJstType ownerType = jstProperty.getOwnerType();
		
		IModelElement[] elements = JstNodeDLTKElementResolver.convert(module, ownerType);
		
	
		if(elements.length==0 & ownerType instanceof SynthOlType){
			
			CodeassistUtils.findDeclaringBlock(node);
			// object literal type could be defined in block, function, vjo.otype
			
			elements = JstNodeDLTKElementResolver.convert(module, module.getJstType());
			IType dltkType = (IType)elements[0];
			String name = jstProperty.getName().getName();
			// object liteal name?
			ObjLiteral objectLiteral = ((SynthOlType)ownerType).getObjectLiteral();
//			String objLitName = ((AssignExpr)objectLiteral.getParentNode()).getLHS().toLHSText();
			NV nameval = objectLiteral.getNV(name);
			// this found declaring method but only works for first level functions under type
			IJstNode declaringBlock = CodeassistUtils.findDeclaringMethod(nameval);
			if(declaringBlock==null){
				declaringBlock = CodeassistUtils.findDeclaringBlock(nameval);
				
			}
			// doesn't now how to look up functions defined under functions?
			IModelElement element =null;
			if(declaringBlock instanceof JstMethod){
				IModelElement[] elementFromAry = JstNodeDLTKElementResolver.lookupAndConvert(declaringBlock);
				if(elementFromAry!=null && elementFromAry.length==1){
					element = elementFromAry[0];
				}
			
			}else if(declaringBlock instanceof JstBlock){
				try {
					element = dltkType.getChildren()[0];
				} catch (ModelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			
			try {
				IMember dltkMethod = (IMember) element;
				// TODO support selection engine for var x,y,z;
				
				element = CodeassistUtils.findDeclaringObjectLiteralFieldChain((ModelElement)dltkMethod, nameval);
				if(element!=null){
					return new IModelElement[] { element };
				}
				
			} catch (ModelException e) {
				VjetPlugin.error(e.getLocalizedMessage(), e);
			}
			
			

			// create reverse map
			// create ITypes for object literals? can they be hidden -- might be too much overhead
			
	
			
			// looking up property from dltk type may not be correct
			
			// TODO create field under correct method/function 
			
			// dltk light weight model...
			//               for this code:
			/*
			 * 				var x = { bar:"test"}
			 * 				yields :
			 * 				JstType (file name)
			 * 					JsField x
			 * 						JsField bar
			 * 
			 * 				When looking up 
			 * 				need to use type . getField() as parent
			 * 
			 * 
			 */
			//               file  - object literal (field of type) 
			// test if I can create type . getMethod() .getField . getField for object literal type?
			// test if I can create type . getField() . getField()  
			
			
			
	
		}else if(elements!=null && elements.length>0  && ownerType instanceof JstObjectLiteralType){
			// find otype that is requested
			try {
				IModelElement element = CodeassistUtils.findDeclaringObjectLiteralFieldChain((ModelElement)elements[0], node);
				if(element!=null){
					return new IModelElement[] { element };
				}
				System.out.println(element);
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		if(elements.length==0 || !(elements[0] instanceof IType)){
			return new IModelElement[0];
		}
		IType dltkType = (IType)elements[0];
		String name = jstProperty.getName().getName();
		IField field = dltkType.getField(name);
			
		return field != null ? new IModelElement[] { field }
		: new IModelElement[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.vjet.eclipse.internal.codeassist.select.translator.DefaultNodeTranslator#resolveBinding(org.eclipse.vjet.dsf.jst.IJstNode)
	 */
	@Override
	public IJstNode lookupBinding(IJstNode jstNode) {
		IJstProperty property = (IJstProperty) jstNode;
		// "this.vj$.[Type]" handling
		if (CodeassistUtils.isVjDollarProp(property)) {
			return JstNodeDLTKElementResolver.lookupBinding(property.getType());
		}
		return jstNode;
	}

}
