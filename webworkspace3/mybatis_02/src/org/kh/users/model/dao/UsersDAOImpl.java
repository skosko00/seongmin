package org.kh.users.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.users.model.vo.Users;

public class UsersDAOImpl implements UsersDAO{

	@Override
	public int insertUser(SqlSession session, Users users) {
		int result = session.insert("users.inserUsers",users);
		return result;
	}

	@Override
	public Users idCheck(SqlSession session, String userId) {
		Users user = null;
		user = session.selectOne("users.idCheck",userId);
		return user;
	}

	@Override
	public Users oneUserSelect(SqlSession session, Users users) {
		Users result = null;
		result = session.selectOne("users.oneUserSelect",users);
		return result;
	}

	@Override
	public ArrayList<Users> allUser(SqlSession session) {
		List list = session.selectList("users.allUser");
		return (ArrayList<Users>) list;
	}

	@Override
	public int deleteUser(SqlSession session, Users users) {
		int result = session.delete("users.deleteUser", users);
		return result;
	}

	@Override
	public int updateUser(SqlSession session, Users users) {
		int result = session.update("users.updateUser", users);
		return result;
	}

}
