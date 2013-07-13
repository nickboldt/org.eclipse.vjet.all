package org.eclipse.vjet.eclipse.internal.codeassist.select.translator;

import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.declaration.JstInferredRefType;
import org.eclipse.vjet.eclipse.internal.codeassist.select.JstNodeDLTKElementResolver;

public class JstInferredRefTypeToDLTKTranslator extends DefaultNodeTranslator {

	@Override
	public IJstNode lookupBinding(IJstNode jstNode) {
		JstInferredRefType jstTypeRefType = (JstInferredRefType)jstNode;
		return JstNodeDLTKElementResolver.lookupBinding(jstTypeRefType.getType());
	}

}
