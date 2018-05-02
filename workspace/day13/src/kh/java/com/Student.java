package kh.java.com;

public class Student {
	private String name;
	private String hobby =  "정보가 없습니다.";
	private String addr = "정보가 없습니다.";
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
		System.out.println("이름 : "+ this.name);
		if(age!=0) {
			System.out.println("나이 : "+ this.age);
		}
		else {
			System.out.println("나이 : 정보가 없습니다.");	
		}
		System.out.println("주소 : "+ this.addr);
		System.out.println("취미 : "+ this.hobby);
	}
}
