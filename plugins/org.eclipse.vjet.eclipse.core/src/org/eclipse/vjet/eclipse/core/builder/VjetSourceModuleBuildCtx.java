package org.eclipse.vjet.eclipse.core.builder;

import org.eclipse.dltk.mod.core.ISourceModule;
import org.eclipse.dltk.mod.internal.core.VjoSourceModule;
import org.eclipse.dltk.mod.internal.core.builder.SourceModuleBuildContext;
import org.eclipse.vjet.dsf.jst.IScriptUnit;

public class VjetSourceModuleBuildCtx extends SourceModuleBuildContext {

	private IScriptUnit unit = null;
	

	public VjetSourceModuleBuildCtx(ISourceModule module) {
		super(module);
	}

	public IScriptUnit getUnit() {
		return unit;
	}

	public void setUnit(IScriptUnit unit) {
		this.unit = unit;
	}

	public VjoSourceModule getVjoSourceModule(){
		return (VjoSourceModule) getSourceModule();
	}
	
	
	
	
}
