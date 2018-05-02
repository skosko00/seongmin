package kh.java.Exception;

import java.util.Scanner;

public class ExceptionDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자 입력 : ");
		int su1 = sc.nextInt();
		System.out.print("두번째 숫자 입력 : ");
		int su2 = sc.nextInt();
		try {
		System.out.println("결과 : " + (su1/su2));
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("0으로 나눌 수 없습니다.");
			System.out.println("에러메시지 : "+e.getMessage());
			e.printStackTrace();
		}
		System.out.println("수고하셨습니다.");
	}

}
