package org.kh.student.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.kh.student.model.vo.Student;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public Student selectStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertStudent(SqlSession session) {
		int result = session.insert("student.test1");
		return result;
	}

	public int insertStudent(SqlSession session, String studentName) {
		int result = session.insert("student.test2",studentName);
		return result;
	}

	public int insertStudent(SqlSession session, Student vo) {
		int result = session.insert("student.test3",vo);
		return result;
	}

}
