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
package org.eclipse.vjet.dsf.resource.x;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.resource.permutation.Permutation;
import org.eclipse.vjet.dsf.resource.trace.ResourceUsageCtx;



public abstract class ResourceCtxIsolatedProcessor<RETURN_OBJ, THROWABLE extends Throwable> {
	protected abstract RETURN_OBJ process() throws THROWABLE;
	
	public enum ProcessMode {
		None,
		JsObf,
		JsMin,
		CssOpt,
		Verbose,
		FragmentExtraction,
		Inherit // tells to use whatever is currently available in resource context in addition to extract modes
	}
	public RETURN_OBJ run(ProcessMode... actions) throws THROWABLE {
		return run(null, null, actions);
	}
	
	public RETURN_OBJ run(Permutation permutation, Boolean secure, ProcessMode... actions) throws THROWABLE {
		Set<ProcessMode> actionsSet = new HashSet<ProcessMode>(Arrays.asList(actions));
		
		boolean oldNeedObf = ResourceUsageCtx.ctx().isNeedObfuscation();
		boolean oldNeedMin = ResourceUsageCtx.ctx().isNeedMinification();
		boolean oldNeedCssOpt = ResourceUsageCtx.ctx().isNeedCssOptimization();
		boolean oldVerboseMode = ResourceUsageCtx.ctx().isNeedVerboseInfo();
		boolean oldFragmentExtractionMode = ResourceUsageCtx.ctx().isFragmentExtractionMode();
		Permutation oldPermutation = null;
		Boolean oldSecure = null;
		
		
		try {
			
			if (secure != null) {
				oldSecure = DsfCtx.ctx().isSecureRequest();
				DsfCtx.ctx().setRequestSecure(secure);
			}
			
			if (permutation != null) {
				oldPermutation = Permutation.getFromCtx();
				permutation.setToCtx();
			}

			ResourceUsageCtx.ctx().setNeedObfuscation(actionsSet.contains(ProcessMode.JsObf) 
					|| actionsSet.contains(ProcessMode.Inherit) && ResourceUsageCtx.ctx().isNeedObfuscation());
			
			ResourceUsageCtx.ctx().setNeedMinification(actionsSet.contains(ProcessMode.JsMin)
					|| actionsSet.contains(ProcessMode.Inherit) && ResourceUsageCtx.ctx().isNeedMinification());
			
			ResourceUsageCtx.ctx().setNeedCssOptimization(actionsSet.contains(ProcessMode.CssOpt)
					|| actionsSet.contains(ProcessMode.Inherit) && ResourceUsageCtx.ctx().isNeedCssOptimization());
			
			ResourceUsageCtx.ctx().setNeedVerboseInfo((actionsSet.contains(ProcessMode.Verbose) 
					|| actionsSet.contains(ProcessMode.Inherit) && ResourceUsageCtx.ctx().isNeedVerboseInfo()) 
					&& !actionsSet.contains(ProcessMode.FragmentExtraction)); // fragment extraction overrides verbose
			
			ResourceUsageCtx.ctx().setFragmentExtractionMode(actionsSet.contains(ProcessMode.FragmentExtraction));
			
			return process();
		}
		finally {
			ResourceUsageCtx.ctx().setNeedObfuscation(oldNeedObf);
			ResourceUsageCtx.ctx().setNeedMinification(oldNeedMin);
			ResourceUsageCtx.ctx().setNeedCssOptimization(oldNeedCssOpt);
			ResourceUsageCtx.ctx().setNeedVerboseInfo(oldVerboseMode);
			ResourceUsageCtx.ctx().setFragmentExtractionMode(oldFragmentExtractionMode);
			
			if (oldPermutation != null) {
				oldPermutation.setToCtx();
			}
			
			if (oldSecure != null) {
				DsfCtx.ctx().setRequestSecure(oldSecure);
			}
			
		}
	}
}
