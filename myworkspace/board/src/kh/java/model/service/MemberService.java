package kh.java.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import kh.java.model.dao.MemberDAO;
import kh.java.model.template.BoardTemplate;
import kh.java.model.vo.Member;

public class MemberService {
	public MemberService() {}

	public ArrayList<Member> allMember() {
		Connection conn = BoardTemplate.Connection();
		ArrayList<Member> list = new MemberDAO().allMember(conn);
		BoardTemplate.close(conn);
		return list;
	}

	public Member serachId(String memberId) {
		Connection conn = BoardTemplate.Connection();
		Member m = new MemberDAO().searchId(conn,memberId);
		BoardTemplate.close(conn);
		return m;
	}

	public ArrayList<Member> searchName(String memberName) {
		Connection conn = BoardTemplate.Connection();
		ArrayList<Member> list = new MemberDAO().searchName(conn,memberName);
		BoardTemplate.close(conn);
		return list;		
	}

	public int insertMember(Member m) {
		Connection conn = BoardTemplate.Connection();
		int result = new MemberDAO().insertMember(conn,m);
		if(result>0)
		{
			BoardTemplate.commit(conn);
		}
		else
		{
			BoardTemplate.rollback(conn);
		}
		BoardTemplate.close(conn);
		return result;
	}

	public int updateMember(Member m) {
		Connection conn = BoardTemplate.Connection();
		int result = new MemberDAO().updateMember(conn,m);
		if(result > 0)
		{
			BoardTemplate.commit(conn);
		}
		else
		{
			BoardTemplate.rollback(conn);
		}
		BoardTemplate.close(conn);
		return result;
	}

	public int deleteMember(Member m) {
		Connection conn = BoardTemplate.Connection();
		int result = new MemberDAO().deleteMember(conn,m);
		if(result > 0)
		{
			BoardTemplate.commit(conn);
		}
		else
		{
			BoardTemplate.rollback(conn);
		}
		BoardTemplate.close(conn);
		return result;
	}
	
}
