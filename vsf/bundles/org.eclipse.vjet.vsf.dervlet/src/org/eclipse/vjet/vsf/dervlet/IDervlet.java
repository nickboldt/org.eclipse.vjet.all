package org.eclipse.vjet.vsf.dervlet;

import javax.servlet.Servlet;

public abstract interface IDervlet extends Servlet
{
  public abstract String getPath();
}

/* Location:           /Applications/appSDK/lib/CoreDervlet-1.7.zip
 * Qualified Name:     com.ebay.coredervlet.IDervlet
 * JD-Core Version:    0.6.2
 */