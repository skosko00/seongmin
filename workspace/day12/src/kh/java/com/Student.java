package kh.java.com;

public class Student {
	private String name;
	private int age;
	private String addr;
	
	public void setName(String _name) {
		name = _name;
	}
	public void setAge(int _age) {
		age = _age;
	}
	public void setAddr(String _addr) {
		addr = _addr;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getAddr()
	{
		return addr;
	}
}
