package com.kh.java;
import java.util.*;

public class calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in); //Scanner 클래스를 변수 sc로 치환
		System.out.print("첫번째 수 입력 : ");  //출력
		int num1 = sc.nextInt();  //int num1 의 정수를 입력 받는다
		System.out.print("두번째 수 입력 : ");  //출력
		int num2 = sc.nextInt();  //int num2 의 정수를 입력 받는다
		
		System.out.println("-------------------------출력-------------------------");
		System.out.printf("두수를 더한수 : %d \n", num1+num2); //출력
		System.out.printf("두수를 뺀   수 : %d \n", num1-num2); //출력
		System.out.printf("두수를 곱한수 : %d \n", num1*num2); //출력
		System.out.printf("두수를 나눈수 : %.2f \n", (double)num1/num2); //num1/num2를 하여 나온 값을 double로 강제형변환 시켜서 소수점 2째 자리까지 표현한다.

	}

}
