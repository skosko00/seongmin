package com.kh.java;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.nextLine();
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt();
		System.out.print("�ּҸ� �Է��ϼ��� : ");
		sc.nextLine();  //���� �ʱ�ȭ
		String addr = sc.nextLine();
		System.out.print("Ű�� �Է��ϼ��� : ");
		double key = sc.nextDouble();
		System.out.print("�����Ը� �Է��ϼ��� : ");
		double wei = sc.nextDouble();
		System.out.printf("������ �Է��ϼ��� : ");
		char sex = sc.next().charAt(0);  //���ڿ��� �Է� �ް� ���� sex 0��° �ε����� ����
		
		System.out.println("----------------------���----------------------");
		System.out.printf("�̸� : %s \n", name);  //%s�� name�� ���� ��
		System.out.printf("���� : %d \n", age);  //%d�� age�� ���� ��
		System.out.printf("�ּ� : %s \n", addr);  //%s�� addr�� ���� ��
		System.out.printf("Ű : %d \n", (int)key);  //double������ ����� key�� ���� int�� ���� ������ �Ŀ� %d�� key�� ���� ��
		System.out.printf("������ : %.1f \n", wei);  //%.1f(�Ҽ��� ù°�ڸ����� ���)�� wei�� ���� ��
		System.out.printf("���� : %c \n", sex);  //%c�� sex�� ���� ��

	}

}
