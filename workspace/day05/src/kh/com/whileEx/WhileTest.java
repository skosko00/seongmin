package kh.com.whileEx;

import java.util.Scanner;

public class WhileTest {

	public void test1()
	{
		int i;
		i = 0;
		while(i<10)
		{
			i = i +1;
			
			System.out.println("i = " + i);
		}
	}

	public void test2()
	{
		int i = 0;
		
		while (i<5)
		{
			System.out.println("안녕하세요");
			i++;
		}
	}
	
	public void test3()
	{
		Scanner sc = new Scanner(System.in);
			
		System.out.print("몇번을 출력하시겠습니까?");
		int i = sc.nextInt();
		int x=0;
		while(x<i)
		{
			System.out.println("안녕하세요");
			x++;
		}
	}
	
	public void test4()
	{
		int i = 0;
		while(i<9)
		{
			i++;
			System.out.printf("2 * %d = %d \n", i, 2*i);
		}
	}
	

	public void test5()
	{
		Scanner sc = new Scanner(System.in);
		int x, j=1;
		
		System.out.print("몇단을 출력하시겠습니까?");
		x = sc.nextInt();
		while(j<=9) 
		{
			System.out.printf("%d * %d = %d \n", x, j, x*j);
			j++;
		}
	}
	
	
	public void test6()
	{
		Scanner sc = new Scanner(System.in);
		int x=0, y, sum=0;
		while(x<5)
		{
			x++;
			System.out.print("정수값을 입력하시오 : ");
			y = sc.nextInt();
			sum += y;
		}
		
		System.out.println("입력한 5개의 정수의 합 : "+ sum);
	}
	
}
