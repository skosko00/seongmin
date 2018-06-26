package jsp.admin.model.vo;

import java.util.ArrayList;

import jsp.reservation.model.vo.ReservationVo;

public class ReservePageVo {
	private ArrayList<ReservationVo> list;
	private String pageNavi;
	public ReservePageVo() {
	}
	public ReservePageVo(ArrayList<ReservationVo> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}

	public ArrayList<ReservationVo> getList() {
		return list;
	}
	public void setList(ArrayList<ReservationVo> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
	
	
	
}
