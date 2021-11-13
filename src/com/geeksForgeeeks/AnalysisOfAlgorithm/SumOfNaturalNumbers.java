package com.geeksForgeeeks.AnalysisOfAlgorithm;

public class SumOfNaturalNumbers {

	
	/*** Analysis Of Algorith O(1) ***/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int n=10;
	int res=func(n);
	System.out.println(res);
	}
	
	
	public static int func(int n)
	{
	return n*(n+1)/2;	
	}

}
