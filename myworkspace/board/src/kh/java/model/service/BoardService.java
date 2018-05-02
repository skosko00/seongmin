package kh.java.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.java.model.dao.BoardDAO;
import kh.java.model.template.BoardTemplate;
import kh.java.model.vo.Board;

public class BoardService {
	public BoardService() {}
	
	public ArrayList<Board> allBoard() {
		Connection conn = BoardTemplate.Connection();
		ArrayList<Board> list = new BoardDAO().allBoard(conn);
		BoardTemplate.close(conn);
		return list;
	}

	public int insertBoard(Board b) {
		Connection conn = BoardTemplate.Connection();
		int result = new BoardDAO().insertBoard(conn,b);
		if(result>0)
		{
			BoardTemplate.commit(conn);
		}
		else
		{
			BoardTemplate.rollback(conn);
		}
		BoardTemplate.close(conn);
		return result;
	}

	public ArrayList<Board> writerSearch(String writer) {
		Connection conn = BoardTemplate.Connection();
		ArrayList<Board> list = new BoardDAO().writerSearch(conn, writer);
		BoardTemplate.close(conn);
		return list;
	}

	public ArrayList<Board> titleSearch(String title) {
		Connection conn = BoardTemplate.Connection();
		ArrayList<Board> list = new BoardDAO().titleSearch(conn, title);
		BoardTemplate.close(conn);
		return list;
	}

	public int updateBoard(Board b) {
		Connection conn = BoardTemplate.Connection();
		int result = new BoardDAO().updateBoard(conn, b);
		if(result>0)
		{
			BoardTemplate.commit(conn);
		}
		else
		{
			BoardTemplate.rollback(conn);
		}
		BoardTemplate.close(conn);
		return result;
	}

	public int deleteBoard(int no) {
		Connection conn = BoardTemplate.Connection();
		int result = new BoardDAO().deleteBoard(conn, no);
		if(result>0)
		{
			BoardTemplate.commit(conn);
		}
		else
		{
			BoardTemplate.rollback(conn);
		}
		BoardTemplate.close(conn);
		return result;
		
	}

}
