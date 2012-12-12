package org.eclipse.vjet.vsf.dapunit;

import java.util.Iterator;

import junit.framework.Assert;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.EventCapture;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IActionInfo;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IDomChange;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IEventCapture;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.ViewCapture;
import org.eclipse.vjet.dsf.dap.cnr.IDapCaptureListener;

//import com.ebay.dsf.common.exceptions.DsfRuntimeException;
//import com.ebay.dsf.dap.cnr.DapCaptureData;
//import com.ebay.dsf.dap.cnr.IDapCaptureListener;
//import com.ebay.dsf.dap.cnr.DapCaptureData.EventCapture;
//import com.ebay.dsf.dap.cnr.DapCaptureData.IActionInfo;
//import com.ebay.dsf.dap.cnr.DapCaptureData.IDomChange;
//import com.ebay.dsf.dap.cnr.DapCaptureData.IEventCapture;
//import com.ebay.dsf.dap.cnr.DapCaptureData.ViewCapture;

public class DapUnitInstantValidator implements IDapCaptureListener {

	private ViewCapture m_curViewCapture;
	private IEventCapture m_curEventCapture;
	private Iterator<IActionInfo> m_expectedActionItr;
	
	private DapCaptureData m_actualCaptureData;
	
	private DapUnitConfig m_config;
	
	private static final String ASSERT_NULL = "ActualEventCapture is null for event";
	private static final String ASSERT_EQUALS = "ActualEventCapture is different for event";
	private static final String CONS_NULL = " NULL";
	
	//
	// Constructor
	//
	public DapUnitInstantValidator(final DapUnitConfig config){
		if (config == null){
			m_config = new DapUnitConfig();
		}
		m_config = config;
	}
	
	//
	// Satisfy IDapCaptureListener
	//
	@Override
	public void onDomCapture(IDomChange domChange) {
		IDomChange expected = getExpectedDomChange();
		
		DomError domError = m_config.getValidator(domChange.getClass()).validate(expected, domChange);
		if (domError != null){
			m_config.getErrorReporter().addDomError(
					domError, 
					expected, 
					domChange, 
					m_curEventCapture, 
					m_curViewCapture);
		}
	}

	//
	// API
	//
	public DapUnitInstantValidator setActualCaptureData(final DapCaptureData actualCaptureData){
		m_actualCaptureData = actualCaptureData;
		return this;
	}
	
	public DapUnitInstantValidator startInit(final EventCapture expectedInitCapture){
		if (m_actualCaptureData == null){
			throw new DsfRuntimeException("m_actualCaptureData is null");
		}
		startEvent(expectedInitCapture);
		return this;
	}
	
	public DapUnitInstantValidator endInit() {
		EventCapture actualEventCapture = m_actualCaptureData.getInitEventCapture();
		if (actualEventCapture instanceof EventCapture) {
			EventCapture ec = (EventCapture) actualEventCapture;
			Assert.assertNotNull(ASSERT_NULL.concat(ec.getEvent() != null ? ec
					.getEvent().getPayload() : CONS_NULL), actualEventCapture);
			Assert.assertEquals(ASSERT_EQUALS.concat(ec.getEvent() != null ? ec
					.getEvent().getPayload() : CONS_NULL), m_curEventCapture
					.getDomChangeSize(), ec.getDomChangeSize());
		}
		m_curEventCapture = null;;
		m_expectedActionItr = null;
		return this;
	}
	
	public DapUnitInstantValidator startView(final ViewCapture expectedViewCapture) {
		if (expectedViewCapture == null){
			throw new DsfRuntimeException("expectedViewCapture is null");
		}
		m_curViewCapture = expectedViewCapture;
		return this;
	}

	public DapUnitInstantValidator startEvent(final IEventCapture expectedEventCapture) {
		if (expectedEventCapture == null){
			throw new DsfRuntimeException("expectedEventCapture is null");
		}
		m_curEventCapture = expectedEventCapture;
		m_expectedActionItr = m_curEventCapture.getActionsIter();
		return this;
	}
	
	public DapUnitInstantValidator endEvent() {
		IEventCapture actualEventCapture = m_actualCaptureData.getCurrentEventCapture();
		if(actualEventCapture instanceof EventCapture){
			EventCapture ec = (EventCapture)actualEventCapture;
			Assert.assertNotNull(ASSERT_NULL.concat(ec.getEvent() != null ? ec
					.getEvent().getPayload() : CONS_NULL), actualEventCapture);
			Assert.assertEquals(ASSERT_EQUALS
					.concat(ec.getEvent() != null ? ec.getEvent().getPayload()
							: CONS_NULL), m_curEventCapture.getDomChangeSize(), ec
					.getDomChangeSize());
			m_curEventCapture = null;;
			m_expectedActionItr = null;
		}
		return this;
	}
	
	//
	// Private
	//
	private IDomChange getExpectedDomChange(){
		if (m_curViewCapture == null){
			throw new DsfRuntimeException("m_curViewCapture is null");
		}
		if (m_curEventCapture == null){
			throw new DsfRuntimeException("m_curEventCapture is null");
		}
		if (m_expectedActionItr == null){
			throw new DsfRuntimeException("m_actionItr is null");
		}
		IActionInfo actionInfo;
		while (m_expectedActionItr.hasNext()){
			actionInfo = m_expectedActionItr.next();
			if (actionInfo instanceof IDomChange){
				return (IDomChange)actionInfo;
			}
		}
		return null;
	}
}
