/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jstojava.translator.robust.ast2jst;

import java.util.List;

import org.eclipse.vjet.dsf.jsgen.shared.ids.ScopeIds;
import org.eclipse.vjet.dsf.jst.IJstMethod;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.JstCommentLocation;
import org.eclipse.vjet.dsf.jst.JstSource;
import org.eclipse.vjet.dsf.jst.declaration.JstArg;
import org.eclipse.vjet.dsf.jst.declaration.JstBlock;
import org.eclipse.vjet.dsf.jst.declaration.JstCache;
import org.eclipse.vjet.dsf.jst.declaration.JstFuncType;
import org.eclipse.vjet.dsf.jst.declaration.JstMethod;
import org.eclipse.vjet.dsf.jst.expr.FuncExpr;
import org.eclipse.vjet.dsf.jst.meta.IJsCommentMeta;
import org.eclipse.vjet.dsf.jst.term.JstIdentifier;
import org.eclipse.vjet.dsf.jst.term.NV;
import org.eclipse.vjet.dsf.jst.token.IExpr;
import org.eclipse.vjet.dsf.jstojava.translator.JsDocHelper;
import org.eclipse.vjet.dsf.jstojava.translator.TranslateHelper;
import org.eclipse.vjet.dsf.jstojava.translator.robust.completion.JstCommentUtil;
import org.eclipse.vjet.dsf.jstojava.translator.robust.completion.JstCompletion;
import org.eclipse.vjet.dsf.jstojava.translator.robust.completion.JstFieldOrMethodCompletion;
import org.eclipse.mod.wst.jsdt.core.ast.IExpression;
import org.eclipse.mod.wst.jsdt.internal.compiler.ast.ASTNode;
import org.eclipse.mod.wst.jsdt.internal.compiler.ast.ObjectGetterSetterField;
import org.eclipse.mod.wst.jsdt.internal.compiler.ast.ObjectLiteral;
import org.eclipse.mod.wst.jsdt.internal.compiler.ast.ObjectLiteralField;
import org.eclipse.mod.wst.jsdt.internal.compiler.ast.SingleNameReference;

