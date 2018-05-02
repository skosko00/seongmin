package kh.java.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.java.model.dao.MemberDAO;
import static kh.java.model.template.MemberTemplate.*;
import kh.java.model.vo.Member;

public class MemberService {
	public MemberService() {}

	public ArrayList<Member> allMember() {
		Connection conn =  getConnection();		
		ArrayList<Member> list = new MemberDAO().allMember(conn);		
		 close(conn);		
		return list;
	}

	public Member selectId(String memberId) {
		Connection conn =  getConnection();
		Member m = new MemberDAO().selectId(conn, memberId);
		 close(conn);
		return m;
	}

	public ArrayList<Member> selectName(String memberName) {
		Connection conn =  getConnection();
		ArrayList<Member> list = new MemberDAO().selectName(conn,memberName);
		 close(conn);
		return list;
	}

	public int insertMember(Member m) {
		Connection conn =  getConnection();
		int result = new MemberDAO().insertMember(conn, m);
		if(result>0)
		{
			 commit(conn);
		}else
		{
			 rollback(conn);
		}
		return result;
	}

	public int updateMember(Member m) {
		Connection conn =  getConnection();
		int result = new MemberDAO().updateMember(conn, m);
		if(result>0)
		{
			 commit(conn);
		}
		else
		{
			 rollback(conn);
		}
		return result;
	}

	public int deleteMember(Member m) {
		Connection conn =  getConnection();
		int result = new MemberDAO().deleteMember(conn,m);
		if(result>0)
		{
			 commit(conn);
		}
		else
		{
			 rollback(conn);
		}
		return result;
	}	
}
