package com.kh.info;
import java.util.*;

public class TestInfo {

	public void student() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생의 이름 입력 : ");
		String name = sc.nextLine();
		
		System.out.print("학생의 나이 입력 : ");
		int age = sc.nextInt();
		
		System.out.print("학생의 국어점수 입력 : ");
		int kor = sc.nextInt();
		
		System.out.print("학생의 영어점수 입력 : ");
		int eng = sc.nextInt();
		
		System.out.print("학생의 수학점수 입력 : ");
		int math = sc.nextInt();
		
//		double avg = (kor + eng + math) / 3;
		System.out.println("---출력 결과---");
		
		System.out.println(name + "!! 당신은 " + age + "살이군요");
		System.out.println("국어점수는 " + kor + "점");
		System.out.println("국어점수는 " + eng + "점");
		System.out.println("국어점수는 " + math + "점");
		System.out.println("평균점수는 " + (kor + eng + math) / 3.0 + "점");
	}
}