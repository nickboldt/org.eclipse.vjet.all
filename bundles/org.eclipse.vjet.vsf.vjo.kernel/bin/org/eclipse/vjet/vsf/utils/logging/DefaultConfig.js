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
vjo.ctype("org.eclipse.vjet.vsf.utils.logging.DefaultConfig")
.needs("org.eclipse.vjet.vsf.utils.logging.Level")
.needs("org.eclipse.vjet.vsf.utils.logging.ConsoleHandler")
.needs("org.eclipse.vjet.vsf.utils.logging.SimpleFormatter")
.props({
	properties: [

//============================================
//  	Default Logging Configuration File
//============================================

//=========================================
//	!! IMPORTANT !!
//	Format of property lines:
//	["key", "value"],
//	DO add ',' at the end of each config line, leave the endGuard to close array
//=========================================

//============================================
//  	Global properties
//============================================

// "handlers" specifies a '&' separated list of log Handler 
// classes.  These handlers will be installed during VM startup.
// Note that these classes must be on the system classpath.
// By default we only configure a ConsoleHandler, which will only
// show messages at the INFO and above levels.
	["handlers", "org.eclipse.vjet.vsf.utils.logging.ConsoleHandler"],

// To also add the RemoteHandler, use the following line instead.
//  ["handlers", "org.eclipse.vjet.vsf.utils.logging.RemoteHandler & org.eclipse.vjet.vsf.utils.logging.ConsoleHandler"],

// Default global logging level.
// This specifies which kinds of events are logged across
// all loggers.  For any given facility this global level
// can be overriden by a facility specific level
// Note that the ConsoleHandler also has a separate level
// setting to limit messages printed to the console.
	[".level", "INFO"],

//============================================
// Handler specific properties.
// Describes specific configuration info for Handlers.
//============================================

// Limit the message that are printed on the console to INFO and above.
	["org.eclipse.vjet.vsf.utils.logging.ConsoleHandler.level", "INFO"],
	
	["org.eclipse.vjet.vsf.utils.logging.ConsoleHandler.formatter", "org.eclipse.vjet.vsf.utils.logging.SimpleFormatter"],

	["org.eclipse.vjet.vsf.utils.logging.RemoteHandler.contentTag", "rhArea"],
	
	["org.eclipse.vjet.vsf.utils.logging.RemoteHandler.lineSeparater", "\t"],

//============================================
// Facility specific properties.
// Provides extra control for each logger.
//============================================

// For example, set the com.xyz.foo logger to only log SEVERE
// messages:
// ["com.xyz.foo.level", "SEVERE"],

//==============================================
//Ending
//==============================================
	["endGuard",""]
	]
})
.endType();
