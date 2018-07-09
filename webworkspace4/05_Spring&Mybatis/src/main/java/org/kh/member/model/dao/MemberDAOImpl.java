package org.kh.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{

	@Override
	public Member selectOneMember(SqlSessionTemplate sqlSession, Member vo) {
		return sqlSession.selectOne("member.selectOneMember", vo);
	}

	@Override
	public int updateMember(SqlSessionTemplate sqlSession, Member vo) {
		return sqlSession.update("member.updateMember", vo);
	}

	public int insertMember(SqlSessionTemplate sqlSession, Member vo) {
		return sqlSession.insert("member.insertMember", vo);
	}

	public int deleteMember(SqlSessionTemplate sqlSession, Member vo) {
		return sqlSession.delete("member.deleteMember", vo);
	}

	public ArrayList<Member> allMember(SqlSessionTemplate sqlSession) {
		List list = sqlSession.selectList("member.allMember");
			return (ArrayList<Member>)list;
	}

}
