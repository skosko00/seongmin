package book.kh.com.model.vo;

import java.sql.Date;

public class Library {
	public Library () {}
	
	private int leaseNo;
	private String userId;
	private String userName;
	private String bookName;
	public int getLeaseNo() {
		return leaseNo;
	}
	public void setLeaseNo(int leaseNo) {
		this.leaseNo = leaseNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	@Override
	public String toString() {
		return leaseNo + "    " + userId + "    " + userName + "    "
				+ bookName;
	}
	
}
