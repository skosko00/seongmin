package com.exception.number;

public class TestMain {

	public static void main(String[] args) {

		Student s1 = new Student("ȫ�浿",20,"��⵵");
		Student s2 = null;
		try {
			s2 = (Student) s1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		s1.setAge(999);
		
		System.out.println(s2);
		
		
	}
}