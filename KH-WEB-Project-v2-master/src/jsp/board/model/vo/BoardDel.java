package jsp.board.model.vo;

import java.sql.Timestamp;

public class BoardDel {
	public BoardDel() {
	}

	// 게시판 삭제
	private int bdDelNo;
	private String bdDelName;
	private String bdDelContents;
	private String bdDelWriter;
	private Timestamp bdDelWriteDate;
	private Timestamp bdDelDate;
	
	public BoardDel(int bdDelNo, String bdDelName, String bdDelContents, String bdDelWriter,
			Timestamp bdDelWriteDate, Timestamp bdDelDate) {
		super();
		this.bdDelNo = bdDelNo;
		this.bdDelName = bdDelName;
		this.bdDelContents = bdDelContents;
		this.bdDelWriter = bdDelWriter;
		this.bdDelWriteDate = bdDelWriteDate;
		this.bdDelDate = bdDelDate;
	}
	public int getBdDelNo() {
		return bdDelNo;
	}
	public void setBdDelNo(int bdDelNo) {
		this.bdDelNo = bdDelNo;
	}
	public String getBdDelName() {
		return bdDelName;
	}
	public void setBdDelName(String bdDelName) {
		this.bdDelName = bdDelName;
	}
	public String getBdDelContents() {
		return bdDelContents;
	}
	public void setBdDelContents(String bdDelContents) {
		this.bdDelContents = bdDelContents;
	}
	public String getBdDelWriter() {
		return bdDelWriter;
	}
	public void setBdDelWriter(String bdDelWriter) {
		this.bdDelWriter = bdDelWriter;
	}
	public Timestamp getBdDelWriteDate() {
		return bdDelWriteDate;
	}
	public void setBdDelWriteDate(Timestamp bdDelWriteDate) {
		this.bdDelWriteDate = bdDelWriteDate;
	}
	public Timestamp getBdDelDate() {
		return bdDelDate;
	}
	public void setBdDelDate(Timestamp bdDelDate) {
		this.bdDelDate = bdDelDate;
	}
	
	
}
