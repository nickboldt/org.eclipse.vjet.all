/*    */ package org.eclipse.vjet.vsf.dervlet;
/*    */ 
/*    */ import org.eclipse.jetty.servlet.ServletContextHandler;
/*    */ import org.eclipse.jetty.server.session.HashSessionIdManager;
/*    */ import org.eclipse.jetty.server.session.HashSessionManager;
/*    */ import org.eclipse.jetty.server.session.SessionHandler;
/*    */ public class DervletSessionEnabler
/*    */ {
/*    */   public static void enableDervletSession(ServletContextHandler context)
/*    */   {
/* 11 */     HashSessionManager sessionManager = new HashSessionManager();
/* 12 */     sessionManager.setIdManager(new HashSessionIdManager());
/* 13 */     sessionManager.setMaxInactiveInterval(3600);
/* 14 */     sessionManager.setUsingCookies(true);
/* 15 */     sessionManager.setHttpOnly(true);
/* 16 */     SessionHandler sessionHandler = new SessionHandler(sessionManager);
/* 17 */     context.setHandler(sessionHandler);
/*    */   }
/*    */ }

/* Location:           /Applications/appSDK/lib/CoreDervlet-1.7.zip
 * Qualified Name:     com.ebay.coredervlet.DervletSessionEnabler
 * JD-Core Version:    0.6.2
 */