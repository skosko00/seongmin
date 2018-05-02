package kh.java.pay.model.vo;

public class Permanent extends Pay{

	private int pay;
	
	public Permanent(String name, String division, int pay)
	{
		super(name, division);
		this.pay=pay;
	}
	
	public int getPay()
	{
		return pay;
	}
}
