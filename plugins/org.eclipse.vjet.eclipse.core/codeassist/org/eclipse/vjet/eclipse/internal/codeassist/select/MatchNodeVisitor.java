//package org.eclipse.vjet.eclipse.internal.codeassist.select;
//
//
//import org.eclipse.dltk.mod.ast.ASTNode;
//import org.eclipse.dltk.mod.ast.ASTVisitor;
//import org.eclipse.vjet.dsf.jst.JstSource;
//
///**
// * Visits ASTs in order to find node under start and end offsets.
// */
//public class MatchNodeVisitor extends ASTVisitor {
//	private final int end;
//	private final int start;
//	private ASTNode result;
//	private Class<?> clazz;
//
//	/**
//	 * Constructor initialized with offsets to seek for
//	 * 
//	 * @param start
//	 *            offset
//	 * @param end
//	 *            offset
//	 */
//	public MatchNodeVisitor(int start, int end, Class<?> clazz) {
//		this.end = end;
//		this.start = start;
//		this.clazz = clazz;
//	}
//
//	/**
//	 * Retrieve matching node, available after using current object in {@link ASTNode#traverse(ASTVisitor)}
//	 * 
//	 * @return matching {@link ASTNode} or null if not available
//	 */
//	public ASTNode getNode() {
//		return result;
//	}
//
//	protected void setNode(ASTNode node) {
//		result = node;
//	}
//
//	/**
//	 * Browse given {@link ASTNode} tree to found a node matching offset provided in {@link #MatchNodeVisitor(int, int)}
//	 * 
//	 * @see ASTVisitor#visitGeneral(ASTNode)
//	 * @see #MatchNodeVisitor(int, int)
//	 */
//	public boolean visitGeneral(ASTNode s) throws Exception {
//		int realStart = s.sourceStart();
//		int realEnd = s.sourceEnd();
//		
//		int range = this.end - this.start;
//		
//		int curRange = realEnd - realStart;
//		
//	
//		if (range <= curRange) {
//			setNode(s);
////			return true;
//		}
//		return true;
////		if (realStart <= start && realEnd >= end) {
////			if (clazz.isInstance(s)) {
////				if (getNode() == null) {
////					setNode(s);
////				} else if (s.sourceStart() >= getNode().sourceStart() && s.sourceEnd() <= getNode().sourceEnd()) {
////					setNode(s);
////				}
////			}
////			return true;
////		} else {
////			return false;
////		}
//
//	}
//}