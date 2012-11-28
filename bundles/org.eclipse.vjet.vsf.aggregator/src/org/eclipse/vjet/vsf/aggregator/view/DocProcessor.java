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
package org.eclipse.vjet.vsf.aggregator.view;

import java.util.Map;
import java.util.Set;

import org.eclipse.vjet.dsf.common.context.DsfCtx;
import org.eclipse.vjet.dsf.common.context.IdGenerator;
import org.eclipse.vjet.dsf.common.trace.DataModelCtx;
import org.eclipse.vjet.dsf.common.trace.TraceCtx;
import org.eclipse.vjet.dsf.common.utils.DataModelHelper;
import org.eclipse.vjet.dsf.dom.DDocument;
import org.eclipse.vjet.dsf.dom.DElement;
import org.eclipse.vjet.dsf.dom.DNode;
import org.eclipse.vjet.dsf.html.ctx.HtmlCtx;
import org.eclipse.vjet.dsf.html.dom.DDiv;
import org.eclipse.vjet.dsf.html.dom.DForm;
import org.eclipse.vjet.dsf.html.dom.DH3;
import org.eclipse.vjet.dsf.html.dom.DHead;
import org.eclipse.vjet.dsf.html.dom.DHtmlDocument;
import org.eclipse.vjet.dsf.html.dom.DMeta;
import org.eclipse.vjet.dsf.html.dom.DScript;
import org.eclipse.vjet.dsf.html.dom.DSpan;
import org.eclipse.vjet.dsf.html.dom.DTable;
import org.eclipse.vjet.dsf.html.dom.DTd;
import org.eclipse.vjet.dsf.html.dom.DTextArea;
import org.eclipse.vjet.dsf.html.dom.DTr;
import org.eclipse.vjet.dsf.resource.slot.JsResourceSlotter;
import org.eclipse.vjet.dsf.resource.trace.ContentUsageTracer;
import org.eclipse.vjet.dsf.resource.trace.HtmlResourceUsageTracer;
import org.eclipse.vjet.dsf.resource.trace.IResourceUsageTracer;
import org.eclipse.vjet.dsf.resource.trace.ResourceUsageCtx;
import org.eclipse.vjet.dsf.spec.app.IDocAnnotationData;
import org.eclipse.vjet.vsf.FirePageLoadJsr;
import org.eclipse.vjet.vsf.aggregator.js.JsProcessor;
import org.eclipse.vjet.vsf.aggregator.js.JsProcessorUtils;
import org.eclipse.vjet.vsf.aggregator.js.error.DefaultErrorHandler;
import org.eclipse.vjet.vsf.docprocessing.BaseDocProcessor;
import org.eclipse.vjet.vsf.docprocessing.IJsProcessor;
import org.eclipse.vjet.vsf.docprocessing.IProductionPlan;
import org.eclipse.vjet.vsf.jsref.ctx.ResourceCtx;
import org.eclipse.vjet.vsf.jsruntime.context.JsRuntimeCtx;
import org.eclipse.vjet.vsf.resource.js.trace.SimpleResourceUsageTracer;
import org.eclipse.vjet.vsf.resource.pattern.js.IJsResourceDispenser;
import org.eclipse.vjet.vsf.resource.pattern.js.JsResource;
import org.w3c.dom.Node;



/**
 * Simple document processor according to a production plan.
 * It annotates the doc based on the DocAnnotationData,
 * aggregates and injects the JS and CSS resources into the doc.
 */
