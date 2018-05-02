package net.kh.member.model;

public class Member {
	private String memberId;
	private String memberPwd;
	private String memberName;
	private int age;
	private char gender;
	private String phone;
	private String email;
	
	public Member()
	{
		
	}
	
	public void setMemberId(String memberId)
	{
		this.memberId = memberId;
	}
	
	public String getMemberId()
	{
		return this.memberId;
	}
	
	public void setMemberPwd(String memberPwd)
	{
		this.memberPwd = memberPwd;
	}
	
	public String getMemberPwd()
	{
		return this.memberPwd;
	}
	
	public void setMemberName(String memberName)
	{
		this.memberName = memberName;
	}
	
	public String getMemberName()
	{
		return this.memberName;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public void setAge(char gender)
	{
		this.gender = gender;
	}
	
	public char getGender()
	{
		return this.gender;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public String getPhone()
	{
		return this.phone;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getEmail()
	{
		return this.email;
	}
}
