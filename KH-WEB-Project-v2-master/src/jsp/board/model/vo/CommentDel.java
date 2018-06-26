package jsp.board.model.vo;

import java.sql.Timestamp;

public class CommentDel {
	public CommentDel() {
	}

	// 댓글 삭제
	private int CmDelNo;
	private int cmBdNo;
	private String CmDelWriter;
	private String CmDelContents;
	private Timestamp CmDelWriteDate;
	private Timestamp CmDelDeleteDate;
	public CommentDel(int CmDelNo, int cmBdNo, String CmDelWriter, String CmDelContents,
			Timestamp CmDelWriteDate, Timestamp CmDelDeleteDate) {
		super();
		this.CmDelNo = CmDelNo;
		this.cmBdNo = cmBdNo;
		this.CmDelWriter = CmDelWriter;
		this.CmDelContents = CmDelContents;
		this.CmDelWriteDate = CmDelWriteDate;
		this.CmDelDeleteDate = CmDelDeleteDate;
	}
	public int getCmDelNo() {
		return CmDelNo;
	}
	public void setCmDelNo(int CmDelNo) {
		this.CmDelNo = CmDelNo;
	}
	public int getCmBdNo() {
		return cmBdNo;
	}
	public void setCmBdNo(int cmBdNo) {
		this.cmBdNo = cmBdNo;
	}
	public String getCmDelWriter() {
		return CmDelWriter;
	}
	public void setCmDelWriter(String CmDelWriter) {
		this.CmDelWriter = CmDelWriter;
	}
	public String getCmDelContents() {
		return CmDelContents;
	}
	public void setCmDelContents(String CmDelContents) {
		this.CmDelContents = CmDelContents;
	}
	public Timestamp getCmDelWriteDate() {
		return CmDelWriteDate;
	}
	public void setCmDelWriteDate(Timestamp CmDelWriteDate) {
		this.CmDelWriteDate = CmDelWriteDate;
	}
	public Timestamp getCmDelDeleteDate() {
		return CmDelDeleteDate;
	}
	public void setCmDelDeleteDate(Timestamp CmDelDeleteDate) {
		this.CmDelDeleteDate = CmDelDeleteDate;
	}

}