public class DocProcessor extends BaseDocProcessor {
	public DocProcessor(final IProductionPlan plan) {
		super(plan) ;
		
		if (m_plan.getJsSlotter() == null) {
			m_plan.setJsSlotter(JsProcessor.createDefaultSlotter());
		}
		final JsResourceSlotter jsSlotter = m_plan.getJsSlotter();		
		if (JsRuntimeCtx.ctx().addErrorHandling()) {
			//register the default handler
			JsRuntimeCtx.ctx().addErrorHandler(new DefaultErrorHandler(), 0);
			
			//add the JS error handling code
			JsProcessorUtils.addJsErrorHandling(jsSlotter);
			
			//enable window.onerror
			JsProcessorUtils.enableWindowOnError(jsSlotter, JsRuntimeCtx.ctx()
					.hideJsErrors(), JsRuntimeCtx.ctx()
					.isCaptureJsErrorStackTrace());
		}
		
		int size = HtmlCtx.ctx().getEventHandlerContainer().size();
		if (size>0) {
			//We should make sure there's only one instance of this
			//JsProcessorUtils.addPageLoadTrigger(jsSlotter);
			ResourceCtx.ctx().register(FirePageLoadJsr.ResourceSpec.getInstance());
		}

	}
	
	@Override
	protected IJsProcessor createJsProcessor() {
		return new JsProcessor(
			m_plan.getJsSlotter(),
			m_plan.getJsApplier(),
			m_plan.getJsSystemLibCache(),
			m_plan.isProcessEventsAndServices());
	}
	
	
	public void process(final DHtmlDocument doc) {
		super.process(doc) ;
		
		//TODO: Testing code which will be removed to proper handler later
		final IResourceUsageTracer usageTracer 
			= ResourceUsageCtx.ctx().getTracer();
		if (usageTracer instanceof SimpleResourceUsageTracer) {
//			printUsageInfo((SimpleResourceUsageTracer)usageTracer);
			addUsageInfoToHtml(doc,(SimpleResourceUsageTracer)usageTracer);
		}	
		
		if (TraceCtx.ctx().haveInstrumenter()) {
			addDataModelToDOM(doc);
		}

	}
	
	protected static void addUsageInfoToHtml(
		final DHtmlDocument doc, final SimpleResourceUsageTracer tracer)
	{
		Node finalNode = doc.getBody().getLastChild().getParentNode();
		DH3 h3 = new DH3("Resources Used by Page");
		finalNode.appendChild(h3);
		DDiv lastNode = new DDiv("tabber");
		finalNode.appendChild(lastNode);
		
		
		if (tracer.getJsList().size() > 0) {
			DDiv js = createResourceTab("Javascript");
			lastNode.add(js);
			generateJsUsed(tracer, js);
		}
		
	}

	/*
	 * This method ensures that the final JSON String is constructed with the trace info for the spyGlass=html
	 */
	protected static void addHtmlUsageInfoToDOM(
			final DHtmlDocument doc, final HtmlResourceUsageTracer tracer)
	{
			Node finalNode = doc.getBody().getLastChild().getParentNode();
			
			if( tracer.getHtmlTraceMap().size() > 0)
			{
				String[] localList = new String[tracer.getHtmlTraceMap().size()];
				for(Object key : tracer.getHtmlTraceMap().keySet() ){
					localList[((Integer)tracer.getHtmlTraceMap().get(key)).intValue()] = (String)key;
				}
				StringBuffer sbuf = new StringBuffer("var spyglassTracebackTbl = [ ");
				
				for( String trace: localList)
				{
					sbuf.append("\"").append(trace).append("\",\n");
				}
				sbuf.append("\"\" ]");
				DScript jsonDs = new DScript();
				jsonDs.add(sbuf.toString());
				finalNode.appendChild(jsonDs);
			}
	}

