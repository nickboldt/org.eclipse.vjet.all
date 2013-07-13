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
vjo.ctype("org.eclipse.vjet.vsf.utils.logging.LogRecord")
.needs("org.eclipse.vjet.vsf.utils.logging.Level")
.protos({
//level
//logger name
//message
//millis
//parameters
//src clz name
//src method name
//error
//>public
	constructs: function(level, msg){
		var t = this;
		t.bLR = true;//for logger.log() judgement
		t.level = level;
		t.msg = msg;
		t.millis = new Date().getTime().toString();
	},
	
	setMsg: function(msg){
		this.msg = msg;
	},
	
    //> public String getMsg()
	getMsg: function(){
		return this.msg;
	},
	
	setParameters: function(params){
		this.params = params;
	},
	
	setSrcClzName: function(name){
		this.srcClzName = name;
	},
	
	setSrcFuncName: function(name){
		this.srcFuncName = name;
	},
	
	setMillis: function(millis){
		this.millis = millis;
	},
	
	setLoggerName: function(name){
		this.loggerName = name;
	},
	
	setLevel: function(level){
		this.level = level;
	},
	
    //> public String getLevel()
	getLevel: function(){
		return this.level;
	},
	
    //> public String getLoggerName()
	getLoggerName: function(){
		return this.loggerName;
	},
	
    //> public long getMillis()
	getMillis: function(){
		return this.millis;
	},
	
    //> public String[] getParameters()
	getParameters: function(){
		return this.params || [];
	},
	
    //> public String getSrcClzName()
	getSrcClzName: function(){
		return this.srcClzName || '';
	},
	
    //> public String getSrcFuncName()
	getSrcFuncName: function(){
		return this.srcFuncName || '';
	},
	
	setMsgId: function(msgId){
		this.msgId = msgId;
	},
	
    //> public String getMsgId()
	getMsgId: function(){
		return this.msgId || '';
	}
	
})
.endType();
