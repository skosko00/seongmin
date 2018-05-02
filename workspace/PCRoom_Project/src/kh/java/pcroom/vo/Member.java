package kh.java.pcroom.vo;

public class Member {
	private String memberId;		// ȸ�� ID
	private String password;		// ȸ�� ��й�ȣ
	private String name;			// ȸ�� �̸�
	private String birth;			// ȸ�� ����
	private String phoneNumber;		// ȸ�� ��ȭ��ȣ
	private String eMail;			// ȸ�� ����
	private int userPrice;			// �����
	private int productPrice;		// ��ǰ�����
	private int totalPrice;			// �� ���
	 
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
