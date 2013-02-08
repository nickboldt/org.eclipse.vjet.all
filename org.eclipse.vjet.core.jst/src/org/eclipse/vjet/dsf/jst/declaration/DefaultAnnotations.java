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
	
	/**
	 * This tag interface is used to declare that JS method or property doesn't have 
	 * a comment which defines it's type
	 */
	static final JstAnnotation NOTYPECOMMENT  = new JstAnnotation("@NoTypeComment");
	
	/**
	 * In an object literal usage of a class may be implied by a name when this happens
	 * the JstAnnotation will have this name and the child of the JstAnnotation node will have the instance of the type
	 * that identifier is implying usage.
	 */
	static final String IMPLIED_USAGE_OF_TYPE = "@ImpliedUsageOfType";
	
}
