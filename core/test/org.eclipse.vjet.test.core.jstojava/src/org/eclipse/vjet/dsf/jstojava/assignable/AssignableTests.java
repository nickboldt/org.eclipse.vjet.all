package org.eclipse.vjet.dsf.jstojava.assignable;


import static junit.framework.TestCase.*;

import org.eclipse.vjet.dsf.jsgen.shared.validation.vjo.semantic.rules.util.AssignableTypeRegistry;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.declaration.JstFactory;
import org.junit.Test;


public class AssignableTests {

	@Test
	public void testAssignable(){
		
		/**
		 * Object[] -> T
ObjLiteral -> T
ObjLiteral[] -> T[]
ObjLiteral[] -> T

Sencha Specific examples:
Object -> Mixed == Object/Number/String/Boolean == any literal

Object[] -> MixedCollection = []
Object[] -> MixedCollection = []
		 */
		AssignableTypeRegistry reg = AssignableTypeRegistry.getInstance();
//		JstArray objArray = new JstArray(objType);
		assertFalse(reg.isAssignable("test", "Object", "Object[]"));
		reg.registerAllowedConversion("test", "Object", "Object[]");
		assertTrue(reg.isAssignable("test", "Object", "Object[]"));
//		reg.registerAllowedConversion("Test", assignTo, assignFrom);
		
		
	}
	
}
