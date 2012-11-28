package com.ebay.darwin.codegen.java2js.data;

public class Array {
	
	private long m_avg = 5;
	private long[] m_la = {1+m_avg,2,3};
	private int[][] m_twoDimArray = {{1,2,3}, {4,5,6}};
	
	static private String[] s_sa = {"a","b","c"};
	
	public void initializer(){
		long avg = 10;
		long[] la = {1+avg,2,3};
		int[][] twoDimArray = {{1,2,3}, {4,5,6}};
		
		String prefix = "Pre";
		String[] sa = {prefix + "a", prefix + "b", prefix + "c"};
	}
	
	public void creation(){
		int avg = 3;
		long[] la = new long[avg + 3];
		
		String[] sa = new String[avg + 3];
		
		long[][][] la3 = new long[avg][][];
		
		for (int i=0; i<avg; i++){
			la3[i] = new long[i+2][];
			for (int j=0; j<i+2; j++){
				la3[i][j] = new long[j+2];
				for (int k=0; k<j+2; k++){
					la3[i][j][k] = k;
				}
			}
		}
	}
	
	public void access(){
		int avg=2;
		String[][] sa2 = new String[avg][];
		
		for (int i=0; i<avg; i++){
			sa2[i] = new String[i+2];
			String line = "Row " + String.valueOf(i) + ": ";
			for (int j=0; j<i+2; j++){
				sa2[i][j] = String.valueOf(j);
				line += sa2[i][j] + ", ";
			}
		}
	}
}
