package kh.java.test;

import java.util.Scanner;

public class StringMainTest {

	public void test1()
	{
		Scanner sc = new Scanner(System.in);
		String str1;
		char ch;
		int count=0;
		System.out.print("문자열 입력 : ");
		str1 = sc.nextLine();
		System.out.print("문자 입력 : ");
		ch = sc.next().charAt(0);
		if(('a'<=ch && ch<= 'z') || ('A'<=ch && ch<='Z')) {
			for (int i = 0; i<str1.length(); i++)
			{
				if(str1.charAt(i) == ch)
				{
					count++;
				}

			}
			System.out.printf("포함된 갯수 : %d 개",count );
		}
		else
		{
			System.out.println("영문자가 아닙니다.");
		}
	}

	public void test2()
	{
		Scanner sc = new Scanner(System.in);
		String name, addr, phone;
		int age, key, weight;
		
		System.out.println("===================저장회원===================");
		
		for(int i=1; i<=5; i++)
		{
			System.out.print("이름 입력 : ");
			name = sc.nextLine();
			System.out.print("나이 입력 : ");
			age = sc.nextInt();
			System.out.print("주소 입력 : ");
			sc.nextLine();
			addr = sc.nextLine();
			System.out.print("키 입력 : ");
			key = sc.nextInt();
			System.out.print("몸무게 입력 : ");
			weight = sc.nextInt();
			System.out.print("연락처 입력 : ");
			sc.nextLine();
			phone = sc.nextLine();
			
			System.out.printf("%d %s %d세 %s %d %d %s",i,name,age,addr,key,weight,phone);
		}
		
	}
}
