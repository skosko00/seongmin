package com.kh.test;

import java.util.Scanner;

public class Print {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.print("[국어]점수입력 : ");
		int kor = sc.nextInt();
		System.out.print("[수학]점수입력 : ");
		int math = sc.nextInt();
		System.out.print("[영어]점수입력 : ");
		int eng = sc.nextInt();
		
		System.out.println("---------------------------출력---------------------------");
		
		System.out.printf("%s %10s %10s %10s %10s \n", "국어", "수학", "영어", "합계", "평균"); //왼쪽 10칸씩 띄운 후 정렬
		System.out.printf("%d %5d %6d %6d %6.1f \n",
			kor, math, eng, kor+math+eng, (kor+math+eng)/3.0); //왼쪽 0, 5, 6, 6, 6 칸씩 띄우고 소수점 첫째짜리 까지
	}
	public void word() {
//		String name = "원빈";
//		int age = 20;
//		
//		System.out.printf("당신의 이름은 %s이고 나이는 %d 이군요", name, age);
		
//		System.out.printf("%15d, %15d, %15d\n", 100, 100, 100);
//		System.out.printf("%-15d, %-15d, %-15d\n", 100, 100, 100);
//		System.out.printf("%.1f, %.2f, %.3f\n", 3.14, 3.14, 3.14);
//		System.out.printf("%15.2f\n", 3.14);
		
//		System.out.printf("a \n");
//		System.out.printf("\ta \n");
//		System.out.printf("\na \n");
//		System.out.printf("\'a \n");
//		System.out.printf("\"a \n");
		
//		String name1 = "홍길동";
//		String name2 = "김말똥";
//		
//		int age1 = 20;
//		int age2 = 30;
//		
//		String addr1 = "인천광역시 서구";
//		String addr2 = "서울특별시 관악구";
//		
//		System.out.printf("%5s %5s %5s \n", "이름", "나이", "주소");
//		System.out.printf("%5s %5d %5s \n", name1, age1, addr1);
//		System.out.printf("%5s %5d %5s \n", name2, age2, addr2);
	}

}