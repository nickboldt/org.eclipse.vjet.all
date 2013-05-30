package org.eclipse.vjet.vsf.dapunit;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.common.xml.IIndenter;
import org.eclipse.vjet.dsf.dap.cnr.DapCapture;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.ViewCapture;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureXmlSerializer;
import org.eclipse.vjet.dsf.dap.rt.DapConfig;
import org.eclipse.vjet.dsf.dap.rt.DapCtx;
import org.eclipse.vjet.dsf.dap.rt.IDapHttpClient;
import org.eclipse.vjet.dsf.dom.DComment;
import org.eclipse.vjet.dsf.dom.DNode;
import org.eclipse.vjet.dsf.html.HtmlWriterHelper;
import org.eclipse.vjet.dsf.html.dom.DHtmlDocument;
import org.eclipse.vjet.dsf.liveconnect.client.DLCClientHelper;
import org.eclipse.vjet.dsf.liveconnect.client.simple.SimpleDLCClient;
import org.eclipse.vjet.dsf.spec.view.DefaultViewSpec;
import org.eclipse.vjet.dsf.spec.view.IViewSpec;
import org.eclipse.vjet.dsf.util.NodeToDHtmlDocument;
import org.eclipse.vjet.vsf.aggregator.js.JsProcessor;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//import com.ebay.dsf.aggregator.js.JsProcessor;
//import com.ebay.dsf.common.exceptions.DsfRuntimeException;
//import com.ebay.dsf.dap.cnr.DapCapture;
//import com.ebay.dsf.dap.cnr.DapCaptureData;
//import com.ebay.dsf.dap.cnr.DapCaptureXmlSerializer;
//import com.ebay.dsf.dap.cnr.DapCaptureData.ViewCapture;
//import com.ebay.dsf.dap.rt.DapConfig;
//import com.ebay.dsf.dap.rt.DapCtx;
//import com.ebay.dsf.dap.rt.IDapHttpClient;
//import com.ebay.dsf.dom.DComment;
//import com.ebay.dsf.dom.DNode;
//import com.ebay.dsf.html.HtmlWriterHelper;
//import com.ebay.dsf.html.dom.DHtmlDocument;
//import com.ebay.dsf.liveconnect.client.DLCClientHelper;
//import com.ebay.dsf.liveconnect.client.simple.SimpleDLCClient;
//import com.ebay.dsf.spec.view.DefaultViewSpec;
//import com.ebay.dsf.spec.view.IViewSpec;
//import com.ebay.dsf.test.fwk.awu.AssertionExecutor;
//import com.ebay.dsf.test.fwk.awu.AwuClientProxy;
//import com.ebay.dsf.test.utils.common.UserAgentsEnum;
//import com.ebay.dsf.util.NodeToDHtmlDocument;
//import com.ebay.kernel.util.xml.IIndenter;

public class DapUnitDriver {

	private final List<View> m_views = new ArrayList<View>(1);
	private final DapCaptureData m_captureData;
	private DapUnitPlayer m_player;
	private DapUnitInstantValidator m_validator;
	private AssertionExecutor m_executor;
	private DapUnitConfig m_config;
	private UserAgentsEnum[] m_userAgents;

	//
	// Constructor
	//
	public DapUnitDriver(URL capturedXmlFilePath) {
		m_captureData = deserializeXml(capturedXmlFilePath);
	}

	//
	// Dummy Constructor to satisfy DeprecatedTestEngine
	//
	public DapUnitDriver(String capturedXmlFilePath) {
		m_captureData = null;
	}

	// 
	// API
	//
	public final DapUnitConfig getConfig() {
		if (m_config == null) {
			m_config = new DapUnitConfig();
		}
		return m_config;
	}

	public void setConfig(DapUnitConfig config) {
		m_config = config;
	}

	public void addView(final String html) {
		m_views.add(new View(html, 0));
	}

	public DapUnitDriver addView(final DNode node) {
		assertNotNull(node);
		m_views.add(new View(getDapHtml(processDoc(node, null)), 0));
		return this;
	}

	public DapUnitDriver addView(final DNode node, long timeout) {
		assertNotNull(node);
		m_views.add(new View(getDapHtml(processDoc(node, null)), timeout));
		return this;
	}

	public DapUnitDriver addView(final DNode node, IViewSpec viewSpec) {
		assertNotNull(node);
		m_views.add(new View(getDapHtml(processDoc(node, viewSpec)), 0));
		return this;
	}

	public DapUnitDriver addView(final DNode node, IViewSpec viewSpec,
			long timeout) {
		assertNotNull(node);
		m_views.add(new View(getDapHtml(processDoc(node, viewSpec)), timeout));
		return this;
	}

	// public void setDefaultDomValidator(final IDomValidator domValidator){
	// m_domValidator = domValidator;
	// }
	//	
	// public DapUnitDriver setRegExFilters(final String[] regExFilters){
	// m_regExFilters = regExFilters;
	// return this;
	// }

	public DapUnitDriver setUserAgents(final UserAgentsEnum[] userAgents) {
		m_userAgents = userAgents;
		return this;
	}

	public DapUnitInstantValidator getValidator() {
		return m_validator;
	}

