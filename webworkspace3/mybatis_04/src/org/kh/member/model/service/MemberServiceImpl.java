package org.kh.member.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.common.SqlSessionTemplate;
import org.kh.member.model.dao.MemberDAOImpl;
import org.kh.member.model.vo.Check;
import org.kh.member.model.vo.Member;
import org.kh.member.model.vo.SearchRadio;

public class MemberServiceImpl implements MemberService{

	@Override
	public Member loginMember(Member m) {
		SqlSession session = SqlSessionTemplate.getSession();
		m = new MemberDAOImpl().loginMember(session, m);
		return m;
	}

	@Override
	public int updateMember(Member m) {
		SqlSession session = SqlSessionTemplate.getSession();
		int result = new MemberDAOImpl().updateMember(session, m);
		if(result>0)
		{
			session.commit();
		} else {
			session.rollback();
		}
		return result;
	}

	@Override
	public int deleteMember(Member m) {
		SqlSession session = SqlSessionTemplate.getSession();
		int result = new MemberDAOImpl().deleteMember(session, m);
		if(result>0)
		{
			session.commit();
		} else {
			session.rollback();
		}
		return result;
	}

	@Override
	public ArrayList<Member> allMember() {
		SqlSession session = SqlSessionTemplate.getSession();
		ArrayList<Member> list = new MemberDAOImpl().allMember(session);
		return list;
	}

	@Override
	public ArrayList<Member> radioSearch(SearchRadio sr) {
		SqlSession session = SqlSessionTemplate.getSession();
		ArrayList<Member> list = new MemberDAOImpl().radioSearch(session, sr);
		return list;
	}

	@Override
	public ArrayList<Member> checkBox1(Check check) {
		SqlSession session = SqlSessionTemplate.getSession();
		ArrayList<Member> list = new MemberDAOImpl().checkBox1(session, check);
		return list;
	}

	@Override
	public ArrayList<Member> checkBox2(String[] addr) {
		SqlSession session = SqlSessionTemplate.getSession();
		ArrayList<Member> list = new MemberDAOImpl().checkBox2(session, addr);
		return list;
	}

	@Override
	public int enrollMember(Member m) {
		SqlSession session = SqlSessionTemplate.getSession();
		int result = new MemberDAOImpl().enrollMember(session, m);
		if(result>0)
		{
			session.commit();
		} else {
			session.rollback();
		}
		return result;
	}
}
