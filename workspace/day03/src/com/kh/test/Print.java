package com.kh.test;

import java.util.Scanner;

public class Print {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.print("[����]�����Է� : ");
		int kor = sc.nextInt();
		System.out.print("[����]�����Է� : ");
		int math = sc.nextInt();
		System.out.print("[����]�����Է� : ");
		int eng = sc.nextInt();
		
		System.out.println("---------------------------���---------------------------");
		
		System.out.printf("%s %10s %10s %10s %10s \n", "����", "����", "����", "�հ�", "���"); //���� 10ĭ�� ��� �� ����
		System.out.printf("%d %5d %6d %6d %6.1f \n",
			kor, math, eng, kor+math+eng, (kor+math+eng)/3.0); //���� 0, 5, 6, 6, 6 ĭ�� ���� �Ҽ��� ù°¥�� ����
	}
	public void word() {
//		String name = "����";
//		int age = 20;
//		
//		System.out.printf("����� �̸��� %s�̰� ���̴� %d �̱���", name, age);
		
//		System.out.printf("%15d, %15d, %15d\n", 100, 100, 100);
//		System.out.printf("%-15d, %-15d, %-15d\n", 100, 100, 100);
//		System.out.printf("%.1f, %.2f, %.3f\n", 3.14, 3.14, 3.14);
//		System.out.printf("%15.2f\n", 3.14);
		
//		System.out.printf("a \n");
//		System.out.printf("\ta \n");
//		System.out.printf("\na \n");
//		System.out.printf("\'a \n");
//		System.out.printf("\"a \n");
		
//		String name1 = "ȫ�浿";
//		String name2 = "�踻��";
//		
//		int age1 = 20;
//		int age2 = 30;
//		
//		String addr1 = "��õ������ ����";
//		String addr2 = "����Ư���� ���Ǳ�";
//		
//		System.out.printf("%5s %5s %5s \n", "�̸�", "����", "�ּ�");
//		System.out.printf("%5s %5d %5s \n", name1, age1, addr1);
//		System.out.printf("%5s %5d %5s \n", name2, age2, addr2);
	}

}