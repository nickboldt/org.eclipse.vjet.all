/*******************************************************************************
 * Copyright (c) 2008, 2012 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Alex Panchenko)
 *******************************************************************************/
package org.eclipse.dltk.mod.compiler.problem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.dltk.mod.compiler.task.ITaskReporter;

public class ProblemCollector extends AbstractProblemReporter implements
		ITaskReporter {

	protected final List problems = new ArrayList();

	public void reportProblem(IProblem problem) {
		problems.add(problem);
	}

	public void reportTask(String message, int lineNumber, int priority,
			int charStart, int charEnd) {
		reportProblem(new TaskInfo(message, lineNumber, priority, charStart,
				charEnd));
	}

	/**
	 * @return
	 */
	public boolean isEmpty() {
		return problems.isEmpty();
	}

	public Object getAdapter(Class adapter) {
		if (ITaskReporter.class.equals(adapter)
				|| IProblemReporter.class.equals(adapter)) {
			return this;
		}
		return super.getAdapter(adapter);
	}

	/**
	 * @return
	 */
	public boolean hasErrors() {
		if (!problems.isEmpty()) {
			for (Iterator i = problems.iterator(); i.hasNext();) {
				final IProblem problem = (IProblem) i.next();
				if (problem.isError()) {
					return true;
				}
			}
		}
		return false;
	}

	public static class TaskInfo extends CategorizedProblem {

		private final String message;
		private final int charStart;
		private final int lineNumber;
		private final int charEnd;
		private final int priority;

		/**
		 * @param message
		 * @param lineNumber
		 * @param charEnd
		 * @param charStart
		 */
		public TaskInfo(String message, int lineNumber, int priority,
				int charStart, int charEnd) {
			this.message = message;
			this.lineNumber = lineNumber;
			this.priority = priority;
			this.charEnd = charEnd;
			this.charStart = charStart;
		}

		public int getCategoryID() {
			return 0;
		}

		public String getMarkerType() {
			return DefaultProblem.MARKER_TYPE_TASK;
		}

		public String[] getArguments() {
			return null;
		}

		public int getID() {
			return IProblem.Task;
		}

		public String getMessage() {
			return message;
		}

		public String getOriginatingFileName() {
			return null;
		}

		public int getSourceEnd() {
			return charEnd;
		}

		public int getSourceLineNumber() {
			return lineNumber;
		}

		public int getSourceStart() {
			return charStart;
		}

		public int getPriority() {
			return priority;
		}

		public boolean isError() {
			return false;
		}

		public boolean isWarning() {
			return false;
		}

		public void setSourceEnd(int sourceEnd) {
			// unsupported
		}

		public void setSourceLineNumber(int lineNumber) {
			// unsupported
		}

		public void setSourceStart(int sourceStart) {
			// unsupported
		}

		public String toString() {
			final StringBuffer sb = new StringBuffer();
			sb.append("Task"); //$NON-NLS-1$
			sb.append(' ');
			sb.append(lineNumber);
			sb.append('[');
			sb.append(charStart);
			sb.append(".."); //$NON-NLS-1$
			sb.append(charEnd);
			sb.append(']');
			sb.append(':');
			if (this.message != null) {
				sb.append(this.message);
			}
			return sb.toString();
		}

	}

	/**
	 * @param destination
	 */
	public void copyTo(IProblemReporter destination) {
		for (Iterator i = problems.iterator(); i.hasNext();) {
			final IProblem problem = (IProblem) i.next();
			destination.reportProblem(problem);
		}
	}

	/**
	 * @return
	 */
	public List getErrors() {
		final List result = new ArrayList();
		for (Iterator i = problems.iterator(); i.hasNext();) {
			final IProblem problem = (IProblem) i.next();
			if (problem.isError()) {
				result.add(problem);
			}
		}
		return result;
	}

}
