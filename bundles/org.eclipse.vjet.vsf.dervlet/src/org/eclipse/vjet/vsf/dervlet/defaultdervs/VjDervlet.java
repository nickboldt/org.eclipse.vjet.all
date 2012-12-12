package org.eclipse.vjet.vsf.dervlet.defaultdervs;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.eclipse.vjet.dsf.dap.rt.DapCtx.ExeMode;
import org.eclipse.vjet.dsf.dom.DNode;
import org.eclipse.vjet.dsf.dom.DText;
import org.eclipse.vjet.dsf.html.dom.DHtmlDocument;
import org.eclipse.vjet.dsf.jsnative.HtmlDocument;
import org.eclipse.vjet.dsf.jsnative.HtmlElement;
import org.eclipse.vjet.dsf.spec.component.IComponentSpec;
import org.eclipse.vjet.dsf.spec.view.DefaultViewSpec;
import org.eclipse.vjet.vsf.aggregator.view.DocProcessor;
import org.eclipse.vjet.vsf.dervlet.DsfDervlet;
import org.eclipse.vjet.vsf.docprocessing.ProductionCtx;

public class VjDervlet extends DsfDervlet{
	private static final String PARENT_ELEM_ID = "__dap_target_elem";
	private static final ExeMode DEFAULT_MODE = ExeMode.ACTIVE;
	private static final long serialVersionUID = 1L;
	public static int REMOTE_PORT = 7564;
	private static String JSR_SUFFIX = "Jsr";
	
	private Class<?> m_jsrClz = null;

	public static void main(String[] args) {
		if (args.length == 0) {
			throw new RuntimeException("Class name missing");
		}
		
		Class<?> clz = getJsrClass(args[0]);
		if (clz != null) {
			VjDervlet runner = new VjDervlet();
			runner.setJsrClz(clz);
			runner.runAsServer();
		}
	}

	private static Class<?> getJsrClass(String className) {
		if (className == null) {
			throw new NullPointerException("Class name cannot be null");
		}
		String jsrName = className + JSR_SUFFIX;
		return getClz(jsrName);
	}

	private static Class<?> getClz(String jsrName) {
		Class<?> clz = null;
		try {
			clz = Class.forName(jsrName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return clz;
	}
	
	public VjDervlet() {
		super("vjRunner", "/vjRunner?dapMode=A");

	}
	
	
	@Override
	public void init() throws ServletException {
		ExeMode dapMode = DEFAULT_MODE;
		String dapEnv = System.getProperty("dapMode");
		if ("W".equalsIgnoreCase(dapEnv)) {
			dapMode = ExeMode.WEB;
		} else if ("T".equalsIgnoreCase(dapEnv)) {
			dapMode = ExeMode.TRANSLATE;
		}
		
		this.getDapIntercepter().setDapMode(dapMode);

	}
	
	
	@Override
	public DNode createFragment(HttpServletRequest request) {
		String className = request.getParameter("class");
		if (className != null && className.length() > 0) {
			Class<?> jsr = getJsrClass(className);
			if (jsr == null) {
				throw new RuntimeException("Unable to find class for " + className);
			}
			m_jsrClz = jsr;
		}
		if (m_jsrClz == null) {
			throw new RuntimeException("Unable to run as Dervlet");
		}
		String triggerMtdName = getTriggerMethodName(className);
		if (triggerMtdName == null || triggerMtdName.length() == 0) {
			return new DText("Unable to find a suitable trigger method. Expects a method with 'ANode' or 'void' return type and no params.");
		}
		
		Method triggerMtd;
		DNode dNode = null;
		try {
			DefaultViewSpec spec = new DefaultViewSpec();
			spec.setComponentSpec((IComponentSpec)m_jsrClz.getField("SPEC").get(m_jsrClz));
			ProductionCtx.ctx().getPlan().setViewSpec(spec);
			
			Class<?> clz = getClz(className);
			if (clz == null) {
				return new DText("Error: Class not found for name " + className);
			}
			triggerMtd = clz.getMethod(triggerMtdName);

			boolean isStatic = Modifier.isStatic(triggerMtd.getModifiers());
			
			dNode = ANodeToDocument.createHtmlDocumentContaining(triggerMtd.getReturnType(), PARENT_ELEM_ID, getCallString(clz, triggerMtdName, PARENT_ELEM_ID, isStatic));
			if (dNode instanceof DHtmlDocument) {
				new DocProcessor(ProductionCtx.ctx().getPlan()).process((DHtmlDocument)dNode);
			}

		} catch (Throwable e1) {
			e1.printStackTrace();
			return new DText("Tried: /vjRunner?"+request.getQueryString()+", got: "+DervletAdminServlet.toMessageString(e1));
		} 
		
		return dNode;
	}

	private String getCallString(Class<?> clz, String mtdName, String elemId, boolean isStatic) {
		StringBuilder sb = new StringBuilder();
		if (isStatic) {
			sb.append(clz.getName()).append('.').append(mtdName).append("()");
		} else {
			sb.append("(function () {var rs=new ").append(clz.getName()).append("();");
			sb.append("return rs.").append(mtdName).append("();})()");
			
		}
		return sb.toString();
	}
	private static String getTriggerMethodName(String className) {
		Class<?> clz = getClz(className);
		
		//First look for HtmlElement/HtmlDocument return type
		for (Method mtd : clz.getDeclaredMethods()) {
			if (!Modifier.isPublic(mtd.getModifiers())) {
				continue;
			}
			Class<?> returnType = mtd.getReturnType();
			if (HtmlElement.class.isAssignableFrom(returnType)
					|| HtmlDocument.class.isAssignableFrom(returnType)) {
				if (mtd.getParameterTypes().length == 0) {
					return mtd.getName();
				}
			}
		}
		
		//If HtmlElement/HtmlDocument return type not found then look for void
		for (Method mtd : clz.getDeclaredMethods()) {
			if (!Modifier.isPublic(mtd.getModifiers())) {
				continue;
			}
			Class<?> returnType = mtd.getReturnType();
			//if (returnType.isAssignableFrom(void.class)) {
			if (void.class.equals(returnType)) {
				if (mtd.getParameterTypes().length == 0) {
					return mtd.getName();
				}
			}
		}
			
		return null;
	}

	public Class<?> getJsrClz() {
		return m_jsrClz;
	}

	public void setJsrClz(Class<?> clz) {
		m_jsrClz = clz;
	}	

}
