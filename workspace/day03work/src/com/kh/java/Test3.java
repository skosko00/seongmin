package com.kh.java;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[����]�����Է� : ");
		int kor = sc.nextInt();
		System.out.print("[����]�����Է� : ");
		int math = sc.nextInt();
		System.out.print("[����]�����Է� : ");
		int eng = sc.nextInt();
		
		System.out.println("-------------------------���-------------------------");
		System.out.printf("%10s %10s %10s %10s %10s \n", "����", "����", "����", "�հ�", "���");  //%10s �������κ��� 10ĭ�� �������� �� ���Ŀ� ���� ��� 
		System.out.printf("%5d %5d %5d %5d %5.1f \n", kor, math, eng, kor+math+eng, (kor+math+eng)/3.0);  //%5s �������κ��� 5ĭ�� �������� �� ���Ŀ� ���� ���,
																								//%5.1f �������κ��� 5ĭ�� �������� �� ���Ŀ� �Ҽ��� ù°�ڸ����� ���
		

	}

}
