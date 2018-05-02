package kh.java.jdbc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.java.jdbc.model.vo.Member;

// DAO의 역할
// DBMS의 연결 및 SQL 전송, 결과 리턴
// JDBC
// 1. 드라이버 등록
// 2. Connection (DBMS 연결)
// 3. Statement
// 4. SQL
// 5. Result Set
// 6. 연결 해제 (close)

public class MemberDAO {

	public MemberDAO() {}

	public ArrayList<Member> selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		ArrayList<Member> list = null;

		try {

			// 1. Driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. connection (DBMS에 연결 성공시 (Connection 값 리턴, 실패시 null 값 리턴)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");

			//			System.out.println("DB 연결 값 : " + conn);	// DB연결 확인 코드
			// 3. Statement 생성
			stmt = conn.createStatement();

			// 4. SQL
			String query = "select * from member";
			rset = stmt.executeQuery(query);	// 전송후에 결과값 리턴(Result Set);
			//rset = stmt.executeQuery("select * from member");	// 얘도 가능

			// rset.next() -> next메소드는 다음 행을 가리키는 메소드
			// 다음행을 가리켰을 때 있으면 true를 리턴, 없으면 false 리턴

			list = new ArrayList<Member>();

			while(rset.next())	//다음을 가리켰을때 있다면 루프반복, 없으면 스탑
			{
				Member m = new Member();
				// rset은 Key:Value 형태 // key는 컬럼명
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
				stmt.close();
				conn.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		/* 확인코드
		System.out.println(list);
		System.out.println(list.get(0).getMemberName());
		System.out.println(list.get(5).getMemberName());
		 */
		return list;

	}

	public Member selectOneId(String memberId) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		Member m = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 1. 드라이버 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student"); // 2. connection 연결
			//			System.out.println("DB 연결 값 : "+conn);
			stmt = conn.createStatement();	// 3. statement 생성

			String query = "select * from member where member_id = '"+memberId+"'";	//qeury

			rset = stmt.executeQuery(query);	// 4. 쿼리 전송 및 실행

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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return m;

	}

	public ArrayList<Member> selectName(String memberName) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;
		Member m = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			System.out.println(conn);
			stmt = conn.createStatement();

			String query = "select * from member where member_name like '%"+memberName+"%'";

			rset = stmt.executeQuery(query);

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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;

	}

	public int insertMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		// insert, update, delete는 ResultSet이 필요 없음
		// 이유는? 반환되는 결과가 성공이나 실패냐 인것이지
		// select처럼 어떠한 정보가 리턴되는것이 아니기 때문!!
		
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
		System.out.println(query);
		try {
			// 1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			// 3. Statement 객체 생성
			stmt = conn.createStatement();
			// 4. 쿼리문 실행			
			result = stmt.executeUpdate(query);
			// insert, update, delete 는 executeUpdate 메소드를
			// 사용하여 쿼리문을 작동시킴(리턴값이 int형 -> 쿼리문 정상 실행 개수 리턴)
			// executeUpdate 메소드는 해당 쿼리문을 실행 시킬 뿐
			// 적용 시키는 코드는 아님(commit 과 Rollback은 별도로 진행 해야 함)
			
			if(result>0)	// 정상 처리 되었다면
			{
				conn.commit();	// 적용
			}
			else			// 정상 처리 되지 않았다면
			{
				conn.rollback();	// 되돌리기
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{			
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean updateMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmt = conn.createStatement();
			
			String query =  "update member set member_pwd = '"
					+ m.getMemberPwd() +"', email = '"
					+ m.getEmail() + "', phone = '"
					+ m.getPhone() + "', address = '"
					+ m.getAddress() + "' where member_id = '"
					+ m.getMemberId() + "'";
			
			result = stmt.executeUpdate(query);
			
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(result>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public int deleteMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmt = conn.createStatement();
			
			String query = "delete from member where member_id='"
					+ m.getMemberId() + "' and member_pwd='"
					+ m.getMemberPwd() + "'";
			result = stmt.executeUpdate(query);
			
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
		
	}

}
