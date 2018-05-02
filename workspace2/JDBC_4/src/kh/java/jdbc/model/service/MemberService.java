package kh.java.jdbc.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.java.jdbc.model.dao.MemberDAO;
import kh.java.jdbc.model.template.JDBCTemplate;
import kh.java.jdbc.model.vo.Member;

public class MemberService {

	public MemberService() {}



	//	DAO는 DB에 접근하여 데이터를 가져오거나 삽입, 삭제 등의 행위를 하는
	//	역할의 객체 일뿐!! DB 접속 연결을 하는 역할도 DAO의 역할은 아님!!
	//	DB에 연결하기 위한 역할은 Service에서 진행

	public ArrayList<Member> selectAll() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = new MemberDAO().selectAll(conn);
		JDBCTemplate.close(conn);
		return list;	
	}


	public Member selectOneId(String memberId) {
		Connection conn = null;
		Member m = null;
		conn = JDBCTemplate.getConnection();
		m = new MemberDAO().selectOneId(conn, memberId);
		JDBCTemplate.close(conn);
		return m;
	}

	public ArrayList<Member> selectName(String memberName) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = new MemberDAO().selectName(conn, memberName);
		JDBCTemplate.close(conn);
		return list;
	}

	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDAO().insertMember(conn, m);
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

	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDAO().updateMember(conn, m);
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

	public int deleteMember(Member m) {
		//		회원 탈퇴 작업시 (탈퇴 Service)
		//		1. 기존 테이블 -> 탈퇴한 회원 테이블 정보 Copy
		//		2. 2. 기존 테이블에서 삭제

		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		MemberDAO dao = new MemberDAO();
		int result1 = dao.memberToDelete(conn,m);
		int result2 = dao.deleteMember(conn,m);
		if(result1>0 && result2>0)
		{
			JDBCTemplate.commit(conn);
			result = 1;
		}
		else
		{
			JDBCTemplate.rollback(conn);
			result = -1;
		}	
		JDBCTemplate.close(conn);
		return result;
	}
}
