package org.kh.student.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.kh.student.model.vo.Student;

public interface StudentDAO {
	public Student selectStudent();
	public int insertStudent(SqlSession session);
}
