package com.kh.java;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[국어]점수입력 : ");
		int kor = sc.nextInt();
		System.out.print("[수학]점수입력 : ");
		int math = sc.nextInt();
		System.out.print("[영어]점수입력 : ");
		int eng = sc.nextInt();
		
		System.out.println("-------------------------출력-------------------------");
		System.out.printf("%10s %10s %10s %10s %10s \n", "국어", "수학", "영어", "합계", "평균");  //%10s 왼쪽으로부터 10칸을 공백으로 한 이후에 글자 출력 
		System.out.printf("%5d %5d %5d %5d %5.1f \n", kor, math, eng, kor+math+eng, (kor+math+eng)/3.0);  //%5s 왼쪽으로부터 5칸을 공백으로 한 이후에 글자 출력,
																								//%5.1f 왼쪽으로부터 5칸을 공백으로 한 이후에 소수점 첫째자리까지 출력
		

	}

}
