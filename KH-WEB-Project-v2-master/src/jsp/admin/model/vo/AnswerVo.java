package jsp.admin.model.vo;

public class AnswerVo {
	private int aNo;
	private int aQNo;
	private String aContents;
	
	public int getaNo() {
		return aNo;
	}
	public void setaNo(int aNo) {
		this.aNo = aNo;
	}
	public int getaQNo() {
		return aQNo;
	}
	public void setaQNo(int aQNo) {
		this.aQNo = aQNo;
	}
	public String getaContents() {
		return aContents;
	}
	public void setaContents(String aContents) {
		this.aContents = aContents;
	}
	public AnswerVo(int aNo, int aQNo, String aContents) {
		super();
		this.aNo = aNo;
		this.aQNo = aQNo;
		this.aContents = aContents;
	}
	public AnswerVo() {
		super();
	}
	@Override
	public String toString() {
		return "AnswerVo [aNo=" + aNo + ", aQNo=" + aQNo + ", aContents=" + aContents + "]";
	}
}

