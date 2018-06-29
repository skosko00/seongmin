package org.kh.member.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.Check;
import org.kh.member.model.vo.Member;
import org.kh.member.model.vo.SearchRadio;

public interface MemberDAO {
	public Member loginMember(SqlSession session, Member m);
	public int updateMember(SqlSession session, Member m);
	public int deleteMember(SqlSession session, Member m);
	public ArrayList<Member> allMember(SqlSession session);
	public ArrayList<Member> radioSearch(SqlSession session, SearchRadio sr);
	public ArrayList<Member> checkBox1(SqlSession session, Check check);
	public ArrayList<Member> checkBox2(SqlSession session, String[] addr);
	public int enrollMember(SqlSession session, Member m);
}