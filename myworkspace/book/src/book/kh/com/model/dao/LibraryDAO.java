package book.kh.com.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import book.kh.com.model.vo.Book;
import book.kh.com.model.vo.Customer;
import book.kh.com.model.vo.Library;

public class LibraryDAO {

	public ArrayList<Library> allLibrary() {
		Connection conn = null;
		Statement stmn = null;
		ResultSet rset = null;
		ArrayList<Library> list = null;
		Library l = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();
			
			String query = "select l.lease_no, l.user_id, c.user_name, b.book_name from library l, CUSTOMER c, BOOK b where l.user_id=c.user_id and l.book_no = b.book_no";
			
			rset = stmn.executeQuery(query);
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
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmn.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
		
	}

	public ArrayList<Library> searchId(String userId) {
		Connection conn = null;
		Statement stmn = null;
		ResultSet rset = null;
		ArrayList<Library> list = null;
		Library l = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();
			
			String query = "select l.lease_no, l.user_id, c.user_name, b.book_name \r\n" + 
					"from library l, CUSTOMER c, BOOK b \r\n" + 
					"where l.user_id=c.user_id and l.book_no = b.book_no\r\n" + 
					"and l.user_id='"+userId+"'";
			
			rset = stmn.executeQuery(query);
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
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmn.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
		
	}

	public ArrayList<Library> searchBookName(String sBN) {
		Connection conn = null;
		Statement stmn = null;
		ResultSet rset = null;
		ArrayList<Library> list = null;
		Library l = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();
			
			
			String query = "select l.lease_no, l.user_id, c.user_name, b.book_name \r\n" + 
					"from library l, CUSTOMER c, BOOK b \r\n" + 
					"where l.user_id=c.user_id and l.book_no = b.book_no\r\n" + 
					"and b.book_name like '%"+sBN+"%'";
			
			rset = stmn.executeQuery(query);
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
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmn.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
				
	}

	public int insertLibrary(Library l) {
		Connection conn = null;
		Statement stmn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();
			
			String query = "insert into library values("
					+l.getLeaseNo()+",(select book_no from book where book_name = '"+l.getBookName()+"'),'"
					+l.getUserId()+"',sysdate,sysdate+2)";
			
			result = stmn.executeUpdate(query);
			
			if(result>0)
			{
				conn.commit();
			}
			else
			{
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			if(e.getMessage().contains("C007400"))
			{
				System.out.println("대여번호가 이미 존재합니다");
			}
			
			if(e.getMessage().contains("C007402"))
			{
				System.out.println("회원이 존재하지 않습니다.");
			}
			
			if(e.getMessage().contains("insert NULL"))
			{
				System.out.println("존재하지 않는 책입니다.");
			}
		} finally {
			try {
				stmn.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
