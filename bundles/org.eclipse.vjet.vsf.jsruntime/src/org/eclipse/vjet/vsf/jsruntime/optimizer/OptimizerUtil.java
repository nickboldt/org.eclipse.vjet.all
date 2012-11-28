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
package org.eclipse.vjet.vsf.jsruntime.optimizer;

import org.eclipse.vjet.dsf.common.converter.IConverter;
import org.eclipse.vjet.dsf.common.exceptions.DsfException;
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.html.js.IJsFunc;
import org.eclipse.vjet.dsf.html.js.IJsObjectRef;
import org.eclipse.vjet.vsf.jsruntime.context.JsRuntimeCtx;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.DefaultJava2JsConverter;
import org.eclipse.vjet.vsf.jsruntime.jsconverters.registry.Java2JsTypeConverterRegistration;

public class OptimizerUtil {
	public static IJsOptimizer createOptimizer(Object obj) throws DsfException {
		if (obj instanceof IJsObjectRef) {
			return new JsObjOptimizer((IJsObjectRef)obj);
		} else if (obj instanceof IJsFunc) {
			return new JsFuncOptimizer((IJsFunc)obj);
		}
		return null;
	}
	public static IConverter getDefaultConverter(Object value) {
		Class fromType = null;
		Class toType = null;
		Java2JsTypeConverterRegistration registry = JsRuntimeCtx.ctx()
				.getConverterRegistry();

		try {
			if (value != null) {
				fromType = value.getClass();
			}
			toType = String.class;
			IConverter converter = null;

			while (fromType!=null) {
				converter = registry.get(fromType, toType);
				if (converter!=null) {
					return converter;
				}
				Class[] clzs = fromType.getInterfaces();
				if (converter == null && clzs != null) {
					for (Class clz : clzs) {
						IConverter tmp = registry.get(clz, toType);
						if (tmp != null) {
							return tmp;
						}
					}
				}
				fromType = fromType.getSuperclass();
			}
//			if (fromType != null) {
//				converter = registry.get(fromType, toType);
//				Class[] clzs = fromType.getInterfaces();
//				if (converter == null && clzs != null) {
//					for (Class clz : clzs) {
//						IConverter tmp = registry.get(clz, toType);
//						if (tmp != null) {
//							return converter;
//						}
//					}
//				}
//			}
			if (converter == null) {
				return new DefaultJava2JsConverter();
			}

			return converter;
		} catch (RuntimeException e) {
			throw new DsfRuntimeException(
					"Got exception when looking up the registry: fromType:"
							+ fromType + " toType:" + toType + " value: "
							+ value, e);
		}

	}
}
