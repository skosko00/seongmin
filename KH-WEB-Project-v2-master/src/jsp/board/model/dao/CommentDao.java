package jsp.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jsp.board.model.vo.Comment;
import jsp.common.JDBCTemplate;

public class CommentDao {

	public ArrayList<Comment> selectComment(Connection conn, int bdNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Comment> list = null;
		
		String query = "select * from COMMENT_TB where CM_BD_NO=? order by 1 desc";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bdNo);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Comment>();
			
			while(rset.next()) {
				Comment c = new Comment();
				
				c.setCmNo(rset.getInt("CM_NO"));
				c.setCmBdNo(rset.getInt("CM_BD_NO"));
				c.setCmWriter(rset.getString("CM_WRITER"));
				c.setCmContents(rset.getString("CM_CONTENTS"));
				c.setCmWriteDate(rset.getTimestamp("CM_WRITE_DATE"));
				c.setCmRecCount(rset.getInt("CM_RECOMMEND_COUNT"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public int recommendAdd(Connection conn, int cmNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update COMMENT_TB set CM_RECOMMEND_COUNT = CM_RECOMMEND_COUNT+1 where CM_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cmNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public boolean recommendInquiry(Connection conn, int cmNo, String recommendId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean result = false;
		
		String query = "select * from RECOMMEND_COMMENT_TB where MB_ID=? and CM_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, recommendId);
			pstmt.setInt(2, cmNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int recommendInsert(Connection conn, int cmNo, String recommendId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into RECOMMEND_COMMENT_TB values (RECOMMEND_COMMENT_SEQ.NEXTVAL,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, recommendId);
			pstmt.setInt(2, cmNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public Comment commentCmNo(Connection conn, int cmNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Comment c = null;
		
		String query = "select * from COMMENT_TB where CM_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cmNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Comment();
				
				c.setCmNo(rset.getInt("CM_NO"));
				c.setCmBdNo(rset.getInt("CM_BD_NO"));
				c.setCmWriter(rset.getString("CM_WRITER"));
				c.setCmContents(rset.getString("CM_CONTENTS"));
				c.setCmWriteDate(rset.getTimestamp("CM_WRITE_DATE"));
				c.setCmRecCount(rset.getInt("CM_RECOMMEND_COUNT"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return c;
	}

}
