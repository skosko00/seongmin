// 예약 정보 VO
package jsp.reservation.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class ReservationVo {
	private int resNo;
	private String resRoomName; // 방 이름(PensionVo_pk)
	private String resId;
	private int resPersonnel;
	private Timestamp resReservationDate;
	private Date resInDate;
	private Date resOutDate;
	private int resPeriod;
	private int resPrice;
	private Timestamp resPaymentDate;
	
	public ReservationVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReservationVo(int resNo, String resRoomName, String resId, int resPersonnel, Timestamp resReservationDate,
			Date resInDate, Date resOutDate, int resPeriod, int resPrice, Timestamp resPaymentDate) {
		super();
		this.resNo = resNo;
		this.resRoomName = resRoomName;
		this.resId = resId;
		this.resPersonnel = resPersonnel;
		this.resReservationDate = resReservationDate;
		this.resInDate = resInDate;
		this.resOutDate = resOutDate;
		this.resPeriod = resPeriod;
		this.resPrice = resPrice;
		this.resPaymentDate = resPaymentDate;
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public String getResRoomName() {
		return resRoomName;
	}

	public void setResRoomName(String resRoomName) {
		this.resRoomName = resRoomName;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public int getResPersonnel() {
		return resPersonnel;
	}

	public void setResPersonnel(int resPersonnel) {
		this.resPersonnel = resPersonnel;
	}

	public Timestamp getResReservationDate() {
		return resReservationDate;
	}

	public void setResReservationDate(Timestamp resReservationDate) {
		this.resReservationDate = resReservationDate;
	}

	public Date getResInDate() {
		return resInDate;
	}

	public void setResInDate(Date resInDate) {
		this.resInDate = resInDate;
	}

	public Date getResOutDate() {
		return resOutDate;
	}

	public void setResOutDate(Date resOutDate) {
		this.resOutDate = resOutDate;
	}

	public int getResPeriod() {
		return resPeriod;
	}

	public void setResPeriod(int resPeriod) {
		this.resPeriod = resPeriod;
	}

	public int getResPrice() {
		return resPrice;
	}

	public void setResPrice(int resPrice) {
		this.resPrice = resPrice;
	}

	public Timestamp getResPaymentDate() {
		return resPaymentDate;
	}

	public void setResPaymentDate(Timestamp resPaymentDate) {
		this.resPaymentDate = resPaymentDate;
	}
	
}
