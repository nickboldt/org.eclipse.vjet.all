/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jstojava.translator.robust.ast2jst;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.mod.wst.jsdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.util.JstBindingUtil;
import org.eclipse.vjet.dsf.jst.BaseJstNode;
import org.eclipse.vjet.dsf.jst.IJstMethod;
import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.IJstTypeReference;
import org.eclipse.vjet.dsf.jst.JstSource;
import org.eclipse.vjet.dsf.jst.declaration.JstCache;
import org.eclipse.vjet.dsf.jst.declaration.JstFactory;
import org.eclipse.vjet.dsf.jst.declaration.JstFuncType;
import org.eclipse.vjet.dsf.jst.declaration.JstInferredType;
import org.eclipse.vjet.dsf.jst.declaration.JstMethod;
import org.eclipse.vjet.dsf.jst.declaration.JstSynthesizedMethod;
import org.eclipse.vjet.dsf.jst.declaration.JstVars;
import org.eclipse.vjet.dsf.jst.expr.AssignExpr;
import org.eclipse.vjet.dsf.jst.meta.IJsCommentMeta;
import org.eclipse.vjet.dsf.jst.meta.IJsCommentMeta.DIRECTION;
import org.eclipse.vjet.dsf.jst.term.JstIdentifier;
import org.eclipse.vjet.dsf.jst.token.IExpr;
import org.eclipse.vjet.dsf.jstojava.parser.comments.CommentCollector;
import org.eclipse.vjet.dsf.jstojava.translator.IFindTypeSupport;
import org.eclipse.vjet.dsf.jstojava.translator.TranslateHelper;

