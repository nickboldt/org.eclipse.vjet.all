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
package org.eclipse.vjet.vsf.jsruntime.jsconverters;

import java.util.List;

import org.eclipse.vjet.dsf.common.converter.BaseConverter;
import org.eclipse.vjet.dsf.common.converter.IConversionResult;
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;
import org.eclipse.vjet.vsf.jsruntime.JsObjectRefWrapper;

public class JsObjRefArrayConverter extends BaseConverter<String>{

	private static final List<Class> VALID_CONVERSION_TYPES ;
		
		static {
			final Class[] types = {
					JsObjectRefWrapper.class} ;
			
				
			VALID_CONVERSION_TYPES = immutableTypeList(types) ;	
		}	
		/**
		 * Conversion should map IJsContentGenerator to 
		 * generated String
		 */
		public IConversionResult<String> convert(Object toBeConverted) {
			JsObjectRefWrapper contentWrapper = (JsObjectRefWrapper)toBeConverted;
			IJsObjectRef[] content = contentWrapper.getValue();
			StringBuilder contentStr = new StringBuilder("[");
			
			for(int i=0;i<content.length;i++){
				IJsObjectRef c = content[i];
				contentStr.append(c.getVariableRef());
				if(i!=content.length-1){
					contentStr.append(",");
				}
			}
			
			contentStr.append("]");
//			setResult(toBeConverted, content.getVariableRef())
			
			return setResult(toBeConverted, contentStr.toString());
		}

		public Class<String> getTargetType() {
			return String.class;
		}

		public List<Class> getValidConversionTypes() {
			return VALID_CONVERSION_TYPES;
		}

	}
