package org.kh.member.model.vo;

public class Check {
	private String name;
	private String addr;
	private String gender;
	private String hobby;
	public Check() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Check(String name, String addr, String gender, String hobby) {
		super();
		this.name = name;
		this.addr = addr;
		this.gender = gender;
		this.hobby = hobby;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
