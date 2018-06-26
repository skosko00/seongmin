package jsp.reservation.model.vo;

public class SalesVo {
	private int salesNo;
	private String salesId;
	private int salesPaymentPrice;
	private int salesReservationNo;
	public SalesVo() {
		// TODO Auto-generated constructor stub
	}
	
	public SalesVo(int salesNo, String salesId, int salesPaymentPrice, int salesReservationNo) {
		super();
		this.salesNo = salesNo;
		this.salesId = salesId;
		this.salesPaymentPrice = salesPaymentPrice;
		this.salesReservationNo = salesReservationNo;
	}

	public int getSalesNo() {
		return salesNo;
	}
	public void setSalesNo(int salesNo) {
		this.salesNo = salesNo;
	}
	public String getSalesId() {
		return salesId;
	}
	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
	public int getSalesPaymentPrice() {
		return salesPaymentPrice;
	}
	public void setSalesPaymentPrice(int salesPaymentPrice) {
		this.salesPaymentPrice = salesPaymentPrice;
	}
	public int getSalesReservationNo() {
		return salesReservationNo;
	}
	public void setSalesReservationNo(int salesReservationNo) {
		this.salesReservationNo = salesReservationNo;
	}
	
}
