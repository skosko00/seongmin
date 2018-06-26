package jsp.member.model.vo;

import java.util.ArrayList;

public class PageDataVo {

	private ArrayList<QuestionVo> aList;
	private String pageNavi;

	public PageDataVo() {
		super();
	}

	public PageDataVo(ArrayList<QuestionVo> aList, String pageNavi) {
		super();
		this.aList = aList;
		this.pageNavi = pageNavi;
	}

	public ArrayList<QuestionVo> getaList() {
		return aList;
	}

	public void setaList(ArrayList<QuestionVo> aList) {
		this.aList = aList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
}
