/*    */ package org.eclipse.vjet.vsf.dervlet.embedded.server;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.AbstractHttpConnection;
/*    */
/*    */ 
/*    */ public abstract class EmbeddedServerErrorHandler
/*    */ {
/*    */   HttpServletRequest m_request;
/*    */ 
/*    */   protected abstract boolean handleError(HttpServletRequest paramHttpServletRequest, Writer paramWriter, int paramInt, String paramString)
/*    */     throws IOException;
/*    */ 
/*    */   public final HttpServletResponse getResponse()
/*    */   {
/* 34 */     return AbstractHttpConnection.getCurrentConnection().getResponse();
/*    */   }
/*    */ 
/*    */   public final Throwable getThrowable()
/*    */   {
/* 39 */     return (Throwable)this.m_request.getAttribute("javax.servlet.error.exception");
/*    */   }
/*    */ 
/*    */   final void setRequest(HttpServletRequest request) {
/* 43 */     this.m_request = request;
/*    */   }
/*    */ }

/* Location:           /Applications/appSDK/lib/CoreDervlet-1.7.zip
 * Qualified Name:     com.ebay.coredervlet.EmbeddedServerErrorHandler
 * JD-Core Version:    0.6.2
 */