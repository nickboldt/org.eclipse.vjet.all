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
 package org.eclipse.vjet.core.codegen.bootstrap;
  
  /**
   * The IToolMonitor interface is implemented by objects that monitor the
   * progress of an activity; the methods in this interface are invoked by code
   * that performs the activity.
   * <p>
   * All activity is broken down into a linear sequence of tasks against which
   * progress is reported. When a task begins, a beginTask(String, int)
   * notification is reported, followed by any number and mixture of progress
   * reports (worked()) and subtask notifications (subTask(String)). When the task
   * is eventually completed, a done() notification is reported. After the done()
   * notification, the progress monitor cannot be reused; i.e., beginTask(String,
   * int) cannot be called again after the call to done().
   * <p>
   * A request to cancel an operation can be signaled using the setCanceled
   * method. Operations taking a progress monitor are expected to poll the monitor
   * (using isCanceled) periodically and abort at their earliest convenience.
   * Operation can however choose to ignore cancelation requests.
   * <p>
   * Since notification is synchronous with the activity itself, the listener
   * should provide a fast and robust implementation. If the handling of
   * notifications would involve blocking operations, or operations which might
   * throw uncaught exceptions, the notifications should be queued, and the actual
   * processing deferred (or perhaps delegated to a separate thread).
   * <p>
   * This interface can be used without OSGi running.
   * <p>
   * Clients may implement this interface.
   * <p>
   * Here is the recommended basic pattern for using progress monitors:
   * 
   * <pre>
   *  final int TOTAL_WORK = 100;
   *  try {
   *    monitor.beginTask(&quot;Name of task&quot;, TOTAL_WORK);
   *    for (int i = 0; i &lt; TOTAL_WORK; i++) {
   *    monitor.subTask(&quot;Name of sub task&quot;);
   *    //do some work
   *    monitor.worked(1);
   *  } finally {
   *    monitor.done();
   *  }
   *  </pre>
   * 
   * 
   * @author jricker
   * @see org.eclipse.core.runtime.IProgressMonitor
   * 
   */
  public interface IToolMonitor {
  
      /**
       * Constant indicating an unknown amount of work.
       */
      public static final int UNKNOWN = -1;
  
      /**
       * Notifies that the main task is beginning. This must only be called once
       * on a given progress monitor instance.
       * 
       * @param name
       *            the name (or description) of the main task
       * @param totalWork
       *            the total number of work units into which the main task is
       *            been subdivided. If the value is UNKNOWN the implementation is
       *            free to indicate progress in a way which doesn't require the
       *            total number of work units in advance.
       */
      public void beginTask(String name, int totalWork);
  
      /**
       * Notifies that the work is done; that is, either the main task is
       * completed or the user canceled it. This method may be called more than
       * once (implementations should be prepared to handle this case).
       * 
       * 
       */
      public void done();
  
      /**
       * Sets the task name to the given value. This method is used to restore the
       * task label after a nested operation was executed. Normally there is no
       * need for clients to call this method.
       * 
       * @param name
       *            the name (or description) of the main task
       */
      public void subTask(String name);
  
      /**
       * Notifies that a given number of work unit of the main task has been
       * completed. Note that this amount represents an installment, as opposed to
       * a cumulative amount of work done to date.
       * 
       * @param work
       *            the number of work units just completed
       */
      public void worked(int work);
  
      /**
       * Returns whether cancelation of current operation has been requested.
       * Long-running operations should poll to see if cancelation has been
       * requested.
       * 
       * @return true if cancellation has been requested, and false otherwise
       */
      public boolean isCanceled();
  
      /**
       * Sets the cancel state to the given value
       * 
       * @param value
       *            true indicates that cancelation has been requested (but not
       *            necessarily acknowledged); false clears this flag
       */
      public void setCanceled(boolean value);
  
  }