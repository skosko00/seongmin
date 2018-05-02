package com.kh.java;
import java.util.*;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수 입력 : ");
		int kor = sc.nextInt();
		System.out.print("영어점수 입력 : ");
		int eng = sc.nextInt();
		System.out.print("수학점수 입력 : ");
		int math = sc.nextInt();
		System.out.print("등급 입력 : ");
		char grade = sc.next().charAt(0);  //문자열을 입력 받아서 변수 grade에 0번째 인덱스만 저장
		int sum = kor + eng + math;
		
		System.out.println("-------------------------출력-------------------------");
		System.out.printf("당신의 성적은 총합 %d점이고 평균은 %.1f점 이군요\n"
				+ "당신의 등급은 %c 등급 입니다.",sum,sum/3.0,grade);  //%d에는 sum의 값이 출력되고 %.1f에는 소수점 첫째자리까지의 sum/3.0 결과값이 출력 되고 %c에는 grade의 값이 출력 된다.

	}

}
