package org.kh.users.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.users.model.vo.Check;
import org.kh.users.model.vo.Search;
import org.kh.users.model.vo.User;

public class UsersDAO {

	public ArrayList<User> checkUserList(SqlSession session, Check check) {
		List list = session.selectList("users.checkList",check); 
		return (ArrayList<User>) list;
	}

	public ArrayList<User> searchUserList(SqlSession session, Search search) {
		List list = session.selectList("users.searchList",search); 
		return (ArrayList<User>) list;
	}

	public ArrayList<User> search2UserList(SqlSession session, User user) {
		List list = session.selectList("users.search2List",user); 
		return (ArrayList<User>) list;
	}

	public ArrayList<User> search3UserList(SqlSession session, String[] addr) {
		List list = session.selectList("users.search3List",addr); 
		return (ArrayList<User>) list;
	}

}
