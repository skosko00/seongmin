package book.kh.com.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import book.kh.com.model.vo.Book;
import book.kh.com.model.vo.Library;

public class BookDAO {

	public BookDAO() {}

	public ArrayList<Book> allBook() {
		Connection conn = null;
		Statement stmn = null;
		ResultSet rset = null;
		ArrayList<Book> list = null;
		Book b = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();

			String query = "select * from book";

			rset = stmn.executeQuery(query);
			list = new ArrayList<Book>();

			while(rset.next())
			{
				b = new Book();
				b.setBookNo(rset.getInt("book_no"));
				b.setBookName(rset.getString("book_name"));
				b.setBookWriter(rset.getString("book_writer"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setPublisher(rset.getString("publisher"));
				b.setGenre(rset.getString("genre"));
				list.add(b);
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

	public Book searchCode(int bookCode) {
		Connection conn = null;
		Statement stmn = null;
		ResultSet rset = null;
		Book b = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();

			String query = "select * from book where book_no='"+bookCode+"'";

			rset = stmn.executeQuery(query);
			if(rset.next())
			{
				b = new Book();
				b.setBookNo(rset.getInt("book_no"));
				b.setBookName(rset.getString("book_name"));
				b.setBookWriter(rset.getString("book_writer"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setPublisher(rset.getString("publisher"));
				b.setGenre(rset.getString("genre"));
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
		return b;
	}

	public int insertBook(Book b) {
		Connection conn = null;
		Statement stmn = null;
		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();

			String query = "insert into book values("+b.getBookNo()+",'"
					+b.getBookName()+"','"
					+b.getBookWriter()+"',"
					+b.getBookPrice()+",'"
					+b.getPublisher()+"','"
					+b.getGenre()+"')";

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public int deleteBook(int deleteCode) {
		Connection conn = null;
		Statement stmn = null;
		int result = 0;
		int result1;
		Book b = new Book();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();

			result1 = serachLibrary(deleteCode);
			if(result1==1)
			{
				String query = "delete book where BOOK_NO="+deleteCode;
				result = stmn.executeUpdate(query);
				if(result>0)
				{
					conn.commit();
				}
				else
				{
					conn.rollback();
				}
			}
			else
			{
				return result1;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	private int serachLibrary(int deleteCode) {
		Connection conn = null;
		Statement stmn = null;
		ResultSet rset = null;
		Library l = null;
		int value=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();

			String query = "select * from library where book_no="+deleteCode+"";

			rset = stmn.executeQuery(query);

			if(rset.next())
			{
				l = new Library();
				l.setLeaseNo(rset.getInt("lease_no"));
			}
			if(l!=null)
			{
				value = -1;
			}else
			{
				value = 1;
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
		return value; 
	}

}
