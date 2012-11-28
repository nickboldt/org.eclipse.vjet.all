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
package org.eclipse.vjet.dsf.resource.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * Marker interface inserted into Java that is code-generated.
 * It indicates the class is code-generated and identifies the
 * Class that did the code-generation. It is used to by triggers
 * to prevent checking in code-generated classes.
 */
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.CLASS)
public @interface CodeGen {

	String value();
	
}
