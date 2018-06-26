package jsp.admin.model.vo;

import java.util.ArrayList;

import jsp.reservation.model.vo.ReservationCancelVo;

public class ReserveCancelPageVo {
	
	private ArrayList<ReservationCancelVo> list;
	private String pageNavi;
	
	
	public ReserveCancelPageVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReserveCancelPageVo(ArrayList<ReservationCancelVo> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}


	public ArrayList<ReservationCancelVo> getList() {
		return list;
	}


	public void setList(ArrayList<ReservationCancelVo> list) {
		this.list = list;
	}


	public String getPageNavi() {
		return pageNavi;
	}


	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
	
	

	
}
