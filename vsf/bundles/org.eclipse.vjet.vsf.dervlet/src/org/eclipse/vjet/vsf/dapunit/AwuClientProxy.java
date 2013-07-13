package org.eclipse.vjet.vsf.dapunit;

import java.util.Iterator;

import org.eclipse.vjet.dsf.dap.rt.DapCtx;
import org.eclipse.vjet.dsf.dap.rt.DapSession;
import org.eclipse.vjet.dsf.dap.rt.DapView;
import org.eclipse.vjet.dsf.liveconnect.IDLCDispatcher;


public class AwuClientProxy {

	private static IDLCDispatcher s_dispatcher = null;

	public static void setDispatcher(IDLCDispatcher d) {
		s_dispatcher = d;
	}

	private static IDLCDispatcher m_dispatcher = null;

	public AwuClientProxy() {
		if(s_dispatcher != null) {
			m_dispatcher = s_dispatcher;
		} else {
			DapSession session = DapCtx.ctx().getSession();
			if(session!=null) {
				Iterator<DapView> viewIter = session.getViews().values().iterator();
				DapView view = null;
				while(viewIter.hasNext()) view = viewIter.next();
				if(view != null) {
					m_dispatcher = view.getEngine().getDispatcher();
				}
			}
		}
	}

	public void toggle() {
		if(m_dispatcher!=null) 
		    m_dispatcher.send("if(AWU) { AWU.toggle(); }");
	}

	public void setPath(String path) {
		if(m_dispatcher!=null) 
			m_dispatcher.send("if(AWU) { AWU.setPath('" + path + "'); }");
	}

	public void check(String prop) {
		if(m_dispatcher!=null) 
		    m_dispatcher.send("if(AWU) { AWU.check('" + prop + "'); }");
	}

	public void remove(String prop) {
		if(m_dispatcher!=null) 
		    m_dispatcher.send("if(AWU) { AWU.remove('" + prop + "'); }");
	}

	public void asserts() {
		if(m_dispatcher!=null) 
		    m_dispatcher.send("if(AWU) { AWU.asserts(); }");
	}
	
}
