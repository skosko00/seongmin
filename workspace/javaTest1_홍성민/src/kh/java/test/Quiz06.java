package kh.java.test;

import java.util.Scanner;

public class Quiz06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է�(1~5) : ");
		int select = sc.nextInt();
		if(0<select && select<6)
		{
			switch(select)
			{
			case 1:
				System.out.println("**�Է��� ���������� �Ǿ����ϴ�! **");
				break;
			case 2:
				System.out.println("**��ȸ�� ���۵Ǿ����ϴ�! **");
				break;
			case 3:
				System.out.println("**������ ���������� �Ǿ����ϴ�! **");
				break;
			case 4:
				System.out.println("**������ ���������� �Ǿ����ϴ�! **");
				break;
			default:
				System.out.println("**���������� ���� �Ǿ����ϴ�! **");
				break;
			}
		}
		else
		{
			System.out.println("** �ٽ� �Է��� �ּ���! **");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
