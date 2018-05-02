package kh.java.point.model.vo;

public class Gold extends Grade{
	
	public Gold()
	{
		
	}
	public Gold(String name, String Grade, int point)
	{
		super(name,Grade,point);
	}
	
	public double getInterest()
	{
		return this.getPoint()*0.05;
	}
	
}
