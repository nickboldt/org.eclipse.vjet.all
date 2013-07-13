package org.eclipse.vjet.vsf.dapunit;


public class MsgError implements IDapUnitError {

private String m_msg;
	
	//
	// Constructor
	//
	public MsgError(final String msg){
		m_msg = msg;
	}
	
	@Override
	public String getMsg(){
		return m_msg;
	}
}
