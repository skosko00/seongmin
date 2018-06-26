package jsp.board.model.vo;

import java.sql.Timestamp;

public class Comment {
	public Comment() {
	}

	// 댓글
	private int cmNo;
	private int cmBdNo;
	private String cmWriter;
	private String cmContents;
	private Timestamp cmWriteDate;
	private int cmRecCount;
	public Comment(int cmNo, int cmBdNo, String cmWriter, String cmContents, Timestamp cmWriteDate,
			int cmRecCount) {
		super();
		this.cmNo = cmNo;
		this.cmBdNo = cmBdNo;
		this.cmWriter = cmWriter;
		this.cmContents = cmContents;
		this.cmWriteDate = cmWriteDate;
		this.cmRecCount = cmRecCount;
	}
	public int getCmNo() {
		return cmNo;
	}
	public void setCmNo(int cmNo) {
		this.cmNo = cmNo;
	}
	public int getCmBdNo() {
		return cmBdNo;
	}
	public void setCmBdNo(int cmBdNo) {
		this.cmBdNo = cmBdNo;
	}
	public String getCmWriter() {
		return cmWriter;
	}
	public void setCmWriter(String cmWriter) {
		this.cmWriter = cmWriter;
	}
	public String getCmContents() {
		return cmContents;
	}
	public void setCmContents(String cmContents) {
		this.cmContents = cmContents;
	}
	public Timestamp getCmWriteDate() {
		return cmWriteDate;
	}
	public void setCmWriteDate(Timestamp cmWriteDate) {
		this.cmWriteDate = cmWriteDate;
	}
	public int getCmRecCount() {
		return cmRecCount;
	}
	public void setCmRecCount(int cmRecCount) {
		this.cmRecCount = cmRecCount;
	}

}
