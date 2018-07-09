package org.kh.member.model.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.kh.member.model.dao.MemberDAOImpl;
import org.kh.member.model.vo.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Resource(name="memberDAO")
	private MemberDAOImpl memberDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public Member selectOneMember(Member vo) {
		System.out.println("비즈니스 로직 호출");
		Member m = memberDAO.selectOneMember(sqlSession, vo);
		return m;
	}

	public int updateMember(Member vo) {
		System.out.println("비즈니스 로직 호출");
		int result = memberDAO.updateMember(sqlSession, vo);
		return result;
	}
	
	
	public int insertMember(Member vo) {
		System.out.println("비즈니스 로직 호출");
		int result = memberDAO.insertMember(sqlSession, vo);
		return result;
	}
	

	public int deleteMember(Member vo) {
		System.out.println("비즈니스 로직 호출");
		int result = memberDAO.deleteMember(sqlSession, vo);
		return result;
	}

	
	public ArrayList<Member> allMember() {
		System.out.println("비즈니스 로직 호출");
		ArrayList<Member> list = memberDAO.allMember(sqlSession);
		return list;
	}
}
