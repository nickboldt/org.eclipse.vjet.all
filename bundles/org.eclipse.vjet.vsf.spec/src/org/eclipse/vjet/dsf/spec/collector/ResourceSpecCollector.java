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
package org.eclipse.vjet.dsf.spec.collector;

  import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.vjet.dsf.spec.resource.IResourceSpec;
import org.eclipse.vjet.dsf.spec.resource.IResourceSpecs;
  
  /**
   * Use for aggregating all the IResourceSpec based on their dependencies.
   * It is also an IResourceSpecs itslef.
   */
  public class ResourceSpecCollector implements IResourceSpecs<IResourceSpec> {
      private final Set<IResourceSpec> m_componentSpecs=
          new LinkedHashSet<IResourceSpec>();
      
      private final Set<IResourceSpec> m_dupSpecExclusionSet=
          new LinkedHashSet<IResourceSpec>();
      
      private final ResourceSpecVisitor m_visitor = new ResourceSpecVisitor(){
          public void visit(IResourceSpec resourceSpec) {
              m_componentSpecs.add(resourceSpec);
          }
      };
      
      public Iterator<IResourceSpec> iterator() {
          return m_componentSpecs.iterator();
      }
      
      public int size() {
          return m_componentSpecs.size();
      }
      
      public void aggregate(final IResourceSpec resourceSpec) {
          depthFirstTraversal(resourceSpec, m_visitor);
      }
      
      public void aggregate(final IResourceSpecs<? extends IResourceSpec> resourceSpecs) {
          depthFirstTraversal(resourceSpecs, m_visitor);
      }
      
      public static interface ResourceSpecVisitor {
          void visit(IResourceSpec resourceSpec);
      }
      
      public void depthFirstTraversal(
          final IResourceSpec resourceSpec,
          final ResourceSpecVisitor visitor)
      {
          if (m_dupSpecExclusionSet.contains(resourceSpec)) {
              return ;
          }
          m_dupSpecExclusionSet.add(resourceSpec);
          
          depthFirstTraversal(resourceSpec.getDependentSpecs(),visitor);
          visitor.visit(resourceSpec);
      }
      
      public void depthFirstTraversal(
          final IResourceSpecs<? extends IResourceSpec> resourceSpecs,
          final ResourceSpecVisitor visitor)
      {   
          for (IResourceSpec child: resourceSpecs){
              depthFirstTraversal(child, visitor);
          }
      }
  }