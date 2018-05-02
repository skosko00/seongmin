package book.kh.com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.kh.com.model.vo.Customer;

public class CustomerDAO {

	public CustomerDAO() {}

	public ArrayList<Customer> allCustomer(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Customer> list = null;
		Customer c = null;

		String query = "select * from customer";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			list = new ArrayList<Customer>();
			while(rset.next())
			{
				c = new Customer();
				c.setUserNo(rset.getInt("user_no"));
				c.setUserId(rset.getString("user_id"));
				c.setUserName(rset.getString("user_name"));
				c.setUserAge(rset.getInt("user_age"));
				c.setAddr(rset.getString("addr"));
				c.setGender(rset.getString("gender"));
				c.setEnrollDate(rset.getDate("enroll_date"));
				list.add(c);
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

	public ArrayList<Customer> searchName(Connection conn, String name) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Customer> list = null;
		Customer c = null;

		String query = "select * from customer where user_name like ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+name+"%");
			rset = pstmt.executeQuery();
			list = new ArrayList<Customer>();
			if(rset.next())
			{
				c = new Customer();
				c.setUserNo(rset.getInt("user_no"));
				c.setUserId(rset.getString("user_id"));
				c.setUserName(rset.getString("user_name"));
				c.setUserAge(rset.getInt("user_age"));
				c.setAddr(rset.getString("addr"));
				c.setGender(rset.getString("gender"));
				c.setEnrollDate(rset.getDate("enroll_date"));
				list.add(c);
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

	public Customer searchId(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Customer c = null;

		String query = "select * from customer where user_id = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if(rset.next())
			{
				c = new Customer();
				c.setUserNo(rset.getInt("user_no"));
				c.setUserId(rset.getString("user_id"));
				c.setUserName(rset.getString("user_name"));
				c.setUserAge(rset.getInt("user_age"));
				c.setAddr(rset.getString("addr"));
				c.setGender(rset.getString("gender"));
				c.setEnrollDate(rset.getDate("enroll_date"));
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
		return c;
	}

	public int insertCustomer(Connection conn, Customer c) {
		PreparedStatement pstmt= null;
		int result = 0;

		String query = "insert into customer values(?,?,?,?,?,?,sysdate)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, c.getUserNo());
			pstmt.setString(2, c.getUserId());
			pstmt.setString(3, c.getUserName());
			pstmt.setInt(4, c.getUserAge());
			pstmt.setString(5, c.getAddr());
			pstmt.setString(6, c.getGender());

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

	public int updateCustomer(Connection conn, Customer c) {
		PreparedStatement pstmt= null;
		int result = 0;

		String query = "update customer set user_name=?,addr=? where user_id=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getUserName());
			pstmt.setString(2, c.getAddr());
			pstmt.setString(3, c.getUserId());

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

	public int deleteCustomer(Connection conn, Customer c) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "delete customer where user_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}