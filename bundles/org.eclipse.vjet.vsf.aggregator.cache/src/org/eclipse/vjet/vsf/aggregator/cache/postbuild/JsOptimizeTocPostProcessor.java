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
package org.eclipse.vjet.vsf.aggregator.cache.postbuild;

import java.util.ArrayList;
import java.util.Set;

import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.vsf.aggregator.cache.meta.AppJsExternalizationInfo;
import org.eclipse.vjet.vsf.aggregator.cache.meta.ViewJsExternalizationInfo;
import org.eclipse.vjet.vsf.aggregator.cache.meta.ViewJsExternalizationInfo.GrouppedJsInfo;

public class JsOptimizeTocPostProcessor {
	
	/**
	 * @param currentAppJsInfo
	 *            - Current AppJsExternalizationInfo
	 * @param oldAppJsInfo
	 *            - Previous versioned AppJsExternalizationInfo
	 * @return boolean - has been optimized
	 * 
	 * Will update the current AppJsExternalizationInfo. If any external files
	 * have the same md5, the file has not changed, so we can use the old (or
	 * cached) version of this file.
	 */
	public static boolean optimize(
			final AppJsExternalizationInfo currentAppJsInfo, 
			final AppJsExternalizationInfo oldAppJsInfo,
			final boolean isReroll) 
	{
		return optimize(currentAppJsInfo,oldAppJsInfo,isReroll,null);
	}
	
	public static boolean optimize(
			final AppJsExternalizationInfo currentAppJsInfo, 
			final AppJsExternalizationInfo oldAppJsInfo,
			final boolean isReroll,
			final IOptimizeTocPostProcessorRule rule) 
	{
		boolean isOptimized = false;
		//checking view deletions for re-roll builds
		if(isReroll){
			checkRerollViewDeletions(currentAppJsInfo,oldAppJsInfo);
		}
		for (ViewJsExternalizationInfo viewInfo : currentAppJsInfo.getAllViewJsInfos()) {
			ViewJsExternalizationInfo oldViewInfo = oldAppJsInfo.getViewJsInfo(viewInfo.getViewId());
			if (oldViewInfo!=null) {
				for (GrouppedJsInfo slotJsInfo : viewInfo.getAllGrouppedJsInfo()) {
					GrouppedJsInfo oldSlotJsInfo = oldViewInfo.getGrouppedJsInfo(slotJsInfo.getIndex());
					if (oldSlotJsInfo != null 
							&& oldSlotJsInfo.getMd5() != null
							&& oldSlotJsInfo.getOptimizedPath() != null
							&& oldSlotJsInfo.getMd5().equals(slotJsInfo.getMd5())) 
					{
//						slotJsInfo.setOptimizedPath(oldSlotJsInfo
//								.getOptimizedPath());
						String opath = oldSlotJsInfo.getOptimizedPath();
						if (rule != null) {
							opath = rule.getOptimizedPath(
									oldSlotJsInfo.getRelativePath(), oldSlotJsInfo
											.getOptimizedPath(), slotJsInfo
											.getRelativePath(), slotJsInfo
											.getOptimizedPath());
						}
						slotJsInfo.setOptimizedPath(opath);
						isOptimized = true;
					}
				}
			}
		}
		optimizeLocaleSpecficViews(currentAppJsInfo, oldAppJsInfo, rule);
		return isOptimized;
	}
	
	private static void optimizeLocaleSpecficViews(
			final AppJsExternalizationInfo currentAppJsInfo,
			final AppJsExternalizationInfo oldAppJsInfo,
			final IOptimizeTocPostProcessorRule rule) {
		for (ViewJsExternalizationInfo viewInfo : currentAppJsInfo
				.getAllViewJsInfos()) {
			ViewJsExternalizationInfo oldViewInfo = oldAppJsInfo
					.getViewJsInfo(viewInfo.getViewId());
			if (oldViewInfo != null) {
				Set<String> locales = viewInfo.getLocales();
				for(String locale : locales){
					for (GrouppedJsInfo slotJsInfo : viewInfo
							.getAllGrouppedJsInfo(locale)) {
						GrouppedJsInfo oldSlotJsInfo = oldViewInfo
								.getGrouppedJsInfo(slotJsInfo.getIndex(),locale);
						if (oldSlotJsInfo != null
								&& oldSlotJsInfo.getMd5() != null
								&& oldSlotJsInfo.getOptimizedPath() != null
								&& oldSlotJsInfo.getMd5().equals(
										slotJsInfo.getMd5())) {
//							slotJsInfo.setOptimizedPath(oldSlotJsInfo
//									.getOptimizedPath());
							String opath = oldSlotJsInfo.getOptimizedPath();
							if (rule != null) {
								opath = rule.getOptimizedPath(
										oldSlotJsInfo.getRelativePath(), oldSlotJsInfo
												.getOptimizedPath(), slotJsInfo
												.getRelativePath(), slotJsInfo
												.getOptimizedPath());
							}
							slotJsInfo.setOptimizedPath(opath);
						}
					}
				}
			}
		}
	}
	
	private static void checkRerollViewDeletions(
			final AppJsExternalizationInfo currentAppJsInfo,
			final AppJsExternalizationInfo oldAppJsInfo) {
		ArrayList<String> deletedViews = new ArrayList<String>();
		if (currentAppJsInfo == null || oldAppJsInfo == null) {
			return;
		}
		for (ViewJsExternalizationInfo oldview : oldAppJsInfo
				.getAllViewJsInfos()) {
			// checking whether old view exists in the current view or not
			if (currentAppJsInfo.getViewJsInfo(oldview.getViewId()) == null) {
				deletedViews.add(oldview.getViewId());
			}
		}
		if (deletedViews.size() > 0) {
			String errorMessage = "Viewspec(s) "
					+ deletedViews.toString()
					+ " deleted in application spec ["
					+ oldAppJsInfo.getAppId()
					+ "]. Deleting viewspec(s) are not permitted in the train re-rolls.";
			throw new DsfRuntimeException(errorMessage);
		}
	}

}