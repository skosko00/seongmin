package org.kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.kh.member.model.vo.Member;

public class MemberDAO {

	public Member selectOneMember(Connection conn, Member vo) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where user_id=? and user_pw=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPw());
			rset = pstmt.executeQuery();
			if(rset.next())
			{
				m = new Member();
				m.setUserId(rset.getString("user_id"));
				m.setUserPw(rset.getString("user_pw"));
				m.setUserName(rset.getString("user_name"));
				m.setUserPhone(rset.getString("user_phone"));
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
		return m;
	}

}
