package kh.java.run;

import kh.java.controller.StuMgr;
import kh.java.model.vo.Student;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StuMgr m = new StuMgr();
		m.insertStudent(new Student("홍길동", 20, "경기도"));
		m.insertStudent(new Student("김말똥", 30, "충청도"));
		m.insertStudent(new Student("고길동", 99, "서울시"));
		m.viewAllStudent();

	}

}
