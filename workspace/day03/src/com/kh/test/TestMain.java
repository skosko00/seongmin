package com.kh.test;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int age = sc.nextInt();
		System.out.print("�ּ� �Է� : ");
		sc.nextLine();
		String addr = sc.nextLine();
		
		
		System.out.println("���� : " + age);
		System.out.println("�ּ� : " + addr);
	}

}