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
			System.out.println("�ȳ��ϼ���");
			i++;
		}
	}
	
	public void test3()
	{
		Scanner sc = new Scanner(System.in);
			
		System.out.print("����� ����Ͻðڽ��ϱ�?");
		int i = sc.nextInt();
		int x=0;
		while(x<i)
		{
			System.out.println("�ȳ��ϼ���");
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
		
		System.out.print("����� ����Ͻðڽ��ϱ�?");
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
			System.out.print("�������� �Է��Ͻÿ� : ");
			y = sc.nextInt();
			sum += y;
		}
		
		System.out.println("�Է��� 5���� ������ �� : "+ sum);
	}
	
}
