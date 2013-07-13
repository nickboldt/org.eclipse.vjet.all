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
package org.eclipse.vjet.vsf.resource.pattern.js.coverage;

public class JsCoverageFunction {

	private String m_functionName;
	private String [] m_trackLineCoverage=new String[0];
	private int m_currentLineCoverage;
	private int m_totalLines;
	private String m_instrJs = "";

	public JsCoverageFunction() {
	}
	
	public JsCoverageFunction(final String name) {
		m_functionName = name;
	}
	
	public String getFunctionName() {
		return m_functionName;
	}

	public void setFunctionName(final String functionName) {
		m_functionName = functionName;
	}

	public String[] getTrackLineCoverage() {
		return m_trackLineCoverage;
	}

	public void setTrackLineCoverage(final String[] trackLineCoverage) {
		this.m_trackLineCoverage = trackLineCoverage;
	}
	
	public int getCurrentLineCoverage() {
		return m_currentLineCoverage;
	}

	public void setCurrentLineCoverage(final int lineCoverage) {
		m_currentLineCoverage = lineCoverage;
	}

	public int getTotalLines() {
		return m_totalLines;
	}

	public void setTotalLines(final int lines) {
		m_totalLines = lines;
	}
	
	public String getInstrJs() {
		return m_instrJs;
	}

	public void setInstrJs(final String instrJs) {
		m_instrJs = instrJs;
	}
}
