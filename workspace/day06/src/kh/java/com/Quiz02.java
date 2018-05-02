package kh.java.com;

import java.util.Scanner;

public class Quiz02 {

	public  void test1() {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int x, y = 0, sum = 0;
		System.out.print("1부터 더할 숫자까지의 범위를 말하세요");
		x = sc.nextInt();
		while(y<x) {
			y++;
			sum += y;
		}
		System.out.printf("1부터 %d 까지의 합은 %d 입니다.",x,sum);
	}

	public void test2()

	{
		Scanner sc = new Scanner(System.in);
		int n, y=0, sum = 0;

		System.out.print("n의 수를 입력 ");
		n = sc.nextInt();
		while(y<=n)
		{

			if(y%2==0)
			{
				sum += y;
			}
			y++;			
		}
		System.out.printf("짝수들만의 합은 : %d",sum);
	}

	public void test3()
	{
		Scanner sc = new Scanner(System.in);
		int num1, num2, sum=0;
		System.out.print("첫번째 수 입력 : ");
		num1 = sc.nextInt();
		System.out.print("두번째 수 입력 : ");
		num2 = sc.nextInt();
		System.out.printf("%d ~ %d 까지의 합 : ",num1,num2);

		while(num1<num2)
		{
			sum += num1;
			num1++;
		}

		while(num1>=num2)
		{
			sum += num2;
			num2++;

		}
		System.out.print(sum);
	}

	public void test4()

	{
		Scanner sc = new Scanner(System.in);
		int num1, num2, sum = 0, count = 0;
		double avg=0;

		System.out.print("첫번째 정수를 입력하세요 : ");
		num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력하세요 : ");
		num2 = sc.nextInt();

		if(num1<=num2) {
			while(num1<=num2)
			{
				if(num1%3==0 || num1%5==0)
				{
					sum += num1;
					count++;
					avg = (double)sum / count;
					num1++;
				}
				else
				{
					num1++;
				}

			}
		}
		else {
			while(num2<=num1)
			{
				if(num2%3==0 || num2%5==0)
				{
					sum += num2;
					count++;
					avg = (double)sum / count;
					num2++;
				}
				else
				{
					num2++;
				}
			}
		}


		System.out.printf("평균  : %.1f 합 : %d", avg, sum);
	}

	public void test5()
	{
		Scanner sc = new Scanner(System.in);
		int su;
		System.out.println("정수 입력 : ");
		su = sc.nextInt();
		do
		{
			System.out.println(su%10);
			su/=10;
		}while(su>0);
	}

	public void test6()
	{
		for (int i=1; i<=10; i++)
		{
			System.out.println("i = " + i);
		}
	}

	public void test7()
	{
		for (int i=1; i<=5; i++)
		{
			System.out.println("안녕하세요");
		}
	}
	
	public void test8()
	{
		Scanner sc = new Scanner(System.in); 
		System.out.print("몇번을 출력하시겠습니까?");
		int su = sc.nextInt();
		for(int i=1; i<=su; i++)
		{
			System.out.println("안녕하세요");
		}
	}

	public void test9()
	{
		for(int i=1; i<=9;i++)
		{
			System.out.println("2 * " +i+ " =" + (2*i));
		}
	}
	
	public void test10()
	{
		int num1;
		Scanner sc = new Scanner(System.in);
		System.out.print("구구단 단수를 입력하세요 : ");
		num1 = sc.nextInt();
		for(int i=1; i<=9; i++) {
			System.out.printf("%d * %d = %d \n", num1, i ,num1*i);	
		}
	}
}