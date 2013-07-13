/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.css.dom.impl;

import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.batik.css.parser.CSSLexicalUnit;
import org.eclipse.vjet.dsf.css.dom.IHslColor;
import org.eclipse.vjet.dsf.css.dom.IHslaColor;
import org.eclipse.vjet.dsf.css.dom.IRgbaColor;
import org.eclipse.vjet.dsf.css.parser.DCssBuilder;
import org.w3c.css.sac.InputSource;
import org.w3c.css.sac.LexicalUnit;
import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.CSSValueList;
import org.w3c.dom.css.Counter;
import org.w3c.dom.css.RGBColor;
import org.w3c.dom.css.Rect;

/**
 * @see org.w3c.dom.css.CSSPrimitiveValue
 * @see org.w3c.dom.css.CSSValueList
 */

public class DCssValue implements CSSPrimitiveValue, CSSValueList,
		Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private Object m_value = null;

	public DCssValue(LexicalUnit value, boolean forcePrimitive) {
		if ((value.getNextLexicalUnit() == null)) {
			switch(value.getLexicalUnitType()) {
				case LexicalUnit.SAC_RECT_FUNCTION:
					m_value = new DCssRect(value.getParameters());
					break ;
				case LexicalUnit.SAC_RGBCOLOR:
					m_value = new DCssRgbColor(value.getParameters());
					break ;
//				case LexicalUnit.SAC_RGBACOLOR:
//					m_value = new DCssRgbaColor(value.getParameters());
//					break ;
//				case LexicalUnit.SAC_HSLCOLOR:
//					m_value = new DCssHslColor(value.getParameters());
//					break ;
//				case LexicalUnit.SAC_HSLACOLOR:
//					m_value = new DCssHslaColor(value.getParameters());
//					break ;
				case LexicalUnit.SAC_COUNTER_FUNCTION:
					m_value = new DCssCounter(false, value.getParameters());
					break ;
				case LexicalUnit.SAC_COUNTERS_FUNCTION:
					m_value = new DCssCounter(true, value.getParameters());
					break ;
//				case LexicalUnit.SAC_LINEAR_GRADIENT:
//					m_value = new DCssLinearGradient(value);
//					break ;
//				case LexicalUnit.SAC_RADIAL_GRADIENT:
////throw new RuntimeException("DCssRadialGradient class needs to be implemented") ;
//					m_value = new DCssLinearGradient(value);
////					m_value = new DCssRadialGradient(value.getParameters());
//					break ;
//				case LexicalUnit.SAC_WEBKIT_GRADIENT:
////throw new RuntimeException("DCssWebkitGradient class needs to be implemented") ;
//					m_value = new DCssLinearGradient(value);
////					m_value = new DCssWebkitGradient(value.getParameters());
//					break ;
//				case LexicalUnit.SAC_MOZ_LINEAR_GRADIENT:
////throw new RuntimeException("DCssMozLinearGradient class needs to be implemented") ;
//					m_value = new DCssLinearGradient(value);
////					m_value = new DCssMozLinearGradient(value.getParameters());
//					break ;
//				case LexicalUnit.SAC_MOZ_RADIAL_GRADIENT:
////throw new RuntimeException("DCssMozRadialGradient class needs to be implemented") ;
//					m_value = new DCssLinearGradient(value);
////					m_value = new DCssMozRadialGradient(value.getParameters());
//					break ;
//				case LexicalUnit.SAC_MOZ_REPEATING_LINEAR_GRADIENT:
////throw new RuntimeException("DCssMozRepeatingLinearGradient class needs to be implemented") ;
//					m_value = new DCssLinearGradient(value);
////					m_value = new DCssMozRepeatingLinearGradient(value.getParameters());
//					break ;
//				case LexicalUnit.SAC_MOZ_REPEATING_RADIAL_GRADIENT:
////throw new RuntimeException("DCssMozRepeatingRadialGradient class needs to be implemented") ;
//					m_value = new DCssLinearGradient(value);
////					m_value = new DCssMozRepeatingLinearGradient(value.getParameters());
//					break ;
//				case LexicalUnit.SAC_COLOR_STOP:
//				case LexicalUnit.SAC_TO:
//				case LexicalUnit.SAC_FROM:
//					
//				case LexicalUnit.SAC_SCALE :
//				case LexicalUnit.SAC_SCALEX :
//				case LexicalUnit.SAC_SCALEY :
//				case LexicalUnit.SAC_SCALEZ :
//				case LexicalUnit.SAC_SCALE3D :
//					
//				case LexicalUnit.SAC_ROTATE :
//				case LexicalUnit.SAC_ROTATEX :
//				case LexicalUnit.SAC_ROTATEY :
//				case LexicalUnit.SAC_ROTATEZ :
//					
//				case LexicalUnit.SAC_SKEW :
//				case LexicalUnit.SAC_SKEWX :
//				case LexicalUnit.SAC_SKEWY :
//					
//				case LexicalUnit.SAC_TRANSLATE :
//				case LexicalUnit.SAC_TRANSLATEX :
//				case LexicalUnit.SAC_TRANSLATEY :
//				case LexicalUnit.SAC_TRANSLATEZ :
//				case LexicalUnit.SAC_TRANSLATE3D :
//					
//				case LexicalUnit.SAC_MATRIX :
//				case LexicalUnit.SAC_MATRIX3D :
//					
//				case LexicalUnit.SAC_CUBIC_BEZIER :
//					
////				case LexicalUnit.SAC_TRANSFORM :
////				case LexicalUnit.SAC_TRANSFORM_ORIGIN :
////				case LexicalUnit.SAC_MOZ_TRANSFORM :
////				case LexicalUnit.SAC_MOZ_TRANSFORM_ORIGIN :
////				case LexicalUnit.SAC_WEBKIT_TRANSFORM :
////				case LexicalUnit.SAC_WEBKIT_TRANSFORM_ORIGIN :
////				case LexicalUnit.SAC_O_TRANSFORM   :
////				case LexicalUnit.SAC_O_TRANSFORM_ORIGIN :
//
//					m_value = new DCssLinearGradient(value);
//					break ;
				default:
					m_value = value;
			}
			
//			if (value.getLexicalUnitType() == LexicalUnit.SAC_RECT_FUNCTION) {
//				m_value = new DCssRect(value.getParameters());
//			} 
//			else if (value.getLexicalUnitType() == LexicalUnit.SAC_RGBCOLOR) {
//				m_value = new DCssRgbColor(value.getParameters());
//			} 
//			else if (value.getLexicalUnitType() == LexicalUnit.SAC_RGBACOLOR) {
//				m_value = new DCssRgbaColor(value.getParameters());
//			} 
//			else if (value.getLexicalUnitType() == LexicalUnit.SAC_HSLCOLOR) {
//				m_value = new DCssHslColor(value.getParameters());
//			} 
//			else if (value.getLexicalUnitType() == LexicalUnit.SAC_HSLACOLOR) {
//				m_value = new DCssHslaColor(value.getParameters());
//			} 
//			else if (value.getLexicalUnitType() == LexicalUnit.SAC_COUNTER_FUNCTION) {
//				m_value = new DCssCounter(false, value.getParameters());
//			} 
//			else if (value.getLexicalUnitType() == LexicalUnit.SAC_COUNTERS_FUNCTION) {
//				m_value = new DCssCounter(true, value.getParameters());
//			} 
//			else {
//				m_value = value;
//			}
		} 
		else if (forcePrimitive || (value.getNextLexicalUnit() == null)) {
			// We need to be a CSSPrimitiveValue
			m_value = value;
		} 
		else {

			// We need to be a CSSValueList
			// Values in an "expr" can be seperated by "operator"s, which are
			// either '/' or ',' - ignore these operators
			List<CSSValue> v = new ArrayList<CSSValue>();
			LexicalUnit lu = value;
			while (lu != null) {
				if ((lu.getLexicalUnitType() != LexicalUnit.SAC_OPERATOR_COMMA)
						&& (lu.getLexicalUnitType() != LexicalUnit.SAC_OPERATOR_SLASH)) {

					v.add(new DCssValue(lu, true));
				}

				lu = lu.getNextLexicalUnit();
			}
			m_value = v;
		}
	}

	public DCssValue(LexicalUnit value) {
		this(value, false);
	}

	public String getCssText() {
		if (getCssValueType() == CSS_VALUE_LIST) {

			// Create the string from the LexicalUnits so we include the correct
			// operators in the string
			StringBuffer sb = new StringBuffer();
			List v = (List) m_value;
			LexicalUnit lu = (LexicalUnit) ((DCssValue) v.get(0)).m_value;
			while (lu != null) {
				sb.append(lu.toString());

				// Step to the next lexical unit, determining what spacing we
				// need to put around the operators
				LexicalUnit prev = lu;
				lu = lu.getNextLexicalUnit();
				if ((lu != null)
						&& (lu.getLexicalUnitType() != LexicalUnit.SAC_OPERATOR_COMMA)
						&& (lu.getLexicalUnitType() != LexicalUnit.SAC_OPERATOR_SLASH)
						&& (prev.getLexicalUnitType() != LexicalUnit.SAC_OPERATOR_SLASH)) {
					sb.append(" ");
				}
			}
			return sb.toString();
		}
		return m_value.toString();
	}

	public void setCssText(String cssText) throws DOMException {
		try {
			InputSource is = new InputSource(new StringReader(cssText));
			DCssBuilder parser = new DCssBuilder();
			DCssValue v2 = parser.parsePropertyValue(is);
			m_value = v2.m_value;
		} catch (Exception e) {
			throw new DCssException(DOMException.SYNTAX_ERR,
					DCssException.SYNTAX_ERROR, e.getMessage());
		}
	}

	public short getCssValueType() {
		if (m_value instanceof List) {
			return CSS_VALUE_LIST;
		}

		if (m_value instanceof LexicalUnit
				&& ((LexicalUnit) m_value).getLexicalUnitType() 
					== LexicalUnit.SAC_INHERIT) {
			return CSS_INHERIT;
		}
		return CSS_PRIMITIVE_VALUE;
	}

	public short getPrimitiveType() {
		if (m_value instanceof LexicalUnit) {
			LexicalUnit lu = (LexicalUnit) m_value;
			switch (lu.getLexicalUnitType()) {
			case LexicalUnit.SAC_INHERIT:
				return CSS_IDENT;
			case LexicalUnit.SAC_INTEGER:
			case LexicalUnit.SAC_REAL:
				return CSS_NUMBER;
			case LexicalUnit.SAC_EM:
				return CSS_EMS;
			case LexicalUnit.SAC_EX:
				return CSS_EXS;
			case LexicalUnit.SAC_PIXEL:
				return CSS_PX;
			case LexicalUnit.SAC_INCH:
				return CSS_IN;
			case LexicalUnit.SAC_CENTIMETER:
				return CSS_CM;
			case LexicalUnit.SAC_MILLIMETER:
				return CSS_MM;
			case LexicalUnit.SAC_POINT:
				return CSS_PT;
			case LexicalUnit.SAC_PICA:
				return CSS_PC;
			case LexicalUnit.SAC_PERCENTAGE:
				return CSS_PERCENTAGE;
			case LexicalUnit.SAC_URI:
				return CSS_URI;
			// case DLexicalUnit.SAC_COUNTER_FUNCTION:
			// case DLexicalUnit.SAC_COUNTERS_FUNCTION:
			// return CSS_COUNTER;
			// case DLexicalUnit.SAC_RGBCOLOR:
			// return CSS_RGBCOLOR;
			case LexicalUnit.SAC_DEGREE:
				return CSS_DEG;
			case LexicalUnit.SAC_GRADIAN:
				return CSS_GRAD;
			case LexicalUnit.SAC_RADIAN:
				return CSS_RAD;
			case LexicalUnit.SAC_MILLISECOND:
				return CSS_MS;
			case LexicalUnit.SAC_SECOND:
				return CSS_S;
			case LexicalUnit.SAC_HERTZ:
				return CSS_KHZ;
			case LexicalUnit.SAC_KILOHERTZ:
				return CSS_HZ;
			case LexicalUnit.SAC_IDENT:
				return CSS_IDENT;
			case LexicalUnit.SAC_STRING_VALUE:
				return CSS_STRING;
			case LexicalUnit.SAC_ATTR:
				return CSS_ATTR;
			// case DLexicalUnit.SAC_RECT_FUNCTION:
			// return CSS_RECT;
			case LexicalUnit.SAC_UNICODERANGE:
			case LexicalUnit.SAC_SUB_EXPRESSION:
			case LexicalUnit.SAC_FUNCTION:
				return CSS_STRING;
			case LexicalUnit.SAC_DIMENSION:
				return CSS_DIMENSION;
			}
		} 
		else if (m_value instanceof Rect) {
			return CSS_RECT;
		} 
		else if (m_value instanceof RGBColor) {
			return CSS_RGBCOLOR;
		} 
//		else if (m_value instanceof IRgbaColor) {
//			return CSS_RGBACOLOR;
//		} 
//		else if (m_value instanceof IHslColor) {
//			return CSS_HSLCOLOR;
//		} 
//		else if (m_value instanceof IHslaColor) {
//			return CSS_HSLACOLOR;
//		} 
		else if (m_value instanceof Counter) {
			return CSS_COUNTER;
		}
		return CSS_UNKNOWN;
	}

	public void setFloatValue(short unitType, float floatValue)
			throws DOMException {
		m_value = CSSLexicalUnit.createFloat(unitType, floatValue,null);
	}

	public float getFloatValue(short unitType) throws DOMException {
		if (m_value instanceof LexicalUnit) {
			LexicalUnit lu = (LexicalUnit) m_value;
			return lu.getFloatValue();
		}
		throw new DCssException(
			DOMException.INVALID_ACCESS_ERR, DCssException.FLOAT_ERROR);

		// We need to attempt a conversion
		// return 0;
	}

	public void setStringValue(short stringType, String stringValue)
			throws DOMException {
		switch (stringType) {
		case CSS_STRING:
			m_value = CSSLexicalUnit.createString(stringType, stringValue,null);
			break;
// TODO reenable
//		case CSS_URI:
//			m_value = CSSLexicalUnit.createURI(null, stringValue);
//			break;
//		case CSS_IDENT:
//			m_value = CSSLexicalUnit.createIdent(null, stringValue);
//			break;
		case CSS_ATTR:
			// _value = LexicalUnitImpl.createAttr(null, stringValue);
			// break;
			throw new DCssException(DOMException.NOT_SUPPORTED_ERR,
					DCssException.NOT_IMPLEMENTED);
		default:
			throw new DCssException(DOMException.INVALID_ACCESS_ERR,
					DCssException.STRING_ERROR);
		}
	}

	/**
	 * TODO: return a value for a list type
	 */
	public String getStringValue() throws DOMException {
		if (m_value instanceof LexicalUnit) {
			LexicalUnit lu = (LexicalUnit) m_value;
			if ((lu.getLexicalUnitType() == LexicalUnit.SAC_IDENT)
					|| (lu.getLexicalUnitType() == LexicalUnit.SAC_STRING_VALUE)
					|| (lu.getLexicalUnitType() == LexicalUnit.SAC_URI)
					|| (lu.getLexicalUnitType() == LexicalUnit.SAC_ATTR)) {
				return lu.getStringValue();
			}
		} else if (m_value instanceof List) {
			return null;
		}

		throw new DCssException(DOMException.INVALID_ACCESS_ERR,
				DCssException.STRING_ERROR);
	}

	public Counter getCounterValue() throws DOMException {
		if ((m_value instanceof Counter) == false) {
			throw new DCssException(DOMException.INVALID_ACCESS_ERR,
					DCssException.COUNTER_ERROR);
		}
		return (Counter) m_value;
	}

	public Rect getRectValue() throws DOMException {
		if ((m_value instanceof Rect) == false) {
			throw new DCssException(DOMException.INVALID_ACCESS_ERR,
					DCssException.RECT_ERROR);
		}
		return (Rect) m_value;
	}

	public RGBColor getRGBColorValue() throws DOMException {
		if ((m_value instanceof RGBColor) == false) {
			throw new DCssException(DOMException.INVALID_ACCESS_ERR, DCssException.RGBCOLOR_ERROR);
		}
		return (RGBColor) m_value;
	}
	
	public IRgbaColor getRGBAColorValue() throws DOMException {
		if ((m_value instanceof IRgbaColor) == false) {
			throw new DCssException(DOMException.INVALID_ACCESS_ERR, DCssException.RGBACOLOR_ERROR);
		}
		return (IRgbaColor) m_value;
	}
	
	public IHslColor getHSLColorValue() throws DOMException {
		if ((m_value instanceof IHslColor) == false) {
			throw new DCssException(DOMException.INVALID_ACCESS_ERR, DCssException.HSLCOLOR_ERROR);
		}
		return (IHslColor) m_value;
	}
	
	public IHslaColor getHSLAColorValue() throws DOMException {
		if ((m_value instanceof IHslaColor) == false) {
			throw new DCssException(DOMException.INVALID_ACCESS_ERR, DCssException.HSLACOLOR_ERROR);
		}
		return (IHslaColor) m_value;
	}

	public int getLength() {
		return (m_value instanceof List) ? ((List) m_value).size() : 0;
	}

	public CSSValue item(int index) {
		return (m_value instanceof List) ? ((CSSValue) ((List) m_value)
				.get(index)) : null;
	}

	public String toString() {
		return getCssText();
	}

	public Object clone() throws CloneNotSupportedException {
		DCssValue copy = (DCssValue) super.clone();
		if (copy.m_value instanceof DCssRect) {
			copy.m_value = ((DCssRect) copy.m_value).clone();
		} else if (copy.m_value instanceof DCssRgbColor) {
			copy.m_value = ((DCssRgbColor) copy.m_value).clone();
		} else if (copy.m_value instanceof DCssCounter) {
			copy.m_value = ((DCssCounter) copy.m_value).clone();
		} else if (copy.m_value instanceof List) {
			copy.m_value = ((ArrayList) copy.m_value).clone();
		}
		return copy;
	}
}
