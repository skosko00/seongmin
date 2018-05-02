package kh.java.com.model.vo;

public abstract class Grade {
	private String name;
	private String grade;
	private int point;

	public Grade(String name, String grade, int point) {
		this.name = name;
		this.grade = grade;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public String getGrade() {
		return grade;
	}

	public int getPoint() {
		return point;
	}
	
	public abstract double getInterest();
}
