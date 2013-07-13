package org.eclipse.vjet.vsf.dapunit;

import org.eclipse.vjet.dsf.active.dom.html.AHtmlElement;
import org.eclipse.vjet.dsf.common.exceptions.DsfRuntimeException;
import org.eclipse.vjet.dsf.dap.proxy.Global;
import org.eclipse.vjet.vsf.dapunit.DomError.Type;
import org.eclipse.vjet.vsf.dervlet.dap.Assertion;
import org.eclipse.vjet.vsf.dapunit.DomError;



//import com.ebay.dsf.active.dom.html.AHtmlElement;
//import com.ebay.dsf.common.exceptions.DsfRuntimeException;
//import com.ebay.dsf.dap.proxy.Global;
//import com.ebay.dsf.test.fwk.awu.Assertion;
//import com.ebay.dsf.test.fwk.dapunit.DomError;
//import com.ebay.dsf.test.fwk.dapunit.DomError.Type;

public abstract class StaticVldCommand {
	//
	// API
	//
	
	/**
	 * In replay, verify whether a given assertion still stands
	 */
	public DomError validateAssertion(Assertion assertion){
		String cont1 = assertion.getContent();
		String cont2 = getContent(assertion.getPath());
		if(compareString(cont1, cont2)){
			return null;
		}
		return new DomError(Type.INVALID_NODE_HTML, "Actual content doesn't match expected!");
	}
	
	/**
	 * In capture, build an Assertion for given path 
	 */
	public Assertion createAssertion(String path){
		Assertion assertion = new Assertion();
		assertion.setCmd(getCmdName());
		assertion.setPath(path);
		return assertion; 
	}
	
	/**
	 * Define whether this command is only available to specific elements 
	 */
	public String getTargetRegex(){
		return "[a-zA-Z]+";
	}
	
	//
	// Private
	//
	
	private boolean compareString(String cont1, String cont2){
		if(cont1 == null || cont2 == null){
			return cont1 == cont2;
		}
		if(cont1.length() != cont2.length()){
			return false;
		}
		return cont1.equals(cont2);
	}
	
	public String getContent(String path){
		AHtmlElement elem = findAElement(path);
		if(elem != null){
			return getContent(elem);
		}
		throw new DsfRuntimeException("Could not find element in ADOM with '"+path+"'");
	}
	
//	private static final String PATH_PREFIX = "document.getElementById(";
//	private static final int PATH_PREFIX_LEN = PATH_PREFIX.length();
//	private static final String STEP_PREFIX = ".childNodes[";
//	private static final int STEP_PREFIX_LEN = STEP_PREFIX.length();
	
	private AHtmlElement findAElement(String path){
		AHtmlElement elem = (AHtmlElement)Global.eval(path);
//		if(elem == null && path.startsWith(PATH_PREFIX)){
//			String step = path.substring(PATH_PREFIX_LEN + 1);
//			int end = step.indexOf(")");
//			String id = step.substring(0, end - 1);
//			elem = (AHtmlElement)DapCtx.ctx().getWindow().getDocument().getElementById(id);
//			step = step.substring(end);
//			while(elem != null && step.startsWith(STEP_PREFIX)){
//				step = step.substring(STEP_PREFIX_LEN);
//				int idx = new Integer(step.charAt(0)+"");
//				elem = (AHtmlElement) elem.getChildNodes().item(idx);
//			}
//		}
		return elem;
	}
	
	//
	// Abstract
	//
	
	/**
	 * Defined how a concrete command extract content from an ADOM element via given path
	 */
	protected abstract String getContent(AHtmlElement element);
	
	/**
	 * The name for a concrete command
	 */
	public abstract String getCmdName();
	
	//
	// Override
	//
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof StaticVldCommand){
			StaticVldCommand cmd = (StaticVldCommand)o;
			return compareString(getCmdName(), cmd.getCmdName());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getCmdName().hashCode();
	}
}
