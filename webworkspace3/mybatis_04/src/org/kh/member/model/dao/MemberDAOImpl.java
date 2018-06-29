package org.kh.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.Check;
import org.kh.member.model.vo.Member;
import org.kh.member.model.vo.SearchRadio;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public Member loginMember(SqlSession session, Member m) {
		m = session.selectOne("member.loginMember", m);
		return m;
	}

	@Override
	public int updateMember(SqlSession session, Member m) {
		int result = session.update("member.updateMember",m);
		return result;
	}

	@Override
	public int deleteMember(SqlSession session, Member m) {
		int result = session.delete("member.deleteMember",m);
		return result;
	}

	@Override
	public ArrayList<Member> allMember(SqlSession session) {
		List list = session.selectList("member.allMember");
		return (ArrayList<Member>)list;
	}

	@Override
	public ArrayList<Member> radioSearch(SqlSession session, SearchRadio sr) {
		List list = session.selectList("member.radioSearch",sr);
		return (ArrayList<Member>)list;
	}

	@Override
	public ArrayList<Member> checkBox1(SqlSession session, Check check) {
		List list = session.selectList("member.checkBox1",check);
		return (ArrayList<Member>)list;
	}

	@Override
	public ArrayList<Member> checkBox2(SqlSession session, String[] addr) {
		List list = session.selectList("member.checkBox2",addr);
		return (ArrayList<Member>)list;
	}

	@Override
	public int enrollMember(SqlSession session, Member m) {
		int result = session.insert("member.enrollMember",m);
		return result;
	}
	
}
