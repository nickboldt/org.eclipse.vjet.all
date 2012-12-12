package org.eclipse.vjet.vsf.dervlet.dap;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.AbstractEventCapture;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IActionInfo;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IDomChange;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.IEventCapture;
import org.eclipse.vjet.dsf.dap.rt.DapHttpRequest;
import org.eclipse.vjet.dsf.dap.rt.DapHttpResponse;

//import com.ebay.dsf.dap.cnr.DapCaptureData.AbstractEventCapture;
//import com.ebay.dsf.dap.cnr.DapCaptureData.IActionInfo;
//import com.ebay.dsf.dap.cnr.DapCaptureData.IDomChange;
//import com.ebay.dsf.dap.cnr.DapCaptureData.IEventCapture;
//import com.ebay.dsf.dap.rt.DapHttpRequest;
//import com.ebay.dsf.dap.rt.DapHttpResponse;


public class Assertion extends AbstractEventCapture implements IEventCapture {
	private String m_path;
	private String m_content;
	private String m_cmd;
	private List<IActionInfo> m_actions = new ArrayList<IActionInfo>();
	public String getPath() {
		return m_path;
	}
	public void setPath(String path) {
		this.m_path = path;
	}
	public String getContent() {
		return m_content;
	}
	public void setContent(String content) {
		this.m_content = content;
	}
	public String getCmd() {
		return m_cmd;
	}
	public void setCmd(String cmd) {
		this.m_cmd = cmd;
	}
	public List<IActionInfo> getActions() {
		return m_actions;
	}
	public void addDomChange(IDomChange data) {
		//NOOP
	}
	public int getDomChangeSize() {
		return 0;
	}
	public void addHttpReq(final DapHttpRequest req) {
		//NOOP
	}
	public void addHttpResp(final DapHttpRequest req, final DapHttpResponse resp) {
		//NOOP
	}
	public String getInfo() {
		return "assertion-" + m_path + "-" + m_content;
	}
}
