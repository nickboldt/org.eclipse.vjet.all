/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jstojava.translator;

import org.eclipse.vjet.dsf.jst.declaration.JstDoc;
import org.eclipse.vjet.dsf.jst.declaration.JstMethod;
import org.eclipse.vjet.dsf.jst.declaration.JstProperty;
import org.eclipse.vjet.dsf.jst.declaration.JstType;
import org.eclipse.vjet.dsf.jst.meta.IJsCommentMeta;

public class JsDocHelper {

	public static void addJsDoc(IJsCommentMeta meta, JstMethod jstMethod) {
		if (meta !=null && meta.getCommentSrc() != null) {
			String jsdoc = getJsDocFromStructuredComment(meta);
			if (jsdoc != "" ) {
				JstDoc jsDocNode = createJsDocNode(jsdoc);
				if(jsDocNode!=null){
					jstMethod.setDoc(jsDocNode);
				}
			}
		}
	}
	
	public static void addJsDoc(IJsCommentMeta meta, JstProperty property) {
		if (meta !=null &&meta.getCommentSrc() != null) {
			String jsdoc = getJsDocFromStructuredComment(meta);
			property.setDoc(createJsDocNode(jsdoc));

		}
	}

	public static void addJsDoc(String jsdoc, JstProperty property) {
		if (jsdoc != null) {
			if(!jsdoc.trim().startsWith("/**")){
				return;
			}
			property.setDoc(createJsDocNode(jsdoc));

		}
	}

	private static String getJsDocFromStructuredComment(IJsCommentMeta meta) {
		String[] split = meta.getCommentSrc().split(";");
		StringBuilder jsdoc = new StringBuilder();
		if (split.length >= 2) {
			for (int i = 1; i < split.length; i++) {
				jsdoc.append( split[i]);
			}
		}else{
			return null;
		}
		return jsdoc.toString().trim();
	}

	public static void addJsDoc(String jsdoc, JstType property) {
		if (jsdoc != null) {
			if(!jsdoc.trim().startsWith("/**")){
				return;
			}
			property.setDoc(createJsDocNode(jsdoc));

		}
	}

	public static void addJsDoc(IJsCommentMeta meta, JstType type) {

		if (meta !=null && meta.getCommentSrc() != null) {

			String jsdoc = getJsDocFromStructuredComment(meta);
			if (jsdoc != "") {
				type.setDoc(createJsDocNode(jsdoc));
			}
		}

	}

	private static JstDoc createJsDocNode(String jsdoc) {
		jsdoc = cleanJsDocComment(jsdoc);
		return new JstDoc(jsdoc);
	}
	
	public static String getJsDocFromVjetComment(String vjetDoc){
		if(vjetDoc==null){
			return null;
		}
		if(vjetDoc.indexOf(";")!=-1){
			String[] vjetDoc2 = vjetDoc.split(";");
			if(vjetDoc2.length>1){
				return cleanJsDocComment(vjetDoc2[1]);
			}
		}
		return "";
	}

	public static String cleanJsDocComment(String jsdoc) {
		if(jsdoc==null){
			return null;
		}
		jsdoc = jsdoc.trim();
		jsdoc = jsdoc.replaceAll("^/\\*\\*", "");
		jsdoc = jsdoc.replaceAll("^\\*", "");
		jsdoc = jsdoc.replaceAll("\\*/$", "");
		// commentSrc = commentSrc.replaceAll("^(\t)*(\\*)*", "");
		jsdoc = jsdoc.replaceAll("\\s+\\*", "\n");
		return jsdoc;
	}
	
	
	
	public static void addJsDoc(String jsdoc, JstMethod method) {
		if (jsdoc != null) {
			if(!jsdoc.trim().startsWith(("/**"))){
				return;
			}
		
			method.setDoc(createJsDocNode(jsdoc));
			

		}
	}
	
	
	
}
