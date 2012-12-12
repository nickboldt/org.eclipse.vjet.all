package org.eclipse.vjet.vsf.dapunit;

import java.io.IOException;
import java.net.URL;

import junit.framework.Assert;

import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.common.resource.ResourceUtil;
import org.eclipse.vjet.dsf.dap.cnr.ReplaySpeed;
import org.eclipse.vjet.dsf.dap.rt.DapCtx;
import org.eclipse.vjet.dsf.dap.rt.DapCtx.ExeMode;
import org.eclipse.vjet.dsf.dom.DNode;
import org.eclipse.vjet.vsf.jsruntime.context.JsRuntimeCtx;

/**
 * Base type for all DAP Unit tests
 */
public class BaseDapUnit {

	private URL m_dapCaptureFileName;
	private DapUnitConfig m_config;

	private int m_expectedErrorCount = 0;
	private long m_timeout = 0;

	public BaseDapUnit() {
		DapCtx.ctx().reset();
		DsfCtx.ctx().reset();
//		DapCtx.ctx().setDsfSvcRegistry(JsRuntimeCtx.ctx().getServiceEngine());
		DapCtx.ctx().setExeMode(ExeMode.ACTIVE);
	}

	//
	// Protected
	//
	/**
	 * Run the test for the given component root
	 * 
	 * @param root
	 *            DNode
	 */
	protected void runTest(final DNode root) {

		ValidationCommands.enableAllPropertyBasedCommands();
		ValidationCommands.enableAllStyleCommands();
		AssertionSerializationHelper.enableAssertion();

		new DapUnitDriver(getCaptureFileName()).setUserAgents(getUserAgents())
				.addView(root, getTimeout()).run(getConfig());

		Assert.assertEquals("Please find errors in console.",
				m_expectedErrorCount, getConfig().getErrorReporter()
						.getDomErrors().size());
		
		enableTraceError();
		setReplaySpeed(ReplaySpeed.FAST);
	}

	/**
	 * Answer the config for this test
	 * 
	 * @return DapUnitConfig
	 */
	protected final DapUnitConfig getConfig() {
		if (m_config == null) {
			m_config = new DapUnitConfig();
			getConfig().getErrorReporter().setTestName(getClass().getName());
		}
		return m_config;
	}

	/**
	 * Answer userAgents for this test. To be overridden by derived tests.
	 * Please be aware that captured userAgent will always be tested first and
	 * only once.
	 * 
	 * @return UserAgentsEnum[]
	 */
	protected UserAgentsEnum[] getUserAgents() {
		return null;
	}

	protected void setReplaySpeed(ReplaySpeed speed) {
		getConfig().setReplaySpeed(speed);
	}

	protected void enableTraceError() {
		getConfig().getErrorReporter().enableTraceError();
	}

	protected void disableTraceError() {
		getConfig().getErrorReporter().disableTraceError();
	}

	protected BaseDapUnit setExpectedErrorCount(int count) {
		m_expectedErrorCount = count;
		if(count==0)
			getConfig().getErrorReporter().enableTraceError();
		else
			getConfig().getErrorReporter().disableTraceError();
		return this;
	}

	//
	// Private
	//
	private static final String DAP_UNIT = "DapUnit";
	private static final String DAP_CAPTURE_DOT_XML = "DapCapture.xml";

	private URL getCaptureFileName() {
		if (m_dapCaptureFileName != null)
			return m_dapCaptureFileName;
		String simpleClassName = getClass().getSimpleName();
		if (simpleClassName.endsWith(DAP_UNIT)) {
			String captureResourceName = simpleClassName.substring(0,
					simpleClassName.length() - DAP_UNIT.length())
					+ DAP_CAPTURE_DOT_XML;
			try {
				m_dapCaptureFileName = ResourceUtil.getResource(getClass(),
						captureResourceName);
			} catch (IOException e) {
				// ignored
			}
		}
		if (m_dapCaptureFileName == null || !simpleClassName.endsWith(DAP_UNIT))
			throw new DsfRuntimeException(
					"Cannot find DAP capture file in test directory: "
							+ this.getClass().getSimpleName()
							+ "DapCapture.xml");

		return m_dapCaptureFileName;
	}

	protected long getTimeout() {
		return m_timeout;
	}

	protected void setTimeout(long m_timeout) {
		this.m_timeout = m_timeout;
	}
}
