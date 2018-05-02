package kh.java.com;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Test {
	public void test1() {

		for (int i=2; i<10;i++) {
			for(int j=1;j<10;j++)
			{
				System.out.printf("%d * %d = %d \n",i,j,i*j);
			}
			System.out.println();
		}
	}

	public void test2() {

		for (int i=5; i<10;i++) {
			for(int j=1;j<10;j++)
			{
				System.out.printf("%d * %d = %d \n",i,j,i*j);
			}
			System.out.println();
		}
	}

	public void test3()
	{
		for (int i=2; i<10; i++)
		{
			for(int j=1; j<10; j++)
			{
				System.out.printf("%d*%d = %d ",i,j,i*j);
			}
			System.out.println();
		}
	}

	public void test4()
	{
		for(int i=1; i<10; i++)
		{
			for(int j=2; j<10; j++)
			{
				System.out.printf("%d*%d= %d\t",j,i,i*j);
			}
			System.out.println();
		}
	}

	public void test5()
	{
		Scanner sc= new Scanner(System.in);
		ArrayList<String> inputs = new ArrayList<>();

		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			if (input == null || input.isEmpty()) {
				break;
			}
			inputs.add(input);
		}
		sc.close();

		for (int i = 0; i < inputs.size(); ++i) {
			System.out.println(inputs.get(i));

		}
	}

	public void test6()
	{
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print("*");
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

	public void quiz14()
	{
		for (int i=0;i<4;i++)
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
		for (int i=0;i<5;i++)
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

	public void quiz15()
	{
		for (int i=0;i<4;i++)
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
		for (int i=0;i<5;i++)
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

	public void test7()
	{
		Scanner sc = new Scanner(System.in);
		int sel = 0;
		int sum = 0;
		while(true)
		{
			System.out.print("더할 수를 입력하세요 (종료==0) :");
			sel= sc.nextInt();
			if(sel==0)break;
			sum += sel;
		}
		System.out.printf("입력하신 값들의 전체 합은 %d입니다. \n",sum);

	}

	public void test8()
	{
		Scanner sc = new Scanner(System.in);
		int i = 0;
		while(true)
		{
			i++;
			System.out.println(i);

			if(i%500000==0)
			{
				System.out.print("중단하시겠습니까?(y,n) : ");
				if(sc.next().charAt(0)=='y')
				{
					break;
				}
			}
		}
		System.out.println("중단하였습니다.");
	}

	public void calculator()
	{
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		char ch;
		System.out.println("=== 계산기 프로그램 ===");
		System.out.println();
		while(true) 
		{
			System.out.print("연산자 입력 (+, -, *, / (q:종료)) : ");
			ch = sc.next().charAt(0);

			if(ch=='q'|| ch=='Q')
			{
				break;
			}
			if(ch != '+' && ch != '-' && ch != '*' && ch != '/')
			{
				System.out.println("연산자" + ch +"를 잘못 입력하셨습니다.");
				continue;
			}
			System.out.print("첫 번째 숫자 입력 : ");
			num1 = sc.nextInt();
			System.out.print("두 번째 숫자 입력 : ");
			num2 = sc.nextInt();

			System.out.print("계산중.");
			for(int i=0;i<10;i++)
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print(".");
			}

			System.out.println();
			System.out.println("====== 결 과 ======");
			switch(ch)
			{
			case '+':
				System.out.printf("%d + %d = %d \n",num1,num2,num1+num2);
				break;
			case '-':
				System.out.printf("%d + %d = %d \n",num1,num2,num1-num2);
				break;
			case '*':
				System.out.printf("%d + %d = %d \n",num1,num2,num1*num2);
				break;
			case '/':
				System.out.printf("%d + %d = %.1f \n",num1,num2,(double)num1/num2);
				break;
			}
		}
	}
	public void random()
	{
		Random r = new Random();
		for(int i=0; i<6;i++) {
			System.out.println(r.nextInt(45)+1);
		}
	}

	public void random1() 
	{
		Random r = new Random();
		System.out.print("0~9까지의 랜덤 수 : ");
		System.out.println(r.nextInt(10));
		System.out.print("1~10까지의 랜덤 수 : ");
		System.out.println(r.nextInt(10)+1);
		System.out.print("20~35까지의 랜덤 수 : ");
		System.out.println(r.nextInt(16)+20);
		System.out.print("0또는 1 : ");
		System.out.println(r.nextInt(2));
	}

}