	public DapUnitDriver run(final DapUnitConfig config) {

		m_config = config;

		test(new MockDlcDispatcher(m_config));

		if (m_userAgents != null && m_userAgents.length > 0) {
			String captureUserAgent = m_captureData.getUserAgent();
			for (UserAgentsEnum userAgent : m_userAgents) {
				if (userAgent == null
						|| userAgent.getName().equals(captureUserAgent)) {
					continue;
				}
				test(new MockDlcDispatcher(m_config, userAgent));
			}
		}

		return this;
	}

	public DapUnitDriver run(final UserAgentsEnum userAgent,
			final DapUnitConfig config) {
		m_config = config;
		test(new MockDlcDispatcher(m_config, userAgent));
		return this;
	}

	//
	// Private
	//
	private void test(final MockDlcDispatcher dlcDispatcher) {

		// Save ctxs
		// DapCtx dapCtx = DapCtx.ctx();
		// DsfCtx dsfCtx = DsfCtx.ctx();

		AwuClientProxy.setDispatcher(dlcDispatcher);

		try {

			// Assert MATCHING VIEW SIZE
			AssertUtils.assertEquals(m_captureData.getViewCaptures().size(), m_views
					.size());

			DapCapture dapCapture = new DapCapture();
			dapCapture.getCapturedData().setUserAgent(
					m_captureData.getUserAgent());

			m_player = new DapUnitPlayer(m_captureData.getInitEventCapture());
			m_validator = new DapUnitInstantValidator(getConfig())
					.setActualCaptureData(dapCapture.getCapturedData());
			m_executor = new AssertionExecutor(getConfig());

			// Config
			final DapConfig config = DapCtx.ctx().getDapConfig();
			config.addCaptureListener(m_validator);

			// TODO: this is for when uprev is done
			if (m_config.isEnableMockHttpClient()) {
				IDapHttpClient mockClient = new MockDapHttpClient(m_captureData
						.getHttpCallCaptures().values(), 1);// TODO: make the
				// speedRatio
				// configurable
				config.setHttpClient(mockClient);
			}

			Iterator<View> viewItr = m_views.iterator();
			View view;
			for (ViewCapture viewCapture : m_captureData.getViewCaptures()) {
				// setupCtx();
				view = viewItr.next();
				m_validator.startView(viewCapture);
				dlcDispatcher.startView(viewCapture);
				m_player.play(view.m_html, dapCapture, m_captureData
						.getInitEventCapture(), viewCapture, view.m_timeout,
						dlcDispatcher, m_validator, m_executor);
			}

		} finally {
			// Restore ctxs
			// DsfCtx.setCtx(dsfCtx);
			// DapCtx.setCtx(dapCtx);

			AwuClientProxy.setDispatcher(null);

			DapCtx.ctx().setDapConfig(null);
			DapCtx.ctx().setWindow(null);
		}
	}

	private DHtmlDocument processDoc(DNode node, IViewSpec viewSpec) {
		DHtmlDocument document;
		if (node instanceof DHtmlDocument) {
			document = (DHtmlDocument) node;
		} else {
			document = NodeToDHtmlDocument.createHtmlDocumentContaining(node,
					false);
			if (viewSpec == null) {
				viewSpec = new DefaultViewSpec();
			}
			new JsProcessor().process((DHtmlDocument) document, viewSpec);
		}

		return document;
	}

	private DapCaptureData deserializeXml(final URL filePath) {
		// read file and deserialize. throw excpetion if file non found or
		// invalid
		DapCaptureData data = null;
		try {
			;
			data = new DapCaptureXmlSerializer(new IIndenter.Pretty())
					.deserialize(filePath.openStream());
		} catch (IOException e) {
			throw new DsfRuntimeException("Captured data is not found: "
					+ filePath);
		}
		if (data == null) {
			throw new DsfRuntimeException("Failed to deserialize " + filePath);
		}
		return data;
	}

	// private void setupCtx() {
	// DapCtx.setCtx(null);
	// DsfCtx.setCtx(null);
	// DsfCtx.createCtx();
	// DapCtx.ctx().setDsfSvcRegistry(JsRuntimeCtx.ctx().getServiceEngine());
	// DapCtx.ctx().setExeMode(DapCtx.ExeMode.ACTIVE);
	// }

	private String getDapHtml(DHtmlDocument doc) {
		removeComments(doc);
		DLCClientHelper.enableDLC("localhost", 1024, doc, SimpleDLCClient
				.getInstance());
		return HtmlWriterHelper.asString(doc);
	}

	private void removeComments(Node node) {
		if (node == null || !node.hasChildNodes()) {
			return;
		}
		NodeList children = node.getChildNodes();
		Node child;
		for (int i = children.getLength() - 1; i >= 0; i--) {
			child = children.item(i);
			if (child instanceof DComment) {
				node.removeChild(child);
			} else {
				removeComments(child);
			}
		}
	}

	private void assertNotNull(final DNode node) {
		if (node == null) {
			throw new DsfRuntimeException("node is null");
		}
	}

	//
	// Embedded
	//
	private static class View {
		private String m_html;
		private long m_timeout;

		private View(String html, long timeout) {
			m_html = html;
			m_timeout = timeout;
		}
	}
}
