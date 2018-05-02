package kh.java.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.java.model.vo.Member;

public class MemberDAO {
	
	public MemberDAO() {}

	public ArrayList<Member> allMember() {
		Connection conn = null;
		Statement stmn = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;
		Member m = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();
			
			String query = "select * from member";
			
			rset = stmn.executeQuery(query);
			
			list = new ArrayList<Member>();
			
			while(rset.next())
			{
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPwd(rset.getString("member_pwd"));
				m.setMemberName(rset.getString("member_name"));
				m.setGender(rset.getString("gender"));
				m.setAge(rset.getInt("age"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setHobby(rset.getString("hobby"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				list.add(m);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmn.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
		
	}

	public Member selectId(String memberId) {
		Connection conn = null;
		Statement stmn = null;
		ResultSet rset = null;
		Member m = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();
			
			String query = "select * from member where member_id = '"+memberId + "'";
			
			rset = stmn.executeQuery(query);
			
			if(rset.next())
			{
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPwd(rset.getString("member_pwd"));
				m.setMemberName(rset.getString("member_name"));
				m.setGender(rset.getString("gender"));
				m.setAge(rset.getInt("age"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setHobby(rset.getString("hobby"));
				m.setEnrollDate(rset.getDate("enroll_date"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmn.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return m;
		
	}

	public ArrayList<Member> selectName(String memberName) {
		Connection conn = null;
		Statement stmn = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;
		Member m = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();
			
			String query = "select * from member where member_name like '%"
					+ memberName +"%'";
			
			rset = stmn.executeQuery(query);
			list = new ArrayList<Member>();
			
			while(rset.next())
			{
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPwd(rset.getString("member_pwd"));
				m.setMemberName(rset.getString("member_name"));
				m.setGender(rset.getString("gender"));
				m.setAge(rset.getInt("age"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setHobby(rset.getString("hobby"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				list.add(m);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmn.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
		
	}

	public int insertMember(Member m) {
		Connection conn = null;
		Statement stmn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();
			
			String query = "insert into member values("
					+"'" + m.getMemberId() + "','"
					+ m.getMemberPwd() + "','"
					+ m.getMemberName() + "','"
					+ m.getGender() + "',"
					+ m.getAge() +",'"
					+ m.getEmail() + "','"
					+ m.getPhone() + "','"
					+ m.getAddress() + "','"
					+ m.getHobby() + "',"
					+ "sysdate)";
			
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
			e.printStackTrace();
		} finally {
			try {
				stmn.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return result;
	}

	public int updateMember(Member m) {
		Connection conn = null;
		Statement stmn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();
			
			String query = "update member set member_pwd = '"
					+ m.getMemberPwd() + "',email = '"
					+ m.getEmail() + "',phone = '"
					+ m.getPhone() + "',address = '"
					+ m.getAddress() + "' where member_id = '"
					+ m.getMemberId() +"'";
			
			System.out.println(query);
			
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

	public int deleteMember(Member m) {
		Connection conn = null;
		Statement stmn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmn = conn.createStatement();
			
			String query = "delete member where member_id = '"
					+ m.getMemberId() + "' and member_pwd = '"
					+ m.getMemberPwd() +"'";
			
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