	/*
	 * add a hidden data model <span> mode
	 * there is a list of <form> in span, each form is representing a data model
	 * 
	 * <span styple="display:none" > 
	 *    <form id="v4-idnumber" target="_blank" action="http://localhost:9090/v4plugin/getxml" method=post>
	 *       <textarea name=datamodelxmlstr>thedatamodelstr</textarea>
	 *    </form>    
	 * </span>
	 */
	protected static void addDataModelToDOM(final DHtmlDocument doc)
	{
		Node finalNode = doc.getBody().getLastChild().getParentNode();
		DSpan span = new DSpan();
		finalNode.appendChild(span);
		span.setHtmlStyleAsString("display:none");
		span.setHtmlId("spydatamodelspan");
		
		DataModelCtx ctx = DataModelCtx.getCtx();
		Map<DNode,Object>  map = ctx.getComponentModelMap();		
		for ( DNode node: map.keySet()) {
			if ( !(node instanceof DElement) ) {
				continue;
			}
			Object model = map.get(node);
			if (model!=null) {
				DataModelHelper helper = DataModelHelper.getInstance();
				String xmlDataModel = helper.getDataModelAsXml(node,true); //based64 encoded
				
				if (xmlDataModel!=null) {
					DsfCtx dsfCtx = DsfCtx.ctx();
					IdGenerator idGenerator = dsfCtx.ids();
					String id = idGenerator.nextHtmlId();
					((DElement)node).setAttribute(DataModelCtx.SpyDataModelId, id); //link to hidden data model form
			
					DForm form = new DForm();
					span.add(form);
					form.setHtmlId(id); //used by VjSpyglassComponentViewer.js
					form.setAttribute("target", "_blank");
					form.setAttribute("method", "POST");
					form.setAttribute("action", "http://localhost:9090/v4plugin/getxml");
					
					DTextArea ta = new DTextArea();
					form.add(ta);
					ta.setHtmlName("datamodelxmlstr");  //used by EmbeddedPluginSevlet & VjSpyglassComponentViewer.js
					ta.setTextContent(xmlDataModel);
				}
			}

		}
	}
	
	protected void addContentUsageInfoToDOM(
		final DHtmlDocument doc, final ContentUsageTracer tracer)
	{
		Node finalNode = doc.getBody().getLastChild().getParentNode();
		
		if( tracer.getContentTraceMap().size() <= 0) return ;

		// create an empty JSON traceback table place holder in the DOM tree. 
		//	This is the last child node of body.
		//	This DScript will be populated during rendering at startElement
		DScript jsonDs = new DScript();
		jsonDs.setAttribute("id", "SpyglassTracebackTbl");
		finalNode.appendChild(jsonDs);
	}
	


	

	private static void generateJsUsed(
		final SimpleResourceUsageTracer tracer, final DDiv outer)
	{
		DTable table = new DTable();
		table.setHtmlBorder("1");
		outer.add(table);
		for (JsResource resource: tracer.getJsList()) {
			if (resource.getUrn().indexOf("VjSpyglass") > 0) {
				continue;
			}
			DTr rows = new DTr();
			table.add(rows);
			DTd td1s = new DTd();
			rows.add(td1s);
			td1s.add(resource.getUrn());
			Set<Class<? extends IJsResourceDispenser>> dispensers = tracer.getDispensers(resource);
			if (dispensers != null) {
				DTd td2s = new DTd();
				rows.add(td2s);
				for (Class<?> clz : dispensers) {
					td2s.add(clz.getName());
					td2s.addBr() ;
				}
			}
		}
	}
	

	private static DDiv createResourceTab(final String title) {
		DDiv tabDiv = new DDiv("tabbertab");
		tabDiv.setHtmlTitle(title);
		DTable table = new DTable();
		table.setHtmlStyleAsString("border: solid 1px black");
		tabDiv.add(table);
		
		return tabDiv;
	}

	protected void processDocAnnotation(final DDocument ddoc) {
		final IDocAnnotationData annotation = m_plan.getDocAnnotation();
		
		DHtmlDocument doc = (DHtmlDocument)ddoc ;
		
		if (annotation == null){
			return;
		}
		
		if (doc.getDoctype() == null) {
			doc.setDocType(annotation.getDocType());
		}
		
		if (annotation.getContentType() == null
			|| annotation.getContentType().length() <= 0) {
			return;
		}

		final DHead head = doc.getHead();
		final DMeta content = new DMeta();
		final String charset = annotation.getCharset() == null
			? "ISO-8859-1" : annotation.getCharset();

		content.setHtmlHttpEquiv("Content-Type");
		content.setHtmlContent(annotation.getContentType() + "; charset=" + charset);

		head.insertBefore(content, head.getFirstChild());
	}


}