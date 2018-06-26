package org.kh.student.model.service;

import org.kh.student.model.vo.Student;

public interface StudentService {
	public Student selectStudent(); // 1명의 정보를 리턴하는 추상 메소드
	public int insertStudent(); // 1명의 정보를 입력(insert)하는 추상 메소드
}
