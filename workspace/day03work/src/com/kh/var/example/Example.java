package com.kh.var.example;
import java.util.*;

public class Example {
	
	Scanner sc = new Scanner(System.in);
	
	public void example1() {
		
		System.out.print("첫번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 : ");
		int num2 = sc.nextInt();
		
		System.out.println("-------------------------출력-------------------------");
		System.out.println("더하기 결과 : " + (num1 + num2));
		System.out.println("빼기 결과 : " + (num1 + num2));
		System.out.println("곱하기 결과 : " + (num1 * num2));
		System.out.println("나누기 한 몫 : " + (num1 / num2));
		System.out.println("나누기한 나머지 : " + (num1 % num2));
	}
	
	public void example2() {

		
		System.out.print("사각형의 가로를 입력하세요 : ");
		double width = sc.nextDouble();
		System.out.print("사각형의 세로를 입력하세요 : ");
		double length = sc.nextDouble();
		
		System.out.println("-------------------------출력-------------------------");
		System.out.println("사각형의 면적" + (width * length));
		System.out.println("사각형의 둘레" + ((width + length)*2));
		
		sc.nextLine();
	}
	
	public void example3() {
		System.out.print("문자열을 입력하시오 : ");
		String str = sc.next();
		System.out.println("첫번째 문자 : " + str.charAt(0));  //str에 저장된 문자열에 0번째 인덱스 값만 출력
		System.out.println("두번째 문자 : " + str.charAt(1));  //str에 저장된 문자열에 1번째 인덱스 값만 출력
		System.out.println("세번째 문자 : " + str.charAt(2));  //str에 저장된 문자열에 2번째 인덱스 값만 출력
	}
	
	public void example4() {
		System.out.print("문자열을 입력하시오 : ");
		String str = sc.nextLine();
		System.out.println("첫번째 문자 : " + str.charAt(0));  //str에 저장된 문자열에 0번째 인덱스 값만 출력
		System.out.println("두번째 문자 : " + str.charAt(1));  //str에 저장된 문자열에 1번째 인덱스 값만 출력
		System.out.println("세번째 문자 : " + str.charAt(2));  //str에 저장된 문자열에 2번째 인덱스 값만 출력
	}
}