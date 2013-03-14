/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.vjo.tool.codecompletion.advisor;

import java.util.List;

import org.eclipse.vjet.dsf.jst.IJstMethod;
import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.declaration.JstArg;
import org.eclipse.vjet.dsf.jst.declaration.JstFuncType;
import org.eclipse.vjet.dsf.jst.declaration.JstFunctionRefType;
import org.eclipse.vjet.dsf.jst.expr.MtdInvocationExpr;
import org.eclipse.vjet.dsf.jst.term.JstIdentifier;
import org.eclipse.vjet.dsf.jst.token.IExpr;
import org.eclipse.vjet.dsf.jstojava.translator.TranslateHelper.RenameableSynthJstProxyMethod;
import org.eclipse.vjet.vjo.tool.codecompletion.IVjoCcAdvisor;
import org.eclipse.vjet.vjo.tool.codecompletion.VjoCcCtx;

/**
 * Advise parameters as tooltip when cursor is in MtdInvocationExpression
 * example1:<br>
 * function() { xxxx(<cursor>) }<br>
 * example2:<br>
 * function() { xx(a, <cursor>b }<br>
 * 
 * Needs attribute:<br>
 * ctx.actingType,<br>
 * 
 * ProposalData.data IjstMethod. <b4>
 * 
 * 
 * 
 */
public class VjoCcFunctionArgumentAdvisor extends AbstractVjoCcAdvisor implements
		IVjoCcAdvisor {
	public static final String ID = VjoCcFunctionArgumentAdvisor.class.getName();

	public void advise(final VjoCcCtx ctx) {
		final Object valueOfInfoKeyArgument = ctx.getInfo(VjoCcCtx.INFO_KEY_ARGUMENT);
		if (! (valueOfInfoKeyArgument instanceof IExpr)){
			return;
		}
		
		final IExpr argument = (IExpr)valueOfInfoKeyArgument;
		if(!(argument.getParentNode() instanceof MtdInvocationExpr)){
			return;
		}
		final MtdInvocationExpr mtdInvocationExpr = (MtdInvocationExpr) argument.getParentNode();
		final int position = mtdInvocationExpr.getArgs().indexOf(argument);
		IJstNode node = mtdInvocationExpr.getMethod();
		
		if(node instanceof JstIdentifier){
			node = ((JstIdentifier) node).getJstBinding();
		}
		
		if (node == null || !(node instanceof IJstMethod)) {
			return;
		}
		
		final IJstMethod method = (IJstMethod) node;
		
		
		
		
		IJstType calledType = method.getOwnerType();
		if (calledType == null) {
			return;
		}
		
		final List<JstArg> arguments = method.getArgs();
		if(arguments.size() <= position){
			return;
		}
		 IJstType parameterType = null;
		final IExpr parameterAtPos = mtdInvocationExpr.getArgs().get(position);
		final JstArg argAtPosition = arguments.get(position);
		if(parameterAtPos instanceof JstIdentifier){
			parameterType = ((JstIdentifier) parameterAtPos).getType();
		}else{
			return;
		}
		if(parameterType instanceof JstFuncType){
			IJstMethod function = ((JstFuncType)parameterType).getFunction();
			if(function.isDispatcher()){
				for (IJstMethod overload : function.getOverloaded()) {
					appendData(ctx, getParamNamedMethodProposal(argAtPosition, overload), false);
				}
			}else{
				appendData(ctx, getParamNamedMethodProposal(argAtPosition, function), true);
			}
		}
		else if(parameterType instanceof JstFunctionRefType){
			appendData(ctx, getParamNamedMethodProposal(argAtPosition, ((JstFunctionRefType)parameterType).getMethodRef()), true);
		}
	}

	private IJstMethod getParamNamedMethodProposal(
			final JstArg parameterAtPos, final IJstMethod method) {
		if(parameterAtPos == null || parameterAtPos.getName() == null){
			return method;
		}
		
		return new RenameableSynthJstProxyMethod(method, parameterAtPos.getName());
	}
}
