package jsp.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import jsp.board.model.dao.CommentDao;
import jsp.board.model.vo.Comment;
import jsp.common.JDBCTemplate;

public class CommentService {

	public ArrayList<Comment> selectComment(int bdNo) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		ArrayList<Comment> list = new CommentDao().selectComment(conn, bdNo);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public int recommendAdd(int cmNo) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = new CommentDao().recommendAdd(conn, cmNo);
		if(result > 0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollBack(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public boolean recommendInquiry(int cmNo, String recommendId) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		boolean result = new CommentDao().recommendInquiry(conn, cmNo, recommendId);
		JDBCTemplate.close(conn);
		return result;
	}

	public int recommendInsert(int cmNo, String recommendId) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = new CommentDao().recommendInsert(conn, cmNo, recommendId);
		if(result > 0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollBack(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public Comment commentCmNo(int cmNo) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		Comment c = new CommentDao().commentCmNo(conn, cmNo);
		JDBCTemplate.close(conn);
		return c;
	}

}
