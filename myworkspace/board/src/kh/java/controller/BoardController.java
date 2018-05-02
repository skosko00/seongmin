package kh.java.controller;

import java.util.ArrayList;

import kh.java.model.service.BoardService;
import kh.java.model.vo.Board;

public class BoardController {
	public BoardController() {}
	private BoardService bs = new BoardService();

	public ArrayList<Board> allBoard() {
		ArrayList<Board> list = bs.allBoard();	
		if(list.isEmpty())
		{
			return null;
		}else
		{
			return list;
		}
	}

	public String insertBoard(Board b) {
		int result = bs.insertBoard(b);
		if(result>0)
		{
			return "글이 작성되었습니다.";
		}
		else
		{
			return "글 작성에 실패하였습니다.";
		}
	}

	public ArrayList<Board> writerSearch(String writer) {
		ArrayList<Board> list = bs.writerSearch(writer);
		if(list.isEmpty())
		{
			return null;
		}else
		{
			return list;
		}
	}

	public ArrayList<Board> titleSearch(String title) {
		ArrayList<Board> list = bs.titleSearch(title);
		if(list.isEmpty())
		{
			return null;
		}else
		{
			return list;
		}
	}

	public String updateBoard(Board b) {
		int result = bs.updateBoard(b);
		if(result>0)
		{
			return "수정되었습니다.";
		}else
		{
			return "수정에 실패하였습니다.";
		}
	}

	public String deleteBoard(int no) {
		int result = bs.deleteBoard(no);
		if(result>0)
		{
			return "삭제되었습니다.";
		}else
		{
			return "삭제에 실패하였습니다.";
		}
	}

}
