package kh.java.pay.model.vo;

public class PartTime extends Pay{
	private int pay, time;
	
	public PartTime(String name, String division, int pay, int time)
	{
		super(name,division);
		this.pay = pay;
		this.time = time;
	}
	
	public int getPay()
	{
		return (pay*time);
	}

}
