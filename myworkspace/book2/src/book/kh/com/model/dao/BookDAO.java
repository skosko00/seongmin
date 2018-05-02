package book.kh.com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.kh.com.model.vo.Book;
import book.kh.com.model.vo.Library;

public class BookDAO {

	public BookDAO() {}

	public ArrayList<Book> allBook(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> list = null;
		Book b = null;
		
		String query = "select * from book";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
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

	public Book searchCode(Connection conn, int bookCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Book b = null;
		
		String query = "select * from book where book_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookCode);
			rset = pstmt.executeQuery();
			
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
		return b;		
	}

	public int insertBook(Connection conn, Book b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into book values(?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b.getBookNo());
			pstmt.setString(2, b.getBookName());
			pstmt.setString(3, b.getBookWriter());
			pstmt.setInt(4, b.getBookPrice());
			pstmt.setString(5, b.getPublisher());
			pstmt.setString(6, b.getGenre());
			
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

	public int deleteBook(Connection conn, int deleteCode) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "delete from book where book_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, deleteCode);
			
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

	public int searchLibrary(Connection conn, int deleteCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Library l = null;
		int value = 0;
		
		String query = "select * from library where book_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, deleteCode);
			rset = pstmt.executeQuery();
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
		return value;
	}
}
