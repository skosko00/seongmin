package kh.java.Exception;

import java.util.Scanner;

public class ExceptionDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� �Է� : ");
		int su1 = sc.nextInt();
		System.out.print("�ι�° ���� �Է� : ");
		int su2 = sc.nextInt();
		try {
		System.out.println("��� : " + (su1/su2));
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("0���� ���� �� �����ϴ�.");
			System.out.println("�����޽��� : "+e.getMessage());
			e.printStackTrace();
		}
		System.out.println("�����ϼ̽��ϴ�.");
	}

}
