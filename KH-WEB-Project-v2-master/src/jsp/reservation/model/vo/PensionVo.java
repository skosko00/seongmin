package jsp.reservation.model.vo;

public class PensionVo {

	private String psName;
	private int psPersonnel;
	private int psMaxPersonnel;
	private String psContents;
	private int psWeekend;
	private int psWeekday;
	private int psAddtionalPrice;
	
	public PensionVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PensionVo(String psName, int psPersonnel, int psMaxPersonnel, String psContents, int psWeekend,
			int psWeekday, int psAddtionalPrice) {
		super();
		this.psName = psName;
		this.psPersonnel = psPersonnel;
		this.psMaxPersonnel = psMaxPersonnel;
		this.psContents = psContents;
		this.psWeekend = psWeekend;
		this.psWeekday = psWeekday;
		this.psAddtionalPrice = psAddtionalPrice;
	}

	public String getPsName() {
		return psName;
	}

	public void setPsName(String psName) {
		this.psName = psName;
	}

	public int getPsPersonnel() {
		return psPersonnel;
	}

	public void setPsPersonnel(int psPersonnel) {
		this.psPersonnel = psPersonnel;
	}

	public int getPsMaxPersonnel() {
		return psMaxPersonnel;
	}

	public void setPsMaxPersonnel(int psMaxPersonnel) {
		this.psMaxPersonnel = psMaxPersonnel;
	}

	public String getPsContents() {
		return psContents;
	}

	public void setPsContents(String psContents) {
		this.psContents = psContents;
	}

	public int getPsWeekend() {
		return psWeekend;
	}

	public void setPsWeekend(int psWeekend) {
		this.psWeekend = psWeekend;
	}

	public int getPsWeekday() {
		return psWeekday;
	}

	public void setPsWeekday(int psWeekday) {
		this.psWeekday = psWeekday;
	}

	public int getPsAddtionalPrice() {
		return psAddtionalPrice;
	}

	public void setPsAddtionalPrice(int psAddtionalPrice) {
		this.psAddtionalPrice = psAddtionalPrice;
	}

	@Override
	public String toString() {
		return "PensionVo [psName=" + psName + ", psPersonnel=" + psPersonnel + ", psMaxPersonnel=" + psMaxPersonnel
				+ ", psContents=" + psContents + ", psWeekend=" + psWeekend + ", psWeekday=" + psWeekday
				+ ", psAddtionalPrice=" + psAddtionalPrice + "]";
	}
	
	
}
