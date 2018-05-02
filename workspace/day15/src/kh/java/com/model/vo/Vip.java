package kh.java.com.model.vo;

public class Vip extends Grade {
	public Vip(String name, String grade, int point) {
		super(name, grade, point);
	}
	public double getIPoint() {
		return this.getPoint()*0.1;
	}
}
