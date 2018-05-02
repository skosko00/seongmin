package com.kh.java;

import java.util.Scanner;

public class MethodTest {
	public void start1()	//문제1
	{
		int a = 10;
		int b = 3;
		
		System.out.println(addFunction(a, b));
		System.out.println(subFunction(a, b));
		System.out.println(mulFunction(a, b));
		System.out.println(divFunction(a, b));
	}
	
	public void start2()	//문제2
	{
		Scanner sc = new Scanner(System.in);
		char ch;
		System.out.print("영문자 입력 : ");
		ch = sc.next().charAt(0);
		System.out.println("===== 변 환 =====");
		System.out.print(ch + " --> ");
		ch = charChange(ch);
		System.out.println(ch);
	}
	
	public void start3()	//문제3
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 :");
		int num = sc.nextInt();
		while(true)
		{
		if(!(0<num && num<=100))
		{
			System.out.println("값을 잘못 입력하였습니다.");
		}
		break;
		}
		int [][] arr = new int [num][num];
		for(int i=0;i<arr.length;i++)
		{
			for(int k=0; k<arr[i].length;k++)
			{
				arr[i][k] = (i+1)*(k+1);
			}
		}
		square(arr);
	}

	public int addFunction(int num1, int num2)
	{
		return num1+num2;
	}
	
	public int subFunction(int num1, int num2)
	{
		return num1-num2;
	}
	
	public int mulFunction(int num1, int num2)
	{
		return num1*num2;
	}
	
	public double divFunction(int num1, int num2)
	{
		return (double)num1/num2;
	}
	
	public char charChange(char c)		//문제 2 변환문
	{
		if('a'<=c && c<='z' || 'A'<=c && c<='Z')
		{
			c = (char)(c^32);
		}
		return c;
	}
	
	public void square(int a[][])	//문제3 출력문
	{
		for(int i=0; i<a.length;i++)
		{
			for(int j=0; j<a[i].length;j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
