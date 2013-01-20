/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.vjet.eclipse.internal.ui.preferences.formatting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.internal.ui.IJavaStatusConstants;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.vjet.eclipse.core.VjetPlugin;
import org.eclipse.vjet.eclipse.formatter.CodeFormatterUtil;
import org.eclipse.vjet.eclipse.ui.VjetUIPlugin;




public class SnippetPreview extends JavaPreview {
  
    public final static class PreviewSnippet {
        
        public String header;
        public final String source;
        public final int kind;
        
        public PreviewSnippet(int kind, String source) {
            this.kind= kind;
            this.source= source;
        }
    }
    
    private ArrayList fSnippets;

    public SnippetPreview(Map workingValues, Composite parent) {
        super(workingValues, parent);
        fSnippets= new ArrayList();
    }

    protected void doFormatPreview() {
        if (fSnippets.isEmpty()) { 
            fPreviewDocument.set(""); //$NON-NLS-1$
            return;
        }
        
        //This delimiter looks best for invisible characters
        final String delimiter= "\n"; //$NON-NLS-1$
        
        final StringBuffer buffer= new StringBuffer();
        for (final Iterator iter= fSnippets.iterator(); iter.hasNext();) {
            final PreviewSnippet snippet= (PreviewSnippet) iter.next();
            String formattedSource;
            try {
                formattedSource= CodeFormatterUtil.format(snippet.kind, snippet.source, 0, null, delimiter, fWorkingValues);
            } catch (Exception e) {
                final IStatus status= new Status(IStatus.ERROR, VjetUIPlugin.PLUGIN_ID, IJavaStatusConstants.INTERNAL_ERROR, 
                    FormatterMessages.JavaPreview_formatter_exception, e); 
                VjetUIPlugin.log(status);
                continue;
            }
            buffer.append(delimiter);            
            buffer.append(formattedSource);
            buffer.append(delimiter);            
            buffer.append(delimiter);
        }
        fPreviewDocument.set(buffer.toString());
    }
    
    
    
    public void add(PreviewSnippet snippet) {
        fSnippets.add(snippet);
    }
    
    public void remove(PreviewSnippet snippet) {
        fSnippets.remove(snippet);
    }
    
    public void addAll(Collection snippets) {
        fSnippets.addAll(snippets);
    }
    
    public void clear() {
        fSnippets.clear();
    }

}
