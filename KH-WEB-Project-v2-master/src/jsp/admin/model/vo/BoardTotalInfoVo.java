package jsp.admin.model.vo;

import java.util.ArrayList;

import jsp.board.model.vo.BoardVo;
import jsp.board.model.vo.DataFile;

public class BoardTotalInfoVo {
	private BoardVo bv;
	private ArrayList<DataFile> list;
	
	
	public BoardTotalInfoVo(BoardVo bv, ArrayList<DataFile> list) {
		super();
		this.bv = bv;
		this.list = list;
	}
	
	public BoardTotalInfoVo() {
		super();
	}

	public BoardVo getBv() {
		return bv;
	}
	public void setBv(BoardVo bv) {
		this.bv = bv;
	}
	public ArrayList<DataFile> getList() {
		return list;
	}
	public void setList(ArrayList<DataFile> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "BoardTotalInfoVo [bv=" + bv + ", list=" + list.toString() + "]";
	}
	

}
