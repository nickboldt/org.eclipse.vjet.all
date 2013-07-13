package org.eclipse.vjet.vsf.dervlet.embedded.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.eclipse.jetty.http.HttpException;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.IO;




public class ProxyServer extends Server {
	
	private ProxyServerConfig m_config = null;
	private int m_port = 0;

	
	public ProxyServer(int port) {
		super(port);
		m_port = port;
		m_config = ProxyServerConfig.getInstance();
	}
	
	
	public void handle(String target, HttpServletRequest request,
            			HttpServletResponse response, int dispatch) 
	throws IOException, ServletException
    {
		// intercept http calls
		if (target.equals("443") ) {
			return;
		}
		
		String urlString = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		String serverName = request.getServerName().toUpperCase();
				
		String localHost = InetAddress.getLocalHost().getHostName().toUpperCase();
		if (serverName.indexOf(localHost) != -1 ||
			serverName.compareToIgnoreCase("localhost") == 0) {
			int port = request.getServerPort();
			
			if (m_port == port) {
				// handle local host request
				request.setAttribute("viewPath", m_config.getViewPath());
				request.setAttribute("viewRoot", m_config.getViewRoot());
			  // TODO see if this works after upgrade
				super.handle(target, null, request, response);
				return;
			}
		}

		for (ProxyRule rule: m_config.getRules()) {
			
			switch (rule.match(uri)) {
				case ProxyRule.NOT_MATCH: break;
				case ProxyRule.INCLUDES: 
					request.setAttribute("resource", rule.getResourceURI());
					request.setAttribute("viewPath", m_config.getViewPath());
					request.setAttribute("viewRoot", m_config.getViewRoot());
					// TODO see if this works with null
					super.handle(target, null,request, response);
					return;
				case ProxyRule.EXCLUDES:
					// forward to original server
					System.out.println("forward request to server : " + urlString);
					forwardRequest(request, response);
					return;
			}
			
		}
	
		//System.out.println("forward request to server : " + urlString);
		forwardRequest(request, response);		
				
    }
    /* ------------------------------------------------------------ */
    public void handleConnect(HttpServletRequest request,
                              HttpServletResponse response)
        throws IOException
    {
        String uri = request.getRequestURI();
        
        
        String port = "";
        String host = "";
        
        int c = uri.indexOf(':');
        if (c>=0)
        {
            port = uri.substring(c+1);
            host = uri.substring(0,c);
            if (host.indexOf('/')>0)
                host = host.substring(host.indexOf('/')+1);
        }

        
       

        InetSocketAddress inetAddress = new InetSocketAddress (host, Integer.parseInt(port));
        
        //if (isForbidden(HttpMessage.__SSL_SCHEME,addrPort.getHost(),addrPort.getPort(),false))
        //{
        //    sendForbid(request,response,uri);
        //}
        //else
        {
            InputStream in=request.getInputStream();
            OutputStream out=response.getOutputStream();
            
            Socket socket = new Socket(inetAddress.getAddress(),inetAddress.getPort());
            
            response.setStatus(200);
            response.setHeader("Connection","close");
            response.flushBuffer();
            
            

            IO.copyThread(socket.getInputStream(),out);
            IO.copy(in,socket.getOutputStream());
        }
    }
	private void forwardRequest(HttpServletRequest req, HttpServletResponse res) 
		throws IOException, ServletException {

        // Create an instance of HttpClient.
        HttpClient client = new HttpClient();
        String url = req.getRequestURL().toString();
       
        // Create a method instance.
        GetMethod method = new GetMethod(url);
        
        // Provide custom retry handler is necessary
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
            new DefaultHttpMethodRetryHandler(3, false));

        try {
          // Execute the method.
          int statusCode = client.executeMethod(method);
          if (statusCode != HttpStatus.OK_200) {
            System.err.println("Method failed: " + method.getStatusLine());
          }

          // Read the response body.
//        byte[] responseBody = method.getResponseBody();
          InputStream in =method.getResponseBodyAsStream();
          // set response headers
          int h=0;
         Header[] hs= method.getResponseHeaders();
         for (int i = 0; i < hs.length; i++) {
           res.addHeader(hs[i].getName(), hs[i].getValue());
       }
         res.addHeader("Via","1.1 (jetty)");
          res.setStatus(statusCode);
          IO.copy(in, res.getOutputStream());
          // Deal with the response.
          // Use caution: ensure correct character encoding and is not binary data
//        System.out.println(new String(responseBody));

        } catch (HttpException e) {
          System.err.println("Fatal protocol violation: " + e.getMessage());
          e.printStackTrace();
        } catch (IOException e) {
          System.err.println("Fatal transport error: " + e.getMessage());
          e.printStackTrace();
        } finally {
          // Release the connection.
          method.releaseConnection();
        }  
	}

	public ProxyServerConfig getConfig() {
		return m_config;
	}

}


