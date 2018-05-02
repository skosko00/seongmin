package book.kh.com.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import book.kh.com.controller.CustomerController;
import book.kh.com.model.vo.Customer;

public class CustomerDAO {
	
	public CustomerDAO() {}

	public ArrayList<Customer> allCustomer() {
		Connection conn = null;
		Statement stmn = null;
		ResultSet rset = null;
		ArrayList<Customer> list = null;
		Customer c = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();
			
			String query = "select * from customer";
			
			rset = stmn.executeQuery(query);
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

	public ArrayList<Customer> searchName(String name) {
		Connection conn = null;
		Statement stmn = null;
		ResultSet rset = null;
		ArrayList<Customer> list = null;
		Customer c = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();
			
			String query = "select * from customer where user_name like '%"+name+"%'"; 
			
			rset = stmn.executeQuery(query);
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

	public Customer searchId(String memberId) {
		Connection conn = null;
		Statement stmn = null;
		ResultSet rset = null;
		Customer c = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();
			
			String query = "select * from customer where user_id like '"+memberId+"'";
			
			rset = stmn.executeQuery(query);
			
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
		return c;
	}

	public int insertCustomer(Customer c) {
		Connection conn = null;
		Statement stmn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();
			
			String query = "insert into customer values ("+c.getUserNo()+",'"
					+c.getUserId()+"','"
					+c.getUserName()+"',"
					+c.getUserAge()+",'"
					+c.getAddr()+"','"
					+c.getGender()+"',"
					+"sysdate)";
			
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

	public int updateCustomer(Customer c) {
		Connection conn = null;
		Statement stmn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();
			
			String query = "update customer set user_name='"+c.getUserName()+"',addr = '"
					+c.getAddr()+"' where user_id='"+c.getUserId()+"'";
			
			result = stmn.executeUpdate(query);
			
			if(result>0)
			{
				conn.commit();
			}else {
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

	public int deleteCustomer(Customer c) {
		Connection conn = null;
		Statement stmn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();
			
			String query = "delete CUSTOMER where user_id='"+c.getUserId()+"'";
			
			result = stmn.executeUpdate(query);
			
			if(result>0)
			{
				conn.commit();
			}else {
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

}
