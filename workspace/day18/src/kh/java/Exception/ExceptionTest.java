package kh.java.Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	Scanner sc = new Scanner(System.in);
	
	public void menuPrint()
	{
		System.out.println("--------- �޴� ���� -----------");
		System.out.println("1. �ݰ����ϴ�. ���");
		System.out.println("2. ����������. ���");
		System.out.println("3. �� ������ ���");
		System.out.print("�Է� : ");
	}
	public void ExceptionDemo1_Print(int choice)
	{
		
		switch(choice)
		{
		case 1: System.out.println("�ݰ����ϴ�"); break; 
		case 2: System.out.println("����������"); break;
		case 3: System.out.println("�� ������"); break;
		default : System.out.println("1~3 ���� �������ּ���");
		}
		
		
	}
	public void start()
	{
		int choice = 0;
		this.menuPrint();
		try
		{
		choice = sc.nextInt();
		ExceptionDemo1_Print(choice);
		}catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("���ڸ� �Է����ּ���");
		}
	}
}
