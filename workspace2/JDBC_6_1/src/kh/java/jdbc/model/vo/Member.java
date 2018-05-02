package kh.java.jdbc.model.vo;

import java.sql.Date;

public class Member {
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	private Date enrollDate;
	
	public Member() {}	// 기본 생성자
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return this.memberId + "  " + this.memberName + "  " + this.memberPwd + "  " + this.gender + "  "
				+ this.age + "  " + this.email + "  " + phone + "  " + this.address + "  " + this.hobby
				+ "  " + this.enrollDate;
	}	
	
	
	
}

/*

MEMBER_ID   NOT NULL VARCHAR2(15)  
MEMBER_PWD  NOT NULL VARCHAR2(15)  
MEMBER_NAME NOT NULL VARCHAR2(20)  
GENDER               CHAR(1)       
AGE         NOT NULL NUMBER        
EMAIL                VARCHAR2(30)  
PHONE                CHAR(11)      
ADDRESS              VARCHAR2(500) 
HOBBY                VARCHAR2(50)  
ENROLL_DATE          DATE          

*/