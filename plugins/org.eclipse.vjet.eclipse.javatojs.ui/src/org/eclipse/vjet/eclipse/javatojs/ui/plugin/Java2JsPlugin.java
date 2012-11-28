//
//package com.ebay.tools.v4.java2js.plugin;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.Properties;
//
//import org.eclipse.core.runtime.FileLocator;
//import org.eclipse.core.runtime.Path;
//import org.eclipse.core.runtime.Status;
//import org.eclipse.ui.console.ConsolePlugin;
//import org.eclipse.ui.console.IConsole;
//import org.eclipse.ui.console.IConsoleManager;
//import org.eclipse.ui.console.MessageConsole;
//import org.osgi.framework.BundleContext;
//
//import com.ebay.tools.core.ui.AbstractEbayUIActivator;
//import com.ebay.tools.v4.java2js.adapters.Java2JsInput;
//
///**
// * The activator class controls the plug-in life cycle
// */
//public class Java2JsPlugin extends AbstractEbayUIActivator {
//
//	// The plug-in ID
//	public static final String PLUGIN_ID = "com.ebay.tools.v4.codegen.java2js";
//
//	public static final String MESSAGE_CONSOLE = "Java2Js";
//	
//	private Properties properties;
//	
//	// The shared instance
//	private static Java2JsPlugin plugin;
//	
//	private URL defaultJava2JsConfig;
//	
//	
//	/**
//	 * The constructor
//	 */
//	public Java2JsPlugin() {
//		plugin = this;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
//	 */
//	public void start(BundleContext context) throws Exception {
//		super.start(context);
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
//	 */
//	public void stop(BundleContext context) throws Exception {
//		plugin = null;
//		super.stop(context);
//	}
//
//	/**
//	 * Returns the shared instance
//	 *
//	 * @return the shared instance
//	 */
//	public static Java2JsPlugin getDefault() {
//		return plugin;
//	}
//	
//	/**
//	 * The plug-in contains the default configuration file.
//	 * @return URL to the default config file
//	 */
//	public URL getDefaultJava2JsConfig() {
//		if (defaultJava2JsConfig == null) {
//			Path path = new Path(Java2JsInput.CONFIG_FILE_NAME);
//			URL url = FileLocator.find(getBundle(),path,null);
//			try {
//				defaultJava2JsConfig = FileLocator.toFileURL(url);
//			} catch (IOException e) {
//				logException(e);
//			}
//		}
//		return defaultJava2JsConfig;
//	}
//	
//	public Properties getDefaultJava2JsConfigProperties() {
//		if 	(properties == null) {
//			properties = new Properties();
//			Path path = new Path(Java2JsInput.CONFIG_FILE_NAME);
//			try {
//				properties.load(FileLocator.openStream(getBundle(), path, false));
//			} catch (IOException e) {
//				logException(e);
//			}
//		}	
//		return properties;
//	}
//	
//	/**
//	 * Platform log
//	 * @param e
//	 */
//	public static void logException(Exception e) {
//		plugin.getLog().log(new Status(Status.ERROR, PLUGIN_ID, e.getLocalizedMessage(), e));
//	}
//
//	/**
//	 * Message console
//	 * @return
//	 */
//	public MessageConsole getConsole() {
//		IConsoleManager mgr = ConsolePlugin.getDefault().getConsoleManager();
//		for (IConsole console : mgr.getConsoles()) {
//			if (MESSAGE_CONSOLE.equals(console.getName())) {
//				return (MessageConsole)console;
//			}
//		}
//		MessageConsole msgconsole = new MessageConsole(MESSAGE_CONSOLE, null);
//		mgr.addConsoles(new IConsole[]{msgconsole});
//		return msgconsole;
//	}
//
//}
