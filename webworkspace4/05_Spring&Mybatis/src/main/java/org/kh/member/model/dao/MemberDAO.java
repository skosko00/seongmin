package org.kh.member.model.dao;

import org.kh.member.model.vo.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

public interface MemberDAO {
	public Member selectOneMember(SqlSessionTemplate sqlSession, Member vo);
	public int updateMember(SqlSessionTemplate sqlSession, Member vo);
}
