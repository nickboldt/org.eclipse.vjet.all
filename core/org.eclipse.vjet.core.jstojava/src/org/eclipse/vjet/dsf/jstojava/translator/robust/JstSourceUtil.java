/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jstojava.translator.robust;

import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.vjet.dsf.jstojava.translator.IFindTypeSupport;

public class JstSourceUtil implements IFindTypeSupport.ILineInfoProvider {

	
	private int[] lineEndTable;
	private int m_startPosition;
	private int m_length;

	public JstSourceUtil(int[] lineSeperatorPositions, int startPosition, int length){
		lineEndTable = lineSeperatorPositions;
		m_startPosition = startPosition;
		m_length = length;
	}
	
	// private static final char CHAR = '\n';

//	private static final LineInfo NEGONE = new LineInfo(-1, -1, -1);

//	public static class LineInfo implements Comparable<LineInfo> {
//
//		private final int m_line;
//		private final int m_colStart;
//		private final int m_colEnd;
//
//		// private final int m_startOffset;
//
//		public LineInfo(int lineCount, int colStart, int colEnd) {
//			m_line = lineCount;
//			m_colStart = colStart;
//			m_colEnd = colEnd;
//			// System.out.println("line:" + lineCount + " start:" + colStart+
//			// "end: " + colEnd );
//		}
//
//		public int line() {
//			return m_line;
//		}
//
//		public int colStart() {
//			return m_colStart;
//		}
//
//		public int colEnd() {
//			return m_colEnd;
//		}
//
//		@Override
//		public int compareTo(LineInfo o) {
//			int thisVal = this.colStart();
//			int anotherVal = o.colStart();
//			return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
//
//		}
//		
//		@Override
//		public String toString() {
//			return new StringBuilder().append(this.m_colStart).toString();
//		}
//
//	}

//	private char[] m_source;
//	private List<LineInfo> m_lineInfo = new ArrayList<LineInfo>();
//	private boolean m_init = false;
//	private AvlTree m_tree;

//	public JstSourceUtil(char[] source) {
//		m_source = source;
//	}

//	public LineInfo lineInfo(int startOffset) {
//		init();
//		if(m_tree.getRoot()==null){
//			return new LineInfo(0, 0, 0);
//		}
//		return binarySearch(m_lineInfo, startOffset);
//	}

	public int line(int startOffset) {
		return getLineNumber(startOffset);
//		init();
//		LineInfo line = binarySearchNew(m_tree, startOffset);
//		return line.m_line;
		// return binarySearch(m_lineInfo, startOffset).m_line;
	}
	
	
	/**
	 * Returns the line number corresponding to the given source character
	 * position in the original source string. The initial line of the
	 * compilation unit is numbered 1, and each line extends through the
	 * last character of the end-of-line delimiter. The very last line extends
	 * through the end of the source string and has no line delimiter.
	 * For example, the source string <code>class A\n{\n}</code> has 3 lines
	 * corresponding to inclusive character ranges [0,7], [8,9], and [10,10].
	 * Returns -1 for a character position that does not correspond to any
	 * source line, or -2 if no line number information is available for this
	 * compilation unit.
	 *
	 * @param position a 0-based character position, possibly
	 *   negative or out of range
	 * @return the 1-based line number, or <code>-1</code> if the character
	 *    position does not correspond to a source line in the original
	 *    source file or <code>-2</code> if line number information is not known for this
	 *    compilation unit
	 * @see ASTParser
	 * @since 3.2
	 */
	public int getLineNumber(int position) {
		if (this.lineEndTable == null) return -2;
		int length;
		if ((length = this.lineEndTable.length) == 0) {
			if (position >= getStartPosition() + getLength()) {
				return -1;
			}
			return 1;
		}
		int low = 0;
		if (position < 0) {
			// position illegal
			return -1;
		}
		if (position <= this.lineEndTable[low]) {
			// before the first line delimiter
			return 1;
		}
		// assert position > lineEndTable[low+1]  && low == 0
		int hi = length - 1;
		if (position > this.lineEndTable[hi]) {
			// position beyond the last line separator
			if (position >= getStartPosition() + getLength()) {
				// this is beyond the end of the source length
				return -1;
			} else {
				return length + 1;
			}
		}
		// assert lineEndTable[low]  < position <= lineEndTable[hi]
		// && low == 0 && hi == length - 1 && low < hi

		// binary search line end table
		while (true) {
			// invariant lineEndTable[low] < position <= lineEndTable[hi]
			// && 0 <= low < hi <= length - 1
			// reducing measure hi - low
			if (low + 1 == hi) {
				// assert lineEndTable[low] < position <= lineEndTable[low+1]
				// position is on line low+1 (line number is low+2)
				return low + 2;
			}
			// assert hi - low >= 2, so average is truly in between
			int mid = low + (hi - low) / 2;
			// assert 0 <= low < mid < hi <= length - 1
			if (position <= this.lineEndTable[mid]) {
				// assert lineEndTable[low] < position <= lineEndTable[mid]
				// && 0 <= low < mid < hi <= length - 1
				hi = mid;
			} else {
				// position > lineEndTable[mid]
				// assert lineEndTable[mid] < position <= lineEndTable[hi]
				// && 0 <= low < mid < hi <= length - 1
				low = mid;
			}
			// in both cases, invariant reachieved with reduced measure
		}
	}


