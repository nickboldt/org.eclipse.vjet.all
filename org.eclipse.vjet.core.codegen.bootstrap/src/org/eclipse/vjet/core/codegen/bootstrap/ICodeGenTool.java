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
  
  import java.util.List;
  
 
  /**
   * 
   * This interface is used by code generation tools. Other tools, like the Darwin
   * eclipse plugin will use this to call the various code generators.
   * 
   */
  public interface ICodeGenTool extends IValidationTool {
  
      /**
       * Generate an entity based the given entity into the given stream
       * 
       * @param inputEntity
       *            The input for codegeneration
       * @param outputCollection
       *            Collection of CodeGenOutputEnity's. Each CodeGenOutputEnity
       *            will now have a valid output stream writer associated with it
       *            for the code generator.
       * @return A collection of statuses. If the generation is successful the
       *         generation will return one CodeGenStatus in the collection with
       *         the status of StatusCode.Success.
       */
      List<CodeGenStatus> generate(CodeGenInputEntity inputEntity,
              List<CodeGenOutputEntity> outputCollection);
  
      /**
       * This method is called to determine what the output entities are. For
       * example, An input of a JavaScript file could yield multiple java source
       * files.
       * 
       * @param inputEntity
       *            Input Entity. Contains information needed for code generation
       * @return Returns a collection of CogenEntities.
       */
      List<CodeGenOutputEntity> getOutputEntities(CodeGenInputEntity inputEntity);
  }
