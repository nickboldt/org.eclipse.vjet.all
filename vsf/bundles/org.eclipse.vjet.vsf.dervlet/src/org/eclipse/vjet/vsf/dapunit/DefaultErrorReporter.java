package org.eclipse.vjet.vsf.dapunit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IDomChange;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IEventCapture;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.ViewCapture;


public class DefaultErrorReporter implements IDapUnitErrorReporter {

	private boolean m_traceError = true;
	private String m_testName;
	private List<IDapUnitError> m_errors = new ArrayList<IDapUnitError>();
	
	//
	// Satisfy IDapCaptureErrorReporter
	//
	public void setTestName(String testName){
		m_testName = testName;
	}

	public void enableTraceError() {
		m_traceError = true;
	}

	public void disableTraceError() {
		m_traceError = false;
	}
	
	public void addDomError(
			final DomError error, 
			final IDomChange expectedDomChange,
			final IDomChange actualDomChange, 
			final IEventCapture eventCapture,
			final ViewCapture view){
		
		if (m_errors.isEmpty()){
			System.err.println("DapUnit test failured - " + m_testName + ":");
		}
		
		System.err.println(String.valueOf(m_errors.size()+1) + ") " + error.getMsg() + ":");
		
		StringBuffer sb = new StringBuffer();
		if (eventCapture != null){
	        sb.append(eventCapture.getInfo());
		}
		
		sb.append("\n\t").append("Expected:").append(expectedDomChange == null ? "null" : expectedDomChange.toString());
		sb.append("\n\t").append("  Actual:").append(actualDomChange == null ? "null" : actualDomChange.toString());
		
		try {
			if(m_traceError)
				throw new DapUnitValidationFailureException(sb.toString());
		}
		catch (Exception e){
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			e.printStackTrace(new PrintStream(stream));
			System.err.println(stream.toString());
		}
		finally {
			m_errors.add(error);
		}
	}
	
	public void addMsgError(
			final MsgError error, 
			final String expectedDlcMsg,
			final String actualDlcMsg, 
			final IEventCapture eventCapture,
			final ViewCapture view){
		
		if (m_errors.isEmpty()){
			System.err.println("DapUnit test failured - " + m_testName + ":");
		}
		
		System.err.println(String.valueOf(m_errors.size()+1) + ") " + error.getMsg() + ":");
		
		StringBuffer sb = new StringBuffer();
		if (eventCapture != null){
	        sb.append(eventCapture.getInfo());
		}
		
		sb.append("\n\t").append("Expected:").append(expectedDlcMsg == null ? "null" : expectedDlcMsg.toString());
		sb.append("\n\t").append("  Actual:").append(actualDlcMsg == null ? "null" : actualDlcMsg.toString());
		
		try {
			if(m_traceError)
				throw new DapUnitValidationFailureException(sb.toString());
		}
		catch (Exception e){
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			e.printStackTrace(new PrintStream(stream));
			System.err.println(stream.toString());
		}
		finally {
			m_errors.add(error);
		}
	}
	
	public List<IDapUnitError> getDomErrors(){
		return m_errors;
	}
	
	public void addAssertionFailure(
			final IDapUnitError error,
			final String expected,
			final String actual,
			final String input){
		System.err.println(String.valueOf(m_errors.size()+1) + ") DapUnit validation failure: ");
		
		StringBuffer sb = new StringBuffer();
		if (input != null){
			sb.append("input - ").append(input);
		}
		
		sb.append("\n\t").append("Expected:").append(expected == null ? "null" : expected);
		sb.append("\n\t").append("  Actual:").append(actual == null ? "null" : actual);
		
		try {
			if(m_traceError)
				throw new DapUnitValidationFailureException(sb.toString());
		}
		catch (Exception e){
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			e.printStackTrace(new PrintStream(stream));
			System.err.println(stream.toString());
		}
		finally {
			m_errors.add(error);
		}
	}
}
