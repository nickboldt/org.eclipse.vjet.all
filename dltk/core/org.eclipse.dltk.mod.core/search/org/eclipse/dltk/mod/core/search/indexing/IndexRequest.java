/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.eclipse.dltk.mod.core.search.indexing;

import org.eclipse.core.runtime.IPath;
import org.eclipse.dltk.mod.internal.core.search.processing.IJob;


public abstract class IndexRequest implements IJob {
	protected boolean isCancelled = false;
	protected IPath containerPath;
	protected IndexManager manager;

	public IndexRequest(IPath containerPath, IndexManager manager) {
		this.containerPath = containerPath;
		this.manager = manager;
	}
	public boolean belongsTo(String projectNameOrArchivePath) {
		// used to remove pending jobs because the project was deleted... not to delete index files
		// can be found either by project name or  path name
		return projectNameOrArchivePath.equals(this.containerPath.segment(0))
			|| projectNameOrArchivePath.equals(this.containerPath.toString());
	}
	public void cancel() {
		this.manager.jobWasCancelled(this.containerPath);
		this.isCancelled = true;
	}
	public void ensureReadyToRun() {
		// tag the index as inconsistent
		this.manager.aboutToUpdateIndex(this.containerPath, updatedIndexState());
	}
	protected Integer updatedIndexState() {
		return IndexManager.UPDATING_STATE;
	}
}
