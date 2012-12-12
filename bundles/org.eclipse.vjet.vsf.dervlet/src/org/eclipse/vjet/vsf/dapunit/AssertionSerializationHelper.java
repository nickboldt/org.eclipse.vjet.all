package org.eclipse.vjet.vsf.dapunit;

import java.util.Map;

import org.eclipse.vjet.dsf.dap.rt.DapCtx;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.eclipse.vjet.dsf.dap.cnr.DapCaptureXmlSerializer.CDataSerializer;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureXmlSerializer.CharactersSerializer;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureXmlSerializer.CollectionSubSerializer;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureXmlSerializer.DapCaptureDataSubHandler;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureXmlSerializer.DapCaptureDataSubSerializer;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureXmlSerializer.ObjectSubSerializer;
import org.eclipse.vjet.dsf.dap.cnr.DapCaptureXmlSerializer.PrimitiveHandler;
import org.eclipse.vjet.vsf.dervlet.dap.Assertion;


public class AssertionSerializationHelper {
	private static final String CLZNAME_ASSERTION = "Assertion";
	
	private static final String TAGNAME_ASSERTIOIN = "Assertion";
	private static final String TAGNAME_ACONTENT = "AContent";
	private static final String TAGNAME_APATH = "APath";
	private static final String TAGNAME_ACTIONS = "Actions";
	
	private static final String ATTRNAME_CMD = "cmd";
	
	private static final String FLDNAME_CONTENT = "m_content";
	private static final String FLDNAME_PATH = "m_path";
	private static final String FLDNAME_CMD = "m_cmd";
	private static final String FLDNAME_ACTIONS = "m_actions";

	private static final String DOT = ".";

	private AssertionSerializationHelper(){}
	
	public static void enableAssertion(){
		Map<String, Class<? extends DapCaptureDataSubSerializer>> serRegistry = 
			DapCtx.ctx().getDapConfig().getDapCaptureDataSerializerRegistry();
		
		serRegistry.put(CLZNAME_ASSERTION, 
				AssertionSerializer.class);
		serRegistry.put(CLZNAME_ASSERTION + DOT + FLDNAME_PATH, 
				CharactersSerializer.class);
		serRegistry.put(CLZNAME_ASSERTION + DOT + FLDNAME_CONTENT, 
				CDataSerializer.class);
		serRegistry.put(CLZNAME_ASSERTION + DOT + FLDNAME_ACTIONS, 
				CollectionSubSerializer.class);
		
		Map<String, Class<? extends DapCaptureDataSubHandler>> deserRegistry = 
			DapCtx.ctx().getDapConfig().getDapCaptureDataDeserializerRegistry();
		
		deserRegistry.put(TAGNAME_ASSERTIOIN, 
				AssertionHandler.class);
		deserRegistry.put(TAGNAME_APATH, 
				AssertionPrimitiveHandler.class);
		deserRegistry.put(TAGNAME_ACONTENT, 
				AssertionPrimitiveHandler.class);
	}
	
	public static void disableAssertion(){
		Map<String, Class<? extends DapCaptureDataSubSerializer>> serRegistry = 
			DapCtx.ctx().getDapConfig().getDapCaptureDataSerializerRegistry();
		
		serRegistry.remove(CLZNAME_ASSERTION);
		serRegistry.remove(CLZNAME_ASSERTION + DOT + FLDNAME_PATH);
		serRegistry.remove(CLZNAME_ASSERTION + DOT + FLDNAME_CONTENT);
		
		Map<String, Class<? extends DapCaptureDataSubHandler>> deserRegistry = 
			DapCtx.ctx().getDapConfig().getDapCaptureDataDeserializerRegistry();
		
		deserRegistry.remove(TAGNAME_ASSERTIOIN);
		deserRegistry.remove(TAGNAME_APATH);
		deserRegistry.remove(TAGNAME_ACONTENT);
	}
	
	public static class AssertionSerializer extends ObjectSubSerializer{

		@Override
		protected String[] getAttrFields() {
			return new String[]{FLDNAME_CMD};
		}
		
		@Override
		protected String[] getNodeFields() {
			return new String[]{FLDNAME_PATH, FLDNAME_CONTENT, FLDNAME_ACTIONS};
		}
		
		@Override
		protected String getDisplayName(String fldName, boolean capitalizeFirst) {
			if(FLDNAME_PATH.equals(fldName)){
				return TAGNAME_APATH;
			}else if(FLDNAME_CONTENT.equals(fldName)){
				return TAGNAME_ACONTENT;
			}else if(FLDNAME_ACTIONS.equals(fldName)){
				return TAGNAME_ACTIONS;
			}
			return super.getDisplayName(fldName, capitalizeFirst);
		}
	}
	
	public static class AssertionHandler extends DapCaptureDataSubHandler{

		@Override
		public void startElement(String uri, String localName, String name,
				Attributes attributes) throws SAXException {
			Assertion ass = new Assertion();
			ass.setCmd(attributes.getValue(ATTRNAME_CMD));
			String grpName = (String)getObjStack().pop();
			getHolder()
				.getValue()
				.getCurrentViewCapture()
				.addEventCapture(grpName, ass);
			getObjStack().push(grpName);
			getObjStack().push(ass);
		}
		
		@Override
		public void endElement(String uri, String localName, String name)
				throws SAXException {
			getObjStack().pop();
		}
	}
	
	public static class AssertionPrimitiveHandler extends PrimitiveHandler{
		@Override
		protected String getFldName(String tagName) {
			if(TAGNAME_APATH.equals(tagName)){
				return FLDNAME_PATH;
			}else if(TAGNAME_ACONTENT.equals(tagName)){
				return FLDNAME_CONTENT;
			}else if(TAGNAME_ACTIONS.equals(tagName)){
				return FLDNAME_ACTIONS;
			}
			return super.getFldName(tagName);
		}
	}
}
