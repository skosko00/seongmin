package org.kh.student.model.dao;

import java.util.ArrayList;
import java.util.List;

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

	public int updateStudent(SqlSession session, Student vo) {
		int result = session.update("student.test4",vo);
		return result;
	}

	public int deleteStudent(SqlSession session, int studentNo) {
		int result = session.delete("student.test5",studentNo);
		return result;
	}

	public Student selectOneStudent(SqlSession session, int studentNo) {
		Student std = session.selectOne("student.test6", studentNo);
		return std;
	}

	public ArrayList<Student> selectAllStudent(SqlSession session) {
		List list = session.selectList("student.test7");
		return (ArrayList<Student>)list;
	}

}
