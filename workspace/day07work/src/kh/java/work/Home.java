package kh.java.work;

import java.util.Random;
import java.util.Scanner;

public class Home {
	public void test1()
	{
		for (int i=2; i<=9;i++) 
		{
			for(int j=1; j<=9;j++)
			{
				System.out.printf("%d*%d= %d\t",i,j,i*j);
			}
			System.out.println();
		}
	}

	public void test2()
	{
		for (int i=1; i<=9;i++)
		{
			for(int j=2; j<=9;j++)
			{
				System.out.printf("%d*%d=%d\t",j,i,j*i);
			}
			System.out.println();
		}
	}

	public void quiz1()
	{
		for(int i=0; i<5; i++)
		{
			System.out.print("*");
		}
	}

	public void quiz2()
	{
		for(int i=0; i<5; i++)
		{
			System.out.println("*");
		}
	}

	public void quiz3()
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void quiz4()
	{
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=5;j++)
			{
				System.out.print(i);
			}
			System.out.println();
		}
	}

	public void quiz5()
	{
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=5;j++)
			{
				System.out.print(j);
			}
			System.out.println();
		}
	}

	public void quiz6()
	{
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=5; j++)
			{
				System.out.print(j+i);
			}			
			System.out.println();
		}
	}

	public void quiz7()

	{
		for(int i=5; i>0; i--)
		{
			for(int j=0; j<5; j++)
			{
				System.out.print(i+j);
			}
			System.out.println();
		}
	}

	public void quiz8()
	{
		for(int i=0; i<5; i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void quiz9()
	{
		for(int i=0; i<5; i++)
		{	
			for(int j=i;j<5;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void quiz10()
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<i;j++)
			{
				System.out.print(" ");
			}
			for(int z=i;z<5;z++) 
			{
				System.out.print("*");
			}
			System.out.println();
		}		
	}

	public void quiz11()
	{
		for(int i=0;i<5;i++)
		{
			for(int j=i;j<4;j++)
			{
				System.out.print(" ");
			}
			for(int z=0;z<=i;z++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void quiz12()
	{
		for(int i=0;i<4;i++)
		{
			System.out.println();
			for(int j=0;j<=i;j++)
			{
				System.out.print("*");
			}
		}
		for(int i=0;i<5;i++)
		{
			System.out.println();
			for(int z=i;z<5;z++)
			{
				System.out.print("*");
			}
		}
	}

	public void quiz13()
	{
		for(int i=0;i<4;i++)
		{
			for(int j=i;j<5;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void test3()
	{
		int sum=0;

		for(int i=1; i<=10;i++)
		{
			for(int j=1; j<=i; j++)
			{
				sum+=j;
			}
		}
		System.out.println(sum);
	}

	public void test4()
	{
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.print("n입력 : ");
		n = sc.nextInt();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void test5()
	{
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.print("n을 입력 : ");
		n = sc.nextInt();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void test6()
	{
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		char oper;
		System.out.println("=== 계산기 프로그램 ====");
		System.out.println();
		while(true)
		{
		System.out.print("(+, -, *, / (q:종료)) :");
		oper = sc.next().charAt(0);
		if(oper=='q' || oper=='Q')
		{
			System.out.println("종료합니다.");
			break;
		}
		if(oper!='+' && oper!='-' && oper!='*' && oper!='/' )
		{
		System.out.println("연산자를 잘못 입력하셨습니다.");
		continue;
		}

		System.out.print("첫번째 숫자 입력 : ");
		num1 = sc.nextInt();
		System.out.print("두번째 숫자 입력 : ");
		num2 = sc.nextInt();		
		System.out.println();
		System.out.println("======= 결 과 ========");
		switch(oper)
		{
		case '+':
			System.out.printf("%d + %d = %d",num1,num2,num1+num2);
			break;
		case '-':
			System.out.printf("%d - %d = %d",num1,num2,num1-num2);
			break;
		case '*':
			System.out.printf("%d * %d = %d",num1,num2,num1*num2);
			break;
		case '/':
			System.out.printf("%d / %d = %.1f",num1,num2,(double)num1/num2);
			break;
		}
		}
	}
	
	public void test7()
	{
		Random r = new Random();
		System.out.print("0~9까지의 랜덤수 : ");
		System.out.println(r.nextInt(10));
		System.out.print("1~10까지의 랜덤수 : ");
		System.out.println(r.nextInt(10)+1);
		System.out.print("20~35까지의 랜덤수 : ");
		System.out.println(r.nextInt(16)+20);
		System.out.print("0 또는 1 : ");
		System.out.println(r.nextInt(2));
	}
	
	public void test8()
	{
		Random r = new Random();
		System.out.print("0~45까지의 랜덤수 : ");
		System.out.println(r.nextInt(46));
		System.out.print("1~55까지의 랜덤수 : ");
		System.out.println(r.nextInt(55)+1);
		System.out.print("23~45까지의 랜덤수 : ");
		System.out.println(r.nextInt(23)+23);
		System.out.print("55~80까지의 랜덤수 : ");
		System.out.println(r.nextInt(26)+55);
		System.out.print("17~50까지의 랜덤수 : ");
		System.out.println(r.nextInt(34)+17);
		System.out.print("34~40까지의 랜덤수 : ");
		System.out.println(r.nextInt(7)+34);
		System.out.print("80~120까지의 랜덤수 : ");
		System.out.println(r.nextInt(41)+80);
	}
}
