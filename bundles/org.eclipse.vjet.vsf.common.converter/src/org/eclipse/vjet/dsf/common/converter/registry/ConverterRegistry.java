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
package org.eclipse.vjet.dsf.common.converter.registry;

import org.eclipse.vjet.dsf.common.converter.BooleanConverter;
import org.eclipse.vjet.dsf.common.converter.DateConverter;
import org.eclipse.vjet.dsf.common.converter.DoubleConverter;
import org.eclipse.vjet.dsf.common.converter.IntegerArrayConverter;
import org.eclipse.vjet.dsf.common.converter.IntegerConverter;
import org.eclipse.vjet.dsf.common.converter.LongArrayConverter;
import org.eclipse.vjet.dsf.common.converter.LongConverter;
import org.eclipse.vjet.dsf.common.converter.StringArrayConverter;
import org.eclipse.vjet.dsf.common.converter.StringConverter;



public final class ConverterRegistry extends BaseConverterRegistry {
	
	private static final ConverterRegistry s_self = 
		new ConverterRegistry(
			true, 		// fail if someone stomps our global registry
			false) ;	// return null if nothing found for key
	
	//
	// Constructor(s)
	//
	private ConverterRegistry(
		final boolean failOnOverride, final boolean failOnNotFound)
	{
		super(failOnOverride, failOnNotFound) ;

		put(new BooleanConverter()) ;
		put(new DateConverter()) ;
		put(new DoubleConverter()) ;
		put(new IntegerConverter()) ;
		put(new IntegerArrayConverter()) ;
		put(new LongConverter()) ;
		put(new LongArrayConverter()) ;
		put(new StringConverter()) ;
		put(new StringArrayConverter()) ;
		
//		// TODO: Mappings for eBay's BaseEnum
//		put(BaseEnum.class, Integer.class, IntegerConverter.class) ;
//		put(BaseEnum.class, String.class, StringConverter.class) ;
//		
//		// TODO: Mappings for Java's Enum
//		put(Enum.class, Integer.class, IntegerConverter.class) ;
//		put(Enum.class, String.class, StringConverter.class) ;
//		
//		//
//		// Money, toType, Converter
//		//
//		put(Money.class, Money.class, MoneyConverter.class);
//		put(Money.class, String.class, StringConverter.class);	
//		put(Money.class, Double.class, DoubleConverter.class);	
//		
//		put(MoneyStringValue.class, Money.class, MoneyConverter.class);	
//		
//		//
//		// Date, toType, Converter
//		//
//		put(Date.class, Date.class, DateConverter.class);
//		put(Date.class, String.class, StringConverter.class);	
//		put(Date.class, Long.class, LongConverter.class);	
//		
//		put(DateTimeStringValue.class, Date.class, DateConverter.class);	
//								
//		//
//		// String, toType, Converter
//		//
//		put(String.class, String.class, StringConverter.class);	
//		put(String.class, Boolean.class, BooleanConverter.class);	
//		put(String.class, Integer.class, IntegerConverter.class);
//		put(String.class, Long.class, LongConverter.class);
//		put(String.class, Double.class, DoubleConverter.class);
//		
//		put(LocalizedStringValue.class, Integer.class, IntegerConverter.class);
//		put(LocalizedStringValue.class, Long.class, LongConverter.class);
//		put(LocalizedStringValue.class, Double.class, DoubleConverter.class);
//		
//		//
//		// Boolean, toType, Converter
//		//
//		put(Boolean.class, Boolean.class, BooleanConverter.class);
//		put(Boolean.class, Integer.class, IntegerConverter.class);
//		put(Boolean.class, Long.class, LongConverter.class);
//		put(Boolean.class, String.class, StringConverter.class);
//
//		//
//		// Integer, toType, Converter
//		//
//		put(Integer.class, Integer.class, IntegerConverter.class);
//		put(Integer.class, Boolean.class, BooleanConverter.class) ;		
//		put(Integer.class, Long.class, LongConverter.class) ;
//		put(Integer.class, Double.class, DoubleConverter.class) ;	
//		put(Integer.class, String.class, StringConverter.class) ;
//			
//		// 
//		// Long, toType, Converter
//		//
//		put(Long.class, Long.class, LongConverter.class) ;
//		put(Long.class, Boolean.class, BooleanConverter.class) ;	
//		put(Long.class, Integer.class, IntegerConverter.class);
//		put(Long.class, Double.class, DoubleConverter.class) ;
//		put(Long.class, String.class, StringConverter.class) ;	
//		put(Long.class, Date.class, DateConverter.class) ;
//				
//		// 
//		// Double, toType, Converter
//		//
//		put(Double.class, Double.class, DoubleConverter.class) ;
//		put(Double.class, Boolean.class, BooleanConverter.class) ;
//		put(Double.class, Integer.class, IntegerConverter.class);
//		put(Double.class, Long.class, LongConverter.class) ;		
//		put(Double.class, String.class, StringConverter.class) ;	
//		
//		// String[], toType, Converter
//		put(String[].class, String[].class, StringArrayConverter.class) ;
//		put(String[].class, Integer[].class, IntegerArrayConverter.class) ;
//		
//		put(LocalizedStringValue[].class, String[].class, StringArrayConverter.class) ;
//		put(LocalizedStringValue[].class, Integer[].class, IntegerArrayConverter.class) ;				
//		put(LocalizedStringValue[].class, Long[].class, LongArrayConverter.class) ;				
	}
	
	//
	// API
	//
	public static ConverterRegistry getInstance() {
		return s_self ;
	}
}