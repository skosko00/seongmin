package kh.java.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kh.java.model.template.BoardTemplate;
import kh.java.model.vo.Board;

public class BoardDAO {

	public ArrayList<Board> allBoard(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		Board b = null;
		String query = "select * from board";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next())
			{
				b = new Board();
				b.setBoardNo(rset.getInt("board_no"));
				b.setDiv(rset.getString("div"));
				b.setTitle(rset.getString("title"));
				b.setContent(rset.getString("content"));
				b.setWriter(rset.getString("writer"));
				b.setWriteDate(rset.getDate("write_date"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BoardTemplate.close(rset);
			BoardTemplate.close(pstmt);
		}
		return list;
	}

	public int insertBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;		
		String query = "insert into board values(board_seq.nextval,?,?,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, b.getDiv());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());
			pstmt.setString(4, b.getWriter());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BoardTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Board> writerSearch(Connection conn, String writer) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		Board b = null;
		
		String query = "select * from board where writer=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, writer);
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				b = new Board();
				b.setBoardNo(rset.getInt("board_no"));
				b.setDiv(rset.getString("div"));
				b.setTitle(rset.getString("title"));
				b.setContent(rset.getString("content"));
				b.setWriter(rset.getString("writer"));
				b.setWriteDate(rset.getDate("write_date"));
				list.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BoardTemplate.close(rset);;
			BoardTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Board> titleSearch(Connection conn, String title) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		Board b = null;
		
		String query = "select * from board where title=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, title);
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				b = new Board();
				b.setBoardNo(rset.getInt("board_no"));
				b.setDiv(rset.getString("div"));
				b.setTitle(rset.getString("title"));
				b.setContent(rset.getString("content"));
				b.setWriter(rset.getString("writer"));
				b.setWriteDate(rset.getDate("write_date"));
				list.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BoardTemplate.close(rset);;
			BoardTemplate.close(pstmt);
		}
		return list;
	}

	public int updateBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update board set title=?, content=? where board_no=?";
		
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getBoardNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BoardTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteBoard(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from board where board_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
