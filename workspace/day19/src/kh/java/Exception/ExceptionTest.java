package kh.java.Exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
	public void start() throws FileNotFoundException
	{
		fileSearch();
	}
	public void fileSearch() throws FileNotFoundException
	{
		FileReader file1 = new FileReader("Test1.test");
		FileReader file2 = new FileReader("Test2.test");
		FileReader file3 = new FileReader("Test3.test");
	}
	
	public void sum(int a, int b) throws NoZeroException
	{
		if(a==0 || b==0)
		{
			throw new NoZeroException("0���δ� ���� �� �����ϴ�.");
		}
		System.out.println(a+b);
	}
}
