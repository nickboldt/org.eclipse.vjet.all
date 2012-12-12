package org.eclipse.vjet.vsf.dapunit;


public class DomError implements IDapUnitError {

	private Type m_type;
	private String m_msg;
	
	//
	// Constructor
	//
	public DomError(final Type type, final String msg){
		m_type = type;
		m_msg = msg;
	}
	
	@Override
	public String getMsg(){
		return m_msg;
	}
	
	//
	// API
	//
	public Type getType(){
		return m_type;
	}
	
	//
	// Embedded
	//
	public static enum Type {
		// Detailed
		INVALID_NODE_TYPE,
		INVALID_NODE_PATH,
		INVALID_PARENT_PATH,
		INVALID_REF_PATH,
		INVALID_NODE_HTML,

		// High-level, for simple string validation only
		EXPECTED_DOM_CHANGE_NULL,
		ACTUAL_DOM_CHANGE_NULL,
		ACTUAL_DOM_CHANGE_INVALID,
	}
}
