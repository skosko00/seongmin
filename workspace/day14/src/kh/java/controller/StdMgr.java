package kh.java.controller;

import java.util.Scanner;

import kh.java.model.Student;

public class StdMgr {

	Student [] s = new Student[3];	
	Scanner sc = new Scanner(System.in);
	
	public StdMgr()
	{
		for(int i=0; i<s.length;i++)
		{
			s[i] = new Student();
		}
	}

	public void start()
	{
		System.out.println("학생 관리 시스템 ver1.0\n");
		while(true)
		{
			System.out.println("1.학생 정보 입력");
			System.out.println("2.학생 정보 출력");
			System.out.println("3.종료");
			switch(sc.nextInt())
			{
			case 1:
				inserData();
				break;
			case 2:
				printData();
				break;
			case 3:
				programEnd();
				break;
			}
		}
	}

	private void inserData()
	{
		for(int i=0; i<s.length; i++)
		{
		System.out.print("학번을 입력하세요 : ");
		s[i].setNumber(sc.nextInt());
		System.out.print("이름을 입력하세요 : ");
		s[i].setName(sc.next());
		System.out.print("나이를 입력하세요 : ");
		s[i].setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("주소를 입력하세요 : ");
		s[i].setAddr(sc.nextLine());
		System.out.print("성별을 입력하세요 : ");
		s[i].setGender(sc.next().charAt(0));
		System.out.print("학점을 입력하세요 : ");
		s[i].setGrade(sc.nextDouble());		
		System.out.println();
		}
	}

	private void printData()
	{
		System.out.println("\t학번 \t이름 \t나이 \t주소 \t성별 \t학점\n");
		for(int i=0; i<s.length;i++)
		{
		System.out.printf("\t%d \t%s \t%d \t%s \t%c \t%.2f \n",s[i].getNumber(),s[i].getName(),s[i].getAge(),s[i].getAddr(),s[i].getGender(),s[i].getGrade());
		}
	}

	private void programEnd()
	{
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
}
