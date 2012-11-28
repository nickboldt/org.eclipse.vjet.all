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
package org.eclipse.vjet.dsf.serializer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This is a runtime annotation which marks the class as a vjo serializable.
 * This means that the java class has an equivalent vjo type.
 * The vjoType info is needed and the vjoIdGetter info is optional
 * 
 * Annotation could be a better choice than interface for the reason that:
 * 1) annotation doesn't interfere with the java2js translation
 * 2) default value could be provided
 * 
 * @author huzhou
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AVjoSerializable {

	/**
	 * corresponding vjo type's full string name
	 * made optional as well in case type of vjo & type of java has the same name
	 * @return
	 */
	String vjoType() default "";
	
	/**
	 * vjoIdGetter is either empty, which lets the system assign a random id for registry
	 * or a qualified getter method name, which lets the system reflectively get the id
	 * 
	 * the 2nd case is useful when user would like an anticipated id for the serialization
	 * @return
	 */
	String vjoIdGetter() default "";
}
