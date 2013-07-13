/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.vjet.dsf.spec.app;

import java.util.Map;

import org.eclipse.vjet.dsf.html.dom.DHtmlDocType;

public interface IDocAnnotationData {

String getContentType();
IDocAnnotationData setContentType(String type);
String getCharset();
IDocAnnotationData setCharset(String charSet);
Map<String,String> getMetaData();
DHtmlDocType.Type getDocType();
IDocAnnotationData setDocType(DHtmlDocType.Type type);
	
}
