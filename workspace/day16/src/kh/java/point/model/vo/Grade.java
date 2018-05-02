package kh.java.point.model.vo;

public abstract class Grade {

	private String name;
	private String grade;
	private int point;
	
	public Grade()
	{
		
	}
	
	public Grade(String name, String grade, int point)
	{
		this.name = name;
		this.grade = grade;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	public abstract double getInterest();
	
}
