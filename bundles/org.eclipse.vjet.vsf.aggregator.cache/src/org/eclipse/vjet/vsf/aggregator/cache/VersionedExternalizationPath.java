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
package org.eclipse.vjet.vsf.aggregator.cache;

import org.eclipse.vjet.dsf.resource.permutation.Permutation;
import org.eclipse.vjet.dsf.spec.app.IAppSpec;
import org.eclipse.vjet.dsf.spec.view.IViewSpec;

public class VersionedExternalizationPath implements IExternalizationPath {
	
	private final String m_majorVer;
	private final String m_minorVer;
	
	public VersionedExternalizationPath() {
		m_majorVer = "v";
		m_minorVer = "";
	}
	
	public VersionedExternalizationPath(
		final String majorVer, final String minorVer)
	{
		m_majorVer = majorVer;
		m_minorVer = minorVer;
	}
	
	public String getMajorVersion() {
		return m_majorVer;
	}
	
	public String getMinorVersion() {
		return m_minorVer;
	}
	
	public String getRelativePath(
		final Permutation permutation, final IAppSpec appSpec, final IViewSpec viewSpec)
	{
		return getRelativePath(permutation, appSpec, viewSpec, null);
	}
	
	public String getRelativePath(
		final Permutation permutation, final IAppSpec appSpec, final IViewSpec viewSpec, 
		final String index)
	{
		return getRelativePath(permutation, getRelativePath(appSpec, viewSpec, index));
	}
	
	public String getRelativePath(final Permutation permutation, final String subPath) {
		StringBuilder sb = new StringBuilder(60);
		String localeStr = permutation.getLocale().toString();
		if (permutation.isLanguageSpecific()) {
			localeStr = permutation.getParent().getLocale().toString() + "__" + localeStr;
		}
		sb.append(localeStr);
		if (permutation.getTarget() != null && !Permutation.isDefaultTarget(permutation.getTarget())) {
			sb.append("/");
			sb.append(permutation.getTarget());
		}
		sb.append("/")
		  .append(subPath)
		  .append("_")
		  .append(localeStr);
		
		return sb.toString();
	}
	
	public String getRelativePath(final IAppSpec appSpec, final IViewSpec viewSpec) {
		return getRelativePath(appSpec, viewSpec, null);
	}
	
	public String getRelativePath(
		final IAppSpec appSpec, final IViewSpec viewSpec, final String index)
	{
		StringBuilder sb = new StringBuilder(50);
		sb.append(m_majorVer).append("/")
		  .append(appSpec.getName()).append("_")
		  .append(viewSpec.getName()).append("_")
		  .append(m_majorVer).append(m_minorVer.replaceAll(":", "_"));
		if (index != null && index.length() > 0) {
			sb.append("_").append(index);
		}
		
		return sb.toString();
	}
	
	public String getRelativePath(
			final IAppSpec appSpec, final String index)
		{
			StringBuilder sb = new StringBuilder(50);
			sb.append(m_majorVer).append("/")
			  .append(appSpec.getName()).append("_")
			  .append("Common").append("_")
			  .append(m_majorVer).append(m_minorVer);
			if (index != null && index.length() > 0) {
				sb.append("_").append(index);
			}
			
			return sb.toString();
		}
	
	public String getRelativePath(
			final Permutation permutation, final IAppSpec appSpec,
			final String index)
		{
			return getRelativePath(permutation, getRelativePath(appSpec, index));
		}
}
