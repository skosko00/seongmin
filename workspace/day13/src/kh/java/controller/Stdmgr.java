package kh.java.controller;

import java.util.Scanner;

import kh.java.model.Student;

public class Stdmgr {
	Student s = new Student();	
	Scanner sc = new Scanner(System.in);

	public void start()
	{
		System.out.println("= = = = = = 학 생 관 리 시 스 템 = = = = = = ver1.0\n");
		while(true)
		{
			System.out.println("1.학생 정보 입력(1명)");
			System.out.println("2.학생 정보 출력(1명)");
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
				return;
			}
		}
	}

	public void inserData()		//입력
	{
		System.out.print("학번을 입력하세요 : \n");
		s.setNumber(sc.nextInt());
		System.out.print("이름을 입력하세요 : \n");
		s.setName(sc.next());
		System.out.print("나이를 입력하세요 : \n");
		s.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("주소를 입력하세요 : \n");
		s.setAddr(sc.nextLine());
		System.out.print("성별을 입력하세요 : \n");
		s.setGender(sc.next().charAt(0));
		System.out.print("성적을 입력하세요 : \n");
		s.setGrade(sc.nextDouble());
	}

	public void printData()		//출력
	{
		System.out.printf("\t%s \t%s \t%s \t%s \t%s \t%s \n","학번","이름","나이","주소","성별","성적");
		System.out.printf("\t%d \t%s \t%d \t%s \t%c \t%.2f\n",s.getNumber(), s.getName(), s.getAge(), s.getAddr(), s.getGender(), s.getGrade());
	}

	public void programEnd()
	{
		System.out.println("프로그램을 종료합니다.");
	}

}
