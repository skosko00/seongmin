package org.kh.member.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.kh.member.model.vo.Member;
import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rset, int rowNum) throws SQLException {
		Member m = new Member();
		m.setUserId(rset.getString("user_id"));
		m.setUserPw(rset.getString("user_pw"));
		m.setUserName(rset.getString("user_name"));
		m.setUserPhone(rset.getString("user_phone"));
		return m;
	}
	
}
