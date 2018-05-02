package kh.java.controller;

import java.util.Scanner;

public class Cal implements Calculator{

	@Override
	public int add(String su1, String su2) {
		return Integer.parseInt(su1)+Integer.parseInt(su2);
	}

	@Override
	public int subtract(String su1, String su2) {
		return Integer.parseInt(su1)-Integer.parseInt(su2);
	}

	@Override
	public int multiply(String su1, String su2) {
		return Integer.parseInt(su1)*Integer.parseInt(su2);
	}

	@Override
	public double divide(String su1, String su2) {
		return Integer.parseInt(su1)/Double.parseDouble(su2);
	}

	@Override
	public void start() {
		String su1, su2;
		Scanner sc = new Scanner(System.in);
		System.out.print("연산자 입력 (+,-,*,/) : ");
		char oper = sc.next().charAt(0);
		System.out.print("첫번째 숫자 입력 : ");
		su1 = sc.next();
		System.out.print("두번째 숫자 입력 : ");
		su2 = sc.next();
		switch(oper)
		{
		case '+':
			System.out.printf("%s + %s = %d", su1, su2, add(su1,su2));
			break;
		case '-':
			System.out.printf("%s - %s = %d", su1, su2, subtract(su1,su2));
			break;
		case '*':
			System.out.printf("%s * %s = %d", su1, su2, multiply(su1,su2));
			break;
		case '/':
			System.out.printf("%s / %s = %.1f", su1, su2, divide(su1,su2));
			break;
		}

	}

}
