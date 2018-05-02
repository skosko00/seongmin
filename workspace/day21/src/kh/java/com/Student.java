package kh.java.com;

public class Student {
	private int classNumber;
	private String name;
	private int age;

	public Student() {}

	public Student(int classNumber, String name, int age) 
	{
		this.classNumber = classNumber;
		this.name = name;
		this.age = age;
	}

	public int getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
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

	@Override
	public String toString() {
		return " " + classNumber + "\t " + name + "\t " + age;
	}

	

}
