package org.eclipse.vjet.dsf.jst.declaration;

public interface DefaultAnnotations {

	/**
	 * This annotation is for types which are alternates for their parent class. 
	 * Example MyLib.Bar is alternate class name for more qualified type MyLib.foo.utils.Bar
	 * MyLib.Bar has been setup to extend MyLib.foo.utils.Bar but any dependency on MyLib.Bar will be resolved
	 * to MyLib.foo.utils.Bar and alternate class name will not be used.
	 */
	static final JstAnnotation ALTERNATE_CLASS_NAME = new JstAnnotation("@AlternateClassName");
	/**
	 * This annotation is used to mark any method which is actually a factory function which constructs instances of types
	 */
	static final JstAnnotation CONSTRUCTOR  = new JstAnnotation("@Constructor");
	
}
