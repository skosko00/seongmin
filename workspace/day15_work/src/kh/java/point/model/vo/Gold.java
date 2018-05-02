package kh.java.point.model.vo;

public class Gold extends Grade {
	
	public Gold(String name, String grade, int point)
	{
		super(name, grade, point);
	}
	
	public double getInterest()
	{
		return this.getPoint()*0.05;
	}
}
