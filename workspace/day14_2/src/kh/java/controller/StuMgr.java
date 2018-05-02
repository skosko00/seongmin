package kh.java.controller;

import java.util.Scanner;

import kh.java.model.vo.Student;

public class StuMgr {

	Student [] s = new Student[10];
	// Student 객체 10개를 저장 할 수 있는 객체배열
	Scanner sc = new Scanner(System.in);
	int index = 0;
	
	public void insertStudent(Student s)
	{
		this.s[index++] = s;
	}
	
	public void viewAllStudent()
	{
		System.out.println("= = = = = = = = = 학생 정보 출력 = = = = = = = = =");
		System.out.println("\t이름 \t나이 \t 주소");
		for(int i=0; i<index; i++)
		{
			System.out.printf("\t%s \t%d \t%s \n",s[i].getName(),s[i].getAge(),s[i].getAddr());
		}
	}
}
