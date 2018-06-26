package jsp.reservation.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class ReservationCancelVo { // 예약 취소 테이블 vo
	
	
	public int rcNo;
	private int rcResNo;
	private String rcResRoomName;
	private String rcResId;
	private int rcResPersonnel;
	private Timestamp rcResReservationDate;
	private Date rcResInDate;
	private Date rcResOutDate;
	private int rcResPeriod;
	private int rcResPrice;
	private Timestamp rcResPaymentDate;
	private Timestamp rcDate;
	private String rcRefundCheck;
	private String rcCancelCheck;
	
	
	public ReservationCancelVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ReservationCancelVo(int rcNo, int rcResNo, String rcResRoomName, String rcResId, int rcResPersonnel,
			Timestamp rcResReservationDate, Date rcResInDate, Date rcResOutDate, int rcResPeriod, int rcResPrice,
			Timestamp rcResPaymentDate, Timestamp rcDate, String rcRefundCheck, String rcCancelCheck) {
		super();
		this.rcNo = rcNo;
		this.rcResNo = rcResNo;
		this.rcResRoomName = rcResRoomName;
		this.rcResId = rcResId;
		this.rcResPersonnel = rcResPersonnel;
		this.rcResReservationDate = rcResReservationDate;
		this.rcResInDate = rcResInDate;
		this.rcResOutDate = rcResOutDate;
		this.rcResPeriod = rcResPeriod;
		this.rcResPrice = rcResPrice;
		this.rcResPaymentDate = rcResPaymentDate;
		this.rcDate = rcDate;
		this.rcRefundCheck = rcRefundCheck;
		this.rcCancelCheck = rcCancelCheck;
	}


	public int getRcNo() {
		return rcNo;
	}


	public void setRcNo(int rcNo) {
		this.rcNo = rcNo;
	}


	public int getRcResNo() {
		return rcResNo;
	}


	public void setRcResNo(int rcResNo) {
		this.rcResNo = rcResNo;
	}


	public String getRcResRoomName() {
		return rcResRoomName;
	}


	public void setRcResRoomName(String rcResRoomName) {
		this.rcResRoomName = rcResRoomName;
	}


	public String getRcResId() {
		return rcResId;
	}


	public void setRcResId(String rcResId) {
		this.rcResId = rcResId;
	}


	public int getRcResPersonnel() {
		return rcResPersonnel;
	}


	public void setRcResPersonnel(int rcResPersonnel) {
		this.rcResPersonnel = rcResPersonnel;
	}


	public Timestamp getRcResReservationDate() {
		return rcResReservationDate;
	}


	public void setRcResReservationDate(Timestamp rcResReservationDate) {
		this.rcResReservationDate = rcResReservationDate;
	}


	public Date getRcResInDate() {
		return rcResInDate;
	}


	public void setRcResInDate(Date rcResInDate) {
		this.rcResInDate = rcResInDate;
	}


	public Date getRcResOutDate() {
		return rcResOutDate;
	}


	public void setRcResOutDate(Date rcResOutDate) {
		this.rcResOutDate = rcResOutDate;
	}


	public int getRcResPeriod() {
		return rcResPeriod;
	}


	public void setRcResPeriod(int rcResPeriod) {
		this.rcResPeriod = rcResPeriod;
	}


	public int getRcResPrice() {
		return rcResPrice;
	}


	public void setRcResPrice(int rcResPrice) {
		this.rcResPrice = rcResPrice;
	}


	public Timestamp getRcResPaymentDate() {
		return rcResPaymentDate;
	}


	public void setRcResPaymentDate(Timestamp rcResPaymentDate) {
		this.rcResPaymentDate = rcResPaymentDate;
	}


	public Timestamp getRcDate() {
		return rcDate;
	}


	public void setRcDate(Timestamp rcDate) {
		this.rcDate = rcDate;
	}


	public String getRcRefundCheck() {
		return rcRefundCheck;
	}


	public void setRcRefundCheck(String rcRefundCheck) {
		this.rcRefundCheck = rcRefundCheck;
	}


	public String getRcCancelCheck() {
		return rcCancelCheck;
	}


	public void setRcCancelCheck(String rcCancelCheck) {
		this.rcCancelCheck = rcCancelCheck;
	}


	
	
}
