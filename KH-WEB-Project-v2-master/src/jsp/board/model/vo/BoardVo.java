package jsp.board.model.vo;

import java.sql.Timestamp;

public class BoardVo {

	public BoardVo() {
	}

	// 게시판 테이블
	private int bdNo;
	private String bdName;
	private String bdContents;
	private String bdWriter;
	private Timestamp bdWriteDate;
	private int bdViewCount;
	private int bdRecommendCount;
	private String bdCategory;

	public BoardVo(int BdNo, String BdName, String BdContents, String BdWriter, Timestamp BdWriteDate, int BdViewCount,
			int BdRecommendCount, String BdCategory) {
		super();

		this.bdNo = BdNo;
		this.bdName = BdName;
		this.bdContents = BdContents;
		this.bdWriter = BdWriter;
		this.bdWriteDate = BdWriteDate;
		this.bdViewCount = BdViewCount;
		this.bdRecommendCount = BdRecommendCount;
		this.bdCategory = BdCategory;
	}

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}

	public String getBdName() {
		return bdName;
	}

	public void setBdName(String bdName) {
		this.bdName = bdName;
	}

	public String getBdContents() {
		return bdContents;
	}

	public void setBdContents(String bdContents) {
		this.bdContents = bdContents;
	}

	public String getBdWriter() {
		return bdWriter;
	}

	public void setBdWriter(String bdWriter) {
		this.bdWriter = bdWriter;
	}

	public Timestamp getBdWriteDate() {
		return bdWriteDate;
	}

	public void setBdWriteDate(Timestamp bdWriteDate) {
		this.bdWriteDate = bdWriteDate;
	}

	public int getBdViewCount() {
		return bdViewCount;
	}

	public void setBdViewCount(int bdViewCount) {
		this.bdViewCount = bdViewCount;
	}

	public int getBdRecommendCount() {
		return bdRecommendCount;
	}

	public void setBdRecommendCount(int bdRecommendCount) {
		this.bdRecommendCount = bdRecommendCount;
	}

	public String getBdCategory() {
		return bdCategory;
	}

	public void setBdCategory(String bdCategory) {
		this.bdCategory = bdCategory;
	}

}
