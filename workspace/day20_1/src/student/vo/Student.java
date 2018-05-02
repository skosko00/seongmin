package student.vo;

public class Student implements Comparable{
	private int classNumber;	// �й�
	private String name;		// �̸�
	private int age;			// ����
	private String addr;		// �ּ�
	private double grade;		// ����
	
	public Student() {}
	
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public int compareTo(Object o) {
		
		return this.classNumber-((Student)o).classNumber;
	}

	@Override
	public String toString() {
		return this.classNumber + " \t\t"
				+ this.name + " \t\t"
				+ this.age + " \t\t"
				+ this.addr + " \t\t"
				+ this.grade;
	}
	
	
}
