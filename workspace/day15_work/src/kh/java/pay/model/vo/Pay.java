package kh.java.pay.model.vo;

public abstract class Pay {
	private String name;
	private String division;
	
	public Pay()
	{
		
	}
	
	public Pay(String name, String division)
	{
		this.name=name;
		this.division=division;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}
	
	public abstract int getPay();
}
