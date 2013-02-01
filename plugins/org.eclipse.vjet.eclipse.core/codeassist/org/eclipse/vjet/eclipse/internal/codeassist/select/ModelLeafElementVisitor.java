package org.eclipse.vjet.eclipse.internal.codeassist.select;

import org.eclipse.dltk.mod.core.IModelElement;
import org.eclipse.dltk.mod.core.IModelElementVisitor;
import org.eclipse.dltk.mod.core.ISourceRange;
import org.eclipse.dltk.mod.core.ModelException;
import org.eclipse.dltk.mod.internal.core.SourceRefElement;

public class ModelLeafElementVisitor implements IModelElementVisitor {

	final int m_curEndOffset;
	final int m_curStartOffset;
	
	public ModelLeafElementVisitor(int curEndOffset, int curStartOffset) {
		m_curStartOffset = curStartOffset;
		m_curEndOffset = curEndOffset;
		// TOm_curStartOffsetDO Auto-generated constructor stub
	}

	public IModelElement elem;

	@Override
	public boolean visit(IModelElement element) {

		if (element instanceof SourceRefElement) {
			try {
				ISourceRange sourceRange = ((SourceRefElement) element)
						.getSourceRange();
				
				int offset = sourceRange.getOffset();
				if(offset==-1){
					return true;
				}
				int endoffset = sourceRange.getOffset()
						+ sourceRange.getLength();

				// TODO add trace capabilities
//				System.out.println(element.getElementName() + ":" + element.getHandleIdentifier());
//				
//				System.out.println("offset = " + offset + " endoffset:"
//						+ endoffset);

			//	int curRange = m_curEndOffset - m_curStartOffset;
				if (m_curStartOffset == offset) {
					elem = element;
					return false;
				}

			} catch (ModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;
	}

}
