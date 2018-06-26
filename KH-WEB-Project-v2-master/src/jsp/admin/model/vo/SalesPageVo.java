package jsp.admin.model.vo;

import java.util.ArrayList;

import jsp.reservation.model.vo.SalesVo;

public class SalesPageVo {
	private ArrayList<SalesVo> list;
	private String pageNavi;
	public SalesPageVo() {
	}
	
	public SalesPageVo(ArrayList<SalesVo> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}

	public ArrayList<SalesVo> getList() {
		return list;
	}
	public void setList(ArrayList<SalesVo> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	
}
