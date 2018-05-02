package kh.java.Exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ExceptionTest {
	Scanner sc = new Scanner(System.in);
	
	public void menuPrint()
	{
		System.out.println("--------- 메뉴 선택 -----------");
		System.out.println("1. 반갑습니다. 출력");
		System.out.println("2. 잘지내세요. 출력");
		System.out.println("3. 또 만나요 출력");
		System.out.print("입력 : ");
	}
	public void ExceptionDemo1_Print(int choice)
	{
		
		switch(choice)
		{
		case 1: System.out.println("반갑습니다"); break; 
		case 2: System.out.println("잘지내세요"); break;
		case 3: System.out.println("또 만나요"); break;
		default : System.out.println("1~3 에서 선택해주세요");
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
			throw new NoZeroException("0으로는 나눌 수 없습니다.");
		}
		System.out.println(a+b);
	}
}
