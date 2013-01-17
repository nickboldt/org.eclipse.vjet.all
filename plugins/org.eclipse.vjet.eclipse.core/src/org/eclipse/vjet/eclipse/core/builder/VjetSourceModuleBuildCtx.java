package org.eclipse.vjet.eclipse.core.builder;

import org.eclipse.dltk.mod.core.ISourceModule;
import org.eclipse.dltk.mod.internal.core.VjoSourceModule;
import org.eclipse.dltk.mod.internal.core.builder.SourceModuleBuildContext;
import org.eclipse.vjet.dsf.jst.IJstType;
public class VjetSourceModuleBuildCtx extends SourceModuleBuildContext {

	private IJstType unit = null;
	

	public VjetSourceModuleBuildCtx(ISourceModule module) {
		super(module);
	}

	public IJstType getUnit() {
		return unit;
	}

	public void setUnit(IJstType unit) {
		this.unit = unit;
	}

	public VjoSourceModule getVjoSourceModule(){
		return (VjoSourceModule) getSourceModule();
	}
	
	
	
	
}
