package com.kh.var.example;
import java.util.*;

public class Example {
	
	Scanner sc = new Scanner(System.in);
	
	public void example1() {
		
		System.out.print("ù��° ���� : ");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ���� : ");
		int num2 = sc.nextInt();
		
		System.out.println("-------------------------���-------------------------");
		System.out.println("���ϱ� ��� : " + (num1 + num2));
		System.out.println("���� ��� : " + (num1 + num2));
		System.out.println("���ϱ� ��� : " + (num1 * num2));
		System.out.println("������ �� �� : " + (num1 / num2));
		System.out.println("�������� ������ : " + (num1 % num2));
	}
	
	public void example2() {

		
		System.out.print("�簢���� ���θ� �Է��ϼ��� : ");
		double width = sc.nextDouble();
		System.out.print("�簢���� ���θ� �Է��ϼ��� : ");
		double length = sc.nextDouble();
		
		System.out.println("-------------------------���-------------------------");
		System.out.println("�簢���� ����" + (width * length));
		System.out.println("�簢���� �ѷ�" + ((width + length)*2));
		
		sc.nextLine();
	}
	
	public void example3() {
		System.out.print("���ڿ��� �Է��Ͻÿ� : ");
		String str = sc.next();
		System.out.println("ù��° ���� : " + str.charAt(0));  //str�� ����� ���ڿ��� 0��° �ε��� ���� ���
		System.out.println("�ι�° ���� : " + str.charAt(1));  //str�� ����� ���ڿ��� 1��° �ε��� ���� ���
		System.out.println("����° ���� : " + str.charAt(2));  //str�� ����� ���ڿ��� 2��° �ε��� ���� ���
	}
	
	public void example4() {
		System.out.print("���ڿ��� �Է��Ͻÿ� : ");
		String str = sc.nextLine();
		System.out.println("ù��° ���� : " + str.charAt(0));  //str�� ����� ���ڿ��� 0��° �ε��� ���� ���
		System.out.println("�ι�° ���� : " + str.charAt(1));  //str�� ����� ���ڿ��� 1��° �ε��� ���� ���
		System.out.println("����° ���� : " + str.charAt(2));  //str�� ����� ���ڿ��� 2��° �ε��� ���� ���
	}
}