package org.kh.users.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.common.SqlSessionTemplate;
import org.kh.users.model.dao.UsersDAO;
import org.kh.users.model.vo.Check;
import org.kh.users.model.vo.Search;
import org.kh.users.model.vo.User;

public class UsersService {

	public ArrayList<User> checkUserList(Check check) {
		SqlSession session = SqlSessionTemplate.getSession();
		ArrayList<User> list = new UsersDAO().checkUserList(session, check);
		return list;
	}

	public ArrayList<User> searchUserList(Search search) {
		SqlSession session = SqlSessionTemplate.getSession();
		ArrayList<User> list = new UsersDAO().searchUserList(session, search);
		return list;
	}

	public ArrayList<User> search2UserList(User user) {
		SqlSession session = SqlSessionTemplate.getSession();
		ArrayList<User> list = new UsersDAO().search2UserList(session, user);
		return list;
	}

	public ArrayList<User> search3UserList(String[] addr) {
		SqlSession session = SqlSessionTemplate.getSession();
		ArrayList<User> list = new UsersDAO().search3UserList(session, addr);
		return list;
	}
	
}
