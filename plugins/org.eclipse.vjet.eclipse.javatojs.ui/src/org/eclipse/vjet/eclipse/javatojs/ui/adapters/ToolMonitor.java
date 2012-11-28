/**
 * 
 */
package org.eclipse.vjet.eclipse.javatojs.ui.adapters;

import java.io.OutputStream;
import java.io.PrintStream;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.vjet.core.codegen.bootstrap.IToolMonitor;

/**
 * Wraps the Eclipse progress monitor in a tool monitor interface.
 * 
 * @author Ricker
 * 
 */
public class ToolMonitor implements IToolMonitor {

	private IProgressMonitor monitor;
	private PrintStream stream;
	private boolean console;

	public ToolMonitor(IProgressMonitor monitor, OutputStream stream) {
		this.monitor = monitor;
		setStream(stream);
		console = true;
	}
	
	public void setStream(OutputStream ostream) {
		if (ostream == null) {
			stream = System.out;
		} else {
			stream = new PrintStream(ostream);
		}
	}

	/**
	 * Set to output messages to console
	 * @param console
	 */
	public void setConsole(boolean console) {
		this.console = console;
	}

	public boolean isConsole() {
		return console;
	}

	public void beginTask(String name, int totalWork) {
		monitor.beginTask(name, totalWork);
		console(name + "\n");
	}

	public void done() {
		monitor.done();
		console("Done\n");
	}

	public boolean isCanceled() {
		return monitor.isCanceled();
	}

	public void setCanceled(boolean value) {
		monitor.setCanceled(value);
		console("Canceled\n");
	}

	public void subTask(String name) {
		monitor.setTaskName(name);
		console(name + "\n");
	}

	public void worked(int work) {
		monitor.worked(work);
		console(".");
	}

	protected void console(String msg) {
		if (console) {
			stream.print(msg);
		}
	}

}
