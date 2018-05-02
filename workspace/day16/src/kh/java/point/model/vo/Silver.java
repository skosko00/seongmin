package kh.java.point.model.vo;

public class Silver extends Grade{
	
	public Silver()
	{
		
	}
	public Silver(String name, String Grade, int point)
	{
		super(name,Grade,point);
	}
	
	public double getInterest()
	{
		return this.getPoint()*0.03;
	}
}
