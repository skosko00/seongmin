package book.kh.com.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import book.kh.com.model.vo.Book;
import book.kh.com.model.vo.Customer;
import book.kh.com.model.vo.Library;

public class LibraryDAO {

	public LibraryDAO() {}

	public ArrayList<Library> allLibrary(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Library> list = null;
		Library l = null;
		
		String query = "select l.lease_no, l.user_id, c.user_name, b.book_name from library l, CUSTOMER c, BOOK b where l.user_id=c.user_id and l.book_no = b.book_no";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			list = new ArrayList<Library>();
			while(rset.next())
			{
				l = new Library();
				l.setLeaseNo(rset.getInt("lease_no"));
				l.setUserId(rset.getString("user_id"));
				l.setUserName(rset.getString("user_name"));
				l.setBookName(rset.getString("book_name"));
				list.add(l);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<Library> searchID(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Library> list = null;
		Library l = null;
		
		String query = "select l.lease_no, l.user_id, c.user_name, b.book_name from library l, CUSTOMER c, BOOK b where l.user_id=c.user_id and l.book_no = b.book_no and l.user_id=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			list = new ArrayList<Library>();
			while(rset.next())
			{
				l = new Library();
				l.setLeaseNo(rset.getInt("lease_no"));
				l.setUserId(rset.getString("user_id"));
				l.setUserName(rset.getString("user_name"));
				l.setBookName(rset.getString("book_name"));
				list.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public ArrayList<Library> searchBookName(Connection conn, String sBN) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Library> list = null;
		Library l = null;
		
		String query = "select l.lease_no, l.user_id, c.user_name, b.book_name from library l, CUSTOMER c, BOOK b where l.user_id=c.user_id and l.book_no = b.book_no and b.book_name like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+sBN+"%");
			rset = pstmt.executeQuery();
			list = new ArrayList<Library>();
			while(rset.next())
			{
				l = new Library();
				l.setLeaseNo(rset.getInt("lease_no"));
				l.setUserId(rset.getString("user_id"));
				l.setUserName(rset.getString("user_name"));
				l.setBookName(rset.getString("book_name"));
				list.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public int insertLibrary(Connection conn, Library l) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into library values(?,(select book_no from book where book_name = ?),?,sysdate,sysdate+2)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, l.getLeaseNo());
			pstmt.setString(2, l.getBookName());
			pstmt.setString(3, l.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
