package com.kh.java;
import java.util.*;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�������� �Է� : ");
		int kor = sc.nextInt();
		System.out.print("�������� �Է� : ");
		int eng = sc.nextInt();
		System.out.print("�������� �Է� : ");
		int math = sc.nextInt();
		System.out.print("��� �Է� : ");
		char grade = sc.next().charAt(0);  //���ڿ��� �Է� �޾Ƽ� ���� grade�� 0��° �ε����� ����
		int sum = kor + eng + math;
		
		System.out.println("-------------------------���-------------------------");
		System.out.printf("����� ������ ���� %d���̰� ����� %.1f�� �̱���\n"
				+ "����� ����� %c ��� �Դϴ�.",sum,sum/3.0,grade);  //%d���� sum�� ���� ��µǰ� %.1f���� �Ҽ��� ù°�ڸ������� sum/3.0 ������� ��� �ǰ� %c���� grade�� ���� ��� �ȴ�.

	}

}
