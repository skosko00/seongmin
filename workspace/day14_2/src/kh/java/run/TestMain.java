package kh.java.run;

import kh.java.controller.StuMgr;
import kh.java.model.vo.Student;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StuMgr m = new StuMgr();
		m.insertStudent(new Student("ȫ�浿", 20, "��⵵"));
		m.insertStudent(new Student("�踻��", 30, "��û��"));
		m.insertStudent(new Student("��浿", 99, "�����"));
		m.viewAllStudent();

	}

}
