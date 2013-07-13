  package org.eclipse.vjet.vsf.tests.jsruntime.common;
  
  import static org.junit.Assert.fail;

import org.eclipse.vjet.dsf.jsgen.shared.classref.IClassR;
import org.junit.Test;

  
  /**
   * @convertedTo Junit4.4 using Junit Convertion Plugin
   */
  public class ClassRefTest {
      
      @Test

      public void testSimple() throws Exception {
          exists(  IClassR  .BaseComponentSpec);
          exists(  IClassR  .CodeGen);
          exists(  IClassR  .CodeGenerated);
          exists(  IClassR  .DA);
          exists(  IClassR  .DImg);
          exists(  IClassR  .EventType);
          exists(  IClassR  .IComponentSpec);
          exists(  IClassR  .IJsConstructor);
          exists(  IClassR  .IJsObjectRef);
          exists(  IClassR  .IJsParamGenerator);
          exists(  IClassR  .IJsResourceRef);
          exists(  IClassR  .ISimpleJsEventHandler);
          exists(  IClassR  .JSDocument);
          exists(  IClassR  .JsEventHandlerAdapter);
          exists(  IClassR  .JsResource);
          exists(  IClassR  .JsRuntimeCtx);
          exists(  IClassR  .StringBuilder);
          exists(  IClassR  .JsObj);
          exists(  IClassR  .JsCmpMeta);
          exists(  IClassR  .JsType);
          exists(  IClassR  .BV);
          exists(  IClassR  .IValueBinding);
          exists(  IClassR  .JsFunc);
          exists(  IClassR  .JsProp);
          exists(  IClassR  .JsPropSetter);
//          exists(  IClassR  .HandlerHelper);
//          exists(  IClassR  .HandlerType);
//          exists(  IClassR  .VjBootstrapJsRef);
//          exists(  IClassR  .EventDispatcherJsr);
//          exists(  IClassR  .ServiceEngineJsr);
          
      }
  
      private void exists(String cr) {
          try {
              Class.forName(cr);
          } catch (ClassNotFoundException e) {
              fail(cr +"\nClass doesn't exist - code gen bootstrap may be broken");
          }
          
      }
      
      
  }