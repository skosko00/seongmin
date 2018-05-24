package member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	public Member selectOne(String userId, String userPwd) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDAO().selectOne(conn,userId,userPwd);
		JDBCTemplate.close(conn);
		return m;
	}

	public ArrayList<Member> allMember() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = new MemberDAO().allMember(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int activation(String active, String userId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDAO().activation(conn,active,userId);
		if(result>0)
		{
			JDBCTemplate.commit(conn);
		}
		else
		{
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
