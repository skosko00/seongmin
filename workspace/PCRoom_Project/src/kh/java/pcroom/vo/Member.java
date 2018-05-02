package kh.java.pcroom.vo;

public class Member {
	private String memberId;		// 회원 ID
	private String password;		// 회원 비밀번호
	private String name;			// 회원 이름
	private String birth;			// 회원 생일
	private String phoneNumber;		// 회원 전화번호
	private String eMail;			// 회원 메일
	private int userPrice;			// 사용요금
	private int productPrice;		// 상품사용요금
	private int totalPrice;			// 총 요금
	 
	public Member() {}
	
	public Member(String memberId, String password, String name, String birth, String phoneNumber, String eMail) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getName() {
		return name;
	}

	public String getBirth() {
		return birth;
	}

	public String geteMail() {
		return eMail;
	}

	public int getUserPrice() {
		return userPrice;
	}

	public void setUserPrice(int userPrice) {
		this.userPrice += userPrice;
	}

	public int getTotalPrice() {
		totalPrice = userPrice + productPrice;
		return totalPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice += productPrice;
	}
		
	
}
