package org.kh.users.model.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.kh.users.model.dao.UsersDAOImpl;
import org.kh.users.model.vo.Users;

public class UserServiceImpl implements UserService{
	public SqlSession getSqlSession() {
		String resource = "/mybatis-config.xml";
		SqlSession session = null;
		
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(is);
			session = factory.openSession(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}

	@Override
	public int insertUser(Users users) {
		SqlSession session = getSqlSession();
		int result = new UsersDAOImpl().insertUser(session, users);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}

	@Override
	public Users idCheck(String userId) {
		SqlSession session = getSqlSession();
		Users user = new UsersDAOImpl().idCheck(session, userId);
		return user;
	}

	@Override
	public Users oneUserSelect(Users users) {
		SqlSession session = getSqlSession();
		Users user = new UsersDAOImpl().oneUserSelect(session, users);
		return user;
	}

	@Override
	public ArrayList<Users> allUser() {
		SqlSession session = getSqlSession();
		ArrayList<Users> list =  new UsersDAOImpl().allUser(session);
		return list;
	}

	@Override
	public int deleteUser(Users users) {
		SqlSession session = getSqlSession();
		int result = new UsersDAOImpl().deleteUser(session, users);
		if(result>0)
		{
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}

	@Override
	public int updateUser(Users users) {
		SqlSession session = getSqlSession();
		int result = new UsersDAOImpl().updateUser(session, users);
		if(result>0)
		{
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}

}
