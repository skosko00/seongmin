package com.kh.test;
import java.util.*;

public class TestMain1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		System.out.print("�̸��� �������� : ");
		String name = sc.nextLine();
		System.out.print("���̸� �������� : ");
		int age = sc.nextInt();
		System.out.print("�ּҸ� �������� : ");
		sc.nextLine();
		String addr = sc.nextLine();
		System.out.print("Ű�� �������� : ");
		double key = sc.nextDouble();
		System.out.print("�����Ը� �������� : ");
		double wei = sc.nextDouble();
		System.out.println("������ �������� : ");
		sc.nextLine();
		char sex = sc.next().charAt(0);
		
		System.out.println("--------���--------");
		System.out.println("����� �̸��� " + name + " �̱���");
		System.out.println("����� ���̴� " + age + "�� �̱���");
		System.out.println("����� �ּҴ� " + addr + " �̱���");
		System.out.println("����� Ű��" + key + "cm �̱���");
		System.out.println("����� �����Դ� " + wei + "kg �̱���");
		System.out.println("����� ������ " + sex + " �̱���");
	}

}