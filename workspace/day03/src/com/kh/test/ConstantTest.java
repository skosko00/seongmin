package com.kh.test;
import java.util.*;

public class ConstantTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 수 입력 : ");
		int firstNum = sc.nextInt();
		System.out.print("두번째 수 입력 : ");
		int secondNum = sc.nextInt();
		
		System.out.println("------------출력------------");
		
		System.out.println("더한 수 : " + (firstNum + secondNum));
		System.out.println("뺀    수 : " + (firstNum - secondNum));
		System.out.println("곱한 수 : " + (firstNum * secondNum));
		System.out.println("나눈 수 : " + ((double)firstNum) / secondNum);

	}

}