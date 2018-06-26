package jsp.main.model.vo;

public class PensionPicTb {
	private String psPicName;
	private String psPicPath;
	private String psPicMain;
	public PensionPicTb() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PensionPicTb(String psPicName, String psPicPath, String psPicMain) {
		super();
		this.psPicName = psPicName;
		this.psPicPath = psPicPath;
		this.psPicMain = psPicMain;
	}
	public String getpsPicName() {
		return psPicName;
	}
	public void setpsPicName(String psPicName) {
		this.psPicName = psPicName;
	}
	public String getPsPicPath() {
		return psPicPath;
	}
	public void setPsPicPath(String psPicPath) {
		this.psPicPath = psPicPath;
	}
	public String getPsPicMain() {
		return psPicMain;
	}
	public void setPsPicMain(String psPicMain) {
		this.psPicMain = psPicMain;
	}
}
