package kh.java.model.vo;

public class Student {
	private String name;
	private int age;
	private String addr;
	
	public static int count=0;
	
	public Student()
	{
		
	}
	
	public Student(String name, int age, String addr)
	{	
		count();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	

	private void count()
	{
		count++;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
