package jsp.member.model.vo;

import java.sql.Date;

public class MemberVo {

	@Override
	public String toString() {
		return "MemberVo [mbId=" + mbId + ", mbPwd=" + mbPwd + ", mbEmail=" + mbEmail + ", mbPhone=" + mbPhone
				+ ", mbGender=" + mbGender + ", mbName=" + mbName + ", mbAddress=" + mbAddress + ", mbBirth=" + mbBirth
				+ ", mbEntDate=" + mbEntDate + "]";
	}

	private String mbId, mbPwd, mbEmail, mbPhone, mbGender, mbName, mbAddress;
	private Date mbBirth, mbEntDate;

	public MemberVo() {
	}

	public MemberVo(String mbId, String mbPwd, String mbEmail, String mbPhone, String mbGender, String mbName,
			String mbAddress, Date mbBirth, Date mbEntDate) {
		super();
		this.mbId = mbId;
		this.mbPwd = mbPwd;
		this.mbEmail = mbEmail;
		this.mbPhone = mbPhone;
		this.mbGender = mbGender;
		this.mbName = mbName;
		this.mbAddress = mbAddress;
		this.mbBirth = mbBirth;
		this.mbEntDate = mbEntDate;
	}

	public String getMbId() {
		return mbId;
	}

	public void setMbId(String mbId) {
		this.mbId = mbId;
	}

	public String getMbPwd() {
		return mbPwd;
	}

	public void setMbPwd(String mbPwd) {
		this.mbPwd = mbPwd;
	}

	public String getMbEmail() {
		return mbEmail;
	}

	public void setMbEmail(String mbEmail) {
		this.mbEmail = mbEmail;
	}

	public String getMbPhone() {
		return mbPhone;
	}

	public void setMbPhone(String mbPhone) {
		this.mbPhone = mbPhone;
	}

	public String getMbGender() {
		return mbGender;
	}

	public void setMbGender(String mbGender) {
		this.mbGender = mbGender;
	}

	public String getMbName() {
		return mbName;
	}

	public void setMbName(String mbName) {
		this.mbName = mbName;
	}

	public String getMbAddress() {
		return mbAddress;
	}

	public void setMbAddress(String mbAddress) {
		this.mbAddress = mbAddress;
	}

	public Date getMbBirth() {
		return mbBirth;
	}

	public void setMbBirth(Date mbBirth) {
		this.mbBirth = mbBirth;
	}

	public Date getMbEntDate() {
		return mbEntDate;
	}

	public void setMbEntDate(Date mbEntDate) {
		this.mbEntDate = mbEntDate;
	}

}
