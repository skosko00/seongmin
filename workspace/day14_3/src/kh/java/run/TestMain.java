package kh.java.run;

import kh.java.controller.StuMgr;
import kh.java.model.vo.Student;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StuMgr m = new StuMgr();
		m.insertStudent(new Student("È«±æµ¿", 20, "°æ±âµµ"));
		m.insertStudent(new Student("±è¸»¶Ë", 30, "ÃæÃ»µµ"));
		m.insertStudent(new Student("°í±æµ¿", 99, "¼­¿ï½Ã"));
		m.viewAllStudent();
		m.deleteStudent("±è¸»¶Ë");
		m.viewAllStudent();

	}

}
