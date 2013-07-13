package org.eclipse.vjet.eclipse.internal.codeassist.select.translator;

import org.eclipse.vjet.dsf.jst.IJstNode;
import org.eclipse.vjet.dsf.jst.declaration.JstInferredType;
import org.eclipse.vjet.eclipse.internal.codeassist.select.JstNodeDLTKElementResolver;

public class JstInferredTypeToDLTKTranslator extends DefaultNodeTranslator {

	@Override
	public IJstNode lookupBinding(IJstNode jstNode) {
		JstInferredType jstTypeRefType = (JstInferredType)jstNode;
		return JstNodeDLTKElementResolver.lookupBinding(jstTypeRefType.getType());
	}

}
