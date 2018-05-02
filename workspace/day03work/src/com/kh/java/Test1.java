package com.kh.java;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.print("주소를 입력하세요 : ");
		sc.nextLine();  //버퍼 초기화
		String addr = sc.nextLine();
		System.out.print("키를 입력하세요 : ");
		double key = sc.nextDouble();
		System.out.print("몸무게를 입력하세요 : ");
		double wei = sc.nextDouble();
		System.out.printf("성별을 입력하세요 : ");
		char sex = sc.next().charAt(0);  //문자열을 입력 받고 변수 sex 0번째 인덱스만 받음
		
		System.out.println("----------------------출력----------------------");
		System.out.printf("이름 : %s \n", name);  //%s에 name의 값이 들어감
		System.out.printf("나이 : %d \n", age);  //%d에 age의 값이 들어감
		System.out.printf("주소 : %s \n", addr);  //%s에 addr의 값이 들어감
		System.out.printf("키 : %d \n", (int)key);  //double형으로 저장된 key의 값을 int로 강제 형변한 후에 %d에 key의 값이 들어감
		System.out.printf("몸무게 : %.1f \n", wei);  //%.1f(소수점 첫째자리까지 출력)에 wei의 값이 들어감
		System.out.printf("성별 : %c \n", sex);  //%c에 sex의 값이 들어감

	}

}