public class LocalDeclarationTranslator extends
		BaseAst2JstTranslator<LocalDeclaration, JstVars[]> {

			
		
	@Override
	protected JstVars[] doTranslate(LocalDeclaration statement) {

		LocalDeclaration origStatement = statement;
		
		IJsCommentMeta outerMeta = null;
		List<IJsCommentMeta> metaList = null;
		// outer comments
		final CommentCollector commentCollector = m_ctx.getCommentCollector();
		 int exprStartOffset = statement.declarationSourceStart;
		List<JstVars> varsList = new ArrayList<JstVars>();
		 int exprEndOffset = findSourceEnd(statement);
		 List<IJsCommentMeta> outerMetaList = commentCollector.getCommentMeta(exprStartOffset, exprEndOffset, 
				m_ctx.getPreviousNodeSourceEnd(),
				m_ctx.getNextNodeSourceStart());
		 
		 metaList = outerMetaList;
		
	
		
		boolean multiVar = false;

		
		
		IJstType outerJstType = null;
		if(statement.nextLocal!=null){
			multiVar = true;
			
		}
		if (metaList.size()>0 && metaList.get(0).getTyping() != null){
			 	outerMeta = metaList.get(0);
				outerJstType = TranslateHelper.findType(m_ctx, outerMeta.getTyping(), outerMeta);
		}
		int count = 0;
		
		do {
			
			IJstType jstType = null;
			IJsCommentMeta meta = null;
			// use this if there is nextLocal
			 if(multiVar && count==0 && outerMeta!=null && outerMeta.getDirection().equals(DIRECTION.FORWARD)){
					jstType = outerJstType;
				
			}
			else if(multiVar && statement.nextLocal!=null){
				exprStartOffset = statement.sourceStart;
				exprEndOffset = statement.sourceEnd;
				
				metaList = commentCollector.getCommentMeta(exprStartOffset, exprEndOffset, 
						m_ctx.getPreviousNodeSourceEnd(),
						statement.nextLocal.sourceStart);
			}else if(multiVar && statement.nextLocal==null && outerMetaList!=null){
				//metaList = outerMetaList;
				if(outerMeta!=null && outerMeta.getDirection().equals(DIRECTION.BACK)){
					jstType = outerJstType;
				}
			}
			
			String name = String.valueOf(statement.getName());
			JstIdentifier jstIdentifier = new JstIdentifier(name);
			JstSource source = TranslateHelper.getIdentifierSource(statement, m_ctx.getSourceUtil());
			jstIdentifier.setSource(source);
			
			//translate the children 1st
			IExpr init = null;
			
			
			if (statement.initialization != null) {
				init = (IExpr) getTranslatorAndTranslate(statement.initialization);
				BaseJstNode initBaseNode = (BaseJstNode)init;
				if(init != null && init instanceof BaseJstNode){//check if init consumes the comment
					List<IJsCommentMeta> metaFromExpr = TranslateHelper.findMetaFromExpr(initBaseNode);
					if(metaFromExpr!=null && metaFromExpr.size()!=0){
						metaList = metaFromExpr;
					}
					
				}
				if(metaList != null){
					init = TranslateHelper.getCastable(init, metaList, m_ctx);
					// done with meta array removing from tree
					
//					metaList = null;
//					List<BaseJstNode> children = initBaseNode.getChildren();
//					for (IJstNode child : children) {
//						if (child instanceof JsCommentMetaNode) {
//							initBaseNode.removeChild(child);
//							break;
//						}
//					}
					
				}
				else{
					init = TranslateHelper.getCastable(init, statement, m_ctx);
				}
			}
			
			// if multi var look up metatypes
			if(multiVar){
				if(metaList != null && metaList.size() > 0){
					meta = metaList.get(0);
				}
				else if(init != null && init instanceof BaseJstNode){//check if init consumes the comment
					BaseJstNode initBaseNode = (BaseJstNode)init;
					metaList = TranslateHelper.findMetaFromExpr(initBaseNode);
					if(metaList != null && metaList.size() > 0){
						meta = metaList.iterator().next();
					}
				}
			}
		
			if (meta != null) {
				jstType = getTypeFromMeta(jstType, meta,metaList,
						jstIdentifier, init);
			}
			AssignExpr assignExpr = new AssignExpr(jstIdentifier, init);
			assignExpr.setSource(TranslateHelper.getSource(statement, m_ctx.getSourceUtil()));
			
			
			IJstType foundType;
			if(multiVar){
				foundType = jstType;
			}else if(!multiVar && outerJstType==null){
				foundType = jstType; 
			}else if(outerMetaList!=null && outerMetaList.size()==1){
				foundType = outerJstType;
			}else{
				foundType = jstType;
			}
			
			boolean typeFound = true;
			if (foundType == null) {
				typeFound = false;
				foundType = JstCache.getInstance().getType("Undefined");
				
				if (foundType == null) {
					// THIS should never happen except for test cases where JstLib is not loaded
					foundType = JstFactory.getInstance().createJstType("Undefined", true);
				}
				foundType = new JstInferredType(foundType);
				
			}
			JstVars vars = new JstVars(foundType);
			if (meta != null) {
				if (meta.getModifiers().isFinal()) {
					vars.setIsFinal(true);
				}
			}
			
			if (origStatement!=null) {
				vars.setSource(getStatementSource(origStatement, m_ctx.getSourceUtil()));
	//			vars.setComments(commentCollector.getComments(
	//					m_ctx.getPreviousNodeSourceEnd(),
	//					findSourceEnd(origStatement)));
	//			vars.setCommentLocations(commentCollector.getCommentLocations(m_ctx.getPreviousNodeSourceEnd(),
	//					findSourceEnd(origStatement)));
			}
			
			vars.addAssignment(assignExpr);
			
			if (meta != null && typeFound) {
				IJstTypeReference typeRef = vars.getTypeRef();
				TranslateHelper.setTypeRefSource((BaseJstNode) typeRef, meta);
	//			vars.addCommentLocation(meta.getBeginOffset(),meta.getEndOffset());
				meta = null;
				metaList = null;
			}
			
			varsList.add(vars);
			
			count++;
		} while ((statement = (LocalDeclaration) statement.nextLocal) != null);

		
		return varsList.toArray(new JstVars[]{});
	}

	private IJstType getTypeFromMeta(IJstType jstType, IJsCommentMeta meta,
			List<IJsCommentMeta> metaList, JstIdentifier jstIdentifier,
			IExpr init) {
		if (meta.isCast() && init!=null) {
			jstType = init.getResultType();
		} 
		else if (meta.getTyping() != null){
			jstType = TranslateHelper.findType(m_ctx, meta.getTyping(), meta);
			
			//TODO combine this logic to TranslateHelper#findType
			if(jstType instanceof JstFuncType){
				IJstMethod replacement = null;
				//further check rhs of the assignment
				boolean rhsMethodFound = false;
				if(init != null){
					final IJstNode initBinding = JstBindingUtil.getJstBinding(init);
					rhsMethodFound = initBinding != null && initBinding instanceof JstMethod;
					if(rhsMethodFound){
						replacement = (IJstMethod)initBinding;
						jstIdentifier.setJstBinding(initBinding);
						jstType = init.getResultType() != null ? init.getResultType() : jstType;
						
//						replacement = TranslateHelper.MethodTranslateHelper.createJstSynthesizedMethod(metaList, m_ctx, "");
//						jstType = TranslateHelper.replaceSynthesizedMethodBinding(jstIdentifier,
//								replacement);
						
					}
				}
				if(!rhsMethodFound){
					// to solve the local function no overloading problem
					// we need to obtain the whole JsCommentMeta list declared for the local variable
					replacement = TranslateHelper.MethodTranslateHelper.createJstSynthesizedMethod(metaList, m_ctx, "");
//					if(replacement instanceof JstSynthesizedMethod){
//						((JstSynthesizedMethod) replacement).setParent(m_ctx.getCurrentType());
//					}
					
					jstType = TranslateHelper.replaceSynthesizedMethodBinding(jstIdentifier,
							replacement);
				}
			}
		}
		return jstType;
	}
	
	private static int findSourceEnd(LocalDeclaration statement) {
//		final IExpression initialization = statement.getInitialization();
//		if(initialization != null
//				&& initialization instanceof FunctionExpression){
//			return initialization.sourceStart();
//		}
		return statement.declarationSourceEnd;
	}
	
	private static JstSource getStatementSource(LocalDeclaration statement, IFindTypeSupport.ILineInfoProvider util) {
		int line = util.line(statement.declarationSourceStart);
		int col = util.col(statement.declarationSourceStart);
		return new JstSource(JstSource.JS, line, col, findSourceEnd(statement)
				- statement.declarationSourceStart + 1, statement.declarationSourceStart, findSourceEnd(statement));
	}
}
