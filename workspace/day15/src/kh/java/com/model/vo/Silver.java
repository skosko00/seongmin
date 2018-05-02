package kh.java.com.model.vo;

public class Silver extends Grade {
	
	public Silver(String name, String grade, int point) {
		super(name, grade, point);
	}
	

	public double getIPoint() {
		return this.getPoint()*0.02;
	}
	
}
