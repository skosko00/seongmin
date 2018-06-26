package jsp.admin.model.vo;

import java.util.ArrayList;

import jsp.reservation.model.vo.ReservationHistoryVo;

public class ReserveHistoryPageVo {
	
	
	private ArrayList<ReservationHistoryVo> list;
	private String pageNavi;
	
	public ReserveHistoryPageVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReserveHistoryPageVo(ArrayList<ReservationHistoryVo> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}

	public ArrayList<ReservationHistoryVo> getList() {
		return list;
	}

	public void setList(ArrayList<ReservationHistoryVo> list) {
		this.list = list;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
	

}
