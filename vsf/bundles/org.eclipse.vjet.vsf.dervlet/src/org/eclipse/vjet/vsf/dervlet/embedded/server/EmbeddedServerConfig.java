/*     */ package org.eclipse.vjet.vsf.dervlet.embedded.server;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class EmbeddedServerConfig
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   static final long serialVersionUID = 2080280717058448646L;
/*     */   private int m_port;
/*     */   private int m_originalPort;
/*     */   private String m_contextPath;
/*     */   private String m_resourceBase;
/*  13 */   private boolean m_sslEnabled = false;
/*  14 */   private int m_sslPort = 8443;
/*  15 */   private String m_sslKeystore = null;
/*  16 */   private String m_keystoreType = "jks";
/*  17 */   private String m_sslPassword = null;
/*  18 */   private boolean m_isProxy = false;
/*  19 */   private String m_sslKeyPassword = null;
/*  20 */   private String m_protocol = null;
/*  21 */   private boolean m_enableSession = true;
/*  22 */   private String m_truststore = null;
/*  23 */   private String m_truststoreType = "jks";
/*  24 */   private boolean m_requireClientAuth = false;
/*  25 */   private String m_sslTrustPassword = null;
/*     */   private final ClassLoader m_classLoader;
/*     */ 
/*     */   public EmbeddedServerConfig(int port, String contextPath, String resourceBase)
/*     */   {
/*  32 */     this(port, contextPath, resourceBase, null);
/*     */   }
/*     */ 
/*     */   public EmbeddedServerConfig(int port, String contextPath, String resourceBase, ClassLoader classLoader)
/*     */   {
/*  45 */     if (port < 0) {
/*  46 */       throw new RuntimeException("Port must be a positive integer");
/*     */     }
/*     */ 
/*  49 */     this.m_originalPort = (this.m_port = port);
/*     */ 
/*  51 */     if (contextPath == null) {
/*  52 */       this.m_contextPath = "/";
/*     */     }
/*     */     else {
/*  55 */       this.m_contextPath = contextPath;
/*     */     }
/*     */ 
/*  58 */     if (resourceBase == null) {
/*  59 */       this.m_resourceBase = ".";
/*     */     }
/*     */     else {
/*  62 */       this.m_resourceBase = resourceBase;
/*     */     }
/*  64 */     this.m_classLoader = classLoader;
/*     */   }
/*     */ 
/*     */   public int getPort()
/*     */   {
/*  74 */     return this.m_port;
/*     */   }
/*     */   public String getContextPath() {
/*  77 */     return this.m_contextPath;
/*     */   }
/*     */   public String getResourceBase() {
/*  80 */     return this.m_resourceBase;
/*     */   }
/*     */ 
/*     */   public boolean isProxy() {
/*  84 */     return this.m_isProxy;
/*     */   }
/*     */ 
/*     */   public EmbeddedServerConfig setPort(int port)
/*     */   {
/*  94 */     this.m_port = port;
/*  95 */     return this;
/*     */   }
/*     */ 
/*     */   EmbeddedServerConfig resetPort(int port)
/*     */   {
/* 107 */     this.m_originalPort = (this.m_port = port);
/* 108 */     return this;
/*     */   }
/*     */ 
/*     */   public int getOriginalPort()
/*     */   {
/* 116 */     return this.m_originalPort;
/*     */   }
/*     */ 
/*     */   EmbeddedServerConfig setContextPath(String path) {
/* 120 */     this.m_contextPath = path;
/* 121 */     return this;
/*     */   }
/*     */ 
/*     */   EmbeddedServerConfig setResourceBase(String base) {
/* 125 */     this.m_resourceBase = base;
/* 126 */     return this;
/*     */   }
/*     */ 
/*     */   ClassLoader getContextClassLoader() {
/* 130 */     return this.m_classLoader;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 138 */     String NL = System.getProperty("line.separator");
/* 139 */     StringBuilder buf = new StringBuilder();
/* 140 */     buf.append("Port").append(": ").append(this.m_port).append(NL);
/* 141 */     buf.append("Context Path").append(": ").append(this.m_contextPath).append(NL);
/* 142 */     buf.append("Resource Base").append(": ").append(this.m_resourceBase).append(NL);
/* 143 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   public boolean equals(Object o) {
/* 147 */     if (o == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     if (!(o instanceof EmbeddedServerConfig)) {
/* 151 */       return false;
/*     */     }
/*     */ 
/* 154 */     EmbeddedServerConfig other = (EmbeddedServerConfig)o;
/*     */ 
/* 157 */     if (getPort() != other.getPort()) {
/* 158 */       return false;
/*     */     }
/*     */ 
/* 169 */     return true;
/*     */   }
/*     */ 
/*     */   public int getSslPort()
/*     */   {
/* 176 */     return this.m_sslPort;
/*     */   }
/*     */ 
/*     */   public void setSslPort(int port) {
/* 180 */     this.m_sslPort = port;
/*     */   }
/*     */ 
/*     */   public String getSslKeystore() {
/* 184 */     return this.m_sslKeystore;
/*     */   }
/*     */ 
/*     */   public void setSslKeystore(String keystore) {
/* 188 */     this.m_sslKeystore = keystore;
/*     */   }
/*     */ 
/*     */   public void setKeystoreType(String keystoreType) {
/* 192 */     this.m_keystoreType = keystoreType;
/*     */   }
/*     */ 
/*     */   public String getKeystoreType() {
/* 196 */     return this.m_keystoreType;
/*     */   }
/*     */ 
/*     */   public String getSslTruststore() {
/* 200 */     return this.m_truststore;
/*     */   }
/*     */ 
/*     */   public void setSslTruststore(String truststore) {
/* 204 */     this.m_truststore = truststore;
/*     */   }
/*     */ 
/*     */   public void setTruststoreType(String truststoreType) {
/* 208 */     this.m_truststoreType = truststoreType;
/*     */   }
/*     */ 
/*     */   public String getTruststoreType() {
/* 212 */     return this.m_truststoreType;
/*     */   }
/*     */ 
/*     */   public String getSslPassword() {
/* 216 */     return this.m_sslPassword;
/*     */   }
/*     */ 
/*     */   public void setSslPassword(String password) {
/* 220 */     this.m_sslPassword = password;
/*     */   }
/*     */ 
/*     */   public String getSslTrustPassword() {
/* 224 */     return this.m_sslTrustPassword;
/*     */   }
/*     */ 
/*     */   public void setSslTrustPassword(String password) {
/* 228 */     this.m_sslTrustPassword = password;
/*     */   }
/*     */ 
/*     */   public void setSslEnabled(boolean flag) {
/* 232 */     this.m_sslEnabled = flag;
/*     */   }
/*     */ 
/*     */   public boolean getSslEnabled() {
/* 236 */     return this.m_sslEnabled;
/*     */   }
/*     */ 
/*     */   public String getSslKeyPassword() {
/* 240 */     return this.m_sslKeyPassword;
/*     */   }
/*     */ 
/*     */   public void setSslKeyPassword(String password) {
/* 244 */     this.m_sslKeyPassword = password;
/*     */   }
/*     */ 
/*     */   public String getProtocol() {
/* 248 */     return this.m_protocol;
/*     */   }
/*     */ 
/*     */   public void setProtocol(String protocol) {
/* 252 */     this.m_protocol = protocol;
/*     */   }
/*     */ 
/*     */   public boolean isEnableSession() {
/* 256 */     return this.m_enableSession;
/*     */   }
/*     */ 
/*     */   public void setEnableSession(boolean set) {
/* 260 */     this.m_enableSession = set;
/*     */   }
/*     */ 
/*     */   public boolean isRequireClientAuth() {
/* 264 */     return this.m_requireClientAuth;
/*     */   }
/*     */ 
/*     */   public void setRequireClientAuth(boolean set) {
/* 268 */     this.m_requireClientAuth = set;
/*     */   }
/*     */ }

/* Location:           /Applications/appSDK/lib/CoreDervlet-1.7.zip
 * Qualified Name:     com.ebay.coredervlet.EmbeddedServerConfig
 * JD-Core Version:    0.6.2
 */