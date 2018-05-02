package kh.java.pay.model.vo;

public class Permanent extends Pay {
	private int pay;
	public Permanent()
	{
		
	}
	
	public Permanent(String name, String division, int pay)
	{
		super(name, division);
		this.pay=pay;
	}
	@Override
	public int getPay()
	{
		return this.pay;
	}

}
