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
package org.eclipse.dltk.mod.debug.core.eval;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.model.IDebugElement;

public class InspectEvaluatedScriptExpression extends EvaluatedScriptExpression
		implements IDebugEventSetListener {

	public InspectEvaluatedScriptExpression(IScriptEvaluationResult result) {
		super(result);

		DebugPlugin.getDefault().addDebugEventListener(this);
	}

	public void handleDebugEvents(DebugEvent[] events) {
		for (int i = 0; i < events.length; i++) {
			DebugEvent event = events[i];
			switch (event.getKind()) {
			case DebugEvent.TERMINATE:
				if (event.getSource().equals(getDebugTarget())) {
					DebugPlugin.getDefault().getExpressionManager()
							.removeExpression(this);
				}
				break;
			case DebugEvent.SUSPEND:
				if (event.getDetail() != DebugEvent.EVALUATION_IMPLICIT) {
					if (event.getSource() instanceof IDebugElement) {
						IDebugElement source = (IDebugElement) event
								.getSource();
						if (source.getDebugTarget().equals(getDebugTarget())) {
							DebugPlugin.getDefault().fireDebugEventSet(
									new DebugEvent[] { new DebugEvent(this,
											DebugEvent.CHANGE,
											DebugEvent.CONTENT) });
						}
					}
				}
				break;
			}
		}
	}

	public void dispose() {
		super.dispose();

		DebugPlugin.getDefault().removeDebugEventListener(this);
	}
}
