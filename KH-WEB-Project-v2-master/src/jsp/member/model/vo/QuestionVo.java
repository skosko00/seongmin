package jsp.member.model.vo;

import java.sql.Timestamp;

public class QuestionVo {

	private int qNo;
	private String qName, qContents, qWriter, qAnswerCheck;
	private Timestamp qWriteDate, qAnswerDate;

	public QuestionVo() {
	}

	public QuestionVo(int qNo, String qName, String qContents, String qWriter, String qAnswerCheck,
			Timestamp qWriteDate, Timestamp qAnswerDate) {
		super();
		this.qNo = qNo;
		this.qName = qName;
		this.qContents = qContents;
		this.qWriter = qWriter;
		this.qAnswerCheck = qAnswerCheck;
		this.qWriteDate = qWriteDate;
		this.qAnswerDate = qAnswerDate;
	}

	@Override
	public String toString() {
		return "QuestionVo [qNo=" + qNo + ", qName=" + qName + ", qContents=" + qContents + ", qWriter=" + qWriter
				+ ", qAnswerCheck=" + qAnswerCheck + ", qWriteDate=" + qWriteDate + ", qAnswerDate=" + qAnswerDate
				+ "]";
	}

	public int getqNo() {
		return qNo;
	}

	public void setqNo(int qNo) {
		this.qNo = qNo;
	}

	public String getqName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
	}

	public String getqContents() {
		return qContents;
	}

	public void setqContents(String qContents) {
		this.qContents = qContents;
	}

	public String getqWriter() {
		return qWriter;
	}

	public void setqWriter(String qWriter) {
		this.qWriter = qWriter;
	}

	public String getqAnswerCheck() {
		return qAnswerCheck;
	}

	public void setqAnswerCheck(String qAnswerCheck) {
		this.qAnswerCheck = qAnswerCheck;
	}

	public Timestamp getqWriteDate() {
		return qWriteDate;
	}

	public void setqWriteDate(Timestamp qWriteDate) {
		this.qWriteDate = qWriteDate;
	}

	public Timestamp getqAnswerDate() {
		return qAnswerDate;
	}

	public void setqAnswerDate(Timestamp qAnswerDate) {
		this.qAnswerDate = qAnswerDate;
	}
}
