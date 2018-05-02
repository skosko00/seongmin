package kh.java.controller;

import java.util.Scanner;

import kh.java.model.vo.Student;

public class StuMgr {

	Student [] s = new Student[10];
	Scanner sc = new Scanner(System.in);

	public void insertStudent(Student student)
	{
		for(int i=0+Student.count-1;i<Student.count;i++)
		{
			s[i]=student;
		}

	}

	public void viewAllStudent()
	{
		System.out.println("= = = = = = = = = 학생 정보 출력 = = = = = = = = =");
		System.out.println("\t이름 \t나이 \t 주소");
		for(int i=0; i<Student.count; i++)
		{
			System.out.printf("\t%s \t%d \t%s \n",s[i].getName(),s[i].getAge(),s[i].getAddr());
		}
	}
}