// TODO basic implementation for now
// 1. support both get and set
public class ObjectLiteralFieldGetterSetterTranslator extends
		BaseAst2JstTranslator<ObjectGetterSetterField, Object> {

	private NV m_result;

	@Override
	protected Object doTranslate(ObjectGetterSetterField astObjectliteralField) {
		// store completion position
		int completionPos = m_ctx.getCompletionPos();
		try {
		
			if (astObjectliteralField.initializer instanceof ObjectLiteral) {
				m_ctx.enterBlock(ScopeIds.PROPERTY);
			}
//			List<IJsCommentMeta> commentMeta = m_ctx.getCommentCollector().getCommentMeta(
//					astObjectliteralField.sourceStart,
//					m_ctx.getPreviousNodeSourceEnd(),
//					m_ctx.getNextNodeSourceStart());
			
			
		
				JstMethod mtd = new JstMethod();
				if(astObjectliteralField.varName!=null){
					IJstType objectT = JstCache.getInstance().getType("Object");
					mtd.addArg(new JstArg(objectT, astObjectliteralField.varName.toString(), false));
				}
				JstBlock blk = new JstBlock();
				mtd.setBlock(blk);
				TranslateHelper.addStatementsToJstBlock(astObjectliteralField.statements, blk, astObjectliteralField
						.sourceEnd(), m_ctx);
				if(astObjectliteralField.isSetter){
					mtd.setName("set");
				}else{
					mtd.setName("get");
				}
				
			 NV nv =  new NV();
			 FuncExpr expr = new FuncExpr(mtd);
			final JstIdentifier id = createId(astObjectliteralField);
			bindObjLiteralId(astObjectliteralField, id, expr, nv);
			nv.setName(id);
			nv.addChild(id);
			nv.setValue(expr);
			nv.addChild(expr);

			// value = TranslateHelper
			// .getCastable(value, metaArr, m_ctx);
			


//			List<String> comments = new ArrayList<String>();
//			String comment =  m_ctx.getCommentCollector().getCommentNonMeta2(astObjectliteralField.sourceStart);
			JstCommentLocation comment =  m_ctx.getCommentCollector().getCommentLocationNonMeta2(astObjectliteralField.sourceStart);
//			if(comment!=null){
//				comments.add(comment);
//			}
//			nv.setComments(comments)
			if(comment!=null){
				nv.addCommentLocation(comment);
			}

//			nv.setComments(m_ctx.getCommentCollector().getCommentNonMeta(
//					astObjectliteralField.sourceStart()));
//			int start = id.getSource().getStartOffSet();
//			if (value != null && value.getSource() != null) {
//				int end = value.getSource().getEndOffSet();
//				int length = end - start;
//				nv.setSource(TranslateHelper.createJstSource(
//						m_ctx.getSourceUtil(), length, start, end));
//			}
//			if (astObjectliteralField.initializer instanceof ObjectLiteral) {
//				m_ctx.exitBlock();
//			}
			m_result = nv;
			return nv;
		} finally {
			// restore previous completion position
			m_ctx.setCompletionPos(completionPos);
		}
	}

	private void bindObjLiteralId(ObjectLiteralField astObjectliteralField,
			final JstIdentifier id, IExpr value, NV nv) {
		// added by huzhou@ebay.com to bind objectLiteral's methods early on
		if (value instanceof FuncExpr) {
			final TranslateHelper.RenameableSynthJstProxyMethod mtdBinding = new TranslateHelper.RenameableSynthJstProxyMethod(
					((FuncExpr) value).getFunc(), id.getName());
			id.setJstBinding(mtdBinding);
			id.setType(new JstFuncType(mtdBinding));
		}

		final List<IJsCommentMeta> metaArr = getCommentMeta(astObjectliteralField);
		
		if (metaArr != null && metaArr.size() > 0) {
			final IJsCommentMeta meta = metaArr.get(0);
			if (meta.getTyping() != null) {
				nv.setOptional(meta.getTyping().isOptional());
				final IJstType metaDefinedType = TranslateHelper.findType(
						m_ctx, meta.getTyping(), meta);
				if (metaDefinedType != null) {
					id.setType(metaDefinedType);

					if (metaDefinedType instanceof JstFuncType) {
						final IJstMethod replacement = TranslateHelper.MethodTranslateHelper
								.createJstSynthesizedMethod(metaArr, m_ctx,
										id.getName());
						
						String commentStr =  m_ctx.getCommentCollector().getCommentNonMeta2(astObjectliteralField.sourceStart);
						
						 JsDocHelper.addJsDoc(commentStr, (JstMethod)((JstFuncType)metaDefinedType).getFunction());
						
						if (replacement != null) {
							JsDocHelper.addJsDoc(commentStr, (JstMethod)replacement);
							TranslateHelper.replaceSynthesizedMethodBinding(id,
									replacement);
							
							
							
							
							
						}
					}
				}
			}
		}
	}

	private List<IJsCommentMeta> getCommentMeta(ObjectLiteralField ast) {
		return m_ctx.getCommentCollector().getCommentMeta(ast.sourceStart,
				m_ctx.getPreviousNodeSourceEnd(),
				m_ctx.getNextNodeSourceStart());

	}
	


	private JstIdentifier createId(ObjectLiteralField astObjectliteralField) {
		JstIdentifier id = new JstIdentifier(astObjectliteralField
				.getFieldName().toString());
		int startOffset = astObjectliteralField.fieldName.sourceStart;
		int endOffset = astObjectliteralField.fieldName.sourceEnd;
		int length = endOffset - startOffset + 1;
		id.setSource(TranslateHelper.createJstSource(m_ctx.getSourceUtil(),
				length, startOffset, endOffset));
		return id;
	}

	@Override
	protected void checkForCompletion(ObjectGetterSetterField astNode) {
		if (m_ctx.isCreatedCompletion()) {
			return;
		}

		int startPos = astNode.sourceStart();
		int endPos = getSourceEnd(astNode);

		int completionPos = m_ctx.getCompletionPos();
		boolean insideSource = completionPos >= startPos
				&& completionPos <= endPos;

		boolean isAfterSource = completionPos == endPos + 1;
		if (!isAfterSource
				&& astNode.getInitializer() instanceof SingleNameReference) {
			final SingleNameReference missing = (SingleNameReference) astNode
					.getInitializer();
			if (TranslateHelper.MISSING_TOKEN.equals(String.valueOf(missing
					.getToken()))) {
				isAfterSource = true;
			}
		}

		if (insideSource || isAfterSource) {
			JstCompletion completion = createCompletion(astNode, isAfterSource);
			if (completion != null) {
				JstCommentUtil.fillCompletion((ASTNode) astNode, m_ctx,
						completion);
				// m_ctx.getS
				m_ctx.addSyntaxError(completion);
			}
		}
	}

	@Override
	protected JstCompletion createCompletion(
			ObjectGetterSetterField astObjectLiteralField, boolean isAfterSource) {

		int completionPos = m_ctx.getCompletionPos();
		if (completionPos < astObjectLiteralField.sourceStart) {
			return null;
		}

		String preStr = new String(m_ctx.getOriginalSource(),
				astObjectLiteralField.sourceStart, completionPos
						- astObjectLiteralField.sourceStart);
		if (preStr == null) {
			return null;
		}
		String[] strs = (" " + preStr + " ").split(":");
		if (strs.length == 0) {
			// TODO
			return null;
		} else if (strs.length == 1) {
			String token = strs[0].trim();
			JstCompletion completion = new JstFieldOrMethodCompletion(m_result,
					m_ctx.getCurrentScope() == ScopeIds.PROPS);
			IExpression expr = astObjectLiteralField.getFieldName();
			JstSource jstSource = null;
			if (expr != null) {
				if (expr.sourceEnd() + 1 > completionPos) {
					jstSource = createSource(expr.sourceStart(),
							expr.sourceEnd() + 1, m_ctx.getSourceUtil());
				} else {
					jstSource = createSource(expr.sourceStart(), completionPos,
							m_ctx.getSourceUtil());
				}
			}
			completion.setSource(jstSource);
			completion.setCompositeToken(preStr);
			completion.setToken(token);
			m_ctx.setCreatedCompletion(true);
			completion.setScopeStack(m_ctx.getScopeStack());
			return completion;
		} else if (strs.length == 2) {
			String token = strs[1].trim();
			// if cursor is After "(", null will be return
			if (token.indexOf("(") >= 0 || !isJavaIdentifier(token)) {
				return null;
			}
			JstCompletion completion = new JstFieldOrMethodCompletion(m_result,
					ScopeIds.PROPS == m_ctx.getCurrentScope());
			completion.setCompositeToken(preStr);
			completion.setToken(token);
			m_ctx.setCreatedCompletion(true);
			completion.setScopeStack(m_ctx.getScopeStack());
			return completion;
		}

		// }
		return null;
	}
}
