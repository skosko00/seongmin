package com.kh.info;
import java.util.*;

public class TestInfo {

	public void student() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�л��� �̸� �Է� : ");
		String name = sc.nextLine();
		
		System.out.print("�л��� ���� �Է� : ");
		int age = sc.nextInt();
		
		System.out.print("�л��� �������� �Է� : ");
		int kor = sc.nextInt();
		
		System.out.print("�л��� �������� �Է� : ");
		int eng = sc.nextInt();
		
		System.out.print("�л��� �������� �Է� : ");
		int math = sc.nextInt();
		
//		double avg = (kor + eng + math) / 3;
		System.out.println("---��� ���---");
		
		System.out.println(name + "!! ����� " + age + "���̱���");
		System.out.println("���������� " + kor + "��");
		System.out.println("���������� " + eng + "��");
		System.out.println("���������� " + math + "��");
		System.out.println("��������� " + (kor + eng + math) / 3.0 + "��");
	}
}