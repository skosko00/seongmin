package jsp.reservation.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class ReservationHistoryVo {
	
	private int resHisNo;
	private int resHisResNo;
	private String resHisRoomName;
	private String resHisId;
	private int resHisPersonnel;
	private Timestamp resHisReservationDate;
	private Date resHisInDate;
	private Date resHisOutDate;
	private int resHisPeriod;
	private int resHisPrice;
	private Timestamp resHisPaymentDate;
	
	
	public ReservationHistoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReservationHistoryVo(int resHisNo, int resHisResNo, String resHisRoomName, String resHisId,
			int resHisPersonnel, Timestamp resHisReservationDate, Date resHisInDate, Date resHisOutDate,
			int resHisPeriod, int resHisPrice, Timestamp resHisPaymentDate) {
		super();
		this.resHisNo = resHisNo;
		this.resHisResNo = resHisResNo;
		this.resHisRoomName = resHisRoomName;
		this.resHisId = resHisId;
		this.resHisPersonnel = resHisPersonnel;
		this.resHisReservationDate = resHisReservationDate;
		this.resHisInDate = resHisInDate;
		this.resHisOutDate = resHisOutDate;
		this.resHisPeriod = resHisPeriod;
		this.resHisPrice = resHisPrice;
		this.resHisPaymentDate = resHisPaymentDate;
	}


	public int getResHisNo() {
		return resHisNo;
	}


	public void setResHisNo(int resHisNo) {
		this.resHisNo = resHisNo;
	}


	public int getResHisResNo() {
		return resHisResNo;
	}


	public void setResHisResNo(int resHisResNo) {
		this.resHisResNo = resHisResNo;
	}


	public String getResHisRoomName() {
		return resHisRoomName;
	}


	public void setResHisRoomName(String resHisRoomName) {
		this.resHisRoomName = resHisRoomName;
	}


	public String getResHisId() {
		return resHisId;
	}


	public void setResHisId(String resHisId) {
		this.resHisId = resHisId;
	}


	public int getResHisPersonnel() {
		return resHisPersonnel;
	}


	public void setResHisPersonnel(int resHisPersonnel) {
		this.resHisPersonnel = resHisPersonnel;
	}


	public Timestamp getResHisReservationDate() {
		return resHisReservationDate;
	}


	public void setResHisReservationDate(Timestamp resHisReservationDate) {
		this.resHisReservationDate = resHisReservationDate;
	}


	public Date getResHisInDate() {
		return resHisInDate;
	}


	public void setResHisInDate(Date resHisInDate) {
		this.resHisInDate = resHisInDate;
	}


	public Date getResHisOutDate() {
		return resHisOutDate;
	}


	public void setResHisOutDate(Date resHisOutDate) {
		this.resHisOutDate = resHisOutDate;
	}


	public int getResHisPeriod() {
		return resHisPeriod;
	}


	public void setResHisPeriod(int resHisPeriod) {
		this.resHisPeriod = resHisPeriod;
	}


	public int getResHisPrice() {
		return resHisPrice;
	}


	public void setResHisPrice(int resHisPrice) {
		this.resHisPrice = resHisPrice;
	}


	public Timestamp getResHisPaymentDate() {
		return resHisPaymentDate;
	}


	public void setResHisPaymentDate(Timestamp resHisPaymentDate) {
		this.resHisPaymentDate = resHisPaymentDate;
	}
	
	
	
	
	

}
