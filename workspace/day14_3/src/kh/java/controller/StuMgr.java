package kh.java.controller;

import java.util.Scanner;

import kh.java.model.vo.Student;

public class StuMgr {

	Student [] s = new Student[10];
	// Student ��ü 10���� ���� �� �� �ִ� ��ü�迭
	Scanner sc = new Scanner(System.in);
	int index = 0;
	
	public StuMgr()
	{
		for(int i=0;i<s.length;i++)
		{
			s[i] = new Student();
		}
	}
	
	public void insertStudent(Student s)
	{
		this.s[index++] = s;
	}
	
	public void viewAllStudent()
	{
		System.out.println("= = = = = = = = = �л� ���� ��� = = = = = = = = =");
		System.out.println("\t�̸� \t���� \t �ּ�");
		for(int i=0; i<index; i++)
		{
			System.out.printf("\t%s \t%d \t%s \n",s[i].getName(),s[i].getAge(),s[i].getAddr());
		}
	}
	
	public void deleteStudent(String name)
	{
		for(int i=0; i<index; i++)
		{
			if(s[i].getName().equals(name))
			{
				s[i]=s[i+1];
				index--;
			}
		}
	}
}