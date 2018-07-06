package org.kh.member.model.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.kh.member.common.Log4jAdvice;
import org.kh.member.model.dao.MemberDAOImpl;
import org.kh.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Resource(name="memberDAO")
	private MemberDAOImpl memberDAO;
	
	@Autowired
	private JdbcTemplate jdbcTeamplate;
	
	
	@Override
	public Member selectOneMember(Member vo) {
		System.out.println("비즈니스 로직 호출");
		Member m = memberDAO.selectOneMember(jdbcTeamplate, vo);
		return m;
	}

	@Override
	public int updateMember(Member vo) {
		System.out.println("비즈니스 로직 호출");
		int result = memberDAO.updateMember(jdbcTeamplate, vo);
		return result;
	}
	
	
	public int insertMember(Member vo) {
		System.out.println("비즈니스 로직 호출");
		int result = memberDAO.insertMember(jdbcTeamplate, vo);
		return result;
	}

	
	public int deleteMember(Member vo) {
		System.out.println("비즈니스 로직 호출");
		int result = memberDAO.deleteMember(jdbcTeamplate, vo);
		return result;
	}

	
	public ArrayList<Member> allMember() {
		System.out.println("비즈니스 로직 호출");
		ArrayList<Member> list = memberDAO.allMember(jdbcTeamplate);
		return list;
	}
}
