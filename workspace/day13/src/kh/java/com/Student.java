package kh.java.com;

public class Student {
	private String name;
	private String hobby =  "������ �����ϴ�.";
	private String addr = "������ �����ϴ�.";
	private int age=0;
	public Student(String name, int age, String addr, String hobby)
	{
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.hobby = hobby;		
	}
	public Student(String name, int age, String addr)
	{
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public Student(String name)
	{
		this.name = name;
	}
	public void printData()
	{
		System.out.println("�̸� : "+ this.name);
		if(age!=0) {
			System.out.println("���� : "+ this.age);
		}
		else {
			System.out.println("���� : ������ �����ϴ�.");	
		}
		System.out.println("�ּ� : "+ this.addr);
		System.out.println("��� : "+ this.hobby);
	}
}
