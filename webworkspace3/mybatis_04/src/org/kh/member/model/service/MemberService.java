package org.kh.member.model.service;

import java.util.ArrayList;

import org.kh.member.model.vo.Check;
import org.kh.member.model.vo.Member;
import org.kh.member.model.vo.SearchRadio;

public interface MemberService {
	public Member loginMember(Member m);
	public int updateMember(Member m);
	public int deleteMember(Member m);
	public ArrayList<Member> allMember();
	public ArrayList<Member> radioSearch(SearchRadio sr);
	public ArrayList<Member> checkBox1(Check check);
	public ArrayList<Member> checkBox2(String[] addr);
	public int enrollMember(Member m);
}
