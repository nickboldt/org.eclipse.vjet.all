package org.eclipse.vjet.dsf.jst;

import java.io.Serializable;

import org.eclipse.vjet.dsf.common.Z;

public class JstCommentLocation implements Serializable {

	private static final long serialVersionUID = 1L;
	private final int m_startOffset;
	private final int m_endOffset;
	private final boolean m_vjetdoc;
	
	public JstCommentLocation(int startOffset, int endOffset) {
		this(startOffset,endOffset,false);
	}
	
	public JstCommentLocation(int startOffset, int endOffset, boolean vjetdoc) {
		m_startOffset = startOffset;
		m_endOffset = endOffset;
		m_vjetdoc = vjetdoc;
	}
	
	public int getStartOffset(){
		return m_startOffset;
	}
	
	public int getEndOffset(){
		return m_endOffset;
	}
	
	public boolean isVjetDoc(){
		return m_vjetdoc;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Z.fmt("startoffset", getStartOffset()));
		sb.append(Z.fmt("endoffset", getEndOffset()));
		sb.append(Z.fmt("isvjetdoc", isVjetDoc()));
		return sb.toString();
	}

}
