package member.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {
	public MemberService() {}

	public Member selectMember(String userId, String userPwd)
	{
		Connection conn = null;//커넥션 코드 작성 후에
		Member m = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "login_member", "login_member");
			m = new MemberDAO().selectMember(conn,userId,userPwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return m;
	}

}
