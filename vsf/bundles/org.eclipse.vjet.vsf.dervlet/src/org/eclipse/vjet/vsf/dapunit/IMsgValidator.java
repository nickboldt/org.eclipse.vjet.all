package org.eclipse.vjet.vsf.dapunit;


public interface IMsgValidator {
	MsgError validate(String expected, String actual);
}