	private int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getStartPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int col(int beginOffset) {
		// TODO Auto-generated method stub
		return getColumnNumber(beginOffset);
	}
	
	/**
	 * Returns the column number corresponding to the given source character
	 * position in the original source string. Column number are zero-based.
	 * Return <code>-1</code> if it is beyond the valid range or <code>-2</code>
	 * if the column number information is unknown.
	 *
	 * @param position a 0-based character position, possibly
	 *   negative or out of range
	 * @return the 0-based column number, or <code>-1</code> if the character
	 *    position does not correspond to a source line in the original
	 *    source file or <code>-2</code> if column number information is unknown for this
	 *    compilation unit
	 * @see ASTParser
	 * @since 3.2
	 */
	public int getColumnNumber(final int position) {
		if (this.lineEndTable == null) return -2;
		final int line = getLineNumber(position);
		if (line == -1) {
			return -1;
		}
		if (line == 1) {
			if (position >= getStartPosition() + getLength()) return -1;
			return position;
		}
		// length is different from 0
		int length = this.lineEndTable.length;
		// -1 to for one-based to zero-based conversion.
		// -1, again, to get previous line.
		final int previousLineOffset = this.lineEndTable[line - 2];
		 // previousLineOffset + 1 is the first character of the current line
		final int offsetForLine = previousLineOffset + 1;
		final int currentLineEnd = line == length + 1 ? getStartPosition() + getLength() - 1 :	this.lineEndTable[line - 1];
		if (offsetForLine > currentLineEnd) {
			return -1;
		} else {
			return position - offsetForLine;
		}
	}

//	public static LineInfo binarySearch(List<LineInfo> a, int startOffset) {
//		int low = 0;
//		int high = a.size() - 1;
//		int mid;
//		if (startOffset == 0) {
//			return a.get(0);
//		}
//
//		while (low <= high) {
//			mid = (low + high) / 2;
//
//			LineInfo lineInfo = a.get(mid);
//			if (startOffset <= lineInfo.m_colEnd
//					&& startOffset >= lineInfo.m_colStart) {
//				return lineInfo;
//			} else if (inLowerRange(lineInfo, startOffset)) {
//				high = mid - 1;
//			} else if (inHigherRange(lineInfo, startOffset)) {
//				low = mid + 1;
//			} else {
//				return lineInfo;
//			}
//		}

//		return NEGONE; // NOT_FOUND = -1
//	}

//	public static LineInfo binarySearchNew(AvlTree tree, int startOffset) {
//		//tree.printTree();
//		return ((LineInfo) findLine(tree, new LineInfo(0, startOffset, 0)).element);
//	}

//	private static AvlNode findLine(AvlTree tree, Comparable x) {
//		AvlNode t = tree.getRoot();
//		AvlNode preNode = null;
//		while (t != null) {
//			if(preNode==null){
//				AvlNode rootCheck = checkOffset(x, t, null);
//				if(rootCheck!=null){return rootCheck;}
//			}else{
//				AvlNode rootCheck  = checkOffset(x, t, preNode);
//				if(rootCheck!=null){return rootCheck;}
//			}
//			
//			if (x.compareTo(t.element) < 0 && t.left != null) {
//				preNode = t;
//				t = t.left;
//			} else if (x.compareTo(t.element) > 0 && t.right != null ) {
//				preNode = t;
//				t = t.right;
//			} else {
//				t = checkOffset(x, t, preNode);
//				if(t!=null){return t;}
//			}
//		}
//
//		return null; // No match
//
//	}

//	private static AvlNode checkOffset(Comparable x, AvlNode t, AvlNode preNode) {
//		LineInfo tlio = (LineInfo) t.element;
//		LineInfo xlio = (LineInfo) x;
//		LineInfo prlio = null;
//		if(preNode!=null){
//			prlio = (LineInfo) preNode.element;
//		}
//		
//		if (xlio.m_colStart >= tlio.m_colStart
//				&& xlio.m_colStart <= tlio.m_colEnd) {
//			return t;
//		} else if (prlio!=null && xlio.m_colStart >= prlio.m_colStart
//				&& xlio.m_colStart <= prlio.m_colEnd) {
//			return preNode;
//		}else{
//			t=null;
//		}
//		return t;
//	}

//	private static boolean inHigherRange(LineInfo lineInfo, int startOffset) {
//		return startOffset > lineInfo.m_colEnd;
//	}
//
//	private static boolean inLowerRange(LineInfo lineInfo, int startOffset) {
//		return startOffset < lineInfo.m_colStart;
//	}

//	private void init() {
//		if (m_init == true || m_source == null) {
//			return;
//		}
//		String source = new String(m_source);
//
//		int lineCount = 1;
//		int colStart = 0;
//		int colEnd = 0;
//
//		String[] lines = source.split("\n");
//		for (String line : lines) {
//
//			colEnd = colEnd + line.length() + 1;
//
//			m_lineInfo.add(new LineInfo(lineCount, colStart, colEnd));
//
//			colStart = colEnd + 1;
//
//			lineCount++;
//
//		}
//
//		setupBinaryTree();
//
//		m_init = true;
//
//	}

//	private void setupBinaryTree() {
//		// *
//
//		AvlTree tree = new AvlTree();
//
//		for (int i = 0; i < m_lineInfo.size(); i++) {
//			LineInfo linfo = m_lineInfo.get(i);
//			tree.insert(linfo);
//		}
//
//		m_tree = tree;
//		// printFrontToBack(tree.root, m_lineInfo.get(mid).m_colStart);
//	}
//
//	public int col(int startOffset) {
//		init();
//		// LineInfo lineInfo = binarySearch(m_lineInfo, startOffset);
//		LineInfo lineInfo = binarySearchNew(m_tree, startOffset);
//		return startOffset - lineInfo.m_colStart;
//	}
//
//	public static void main(String[] args) {
//		String x = "abcd\nxyz\nddddddd\ndddddd\ndd\ndddd\ndddddd\nddddddd\ndddddd\n";
//
//		JstSourceUtil y = new JstSourceUtil(x.toCharArray());
//		for (int i = 0; i < x.length(); i++) {
//			System.out.println("i=" + i + ": " + y.line(i) + "," + y.col(i));
//		}
//		/*
//		 * System.out.println(y.line(3) +","+ y.col(3));
//		 * System.out.println(y.line(4)+","+ y.col(4));
//		 * System.out.println(y.line(5)+","+ y.col(5));
//		 * System.out.println(y.line(20)+","+ y.col(20));
//		 * System.out.println(y.line(50)+","+ y.col(50));
//		 */
//
//	}

}
