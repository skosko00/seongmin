package kh.java.test;

import java.util.Scanner;

public class StringMainTest {

	public void test1()
	{
		Scanner sc = new Scanner(System.in);
		String str1;
		char ch;
		int count=0;
		System.out.print("���ڿ� �Է� : ");
		str1 = sc.nextLine();
		System.out.print("���� �Է� : ");
		ch = sc.next().charAt(0);
		if(('a'<=ch && ch<= 'z') || ('A'<=ch && ch<='Z')) {
			for (int i = 0; i<str1.length(); i++)
			{
				if(str1.charAt(i) == ch)
				{
					count++;
				}

			}
			System.out.printf("���Ե� ���� : %d ��",count );
		}
		else
		{
			System.out.println("�����ڰ� �ƴմϴ�.");
		}
	}

	public void test2()
	{
		Scanner sc = new Scanner(System.in);
		String name, addr, phone;
		int age, key, weight;
		
		System.out.println("===================����ȸ��===================");
		
		for(int i=1; i<=5; i++)
		{
			System.out.print("�̸� �Է� : ");
			name = sc.nextLine();
			System.out.print("���� �Է� : ");
			age = sc.nextInt();
			System.out.print("�ּ� �Է� : ");
			sc.nextLine();
			addr = sc.nextLine();
			System.out.print("Ű �Է� : ");
			key = sc.nextInt();
			System.out.print("������ �Է� : ");
			weight = sc.nextInt();
			System.out.print("����ó �Է� : ");
			sc.nextLine();
			phone = sc.nextLine();
			
			System.out.printf("%d %s %d�� %s %d %d %s",i,name,age,addr,key,weight,phone);
		}
		
	}
}
