package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.model.vo.Member;

public class MemberDAO {

	public Member selectMember(Connection conn, String userId, String userPwd) {
		PreparedStatement stmt = null;
		ResultSet rset = null;
		Member m =null;
		String query = "select * from member where MEMBER_ID=? and MEMBER_PWD=?";
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, userId);
			stmt.setString(2, userPwd);
			rset = stmt.executeQuery();
			if(rset.next())
			{
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPwd(rset.getString("member_pwd"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberAge(rset.getInt("member_age"));
				m.setMemberAddr(rset.getString("member_addr"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return m;
	}

	

}
