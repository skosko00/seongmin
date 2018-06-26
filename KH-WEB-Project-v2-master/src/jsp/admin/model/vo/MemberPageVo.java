package jsp.admin.model.vo;

import java.util.ArrayList;

import jsp.member.model.vo.MemberVo;

public class MemberPageVo {
	private ArrayList<MemberVo> list;
	private String pageNavi;
	// 생성자
	public MemberPageVo() {}
	public MemberPageVo(ArrayList<MemberVo> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	// getter setter
	public ArrayList<MemberVo> getList() {
		return list;
	}
	public void setList(ArrayList<MemberVo> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
