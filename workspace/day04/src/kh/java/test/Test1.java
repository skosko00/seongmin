package kh.java.test;

import java.util.Scanner;

public class Test1 {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���� �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		if(num>0)
		{
			System.out.printf("����� �Է��� �� %d�� ����Դϴ�.",num);
		}
		if(num==0)
		{
			System.out.printf("����� �Է��� �� %d�� 0 �Դϴ�.", num);
		}
		if(num<0)
				{
			System.out.printf("����� �Է��� �� %d�� �����Դϴ�.", num);
		}
	}
	
	public void test2() {
		int num1, num2;
		System.out.println(" = = = = = �� �� �� ���α׷� ver 1.0 = = = = =");
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� �Է� �ϼ��� : ");
		num1 = sc.nextInt();
		System.out.print("�ι�° ���� �Է� �ϼ��� : ");
		num2 = sc.nextInt();
		
		if (num1 > num2)
		{
			System.out.println(num1 + " > " + num2);
			System.out.println("ù��° ���� �� Ů�ϴ�.");
		}
		if (num1 < num2)
		{
			System.out.println(num1 + " + " + num2);
			System.out.println("ù��° ���� �ι�° �� ���� �۽��ϴ�.");
		}
		if (num1 == num2)
		{
			System.out.println(num1 + " = " + num2);
			System.out.println("ù��° ���� �ι�° ���� �����ϴ�.");
		}
	}
	
	public void test3() {
		int num1, num2;
		char oper;
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ���α׷� ver 1.0");
		System.out.printf("�����ڸ� �Է��ϼ���(+,-,*,/)");
		oper = sc.next().charAt(0);
		System.out.print("ù��° �� �Է� : ");
		num1 = sc.nextInt();
		System.out.print("�ι�° �� �Է� : ");
		num2 = sc.nextInt();
		
		if (oper == '+')
		{
			System.out.printf("%d+%d=%d", num1, num2, num1+num2);
		}
		if (oper == '-')
		{
			System.out.printf("%d-%d=%d", num1, num2, num1-num2);
		}
		if (oper == '=')
		{
			System.out.printf("%d*%d=%d", num1, num2, num1*num2);
		}
		if (oper == '/')
		{
			System.out.printf("%d/%d=%f", num1, num2, (double)num1/num2);
		}
	}
	
	public void test4()
	{
		Scanner sc = new Scanner(System.in);
		int su;
		System.out.print("���� �Է� : ");
		su = sc.nextInt();
		if(su>0)
		{
			System.out.println("�Է� ���� 0���� ũ��");
		}
		else
		{
			System.out.println("�Է� ���� 0���� ũ�� �ʴ�.");
		}
	}
	
	public void test5() 
	{
	Scanner sc = new Scanner(System.in);
	
	int total, adult, child;
	System.out.println("���� ���� ���α׷� v1.0");
	System.out.print("���� �Ͻ� �ο��� �� ����Դϱ�?");
	total = sc.nextInt();
	
	System.out.print("��� ����Դϱ�? (�ο��� 1�� 5õ��)");
	adult = sc.nextInt();
	System.out.print("���̴� ����Դϱ�? (�ο��� 5õ��)");
	child = sc.nextInt();
	
	if (total == adult + child) 
	{
		adult *= 15000;
		child *= 5000;
		System.out.println("�����Ͻ� �� �ݾ��� " + (adult + child) + "�� �Դϴ�.");
	}
	else
	{
		System.out.println("�����Ͻ� �ο��� ���� �ʽ��ϴ�.");
	}
	}
	
	public void test6()
	{
		Scanner sc = new Scanner(System.in);
		
		int select, count = 0;
		
		System.out.println("ù��° �����Դϴ�.");		
		System.out.print("����� ����� �����ϱ��?(1.Apple / 2.�⽺) :");
		select = sc.nextInt();
		
		if (select == 1)
		{
			System.out.println("����!!");
			count++;
		}
		else
		{
			System.out.println("��!");
		}
		System.out.println("�ι�° �����Դϴ�.");
		System.out.print("�ٳ����� ��� ������ ���� ������?(1.���� 2.���) :");
		select = sc.nextInt();
		if (select == 1)
		{
			System.out.println("����!!");
			count++;
		}
		else 
		{
			System.out.println("��!");
		}
		System.out.println("�� " + count + "������ ���߼̽��ϴ�.");
	}
	
	public void test7() 
	{
		Scanner sc = new Scanner(System.in);
		int num1;
		System.out.print("1���� 100������ �� �� ���� : ");
		num1 = sc.nextInt();
		if(num1 > 0 && num1 <= 100) 
		{
			if(num1%2 == 0)
			{
				System.out.println("�Է��� ���� ¦�� �Դϴ�.\n");
			}
			else
			{
				System.out.println("�Է��� ���� Ȧ�� �Դϴ�");
			}
		}
		else
		{
			System.out.println("�߸��� ���� �Է��Ͽ����ϴ�.");
		}
	}
	
	public void test8()
	{
		Scanner sc= new Scanner(System.in);
		
		int select;
		System.out.println("= = = = = = �ɸ� �׽�Ʈ v1.0 = = = = = = \n");
		System.out.print("����� ���� �����Ͻʴϱ�?(1.yes, 2.no)");
		select = sc.nextInt();
		if (select == 1)
		{
			System.out.print("����� ��踦 �ǿ�ϱ�?(1.yes, 2.no)");
			select = sc.nextInt();
			if (select == 1)
			{
				System.out.println("���� �ǰ��� ���� �ʽ��ϴ�!!!");
			}
			else
			{
				System.out.println("���� �ǿ��� �ʾƵ� �� ������ ���� �����ؿ�!");
			}
		}
		else
		{
			System.out.print("����� �̼�ģ���� �ֽ��ϱ�?(1.yes, 2.no)");
			select = sc.nextInt();
			if (select == 1)
			{
				System.out.println("��.......");
			}
			else
			{
				System.out.println("...��������.. ���������� ��ó���..?");
			}
		}
	}
	
	public void test9()
	{
		Scanner sc = new Scanner(System.in);
		int num1;
		System.out.print("Input Number 1 ~ 3 : ");
		num1 = sc.nextInt();
		if(num1 == 1)
		{
			System.out.println("One !");
		}
		else if(num1 == 2)
		{
			System.out.println("Two !");
		}
		else if(num1 == 3)
		{
			System.out.println("Three !");
		}
		else
		{
			System.out.println("Error !");
		}
	}

	public void test10()
	{
		Scanner sc = new Scanner(System.in);
		char ch;
		System.out.print("���� �Է� : ");
		ch = sc.next().charAt(0);
		System.out.println("==== ��� ====");
		if ('A' <= ch && ch <='Z')	//�빮��
		{
			System.out.println("�빮�ڸ� �Է� �Ͽ����ϴ�.");
			System.out.printf("�ҹ��ڷ� ��ȯ : %c \n",(ch^32));
			System.out.println("-------------------->Restart");
		}
		else if ('a' <=ch && ch <= 'z')	//�ҹ���
		{
			System.out.println("�ҹ��ڸ� �Է� �Ͽ����ϴ�.");
			System.out.printf("�빮�ڷ� ��ȯ : %c \n",(ch^32));
			System.out.println("-------------------->Restart");
		}
		else	//�߸��Է�
		{
			System.out.println("�߸� �Է��ϼ̽��ϴ� �����ڸ� �Է����ּ���");
		}
	}
	
	public void test11()
	{
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.print("���� �Է� : ");
		num = sc.nextInt();
		
		if (num!=0)
		{
			if(num%3==0 && num%4==0)
			{
				System.out.printf("[%d]��(��) 3�� ��� �̸鼭, 4�� ����Դϴ�.",num);
			}
			else if(num%3==0)
			{
				System.out.printf("[%d]��(��) 3�� ����Դϴ�.",num);
			}
			else if(num%4==0)
			{
				System.out.printf("[%d]��(��) 4�� ����Դϴ�.",num);
			}
			else
			{
				System.out.printf("[%d]��(��) 3�� ����� 4�� ����� �ƴմϴ�.",num);
			}
		}
		else
		{
			System.out.printf("%d��(��) 3�� ����� 4�� ����� �ƴմϴ�.",num);
		}
	}
}