package kh.java.com;

public class Member implements Comparable
{
	private int number;
	private String name;
	private int age;
	private String addr;

	public Member() {}

	public Member(int number, String name, int age, String addr)
	{
		this.number = number; this.name = name; this.age = age; this.addr = addr;
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

	@Override
	public String toString() {
		return "학번 : " + this.number + " /이름 : "+this.name + " /나이 : " + this.age + " /주소 : " + this.addr;
	}

	@Override
	public int compareTo(Object o) {

		return this.number - ((Member)o).number;
	}


}
