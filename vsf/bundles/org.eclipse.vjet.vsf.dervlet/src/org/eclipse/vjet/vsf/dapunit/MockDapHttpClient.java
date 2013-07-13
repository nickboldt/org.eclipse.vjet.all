package org.eclipse.vjet.vsf.dapunit;

import java.util.Collection;

import org.eclipse.vjet.dsf.dap.cnr.DapCaptureData.DapHttpCall;
import org.eclipse.vjet.dsf.dap.rt.DapHttpClient;
import org.eclipse.vjet.dsf.dap.rt.DapHttpRequest;
import org.eclipse.vjet.dsf.dap.rt.DapHttpResponse;


/**
 * Mock class that intercepts http requests
 * and returns previously captured responses
 */
public class MockDapHttpClient extends DapHttpClient {
	
	private int m_speedRatio;
	private Collection<DapHttpCall> m_callCaptures;
	
	//
	// Constructor
	//
	
	public MockDapHttpClient(Collection<DapHttpCall> ajaxCalls, int speedRatio){
		m_callCaptures = ajaxCalls;
		m_speedRatio = speedRatio;
	}
	
	//
	// Satisfy IDapHttpClient
	//
	@Override
	/**
	 * Answer the previously captured response
	 * @param request DapHttpRequest
	 */
	public DapHttpResponse send(final DapHttpRequest request){
		DapHttpCall call = findCall4Req(request);
		if(call != null){
			sleep4Call(call);
			return call.getResponse();
		}
		return null;
	}
	
	@Override
	/**
	 * Invoke callback with previously captured response
	 * @param request DapHttpRequest
	 * @param callback IDapCallback
	 */
	public void send(final DapHttpRequest request, final IDapCallback callback){
		DapHttpCall call = findCall4Req(request);
		if(call != null){
			new AsyncExecutor(call, callback).start();
		}
	}

	private void sleep4Call(DapHttpCall call) {
		long latency = call.getResponseTime();
		try {
			Thread.sleep(latency * m_speedRatio);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private DapHttpCall findCall4Req(final DapHttpRequest request){
		if(m_callCaptures != null){
			for (DapHttpCall call : m_callCaptures) {
				if(isEqualsDHR(call.getRequest(), request)){
					return call;
				}
			}
		}
		return null;
	}
	
	private boolean isEqualsDHR(DapHttpRequest req1, DapHttpRequest req2){
		boolean flg = false;
		if(req1 != null && req2 != null){
			flg = strEquals(req1.getUrl(), req2.getUrl()) 
				&&  strEquals(req1.getMethod(), req2.getMethod())
				&&  req1.isAsync() == req2.isAsync();
		}
		return flg;
	}
	
	private boolean strEquals(String str1, String str2){
		if(str1 == null || str2 == null){
			return str1 == str2;
		}
		return str1.equals(str2);
	}
	
	private class AsyncExecutor extends Thread{

		DapHttpCall m_call;
		IDapCallback m_callback;
		
		public AsyncExecutor(final DapHttpCall call, final IDapCallback callback) {
			m_call = call;
			m_callback = callback;
		}
		
		@Override
		public void run() {
			sleep4Call(m_call);
			m_callback.onComplete(m_call.getResponse());
		}
	}
}
