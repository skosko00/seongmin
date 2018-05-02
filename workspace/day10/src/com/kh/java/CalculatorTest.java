package com.kh.java;

public class CalculatorTest {
	
	public void start()
	{
		int a = 10;
		int b = 3;
		System.out.println(addFunction(a,b));
		System.out.println(subFunction(a,b));
		System.out.println(mulFunction(a,b));
		System.out.println(divFunction(a,b));
	}
	
	public int addFunction(int su1, int su2)
	{
		return su1+su2;
	}
	
	public int subFunction(int su1, int su2)
	{
		return su1-su2; 
	}
	
	public int mulFunction(int su1, int su2)
	{
		return su1*su2;
	}
	
	public double divFunction(int su1, int su2)
	{
		return (double)su1/su2;
	}
}
