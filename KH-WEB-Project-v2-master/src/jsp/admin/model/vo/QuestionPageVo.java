package jsp.admin.model.vo;

import java.util.ArrayList;

import jsp.member.model.vo.QuestionVo;

public class QuestionPageVo {
	private ArrayList<QuestionVo> list;
	private String pageNavi;
	public ArrayList<QuestionVo> getList() {
		return list;
	}
	public void setList(ArrayList<QuestionVo> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	public QuestionPageVo(ArrayList<QuestionVo> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public QuestionPageVo() {
		super();
	}
	
	
	
}
