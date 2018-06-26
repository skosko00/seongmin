package jsp.admin.model.vo;

import java.util.ArrayList;

public class LoginLogPageVo {
	private ArrayList<MemberLoginLogVo> list ;
	private String pageNavi;
	
	
	public LoginLogPageVo(ArrayList<MemberLoginLogVo> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	
	public LoginLogPageVo() {
		super();
	}

	public ArrayList<MemberLoginLogVo> getList() {
		return list;
	}
	public void setList(ArrayList<MemberLoginLogVo> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
	
}
