package kh.java.com.model.vo;

public class Vvip extends Grade {
	public Vvip(String name, String grade, int point) {
		super(name, grade, point);
	}
	public double getIPoint() {
		return this.getPoint()*0.2;
	}
}
