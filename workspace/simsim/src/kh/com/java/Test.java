package kh.com.java;

import java.util.Scanner;

public class Test {

	public void test1()
	{
		int i=1;
		while(i<=30)
		{
			i++;
			if(i%4==0)
			{
				System.out.print(i + " ");
			}
		}
	}
	
	public void test2()
	{
		Scanner sc = new Scanner(System.in);
		int su;
		do
		{
			System.out.print("number? ");
			su = sc.nextInt();
			if(0<su)
			{
				System.out.println("positive interger");
			}
			else if(su<0)
			{
				System.out.println("negative number");
			}
		}while(su!=0);
		System.out.println("End");
	}

	public void test3()
	{
		int sum=0, value=0;
		for(int i = 1; i<=5; i++)
		{
			value = sum;
			sum = value + i;
		}
		System.out.println(sum);
	}

}
