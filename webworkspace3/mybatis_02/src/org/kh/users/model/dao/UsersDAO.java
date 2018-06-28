package org.kh.users.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.users.model.vo.Users;

public interface UsersDAO {
	public int insertUser(SqlSession session, Users users);
	public Users idCheck(SqlSession session, String userId);
	public Users oneUserSelect(SqlSession session, Users users);
	public ArrayList<Users> allUser(SqlSession session);
	public int deleteUser(SqlSession session, Users users);
	public int updateUser(SqlSession session, Users users);
}
