package jsp.board.model.vo;

import java.util.ArrayList;

public class Page {
	private ArrayList<BoardVo> list;
	private String pageCount;
	
	public Page() {}

	public Page(ArrayList<BoardVo> list, String pageCount) {
		super();
		this.list = list;
		this.pageCount = pageCount;
	}

	public ArrayList<BoardVo> getList() {
		return list;
	}

	public void setList(ArrayList<BoardVo> list) {
		this.list = list;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}
	
	
}
