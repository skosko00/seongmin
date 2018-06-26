package jsp.admin.model.vo;

import java.util.ArrayList;

import jsp.board.model.vo.BoardVo;

public class BoardAdminPageVo {
	private ArrayList<BoardVo> list;
	private String pageNavi;
	
	public BoardAdminPageVo() {
	}

	public BoardAdminPageVo(ArrayList<BoardVo> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}

	public ArrayList<BoardVo> getList() {
		return list;
	}

	public void setList(ArrayList<BoardVo> list) {
		this.list = list;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
	
}
