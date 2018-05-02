package kh.java.com.model.vo;

public class Ruby extends Grade {
	public Ruby(String name, String grade, int point){
		super(name, grade, point);
	}
	
	public double getInterest()
	{
		return this.getPoint()*0.5;
	}
}
