/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
vjo.ctype("org.eclipse.vjet.vsf.utils.jstrace.TraceLogger")
.needs("org.eclipse.vjet.vsf.utils.logging.Level")
.needs("org.eclipse.vjet.vsf.utils.logging.Logger")
.needs("org.eclipse.vjet.vsf.utils.logging.LogManager")
.needs("org.eclipse.vjet.vsf.utils.logging.LogRecord")
.needs("org.eclipse.vjet.vsf.utils.jstrace.JSTraceLogConfig")
.needs("org.eclipse.vjet.vsf.utils.logging.RemoteHandler")
.needs("org.eclipse.vjet.vsf.utils.jstrace.RemoteFormatter")
.needs("org.eclipse.vjet.vsf.utils.logging.RemoteFormatter", "LRF")
.needs("org.eclipse.vjet.vsf.utils.logging.MessageHandler")
.protos({

	LG:	org.eclipse.vjet.vsf.utils.logging.Logger, //<type::Logger
	LR:	org.eclipse.vjet.vsf.utils.logging.LogRecord, //<type::LogRecord
	L:	org.eclipse.vjet.vsf.utils.logging.Level, //<type::Level
	
	constructs : function(cfg){	
		var t = this,
			mgr = this.vj$.LogManager.getLogManager();
		mgr.readConfigure(this.vj$.JSTraceLogConfig);
		t.props = [];
		if(cfg.type === 'remote'){
			t.setupRemoteLogger(cfg);
		}else if(cfg.type === 'msg'){
			t.setupMsgLogger(cfg);
		}else if(cfg.type === 'eclipse'){
			t.setupEclipseLogger(cfg);
		}else { //default
			t.setupLocalLogger(cfg);
		}
		mgr.readConfigure(t.getConfig(cfg));
		cfg.beforeAct =function(traceLog){ t.logBef(traceLog);};
		cfg.afterAct = function(traceLog){t.logAft(traceLog);};
	},
	
	getConfig: function(cfg){
		return {properties:this.props};
	},
	
	setProperty: function(name, value){
		if(value){
			this.props[this.props.length] = [name, value];
		}
	},
	
	log: function(traceLog){
		var lr = new this.LR(this.L.INFO, "");
		lr.setParameters([traceLog]);
		this.LG.getLogger("org.eclipse.vjet.vsf.utils.jstrace.TraceLogger").logRecord(lr);
	},
	
	//=============
	//	Msg Logging
	//=============
	setupMsgLogger : function(cfg){
		cfg.logHandlers = "org.eclipse.vjet.vsf.utils.logging.MessageHandler";
		var t = this;
		t.logBef = t.logMsgBef;
		t.logAft = t.logMsgAft;		
		t.beforeMsgId = cfg.beforeMsgId;
		t.afterMsgId = cfg.afterMsgId;
		t.setProperty("org.eclipse.vjet.vsf.utils.jstrace.TraceLogger.handlers", 	cfg.logHandlers);
	},
	
	logMsgBef: function(traceLog){
		this.logMsg(this.beforeMsgId, traceLog);
	},
	
	logMsgAft: function(traceLog){
		this.logMsg(this.afterMsgId, traceLog);
	},		

	logMsg : function(svcId, traceLog){
		var lr = new this.LR(this.L.INFO, "");
		lr.setMsgId(svcId);
		lr.setParameters([traceLog]);
		this.LG.getLogger("org.eclipse.vjet.vsf.utils.jstrace.TraceLogger").logRecord(lr);
	},
	
	//=============
	//	Local Logging
	//=============
	setupLocalLogger : function(cfg){
		//cfg.logHandlers = null; // use default ConsoleHandler
		var t = this;
		t.logBef = t.log;
		t.logAft = t.log;
		//Local
		t.setProperty("org.eclipse.vjet.vsf.utils.jstrace.TraceLogger.formatter",	cfg.fmt);
	},
	
	//=============
	//	Remote Logging
	//=============
	setupRemoteLogger : function(cfg){
		cfg.logHandlers = "org.eclipse.vjet.vsf.utils.logging.RemoteHandler";
		var t = this;
		t.logBef = t.log;
		t.logAft = t.log;
		t.setProperty("org.eclipse.vjet.vsf.utils.jstrace.TraceLogger.handlers", 	cfg.logHandlers);
		t.setProperty("org.eclipse.vjet.vsf.utils.logging.RemoteHandler.uri", 		cfg.uri);
		t.setProperty("org.eclipse.vjet.vsf.utils.jstrace.RemoteFormatter.guid", 	cfg.guid);
		t.setProperty("org.eclipse.vjet.vsf.utils.jstrace.RemoteFormatter.lifespan",	cfg.life);
		t.setProperty("org.eclipse.vjet.vsf.utils.logging.RemoteHandler.formatter", 	"org.eclipse.vjet.vsf.utils.jstrace.RemoteFormatter");
	},
	
	//=============
	//	Eclipse Logging
	//=============
	setupEclipseLogger : function(cfg){
		cfg.logHandlers = "org.eclipse.vjet.vsf.utils.logging.RemoteHandler";
		var t = this;
		t.logBef = t.log;
		t.logAft = t.log;
		t.setProperty("org.eclipse.vjet.vsf.utils.jstrace.TraceLogger.handlers", 	cfg.logHandlers);
		t.setProperty("org.eclipse.vjet.vsf.utils.logging.RemoteHandler.uri", 		cfg.uri);
		t.setProperty("org.eclipse.vjet.vsf.utils.logging.RemoteHandler.formatter", 	"org.eclipse.vjet.vsf.utils.logging.RemoteFormatter");
	}	
})
.endType();
