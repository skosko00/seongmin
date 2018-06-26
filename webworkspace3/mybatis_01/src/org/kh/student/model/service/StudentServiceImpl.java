package org.kh.student.model.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.kh.student.model.dao.StudentDAOImpl;
import org.kh.student.model.vo.Student;

public class StudentServiceImpl implements StudentService{

	@Override
	public Student selectStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertStudent() {
		SqlSession session = getSqlSession();
		// getSqlSession메소드를 통해 SqlSession 값을 리턴
		
		int result = new StudentDAOImpl().insertStudent(session);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}

	public SqlSession getSqlSession() {	// 기존 getConnection과 같음
		// getSqlSession메소드의 역할은
		// DB에 연결할 JDBC 연결 코드를 통하여 연결하는 세션 정보를
		// 리턴해주는 역할
		
		// Mybatis에서 SqlSession을 만들기 위한 순서(SqlSession == Connection 객체)
		// 1. 드라이버 및 JDBC 연결 정보를 가지고 있는 xml 파일을 읽어 들여야 함(InputStream 생성)
		// 2. SqlSession을 만들려면 SqlSessionFactory 객체가 필요함
		// SqlSessionFactory 객체를 만들려면 SqlSessionFactoryBuilder 객체가 있어야 함
		// 즉, SqlSessionFactoryBuilder 객체 생성
		// 3. SqlSessionFactory 객체 생성
		// 4. SqlSession 리턴 (SqlSessionFactory에 의해 Session이 만들어지고 리턴하는 것임)
		
		String resource = "/mybatis-config.xml";
		SqlSession session = null;
		
		try {
			// 1. 드라이버 및 JDBC 연결 정보를 가지고 있는 xml 파일을 읽어 들여야 함(InputStream 생성)
			InputStream is = Resources.getResourceAsStream(resource);
			
			// 2. SqlSession을 만들려면 SqlSessionFactory 객체가 필요함
			// SqlSessionFactory 객체를 만들려면 SqlSessionFactoryBuilder 객체가 있어야 함
			// 즉, SqlSessionFactoryBuilder 객체 생성
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			
			// 3. SqlSessionFactory 객체 생성(InputStream을 사용하여 팩토리를 생성)
			SqlSessionFactory factory = builder.build(is);
			
			// 4. SqlSession 리턴 (SqlSessionFactory에 의해 Session이 만들어지고 리턴하는 것임)
			session = factory.openSession(false);
			// false값은 auto commit을 해제 (기본값은 true)
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}

	public int insertStudent(String studentName) {
		SqlSession session = getSqlSession();
		int result = new StudentDAOImpl().insertStudent(session,studentName);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}

	public int insertStudent(Student vo) {
		SqlSession session = getSqlSession();
		int result = new StudentDAOImpl().insertStudent(session,vo);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}
}
// JDBC 기본 코드
// 드라이버 등록
// 연결할 주소 등록 (url,ID,PW)

// Mybatis 또한 같음
// 하지만! 드라이버 등록 코드 및 연결할 주소 등록 코드를 xml 파일에
// 미리 등록하고 가져다 사용하는 원리

/*
* 맛보기 이므로
* 데이터를 입력받아서 넣는것이 아닌!
* 미리 쿼리 구문을 작성하고 처리되는지를 보도록 함
*/