package kh.java.pay.model.vo;

public class Intern extends Pay{
	private int pay;
	
	public Intern()
	{
		
	}
	
	public Intern(String name, String division, int pay)
	{
		super(name,division);
		this.pay=pay;
	}
	
	public int getPay()
	{
		return (int)(pay*0.8);
	}

}
