package com.kh.java;
import java.util.*;

public class calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in); //Scanner Ŭ������ ���� sc�� ġȯ
		System.out.print("ù��° �� �Է� : ");  //���
		int num1 = sc.nextInt();  //int num1 �� ������ �Է� �޴´�
		System.out.print("�ι�° �� �Է� : ");  //���
		int num2 = sc.nextInt();  //int num2 �� ������ �Է� �޴´�
		
		System.out.println("-------------------------���-------------------------");
		System.out.printf("�μ��� ���Ѽ� : %d \n", num1+num2); //���
		System.out.printf("�μ��� ��   �� : %d \n", num1-num2); //���
		System.out.printf("�μ��� ���Ѽ� : %d \n", num1*num2); //���
		System.out.printf("�μ��� ������ : %.2f \n", (double)num1/num2); //num1/num2�� �Ͽ� ���� ���� double�� ��������ȯ ���Ѽ� �Ҽ��� 2° �ڸ����� ǥ���Ѵ�.

	}

}
