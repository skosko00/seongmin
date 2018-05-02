package kh.java.point.model.vo;

public class Vip extends Grade{

	public Vip()
	{
		
	}
	
	public Vip(String name, String Grade, int point)
	{
		super(name,Grade,point);
	}
	
	public double getInterest()
	{
		return this.getPoint()*0.1;
	}

	
}
