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
		System.out.println("�л� ���� �ý��� ver1.0\n");
		while(true)
		{
			System.out.println("1.�л� ���� �Է�");
			System.out.println("2.�л� ���� ���");
			System.out.println("3.����");
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
		System.out.print("�й��� �Է��ϼ��� : ");
		s[i].setNumber(sc.nextInt());
		System.out.print("�̸��� �Է��ϼ��� : ");
		s[i].setName(sc.next());
		System.out.print("���̸� �Է��ϼ��� : ");
		s[i].setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("�ּҸ� �Է��ϼ��� : ");
		s[i].setAddr(sc.nextLine());
		System.out.print("������ �Է��ϼ��� : ");
		s[i].setGender(sc.next().charAt(0));
		System.out.print("������ �Է��ϼ��� : ");
		s[i].setGrade(sc.nextDouble());		
		System.out.println();
		}
	}

	private void printData()
	{
		System.out.println("\t�й� \t�̸� \t���� \t�ּ� \t���� \t����\n");
		for(int i=0; i<s.length;i++)
		{
		System.out.printf("\t%d \t%s \t%d \t%s \t%c \t%.2f \n",s[i].getNumber(),s[i].getName(),s[i].getAge(),s[i].getAddr(),s[i].getGender(),s[i].getGrade());
		}
	}

	private void programEnd()
	{
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}
}
