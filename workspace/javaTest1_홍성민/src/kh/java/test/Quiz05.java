package kh.java.test;

import java.util.Scanner;

public class Quiz05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��°�� : ");
		int num1 = sc.nextInt();
		System.out.print("�ι�°�� : ");
		int num2 = sc.nextInt();
		if(0<num1 && num1<10 && 0<num2 && num2<10)
		{
			if(9<num1*num2)
			{
				System.out.println("���ڸ� �� �Դϴ�.");
			}
			else
			{
				System.out.println("���ڸ� �� �Դϴ�.");
			}
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
