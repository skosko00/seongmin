package kh.java.com.model.vo;

public class Silver extends Grade {
	
	public Silver(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	@Override
	public double getInterest()
	{
		return this.getPoint()*0.02;
	}
}
