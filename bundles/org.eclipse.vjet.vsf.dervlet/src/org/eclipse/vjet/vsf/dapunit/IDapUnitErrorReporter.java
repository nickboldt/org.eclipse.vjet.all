package org.eclipse.vjet.vsf.dapunit;

import java.util.List;

import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IDomChange;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IEventCapture;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.ViewCapture;


public interface IDapUnitErrorReporter {
	
	void setTestName(String testName);

	void addDomError(
			DomError error, 
			IDomChange expectedDomChange,
			IDomChange actualDomChange, 
			IEventCapture event,
			ViewCapture view);
	
	void addMsgError(
			MsgError error, 
			String expectedDlcMsg,
			String actualDlcMsg,
			IEventCapture event,
			ViewCapture view);
	
	List<IDapUnitError> getDomErrors();
	
	void addAssertionFailure(
			final IDapUnitError error,
			final String expected,
			final String actual,
			final String input);

	void enableTraceError();

	void disableTraceError();
}
