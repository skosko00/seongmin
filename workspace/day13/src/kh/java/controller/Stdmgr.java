package kh.java.controller;

import java.util.Scanner;

import kh.java.model.Student;

public class Stdmgr {
	Student s = new Student();	
	Scanner sc = new Scanner(System.in);

	public void start()
	{
		System.out.println("= = = = = = �� �� �� �� �� �� �� = = = = = = ver1.0\n");
		while(true)
		{
			System.out.println("1.�л� ���� �Է�(1��)");
			System.out.println("2.�л� ���� ���(1��)");
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
				return;
			}
		}
	}

	public void inserData()		//�Է�
	{
		System.out.print("�й��� �Է��ϼ��� : \n");
		s.setNumber(sc.nextInt());
		System.out.print("�̸��� �Է��ϼ��� : \n");
		s.setName(sc.next());
		System.out.print("���̸� �Է��ϼ��� : \n");
		s.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("�ּҸ� �Է��ϼ��� : \n");
		s.setAddr(sc.nextLine());
		System.out.print("������ �Է��ϼ��� : \n");
		s.setGender(sc.next().charAt(0));
		System.out.print("������ �Է��ϼ��� : \n");
		s.setGrade(sc.nextDouble());
	}

	public void printData()		//���
	{
		System.out.printf("\t%s \t%s \t%s \t%s \t%s \t%s \n","�й�","�̸�","����","�ּ�","����","����");
		System.out.printf("\t%d \t%s \t%d \t%s \t%c \t%.2f\n",s.getNumber(), s.getName(), s.getAge(), s.getAddr(), s.getGender(), s.getGrade());
	}

	public void programEnd()
	{
		System.out.println("���α׷��� �����մϴ�.");
	}

}
