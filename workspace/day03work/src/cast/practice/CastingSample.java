package cast.practice;

import java.util.Scanner;

public class CastingSample {
	
	Scanner sc = new Scanner(System.in);
	
	public void printUniCode() {
	System.out.print("���� �Է� : ");
	char ch = sc.next().charAt(0);	//���ڿ��� �Է� �޾� 0��° �ε����� ���� ���� ch�� ����
	System.out.println(ch + " is ASCII : " + (byte)ch);	 //ch�� ����� ���ڸ� byte�� ���� ����ȯ �Ŀ� ���
	}

	public void calculatorScore() {
		System.out.print("���� : ");
		double kor = sc.nextDouble();
		System.out.print("���� : ");
		double eng = sc.nextDouble();
		System.out.print("���� : ");
		double math = sc.nextDouble();
		
		System.out.println("-------------------------���-------------------------");
		System.out.println("���� : " + (int)(kor+eng+math));  //���� kor, eng, math�� �� �����Ŀ� int������ ���� ����ȯ �� ���
		System.out.println("��� : " + (kor+eng+math)/3);  //���� kor, eng, math�� �� �����Ŀ� 3���� ���� �Ŀ� ���
	}
	
	public void printBitCount() {
		System.out.print("���� �Է� : ");
		int a = sc.nextInt();  //int a�� ������ �Է� ����
		
		System.out.println(a + "�� 2������ ���Ե� 1�� ���� : " + Integer.bitCount(a));
		//java.lang.Integer Ŭ������ �ִ� bitCount �޼ҵ��� ���� a�� ���� ���� �� �Ŀ� ���ϵ� ���� ���
		//java.lang ��Ű���� java�� �⺻ ��Ű��
	}
}